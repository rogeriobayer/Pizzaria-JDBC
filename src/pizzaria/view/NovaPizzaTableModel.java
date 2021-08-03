package pizzaria.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import pizzaria.model.Pizza;
import pizzaria.model.Sabor;
import pizzaria.model.dao.ConnectionFactory;
import pizzaria.model.dao.SaborDao;

public class NovaPizzaTableModel extends AbstractTableModel {

    private String[] colunas = new String[]{"Sabor 1", "Sabor 2", "Forma", "Área", "Lado ou Raio", "Preço"};
    private SaborDao modelDao = new SaborDao(new ConnectionFactory());

    private List<Sabor> saboresList;

    private List<Pizza> lista = new ArrayList();

    public NovaPizzaTableModel(List<Pizza> lista) throws SQLException {
        this.saboresList = modelDao.getLista();
        this.lista = lista;
    }

    public NovaPizzaTableModel() throws SQLException {
        this.saboresList = modelDao.getLista();
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

    private String getSaborStringById(String id) throws SQLException {
        for (Sabor s : this.saboresList) {
            if (s.getId().equals(id)) {
                return s.getNome();
            }
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pizza pizza = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: {
                try {
                    return this.getSaborStringById(pizza.getSabor1());//if column 0 (code)
                } catch (SQLException ex) {
                    Logger.getLogger(NovaPizzaTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 1: {
                try {
                    return this.getSaborStringById(pizza.getSabor2());//if column 1 (name)
                } catch (SQLException ex) {
                    Logger.getLogger(NovaPizzaTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 2:
                return pizza.getFormaString();
            case 3:
                return pizza.getArea();
            case 4:
                return pizza.getLadoOuRaio();
            case 5:
                return "R$ " + pizza.getPrecoTotal();
            default:
                return null;
        }
    }

//    @Override
//    public void setValueAt(Object value, int row, int col) {
//        Pizza pizza = lista.get(row);
//        switch (col) {
//            case 0:
//                pizza.setId((String) value); //if column 0 (code)
//                break;
//            case 1:
//                pizza.setNome((String) value);
//                break;
//            case 2:
//                pizza.setSobrenome((String) value);
//                break;
//            case 3:
//                pizza.setTelefone((String) value);
//                break;
////            case 4:
////                pizza.setEndereco((String) value);
////                break;
//            default:
//        }
//        this.fireTableCellUpdated(row, col);
//    }
    public boolean removePizza(Pizza pizza) {
        int linha = this.lista.indexOf(pizza);
        boolean result = this.lista.remove(pizza);
        this.fireTableRowsDeleted(linha, linha);//update JTable
        return result;
    }

    public void adicionaPizza(Pizza pizza) {
        this.lista.add(pizza);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);//update JTable
    }

    public void setListaPizzas(List<Pizza> pizza) {
        this.lista = pizza;
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

    public Pizza getPizza(int linha) {
        return lista.get(linha);
    }

    void removePizzas(List<Pizza> listaParaExcluir) {
        listaParaExcluir.forEach((cliente) -> {
            removePizza(cliente);
        });
    }
}
