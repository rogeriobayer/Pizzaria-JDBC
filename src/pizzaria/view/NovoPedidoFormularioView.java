package pizzaria.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextField;
import pizzaria.controller.ClienteController;
import pizzaria.controller.PedidoController;
import pizzaria.controller.PizzaController;
import pizzaria.model.Cliente;

public class NovoPedidoFormularioView extends javax.swing.JPanel {

    private Cliente clienteSelecionadoParaAtualizacao;

    public NovoPedidoFormularioView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btn_pedido_excluir = new javax.swing.JButton();
        btn_pedido_novo = new javax.swing.JButton();
        btn_pedido_atualizar = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Pedidos"));

        btn_pedido_excluir.setText("Excluir");
        btn_pedido_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedido_excluirActionPerformed(evt);
            }
        });

        btn_pedido_novo.setText("Criar Novo Pedido");
        btn_pedido_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedido_novoActionPerformed(evt);
            }
        });

        btn_pedido_atualizar.setText("Atualizar");
        btn_pedido_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedido_atualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btn_pedido_excluir)
                .addGap(28, 28, 28)
                .addComponent(btn_pedido_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_pedido_novo)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pedido_excluir)
                    .addComponent(btn_pedido_atualizar)
                    .addComponent(btn_pedido_novo))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pedido_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedido_excluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pedido_excluirActionPerformed

    private void btn_pedido_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedido_novoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pedido_novoActionPerformed

    private void btn_pedido_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedido_atualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pedido_atualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pedido_atualizar;
    private javax.swing.JButton btn_pedido_excluir;
    private javax.swing.JButton btn_pedido_novo;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void setPizzaController(PizzaController controller) {
        this.btn_pedido_novo.addActionListener(e -> controller.abrirNovoPizza());
        this.btn_pedido_atualizar.addActionListener(e -> controller.atualizarNovoPizza());
    }

    public void setPedidoController(PedidoController controller) {
        this.btn_pedido_excluir.addActionListener(e -> controller.excluirPedido());
    }

}
