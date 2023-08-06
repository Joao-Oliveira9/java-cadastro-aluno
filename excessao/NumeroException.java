package excessao;

/**
 * Detecta se um numero foi inserido
 * 
 * @author  Joao Pedro de Souza Oliveira
 * 21/04/2023
 */
public class NumeroException extends Exception
{
        /**
         * NumeroException Construtor
         *
         * @param msg Um parâmetro do tipo string
         */
        public NumeroException(String msg)
        {
            super(msg); // mensagem de opcao invalida
        }
}
