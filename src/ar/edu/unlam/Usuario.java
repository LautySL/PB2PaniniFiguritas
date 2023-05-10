package ar.edu.unlam;

import java.util.*;

public abstract class Usuario {

	private String nombre;
	private Integer ID;
	
	public Usuario(String nombre, Integer iD) {
		super();
		this.nombre = nombre;
		this.ID = iD;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public abstract Boolean agregarFigurita (Figurita figurita, Sistema sistema) throws CodigoExistenteException;

	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(ID, other.ID);
	}

}
