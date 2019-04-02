package pilha;
import java.util.Arrays;

@SuppressWarnings({ "unchecked", "hiding" })
public class Pilha <Item>
{
    private Item[] vetor;
    private int ultimo;

	public Pilha (int tamanho) throws Exception
    {
        if (tamanho<1)
            throw new Exception ("Tamanho invalido");

        this.ultimo = -1;
        this.vetor  = (Item[])new Object [tamanho];
    }

    // push
    public void guarde (Item valor) throws Exception
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
    public Item getValor () throws Exception
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ultimo;
		result = prime * result + Arrays.hashCode(vetor);
		return result;
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
		Pilha other = (Pilha) obj;
		if (ultimo != other.ultimo)
			return false;
		if (!Arrays.equals(vetor, other.vetor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pilha [vetor=" + Arrays.toString(vetor) + "]";
	}

}