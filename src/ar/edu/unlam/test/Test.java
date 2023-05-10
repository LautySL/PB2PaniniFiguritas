package ar.edu.unlam.test;

import static org.junit.Assert.*;

import ar.edu.unlam.*;

public class Test {

	@org.junit.Test
	public void queSePuedaCrearUnaFigurita() {
		 Figurita figurita = new Figurita (1, Seleccion.ARGENTINA, 'A', "Leo Messi", 1000.0);		 
		 assertNotNull (figurita);
	}
	
	@org.junit.Test
	public void queSePuedaCrearUnAdministrador() {
		Usuario administrador = new Administrador ("Fitti", 123);		
		assertNotNull (administrador);
	}
	
	@org.junit.Test
	public void queSePuedaCrearUnUsuarioFinal() {
		Usuario usuarioFinal = new UsuarioFinal ("Fitti", 321);
		assertNotNull (usuarioFinal);
	}
	
	@org.junit.Test
	public void queUnAdministradorPuedaAgregarUnaFigurita() throws CodigoExistenteException {
		Figurita figurita = new Figurita (1, Seleccion.ARGENTINA, 'A', "Leo Messi", 1000.0);
		Usuario administrador = new Administrador ("Fitti", 123);	
		Sistema system = new Sistema ("ASDF");
		
		system.agregarUsuario(administrador);
		
		administrador.agregarFigurita(figurita, system);
		
		Integer cantidadDeFiguritasEsperado = 1;
		Integer cantidadDeFiguritas = system.getCantidadDeFiguritas();
		
		assertEquals (cantidadDeFiguritas, cantidadDeFiguritasEsperado);
	}
	
	@org.junit.Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita() throws CodigoExistenteException {
		Figurita figurita = new Figurita (1, Seleccion.PORTUGAL, 'B', "Cristiano Ronaldo", 1000.0);
		Usuario usuarioFinal = new UsuarioFinal ("Fitti", 321);
		Sistema system = new Sistema ("ASDF");
		
		system.agregarUsuario(usuarioFinal);
		
		usuarioFinal.agregarFigurita(figurita, system);
		
		Integer cantidadDeFiguritasEnElStock = ((UsuarioFinal) usuarioFinal).getCantidadDeFiguritasEnElStock();
		Integer cantidadDeFiguritasEnElStockEsperado = 1;
		
		assertEquals (cantidadDeFiguritasEnElStock, cantidadDeFiguritasEnElStockEsperado);
	}
	
	@org.junit.Test
	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() throws CodigoExistenteException {
		Figurita figurita1 = new Figurita (1, Seleccion.ARGENTINA, 'C', "Leo Messi", 1000.0);
		Figurita figurita2 = new Figurita (5, Seleccion.PORTUGAL, 'H', "Cristiano Ronaldo", 1000.0);
		Figurita figurita3 = new Figurita (3, Seleccion.FRANCIA, 'D', "Kylian Mbappe", 1400.0);
		Figurita figurita4 = new Figurita (6, Seleccion.CROACIA, 'F', "Luka Modric", 1000.0);
		Figurita figurita5 = new Figurita (2, Seleccion.PAISES_BAJOS, 'A', "Wout Weghorst", 1000.0);
		
		Sistema system = new Sistema ("ASDF");
		Usuario usuarioFinal = new UsuarioFinal ("Fitti", 321);
		
		system.agregarUsuario(usuarioFinal);
		
		usuarioFinal.agregarFigurita(figurita1, system);
		usuarioFinal.agregarFigurita(figurita2, system);
		usuarioFinal.agregarFigurita(figurita3, system);
		usuarioFinal.agregarFigurita(figurita4, system);
		usuarioFinal.agregarFigurita(figurita5, system);
		
		assertEquals (figurita5, ((UsuarioFinal) usuarioFinal).getStock().get(0));
		assertEquals (figurita1, ((UsuarioFinal) usuarioFinal).getStock().get(1));
		assertEquals (figurita3, ((UsuarioFinal) usuarioFinal).getStock().get(2));
		assertEquals (figurita4, ((UsuarioFinal) usuarioFinal).getStock().get(3));
		assertEquals (figurita2, ((UsuarioFinal) usuarioFinal).getStock().get(4));
	}
	
	
	@org.junit.Test (expected = CodigoExistenteException.class)
	public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() throws CodigoExistenteException {
		Usuario administrador = new Administrador ("Fitti", 123);	
		Figurita figurita1 = new Figurita (1, Seleccion.ARGENTINA, 'C', "Leo Messi", 1000.0);
		Figurita figurita2 = new Figurita (1, Seleccion.ARGENTINA, 'C', "Leo Messi", 1000.0);
		Sistema system = new Sistema ("ASDF");
		
		system.agregarUsuario(administrador);
		
		assertTrue (administrador.agregarFigurita(figurita1, system));
		assertTrue (administrador.agregarFigurita(figurita2, system));
	}
	
	@org.junit.Test
	public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() throws CodigoExistenteException {
		Figurita figurita1 = new Figurita (1, Seleccion.ARGENTINA, 'C', "Leo Messi", 1000.0);
		Figurita figurita2 = new Figurita (1, Seleccion.ARGENTINA, 'C', "Leo Messi", 1000.0);
		Usuario usuarioFinal = new UsuarioFinal ("Fitti", 321);
		Sistema system = new Sistema ("ASDF");
		
		system.agregarUsuario(usuarioFinal);
		
		assertTrue (usuarioFinal.agregarFigurita(figurita1, system));
		assertTrue (usuarioFinal.agregarFigurita(figurita2, system));
	}
	
