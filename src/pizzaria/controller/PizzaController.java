package pizzaria.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.List;
import pizzaria.model.Forma;
import pizzaria.model.Pedido;
import pizzaria.model.Pizza;
import pizzaria.model.dao.ConnectionFactory;
import pizzaria.model.dao.PizzaDao;
import pizzaria.utils.FormaPizzaEnum;
import pizzaria.view.TelaNovasPizzas;
import pizzaria.view.TelaNovosPedidos;

public class PizzaController {

    private TelaNovasPizzas view;
    private PizzaDao modelDao;
    private TelaNovosPedidos viewPedidos;

    public PizzaController(TelaNovasPizzas view, PizzaDao modelDao) throws SQLException {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }

    public PizzaController(TelaNovosPedidos viewPedidos, PizzaDao modelDao) {
        this.viewPedidos = viewPedidos;
        this.modelDao = modelDao;
        initControllerPedidos();
    }

    private void initController() throws SQLException {
        this.view.setPizzaController(this);
        this.view.initPizzasView();
    }

    private void initControllerPedidos() {
        this.viewPedidos.setPizzaController(this);
        this.viewPedidos.initPedidosView();
    }

    public void criarPizza() {
        try {
            Pizza pizza = view.getPizzaFormulario();
            Forma forma = pizza.getForma();
            if (pizza.isIsMetricaCmQuadrado()) {
                pizza.setArea(pizza.getLadoOuRaio());
                pizza.setLadoOuRaio(forma.calcularLadoOuRaio(pizza.getArea()));
            } else {
                pizza.setArea(forma.calcularArea(pizza.getLadoOuRaio()));
            }

            if (forma.getForma() == FormaPizzaEnum.QUADRADO && (pizza.getLadoOuRaio() < 10 || pizza.getLadoOuRaio() > 40) && !pizza.isIsMetricaCmQuadrado()) {
                view.apresentaInfo("O tamanho do lado para pizzas quadradas é de no mínimo 10cm e no máximo 40cm");
                return;
            } else if (forma.getForma() == FormaPizzaEnum.TRIANGULO && (pizza.getLadoOuRaio() < 20 || pizza.getLadoOuRaio() > 60) && !pizza.isIsMetricaCmQuadrado()) {
                view.apresentaInfo("O tamanho do lado para pizzas triangulares é de no mínimo 20cm e no máximo 60cm");
                return;
            } else if (forma.getForma() == FormaPizzaEnum.CIRCULO && (pizza.getLadoOuRaio() < 7 || pizza.getLadoOuRaio() > 23) && !pizza.isIsMetricaCmQuadrado()) {
                view.apresentaInfo("O tamanho do raio para pizzas circulares é de no mínimo 10cm e no máximo 23cm");
                return;
            } else if (pizza.isIsMetricaCmQuadrado() && (pizza.getArea() < 100 || pizza.getArea() > 1600)) {
                view.apresentaInfo("O tamanho da área da pizza deve ser de no mínimo 100cm2 e de no máximo 1600cm2");
                return;
            }
            Double preco1 = modelDao.getPrecoSabor1(pizza.getSabor1());
            Double preco2 = modelDao.getPrecoSabor2(pizza.getSabor2());
            pizza.setPrecoTotal(((pizza.getArea() * preco1) + (pizza.getArea() * preco2)) / 2);
            BigDecimal bd = new BigDecimal(((pizza.getArea() * preco1) + (pizza.getArea() * preco2)) / 2).setScale(2, RoundingMode.HALF_UP);
            Double parsedPrice = bd.doubleValue();
            pizza.setPrecoTotal(parsedPrice);
            modelDao.inserir(pizza);
            view.atualizarTotal(modelDao.recalcTotal(pizza.getPedido()));
            view.inserirPizzaView(pizza);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao adicionar pizza ao pedido.");
        }
    }

