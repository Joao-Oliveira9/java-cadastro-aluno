import excessao.NumeroNegativoException;
import excessao.raTamException;
import excessao.NumeroException;

import java.util.Scanner;

/**
 * Entrada de dados via console 
 * 
 * @author  Joao Pedro de Souza Oliveira
 * 21/04/2023
 */
public class EntradaDadosConsole implements IEntrada
{
    String aux = null; // string auxiliar 
    Scanner scan = new Scanner(System.in);
    boolean teste = false; // variavel auxiliar 
    
    /**
     * Método qtdDisc - recebe a quantidade de disciplinas a serem inseridas
     *
     * @return tipo int, retorna a quantidade de disciplinas
     */
    
    //funcoes de entrada de dados via teclado
    
    public int lerQtdDisc()
    {
        int qtdDisc = 0;
        int aux2 = 0; // variavel auxiliar para controlo de loop
        
        do
        {
           try
           {
            System.out.print("\nForneca a quantidade de disciplinas: ");
            qtdDisc = scan.nextInt();
            verificarNegCons(qtdDisc); // verifica se a quantidade de disciplinas é negativa
            aux2 = 1;
            aux = String.valueOf(qtdDisc); // conversao de tipo
           }
           catch(NumeroNegativoException e)
            {
                System.out.print("\nQuantidade invalida");
            }
           catch(NumberFormatException e) //exceção de formato do número
           {
              if(aux == null) // verifica se a string auxiliar for nula
              {
                  System.out.print("\nCancelado com sucesso");
                  aux2 = 1; 
              }
              else
              {
                  System.out.print("\nErro de formatacao");    
              }
           }
        }
        while(aux2 !=1);
        
        return qtdDisc;
    }
    /**
     * Método lerNome - le o nome digitado pelo usuario
     *
     * @return retorna uma string 
     */
    public String lerNome()
    {
        String nome = null;
        int aux2 = 0; // variavel auxiliar para controlo de loop
        do
        {
            try
            {
             System.out.print("\nForneca nome: ");
             nome = scan.nextLine();
             if(nome != null)
             {
                 verificarPos2(nome); // verifca se o caractere é valido
             }
             if(nome == null) // verifica se o nome é nulo
                {
                  System.out.print("\nCancelado com sucesso");
                }
                else if(nome.trim().isEmpty()) // checa se o usuario deixou o campo nome vazio
                {
                  System.out.print("\nO campo nome do aluno precisa ser preenchido"); 
                  
                }
                else if (nome.matches("\\d")) // checa se o nome possue números
                {
                    System.out.print("\nCaractere invalido");
                }
                else
                {
                   aux2 = 1; 
                }
            }
                
            catch(Exception e)
            {
                System.out.print("\nErro de formatacao");
            }
        }
        while(aux2 !=1);
        return nome;
    }
    
    /**
     * Método lerIdade - le a idade digitada pelo usuario
     *
     * @return O valor de retorno - retorna um int
     */
    public int lerIdade()
    {
        int idade = 0;
        int aux2 = 0; // variavel auxiliar para controlo de loop
        
        do
        {
            try
            {
                System.out.print("\nForneca a idade: ");
                idade = scan.nextInt();
                verificarNegCons(idade);// verifica se a idade é negativa
                aux2 = 1;
                aux = String.valueOf(idade); // conversao de tipo
            }
            catch(NumberFormatException e) //exceção de formato do número
            {
              if(aux == null)  
              {
                  System.out.print("\nCancelado com sucesso");
                  aux2 = 1; 
              }
              else if(aux.matches("[a-zA-Z]")) // verifica se a idade possue letras
              {
                  System.out.print("\nCaractere invalido");
              }
              else
              {
                  System.out.print("\nO campo idade precisa ser preenchido");    
              }
            }
            catch(NumeroNegativoException e)
            {
               System.out.print("\nIdade invalida\n");
            }
        }
        while(aux2 !=1);
        return idade;
    }
    
    /**
     * Método lerRa - le o RA inserido
     *
     * @return retorna uma String
     */
    public String lerRa()
    {
        String ra = null;
        int aux2 = 0; // variavel auxiliar para controlo de loop
        do
        {
            try
            {
              System.out.print("\nForneca RA: ");
              ra = scan.nextLine();
              if(ra != null) // verifica se o ra não for nulo
              {
                verificarPos(ra);
              }
              if(ra == null)
                 {
                  System.out.print("\nCancelado com sucesso");  
                 }
                  else if(ra.trim().isEmpty()) // checa se o usuario deixou o campo nome vazi
                  {
                  System.out.print("\nO campo ra precisa ser preenchido\n"); 
                  }
                 else if(ra.matches("[a-zA-Z]")) // verifica se o ra possue letras
                  {
                  System.out.print("\nCaractere invalido");
                  }
                 else
                 {
                   aux2 = 1;  
                 }
            }
            catch(raTamException e)
            {
                System.out.print("\nErro de formatacao");
            }
        }
        while(aux2 !=1);
        return ra;
    }
    
