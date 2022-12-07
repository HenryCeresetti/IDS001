package telephony;

/**
 * @author HenryCeresetti
 * @author OrlandoJunior
 */
/*Importação dos utilitários Objetos e Data */

import java.util.Objects;
import java.util.Date;

/* Classe Chamada e seus atributos DATA e DURAÇÃO */

public class call {
    private Date callDate;
    private int callDuration;

/* Método construtor CHAMADA tendo como parâmetros DATA e DURAÇÃO */
    
    public call(Date callDate, int callDuration) {
        super();
        this.callDate = callDate;
        this.callDuration = callDuration;
    }
    
    public Date getCallDate() {
        return callDate;
    }
    
    public int getCallDuration() {
        return callDuration;
    }
    
    /*Sobrescrita do metodo toString para conversão de expressões e argumentos em um objeto composto */
    /*O método ToString(), tem como objetivo trazer uma representação textual de uma instância de um objeto. */

    @Override
    public String toString() {
        return "The registered call is from the following date: " + callDate + " and its duration is from: " + callDuration;
    }

    /*Sobrescrita do metodo hashCode para retornar o método de criação e alocação de novos objetos */

    @Override
    public int hashCode() {
        return Objects.hash(callDate, callDuration);
    }
    
    /*Sobrescrita do metodo equals fazendo comparações e retornando verdadeiro ou falso */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        call instVar = (call) obj;
        return Objects.equals(callDate, instVar.callDate) && Objects.equals(callDuration, instVar.callDuration);
    }
}