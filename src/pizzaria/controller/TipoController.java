package pizzaria.controller;

import java.util.List;
import pizzaria.model.Tipo;
import pizzaria.model.dao.TipoDao;
import pizzaria.view.TelaCliente;

public class TipoController {

    private TelaCliente view;
    private TipoDao modelDao;

    public TipoController(TelaCliente view, TipoDao modelDao) {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }

    private void initController() {
        this.view.setTipoController(this);
        this.listarTipo();
    }

    public void atualizarTipo(Integer type) {
        try {
            Double preco = view.getTipoParaAtualizar(type);
            modelDao.atualizar(type, preco);
            this.listarTipo();
        } catch (Exception ex) {
            view.apresentaErro(ex.getMessage());
        }
    }

    public void listarTipo() {
        try {
            List<Tipo> lista = this.modelDao.getLista();
            view.mostrarListaTipo(lista);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao listar tipos.");
        }
    }

}
