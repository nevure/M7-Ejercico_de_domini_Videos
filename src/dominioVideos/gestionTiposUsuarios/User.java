/**
 * M7- Ejercico de domini de Videos
 * IT Academy
 * Barcelona Activa
 * Interfaz Uer
 *
 */

package dominioVideos.gestionTiposUsuarios;

/**
 * Interfaz que define las características mínimas de un objeto usuario. 
 * @author Rubén Rodríguez
 *
 */
public interface User {
	
	public byte permisos();
	public boolean passCorrecto(String passwd);
	public boolean cambioMail(String mail);
	public boolean requisitosPass(String passwd);
	String getMail();
	void setMail(String mail);
    String getPasswd();
    String toString();
	public String[] toArray();
	
}




