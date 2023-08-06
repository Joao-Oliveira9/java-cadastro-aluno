package armazenador;
import java.io.Serializable;
/**
 * ListaLigadaSimples. Ed para Lista Ligada simples
 * 
 * @author Joao Pedro de Souza Oliveira
 * @version 1.0 2023/05/15
 */
public class ListaLigadaSimples implements IArmazenador, Serializable
{
    No inicio, fim;
    int qtdNos;

    /**
     * ListaLigadaSimples Construtor
     *
     */
    public ListaLigadaSimples(){
        setInicio(null);
        setFim(null);
        setQtdNos(0);
    }
    public int getQtd()
    {
        int qtd = getQtdNos();
        return qtd;
    }
    public Object buscar (int i)
    {
        Object ret = null;
        int k = 0;
            
        if (!estaVazia())
        {
            No elemento = getInicio();
            while(elemento != null && k < i)
            {
                elemento = elemento.getProximo();
                k++;
            }
            if (k == i)
            {
                ret = elemento.getConteudo();
            }
        }
        
        return ret;
    }
    public Object remover(int i)
    {
         //No remover = new No();
         Object ret = null;
         No suc = getInicio();
         No anterior = null;
         No aux = null;
         int k = 0;
         
        if (!estaVazia())
        {
            if (i == 0)
            {
                ret = removerInicio();
            }
            else
            {
                while(suc != getFim() && k != i)
                {
                    anterior = suc;
                    suc = suc.getProximo();
                    k++;
                }
                if (suc == fim && i == k) //remove no fim da lista
                {
                    ret = removerFim();
                }
                else if (k == i) //remove no meio da lista
                {
                    anterior.setProximo(suc.getProximo());
                    setQtdNos(getQtd() - 1);
                    aux = getInicio();
                    ret = aux.getConteudo();
                }
            }
        }

        return ret;
    }
    
    public void adicionar(Object a)
    {
        No novo = new No(a);
        
        if (estaVazia()){
            setInicio(novo);
            setFim(novo);
        }
        else{
            getFim().setProximo(novo);
            setFim(novo);
        }
        setQtdNos(getQtdNos() + 1);
    }

    /**
     * setInicio
     *
     * @param inicio No inicio da lista ligada
     */
    private void setInicio(No inicio)
    {
        this.inicio = inicio;
    }

    /**
     * getInicio
     *
     * @return No de inicio da lista ligada
     */
    public No getInicio(){
        return(this.inicio);
    }

    /**
     * getFim
     *
     * @return No do final da lista ligada
     */
    public No getFim(){
        return(this.fim);
    }

    /**
     * setFim
     *
     * @param fim No fim da lista ligada
     */
    private void setFim(No fim){
        this.fim = fim;
    }

    /**
     * getQtdNos
     *
     * @return int, qtde de nos na lista ligada
     */
    public int getQtdNos(){
        return this.qtdNos;
    }

    /**
     * setQtdNos
     *
     * @param qtdNos Um parâmetro
     */
    private void setQtdNos(int qtdNos){
        this.qtdNos = qtdNos;
    }

    /**
     * estaVazia
     *
     * @return boolean, true se estiver vazia e false caso contrario
     */
    public boolean estaVazia(){
        boolean vazia = false; 
        
        if (getQtdNos() == 0 && getInicio() == null && getFim() == null){
            vazia = true;
        }
        return vazia;
    }

    /**
     * inserirInicio
     *
     * @param elem Objeto a ser inserido no inicio da lista ligada
     */
    public void inserirInicio(Object elem) {
        No novo = new No(elem); //1

        if (estaVazia()){
            setInicio(novo);
            setFim(novo);
        }
        else{
            novo.setProximo(inicio);
            setInicio(novo);
        }
        setQtdNos(getQtdNos() + 1);
    }

    /**
     * inserirFim
     *
     * @param elem Objeto a ser inserido no fim da lista ligada
     */
    public void inserirFim(Object elem){
        No novo = new No(elem);
        if (estaVazia()){
            setInicio(novo);
            setFim(novo);
        }
        else{
            getFim().setProximo(novo);
            setFim(novo);
        }
        setQtdNos(getQtdNos() + 1);
    }

    /**
     * removerInicio
     *
     * @return Objeto removido
     */
    public Object removerInicio(){
        No aux = null;
        Object obj = null; 
        if(!estaVazia()){
            if ((getInicio() == getFim())){
                aux = getInicio();
                setInicio(null);
                setFim(null);
            } else {
                aux = getInicio();
                setInicio(aux.getProximo());
                aux.setProximo(null);
            }
            setQtdNos(getQtdNos() - 1);
            obj = aux.getConteudo();
        }

        return(obj);
    }

    /**
     * removerFim
     *
     * @return Objeto removido
     */
    public Object removerFim(){
        No ant = getInicio();
        No aux = null;
        Object obj = null; 
        if (!estaVazia()){
            if ((getInicio() == getFim())){
                aux = getInicio();
                setInicio(null);
                setFim(null);
            } else {            
                // percorre ate achar o no antes do fim
                while(ant.getProximo() != fim){
                    ant = ant.getProximo();
                }
                ant.setProximo(null);
                aux = fim;
                setFim(ant);
            }
            setQtdNos(getQtdNos() - 1);
            obj = aux.getConteudo();           
        }
        return obj;
    }
}