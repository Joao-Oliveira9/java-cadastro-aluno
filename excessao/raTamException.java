package excessao;

/**
 * Detecta se o caractere é valido
 * 
 * @author  Joao Pedro de Souza Oliveira
 * 21/04/2023 
 */
public class raTamException extends Exception
{
        /**
         * raTamException Construtor 
         *
         * @param msg Um parâmetro do tipo string
         */
        public raTamException(String msg)
        {
            super(msg); // mensagem de caractere invalido
        }
}
