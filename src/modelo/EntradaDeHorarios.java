package modelo;

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
    String hora_entrada;
    @Getter
    @Setter
    String hora_almoco;
    @Getter
    @Setter
    String hora_retorno;
    @Getter
    @Setter
    String hora_saida;
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
