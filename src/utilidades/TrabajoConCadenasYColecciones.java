/**
 * M7- Ejercico de domini de Videos
 * IT Academy
 * Barcelona Activa
 * PAquete de utilidades. Clase que trabaja con Cadenas y colecciones
 *
 */
package utilidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Rubén Rodríguez
 * Clase de utilidades.
 * separadoComasAArray -> un array con texto separado por comas se transforma en un ArrayList.
 * borrarRepetidosLista -> borra los elementos repetidos de una lista devolviendo esta ya con elementos únicos.
 * borrarEspaciosyConvenirALista -> Borra los espacios en un String y luego utiliza las comas para pasar a lista los elementos entre éstas.
 */
public class TrabajoConCadenasYColecciones {
	
	/*
	 * @param str Parámetro String donde se separará los textos por comas y se devuelve en un ArrayList.
	 * @return Devuelve un arrayList donde los elementos son los textos del array entre comas sucesivas.
	 */
	public ArrayList<String> separadoComasAArray (String str) {		
		return new ArrayList<String>(Arrays.asList(str.split(",")));
	}
	
	/*
	 * @param lista Parámetro de tipo List que se analizará para eliminar elementos duplicados.
	 * @return Devuelve una lista de elementos únicos.
	 */
	
	public static List<String> borrarRepetidosLista (List<String> lista) {
		return  lista.stream().distinct().collect(Collectors.toList());
	}
	
	/*
	 * @param str Parámetro String donde se separará eliminará los espacios en blanco y luego le aplicaremos un filtro para devolver el array en formato lista siendo
	 * los elementos aquellos strings entre comas sucesivas.
	 * @return Devuelve una List donde los elementos son los textos del array entre comas sucesivas.
	 */
	
	public static List<String> borrarEspaciosyConvenirALista (String str) {
		str = str.replace(" ", "");
		return  Arrays.asList(str.split(",", -1));
				
	}


}
