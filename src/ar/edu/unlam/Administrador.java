package ar.edu.unlam;

public class Administrador extends Usuario {

	
	public Administrador(String nombre, Integer iD) {
		super(nombre, iD);
	}

	@Override
	public Boolean agregarFigurita(Figurita figurita, Sistema sistema) throws CodigoExistenteException {
		if (sistema.verificarSiElUsuarioEstaEnElSistema(this)) {
			if (sistema.verificarSiLaFiguritaEstaEnElSistema(figurita)) {
				throw new CodigoExistenteException();
			} else {
				sistema.agregarFigurita(figurita);
				return true;
			}
		}
		return false;
	}

}
