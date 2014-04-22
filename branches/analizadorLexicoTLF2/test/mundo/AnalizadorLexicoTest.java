package mundo;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class AnalizadorLexicoTest {



	@Test
	public void testAnalizadorLexico() {
		AnalizadorLexico lexico2 = new AnalizadorLexico(); 
		Assert.assertNotNull(lexico2);
	}

	@Test
	public void testAnalizar() {

		AnalizadorLexico lexico = new AnalizadorLexico();
		lexico.analizar(Configuracion.codigoFuente);

		Assert.assertEquals(Integer.parseInt(Configuracion.valorEsperadoBuenos), lexico.getTablaSimbolos().size());
		Assert.assertEquals(Integer.parseInt(Configuracion.valorEsperadoError), lexico.getTablaErrores().size());

	}

	@Test
	public void testEsReservada() {

		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaReservada + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaReservada.charAt(0));
		lexico.cargarReservadas();

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoReservada), lexico.esReservada());

	}

	@Test
	public void testEsSeparador() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaSeparador + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaSeparador.charAt(0));


		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoSeparador), lexico.esSeparador());
	}

	@Test
	public void testEsEntero() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaEntero + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaEntero.charAt(0));


		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoEntero), lexico.esEntero());
	}

	@Test
	public void testEsReal() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaReal + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaReal.charAt(0));


		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoReal), lexico.esReal());
	}

	@Test
	public void testEsClase() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaClase + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaClase.charAt(0));


		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoClase), lexico.esClase());
	}

	@Test
	public void testEsMetodo() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaMetodo + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaMetodo.charAt(0));


		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoMetodo), lexico.esMetodo());
	}

	@Test
	public void testEsVariable() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaVariable + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaVariable.charAt(0));


		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoVariable), lexico.esVariable());
	}

	@Test
	public void testEsMayoreIgual() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaMayoreIgual + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaMayoreIgual.charAt(0));


		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoMayoreIgual), lexico.esMayoreIgual());
	}

	@Test
	public void testEsMenoreIgual() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaMenoreIgual + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaMenoreIgual.charAt(0));


		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoMenoreIgual), lexico.esMenoreIgual());
	}

	@Test
	public void testEsIgualeIgual() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaIgualeIgual + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaIgualeIgual.charAt(0));


		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoIgualeIgual), lexico.esIgualeIgual());
	}

	@Test
	public void testEsOperadorTerminal() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaTerminal + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaTerminal.charAt(0));


		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoTerminal), lexico.esOperadorTerminal());
	}

	@Test
	public void testEsOperadorAsignacion() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaAsignacion + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaAsignacion.charAt(0));


		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoAsignacion), lexico.esOperadorAsignacion());
	}

	@Test
	public void testEsOperadorMenor() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaMenor + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaMenor.charAt(0));


		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoMenor), lexico.esOperadorMenor());
	}

	@Test
	public void testEsOperadorMayor() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaMayor + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaMayor.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoTerminal), lexico.esOperadorMayor());
	}

	@Test
	public void testEsOperadorDivision() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaDivision + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaDivision.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoDivision), lexico.esOperadorDivision());
	}

	@Test
	public void testEsOperadorResta() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaResta + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaResta.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoResta), lexico.esOperadorResta());
	}

	@Test
	public void testEsOperadorSuma() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaSuma + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaSuma.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoSuma), lexico.esOperadorSuma());
	}

	@Test
	public void testEsOperadorMultiplicacion() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaMultiplicacion + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaMultiplicacion.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoMultiplicacion), lexico.esOperadorMultiplicacion());
	}

	@Test
	public void testEsAbreParentesis() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaAbreParentesis + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaAbreParentesis.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoAbreParentesis), lexico.esAbreParentesis());
	}

	@Test
	public void testEsCierraParentesis() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaCierraParentesis + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaCierraParentesis.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoCierraParentesis), lexico.esCierraParentesis());
	}

	@Test
	public void testEsAbreLlave() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaAbreLlave + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaAbreLlave.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoAbreLlave), lexico.esAbreLlave());
	}

	@Test
	public void testEsCierraLlave() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaCierraLlave + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaCierraLlave.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoCierraLlave), lexico.esCierraLlave());
	}

	@Test
	public void testEsConjuncion() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaConjuncion + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaConjuncion.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoConjuncion), lexico.esConjuncion());
	}

	@Test
	public void testEsDisyuncion() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaDisyuncion + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaDisyuncion.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoDisyuncion), lexico.esDisyuncion());
	}

	@Test
	public void testEsNegacion() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaNegacion + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaNegacion.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoNegacion), lexico.esNegacion());
	}

	@Test
	public void testEsComentario() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaComentario + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaComentario.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoComentario), lexico.esComentario());
	}

	@Test
	public void testEsCadena() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaCadena + EOC);
		lexico.setFilaActual(1);
		lexico.setColumnaActual(1);
		lexico.setPosicionActual(0);
		lexico.setCaracterActual(Configuracion.lexemaCadena.charAt(0));

		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoCadena), lexico.esCadena());
	}

	@Test
	public void testBacktraking() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaBacktraking + EOC);
		lexico.backtraking(Integer.parseInt(Configuracion.posicionActual), Integer.parseInt(Configuracion.filaLexema), Integer.parseInt(Configuracion.columnaLexema));
		Assert.assertEquals(Integer.parseInt(Configuracion.filaLexemaEsperada), lexico.getFilaActual());
		Assert.assertEquals(Integer.parseInt(Configuracion.columnaLexemaEsperada), lexico.getColumnaActual());
		Assert.assertEquals(Integer.parseInt(Configuracion.posicionActualEsperada), lexico.getPosicionActual());
		Assert.assertEquals(Configuracion.caracterActualEsperado.charAt(0), lexico.getCaracterActual());
	}

	@Test
	public void testSigteCaracter() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		char EOC = 0;
		lexico.setCodigoFuente(Configuracion.lexemaSgteCaracter + EOC);
		lexico.setColumnaActual(Integer.parseInt(Configuracion.posicionCaracterActual) + 1);
		lexico.setFilaActual(1);
		lexico.setPosicionActual(Integer.parseInt(Configuracion.posicionCaracterActual));
		lexico.sigteCaracter();

		Assert.assertEquals(Configuracion.caracterSgteEsperado.charAt(0),lexico.getCaracterActual());
		
	}

	@Test
	public void testAlmacenarToken() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		lexico.almacenarToken(Configuracion.lexemaAAlmacenar, Configuracion.tipoLexemaAAlmacenar, 1,1);
		Assert.assertEquals(Integer.parseInt(Configuracion.tamanioTablaDeSimbolosEsperado), lexico.getTablaSimbolos().size());
	}

	@Test
	public void testAlmacenarError() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		lexico.almacenarError(Configuracion.errorAAlmacenar, Configuracion.error, 1,1);
		Assert.assertEquals(Integer.parseInt(Configuracion.tamanioTablaErrores), lexico.getTablaErrores().size());
	}

	@Test
	public void testMostrarTokens() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		lexico.analizar(Configuracion.codigoFuenteMostrarTokens);
		Assert.assertEquals(Integer.parseInt(Configuracion.cantidadTokensEsperados),lexico.mostrarTokens().length);
	}

	@Test
	public void testMostrarTokensError() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		lexico.analizar(Configuracion.codigoFuenteMostrarTokensError);
		Assert.assertEquals(Integer.parseInt(Configuracion.cantidadTokensErrorEsperados),lexico.mostrarTokensError().length);
	}

	@Test
	public void testVerificarTamanioId() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		Assert.assertEquals(Boolean.parseBoolean(Configuracion.valorEsperadoAceptacionLexema), lexico.verificarTamanioId(Configuracion.lexemaVerificarTamanio, Integer.parseInt(Configuracion.TamanioLimite)));
	}

	@Test
	public void testCargarReservadas() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		lexico.cargarReservadas();
		Assert.assertEquals(Integer.parseInt(Configuracion.cantidadEsperadaPalabrasReservadas), lexico.getReservadas().size());
		
	}

	@Test
	public void testCargarReservadasString() {
		AnalizadorLexico lexico = new AnalizadorLexico();
		lexico.cargarReservadas(Configuracion.rutaPReservadas);
		Assert.assertEquals(Integer.parseInt(Configuracion.cantReservadasEsperadas), lexico.getReservadas().size());
	}

	@Test
	public void testCargarCodigo() throws IOException {
		AnalizadorLexico lexico = new AnalizadorLexico();
		String codigo = lexico.cargarCodigo(Configuracion.rutaCodigo);
		int cantidad=0;
		for(int i=0 ; i<codigo.length() ; i++){
			if(codigo.charAt(i) ==' ' | codigo.charAt(i) =='\n' | codigo.charAt(i) =='\t'){
				cantidad++;
			}
		}
		Assert.assertEquals(Integer.parseInt(Configuracion.cantidadLexemas), cantidad);
	}

}
