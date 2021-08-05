package pizzaria.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pizzaria.model.Cliente;

public class ClienteTableModel extends AbstractTableModel {

    private String[] colunas = new String[]{"id", "Nome", "Sobrenome", "Telefone"};

    private List<Cliente> lista = new ArrayList();

    public ClienteTableModel(List<Cliente> lista) {
        this.lista = lista;
    }

    public ClienteTableModel() {
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente customer = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return customer.getId();
            case 1:
                return customer.getNome();
            case 2:
                return customer.getSobrenome();
            case 3:
                return customer.getTelefone();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Cliente customer = lista.get(row);
        switch (col) {
            case 0:
                customer.setId((String) value);
                break;
            case 1:
                customer.setNome((String) value);
                break;
            case 2:
                customer.setSobrenome((String) value);
                break;
            case 3:
                customer.setTelefone((String) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }

    public boolean removeCliente(Cliente customer) {
        int linha = this.lista.indexOf(customer);
        boolean result = this.lista.remove(customer);
        this.fireTableRowsDeleted(linha, linha);
        return result;
    }

    public void adicionaCliente(Cliente customer) {
        this.lista.add(customer);
        this.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public void setListaClientes(List<Cliente> customer) {
        this.lista = customer;
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int indice = lista.size() - 1;
        if (indice < 0) {
            indice = 0;
        }
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0, indice);
    }

    public Cliente getCliente(int linha) {
        return lista.get(linha);
    }

    void removeClientes(List<Cliente> listaParaExcluir) {
        listaParaExcluir.forEach((cliente) -> {
            removeCliente(cliente);
        });
    }
}
