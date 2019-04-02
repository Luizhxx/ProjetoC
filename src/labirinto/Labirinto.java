package labirinto;

import pilha.Coordenada;
import pilha.Pilha;

public class Labirinto {
	
	private int linhas;
	private int colunas;
	private char[][] labirinto = null;
	private Coordenada atual = null;
	private Pilha<Coordenada> caminho = null;
	Pilha<Pilha<Coordenada>> possibilidades= null;
	Pilha<Coordenada> adjacentes = null;
	
	
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
		this.caminho = new Pilha<Coordenada>((this.linhas*this.colunas));
		this.possibilidades = new Pilha<Pilha<Coordenada>>((this.linhas*this.colunas));	
		this.adjacentes = new Pilha<Coordenada>(3);
		boolean controle = true;
		
		while(labirinto[atual.getLinha()][atual.getColuna()] != 'S') {
			if(controle)
				controle = progredir();
			else
				controle = !regredir();
			
			imprimir();
		}
	
	}
	
	private boolean progredir() throws Exception {
		
		if(this.adjacentes.isVazia()) {
			Pilha<Coordenada> auxiliar = new Pilha<Coordenada>(3);
			obterAdjacentes(this.atual, auxiliar);
			if(auxiliar.isVazia()) {
				return false;
			}else {
				this.atual = auxiliar.getValor();
				this.caminho.guarde(atual);
				
				if(labirinto[atual.getLinha()][atual.getColuna()] != 'S')
					this.labirinto[this.atual.getLinha()][this.atual.getColuna()] = '*';
				
				auxiliar.jogueForaValor();
				this.possibilidades.guarde(auxiliar);
				return true;
			}
		}else {
			this.atual = this.adjacentes.getValor();
			this.caminho.guarde(atual);
			
			if(labirinto[atual.getLinha()][atual.getColuna()] != 'S')
				this.labirinto[this.atual.getLinha()][this.atual.getColuna()] = '*';
			
			this.adjacentes.jogueForaValor();
			this.possibilidades.guarde(this.adjacentes);
			return true;
		}
	}
	
	private boolean regredir() throws Exception {
		
		if(this.adjacentes.isVazia()) {
			this.adjacentes = this.possibilidades.getValor();
			this.possibilidades.jogueForaValor();
			this.labirinto[this.atual.getLinha()][this.atual.getColuna()] = ' ';
			
			if(this.adjacentes.isVazia()) {
				this.caminho.jogueForaValor();
				this.atual = this.caminho.getValor();
				return true;
			}else {
				return false;
			}
		}else {
			return false;
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
				{
					if(this.labirinto[atual.getLinha()][atual.getColuna()-1] == ' ' ||
							this.labirinto[atual.getLinha()][atual.getColuna()-1] == 'S')
					{
						Coordenada auxiliar = new Coordenada(atual.getLinha(), atual.getColuna()-1);
						adjacentes.guarde(auxiliar);
					}
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
	public String toString() {
		return "Labirinto [possibilidades=" + possibilidades + "]";
	}
}
