package pizzaria.model.dao;

import java.sql.Array;
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
    private final String insert = "insert into pedidos (id,preco,idcliente,estado) values (?,?,?,?)";
    private final String select = "select * from pedidos";
    private final String update = "update pedidos set id=?, preco=?, idcliente=?, estado=? WHERE id=?";
    private final String delete = "delete from pedidos WHERE id=?";

    public PedidoDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public void inserir(Pedido pedido) {
        Connection connection = connectionFactory.getConnection();
        try {
            // prepared statement para inserção
            PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            // seta os valores
            stmtAdiciona.setString(1, UUID.randomUUID().toString()); ///pedido.getId()
            stmtAdiciona.setDouble(2, pedido.getPreco());
            stmtAdiciona.setString(3, pedido.getIdCliente());
            stmtAdiciona.setInt(4, pedido.getEstado());
            // executa
            stmtAdiciona.execute();
            //Seta o id do pedido
//            ResultSet rs = stmtAdiciona.getGeneratedKeys();
//            rs.next();
//            long i = rs.getLong(1);
//            pedido.setId(i);

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
                // criando o objeto Pedido
                //Pedido pedido = new Pedido();
                String id = rs.getString("id");
                Double preco = rs.getDouble("preco");
                String idCliente = rs.getString("idCliente");
                Integer estado = rs.getInt("estado");
//                LocalDate dataNascimento = rs.getDate("dataNascimento").toLocalDate();
//                Array pedidosArray = rs.getArray("pedidosArray");

                // adicionando o objeto à lista
                pedidos.add(new Pedido(id, preco, idCliente, estado));
            }

            return pedidos;
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
            stmtAtualiza.setString(1, pedido.getId());

            stmtAtualiza.setDouble(2, pedido.getPreco());
            stmtAtualiza.setString(3, pedido.getIdCliente());
            stmtAtualiza.setInt(4, pedido.getEstado());
//            stmtAtualiza.setArray(5, pedido.getArray());
//            stmtAtualiza.setLong(5, pedido.getId());;
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
}
