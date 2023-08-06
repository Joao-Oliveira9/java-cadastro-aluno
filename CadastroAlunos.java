import armazenador.IArmazenador;
import armazenador.VetDin;
import armazenador.ListaLigadaSimples;
//import armazenador.ListaArray;
import javax.swing.JOptionPane;
import aluno.Disciplina;
import aluno.Aluno;
import java.io.*;
import javax.swing.JFrame;
/**
 * Classe onde os alunos serao cadastrados
 * 
 * @author  Joao Pedro de Souza Oliveira
 * 21/04/2023
 */
public class CadastroAlunos
{
    //private Aluno cadastro[];
    //IArmazenador cadastro = new VetDin();
    IArmazenador cadastro = new ListaLigadaSimples();
    //ArquivoBinario ab = new ArquivoBinario();
    //IArmazenador cadastro = new ListaArray();
    //Disciplina d[];
    int tam = 0;
    private EntradaDadosGUI entrada = new EntradaDadosGUI();
    //private EntradaDadosConsole entrada = new EntradaDadosConsole();

    private SaidaDadosGUI saida = new SaidaDadosGUI();
    //private SaidaDadosConsole saida = new SaidaDadosConsole();

    //inserir, remover e listar
    /**
     * CadastroAlunos = Construtor
     *
     * @param qtd Um parâmetro que recebe a quantidade de alunos que possa ser inserido
     */
    public CadastroAlunos()
    {
        // cadastro = new Aluno[qtd];  
    }

    /**
     * Método inserirAlunos - Insere os alunos na lista
     *
     */
    public void inserirAlunos()
    {
        int idade;
        int serie;
        int qtdDisc;
        String ra = entrada.lerRa();
        boolean raValido = false; // variavel para checar se o ra é valido
        boolean raExiste = true; // variavel para checar se o ra inserido ja existe
        boolean raMenor = false; // variavel para checar se o tamanho é menor que 8
        boolean Vazio = false;

        if(ra !=null)
        {
            while (raValido == false && Vazio == false) // verifica enquanto o ra fornecido for invalido
            { 
                if(ra != null)
                {
                    if (verificarRa(ra) != -1) //ra ja existe
                    {
                        raExiste = true;
                        saida.imprimirRaExiste(ra);
                    }
                    else
                    {
                        raExiste = false;
                        raValido = true;
                    }
                    if (verificarTamanhoRa(ra) == false) //ra tem tamanho menor que 8
                    {
                        saida.imprimirRaInvalido(ra);
                        raMenor = true;
                    }
                }   
                if (raValido == false || raMenor == true)
                {
                    ra = entrada.lerRa();
                    if(ra == null)
                    {
                        Vazio=true;
                    }
                    else
                    {
                        raValido = false;
                        raExiste = true;
                        raMenor = false;   
                    }
                }
            }            
            if(ra !=null)
            {
                String nome = entrada.lerNome();
                if(nome != null) // verifica se o nome foi inserido
                {
                    idade = entrada.lerIdade();
                    if(idade > 0) // verifica se a idade foi preenchida
                    {
                        serie = entrada.lerSerie();
                        if(serie > 0) // verifica se a serie foi preenchida
                        {
                            qtdDisc = entrada.lerQtdDisc();
                            if(qtdDisc > 0) // verifica se a quantidade de disciplinas foi preenchida
                            {
                                Disciplina disc[] = inserirDisciplinas(qtdDisc);
                                if(entrada.teste == false)
                                {
                                    Aluno aluno1 = new Aluno(nome, idade, ra, serie, disc); // construtor do aluno
                                    cadastro.adicionar(aluno1);
                                    //cadastro[tam] = aluno1;
                                    //tam++;   
                                }
                            }
                        }
                    }
                }   
            }
        }
    }

    /**
     * Método listarAlunos - Lista os alunos presentes na lista
     *
     */
    public void listarAlunos()
    {
        if (cadastro.estaVazia() == true) // verifica se a lista de alunos for vazia
        {
            saida.imprimirListaVazia();
        }
        else
        {
            for (int i = 0; i < cadastro.getQtd(); i++)
            {
                Aluno aux = (Aluno)cadastro.buscar(i);

                if(aux != null) // verifica se os alunos foram inseridos no cadastro
                {
                    saida.imprimirAlunos(aux.getNome().getNome(), aux.getIdade(), aux.getRa(),aux.getSerie());
                    mostrarDiscs(aux.getDisc()); // mostra as disciplinas dos alunos inseridos
                } 
            }
        }
    }

    /**
     * Método mostrarDiscs - lista as disciplinas de cada aluno
     *
     * @param d Um parâmetro do tipo disciplina
     */
    void mostrarDiscs(Disciplina d[]){
        for(int i = 0; i < d.length; i++) //percorre o array da disciplina
        {
            saida.imprimirDisc(d, i);
        }
    }