    public void atualizarPizza() {
        try {
            Pizza pizza = view.getPizzaParaAtualizar();
            if (pizza == null) {
                viewPedidos.apresentaInfo("Selecione um pizza na tabela para atualizar.");
                return;
            }

            Forma forma = pizza.getForma();

            if (pizza.isIsMetricaCmQuadrado()) {
                pizza.setArea(pizza.getLadoOuRaio());
                pizza.setLadoOuRaio(forma.calcularLadoOuRaio(pizza.getArea()));
            } else {
                pizza.setArea(forma.calcularArea(pizza.getLadoOuRaio()));
            }

            if (forma.getForma() == FormaPizzaEnum.QUADRADO && (pizza.getLadoOuRaio() < 10 || pizza.getLadoOuRaio() > 40) && !pizza.isIsMetricaCmQuadrado()) {
                view.apresentaInfo("O tamanho do lado para pizzas quadradas é de no mínimo 10cm e no máximo 40cm");
                return;
            } else if (forma.getForma() == FormaPizzaEnum.TRIANGULO && (pizza.getLadoOuRaio() < 20 || pizza.getLadoOuRaio() > 60) && !pizza.isIsMetricaCmQuadrado()) {
                view.apresentaInfo("O tamanho do lado para pizzas triangulares é de no mínimo 20cm e no máximo 60cm");
                return;
            } else if (forma.getForma() == FormaPizzaEnum.CIRCULO && (pizza.getLadoOuRaio() < 7 || pizza.getLadoOuRaio() > 23) && !pizza.isIsMetricaCmQuadrado()) {
                view.apresentaInfo("O tamanho do raio para pizzas circulares é de no mínimo 10cm e no máximo 23cm");
                return;
            } else if (pizza.isIsMetricaCmQuadrado() && (pizza.getArea() < 100 || pizza.getArea() > 1600)) {
                view.apresentaInfo("O tamanho da área da pizza deve ser de no mínimo 100cm2 e de no máximo 1600cm2");
                return;
            }
            Double preco1 = modelDao.getPrecoSabor1(pizza.getSabor1());
            Double preco2 = modelDao.getPrecoSabor2(pizza.getSabor2());
            BigDecimal bd = new BigDecimal(((pizza.getArea() * preco1) + (pizza.getArea() * preco2)) / 2).setScale(2, RoundingMode.HALF_UP);
            Double parsedPrice = bd.doubleValue();
            pizza.setPrecoTotal(parsedPrice);

            modelDao.atualizar(pizza);
            view.atualizarTotal(modelDao.recalcTotal(pizza.getPedido()));
            view.atualizarPizza(pizza);

        } catch (Exception ex) {
            view.apresentaErro("Erro ao atualizar pizza.");
        }
    }

    public void excluirPizza() {
        try {
            List<Pizza> listaParaExcluir = view.getPizzasParaExcluir();
            if (listaParaExcluir == null || listaParaExcluir.equals("null") || listaParaExcluir.isEmpty()) {
                viewPedidos.apresentaInfo("Selecione um pedido para excluir.");
                return;
            }
            modelDao.excluirLista(listaParaExcluir);
            view.excluirPizzasView(listaParaExcluir);
            view.atualizarTotal(modelDao.recalcTotal(listaParaExcluir.get(0).getPedido()));
        } catch (Exception ex) {
            view.apresentaErro("Erro ao excluir pedidos.");
        }
    }

    public void listarPizza() {
        try {
            List<Pizza> lista = this.modelDao.getLista(view.getPedidoSelecionado());
            if (lista == null || lista.isEmpty()) {
                view.apresentaInfo("Não há pizzas nesse pedido");
                return;
            }
            view.mostrarListaPizzas(lista);
        } catch (Exception ex) {
            view.apresentaInfo("Não há pizzas cadastradas para esse pedido.");
        }
    }

    public void atualizarNovoPizza() {
        try {
            Pedido pedido = viewPedidos.getPedidoSelecionado();
            if (pedido == null || pedido.equals("null")) {
                viewPedidos.apresentaInfo("Selecione um pedido para atualizar.");
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
            view.apresentaErro("Erro ao abrir a tela Nova Pizza.");
        }
    }

    public void fecharNovaPizza() {
        try {
            view.setVisible(false);
        } catch (Exception ex) {
            viewPedidos.apresentaErro("Erro ao fechar a tela de novas pizzas.");
        }
    }

}
