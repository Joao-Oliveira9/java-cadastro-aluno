import aluno.Disciplina;
/**
 * Interface das funcoes de saida
 * 
 * @author Joao Pedro de Souza Oliveira
 * 21/04/2023
 */
public interface ISaida
{
  public void imprimirListaVazia();
  public void imprimirAlunoNaoExiste();
  public void imprimirAlunoRemovido(String nome);
  public void imprimirAlunos(String nome, int idade, String ra, int serie);
}
