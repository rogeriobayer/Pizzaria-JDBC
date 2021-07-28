package pizzaria.model;

import java.sql.SQLException;
import java.util.UUID;
import pizzaria.utils.EstadosEnum;
import pizzaria.model.dao.ClienteDao;
import pizzaria.model.dao.ConnectionFactory;

public class Pedido {

    private String id;
    private String idCliente;
    private double preco;
    private Integer estado;

    ClienteDao modelDao = new ClienteDao(new ConnectionFactory());

    public Pedido(String idCliente,
            double preco,
            int estado) {
        this.id = UUID.randomUUID().toString();
        this.idCliente = idCliente;
        this.estado = estado;
        this.preco = preco;
    }

    public Pedido(String id, String idCliente,
            double preco,
            Integer estado) {
        this.id = id;
        this.idCliente = idCliente;
        this.estado = estado;
        this.preco = preco;
    }

    public Pedido(String idCliente) {
        this.id = UUID.randomUUID().toString();
        this.estado = EstadosEnum.ABERTO;
        this.idCliente = idCliente;
        this.preco = 0;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getEstadoString() {
        switch (estado) {
            case 0:
                return "Aberto";
            case 1:
                return "A caminho";

            case 2:
                return "Entregue";

        }
        return null;
    }

    public String getTelefone() throws SQLException {
        System.out.print(this.idCliente);

        return this.modelDao.getTelefone(this.idCliente);
    }

    public void setTelefone(int estado) {
        this.estado = estado;
    }
}
