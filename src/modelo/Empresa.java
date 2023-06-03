package modelo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Empresa {

    @Getter
    @Setter
    int codigo;
    @Getter
    @Setter
    String nome;
    @Getter
    @Setter
    String cnpj;
}
