/**
 * 
 */
package co.com.ivancho.exceptions;

/**
 * Esta clase contiene todas las excepciones que van a controlarse de forma
 * controlada por el programa.
 * 
 * @author ipinilla
 *
 */
public class CustomException extends RuntimeException {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -739727813636756811L;

	/**
	 * Constructor de la clase de excepciones.
	 * 
	 * @param message
	 *            Mensaje a ser mostrado
	 */
	public CustomException(String message) {
		super(message);
	}

}
