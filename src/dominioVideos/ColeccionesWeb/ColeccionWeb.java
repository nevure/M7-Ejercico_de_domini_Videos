/**
 * M7- Ejercico de domini de Videos
 * IT Academy
 * Barcelona Activa
 * Interfaz ColeccionWeb
 *
 */

package dominioVideos.ColeccionesWeb;

import java.util.List;

/**
 * Interfaz ColeccionWeb
 * 
 * Defiimos un interfaz para posible objetos relacionados con la WEB. Podrían ser vídoes, libros u otros items.
 * 
 * @author Rubén Rodríguez
 *
 */

public interface ColeccionWeb {
	
	public String toString();
	public String getUrl();
	public String getTitulo();
	public String getAutor();
	public List<String> getListaTags();
	
	public void setUrl(String url);
	public void setTitulo(String titulo);
	public void setAutor(String Autor);
	public void setTag(String tag);	
	public boolean buscarPorCampoClave(String index);
	public boolean equals(Object obj);
	public int hashCode();
	public String[] toArray();
	
}
