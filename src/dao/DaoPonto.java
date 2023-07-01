package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Funcionario;
import modelo.EntradaDeHorarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DaoPonto {

    static int codFuncionarios;

    public static List<EntradaDeHorarios> todosHorarios() {
        List<EntradaDeHorarios> lista = new ArrayList<>();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select * from tab_ponto order by dia";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                EntradaDeHorarios eh = new EntradaDeHorarios();
                eh.setDia(rs.getInt("dia"));
                eh.setHora_entrada(rs.getTime("hora_entrada"));
                eh.setHora_almoco(rs.getTime("hora_almoco"));
                eh.setHora_retorno(rs.getTime("hora_retorno"));
                eh.setHora_saida(rs.getTime("hora_saida"));
                lista.add(eh);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar horários!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    //seleciona funcionario pelo click combobox ou btn pesquisar..
    public static Funcionario todosFuncionarios(Funcionario f) {
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar horários!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return f;
    }

    //carrega combo tela ponto
    public static ResultSet carregar() {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select nome_funcionario from tab_funcionario";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();//recebe resultado
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar combo de funcionarios!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return null;
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

    private static int recuperaCodFuncionario(EntradaDeHorarios eh) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select id_funcionario from tab_funcionario where nome_funcionario= '" + eh.getNome_funcionario() + "'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                codFuncionarios = rs.getInt("id_funcionario");//result n esta posicionanado corretamente...sem rs.next...
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar ID de funcionarios!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return codFuncionarios;
    }

    //salvar entrda de pontos
    public static void inserirHorarios(EntradaDeHorarios entrada) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            int codRecebido = recuperaCodigoFuncionario(entrada);
            String sql = "insert into tab_ponto (dia,hora_entrada,hora_almoco,hora_retorno,hora_saida,id_funcionario)values(?,?,?,?,?,?)";
            //String sql = "update tab_ponto set  hora_entrada=?,hora_almoco=?,hora_retorno=?,hora_saida=?,id_funcionario where dia=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, entrada.getDia());
            pst.setTime(2, entrada.getHora_entrada());
            pst.setTime(3, entrada.getHora_almoco());
            pst.setTime(4, entrada.getHora_retorno());
            pst.setTime(5, entrada.getHora_saida());
            pst.setInt(6, codRecebido);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir horarios!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void upDatePonto(EntradaDeHorarios entra) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            int codRecebido = recuperaCodFuncionario(entra);
            String sql = "update  tab_ponto set hora_entrada =?, hora_almoco=?, hora_retorno=?, hora_saida=?, id_funcionario=?, dia = ? where id_ponto=? ";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setTime(1, entra.getHora_entrada());
            pst.setTime(2, entra.getHora_almoco());
            pst.setTime(3, entra.getHora_retorno());
            pst.setTime(4, entra.getHora_saida());
            pst.setInt(5, entra.getId_funcionario());
            pst.setInt(6, entra.getDia());
            pst.setInt(7, entra.getId_entrada());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar horarios!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    //pega click da tabela
    public static EntradaDeHorarios getHorarios(String horarios) {
        EntradaDeHorarios ent = new EntradaDeHorarios();
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "select  * from tab_ponto where  hora_entrada='" + horarios + "'";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            ent.setId_entrada(rs.getInt("id_ponto"));
            ent.setHora_entrada(rs.getTime("hora_entrada"));
            ent.setHora_almoco(rs.getTime("hora_almoco"));
            ent.setHora_retorno(rs.getTime("hora_retorno"));
            ent.setHora_saida(rs.getTime("hora_saida"));
            ent.setId_funcionario(rs.getInt("id_funcionario"));
            ent.setDia(rs.getInt("dia"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return ent;
    }

    public static void deletarHorarios(EntradaDeHorarios ent) {
        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_ponto", "postgres", "1234")) {
            String sql = "delete from tab_ponto where id_ponto=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, ent.getId_entrada());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir horários!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    //alterar para receber um generic para limpar qualquer lista
    public static List<EntradaDeHorarios> limparLista() {
        List<EntradaDeHorarios> listaLimpa = new ArrayList<>();
        listaLimpa.clear();//metodo inteface List...remove da lista..
        return listaLimpa;
    }
}