    /**
     * Método inserirDisciplinas
     *
     * @param qtd Um parâmetro do tipo inteiro
     * @return d valor de retorno do tipo disciplina
     */
    public Disciplina [] inserirDisciplinas(int qtd)
    {
        double nota = -1;
        String nome;
        Disciplina d[] = new Disciplina[qtd];
        boolean aux = false; // variavel auxiliar para comando de loop
        int i = 0;

        do
        {
            nome = entrada.lerNomeDisc();
            if(nome!=null) // checa se o nome do aluno foi inserido
            {
                nota = entrada.lerNota();
                boolean resposta = entrada.teste;
                if(resposta != true)
                {
                    d[i] = new Disciplina(nota, nome);
                    i++; 
                }
                else
                    aux =true;
            }
            else
            {
                entrada.teste = true;
                aux = true;
            }
        }
        while(i<qtd && aux == false); 
        return d;   
    }

    /**
     * Método removerAlunos - remove um aluno da lista
     *
     */
    public void removerAlunos()
    {
        if (verificarArrayVazio() != true) // checa se o array esta vazio
        {
            String raRemocao = entrada.lerRa();
            int achou = 0;
            int i = 0;

            int indice = verificarRaRemocao(raRemocao); // verifica se o ra que deseja ser removido existe
            if (indice != -1)
            {
                //cadastro = cadastro.remover();
                Aluno aux = (Aluno)cadastro.buscar(indice);
                saida.imprimirAlunoRemovido(aux.getNome().getNome());
                Aluno aux2 = (Aluno)cadastro.remover(indice); 

            }
            else
            {
                saida.imprimirAlunoNaoExiste();
            }
        }
        else
        {
            saida.imprimirListaVazia();
        }
    }

    /**
     * Método salvarArquivo - salva array em arquivo binario
     *
     */
    public void salvarArquivo()
    {
        if (verificarArrayVazio() == false)
        {
            ArquivoBinario ab = new ArquivoBinario();   
            String nomeArq = entrada.lerNomeArquivo();

            if(nomeArq!=null)
            {
                ab.gravarObj(cadastro,nomeArq);
                saida.arquivoGravado(nomeArq);
            }
        }else{
            saida.imprimirListaVazia();
        }

    }

    /**
     * Método lerArquivo
     *
     */
    public void lerArquivo(){
        ArquivoBinario ab = new ArquivoBinario();
        String nomeArq = null;
        int flag = 1;
        do{
            nomeArq = entrada.lerNomeArquivo();
            flag = 1;
            if(nomeArq!= null)
            {
                try{
                    cadastro = (IArmazenador)ab.lerObj(nomeArq);
                }catch(Exception e){
                    flag = 0;
                }
            }
        }while(flag != 1);
        saida.lendoArquivo(nomeArq);
    }

    /**
     * Método verificarRa - verifica se o RA esta presente na lista
     *
     * @param ra Um parâmetro tipo String
     * @return O valor de retorno tipo boolean. False se nao estiver, true se estiver
     */
    private int verificarRa(String ra)
    {
        int indice = -1; // devolve -1 se ra nao existir na lista
        int i = 0;
        Aluno aux = (Aluno)cadastro.buscar(i);
        int qtd = cadastro.getQtd();
        if (verificarArrayVazio() != true) //array vazio
        {
            while (i <cadastro.getQtd() && aux != null && indice == -1) 
            {
                if (aux.getRa().equals(ra))
                {
                    indice = i;
                }
                i++;
            } 
        }

        return indice;
    }

    /**
     * Método verificarRa - verifica se o RA esta presente na lista
     *
     * @param ra Um parâmetro tipo String
     * @return O valor de retorno tipo boolean. False se nao estiver, true se estiver
     */
    private int verificarRaRemocao(String ra)
    {
        int indice = -1; // devolve -1 se ra nao existir na lista
        int i = 0;
        Aluno aux = (Aluno)cadastro.buscar(i);

        int qtd = cadastro.getQtd();
        if (verificarArrayVazio() != true) //array vazio
        {
            while (i <= cadastro.getQtd() && aux != null && indice == -1) 
            {

                if (aux.getRa().equals(ra))
                {
                    if (cadastro.getQtd() == 1 || i == 0)
                    {
                        indice = i;
                    }
                    else
                    {
                        indice = i - 1;
                    }

                }
                else
                {
                    aux = (Aluno)cadastro.buscar(i);
                    i++;
                }
            } 
        }

        return indice;
    }

    /**
     * Método saidaPrograma - Sai do programa
     *
     */
    public void saidaPrograma()
    {
        if (verificarArrayVazio() == false)
        {
            JFrame frame = new JFrame("Salvar");
            int op = 0;
            op = JOptionPane.showConfirmDialog(frame,"Deseja salvar os dados antes de sair?", "Mensagem", JOptionPane.YES_NO_OPTION);
            if (op == JOptionPane.YES_OPTION)
            {
                salvarArquivo();
            }
        }
    }

    /**
     * Método verificarArrayVazio - verifica se o array cadastro esta vazio
     *
     * @return O valor de retorno boolean. retorna true se estiver, false se nao
     */
    public boolean verificarArrayVazio()
    {
        // variavel auxiliar
        boolean vazio;
        vazio = cadastro.estaVazia();

        return vazio;
    }

    /**
     * Método verificarTamanhoRa
     *
     * @param ra Um parâmetro tipo string
     * @return O valor de retorno - retorna false se ra tiver menos numero do que 8
     */
    private boolean verificarTamanhoRa(String ra)
    {
        boolean ok = false; // variavel auxiliar 

        if (ra.length() == 8) // verifica se o ra possue 8 digitos
        {
            ok = true;
        }

        return ok;
    }
}
