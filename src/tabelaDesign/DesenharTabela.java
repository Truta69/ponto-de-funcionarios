package tabelaDesign;

import java.awt.Color;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import modelo.ModeloTabela;

//CLASSE RECEBE TIPO GEBERICO E
//QUE PODE SER CLIeNTE, PRODUTO..
public class DesenharTabela<E> {

    //<E>LISTA DE alguma coisa...empresa...funcionario....
    public void renderizarTabela(JTable tabela, String[] colunas, int[] larguraRecebida, List<E> lista) {
        ModeloTabela model = ModeloTabela.gerarTabelaComLinhasEColunas(lista, colunas);
        tabela.setModel(model);
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setPreferredWidth(larguraRecebida[i]);//TAMANHO EM PIXEL (PARA CODIGO)
            tabela.getColumnModel().getColumn(i).setResizable(false);//NAO É REDIMENCIONAVEL COM O MOUSE
            tabela.getTableHeader().setReorderingAllowed(false);//NAO PODE REORDENAR
            tabela.setSelectionBackground(new Color(0, 0, 255));//cor linha selecionada
            tabela.setSelectionForeground(Color.WHITE);//cor fonte linha selecionada
            tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);//PEGAR TANMANHO DISPONIVEL DA COLUNA
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//SO PODE SELECIONAR UM ELEMENTO NA TABELA
        }
    }
}
