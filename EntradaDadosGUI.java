
import excessao.NumeroNegativoException;
import excessao.raTamException;
import excessao.NumeroException;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 * Entrada de dados via caixa de texto
 * 
 * @author Joao Pedro de Souza Oliveira
 * 21/04/2023
 */
public class EntradaDadosGUI implements IEntrada
{
    String aux = null; // string auxiliar 
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
        int aux2 = 0; //variavel auxiliar para controle de loop
        
        do
        {
           try
           {
            aux = JOptionPane.showInputDialog("Forneca a quantidade de disciplinas: ");
            qtdDisc = Integer.parseInt(aux);
            verificarNeg(qtdDisc); // verifica se a quantidade de disciplinas é negativa
            aux2 = 1;
           }
           catch(NumeroNegativoException e)
            {
                JOptionPane.showMessageDialog(null, "Quantidade invalida");
            }
           catch(NumberFormatException e)
           {
              if(aux == null) // verifica se a string auxiliar é nula
              {
                  JOptionPane.showMessageDialog(null, "Cancelado com sucesso");
                  aux2 = 1; 
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "Erro de formatacao");    
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
        int aux2 = 0; // variavel auxiliar de controle do loop
        do
        {
            try
            {
             nome = JOptionPane.showInputDialog("Forneca nome");
             if(nome != null)
             {
                 verificarPos2(nome); // verifca se o caractere é valido
             }
             if(nome == null)// verifica se o nome for nulo
                {
                  JOptionPane.showMessageDialog(null, "Cancelado com sucesso");
                  aux2 = 1; 
                }
                else if(nome.trim().isEmpty()) // checa se o usuario deixou o campo nome vazio
                {
                  JOptionPane.showMessageDialog(null, "O campo nome do aluno precisa ser preenchido"); 
                  
                }
                else if (nome.matches("\\d")) //checa se nome possui números
                {
                    JOptionPane.showMessageDialog(null, "Caractere invalido");
                }
                else
                {
                   aux2 = 1; 
                }
            }
                
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Erro de formatacao");
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
        int aux2 = 0; //variavel auxiliar para controle de loop
        
        do
        {
            try
            {
                aux = JOptionPane.showInputDialog("Forneca a idade: ");
                idade = Integer.parseInt(aux);
                verificarNeg(idade); // verifica se a idade é negativa
                aux2 = 1;
            }
            catch(NumberFormatException e) //exceção de formato do número
            {
              if(aux == null) // checa se a string aux é vazia
              {
                  JOptionPane.showMessageDialog(null, "Cancelado com sucesso");
                  aux2 = 1; 
              }
              else if(aux.matches("[a-zA-Z]")) // checa se foi inserido letras no campo idade 
              {
                  JOptionPane.showMessageDialog(null, "Caractere invalido");
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "O campo idade precisa ser preenchido corretamente");    
              }
            }
            catch(NumeroNegativoException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
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
        int aux2 = 0; //variavel auxiliar para controle de loop
        do
        {
            try
            {
              ra = JOptionPane.showInputDialog("Forneca RA");
              if(ra != null) // verifica se o ra não for nulo
              {
                verificarPos(ra);
              }
              if(ra == null) // verifica se o ra for nulo
                 {
                  JOptionPane.showMessageDialog(null, "Cancelado com sucesso");
                  aux2 = 1;
                 }
                  else if(ra.trim().isEmpty()) // checa se o usuario deixou o campo nome vazio
                 {
                  JOptionPane.showMessageDialog(null, "O campo ra precisa ser preenchido"); 
                 }
                else 
                {
                     aux2 = 1;
                }
            }
            catch(raTamException e) 
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        while(aux2 !=1);
        return ra;
    }
    
    /**
     * Método lerSerie - le as serie inserida
     *
     * @return retorna um int no qual é a serie do aluno
     */
    public int lerSerie()
    {
        int serie = 0;
        int aux2 = 0; //variavel auxiliar para controle de loop
        
        do
        {
           try
           {   aux = JOptionPane.showInputDialog("Forneca serie: ");
               serie = Integer.parseInt(aux);
               verificarNeg(serie); // verifica se a serie é negativa
               aux2 = 1;
           }
           catch(NumberFormatException e) //exceção de formato do número
           {    
               if(aux == null)
               {
                   JOptionPane.showMessageDialog(null, "Cancelado com sucesso");
                   aux2 = 1; 
               }
              else
              {
                  JOptionPane.showMessageDialog(null, "O campo serie precisa ser preenchido corretamente");    
              }
           }
            catch(NumeroNegativoException e)
            {
                JOptionPane.showMessageDialog(null, "Serie invalida");
            }
        }
        while(aux2 !=1);
        return serie;
    }
    
    /**
     * Método lerNota - le as nota do aluno
     *
     * valor de retorno é a nota do aluno inserido
     */
    public double lerNota()
    {
        double nota = 0;
        int aux2 = 0; //variavel auxiliar para controle de loop
        do
        {   
            try
            {
                aux = JOptionPane.showInputDialog("Nota: ");
                nota = Double.parseDouble(aux); 
                verificarNeg(nota); // verifica se a nota é negativa
                aux2 = 1;
            }
            catch(NumeroNegativoException e)
            {
                JOptionPane.showMessageDialog(null, "Nota invalida");
            }
            catch(Exception e)
            {
               if(aux == null) // verifica se a string auxiliar é nula
               {
                   JOptionPane.showMessageDialog(null, "Cancelado com sucesso");
                   aux2 = 1; 
                   teste = true; // variavel auxiliar 
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "O campo nota precisa ser preenchido corretamente");    
               }
            }
           
        }
        while(aux2!=1);
        return nota;
    }
    
    /**
     * Método opcaoMenu - chamada do menu principal
     *
     * @return O valor de retorno é um string
     */
    public String opcaoMenu()
    {
        String op = JOptionPane.showInputDialog("1 - Inserir \n2 - Remover\n3 - Listar\n4 - Salvar\n5 - Ler arquivo\n6 - Sair\n");
        return op;
    }
    
    /**
     * Método lerNomeDisc - le as disciplinas do aluno
     *
     * retorna o nome da disciplina do aluno
     */
    public String lerNomeDisc()
    {
        String nome = null; 
        int aux2 = 0;//variavel auxiliar para controle do loop
        
        do
        {
            try
            {
                nome = JOptionPane.showInputDialog("Forneca nome da disciplina");
                if(nome == null) // checa caso o nome não foi inserido
                {
                    JOptionPane.showMessageDialog(null, "Cancelado com sucesso");
                    aux2 = 1; 
                }
                else if(nome.trim().isEmpty()) // checa se o usuario deixou o campo nome vazio
                {
                  JOptionPane.showMessageDialog(null, "O campo nome da disciplina precisa ser preenchido"); 
                }
                else
                {
                    aux2 = 1;
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Erro de formatacao");
            }
        }
        while (aux2 !=1);
        return nome;
    }
    
    /**
     * Método lerNomeArquivo - retorna nome do arquivo 
     *
     * @return 
     */
    public static String lerNomeArquivo()
    {
        String nome = null;
        String nomeArq = null;
        int aux2 = 0;
        
        do
        {
            try
            {
                nome = JOptionPane.showInputDialog(null, "Forneca o nome do arquivo");
                if(nome == null)
                {
                    JOptionPane.showMessageDialog(null, "Cancelado com sucesso");
                    aux2 = 1;
                }
                else if(nome.trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "O campo nome do arquivo precisa ser preenchido");
                }
                else
                {
                    aux2 = 1;
                }
            }
            catch(Exception e)
            { 
                JOptionPane.showMessageDialog(null, "Erro de formatacao");   
            }
        }
        while(aux2 != 1);
        
        return nome;
    }
    
   
    

    /**
     * Método verificarPos - Detecta se o caractere é valido
     *
     * @param str Um parâmetro do tipo string
     */
    static void verificarPos(String str)throws raTamException 
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
     * Método verificarNeg - verifica se a idade for negativa
     *
     * @param idade Um parâmetro do tipo double
     */
    public static void verificarNeg(double idade)throws NumeroNegativoException {
            if(idade < 0){
            throw new NumeroNegativoException("Idade invalida");
        }
    }
    
     /**
      * Método verificarPos2 -  Detecta se o caractere é valido
      *
      * @param str Um parâmetro do tipo string
      */
     static void verificarPos2(String str)throws raTamException 
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



