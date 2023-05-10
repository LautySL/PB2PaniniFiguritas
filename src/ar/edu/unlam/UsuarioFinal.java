package ar.edu.unlam;

import java.util.*;

public class UsuarioFinal extends Usuario {

	private ArrayList <Figurita> stock;
	private HashSet <Figurita> album;
	
	public UsuarioFinal(String nombre, Integer iD) {
		super(nombre, iD);
		this.stock = new ArrayList<>();
		this.album = new HashSet<>();
	}

	@Override
	public Boolean agregarFigurita(Figurita figurita, Sistema sistema) {
		if (sistema.verificarSiElUsuarioEstaEnElSistema(this)) {
			this.stock.add(figurita);
			Collections.sort(this.stock);
			return true;
		}
		return false;
	}
	
	public ArrayList<Figurita> getStock() {
		return stock;
	}

	public HashSet<Figurita> getAlbum() {
		return album;
	}

	public Integer getCantidadDeFiguritasEnElStock() {
		return this.stock.size();
	}
	
	public Integer getCantidadDeFiguritasEnElAlbum() {
		return this.album.size();
	}
	
	public void intercambiarFigurita (Figurita figuritaQueIntercambio, Figurita figuritaQueMeDan) {
		this.stock.add(figuritaQueMeDan);
		this.stock.remove(figuritaQueIntercambio);
	}
	
	public Boolean pegarFigurita (Figurita figurita) throws FiguritaRepetidaException {
		if (stock.contains(figurita)) {
			if (album.contains(figurita)) {
				throw new FiguritaRepetidaException();
			} else {
			stock.remove(figurita);
			return album.add(figurita);
			}
		} return false;
	} 
	
	public Boolean verificarSiFiguritaEstaEnElStock (Figurita figurita) throws FiguritaNoDisponible {
		if (this.stock.contains(figurita)) {
			return true;
		} else {
			throw new FiguritaNoDisponible();
		}
	}

}
