
import java.util.List;
import modelo.EntradaDeHorarios;

public class GerardorColunasPonto {

    private final List linhas = null;//tipo de um vetor para linhas   
    private final String[] colunas = null;//vetor para colunas

    public Object colunas(int numLin, int numCol) {
        if (colunas.length > 4) {
            EntradaDeHorarios ent = (EntradaDeHorarios) linhas.get(numLin);
            switch (numCol) {
                case 0:
                    return ent.getDia();
                case 1:
                    return ent.getHora_entrada();
                case 2:
                    return ent.getHora_almoco();
                case 3:
                    return ent.getHora_retorno();
                case 4:
                    return ent.getHora_saida();
                case 5:
                    return ent.getId_funcionario();
            }
        }
        return null;
    }
}
