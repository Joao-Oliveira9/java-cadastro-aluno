package excessao;

/**
 * Detecta se o numero inserido é negativo 
 * 
 * @author Joao Pedro de Souza Oliveira
 * 21/04/2023
 */
public class NumeroNegativoException extends Exception{
    
    /**
     * NumeroNegativoException Construtor
     *
     * @param msg Um parâmetro do tipo string
     */
    public NumeroNegativoException(String msg){
        super(msg); // idade invalida
    }
}
