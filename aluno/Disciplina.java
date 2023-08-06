package aluno;
import txt.Texto;
import java.io.Serializable;
/**
 * Definicao dos atributos da disciplina
 * 
 * @author Joao Pedro de Souza Oliveira
 * 21/04/2023 
 */
public class Disciplina implements Serializable
{
    Texto nomeDisc; //nome
    private double nota;
    
    /**
     * Construtor para objetos da classe Disciplina
     */
    public Disciplina(double nota, String nomeDisc)
    {
        setNota(nota);
        setDisc(nomeDisc);
    }
    
    /**
     * Método atualiza o valor da nota
     *
     * @param nota parametro tipo float
     */
    private void setNota(double nota)
    {
        this.nota = nota;
    }
    
    /**
     * Método getNota - retorna nota da pessoa
     *
     * @return O valor de retorno nota, tipo float
     */
    public double getNota()
    {
        return this.nota;
    }
    
    /**
     * Método setDisc - atualiza valor de nomeDisc (nome da disciplina)
     *
     * @param nomeDisc Um parâmetro do tipo String
     */
    private void setDisc(String nomeDisc)
    {
        this.nomeDisc = new Texto(nomeDisc);
    }
    
    /**
     * Método getDisc - retorna nome da disciplina
     *
     * @return O valor de retorno do tipo String
     */
    public String getDisc()
    {
        return this.nomeDisc.getTxt();
    }
    
    /**
     * Método toString
     *
     * @retorna o valor dos atributos da classe como string
     */
    public String toString(){
        return ("Nome da Disciplina: " + getDisc() + "\nNota: " + getNota());
    }
}
