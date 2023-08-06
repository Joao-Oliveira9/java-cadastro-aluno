package armazenador;
import java.io.Serializable;
/**
 * No de uma lista ligada.
 * 
 * @author Joao Pedro de Souza Oliveira
 * @version 1.0 2023/05/15
 */
public class No implements Serializable{
    /**
     * Atributos
     */
    Object conteudo; // conteudo
    No proximo; // proximo
    int id; //id de cada no

    /**
     * No Construtor
     *
     * @param conteudo Object a ser inserido no no
     */
    public No(Object conteudo){
        setConteudo(conteudo);
        setProximo(null);
        setID(0);
    }
    /**
     * setters e getters
     */
    public void setConteudo(Object conteudo){
        this.conteudo = conteudo;
    }
    
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    
    public void setID(int id)
    {
        this.id = id;
    }
    
    public int getID()
    {
        return this.id; 
    }
    public Object getConteudo(){
        return(this.conteudo);
    }
    
    public No getProximo(){
        return(this.proximo);
    }
    public String toString(){
        return(conteudo.toString());
    }
}
