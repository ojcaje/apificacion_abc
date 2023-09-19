package com.example.apificacion_abc.services;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.example.apificacion_abc.utils.Noticia;

/**
 * Para traer la información de ABC
 */
public class AbcService {

	/**
	 * Obtener las noticias
	 * @param busqueda Las palabras claves
	 * @return El string con las noticias
	 * @throws Exception En caso de no cargarse la url
	 */
	public static String getFromABC(String busqueda) throws Exception {

		// abrir la url
		String url= "https://www.ultimahora.com/buscador?q=" + busqueda;
		StringBuilder html = new StringBuilder();
        BufferedReader readr = new BufferedReader(new InputStreamReader(new URL(url).openStream(), "UTF-8"));

		// extraer todo el html del reader
        String line;
        while ((line = readr.readLine()) != null) {
            html.append(line);
        }
        readr.close();

		// extraer sólo el ul con los resultados de búsqueda del html
		String resultado = StringUtils.substringBetween(html.toString(), "<ul class=\"SearchResultsModule-results\">", "</ul>");
		
		// devolver el resultado en caso de encontrarlo. Caso contrario devolver ""
		return (!Objects.isNull(resultado))?resultado.toString():"";
	}

	/**
	 * @return el JSON con las noticias
	 * @throws Exception
	 */
	public static ArrayList<Noticia> arrayNoticias(String busqueda) throws Exception{
		
		String resultadosBusqueda = getFromABC(busqueda);
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();

		// Se recorre cada elemento de este array, se hace map para crear una nueva Noticia de los resultados y
		// se guarda en un ArrayList para retornar como respuesta todas las noticias
		String[] arrayResultados = StringUtils.substringsBetween(resultadosBusqueda, "<li class=\"SearchResultsModule-results-item\">", "</li>");

		for(String noticia: arrayResultados){
			
			// extraer los datos
			String fecha = parseFecha(StringUtils.substringBetween(noticia, "<div class=\"PagePromo-date\">", "</div>"));
			String enlace = StringUtils.substringBetween(
				StringUtils.substringBetween(noticia, "<div class=\"PagePromo-title\">", "</div>"),
				"href=\"", "\""
			);
			String enlace_foto = StringUtils.substringBetween(
				StringUtils.substringBetween(noticia, "<picture>", "</picture>"),
				"srcset=\"", " "
			);
			String titulo = StringUtils.substringBetween(
				StringUtils.substringBetween(noticia, "<div class=\"PagePromo-title\">", "</div>"),
				">", "<"
			);
			String resumen = StringUtils.substringBetween(noticia, "<div class=\"PagePromo-description\">", "</div>").strip();
			
			// guardar en el ArrayList
			noticias.add(new Noticia(
				fecha,
				enlace,
				enlace_foto,
				titulo,
				resumen
			)
			);
		}

		return noticias;
	}

	/**
	 * Para parsear la fecha que viene del server
	 * @return
	 * @throws ParseException
	 */
	private static String parseFecha(String fecha) throws ParseException{

		// estas variables sirven para poder parsear la fecha que viene del server
		Map<Long, String> nombresFechas = Map.ofEntries(
			Map.entry(1L, "Enero"),
			Map.entry(2L, "Febrero"),
			Map.entry(3L, "Marzo"),
			Map.entry(4L, "Abril"),
			Map.entry(5L, "Mayo"),
			Map.entry(6L, "Junio"),
			Map.entry(7L, "Julio"),
			Map.entry(8L, "Agosto"),
			Map.entry(9L, "Septiembre"),
			Map.entry(10L, "Octubre"),
			Map.entry(11L, "Noviembre"),
			Map.entry(12L, "Diciembre"));
		Map<Long, String> amPM = Map.ofEntries(
			Map.entry(0L, "a. m."),
			Map.entry(1L, "p. m."));

		// Aquí formateamos la fecha del server
		DateTimeFormatter inputDateFormatter = new DateTimeFormatterBuilder()
        	.appendText(ChronoField.MONTH_OF_YEAR, nombresFechas)
        	.appendPattern(" dd, yyyy hh:mm ")
			.appendText(ChronoField.AMPM_OF_DAY, amPM)
			.toFormatter();
		LocalDateTime date = LocalDateTime.parse(fecha, inputDateFormatter);
		
		return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}