    /**
     * Método lerSerie - le a serie inserida
     *
     * @return retorna um int
     */
    public int lerSerie()
    {
        int serie = 0;
        int aux2 = 0; // variavel auxiliar para controlo de loop
        
        do
        {
           try
           {   System.out.print("\nForneca serie: ");
               serie = scan.nextInt();
               verificarNegCons(serie);
               aux = String.valueOf(serie); // conversao de tipo
               aux2 = 1;
           }
         
           catch(NumberFormatException e) // erro de formato do número
           {    
               if(aux == null) // verifica se a string auxiliar é nula
               {
                   System.out.print("\nCancelado com sucesso ");
                   aux2 = 1; 
               }
                else
              {
                  System.out.print("\nO campo serie precisa ser preenchido");    
              }
           }
           catch(NumeroNegativoException e)
            {
                System.out.print("\nSerie invalida\n");
            }
            
        }
        while(aux2 !=1);
        return serie;
    }
    
    /**
     * Método lerNota - le a nota inserida
     *
     * @return O valor de retorno do tipo double
     */
    public double lerNota()
    {
        double nota = 0;
        int aux2 = 0; // variavel auxiliar para controlo de loop
        do
        {   
            try
            {
                System.out.print("\nNota:");
                nota = scan.nextInt();
                aux = String.valueOf(nota); // conversao de tipo
            
                aux2 = 1;
            }
            catch(NumberFormatException e) // erro de formato do número
            {
               if(aux == null) // verifica se a string auxiliar for nula
               {
                   System.out.print("\nCancelado com sucesso");
                   aux2 = 1; 
               }
               else
               {
                  System.out.print("\nO campo nota precisa ser preenchido");    
               }
            }
        }
        while(aux2!=1);
        return nota;
    }
    
    /**
     * Método lerNomeDisc - le o nome da disciplina inserida
     *
     * @return O valor de retorno do tipo string
     */
    public String lerNomeDisc()
    {
        String nome = null;
        int aux2 = 0; // variavel auxiliar para controlo de loop
        
        do
        {
            try
            {
                System.out.print("\nForneca nome da disciplina: ");
                nome = scan.next();
                if(nome == null) //verifica se o nome do aluno não foi inserido
                {
                    System.out.print("\nO campo da disciplina precisa ser preenchido");
                }
                else
                {
                  aux2 = 1;
                }
            }
            catch(Exception e)
            {
                System.out.print("\nErro de formatacao");
            }
        }
        while (aux2 !=1);
        return nome;
    }
    
    /**
     * Método opcaoMenu - chamada do menu principal
     *
     * @return O valor de retorno do tipo string
     */
    public String opcaoMenu()
    {
        System.out.print("1 - Inserir \n2 - Remover\n3 - Listar\n4 - Salvar\n5 - Ler arquivo\n6 - Sair\n");
        String op = scan.next();
        return op;
    }
    
    public String lerNomeArquivo()
    {
        String nome = "";
        
        System.out.println("Forneca o nome do arquivo");
        nome = scan.next();
        
        return nome;
    }
    
    public String lerRaRemocao()
    {
        String ra ="";
        System.out.println("Forneca o RA do aluno a ser removido:  ");
        ra = scan.next();
        
        return ra;
    }
    
     /**
      * Método verificarNegCons -  verifica se a idade for negativa
      *
      * 
      */
    public static void verificarNegCons(double idade)throws NumeroNegativoException 
    { // verifica se a idade inserida é valida
            if(idade < 0){
            throw new NumeroNegativoException("Idade invalida");
        }
    }
    
    /**
     * Método verificarPos - Detecta se o caractere é valido
     * 
     */
    static void verificarPos(String str)throws raTamException // Detecta se o caractere é valido
    {
        boolean result = true;
        for (int i = 0; i < str.length(); i++) { // percorre a string
        if (!Character.isDigit(str.charAt(i)))  // verifica se o caractere digitado não foi um digito entre 0 e 9
                result = false;
        }
        if(result == false)
        {
            throw new raTamException("Caracter Invalido"); 
        }
    }
    
    /**
     * Método verificarPos2 - Detecta se o caractere é valido
     *
     *
     */
    static void verificarPos2(String str)throws raTamException // Detecta se o caractere é valido
    {
        boolean result = true;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) 
                result = false;
        }
        if(result == false)
        {
            throw new raTamException("Caracter Invalido"); 
        }
    }
}
