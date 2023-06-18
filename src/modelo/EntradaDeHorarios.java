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
}
