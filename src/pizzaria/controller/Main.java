package pizzaria.controller;

import pizzaria.model.dao.ConnectionFactory;
import pizzaria.model.dao.ClienteDao;
import pizzaria.model.dao.PedidoDao;
import pizzaria.model.dao.SaborDao;
import pizzaria.model.dao.TipoDao;
import pizzaria.view.TelaPrincipal;

public class Main {

    public static void main(String[] args) {
        TelaPrincipal view = new TelaPrincipal();
        ClienteDao modelDao = new ClienteDao(new ConnectionFactory());
        ClienteController controller = new ClienteController(view, modelDao);
        SaborDao saborDao = new SaborDao(new ConnectionFactory());
        SaborController saborController = new SaborController(view, saborDao);
        TipoDao tipoDao = new TipoDao(new ConnectionFactory());
        TipoController tipoController = new TipoController(view, tipoDao);
        PedidoDao pedidoDao = new PedidoDao(new ConnectionFactory());
        PedidoController pedidoController = new PedidoController(view, pedidoDao);
    }

}
