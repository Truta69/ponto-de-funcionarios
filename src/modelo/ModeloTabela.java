package modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {

    private List linhas = null;//tipo de um vetor para linhas
    private String[] colunas = null;//vetor para colunas

    //tentando fazer uso do padro static metodo
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
        Object[] linha = (Object[]) getLinhas().get(numLin);
        return linha[numCol];
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
