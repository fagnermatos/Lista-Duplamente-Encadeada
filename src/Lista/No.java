package Lista;

public class No<E> {
	
	
	private E elemento;
	private No<E> proximo;
	private No<E> anterior;
	
	public No(E elemento, No<E> proximo, No<E> anterior) {
		this.elemento = elemento;
		this.proximo = proximo;
		this.anterior = anterior;
	}

	public E getElemento() {
		return elemento;
	}

	public void setElemento(E elemento) {
		this.elemento = elemento;
	}

	public No<E> getProximo() {
		return proximo;
	}

	public void setProximo(No<E> proximo) {
		this.proximo = proximo;
	}

	public No<E> getAnterior() {
		return anterior;
	}

	public void setAnterior(No<E> anterior) {
		this.anterior = anterior;
	}


	
}
