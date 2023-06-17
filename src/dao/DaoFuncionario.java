package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Empresa;
import modelo.Funcionario;

public class DaoFuncionario {

    static int codEmpresa;

    //lembrando que class.forName executa uma vez no app(la no DaoEmpresa!!!!!!)
    public static List<Funcionario> todosFuncionarios() {
        List<Funcionario> lista = new ArrayList<>();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select * from tab_funcionario ";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();//recebe resultado
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setCodigoFuncionario(rs.getInt("id_funcionario"));
                f.setNomeFuncionario(rs.getString("nome_funcionario"));
                f.setFuncao(rs.getString("funcao"));
                f.setCod_empresa(rs.getInt("id_empresa"));
                lista.add(f);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possivel executar a conexão!!" + ex);
        }
        return lista;
    }

    //p carregar combo empresas tela de funcionarios
    //vou fazer aqui...mas pera i.....:da p pegar da classe
    //daoempresa...e  o mesmo codigo...so aqui que list de string!!!!!talvez usar generics...
    public static List<String> todasEmpresas() {
        List<String> todas = new ArrayList<>();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select * from tab_empresa";
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
            throw new RuntimeException("Não foi possivel executar a conexão!!" + ex);
        }
        return todas;
    }

    //para inserir e alterar o codigo empresa
    private static int recuperaCodEmpresa(Funcionario f) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select id_empresa from tab_empresa where nome_empresa= '" + f.getNomeEmpresa() + "'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                codEmpresa = rs.getInt("id_empresa");//result n esta posicionanado corretamente...sem rs.next...
            }
        }
        return codEmpresa;
    }

    public static void inserirFuncionario(Funcionario f) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            int codRecebido = recuperaCodEmpresa(f);//declarada como static
            String sql = "insert into tab_funcionario(nome_funcionario,funcao,id_empresa)values(?,?,?) ";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, f.getNomeFuncionario());
            pst.setString(2, f.getFuncao());
            pst.setInt(3, codRecebido);
            pst.executeUpdate();
        }
    }

    public static void upDateFuncionario(Funcionario func) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            int codRecebido = recuperaCodEmpresa(func);
            String sql = "update  tab_funcionario set nome_funcionario =? ,funcao=?,id_empresa=? where id_funcionario=? ";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, func.getNomeFuncionario());
            pst.setString(2, func.getFuncao());
            pst.setInt(3, codRecebido);
            pst.setInt(4, func.getCodigoFuncionario());
            pst.executeUpdate();
        }
    }

    //pega click da tabela
    public static Funcionario getFuncionario(String nomeRecebido) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select  * from tab_funcionario where  nome_funcionario='" + nomeRecebido + "'";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Funcionario f = new Funcionario();
            f.setCodigoFuncionario(rs.getInt("id_funcionario"));
            f.setNomeFuncionario(rs.getString("nome_funcionario"));
            f.setFuncao(rs.getString("funcao"));
            f.setCod_empresa(rs.getInt("id_empresa"));
            return f;
        }
    }

    public static void deletarFuncionario(Funcionario f) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "delete from tab_funcionario where id_funcionario=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, f.getCodigoFuncionario());
            pst.executeUpdate();
        }
    }
}
