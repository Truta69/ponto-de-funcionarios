package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Funcionario;

public class DaoPonto {

    //para carregar combo tela ponto
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

    public static ResultSet carregar() throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select nome_funcionario from tab_funcionario";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();//recebe resultado
            return rs;
        }
    }
}
