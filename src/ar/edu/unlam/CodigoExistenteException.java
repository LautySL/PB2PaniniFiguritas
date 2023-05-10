package ar.edu.unlam;

public class CodigoExistenteException extends Exception {

	public CodigoExistenteException() {
		super("El codigo ya existe.");
	}
	
}
