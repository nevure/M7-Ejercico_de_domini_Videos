/**
 * M7- Ejercico de domini de Videos
 * @author Rubén Rodríguez
 * IT Academy
 * Barcelona Activa
 * Clase principal MAIN
 *
 */
package dominioVideos;


public class VideosAppPrincipal {
	
	/*
	 * Método MAIN
	 */
	public static void main(String[] args) {
		
		/*
		 *menuvista -> Para lanzar cuadros de diálogo visuales y capturar entradas de usuario.
		 *opcionMenuAPP -> recoge la selección del menú principal de la APP
		 *opcionElegida -> recoge la selección del menú de usuario.
		 *miControlador -> Controlador de la APP. Es la clases que interactua con la clase singleton que almacena la lista de usuario y sus videos.  
		 */
		VistaMenu menuVista = new VistaMenu();
		int opcionMenuAPP=0, opcionMenuUsuario=0;
		String opcionElegida = new String();		
		ControladorVistaMenu miControlador = new ControladorVistaMenu();
		
		//Mientras no escogamos la opción de salir.
		while ((opcionMenuAPP = menuVista.menuPrincipal())!=2) {
			
			switch (opcionMenuAPP) {
			/*
			 * case 0 para hacer login. Si hace login bien, entraremos al siguiente nivel donde veremos el menú de usuario. En caso contrario vuelve al menu principal.
			 */
			case 0:  
				
				if (miControlador.loginUsuario())
				{
					
					/*
					 * Iteración interna del espacio de usuario, donde saldremos una vez escogida la opción de salir de la sesión.
					 * 
					 */
					while ((opcionMenuUsuario = miControlador.menuUsuario(new String[] {"Agregar nuevo video", "Editar Video", "Editar datos usuario", "Listar Vídeos personales", "Eliminar Vídeo","Salir Sesion"}))!= 5) {
						switch (opcionMenuUsuario)	{
						
						/*
						 * Case 0 para agregar un nuevo vídeo de usuario. Pasamos las preguntas que deseamos. 
						 */
						case 0:
							if (miControlador.menuNuevoItem(new String[] {"URL", "Titulo", "Autor", "Lista de tags separados por comas"}))
								menuVista.mensajeSimple("Vídeo Agregado con Éxito");
							else 
								menuVista.mensajeSimple("Recuerda que todo campo debe tener más de 3 caracteres. Prueba de nuevo");
							break;
						
							/*
							 * Case 1 para modificar datos del video. Verificamos que realmente se introduce algo y luego se llama al controlador a quien se
							 * le pasa el string introducido (titulo delvideo a modificar) y las preguntas a realizar en la vista.
							 */
						case 1:
							if ((opcionElegida = (menuVista.menuConPreguntas(new String[] {"Dime el titulo del Vídeo a modificar: "}))[0]) != null)
							{
								miControlador.modificarItem(opcionElegida, new String[] {"URL", "Titulo", "Autor", "Lista de tags separados por comas"});								
							}
							break;
						
							/*
							 * Case 2 para modificar datos del usuario. Se pasa las preguntas a realizar.
							 */
						case 2:
							miControlador.modificarUser(new String[] {"Dime tu nombre ", "Dime tus apellidos", "Dime la contraseña de acceso", "Confirma contraseña de acceso"});
							break;
							
							/*
							 * Case 3. Listado de los videos delusuario logueado.
							 */
						case 3: 
							miControlador.mostrarListado();
							break;
							
							/*
							 * Case 4 para eliminar un video. Verificamos que realmente se introduce algo y luego se llama al controlador a quien se
							 * le pasa el string introducido (titulo del video a modificar).
							 */
						case 4:
							if ((opcionElegida = (menuVista.menuConPreguntas(new String[] {"Dime el titulo del Vídeo a eliminar: "}))[0]) != null)
							{
								miControlador.eliminarItem(opcionElegida);								
							}
							break;
						default:
							break;
						}
					}				
				}				
				break;
			
			/*
			 * Case 1 para Agregar un usuario a la APP.
			 */
			case 1: //Agregar user
				
				miControlador.altaUsuario(new String[] {"Dime tu nombre ", "Dime tus apellidos", "Dime tu email", "Dime la contraseña de acceso", "Confirma contraseña de acceso"});
				break;

			default:
				break;
			}				
		}
		
	}
}

