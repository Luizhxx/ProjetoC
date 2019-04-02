package pilha;

public class Coordenada { 
	private int linha; 
	private int coluna; 
	
	public Coordenada(int linha, int coluna)
	{ 
		this.linha = linha; 
		this.coluna = coluna; 
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coluna;
		result = prime * result + linha;
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
		Coordenada other = (Coordenada) obj;
		if (coluna != other.coluna)
			return false;
		if (linha != other.linha)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordenada (" + linha + ", " + coluna + ")";
	}
	
} 