	@org.junit.Test
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() {
		Figurita figurita1 = new Figurita (1, Seleccion.ARGENTINA, 'C', "Leo Messi", 1000.0);
		Usuario usuarioFinal = new UsuarioFinal ("Fitti", 321);
		Sistema system = new Sistema ("ASDF");
		
		system.agregarUsuario(usuarioFinal);
		
		try {
			usuarioFinal.agregarFigurita(figurita1, system);
		} catch (CodigoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertTrue (((UsuarioFinal) usuarioFinal).pegarFigurita(figurita1));
		} catch (FiguritaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@org.junit.Test (expected = FiguritaRepetidaException.class)
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws FiguritaRepetidaException, CodigoExistenteException {
		Figurita figurita1 = new Figurita (1, Seleccion.ARGENTINA, 'C', "Leo Messi", 1000.0);
		Figurita figurita2 = new Figurita (1, Seleccion.ARGENTINA, 'C', "Leo Messi", 1000.0);
		Usuario usuarioFinal = new UsuarioFinal ("Fitti", 321);
		Sistema system = new Sistema ("ASDF");
		
		system.agregarUsuario(usuarioFinal);
		
		usuarioFinal.agregarFigurita(figurita1, system);
		usuarioFinal.agregarFigurita(figurita2, system);
		
		((UsuarioFinal) usuarioFinal).pegarFigurita(figurita1);
		((UsuarioFinal) usuarioFinal).pegarFigurita(figurita2);
	}
	
	@org.junit.Test
	public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() throws CodigoExistenteException, FiguritaNoDisponible {
		Figurita figurita1 = new Figurita (1, Seleccion.ARGENTINA, 'C', "Leo Messi", 1000.0);
		Figurita figurita2 = new Figurita (5, Seleccion.PORTUGAL, 'H', "Cristiano Ronaldo", 1000.0);
		Sistema system = new Sistema ("ASDF");
		
		Usuario usuarioFinal1 = new UsuarioFinal ("Fitti", 321);
		Usuario usuarioFinal2 = new UsuarioFinal ("Viltti", 321);
		
		system.agregarUsuario(usuarioFinal1);
		system.agregarUsuario(usuarioFinal2);
		
		usuarioFinal1.agregarFigurita(figurita1, system);
		usuarioFinal2.agregarFigurita(figurita2, system);
		
		system.intercambiarFiguritas(((UsuarioFinal) usuarioFinal1), figurita1, ((UsuarioFinal) usuarioFinal2), figurita2);
		
		assertEquals (figurita2, ((UsuarioFinal) usuarioFinal1).getStock().get(0));
		assertEquals (figurita1, ((UsuarioFinal) usuarioFinal2).getStock().get(0));
	}
	
	@org.junit.Test (expected = FiguritaNoDisponible.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga() throws CodigoExistenteException, FiguritaNoDisponible {
		Figurita figurita1 = new Figurita (1, Seleccion.ARGENTINA, 'C', "Leo Messi", 1000.0);
		Figurita figurita2 = new Figurita (5, Seleccion.PORTUGAL, 'H', "Cristiano Ronaldo", 1000.0);
		Figurita figurita3 = new Figurita (3, Seleccion.FRANCIA, 'D', "Kylian Mbappe", 1400.0);
		Sistema system = new Sistema ("ASDF");
		
		Usuario usuarioFinal1 = new UsuarioFinal ("Fitti", 321);
		Usuario usuarioFinal2 = new UsuarioFinal ("Viltti", 321);
		
		system.agregarUsuario(usuarioFinal1);
		system.agregarUsuario(usuarioFinal2);
		
		usuarioFinal1.agregarFigurita(figurita1, system);
		usuarioFinal2.agregarFigurita(figurita2, system);
		
		system.intercambiarFiguritas(((UsuarioFinal) usuarioFinal1), figurita3, ((UsuarioFinal) usuarioFinal2), figurita2);
	}
	
	@org.junit.Test (expected = FiguritaNoDisponible.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado() throws CodigoExistenteException, FiguritaRepetidaException, FiguritaNoDisponible {
		Figurita figurita1 = new Figurita (1, Seleccion.ARGENTINA, 'C', "Leo Messi", 1000.0);
		Figurita figurita2 = new Figurita (5, Seleccion.PORTUGAL, 'H', "Cristiano Ronaldo", 1000.0);
		Sistema system = new Sistema ("ASDF");
		
		Usuario usuarioFinal1 = new UsuarioFinal ("Fitti", 321);
		Usuario usuarioFinal2 = new UsuarioFinal ("Viltti", 321);
		
		system.agregarUsuario(usuarioFinal1);
		system.agregarUsuario(usuarioFinal2);
		
		usuarioFinal1.agregarFigurita(figurita1, system);
		usuarioFinal2.agregarFigurita(figurita2, system);
		
		((UsuarioFinal) usuarioFinal1).pegarFigurita(figurita1);
		
		system.intercambiarFiguritas(((UsuarioFinal) usuarioFinal1), figurita1, ((UsuarioFinal) usuarioFinal2), figurita2);
	}
	
	
	

}
