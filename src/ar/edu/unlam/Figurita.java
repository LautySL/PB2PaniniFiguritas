package ar.edu.unlam;

import java.util.Objects;

public class Figurita implements Comparable <Figurita> {

	private Integer numeroDelJugador;
	private Seleccion seleccion;
	private Character letraDelGrupo;
	private String nombreDelJugador;
	private Double valorDelJugador;
	
	public Figurita(Integer numeroDelJugador, Seleccion seleccion, Character letraDelGrupo, String nombreDelJugador, Double valorDelJugador) {
		super();
		this.numeroDelJugador = numeroDelJugador;
		this.seleccion = seleccion;
		this.letraDelGrupo = letraDelGrupo;
		this.nombreDelJugador = nombreDelJugador;
		this.valorDelJugador = valorDelJugador;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(letraDelGrupo, nombreDelJugador, numeroDelJugador, seleccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figurita other = (Figurita) obj;
		return Objects.equals(letraDelGrupo, other.letraDelGrupo)
		&& Objects.equals(nombreDelJugador, other.nombreDelJugador)
		&& Objects.equals(numeroDelJugador, other.numeroDelJugador) && seleccion == other.seleccion;
	}

	public Integer getNumeroDelJugador() {
		return numeroDelJugador;
	}

	public void setNumeroDelJugador(Integer numeroDelJugador) {
		this.numeroDelJugador = numeroDelJugador;
	}

	public Seleccion getSeleccion() {
		return seleccion;
	}
	
	public void setSeleccion(Seleccion seleccion) {
		this.seleccion = seleccion;
	}
	
	public Character getLetraDelGrupo() {
		return letraDelGrupo;
	}
	
	public void setLetraDelGrupo(Character letraDelGrupo) {
		this.letraDelGrupo = letraDelGrupo;
	}
	
	public String getNombreDelJugador() {
		return nombreDelJugador;
	}
	
	public void setNombreDelJugador(String nombreDelJugador) {
		this.nombreDelJugador = nombreDelJugador;
	}
	
	public Double getValorDelJugador() {
		return valorDelJugador;
	}
	
	public void setValorDelJugador(Double valorDelJugador) {
		this.valorDelJugador = valorDelJugador;
	}

	@Override
	public int compareTo(Figurita o) {
		if (this.letraDelGrupo.equals(o.letraDelGrupo)) {
			if (this.seleccion.equals(o.seleccion)) {
				/* 1 - 22 */
				return this.numeroDelJugador.compareTo(o.numeroDelJugador);
			}
			return this.seleccion.compareTo(o.seleccion);
		}
		return this.letraDelGrupo.compareTo(o.letraDelGrupo);
	}
	
	
	
}
