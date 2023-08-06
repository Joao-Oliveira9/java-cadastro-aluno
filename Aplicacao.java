import javax.swing.JOptionPane;
import excessao.NumeroNegativoException;
import excessao.raTamException;
import excessao.NumeroException;
/**
 * Contém o menu do programa
 * 
 * @author Joao Pedro de Souza Oliveira
 * 21/04/2023
 */
public class Aplicacao
{
    public static CadastroAlunos cadastro = new CadastroAlunos(); //cria array que armazena ate 60 alunos
    
    //public static EntradaDadosConsole entradaDados = new EntradaDadosConsole();
    
    public static EntradaDadosGUI entradaDados = new EntradaDadosGUI();

    public static void main(String[] args)
    {  
        String opcao = " ";
        do
        {
            try{    
                opcao = entradaDados.opcaoMenu();
                if(opcao != null)
                {
                    numMenu(opcao);
                    switch(opcao)
                    {
                        case "1":
                            //func do cadastro alunos (inserir)
                            cadastro.inserirAlunos();
                            break;
                        case "2":
                            //func do cadastro alunos (remover)
                            cadastro.removerAlunos();
                            break;
                        case "3":
                            //func do cadastro alunos (listar)    
                            cadastro.listarAlunos();
                            break;
                        case "4":
                            cadastro.salvarArquivo();
                            //salvar em arquivo binario
                            break;
                        case "5":
                            //ler arquivo binario
                            cadastro.lerArquivo();
                            break;
                        case "6":
                            cadastro.saidaPrograma();
                            break;
                    }
                }
                else
                {
                     cadastro.saidaPrograma();
                    System.exit(0);
                    
                }
                   
            }catch(NumeroException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());// criado para o comando cancelar operar no menu inicial
                //System.out.print("\nOpcao invalida\n");
            }
        }
        while(!opcao.equals("6"));  //opcao = 6, programa encerrado               
    } 

    /**
     * Método numMenu - checa se os numeros inseridos no menu sao validos
     *
     * 
     */
    public static void numMenu(String opcao)throws NumeroException {// verifica se o caractere digitado no menu é valido
        if (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5") && !opcao.equals("6")){
            throw new NumeroException("Opção Invalida");
        }
    }
}