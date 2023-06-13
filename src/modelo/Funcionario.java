package modelo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Funcionario {

    @Getter
    @Setter
    private int codigo;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String funcao;
    @Getter
    @Setter
    private int cod_empresa;
    @Getter
    @Setter
    private String nomeEmpresa;//para pegar nome empresa pelo id_empresa
    @Getter
    @Setter
    private String cnpj;//usar p  tela de ponto..
}
