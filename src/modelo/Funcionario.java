package modelo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Funcionario {

    @Getter
    @Setter
    private int codigoFuncionario;
    @Getter
    @Setter
    private String nomeFuncionario;
    @Getter
    @Setter
    private Empresa empresa;//n consegui usar..
    @Getter
    @Setter
    private int cod_empresa;
    @Getter
    @Setter
    private String nomeEmpresa;//para pegar nome empresa pelo id_empresa
    @Getter
    @Setter
    private String cnpj;//usar p  tela de ponto..
    @Getter
    @Setter
    private String cargaHoraria;

    @Override
    public String toString() {
        return nomeFuncionario;
    }
}
