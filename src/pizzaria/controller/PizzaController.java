package pizzaria.controller;

import java.util.List;
import pizzaria.model.Pedido;
import pizzaria.model.Pizza;
import pizzaria.model.dao.ConnectionFactory;
import pizzaria.model.dao.PizzaDao;
import pizzaria.view.TelaNovasPizzas;
import pizzaria.view.TelaNovosPedidos;

public class PizzaController {

    private TelaNovasPizzas view;
    private PizzaDao modelDao;
    private TelaNovosPedidos viewPedidos;

    public PizzaController(TelaNovasPizzas view, PizzaDao modelDao) {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }

    public PizzaController(TelaNovosPedidos viewPedidos, PizzaDao modelDao) {
        this.viewPedidos = viewPedidos;
        this.modelDao = modelDao;
        initControllerPedidos();
    }

    private void initController() {
        this.view.setPizzaController(this);
        this.view.initPizzasView();
    }

    private void initControllerPedidos() {
        this.viewPedidos.setPizzaController(this);
        this.viewPedidos.initPedidosView();
    }

    public void criarPizza() {
        try {
            System.out.printf(modelDao.toString());
            Pizza pizza = view.getPizzaFormulario();
            System.out.printf(pizza.toString());
            System.out.printf("");

            modelDao.inserir(pizza);
            view.inserirPizzaView(pizza);
        } catch (Exception ex) {
            view.apresentaErro(ex.toString());
        }
    }

    public void atualizarPizza() {
        try {
            Pizza pizza = view.getPizzaParaAtualizar();
            if (pizza == null) {
                viewPedidos.apresentaInfo("Selecione um pizza na tabela para atualizar.");
                return;
            }
            modelDao.atualizar(pizza);
            view.atualizarPizza(pizza);
        } catch (Exception ex) {
            viewPedidos.apresentaErro(ex.getMessage());
//            view.apresentaErro("Erro ao atualizar pizza.");
        }
    }

    public void excluirPizza() {
        try {
            List<Pizza> listaParaExcluir = view.getPizzasParaExcluir();
            modelDao.excluirLista(listaParaExcluir);
            view.excluirPizzasView(listaParaExcluir);
        } catch (Exception ex) {
            viewPedidos.apresentaErro("Erro ao excluir pedidos.");
        }
    }

    public void listarPizza() {
        try {

            List<Pizza> lista = this.modelDao.getLista();
            view.mostrarListaPizzas(lista);
        } catch (Exception ex) {
            viewPedidos.apresentaErro("Erro ao listar pedidos.");
        }
    }

    public void atualizarNovoPizza() {
        try {
            Pedido pedido = viewPedidos.getPedidoSelecionado();
            System.out.print(pedido);
            if (pedido == null || pedido.equals("null")) {
                viewPedidos.apresentaInfo("Selecione um pedido.");
                return;
            }
            String cliente = viewPedidos.getClienteSelecionado();

            view = new TelaNovasPizzas(pedido, cliente);
            PizzaDao pedidoDao = new PizzaDao(new ConnectionFactory());
            PizzaController pizzaController = new PizzaController(view, pedidoDao);
            view.setVisible(true);

        } catch (Exception ex) {
            viewPedidos.apresentaErro("Erro ao abrir a tela Nova Pizza.");
        }
    }

    public void abrirNovoPizza() {
        try {
            String cliente = viewPedidos.getClienteSelecionado();
            view = new TelaNovasPizzas(cliente);
            PizzaDao pedidoDao = new PizzaDao(new ConnectionFactory());
            PizzaController pizzaController = new PizzaController(view, pedidoDao);
            view.setVisible(true);

        } catch (Exception ex) {
            viewPedidos.apresentaErro("Erro ao abrir a tela Nova Pizza.");
        }
    }

    public void fecharNovaPizza() {
        try {
            view.setVisible(false);

//            List<Cliente> lista = this.modelDao.getLista();
//            view.mostrarListaClientes(lista);
        } catch (Exception ex) {
            viewPedidos.apresentaErro("Erro ao listar clientes.");
        }
    }

}
