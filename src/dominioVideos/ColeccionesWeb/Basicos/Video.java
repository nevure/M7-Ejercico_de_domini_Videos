/**
 * Ejercico de Dominio Videos M7
 * @author Rubén Rodríguez
 * IT Academy
 * Barcelona Activa
 *
 */

package dominioVideos.ColeccionesWeb.Basicos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import dominioVideos.ColeccionesWeb.ColeccionWeb;


/**
 * Clase Vídeo  que implementa ColeccionWeb.
 * 
 * 
 * 
 * 
 */

public class Video implements ColeccionWeb {
	
	private String url;
	private String titulo;
	private String autor;
	private List<String>  tags;
	
	
	
	public Video() 
	{
	
	} 
	
	/**
	 * Constructor que recibe todos los campos menos la lista de tags.
	 * @param url  URL del vídeo
	 * @param titulo  Título del vídeo. Campo clave
	 * @param autor Autor del vídeo
	 */
	public Video(String url, String titulo, String autor) {
		this.titulo = titulo;
		this.url = url;
		this.autor = autor;
		tags = new ArrayList<String>();

	}
		
	/**
	 * Constructor que recibe todos los campos menos-
	 * @param url  URL del vídeo
	 * @param titulo  Título del vídeo. Campo clave
	 * @param autor Autor del vídeo
	 * @param tags   Lista de tags del vídeo
	 */
	public Video(String url, String titulo, String autor, List<String> tags)
	{
		this.titulo = titulo;
		this.url = url;
		this.autor = autor;

		this.tags = new ArrayList<String>();
		this.tags = tags;
		
	}
	
	/**
	 * Sobreescribimos hashcode para adecuarlo al campo clave de nuestra clase.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	
	/**
	 * Sobreescribimos equals para adecuarlo al campo clave de nuestra clase.
	 * @return true si son iguales.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	/**
	 * Método de clase propio para buscar un elemento utilizando el campo que henos designado como campo clave. el título
	 * @param index   Cadena que vanos a buscar
	 * @return true si el título coincide con la cadena recibida.
	 */
	@Override
	public boolean buscarPorCampoClave(String index) {
		//System.out.println("this titulo es: "+this.titulo+" y el pasado es: "+)
		return (this.titulo.equals(index));
	}

	/*
	 * Getters y Setters
	 */
	
	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String getTitulo() {
		return titulo;
	}

	@Override
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public List<String> getListaTags() {
		return tags;
	}

	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	@Override
	public void setTag (String tag ) {
		tags.add(tag);
	}
	
	@Override
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public String getAutor() {
		return this.autor;
	}

	/**
	 * Método sobreescrito
	 * @return devuelve un string con los datos del vídeo
	 */
	@Override
	public String toString() {

		return "URL : "+this.url+"   Título del Vídeo: "+this.titulo+"    Autor del Vídeo: "+this.autor+"  lista de tags del video: "+String.join(",", this.tags);
	}
	
	/**
	 * Método que devuelve los campos del vídeo en un arreglo. La lista de tags se pasan a stringseparados por comas.
	 * @return Un arreglo de cadenas. Cada posición del arreglo es uncampo del vídeo.
	 */
	@Override
	public String[] toArray() {
		return (new String[] {this.url, this.titulo, this.autor, Arrays.toString(this.tags.toArray()).replace("[", "").replace("]", "")});            
	}
	

}
