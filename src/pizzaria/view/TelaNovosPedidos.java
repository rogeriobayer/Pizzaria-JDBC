package pizzaria.view;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import pizzaria.controller.PedidoController;
import pizzaria.controller.PizzaController;
import pizzaria.model.Cliente;
import pizzaria.model.Pedido;

public class TelaNovosPedidos extends javax.swing.JFrame {

    private Cliente clienteSelecionado;
    private Pedido pedidoSelecionado;

    public TelaNovosPedidos(Cliente clienteSelecionadoParaAtualizacao) {
        initComponents();
        clienteSelecionado = clienteSelecionadoParaAtualizacao;

    }

    public TelaNovosPedidos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pedidoTabelaView = new pizzaria.view.PedidoTabelaView();
        novoPedidoFormularioView = new pizzaria.view.NovoPedidoFormularioView();
        btn_voltarprincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_voltarprincipal.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(novoPedidoFormularioView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pedidoTabelaView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_voltarprincipal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(pedidoTabelaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(novoPedidoFormularioView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_voltarprincipal)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TelaNovosPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovosPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovosPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovosPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNovosPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_voltarprincipal;
    private pizzaria.view.NovoPedidoFormularioView novoPedidoFormularioView;
    private pizzaria.view.PedidoTabelaView pedidoTabelaView;
    // End of variables declaration//GEN-END:variables
    private int pedidoClicadoParaAtualizacao = -1;
    private PedidoTableModel pedidoTableModel = new PedidoTableModel();

    public void initPedidosView() {
        pedidoTabelaView.getTabelaPedido().setModel(pedidoTableModel);
        pedidoTabelaView.getTabelaPedido().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pedidoClicadoParaAtualizacao = pedidoTabelaView.getTabelaPedido().rowAtPoint(evt.getPoint());
                pedidoSelecionado = pedidoTableModel.getPedido(pedidoClicadoParaAtualizacao);
            }
        });
        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }

    public void setPedidoController(PedidoController pedidoController) {
        pedidoTabelaView.setControllerNovoPedido(pedidoController);
        novoPedidoFormularioView.setPedidoController(pedidoController);
        this.btn_voltarprincipal.addActionListener(e -> pedidoController.fecharNovoPedido());
    }

    public void setPizzaController(PizzaController controller) {
        novoPedidoFormularioView.setPizzaController(controller);
    }

    public void inserirPedidoView(Pedido pedido) {
        pedidoTableModel.adicionaPedido(pedido);
    }

    public void mostrarListaPedidos(List<Pedido> lista) {
        pedidoTableModel.setListaPedidos(lista);
    }

    public void excluirPedidosView(List<Pedido> listaParaExcluir) {
        pedidoTableModel.removePedidos(listaParaExcluir);
    }

    public List<Pedido> getPedidosParaExcluir() {
        int[] linhasSelecionadas = this.pedidoTabelaView.getTabelaPedido().getSelectedRows();
        List<Pedido> listaExcluir = new ArrayList();
        for (int i = 0; i < linhasSelecionadas.length; i++) {
            Pedido pedido = pedidoTableModel.getPedido(linhasSelecionadas[i]);
            listaExcluir.add(pedido);
        }
        return listaExcluir;
    }

    public Pedido getPedidoSelecionado() {

        return pedidoSelecionado;
    }

    public String getClienteSelecionado() {
        return clienteSelecionado.getId();
    }

    public void atualizarPedido(Pedido pedido) {
        pedidoTableModel.fireTableRowsUpdated(pedidoClicadoParaAtualizacao, pedidoClicadoParaAtualizacao);
    }

    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null, info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null, erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
