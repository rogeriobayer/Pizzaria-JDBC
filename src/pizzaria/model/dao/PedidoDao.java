package pizzaria.model.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pizzaria.model.Cliente;

public class ClienteDao {
// a conexão com o banco de dados

    private ConnectionFactory connectionFactory;
    private final String insert = "insert into clientes (nome,email,endereco,dataNascimento) values (?,?,?,?)";
    private final String select = "select * from clientes";
    private final String update = "update clientes set nome=?, email=?, endereco=?, dataNascimento=? WHERE id=?";
    private final String delete = "delete from clientes WHERE id=?";

    public ClienteDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public void inserir(Cliente cliente) {
        Connection connection = connectionFactory.getConnection();
        try {
            // prepared statement para inserção
            PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            // seta os valores
            stmtAdiciona.setString(1, cliente.getNome());
            stmtAdiciona.setString(2, cliente.getSobrenome());
            stmtAdiciona.setString(3, cliente.getTelefone());
            stmtAdiciona.setArray(4, cliente.getArray());
            // executa
            stmtAdiciona.execute();
            //Seta o id do cliente
//            ResultSet rs = stmtAdiciona.getGeneratedKeys();
//            rs.next();
//            long i = rs.getLong(1);
//            cliente.setId(i);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getLista() throws SQLException {
        Connection connection = connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(select);
        try {
            rs = stmtLista.executeQuery();
            List<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                // criando o objeto Cliente
                //Cliente cliente = new Cliente();
                String id = rs.getString("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String telefone = rs.getString("telefone");
//                LocalDate dataNascimento = rs.getDate("dataNascimento").toLocalDate();
                Array pedidosArray = rs.getArray("pedidosArray");

                // adicionando o objeto à lista
                clientes.add(new Cliente(id, nome, sobrenome, telefone, pedidosArray));
            }

            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
            stmtLista.close();
        }

    }

    public void atualizar(Cliente cliente) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement stmtAtualiza = connection.prepareStatement(update);
        try {
            stmtAtualiza.setString(1, cliente.getId());

            stmtAtualiza.setString(2, cliente.getNome());
            stmtAtualiza.setString(3, cliente.getSobrenome());
            stmtAtualiza.setString(4, cliente.getTelefone());
            stmtAtualiza.setArray(5, cliente.getArray());
//            stmtAtualiza.setLong(5, cliente.getId());
            stmtAtualiza.executeUpdate();
        } finally {
            stmtAtualiza.close();
        }

    }

    public void exluirLista(List<Cliente> clientes) throws SQLException {
        for (Cliente cliente : clientes) {
            excluir(cliente);
        }
    }

    public void excluir(Cliente cliente) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement stmtExcluir;
        stmtExcluir = connection.prepareStatement(delete);
        try {
            stmtExcluir.setString(1, cliente.getId());
            stmtExcluir.executeUpdate();
        } finally {
            stmtExcluir.close();
        }

    }
}
