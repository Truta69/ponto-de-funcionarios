
import java.util.List;
import modelo.Empresa;

public class GerarColunasEmpresas {

    private final List linhas = null;//tipo de um vetor para linhas    
    private final String[] colunas = null;//vetor para colunas

    public Object colunas(int numLin, int numCol) {
        if (colunas.length < 4) {
            Empresa emp = (Empresa) linhas.get(numLin);
            switch (numCol) {
                case 0:
                    return emp.getCodigo();
                case 1:
                    return emp.getNome();
                case 2:
                    return emp.getCnpj();
            }
        }
        return null;
    }
}
