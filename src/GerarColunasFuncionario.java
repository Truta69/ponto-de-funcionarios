
import java.util.List;
import modelo.Funcionario;

public class GerarColunasFuncionario {

    private final List linhas = null;//tipo de um vetor para linhas   
    private final String[] colunas = null;//vetor para colunas

    public Object colunas(int numLin, int numCol) {
        if (colunas.length == 4) {
            Funcionario f = (Funcionario) linhas.get(numLin);
            switch (numCol) {
                case 0:
                    return f.getCodigoFuncionario();
                case 1:
                    return f.getNomeFuncionario();
                case 2:
                    return f.getCargaHoraria();
                case 3:
                    return f.getCod_empresa();
            }
        }
        return null;
    }
}
