package ar.edu.unlam;

import java.util.*;

public class Sistema {
	
	private String nombre;
	private ArrayList <Figurita> figuritas;
	private Set <Usuario> usuarios;

	public Sistema(String nombre) {
		super();
		this.nombre = nombre;
		this.figuritas = new ArrayList<>();
		this.usuarios = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList <Figurita> getFiguritas() {
		return figuritas;
	}

	public void setFiguritas (ArrayList <Figurita> figuritas) {
		this.figuritas = figuritas;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public Integer getCantidadDeFiguritas() {
		return this.figuritas.size();
	}
	
	public Boolean verificarSiElUsuarioEstaEnElSistema (Usuario usuarioAValidar) {
		return usuarios.contains(usuarioAValidar);
	}
	
	public Boolean verificarSiLaFiguritaEstaEnElSistema (Figurita figuritaAValidar) {
		return figuritas.contains(figuritaAValidar);
	}
	
	public Boolean agregarFigurita (Figurita figurita) {
		return figuritas.add(figurita);
	}
	
	public Boolean agregarUsuario (Usuario usuario) {
		return usuarios.add(usuario);
	}
	
	public void intercambiarFiguritas (UsuarioFinal usuarioUno, Figurita figuritaDeUsuarioUno, UsuarioFinal usuarioDos, Figurita figuritaDeUsuarioDos) throws FiguritaNoDisponible {
		if (usuarioUno.verificarSiFiguritaEstaEnElStock(figuritaDeUsuarioUno) && usuarioDos.verificarSiFiguritaEstaEnElStock(figuritaDeUsuarioDos)) {
			usuarioUno.intercambiarFigurita(figuritaDeUsuarioUno, figuritaDeUsuarioDos);
			usuarioDos.intercambiarFigurita(figuritaDeUsuarioDos, figuritaDeUsuarioUno);
		}
	}
}
