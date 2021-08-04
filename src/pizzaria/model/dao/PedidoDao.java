package pizzaria.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import pizzaria.model.Pedido;

public class PedidoDao {
// a conexão com o banco de dados

    private ConnectionFactory connectionFactory;
    private final String insert = "insert into pedidos (id,preco,id_cliente,estado) values (?,?,?,?)";
    private final String select = "select * from pedidos";
    private final String update = "update pedidos set  preco=?, id_cliente=?, estado=? WHERE id=?";
    private final String delete = "delete from pedidos WHERE id=?";
    private final String selectWhere = "select * from pedidos where id_cliente = ?";

    public PedidoDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public void inserir(Pedido pedido) {
        Connection connection = connectionFactory.getConnection();
        try {
            // prepared statement para inserção
            PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            // seta os valores
            stmtAdiciona.setString(1, pedido.getId());
            stmtAdiciona.setDouble(2, pedido.getPreco());
            stmtAdiciona.setString(3, pedido.getIdCliente());
            stmtAdiciona.setInt(4, pedido.getEstado());
            // executa
            stmtAdiciona.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Pedido> getLista() throws SQLException {
        Connection connection = connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(select);
        try {
            rs = stmtLista.executeQuery();
            List<Pedido> pedidos = new ArrayList();
            while (rs.next()) {
                String id = rs.getString("id");
                Double preco = rs.getDouble("preco");
                String idCliente = rs.getString("id_cliente");
                Integer estado = rs.getInt("estado");
                pedidos.add(new Pedido(id, idCliente, preco, estado));
            }
            return pedidos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
            stmtLista.close();
        }

    }

    public List<Pedido> getListaPorCliente(String id_cliente) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(selectWhere);
        try {
            stmtLista.setString(1, id_cliente); ///pedido.getId()

            rs = stmtLista.executeQuery();
            List<Pedido> pedidos = new ArrayList();
            while (rs.next()) {
                String id = rs.getString("id");
                Double preco = rs.getDouble("preco");
                String idCliente = rs.getString("id_cliente");
                Integer estado = rs.getInt("estado");
                pedidos.add(new Pedido(id, idCliente, preco, estado));
            }
            return pedidos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
            stmtLista.close();
        }

    }

    public void excluirPorCliente(String id_cliente) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PizzaDao pizzaDao = new PizzaDao(connectionFactory);
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(selectWhere);
        try {
            stmtLista.setString(1, id_cliente);
            rs = stmtLista.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                pizzaDao.excludeByOrderId(id);
                excludeById(id);
            }
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
            stmtLista.close();
        }

    }

    public void atualizar(Pedido pedido) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement stmtAtualiza = connection.prepareStatement(update);
        try {
            stmtAtualiza.setDouble(1, pedido.getPreco());
            stmtAtualiza.setString(2, pedido.getIdCliente());
            stmtAtualiza.setInt(3, pedido.getEstado());
            stmtAtualiza.setString(4, pedido.getId());
            stmtAtualiza.executeUpdate();
        } finally {
            stmtAtualiza.close();
        }

    }

    public void excluirLista(List<Pedido> pedidos) throws SQLException {
        for (Pedido pedido : pedidos) {
            excluir(pedido);
        }
    }

    public void excluir(Pedido pedido) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement stmtExcluir;
        stmtExcluir = connection.prepareStatement(delete);
        try {
            stmtExcluir.setString(1, pedido.getId());
            stmtExcluir.executeUpdate();
        } finally {
            stmtExcluir.close();
        }
    }

    public void excludeById(String id_pedido) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement stmtExcluir;
        stmtExcluir = connection.prepareStatement(delete);
        try {
            stmtExcluir.setString(1, id_pedido);
            stmtExcluir.executeUpdate();
        } finally {
            stmtExcluir.close();
        }

    }
}
