package com.example.apificacion_abc.security;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.example.apificacion_abc.models.ApiKeyModel;
import com.example.apificacion_abc.repositories.ApiKeyRepository;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyRequestFilter extends GenericFilterBean {

	@Autowired
    private ApiKeyRepository apiKeyRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI();

        if(path.startsWith("/consulta") == false){
            chain.doFilter(request, response);
            return;
        }

        String key = req.getHeader("Key") == null ? "" : req.getHeader("Key");

        Optional<ApiKeyModel> apiKeyOptional = this.apiKeyRepository.findById(key);
        if(apiKeyOptional.isPresent()){
            chain.doFilter(request, response);
        }else{
			HttpServletResponse resp = (HttpServletResponse) response;
            String error = "{\"codigo\":\"g103\",\"error\":\"No Autorizado\"}";

            resp.reset();
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentLength(error.length());
			response.setContentType("application/json");
        	response.setCharacterEncoding("UTF-8");
            response.getWriter().write(error);
        }

    }

}