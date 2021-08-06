package pizzaria.controller;

import java.util.List;
import pizzaria.model.Sabor;
import pizzaria.model.dao.SaborDao;
import pizzaria.view.TelaPrincipal;

public class SaborController {

    private TelaPrincipal view;
    private SaborDao modelDao;

    public SaborController(TelaPrincipal view, SaborDao modelDao) {
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
            view.cleanFlavorsFields();
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
            view.cleanFlavorsFields();
        } catch (Exception ex) {
            view.apresentaErro(ex.toString());

            view.apresentaErro("Erro ao atualizar sabor.");
        }
    }

    public void excluirSabor() {
        try {
            List<Sabor> listaParaExcluir = view.getSaboresParaExcluir();
            if (listaParaExcluir == null || listaParaExcluir.isEmpty()) {
                view.apresentaInfo("Selecione um sabor na tabela para excluir.");
                return;
            }
            modelDao.excluirLista(listaParaExcluir);
            view.excluirSaboresView(listaParaExcluir);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao excluir sabor. O sabor é utilizado por um ou mais pedidos no sistema.");
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
}
