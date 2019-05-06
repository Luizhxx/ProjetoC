package Servidor;

import java.io.Serializable;
import java.util.Arrays;

public class Musica implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String titulo;
	private String[] cantores;
	private String estilo;
	private String capa;
	private double preco;
	private int tempo;
	
	public Musica(String titulo, String[] cantores, String estilo, 
				String capa, double preco, int tempo)throws Exception {
		
		if(titulo == null || cantores == null || estilo == null ||capa == null
		   || preco == 0 || tempo ==0)
			throw new Exception("Dados invalidos!");
		
		this.titulo = titulo;
		this.cantores = cantores;
		this.estilo = estilo;
		this.capa = capa;
		this.preco = preco;
		this.tempo = tempo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String[] getCantores() {
		return cantores;
	}


	public void setCantores(String[] cantores) {
		this.cantores = cantores;
	}


	public String getEstilo() {
		return estilo;
	}


	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}


	public String getCapa() {
		return capa;
	}


	public void setCapa(String capa) {
		this.capa = capa;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public int getTempo() {
		return tempo;
	}


	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cantores);
		result = prime * result + ((estilo == null) ? 0 : estilo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + tempo;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (!Arrays.equals(cantores, other.cantores))
			return false;
		if (estilo == null) {
			if (other.estilo != null)
				return false;
		} else if (!estilo.equals(other.estilo))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (tempo != other.tempo)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Musica [titulo=" + titulo + ", cantores=" + Arrays.toString(cantores) + ", estilo=" + estilo
				+ ", preco=" + preco + ", tempo=" + tempo + "]";
	}
	
	
}
