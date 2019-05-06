package Servidor;

public class Comunicado {
	private String comando;
	private Object musica;
	
	public Comunicado(String comando, Object musica) throws Exception {
		
		if(comando == null || comando == "")
			throw new Exception("Comando ausente");
		if(musica.equals(null))
			throw new Exception("Musica ausente");
		
		this.comando = comando;
		this.musica = musica;
	}
	
	public Comunicado(String comando) throws Exception {
		
		if(comando == null || comando == "")
			throw new Exception("Comando ausente");
		
		this.comando = comando;
	}

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public Object getMusica() {
		return musica;
	}

	public void setMusica(Object musica) {
		this.musica = musica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comando == null) ? 0 : comando.hashCode());
		result = prime * result + ((musica == null) ? 0 : musica.hashCode());
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
		Comunicado other = (Comunicado) obj;
		if (comando == null) {
			if (other.comando != null)
				return false;
		} else if (!comando.equals(other.comando))
			return false;
		if (musica == null) {
			if (other.musica != null)
				return false;
		} else if (!musica.equals(other.musica))
			return false;
		return true;
	}
}
