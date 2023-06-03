package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {

    private ArrayList linhas = null;//tipo de um vetor para linhas
    private String[] colunas = null;//vetor para colunas

    //tentando fazer uso do padro static metodo
    private ModeloTabela(ArrayList numLimhas, String[] numColunas) {//passa parametros
        setLinhas(numLimhas);
        setColunas(numColunas);
    }

    //para chamar da classe(new moelotabela)
    //com um nome significativo ver renderTabela
    public static ModeloTabela gerarTabelaComLinhasEColunas(ArrayList lin, String[] col) {
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
    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

}
