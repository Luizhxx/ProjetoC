package labirinto;

import java.util.Arrays;

import pilha.Coordenada;
import pilha.Pilha;

public class Labirinto {
	
	private int linhas;
	private int colunas;
	private char[][] labirinto = null;
	private Coordenada atual = null;
	private Pilha<Coordenada> caminho = null;
	
	public Labirinto(String[] arquivo) {
		this.linhas = Integer.parseInt(arquivo[0]);
		this.colunas = arquivo[1].length();
		this.labirinto = new char[this.linhas][this.colunas];
		
		for(int linha = 0; linha < this.linhas; linha++) {
			for(int coluna = 0; coluna < this.colunas; coluna++) {
				this.labirinto[linha][coluna] = arquivo[linha+1].charAt(coluna);
				if(labirinto[linha][coluna] == 'E')
					this.atual = new Coordenada(linha, coluna);
			}
		}
	}
		
	public void encontrarCaminho() throws Exception {
		
		this.caminho = new Pilha<Coordenada>(this.linhas*this.colunas);
		Pilha<Pilha<Coordenada>> possibilidades = new Pilha<Pilha<Coordenada>>(this.linhas*this.colunas);
		Pilha<Coordenada> adjacentes = new Pilha<Coordenada>(3);
		boolean controle = false;
		
		while(this.labirinto[atual.getLinha()][atual.getColuna()] != 'S') {
			
			if(controle == false) {
				adjacentes = new Pilha<Coordenada>(3);
				obterAdjacentes(this.atual, adjacentes);
			}
			
			if(!adjacentes.isVazia()) {
				this.atual = adjacentes.getValor();
				adjacentes.jogueForaValor();
				
				if(labirinto[atual.getLinha()][atual.getColuna()] != 'S')
					labirinto[atual.getLinha()][atual.getColuna()] = '*';
				
				this.caminho.guarde(atual);
				possibilidades.guarde(adjacentes);
				controle = false;
			}
			else {
				while(adjacentes.isVazia()) {
					this.atual = this.caminho.getValor();
					this.labirinto[this.atual.getLinha()][this.atual.getColuna()] = ' ';
					this.caminho.jogueForaValor();
					
					adjacentes = possibilidades.getValor();
					possibilidades.jogueForaValor();
					controle = true;
				}
			}
		}
	}
	
	
	private void obterAdjacentes(Coordenada atual, Pilha<Coordenada> adjacentes) throws Exception{
		
		if(atual.getLinha() == 0) 
		{
			if(this.labirinto[atual.getLinha()+1][atual.getColuna()] == ' ' || 
					this.labirinto[atual.getLinha()+1][atual.getColuna()] == 'S')
			{
				Coordenada auxiliar = new Coordenada(atual.getLinha()+1, atual.getColuna());
				adjacentes.guarde(auxiliar);
			}
		}else
		{
			if(atual.getLinha() == this.linhas-1) 
			{
				if(this.labirinto[atual.getLinha()-1][atual.getColuna()] == ' ' || 
						this.labirinto[atual.getLinha()-1][atual.getColuna()] == 'S')
				{
					Coordenada auxiliar = new Coordenada(atual.getLinha()-1, atual.getColuna());
					adjacentes.guarde(auxiliar);
				}
			}else 
			{
				if(this.labirinto[atual.getLinha()+1][atual.getColuna()] == ' ' || 
						this.labirinto[atual.getLinha()+1][atual.getColuna()] == 'S')
				{
					Coordenada auxiliar = new Coordenada(atual.getLinha()+1, atual.getColuna());
					adjacentes.guarde(auxiliar);
				}else
				{
					if(this.labirinto[atual.getLinha()-1][atual.getColuna()] == ' ' || 
							this.labirinto[atual.getLinha()-1][atual.getColuna()] == 'S')
					{
						Coordenada auxiliar = new Coordenada(atual.getLinha()-1, atual.getColuna());
						adjacentes.guarde(auxiliar);
					}
				}
			}
		}
		
		
		if(atual.getColuna() == 0) {
			if(this.labirinto[atual.getLinha()][atual.getColuna()+1] == ' ' || 
					this.labirinto[atual.getLinha()][atual.getColuna()+1] == 'S'){
				Coordenada auxiliar = new Coordenada(atual.getLinha(), atual.getColuna()+1);
				adjacentes.guarde(auxiliar);
			}
		}else 
		{
			if(atual.getColuna() == (this.colunas-1)) 
			{
				if(this.labirinto[atual.getLinha()][atual.getColuna()-1] == ' ' ||
						this.labirinto[atual.getLinha()][atual.getColuna()-1] == 'S') {
					Coordenada auxiliar = new Coordenada(atual.getLinha(), atual.getColuna()-1);
					adjacentes.guarde(auxiliar);
				}
			}else 
			{
				if(this.labirinto[atual.getLinha()][atual.getColuna()+1] == ' ' ||
						this.labirinto[atual.getLinha()][atual.getColuna()+1] == 'S')
				{
					Coordenada auxiliar = new Coordenada(atual.getLinha(), atual.getColuna()+1);
					adjacentes.guarde(auxiliar);
				}
				if(this.labirinto[atual.getLinha()][atual.getColuna()-1] == ' ' ||
						this.labirinto[atual.getLinha()][atual.getColuna()-1] == 'S')
				{
					Coordenada auxiliar = new Coordenada(atual.getLinha(), atual.getColuna()-1);
					adjacentes.guarde(auxiliar);
				}
			}
		}
	}

 	
	
	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public char[][] getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(char[][] labirinto) {
		this.labirinto = labirinto;
	}

	public Coordenada getAtual() {
		return atual;
	}

	public void setAtual(Coordenada atual) {
		this.atual = atual;
	}

	public Pilha<Coordenada> getCaminho() {
		return caminho;
	}

	public void setCaminho(Pilha<Coordenada> caminho) {
		this.caminho = caminho;
	}

	public void imprimir() {
		for(int x = 0; x < this.linhas; x++) {
			for(int y = 0; y < this.colunas; y++) {
				System.out.print(this.labirinto[x][y] + "");
			}
			System.out.println(" ");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atual == null) ? 0 : atual.hashCode());
		result = prime * result + ((caminho == null) ? 0 : caminho.hashCode());
		result = prime * result + colunas;
		result = prime * result + Arrays.deepHashCode(labirinto);
		result = prime * result + linhas;
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
		Labirinto other = (Labirinto) obj;
		if (atual == null) {
			if (other.atual != null)
				return false;
		} else if (!atual.equals(other.atual))
			return false;
		if (caminho == null) {
			if (other.caminho != null)
				return false;
		} else if (!caminho.equals(other.caminho))
			return false;
		if (colunas != other.colunas)
			return false;
		if (!Arrays.deepEquals(labirinto, other.labirinto))
			return false;
		if (linhas != other.linhas)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Labirinto [linhas=" + linhas + ", colunas=" + colunas + ", labirinto=" + Arrays.toString(labirinto)
				+ ", atual=" + atual + ", caminho=" + caminho + "]";
	}
}
