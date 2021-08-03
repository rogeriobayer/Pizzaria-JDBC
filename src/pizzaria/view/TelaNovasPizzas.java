package pizzaria.view;

import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pizzaria.controller.PizzaController;
import pizzaria.model.Cliente;
import pizzaria.model.Pedido;
import pizzaria.model.Pizza;
import pizzaria.model.Sabor;
import pizzaria.model.dao.ConnectionFactory;
import pizzaria.model.dao.PedidoDao;

public class TelaNovasPizzas extends javax.swing.JFrame {

    private Pedido pedidoSelecionado;
    private String clienteSelecionado;
    private PedidoDao modelDao;

    public TelaNovasPizzas(Pedido pedidoSelecionadoParaAtualizacao, String cliente) throws SQLException {
        initComponents();
        this.pedidoSelecionado = pedidoSelecionadoParaAtualizacao;
        this.clienteSelecionado = cliente;
    }

    public TelaNovasPizzas(String cliente) throws SQLException {
        initComponents();
        this.clienteSelecionado = cliente;
    }

    public TelaNovasPizzas() throws SQLException {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws SQLException {

        novaPizzaTabelaView = new pizzaria.view.NovaPizzaTabelaView();
        btn_voltarpedidos = new javax.swing.JButton();
        pizzaFormularioView = new pizzaria.view.PizzaFormularioView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_voltarpedidos.setText("Voltar a Tela de Pedidos");
        btn_voltarpedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarpedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_voltarpedidos))
                    .addComponent(novaPizzaTabelaView, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pizzaFormularioView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(novaPizzaTabelaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pizzaFormularioView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_voltarpedidos)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarpedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarpedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_voltarpedidosActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaNovasPizzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovasPizzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovasPizzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovasPizzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaNovasPizzas().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaNovasPizzas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_voltarpedidos;
    private pizzaria.view.NovaPizzaTabelaView novaPizzaTabelaView;
    private pizzaria.view.PizzaFormularioView pizzaFormularioView;
    // End of variables declaration//GEN-END:variables
//Pizza
    private int pizzaClicadoParaAtualizacao = -1;
    private NovaPizzaTableModel pizzaTableModel;

    public void initPizzasView() throws SQLException {
        pizzaTableModel = new NovaPizzaTableModel();
        novaPizzaTabelaView.getTabelaPizza().setModel(pizzaTableModel);
        novaPizzaTabelaView.getTabelaPizza().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pizzaClicadoParaAtualizacao = novaPizzaTabelaView.getTabelaPizza().rowAtPoint(evt.getPoint());
                Pizza pizza = pizzaTableModel.getPizza(pizzaClicadoParaAtualizacao);
                try {
                    pizzaFormularioView.setPizza(pizza);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaNovasPizzas.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }

    public void setPizzaController(PizzaController pizzaController) {
        novaPizzaTabelaView.setControllerPizza(pizzaController);
        pizzaFormularioView.setController(pizzaController);
        this.btn_voltarpedidos.addActionListener(e -> pizzaController.fecharNovaPizza());

//        novoPizzaFormularioView.setController(controller);
//        clienteFormularioPizzaView.setController(controller);
    }

//    public void setPizzaController(PizzaController controller) {
////        pizzaTabelaView.setController(controller);
//        novoPizzaFormularioView.setController(controller);
////        clienteFormularioPizzaView.setController(controller);
//    }
    public void inserirPizzaView(Pizza pizza) {
        pizzaTableModel.adicionaPizza(pizza);
    }

    public void mostrarListaPizzas(List<Pizza> lista) {
        pizzaTableModel.setListaPizzas(lista);
    }

    public List<Pizza> getPizzasParaExcluir() {
        int[] linhasSelecionadas = this.novaPizzaTabelaView.getTabelaPizza().getSelectedRows();
        List<Pizza> listaExcluir = new ArrayList();
        for (int i = 0; i < linhasSelecionadas.length; i++) {
            Pizza pizza = pizzaTableModel.getPizza(linhasSelecionadas[i]);
            listaExcluir.add(pizza);
        }
        return listaExcluir;
    }

//    public Pizza getPizzaParaAtualizar() {
//        return novoPizzaFormularioView.getPizzaParaAtualizar();
//    }
    public String getPedidoSelecionado() {
        return this.pedidoSelecionado.getId();
    }

    public Pizza getPizzaParaAtualizar() {
        return pizzaFormularioView.getPizzaParaAtualizar();
    }

    public void excluirPizzasView(List<Pizza> listaParaExcluir) {
        pizzaTableModel.removePizzas(listaParaExcluir);
    }

    public void atualizarPizza(Pizza pizza) {
        pizzaTableModel.fireTableRowsUpdated(pizzaClicadoParaAtualizacao, pizzaClicadoParaAtualizacao);

    }

    public void atualizarTotal(Double valor) {
        pizzaFormularioView.setPrecoTotal(valor);
    }

    public Pizza getPizzaFormulario() {
        Double ladoOuRaio = Double.parseDouble(pizzaFormularioView.getCampoTamanho().getText());
        Integer forma = pizzaFormularioView.getCampoForma().getSelectedIndex();
        String sabor1 = pizzaFormularioView.getCampoSabor1().getId();
        String sabor2 = pizzaFormularioView.getCampoSabor2().getId();

        Boolean isMetricaCmQuadrado = pizzaFormularioView.getPizzaCm().isSelected();

        if (this.pedidoSelecionado == null) {
            this.pedidoSelecionado = new Pedido(this.clienteSelecionado, 0, 0);
            PedidoDao pedidoDao = new PedidoDao(new ConnectionFactory());
            pedidoDao.inserir(pedidoSelecionado);
        }
        return new Pizza(this.pedidoSelecionado.getId(), forma, isMetricaCmQuadrado, ladoOuRaio, sabor1, sabor2);
    }

    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null, info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null, erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }

}
