/**
 * M7- Ejercico de domini de Videos
 * IT Academy
 * Barcelona Activa
 * Clase vistaMenu
 *
 */
 
package dominioVideos;


import javax.swing.JOptionPane;

import excepcionesPropias.*;


/**
 * 
 * Esta clase es reponsable dela vista de la APP. 
 * 
 * @author Rubén Rodríguez
 *
 */
public class VistaMenu {
	
	/**
	 * Método que muestra el menú principal de la APP
	 * 
	 * @return devuelve opción escogida.
	 */
	public int menuPrincipal() {
	
		int seleccion = JOptionPane.showOptionDialog(
				   null,
				   "Seleccione opcion", 
				   "Selector de opciones",
				   JOptionPane.YES_NO_CANCEL_OPTION,
				   JOptionPane.QUESTION_MESSAGE,
				   null,    // null para icono por defecto.
				   new Object[] { "Entrar (Login)", "Nuevo Usuario/a", "Salir del programa" },  
				   "opcion 1");

		
		return seleccion;	  
		
	}
	
	/**
	 * Método que muestra una serie de opciones donde elegir.
	 * @param opciones  lista de opciones a mostrar en pantalla
	 * @return devuelve la opción escogida.
	 */
	public int menuOpciones(String[] opciones) {
		
		int seleccion = JOptionPane.showOptionDialog(
				   null,
				   "Seleccione opcion", 
				   "Selector de opciones",
				   JOptionPane.YES_NO_CANCEL_OPTION,
				   JOptionPane.QUESTION_MESSAGE,
				   null,    // null para icono por defecto.
				   opciones,  
				   "opcion 1");

		
		return seleccion;	  
		
	}
	
	/**
	 * Método que muestra un sencillo mensaje en pantalla con el botón de ok.
	 * @param str Texto a mostrar en pantalla
	 */
	public void mensajeSimple(String str) {
		JOptionPane.showMessageDialog(
				   null,
				   str);
	}
	
	/**
	 * Menú de Login de usuario. Utilizamos excepciones para el caso de introducir pocos caracteres enloscampos.
	 * 
	 * 
	 * @return un arreglo de dos: primera posición el usuario, y segunda el password.
	 * @throws nombre_usuario_erroneo
	 * @throws contrasenya_erroneo
	 */
		
	public  String[] menuLogin() throws nombre_usuario_erroneo, contrasenya_erroneo{
		
		String[] credenciales = new String[2];
		
		
		credenciales[0] = JOptionPane.showInputDialog(
				   null,
				   "email de acceso",
				   JOptionPane.QUESTION_MESSAGE);
		
		if (credenciales[0] == null || credenciales[0].length() < 5 )
			throw new nombre_usuario_erroneo();
		else {
			
				        
		credenciales[1]	= JOptionPane.showInputDialog(
				   null,
				   "Contraseña de usuario/a",
				   JOptionPane.QUESTION_MESSAGE);
		
		if (credenciales[1] == null || credenciales[1].length() < 7) 
			throw new contrasenya_erroneo();
						        
		}
		return credenciales;
	}	
	
	/**
	 * Método que muestra por pantalla preguntas de una en una y devuelve un array con las respuestas. No se permite no cumplimentar los campos ni cancelar.
	 * @param preguntas listado de preguntas a realizar.
	 * @return Arreglo con las respuestas.
	 */
	public String[] menuConPreguntas(String[] preguntas) {
		
		String respuestas[] = new String[preguntas.length];
		int i = 0;
		
		for (String pregunta: preguntas) {
		
			while (respuestas[i] == null || respuestas[i].length() < 3) {
				respuestas[i] = JOptionPane.showInputDialog(
						   null,
						   pregunta + "(Campo obligatorio",
						   "")	;			
			}
					
			i++;		
		}
		return respuestas;
	}
	
	/**
	 * Método similar a {@link dominioVideos.VisaMenu#menuConPreguntas} <br>
	 * PEro en este caso recibe además un arreglo con cadenas que serán introducidas en los campos de respuesta. en nuestra APP nos sirve para que el usuario vea el cotenido  
	 * actual de un registro y pueda modificarlo a su gusto.
	 * @param preguntas listado de preguntas a realizar.
	 * @param inline listado de cadenas a mostrar en los campos de respuesta
	 * @return devuelve respuestas 
	 */
	public String[] menuEdicion(String[] preguntas, String[] inline) {
		
		String respuestas[] = new String[preguntas.length];
		int i = 0;
		
		for (String pregunta: preguntas) {
		
			while (respuestas[i] == null || respuestas[i].length() < 3) {
				respuestas[i] = JOptionPane.showInputDialog(
						   null,
						   pregunta + "(Campo obligatorio",
						   inline[i]);			
			}	
			i++;			
		}
		
		return respuestas;	
	}		 

}
