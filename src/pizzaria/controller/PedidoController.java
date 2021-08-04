package pizzaria.controller;

import java.util.List;
import pizzaria.model.Cliente;
import pizzaria.model.Pedido;
import pizzaria.model.dao.ConnectionFactory;
import pizzaria.model.dao.PedidoDao;
import pizzaria.model.dao.PizzaDao;
import pizzaria.view.TelaCliente;
import pizzaria.view.TelaNovosPedidos;

public class PedidoController {

    private TelaCliente view;
    private PedidoDao modelDao;
    private TelaNovosPedidos viewPedidos;

    public PedidoController(TelaCliente view, PedidoDao modelDao) {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }

    public PedidoController(TelaNovosPedidos viewPedidos, PedidoDao modelDao) {
        this.viewPedidos = viewPedidos;
        this.modelDao = modelDao;
        initControllerPedidos();
    }

    private void initController() {
        this.view.setPedidoController(this);
        this.view.initPedidosView();
    }

    private void initControllerPedidos() {
        this.viewPedidos.setPedidoController(this);
        this.viewPedidos.initPedidosView();
    }

    public void atualizarPedido() {
        try {
            Pedido pedido = view.getPedidoParaAtualizar();
            if (pedido == null) {
                view.apresentaInfo("Selecione um pedido na tabela para atualizar.");
                return;
            }
            modelDao.atualizar(pedido);
            view.atualizarPedido(pedido);
        } catch (Exception ex) {
            view.apresentaErro(ex.getMessage());
            view.apresentaErro("Erro ao atualizar pedido.");
        }
    }

    public void excluirPedido() {
        try {
            List<Pedido> listaParaExcluir = viewPedidos.getPedidosParaExcluir();
            if (listaParaExcluir == null || listaParaExcluir.isEmpty()) {
                viewPedidos.apresentaInfo("Selecione pelo menos um pedido na tabela para excluir.");
                return;
            }
            modelDao.excluirLista(listaParaExcluir);
            viewPedidos.excluirPedidosView(listaParaExcluir);
        } catch (Exception ex) {
            viewPedidos.apresentaErro("Erro ao excluir clientes.");
        }
    }

    public void listarPedido() {
        try {
            List<Pedido> lista = this.modelDao.getLista();
            view.mostrarListaPedidos(lista);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao listar pedidos.");
        }
    }

    public void listarPedidoClienteSelecionado() {
        try {
            List<Pedido> lista = this.modelDao.getListaPorCliente(viewPedidos.getClienteSelecionado()
            );
            viewPedidos.mostrarListaPedidos(lista);
        } catch (Exception ex) {
            viewPedidos.apresentaErro("Erro ao listar pedidos.");
        }
    }

    public void abrirNovoPedido() {
        try {
            Cliente cliente = view.getClienteParaAtualizar();
            if (cliente == null) {
                view.apresentaInfo("Selecione um cliente para criar novo pedido.");
                return;
            }
            viewPedidos = new TelaNovosPedidos(cliente);
            PedidoDao pedidoDao = new PedidoDao(new ConnectionFactory());
            PedidoController pedidoController = new PedidoController(viewPedidos, pedidoDao);
            PizzaDao pizzaDao = new PizzaDao(new ConnectionFactory());
            PizzaController pizzaController = new PizzaController(viewPedidos, pizzaDao);
            viewPedidos.setVisible(true);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao abrir a tela Novo Pedido.");
        }
    }

    public void fecharNovoPedido() {
        try {
            viewPedidos.setVisible(false);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao listar clientes.");
        }
    }

}
