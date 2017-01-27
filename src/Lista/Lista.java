package Lista;

public class Lista<E> {

	private No<E> header;
	private No<E> trailer;
	private int tamanho;
	

	public Lista() {
		header = new No<E>(null,trailer,null);
		trailer = new No<E>(null,null,header);
		tamanho = 0;
	}
	
	public void addLista(E elemento){
		No<E> novoElemento = new No<E>(elemento,trailer,null);
		
		novoElemento.setAnterior(trailer.getAnterior());
		novoElemento.setProximo(trailer);
		trailer.getAnterior().setProximo(novoElemento);
		trailer.setAnterior(novoElemento);
		tamanho++;
		
	}
	
	
	public E getElemento(int pos){
		++pos;
		if(listaVazia()){
			System.out.println("Lista Vazia");
			return null;
		}
		if(pos < -1 || pos > tamanho+1){
			System.out.println("Po��o invalida");
			return null;
		}
		No<E> aux = header;
		for(int i = 1; i <= pos;i++){
			aux = aux.getProximo();
		}
		
		return aux.getElemento();
	}
	
	public void removeLista(int pos){
		++pos;
		if(listaVazia()){
			System.out.println("Lista Vazia");
			return;
		}
		if(pos < -1 || pos > tamanho+1){
			System.out.println("Po��o invalida");
			return;
		}
		No<E> aux = header;
		for(int i = 1; i <= pos;i++){
			aux = aux.getProximo();
		}
	
		aux.getAnterior().setProximo(aux.getProximo());
		aux.getProximo().setAnterior(aux.getAnterior());
		aux.setAnterior(null);
		aux.setProximo(null);	
		tamanho--;
	}
	
	public void setElemento(int pos, E elemento){
		No<E> novoElemento = new No<E>(elemento,null,null);
		++pos;
		if(listaVazia()){
			System.out.println("Lista Vazia");
			return;
		}
		if(pos < -1 || pos > tamanho+1){
			System.out.println("Po��o invalida");
			return;
		}
		No<E> aux = header;
		for(int i = 1; i <= pos;i++){
			aux = aux.getProximo();
		}
		novoElemento.setProximo(aux.getProximo());
		novoElemento.setAnterior(aux.getAnterior());
		aux.getAnterior().setProximo(novoElemento);
		aux.getProximo().setAnterior(novoElemento);
		aux.setAnterior(null);
		aux.setProximo(null);
		
		
	}
	
	
	public boolean listaVazia(){
		if(tamanho==0){
			return true;
		}
		return false;
	}
	
	//Gets e Setters
	public No<E> getHeader() {
		return header;
	}
	public void setHeader(No<E> header) {
		this.header = header;
	}
	public No<E> getTrailer() {
		return trailer;
	}
	public void setTrailer(No<E> trailer) {
		this.trailer = trailer;
	}
	public int sizeLista() {
		return tamanho;
	}
	
	public void imprimir(){
		if(listaVazia()){
			System.out.println("[]");
			return;
		}
		No<E> aux = header;
		String lista = "";
		for(int i = 1; i <= tamanho ; i++){
			aux = aux.getProximo();
			lista += "["+aux.getElemento()+"]";
		}
		System.out.println(lista);
	}
	
	
	public boolean equalsLista(Lista<Integer> c1 ,  Lista<Integer> c2){
		int qtd = 0;
		if(c1.sizeLista() != c2.sizeLista()){
			return false;
		}
		
		Lista<Integer> copy1 = new Lista<Integer>();
		Lista<Integer> copy2 = new Lista<Integer>();
		for (int i = 0; i < c1.sizeLista(); i++) {
			copy1.addLista(c1.getElemento(i));
			copy2.addLista(c2.getElemento(i));
		}
		
		
		
		for (int i = 0; i < copy1.sizeLista(); i++) {
			for (int j = 0; j < copy2.sizeLista(); j++) {
				if(copy1.getElemento(i) == copy2.getElemento(j)){
					qtd++;
					copy1.removeLista(i);
					copy2.removeLista(j);
					i--;
					j--;
				}
			}
		}
		if(qtd == c1.sizeLista()){
		//	System.out.println(qtd + " " + c1.sizeLista() +" " + c2.sizeLista());
			return true;
		}
		return false;
	}
	
}


