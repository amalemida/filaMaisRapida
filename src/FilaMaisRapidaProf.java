

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FilaMaisRapidaProf <X> implements Cloneable
	{
	    private Object[] elemento; //private X[] elemento;
	    private int      tamanhoInicial;
	    private int      ultimo=-1; //vazio
	    private int 	primeiro = 0;
		private int 	inicio;
		private int 	qtde;
		private int 	fim;


	    public FilaMaisRapidaProf(int tamanho) throws Exception
	    {
	        if (tamanho<=0)
	            throw new Exception ("Tamanho invalido");

	        this.elemento       = new Object [tamanho]; //this.elemento=new X [tamanho];
	        this.tamanhoInicial = tamanho;
	    }

	    public FilaMaisRapidaProf ()
	    {
	        this.elemento       = new Object [10]; //this.elemento=new X [10];
	        this.tamanhoInicial = 10;
	    }

	    private void redimensioneSe (float fator)
	    {
	        // X[] novo = new X [Math.round(this.elemento.length*fator)];
	        Object[] novo = new Object [Math.round(this.elemento.length*fator)];

	        for(int i=0; i<=this.ultimo; i++)
	            novo[i] = this.elemento[i];

	        this.elemento = novo;
	    }

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

	    public void guardeUmItem (X x) throws Exception // LIFO
	    {
	        if (x==null)
	            throw new Exception ("Falta o que guardar");

	        if (this.ultimo+1==this.elemento.length) // cheia
	            this.redimensioneSe (2.0F);

	        this.ultimo++;

	        if (x instanceof Cloneable)
	            this.elemento[this.ultimo]=meuCloneDeX(x);
	        else
	            this.elemento[this.ultimo]=x;
	    }

	    public X recupereUmItem () throws Exception // LIFO
	    {
	        if (this.ultimo==-1) // vazia
	            throw new Exception ("Nada a recuperar");

	        X ret=null;
	        if (this.elemento[this.ultimo] instanceof Cloneable)
	            ret = meuCloneDeX((X)this.elemento[this.primeiro]);
	        else
	            ret = (X)this.elemento[this.primeiro];

	        return ret;
	    }

	    public void removaUmItem () throws Exception // LIFO
	    {
	        if (this.ultimo==-1) // vazia
	            throw new Exception ("Nada a remover");

	        for (int i=this.inicio, j=0;j <=this.qtde; i= i < this.elemento.length? i++: 0, j++ ){
				
			}
			this.elemento[this.ultimo] = null;
			this.ultimo--;

	        if (this.elemento.length>this.tamanhoInicial &&
	                this.ultimo+1<=Math.round(this.elemento.length*0.25F))
	            this.redimensioneSe (0.5F);
	    }

	    public boolean isCheia ()
	    {
	        if(this.ultimo+1==this.elemento.length)
	            return true;

	        return false;
	    }

	    public boolean isVazia ()
	    {
	        if(this.ultimo==-1)
	            return true;

	        return false;
	    }

	    public String debugString ()
	    {
	        String ret = (this.ultimo+1) + " elemento(s)";

	        if (this.ultimo!=-1){
	            ret += ": (";
	            for (int i = 0; i < this.ultimo+1; i++) {
	                ret+= this.elemento[i].toString() + ",";
	            }
	        }

	        return ret+")";
	    }

	    public String toString ()
	    {
	        String ret = (this.ultimo+1) + " elemento(s)";

	        if (this.ultimo!=-1)
	            ret += ", sendo o ultimo "+this.elemento[this.ultimo] + ", sendo o primeiro "+this.elemento[this.primeiro];

	        return ret;
	    }

	    public boolean equals (Object obj)
	    {
	        if(this==obj)
	            return true;

	        if(obj==null)
	            return false;

	        if(this.getClass()!=obj.getClass())
	            return false;

	        FilaMaisRapidaProf<X> pil = (FilaMaisRapidaProf<X>) obj;

	        if(this.ultimo!=pil.ultimo)
	            return false;
	        if(this.primeiro!=pil.primeiro)
	            return false;

	        if(this.tamanhoInicial!=pil.tamanhoInicial)
	            return false;

	        for(int i=0 ; i<this.ultimo;i++)
	            if(!this.elemento[i].equals(pil.elemento[i]))
	                return false;

	        return true;
	    }

	    public int hashCode ()
	    {
	        int ret=666/*qualquer positivo*/;

	        ret = ret*7/*primo*/ + Integer.valueOf(this.ultimo        ).hashCode();
	        ret = ret*7/*primo*/ + Integer.valueOf(this.tamanhoInicial).hashCode();

	        for (int i=0; i<this.ultimo; i++)
	            ret = ret*7/*primo*/ + this.elemento[i].hashCode();

	        if (ret<0)
	            ret=-ret;

	        return ret;
	    }

	    // construtor de copia
	    public FilaMaisRapidaProf (FilaMaisRapidaProf<X> modelo) throws Exception
	    {
	        if(modelo == null)
	            throw new Exception("Modelo ausente");

	        this.tamanhoInicial = modelo.tamanhoInicial;
	        this.ultimo         = modelo.ultimo;

	        // para fazer a copia dum vetor
	        // precisa criar um vetor novo, com new
	        // nao pode fazer this.elemento=modelo.element
	        // pois se assim fizermos estaremos com dois
	        // objetos, o this e o modelo, compartilhando
	        // o mesmo vetor
	        this.elemento = new Object[modelo.elemento.length]; // this.elemento = new X [modelo.elemento.length];

	        for(int i=0 ; i<modelo.elemento.length ; i++)
	            this.elemento[i] = modelo.elemento[i];
	    }

	    public Object clone ()
	    {
	        FilaMaisRapidaProf<X> ret=null;

	        try
	        {
	            ret = new FilaMaisRapidaProf<X>(this);
	        }
	        catch(Exception erro)
	        {}

	        return ret;
	    }
	}
