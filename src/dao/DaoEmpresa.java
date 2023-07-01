package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Empresa;

public class DaoEmpresa {

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
            JOptionPane.showMessageDialog(null, "Erro ao carregar empresas!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Erro ao inserir empresa!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    //CARREGAR CAMPOS PELO CLICK NA LINHA TABELA pega uma empresa.. nao uma lista
    public static Empresa getEmpresa(String nomeRecebido) {
        Empresa emp = new Empresa();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select  * from tab_empresa where  nome_empresa='" + nomeRecebido + "'";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();//recebe resultado para consultas
            rs.next();//
            emp.setCodigo(rs.getInt("id_empresa"));
            emp.setNome(rs.getString("nome_empresa"));
            emp.setCnpj(rs.getString("cnpj"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar empresa!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return emp;
    }

    public static void updateEmpresa(Empresa emp) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "update tab_empresa set nome_empresa=?, cnpj=? WHERE id_empresa=? ";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, emp.getNome());
            pst.setString(2, emp.getCnpj());
            pst.setInt(3, emp.getCodigo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar empresa!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void deletarEmpresa(Empresa empresa) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "delete from tab_empresa where id_empresa=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, empresa.getCodigo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir empresa!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }
}
