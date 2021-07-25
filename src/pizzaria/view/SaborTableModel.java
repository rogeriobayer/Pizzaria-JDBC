/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pizzaria.model.Sabor;

public class SaborTableModel extends AbstractTableModel {

    private String[] colunas = new String[]{"Id", "Nome", "Tipo"};
    private List<Sabor> lista = new ArrayList();

    public SaborTableModel(List<Sabor> lista) {
        this.lista = lista;
    }

    public SaborTableModel() {
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
        Sabor sabor = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sabor.getId();//if column 0 (
            case 1:
                return sabor.getNome();//if column 1
            case 2:
                return sabor.getTipoString();//if column 2
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Sabor sabor = lista.get(row);
        switch (col) {
            case 0:
                sabor.setId((String) value); //if column 0 (code)
                break;
            case 1:
                sabor.setNome((String) value);
                break;
            case 2:
                sabor.setTipo((Integer) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }

    public boolean removeSabor(Sabor sabor) {
        int linha = this.lista.indexOf(sabor);
        boolean result = this.lista.remove(sabor);
        this.fireTableRowsDeleted(linha, linha);//update JTable
        return result;
    }

    public void adicionaSabor(Sabor sabor) {
        this.lista.add(sabor);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);//update JTable
    }

    public void setListaSabores(List<Sabor> sabor) {
        this.lista = sabor;
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

    public Sabor getSabor(int linha) {
        return lista.get(linha);
    }

    void removeSabores(List<Sabor> listaParaExcluir) {
        listaParaExcluir.forEach((sabor) -> {
            removeSabor(sabor);
        });
    }
}
