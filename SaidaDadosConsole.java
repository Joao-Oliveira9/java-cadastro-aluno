import aluno.Disciplina;
import armazenador.IArmazenador;
/**
 * Saida de dados via console
 * 
 * @author Joao Pedro de Souza Oliveira
 * 21/04/2023 
 */
public class SaidaDadosConsole implements ISaida
{
    public void imprimirListaVazia()
    {
        System.out.println("A lista esta vazia!!!");
    }
    public void imprimirAlunoNaoExiste()
    {
        System.out.println("O RA fornecido nao refere-se a nenhum aluno");
    }
    public void imprimirAlunoRemovido(String nome)
    {
        System.out.println("O (A) aluno(a) " + nome + " foi removido(a)");
    }
    public void imprimirAlunos(String nome, int idade, String ra, int serie)
    {
        System.out.println("Nome: " + nome + "\nIdade:  " + idade + "\nRA:  " + ra + "\nSerie: " + serie);
    }
    public void imprimirRaExiste(String ra)
    {
        System.out.println("O RA " + ra + " ja existe");
    }
    public void imprimirRaInvalido(String ra)
    {
        System.out.println("O RA " + ra + " nao possui um tamanho valido (8 numeros)");
    }
    public void imprimirDisc(Disciplina disc[], int i)
    {
        System.out.println(disc[i]);
    }
    public void arquivoGravado(String nomeArq)
    {
         System.out.println("\nGravando em " + nomeArq);
    }
    public void lendoArquivo(String nomeArq, IArmazenador outroCad)
    {
        System.out.println("\nLendo do arquivo " + nomeArq + "\n" + outroCad);
    }
}
