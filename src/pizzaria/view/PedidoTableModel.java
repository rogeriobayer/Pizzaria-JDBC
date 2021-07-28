package pizzaria.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pizzaria.model.Pedido;

public class PedidoTableModel extends AbstractTableModel {

    private String[] colunas = new String[]{"id", "Telefone", "Preco", "Estado"};

    private List<Pedido> lista = new ArrayList();

    public PedidoTableModel(List<Pedido> lista) {
        this.lista = lista;
    }

    public PedidoTableModel() {
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
        //if(column==0)
        //    return false;
        //return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido order = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return order.getId();//if column 0 (code)
            case 1: {
                try {
                    return order.getTelefone();//if column 1 (name)
                } catch (SQLException ex) {
                    System.out.print(ex);
                }
            }
            case 2:
                return order.getPreco();//if column 2 (preco)
            case 3:
                return order.getEstadoString();

            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Pedido order = lista.get(row);
        switch (col) {
            case 0:
                order.setId((String) value); //if column 0 (code)
                break;
            case 1:
//                order.setTelefone((String) value);
                break;
            case 2:
                order.setPreco((Double) value);
                break;
            case 3:
                order.setEstado((Integer) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }

    public boolean removePedido(Pedido order) {
        int linha = this.lista.indexOf(order);
        boolean result = this.lista.remove(order);
        this.fireTableRowsDeleted(linha, linha);//update JTable
        return result;
    }

    public void adicionaPedido(Pedido order) {
        this.lista.add(order);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);//update JTable
    }

    public void setListaPedidos(List<Pedido> order) {
        this.lista = order;
        this.fireTableDataChanged();
        //this.fireTableRowsInserted(0,contatos.size()-1);//update JTable
    }

    public void limpaTabela() {
        int indice = lista.size() - 1;
        if (indice < 0) {
            indice = 0;
        }
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0, indice);//update JTable
    }

    public Pedido getPedido(int linha) {
        return lista.get(linha);
    }

    void removePedidos(List<Pedido> listaParaExcluir) {
        listaParaExcluir.forEach((order) -> {
            removePedido(order);
        });
    }
}
