package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Funcionario;
import modelo.EntradaDeHorarios;

public class DaoPonto {

    static int codFuncionarios;

    //seleciona funcionario pelo click combobox ou btn pesquizar..
    public static Funcionario todosFuncionarios(Funcionario f) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select * from tab_empresa  as emp join  tab_funcionario as func on emp.id_empresa=func.id_empresa where nome_funcionario ='" + f.getNomeFuncionario() + "'";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();//recebe resultado
            while (rs.next()) {
                f.setNomeFuncionario(rs.getString("nome_funcionario"));
                f.setFuncao(rs.getString("funcao"));
                f.setNomeEmpresa(rs.getString("nome_empresa"));
                f.setCnpj(rs.getString("cnpj"));
            }
            return f;
        }
    }

    //carrega combo tela ponto
    public static ResultSet carregar() throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select nome_funcionario from tab_funcionario";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();//recebe resultado
            return rs;
        }
    }

    //p inserir
    private static int recuperaCodigoFuncionario(EntradaDeHorarios entrada) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select id_funcionario from tab_funcionario where nome_funcionario= '" + entrada.getNome_funcionario() + "'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                codFuncionarios = rs.getInt("id_funcionario");
            }
        }
        return codFuncionarios;
    }

    //salvar entrda de pontos
    public static void inserirHorarios(EntradaDeHorarios entrada) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            int codRecebido = recuperaCodigoFuncionario(entrada);
            String sql = "insert into tab_ponto (hora_entrada,hora_almoco,hora_retorno,hora_saida,id_funcionario)values(?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, entrada.getHora_entrada());
            pst.setString(2, entrada.getHora_almoco());
            pst.setString(3, entrada.getHora_retorno());
            pst.setString(4, entrada.getHora_saida());
            pst.setInt(5, codRecebido);
            pst.executeUpdate();
        }
    }
}
