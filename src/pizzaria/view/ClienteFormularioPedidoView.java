package pizzaria.view;

import pizzaria.controller.PedidoController;

public class ClienteFormularioPedidoView extends javax.swing.JPanel {

    public ClienteFormularioPedidoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_novopedido = new javax.swing.JButton();

        btn_novopedido.setText("Ver/Criar Pedidos");
        btn_novopedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novopedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btn_novopedido, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_novopedido)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_novopedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novopedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_novopedidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_novopedido;
    // End of variables declaration//GEN-END:variables

    public void setController(PedidoController controller) {
        this.btn_novopedido.addActionListener(e -> controller.abrirNovoPedido());

    }

}
