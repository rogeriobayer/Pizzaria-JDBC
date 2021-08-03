package pizzaria.controller;

import java.util.List;
import pizzaria.model.Sabor;
import pizzaria.model.dao.SaborDao;
import pizzaria.view.TelaCliente;

public class SaborController {

    private TelaCliente view;
    private SaborDao modelDao;

    public SaborController(TelaCliente view, SaborDao modelDao) {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }

    private void initController() {
        this.view.setSaborController(this);
        this.view.initSaboresView();
    }

    public void criarSabor() {
        try {
            Sabor sabor = view.getSaborFormulario();
            if (sabor == null || sabor.getNome().isEmpty()) {
                view.apresentaInfo("Preencha corretamente os campos para criar novo sabor");
                return;
            }
            modelDao.inserir(sabor);
            view.inserirSaborView(sabor);
        } catch (Exception ex) {

            view.apresentaErro("Erro ao criar sabor.");
        }
    }

    public void atualizarSabor() {
        try {

            Sabor sabor = view.getSaborParaAtualizar();
            if (sabor == null || sabor.getNome().isEmpty()) {
                view.apresentaInfo("Selecione um sabor na tabela para atualizar.");
                return;
            }
            modelDao.atualizar(sabor);
            view.atualizarSabor(sabor);

        } catch (Exception ex) {
            view.apresentaErro("Erro ao atualizar sabor.");
        }
    }

    public void excluirSabor() {
        try {
            List<Sabor> listaParaExcluir = view.getSaboresParaExcluir();
            modelDao.excluirLista(listaParaExcluir);
            view.excluirSaboresView(listaParaExcluir);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao excluir sabores.");
        }
    }

    public void listarSabor() {
        try {
            List<Sabor> lista = this.modelDao.getLista();
            view.mostrarListaSabores(lista);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao listar sabores.");
        }
    }

    public void filtrarSabores() {
        try {

            String query = view.getQueryParaFiltrar();
            List<Sabor> lista = this.modelDao.getListaFiltrada(query);

            view.mostrarListaSabores(lista);

            view.cleanFilterQuery();
        } catch (Exception ex) {
//
            view.apresentaErro("Erro ao filtrar sabores.");
        }
    }

}
