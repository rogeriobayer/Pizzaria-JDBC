/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.controller;

import java.util.List;
import pizzaria.model.Cliente;
import pizzaria.model.dao.ClienteDao;
import pizzaria.view.TelaCliente;

public class ClienteController {

    private TelaCliente view;
    private ClienteDao modelDao;

    public ClienteController(TelaCliente view, ClienteDao modelDao) {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }

    private void initController() {
        this.view.setController(this);
        this.view.initView();
    }

    public void criarCliente() {
        try {
            Cliente cliente = view.getClienteFormulario();
            modelDao.inserir(cliente);
            view.inserirClienteView(cliente);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao criar cliente.");
        }
    }

    public void atualizarCliente() {
        try {

            Cliente cliente = view.getClienteParaAtualizar();
            if (cliente == null) {
                view.apresentaInfo("Selecione um cliente na tabela para atualizar.");
                return;
            }
            modelDao.atualizar(cliente);
            view.atualizarCliente(cliente);

        } catch (Exception ex) {
            view.apresentaErro(ex.getMessage());

//            view.apresentaErro("Erro ao atualizar cliente.");
        }
    }

    public void excluirCliente() {
        try {
            List<Cliente> listaParaExcluir = view.getClientesParaExcluir();
            modelDao.excluirLista(listaParaExcluir);
            view.excluirClientesView(listaParaExcluir);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao excluir clientes.");
        }
    }

    public void listarCliente() {
        try {
            List<Cliente> lista = this.modelDao.getLista();
            view.mostrarListaClientes(lista);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao listar clientes.");
        }
    }

    public void filtrarClientes() {
        try {

            String query = view.getQueryParaFiltrar();
            List<Cliente> lista = this.modelDao.getListaFiltrada(query);

            view.mostrarListaClientes(lista);

            view.cleanFilterQuery();
        } catch (Exception ex) {
//
            view.apresentaErro("Erro ao filtrar clientes.");
        }
    }

}
