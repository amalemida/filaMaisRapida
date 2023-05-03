import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FilaCircular<X> implements Cloneable {
    private int capacidade;
    private int fim;
    private int inicio;
    private int qtde;
    private Object[] elemento;

    public FilaCircular() throws Exception {
        this(10);
    }

    public FilaCircular(int capacidade) throws Exception {
        if (capacidade <= 0)
            throw new Exception("Capacidade inválida");

        this.capacidade = capacidade;
        this.qtde = 0;
        this.inicio = 0;
        this.fim = 0;
        this.elemento = (Object[]) new Object[capacidade];
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

    public void guardeUmItem(X x) throws Exception {
        if (x == null)
            throw new Exception("Não tem o que guardar");

        if (this.fim + 1 == this.elemento.length) // cheia
            this.redimensioneSe(2.0F);
        this.fim++;

        if(x instanceof Cloneable)
            this.elemento[this.fim] = meuCloneDeX(x);
        else 
            this.elemento[this.fim] = x;
        this.fim = (this.fim + 1) % this.capacidade;
        this.qtde++;
    
    }

    public X removaUmItem() {
        if (estaVazia()) {
            throw new RuntimeException("Nada a remover");
        }
        X ret = (X) this.elemento[this.inicio];
        this.inicio = (this.inicio + 1) % this.capacidade;
        this.qtde--;
        return ret;
    }

    public X recupereUmItem() {
        if (estaVazia()) {
            throw new RuntimeException("Nada a recuperar");
        }
        return (X) this.elemento[this.inicio];
    }

    public void redimensioneSe(float fator) {
        if (fator < this.qtde) {
            throw new RuntimeException("Nova capacidade menor que a quantidade atual");
        }
        Object[] novo = new Object[Math.round(this.elemento.length * fator)];
        for (int i = 0; i < this.qtde; i++) {
            novo[i] = this.elemento[(this.inicio + i) % this.capacidade];
        }
        this.inicio = 0;
        this.fim = this.qtde;
        this.capacidade = (int) fator;
        this.elemento = novo;
    }

    public String toString() {
        String saida = "";
        for (int i = 0; i < this.qtde; i++) {
            int indice = (this.inicio + i) % this.capacidade;
            saida += this.elemento[indice] + " ";
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
        FilaCircular<X> outra = (FilaCircular<X>) obj;
        if (outra.qtde != this.qtde) {
            return false;
        }
        for (int i = 0; i < this.qtde; i++) {
            int indice = (this.inicio + i) % this.capacidade;
            if (!this.elemento[indice].equals(outra.elemento[indice])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int hashCode = 666;
        for (int i = 0; i < this.qtde; i++) {
            int indice = (this.inicio + i) % this.capacidade;
            hashCode += this.elemento[indice].hashCode();
        }
        return hashCode;
    }

    private X meuCloneDeX(X x) {
        X ret = null;

        try {
            Class<?> classe = x.getClass();
            Class<?>[] tipoDosParms = null;
            Method metodo = classe.getMethod("clone", tipoDosParms);
            Object[] parms = null;
            ret = (X) metodo.invoke(x, parms);
        }
        catch (NoSuchMethodException erro) 
        {}
        catch (IllegalAccessException erro) 
        {}
        catch (InvocationTargetException erro)
        {}

        return ret;
    }

    public void estadoDaFila() {
        if (estaVazia())
            System.out.println("\nA Fila está vazia!\n");
        else
            System.out.println("\nA fila está cheia!\n");

    }
   
}
