package dbo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "musicas")
public class Musicas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String titulo;
	@NotNull
	private String cantores;
	@NotNull
	private String estilo;
	private String capa;
	@NotNull
	private double preco;
	@NotNull
	private int tempo;

	public Musicas() {
	}

	public Musicas(String titulo, String cantores, String estilo, String capa, double preco, int tempo) {
		this.titulo = titulo;
		this.cantores = cantores;
		this.estilo = estilo;
		this.capa = capa;
		this.preco = preco;
		this.tempo = tempo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCantores() {
		return cantores;
	}

	public void setCantores(String cantores) {
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
		result = prime * result + ((cantores == null) ? 0 : cantores.hashCode());
		result = prime * result + ((capa == null) ? 0 : capa.hashCode());
		result = prime * result + ((estilo == null) ? 0 : estilo.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Musicas other = (Musicas) obj;
		if (cantores == null) {
			if (other.cantores != null)
				return false;
		} else if (!cantores.equals(other.cantores))
			return false;
		if (capa == null) {
			if (other.capa != null)
				return false;
		} else if (!capa.equals(other.capa))
			return false;
		if (estilo == null) {
			if (other.estilo != null)
				return false;
		} else if (!estilo.equals(other.estilo))
			return false;
		if (id != other.id)
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
		return "Musicas [id=" + id + ", titulo=" + titulo + ", cantores=" + cantores + ", estilo=" + estilo + ", capa="
				+ capa + ", preco=" + preco + ", tempo=" + tempo + "]";
	}

	
}
