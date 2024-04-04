package filaComPrioridade;
import fila.Fila;
public class FilaComPrioridade<T> extends Fila<T>{
    public FilaComPrioridade(int capacidade){
        super(capacidade);
    }
    public FilaComPrioridade(){
        super();
    }
    @Override
    public void enfileira(T elemento) {
        Comparable<T> comparableElement = (Comparable<T>) elemento;
        int i=0;
        for ( i = 0; i < this.tamanho; i++) {
            //se menor que elementos[i] adicionar elemento na [i]
            if(comparableElement.compareTo(this.elementos[i])<0){
                this._adicionarElemento(elemento, i);
                break;
            }
        }
        this._adicionarElemento(elemento, i);
    }
}
