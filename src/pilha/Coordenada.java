package pilha;

public class Coordenada<Linha, Coluna> { 
	private Linha linha; 
	private Coluna coluna; 
	
	public Coordenada(Linha x, Coluna y)
	{ 
		this.linha = x; 
		this.coluna = y; 
	}
	
	public Linha getLinha() {
		return linha;
	}


	public void setLinha(Linha linha) {
		this.linha = linha;
	}


	public Coluna getColuna() {
		return coluna;
	}


	public void setColuna(Coluna coluna) {
		this.coluna = coluna;
	}


	public void setY(Coluna y) {
		this.coluna = y;
	}


	@Override
	public String toString() {
		return "Coordenada [linha= " + linha + ", coluna= " + coluna + "]";
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		if (coluna == null) {
			if (other.coluna != null)
				return false;
		} else if (!coluna.equals(other.coluna))
			return false;
		if (linha == null) {
			if (other.linha != null)
				return false;
		} else if (!linha.equals(other.linha))
			return false;
		return true;
	}
	
	
	
	
} 