package mundo;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class SimboloLexicoTest {

	@Test
	public void testSimboloLexico() {
		SimboloLexico simboloLexico = new SimboloLexico(Configuracion.lexemaSL, Configuracion.tipoSL, Integer.parseInt(Configuracion.filaSL),Integer.parseInt(Configuracion.columnaSL));
		Assert.assertNotNull(simboloLexico);
	}

	@Test
	public void testGetLexema() {
		SimboloLexico simboloLexico = new SimboloLexico(Configuracion.lexemaSL, Configuracion.tipoSL, Integer.parseInt(Configuracion.filaSL),Integer.parseInt(Configuracion.columnaSL));
		Assert.assertNotNull(simboloLexico.getLexema());

	}

	@Test
	public void testSetLexema() {
		SimboloLexico simboloLexico = new SimboloLexico(Configuracion.lexemaSL, Configuracion.tipoSL, Integer.parseInt(Configuracion.filaSL),Integer.parseInt(Configuracion.columnaSL));
		simboloLexico.setLexema(Configuracion.nuevoLexema);
		Assert.assertEquals(Configuracion.nuevoLexema, simboloLexico.getLexema());
	}

	@Test
	public void testGetTipo() {
		SimboloLexico simboloLexico = new SimboloLexico(Configuracion.lexemaSL, Configuracion.tipoSL, Integer.parseInt(Configuracion.filaSL),Integer.parseInt(Configuracion.columnaSL));
		Assert.assertEquals(Configuracion.tipoSL, simboloLexico.getTipo());
	}

	@Test
	public void testSetTipo() {
		SimboloLexico simboloLexico = new SimboloLexico(Configuracion.lexemaSL, Configuracion.tipoSL, Integer.parseInt(Configuracion.filaSL),Integer.parseInt(Configuracion.columnaSL));
		simboloLexico.setTipo(Configuracion.nuevoTipo);
		Assert.assertEquals(Configuracion.nuevoTipo, simboloLexico.getTipo());
	}

	@Test
	public void testGetFila() {
		SimboloLexico simboloLexico = new SimboloLexico(Configuracion.lexemaSL, Configuracion.tipoSL, Integer.parseInt(Configuracion.filaSL),Integer.parseInt(Configuracion.columnaSL));
		Assert.assertEquals(Integer.parseInt(Configuracion.filaSL), simboloLexico.getFila());
	}

	@Test
	public void testSetFila() {
		SimboloLexico simboloLexico = new SimboloLexico(Configuracion.lexemaSL, Configuracion.tipoSL, Integer.parseInt(Configuracion.filaSL),Integer.parseInt(Configuracion.columnaSL));
		simboloLexico.setFila(Integer.parseInt(Configuracion.nuevaFila));
		Assert.assertEquals(Integer.parseInt(Configuracion.nuevaFila), simboloLexico.getFila());
	}

	@Test
	public void testGetColumna() {
		SimboloLexico simboloLexico = new SimboloLexico(Configuracion.lexemaSL, Configuracion.tipoSL, Integer.parseInt(Configuracion.filaSL),Integer.parseInt(Configuracion.columnaSL));
		Assert.assertEquals(Integer.parseInt(Configuracion.columnaSL), simboloLexico.getColumna());
	}

	@Test
	public void testSetColumna() {
		SimboloLexico simboloLexico = new SimboloLexico(Configuracion.lexemaSL, Configuracion.tipoSL, Integer.parseInt(Configuracion.filaSL),Integer.parseInt(Configuracion.columnaSL));
		simboloLexico.setColumna(Integer.parseInt(Configuracion.nuevaColumna));
		Assert.assertEquals(Integer.parseInt(Configuracion.nuevaColumna), simboloLexico.getColumna());
	}

}
