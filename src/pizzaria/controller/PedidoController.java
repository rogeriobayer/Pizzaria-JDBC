package pizzaria.controller;

import java.util.List;
import pizzaria.model.Pedido;
import pizzaria.model.dao.PedidoDao;
import pizzaria.view.TelaCliente;

public class PedidoController {

    private TelaCliente view;
    private PedidoDao modelDao;

    public PedidoController(TelaCliente view, PedidoDao modelDao) {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }

    private void initController() {
        this.view.setPedidoController(this);
        this.view.initPedidosView();
    }

    public void criarPedido() { //TELA PEDIDO
        try {
            Pedido pedido = view.getPedidoFormulario();
            modelDao.inserir(pedido);
            view.inserirPedidoView(pedido);
        } catch (Exception ex) {
            view.apresentaErro(ex.toString());

//            view.apresentaErro("Erro ao criar pedido.");
        }
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

    public void listarPedido() {
        try {
            List<Pedido> lista = this.modelDao.getLista();
            view.mostrarListaPedidos(lista);
        } catch (Exception ex) {
            //            view.apresentaErro(ex.toString());
            ;
            view.apresentaErro("Erro ao listar pedidos.");
        }
    }
}
