package modelo;

import java.sql.Time;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EntradaDeHorarios {

    @Getter
    @Setter
    int id_entrada;
    @Getter
    @Setter
    int dia;
    @Getter
    @Setter
    Time hora_entrada;
    @Getter
    @Setter
    Time hora_almoco;
    @Getter
    @Setter
    Time hora_retorno;
    @Getter
    @Setter
    Time hora_saida;
    @Getter
    @Setter
    int id_funcionario;
    @Getter
    @Setter
    String nome_funcionario;

    @Override
    public String toString() {
        return id_entrada + "" + hora_entrada + "" + hora_almoco + "" + hora_retorno + "" + hora_saida + "" + id_funcionario;
    }

}
