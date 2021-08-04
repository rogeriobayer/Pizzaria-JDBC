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

    private boolean validaTelefone(String telefone) {
        if (telefone.matches("[0-9]+") && telefone.length() > 9 && telefone.length() < 12) {
            return true;
        } else {
            view.apresentaInfo("Telefone inválido. Digite seu telefone com DDD.");
            return false;
        }
    }

    public void criarCliente() {
        try {
            Cliente cliente = view.getClienteFormulario();
            if (cliente.getTelefone().isEmpty() || cliente.getNome().isEmpty() || cliente.getSobrenome().isEmpty()) {
                view.apresentaInfo("Preecha todos os campos corretamente para adicionar novo cliente.");
                return;
            } else if (!validaTelefone(cliente.getTelefone())) {
                return;
            }
            modelDao.inserir(cliente);
            view.inserirClienteView(cliente);
            view.cleanFields();

        } catch (Exception ex) {
            view.apresentaErro("Erro ao criar cliente. Verifique se o telefone já foi utilizado.");
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
            view.cleanFields();
        } catch (Exception ex) {
            view.apresentaErro("Erro ao atualizar cliente.");
        }
    }

    public void excluirCliente() {
        try {
            List<Cliente> listaParaExcluir = view.getClientesParaExcluir();
            System.out.print(listaParaExcluir);
            if (listaParaExcluir == null || listaParaExcluir.equals("null") || listaParaExcluir.isEmpty()) {
                view.apresentaInfo("Selecione um cliente na tabela para excluir.");
                return;
            }
            modelDao.excluirLista(listaParaExcluir);
            view.excluirClientesView(listaParaExcluir);
            view.cleanFields();
        } catch (Exception ex) {
            view.apresentaErro(ex.toString());

            view.apresentaErro("Erro ao excluir clientes. O cliente possui pedidos no sistema.");
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
            view.apresentaErro("Erro ao filtrar clientes.");
        }
    }

}
