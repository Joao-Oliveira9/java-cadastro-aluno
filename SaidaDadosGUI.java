import aluno.Disciplina;
import armazenador.IArmazenador;
import javax.swing.JOptionPane;
/**
 * Saida de dados via caixa de texto
 * 
 * @author Joao Pedro de Souza Oliveira
 * 21/04/2023
 */
public class SaidaDadosGUI implements ISaida
{
    public void imprimirListaVazia()
    {
        JOptionPane.showMessageDialog(null, "A lista esta vazia!!!");
    }
    public void imprimirAlunoNaoExiste()
    {
        JOptionPane.showMessageDialog(null, "O RA fornecido nao refere-se a nenhum aluno");
    }
    public void imprimirAlunoRemovido(String nome)
    {
        JOptionPane.showMessageDialog(null, "O (A) aluno(a) " + nome + " foi removido(a)");
    }
    public void imprimirAlunos(String nome, int idade, String ra, int serie)
    {
        JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nIdade:  " + idade + "\nRA:  " + ra + "\nSerie: " + serie);
    }
    public void imprimirRaExiste(String ra)
    {
        JOptionPane.showMessageDialog(null, "O RA " + ra + " ja existe");
    }
    public void imprimirRaInvalido(String ra)
    {
        JOptionPane.showMessageDialog(null, "O RA " + ra + " nao possui um tamanho valido (8 numeros)");
    }
    public void imprimirDisc(Disciplina disc[], int i)
    {
        JOptionPane.showMessageDialog(null, disc[i]);
    }
    public void arquivoGravado(String nomeArq)
    {
         JOptionPane.showMessageDialog(null,"\nGravando em " + nomeArq);
    }
    public void lendoArquivo(String nomeArq)
    {
        if(nomeArq != null)
            JOptionPane.showMessageDialog(null,"\nLendo do arquivo " + nomeArq);
    }
}
