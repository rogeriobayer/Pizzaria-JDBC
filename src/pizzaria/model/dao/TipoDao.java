package pizzaria.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pizzaria.model.Tipo;

public class TipoDao {

    private ConnectionFactory connectionFactory;
    private final String select = "select * from tipo_pizza";
    private final String update = "update tipo_pizza set preco=? WHERE id=?";

    public TipoDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public List<Tipo> getLista() throws SQLException {
        Connection connection = connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(select);
        try {
            rs = stmtLista.executeQuery();
            List<Tipo> tipo = new ArrayList();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                Double preco = rs.getDouble("preco");
                tipo.add(new Tipo(id, nome, preco));
            }

            return tipo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
            stmtLista.close();
        }

    }

    public void atualizar(Integer type, Double value) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement stmtAtualiza = connection.prepareStatement(update);
        try {
            stmtAtualiza.setDouble(1, value);
            stmtAtualiza.setInt(2, type);
            stmtAtualiza.executeUpdate();
        } finally {
            stmtAtualiza.close();
        }

    }

}
