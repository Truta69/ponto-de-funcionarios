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
import modelo.Funcionario;

public class DaoFuncionario {

    static int codEmpresa;

    //lembrando que class.forName executa uma vez no app(la no DaoEmpresa!!!!!!)
    public static List<Funcionario> todosFuncionarios() {
        List<Funcionario> lista = new ArrayList<>();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select * from tab_funcionario";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();//recebe resultado
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setCodigoFuncionario(rs.getInt("id_funcionario"));
                f.setNomeFuncionario(rs.getString("nome_funcionario"));
                f.setCargaHoraria(rs.getString("carga_horaria"));
                f.setCod_empresa(rs.getInt("id_empresa"));
                lista.add(f);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar funcionario!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    //p carregar combo empresas tela de funcionarios
    //vou fazer aqui...mas pera i.....:da p pegar da classe
    //daoempresa...e  o mesmo codigo...so aqui que list de string!!!!!talvez usar generics...
    public static List<String> todasEmpresas() {
        List<String> todas = new ArrayList<>();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select * from tab_empresa order by nome_empresa";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();//recebe resultado
            Empresa emp = new Empresa();
            while (rs.next()) {
                emp.setCodigo(rs.getInt("id_empresa"));
                emp.setNome(rs.getString("nome_empresa"));
                emp.setCnpj(rs.getString("cnpj"));
                todas.add(emp.toString());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar empresa!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return todas;
    }

    //para inserir  o codigo empresa
    private static int recuperaCodEmpresa(Funcionario f) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select id_empresa from tab_empresa where nome_empresa= '" + f.getNomeEmpresa() + "'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                codEmpresa = rs.getInt("id_empresa");//result n esta posicionanado corretamente...sem rs.next...
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar empresa para inserir!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return codEmpresa;
    }

    public static void inserirFuncionario(Funcionario f) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            int codRecebido = recuperaCodEmpresa(f);//declarada como static
            String sql = "insert into tab_funcionario(nome_funcionario,carga_horaria,id_empresa)values(?,?,?) ";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, f.getNomeFuncionario());
            pst.setString(2, f.getCargaHoraria());
            pst.setInt(3, codRecebido);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir funcionario!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void upDateFuncionario(Funcionario func) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            int codRecebido = recuperaCodEmpresa(func);
            String sql = "update  tab_funcionario set nome_funcionario =? ,carga_horaria=?,id_empresa=? where id_funcionario=? ";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, func.getNomeFuncionario());
            pst.setString(2, func.getCargaHoraria());
            //pst.setInt(3, codRecebido);
            pst.setInt(3, func.getCod_empresa());
            pst.setInt(4, func.getCodigoFuncionario());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar funcionario!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    //pega click da tabela
    public static Funcionario getFuncionario(String nomeRecebido) {
        Funcionario f = new Funcionario();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select  * from tab_funcionario where  nome_funcionario='" + nomeRecebido + "'";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            //Funcionario f = new Funcionario();
            f.setCodigoFuncionario(rs.getInt("id_funcionario"));
            f.setNomeFuncionario(rs.getString("nome_funcionario"));
            f.setCargaHoraria(rs.getString("carga_horaria"));
            f.setCod_empresa(rs.getInt("id_empresa"));
            //return f;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return f;
    }

    public static void deletarFuncionario(Funcionario f) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "delete from tab_funcionario where id_funcionario=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, f.getCodigoFuncionario());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir funcionario!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<Funcionario> dadosFuncionarios(String nomeRecebido) throws SQLException {
        List<Funcionario> lista = new ArrayList<>();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select nome_funcionario, carga_horaria, nome_empresa,cnpj from tab_funcionario as func join tab_empresa as emp on func.id_empresa=emp.id_empresa where nome_funcionario='" + nomeRecebido + "'";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Funcionario f = new Funcionario();
            f.setNomeFuncionario(rs.getString("nome_funcionario"));
            f.setCargaHoraria(rs.getString("carga_horaria"));
            f.setNomeEmpresa(rs.getString("nome_empresa"));
            f.setCnpj(rs.getString("cnpj"));
            lista.add(f);
            return lista;
        }
    }
}
