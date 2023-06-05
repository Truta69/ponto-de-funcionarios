package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Empresa;

public class DaoEmpresa {

    static {//chama uma vez
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }
    }

    public static List<Empresa> todasEmpresas() {
        List<Empresa> todas = new ArrayList<>();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select * from tab_empresa order by id_empresa";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();//recebe resultado
            while (rs.next()) {
                Empresa emp = new Empresa();
                emp.setCodigo((rs.getInt("id_empresa")));//nomes do banco
                emp.setNome(rs.getString("nome_empresa"));
                emp.setCnpj(rs.getString("cnpj"));
                todas.add(emp);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possivel executar a conexão!!" + ex);
        }
        return todas;
    }

    public static void inserirEmpresas(Empresa emp) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "insert into tab_empresa(nome_empresa,cnpj)values(?,?) ";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, emp.getNome());
            stm.setString(2, emp.getCnpj());
            stm.executeUpdate();//para insert
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possivel executar a conexão!!" + ex);
        }
    }
}
