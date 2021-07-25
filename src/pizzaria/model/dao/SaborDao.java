package pizzaria.model.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pizzaria.model.Sabor;

public class SaborDao {
// a conexão com o banco de dados

    private ConnectionFactory connectionFactory;
    private final String insert = "insert into sabores (id, nome,tipo) values (?,?,?)";
    private final String select = "select * from sabores";
    private final String update = "update sabores set nome=?, tipo=?WHERE id=?";
    private final String delete = "delete from sabores WHERE id=?";
    private final String search = "SELECT * FROM sabores WHERE nome LIKE ? OR tipo LIKE ?";

    private final String preco = "select * from tipo_pizza WHERE id=?";

    public SaborDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public void inserir(Sabor sabor) {
        Connection connection = connectionFactory.getConnection();
        try {
            // prepared statement para inserção
            PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            // seta os valores
            stmtAdiciona.setString(1, sabor.getId());
            stmtAdiciona.setString(2, sabor.getNome());
            stmtAdiciona.setInt(3, sabor.getTipo());
//            stmtAdiciona.setArray(5, sabor.getArray());
            // executa
            stmtAdiciona.execute();
            //Seta o id do sabor
//            ResultSet rs = stmtAdiciona.getGeneratedKeys();
//            rs.next();
//            long i = rs.getLong(1);
//            sabor.setId(i);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Sabor> getLista() throws SQLException {
        Connection connection = connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(select);
        try {
            rs = stmtLista.executeQuery();
            List<Sabor> sabores = new ArrayList();
            while (rs.next()) {
                // criando o objeto Sabor
                //Sabor sabor = new Sabor();
                String id = rs.getString("id");
                String nome = rs.getString("nome");
                Integer tipo = rs.getInt("tipo");
//                LocalDate dataNascimento = rs.getDate("dataNascimento").toLocalDate();
//                Array pedidosArray = rs.getArray("pedidosArray");

                // adicionando o objeto à lista
                sabores.add(new Sabor(id, nome, tipo));
            }

            return sabores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
            stmtLista.close();
        }
    }

    public List<Sabor> getListaFiltrada(String query) throws Exception {
        Connection connection = connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtFilter = connection.prepareStatement(search);
        try {
            stmtFilter.setString(1, "%" + query + "%");
            stmtFilter.setString(2, "%" + query + "%");
            rs = stmtFilter.executeQuery();
            List<Sabor> sabores = new ArrayList();
            while (rs.next()) {

                String id = rs.getString("id");
                String nome = rs.getString("nome");
                Integer tipo = rs.getInt("tipo");
                String telefone = rs.getString("telefone");

                sabores.add(new Sabor(id, nome, tipo));
            }

            return sabores;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
            stmtFilter.close();
        }

    }

    public void atualizar(Sabor sabor) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement stmtAtualiza = connection.prepareStatement(update);
        try {
            stmtAtualiza.setString(1, sabor.getId());
            stmtAtualiza.setString(2, sabor.getNome());
            stmtAtualiza.setInt(3, sabor.getTipo());
            stmtAtualiza.executeUpdate();
        } finally {
            stmtAtualiza.close();
        }

    }

    public void excluirLista(List<Sabor> sabores) throws SQLException {
        for (Sabor sabor : sabores) {
            excluir(sabor);
        }
    }

    public void excluir(Sabor sabor) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement stmtExcluir;
        stmtExcluir = connection.prepareStatement(delete);
        try {
            stmtExcluir.setString(1, sabor.getId());
            stmtExcluir.executeUpdate();
        } finally {
            stmtExcluir.close();
        }

    }
}
