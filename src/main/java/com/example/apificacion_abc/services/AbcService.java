package com.example.apificacion_abc.services;

import java.io.*;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;

/**
 * Para traer la información de ABC
 */
public class AbcService {
	public static String getFromABC(String busqueda) throws Exception {

		String url= "https://www.ultimahora.com/buscador?q=" + busqueda;
		StringBuilder html = new StringBuilder();

        BufferedReader readr = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
  
        String line;
        while ((line = readr.readLine()) != null) {
            html.append(line);
        }
  
        readr.close();

		String resultado = StringUtils.substringBetween(html.toString(), "<ul class=\"SearchResultsModule-results\">", "</ul>");
		return resultado.toString();
	}
}
