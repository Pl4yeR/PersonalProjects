package org.jdomingo.traductorwr;

public class Traduccion {
	
	private String termino;
	private String traduccion;
	private String contexto;
	private String uso;
	
	public Traduccion(String termino, String traduccion, String contexto, String uso){
		this.termino = termino;
		this.traduccion = traduccion;
		this.contexto = contexto;
		this.uso = uso;
	}

	public String getTermino() {
		return termino;
	}

	public void setTermino(String termino) {
		this.termino = termino;
	}

	public String getTraduccion() {
		return traduccion;
	}

	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

}
