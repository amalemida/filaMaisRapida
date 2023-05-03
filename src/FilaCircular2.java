import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FilaCircular2<X> implements Cloneable {
    // implementar fila circular com classe generica
    // imlementar metodos hashcode e equals
    // imlementar metodos toString
    // imlementar metodos de insercao e remocao e recuperação
    // implementar cloneable
    // essa classe não será a main
    // incluir comentáqrios sobre o que faz cada um dos metodos

    private int inicio;
    private int fim;
    private int qtde;
    private Object[] elementos;
    private int capacidade;
   // private int qtdeMaximo;

    public FilaCircular2() {
        this(5);
    }
 
    public FilaCircular2(int capacidade) {
        this.capacidade = capacidade;
      //  this.qtdeMaximo = capacidade;
        this.qtde = 0;
        this.inicio = 0;
        this.fim = 0;
        this.elementos = (Object[]) new Object[capacidade];
    }

    public int qtde() {
        return this.qtde;
    }

    public boolean estaVazia() {

        return this.qtde == 0;
    }

    public boolean estaCheia() {
        return this.qtde == this.capacidade;
    }

    public void enfileirar(X elemento) {
        if (estaCheia()) {
            throw new RuntimeException("Fila cheia");
        }
        this.elementos[this.fim] = elemento;
        this.fim = (this.fim + 1) % this.capacidade;
        this.qtde++;
    }

    public X desenfileirar() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        X elemento = (X) this.elementos[this.inicio];
        this.inicio = (this.inicio + 1) % this.capacidade;
        this.qtde--;
        return elemento;
    }

    public X recuperar() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        return (X) this.elementos[this.inicio];
    }

    public void redimensionar(int novaCapacidade) {
        if (novaCapacidade < this.qtde) {
            throw new RuntimeException("Nova capacidade menor que a quantidade atual");
        }
        Object[] elementosNovos = (Object[]) new Object[novaCapacidade];
        for (int i = 0; i < this.qtde; i++) {
            elementosNovos[i] = this.elementos[(this.inicio + i) % this.capacidade];
        }
        this.inicio = 0;
        this.fim = this.qtde;
        this.capacidade = novaCapacidade;
        this.elementos = elementosNovos;
    }

    public X primeiro() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        return (X) this.elementos[this.inicio];
    }

    public X ultimo() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        return (X) this.elementos[this.fim - 1];
    }

    public String toString() {
        String saida = "";
        for (int i = 0; i < this.qtde; i++) {
            int indice = (this.inicio + i) % this.capacidade;
            saida += this.elementos[indice] + " ";
        }
        return saida;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        FilaCircular2<X> outra = (FilaCircular2<X>) obj;
        if (outra.qtde != this.qtde) {
            return false;
        }
        for (int i = 0; i < this.qtde; i++) {
            int indice = (this.inicio + i) % this.capacidade;
            if (!this.elementos[indice].equals(outra.elementos[indice])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int hashCode = 666;
        for (int i = 0; i < this.qtde; i++) {
            int indice = (this.inicio + i) % this.capacidade;
            hashCode += this.elementos[indice].hashCode();
        }
        return hashCode;
    }

    // public FilaCircular2<X> clone() {
    //     try {
    //         FilaCircular2<X> clone = (FilaCircular2<X>) super.clone();
    //         clone.elementos = this.elementos.clone();
    //         return clone;
    //     } catch (CloneNotSupportedException e) {
    //         return null;
    //     }
    // }
    private X meuCloneDeX (X x)
    {
        X ret=null;

        try
        {
            Class<?> classe         = x.getClass();
            Class<?>[] tipoDosParms = null;
            Method metodo           = classe.getMethod("clone",tipoDosParms);
            Object[] parms          = null;
            ret                     = (X)metodo.invoke(x,parms);
        }
        catch(NoSuchMethodException erro)
        {}
        catch(IllegalAccessException erro)
        {}
        catch(InvocationTargetException erro)
        {}

        return ret;
    }
    public void estadoDaFila() {
        if(estaVazia())
            System.out.println("\nA Fila está vazia!\n" );
        else
            System.out.println("\nA fila está cheia!\n");

    }

    public static void main(String[] args) {
        Cronometro c = new Cronometro();
        System.out.println("Enfileirando.");
        FilaCircular2<Integer> fila = new FilaCircular2<Integer>(1000000);
        for (int i = 1; i <= 1000000; i++) {
            fila.enfileirar(i);
        }
        fila.estadoDaFila();
     
        System.out.println("Desenfileirando...");
        c.iniciar();
        for (int i = 1; i <= 1000000; i++) {
         //   System.out.print(fila.recuperar());
           fila.desenfileirar();
        }
        fila.estadoDaFila();
        
        c.parar();

        if(fila.estaVazia()){
                System.out.println("\nEnfileirando novamente.");
                for (int i = 1; i <= 1000000; i++) {
                fila.enfileirar(i);
            }
        }
        fila.estadoDaFila();
    }

}
