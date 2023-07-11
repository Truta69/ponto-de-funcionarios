package modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {

    private List linhas = null;//tipo de um vetor para linhas
    private String[] colunas = null;//vetor para colunas

//    //tentando fazer uso do padro static metodo
    private ModeloTabela(List numLinhas, String[] numColunas) {//passa parametros
        setLinhas(numLinhas);
        setColunas(numColunas);
    }

    //para chamar da classe(new moelotabela)
    //com um nome significativo ver renderTabela
    public static ModeloTabela gerarTabelaComLinhasEColunas(List lin, String[] col) {
        return new ModeloTabela(lin, col);
    }

    @Override
    public int getRowCount() {
        return linhas.size();//tamanho do array
    }

    @Override
    public int getColumnCount() {//total colunas
        return colunas.length;
    }

    @Override//passa parametros para monstar a tabela
    public Object getValueAt(int numLin, int numCol) {
        if (getColumnCount() < 4) {
            Empresa e = (Empresa) linhas.get(numLin);
            switch (numCol) {
                case 0:
                    return e.getCodigo();
                case 1:
                    return e.getNome();
                case 2:
                    return e.getCnpj();
            }
        }
        if (getColumnCount() == 4) {
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
        if (getColumnCount() > 4) {
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
                    return ent.getHora_total();
            }
        }
        return null;
    }

    //metodos  digitados
    @Override
    public String getColumnName(int numCol) {
        return colunas[numCol];
    }

    //campos encapsulados..
    public List getLinhas() {
        return linhas;
    }

    public void setLinhas(List linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

}
