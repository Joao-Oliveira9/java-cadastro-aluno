package pessoa;
import java.io.Serializable;
/**
 * Definicao dos atributos de pessoa
 * 
 * @author  Joao Pedro de Souza Oliveira
 * 21/04/2023
 */
public class Pessoa implements Serializable
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private NomePessoa nome;
    int idade;
    
    /**
     * Pessoa chamado para instanciar uma pessoa
     *
     * @param nome String, nome da pessoa
     * @param idade int, idade da pessoa
     */
    public Pessoa(String nome, int idade)
    {
        setNome(nome);
        setIdade(idade);
    }
    
    //set e getters
    /**
     * setNome - atualiza nome
     *
     * @param nome NomePessoa, objeto da classe NomePessoa
     */
    private void setNome(String nome)
    {
        this.nome = new NomePessoa(nome);
    }
    
    /**
     * getNome - retorna nome
     *
     * @return nome da pessoa, Objeto da classe NomePessoa
     */
    public NomePessoa getNome()
    {
        return this.nome;
    }
    
    /**
     * setIdade - atualiza idade
     *
     * @param idade int, idade da pessoa
     */
    private void setIdade(int idade)
    {
        this.idade = idade;
    }
    
    /**
     * getIdade - retorna a idade
     *
     * @return int, idade da pessoas
     */
    public int getIdade()
    {
        return this.idade;
    }
    
    /**
     * toString - imprime os dados da pessoa
     *
     * @return String, dados da pessoa
     */
    public String toString(){
        return ("Nome: " + getNome() + "\nIdade: " + getIdade());
    }   
}
