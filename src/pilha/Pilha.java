package pilha;
import java.util.Arrays;

@SuppressWarnings({ "unchecked", "hiding" })
public class Pilha <Coordenada>
{
    private Coordenada[] vetor;
    private int ultimo;

	public Pilha (int tamanho) throws Exception
    {
        if (tamanho<1)
            throw new Exception ("Tamanho invalido");

        this.ultimo = -1;
        this.vetor  = (Coordenada[])new Object [tamanho];
    }

    // push
    public void guarde (Coordenada valor) throws Exception
    {
        if (valor==null)
            throw new Exception ("Valor ausente");

        if (this.ultimo==this.vetor.length-1)
            throw new Exception ("Nao cabe mais");

        this.ultimo++;
        this.vetor[this.ultimo] = valor;
    }

    // pop
    public void jogueForaValor () throws Exception
    {
        if (this.ultimo==-1)
            throw new Exception ("Nada guardado");

        this.vetor[this.ultimo] = null;
        this.ultimo--;
    }

    // peek
    public Coordenada getValor () throws Exception
    {
        if (this.ultimo==-1)
            throw new Exception ("Nada guardado");

        return this.vetor[this.ultimo];
    }

    // isEmpty
    public boolean isVazia ()
    {
        return this.ultimo==-1;
    }

    // isFull
    public boolean isCheia ()
    {
        return this.ultimo==this.vetor.length-1;
    }

    // size
    public int getQuantos ()
    {
        return this.ultimo+1;
    }  

    public String toString ()
    {
        return (this.ultimo+1)+
               " elemento(s)"+
               (this.ultimo!=-1?", sendo o ultimo "+this.vetor[this.ultimo]:"");
    }

    @SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pilha other = (Pilha) obj;
		if (ultimo != other.ultimo)
			return false;
		if (!Arrays.equals(vetor, other.vetor))
			return false;
		return true;
	}

    
}