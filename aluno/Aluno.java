package aluno;
import pessoa.Pessoa;
import java.io.Serializable;
/**
 * Definicao dos atributos do aluno
 * 
 * @author Joao Pedro de Souza Oliveira
 * 21/04/2023 
 */
public class Aluno extends Pessoa implements Serializable
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    String ra;
    int serie;
    private Disciplina disc[];//nome e nota
    //disc = new Disciplina[10];

    /**
     * Construtor para objetos da classe Aluno
     * @param nome String, nome do aluno
     * @param int idade, idade do aluno
     * @param String RA, RA do aluno
     * @param int serie, serie do aluno
     * @param Disciplina disc[], disciplinas cursadas pelo aluno
     */
    public Aluno(String nome, int idade, String ra, int serie, Disciplina disc[])
    {
        super(nome, idade); //invoca construtor da classe pai (pessoa)
        setRa(ra);
        setSerie(serie);
        setDisc(disc);
    }
    
    /**
     * Método setRa - atualiza valor do ra
     *
     * @param ra Um parâmetro do tipo String
     */
    private void setRa(String ra)
    {
        this.ra = ra;
    }
    
    /**
     * Método getRa - retorna valor do RA do aluno
     *
     * @return O valor de retorno do tipo String
     */
    public String getRa()
    {
        return this.ra;
    }
    
    /**
     * Método setSerie - atualiza valor da serie do aluno
     *
     * @param serie - parametro do tipo int
     */
    private void setSerie(int serie)
    {
        this.serie = serie;
    }
    
    /**
     * Método getSerie - retorna valor da serie do aluno
     *
     * @return O valor de retorno do tipo int
     */
    public int getSerie()
    {
        return this.serie;
    }
    
    /**
     * Método setDisc - atualiza disciplina do aluno
     *
     * @param disc Um parâmetro do tipo Disciplina
     */
    private void setDisc(Disciplina disc[])
    {
        this.disc = disc;
    }
    
    /**
     * Método getDisc
     *
     * @return retorna uma posicao do array Disciplina (contem nome e nota)
     */
    public Disciplina[] getDisc()
    {
        return disc;
    }

}
