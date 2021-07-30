package pizzaria.view;

import javax.swing.JTextField;
import pizzaria.model.Pizza;

public class NovoPedidoFormularioView extends javax.swing.JFrame {

    public NovoPedidoFormularioView() {
        initComponents();
    }
    private Pizza pizzaSelecionadoParaAtualizacao;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        novoPedidoTableModel1 = new pizzaria.view.ClienteTableModel();
        novoPedidoTableModel2 = new pizzaria.view.ClienteTableModel();
        novoPedidoTableModel3 = new pizzaria.view.ClienteTableModel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        btn_criarnovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        c_cliente_nome = new javax.swing.JTextField();
        btn_excluir = new javax.swing.JButton();
        btn_atualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbx_sabor1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbx_sabor2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        r_pedido_circulo = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        r_pedido_quadrado = new javax.swing.JRadioButton();
        r_pedido_triangulo = new javax.swing.JRadioButton();
        r_pedido_cm_quadrados = new javax.swing.JRadioButton();
        r_pedido_cm = new javax.swing.JRadioButton();
        btn_tela_anterior = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_criarnovo.setText("Criar Novo");
        btn_criarnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_criarnovoActionPerformed(evt);
            }
        });

        jLabel1.setText("Tamanho:");

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        btn_atualizar.setText("Atualizar");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });

        jLabel4.setText("Preço:");

        jLabel5.setText("R$");

        cbx_sabor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simples", "Especial", "Premium" }));
        cbx_sabor1.setToolTipText("");

        jLabel6.setText("Escolha o primeiro sabor:");

        cbx_sabor2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simples", "Especial", "Premium" }));
        cbx_sabor2.setToolTipText("");

        jLabel7.setText("Escolha o segundo sabor:");

        r_pedido_circulo.setText("Círculo");
        r_pedido_circulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_pedido_circuloActionPerformed(evt);
            }
        });

        jLabel14.setText("Forma:");

        r_pedido_quadrado.setText("Quadrado");
        r_pedido_quadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_pedido_quadradoActionPerformed(evt);
            }
        });

        r_pedido_triangulo.setText("Triângulo");
        r_pedido_triangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_pedido_trianguloActionPerformed(evt);
            }
        });

        r_pedido_cm_quadrados.setText("Área em cm²");
        r_pedido_cm_quadrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_pedido_cm_quadradosActionPerformed(evt);
            }
        });

        r_pedido_cm.setText("Lado ou raio em cm");
        r_pedido_cm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_pedido_cmActionPerformed(evt);
            }
        });

        btn_tela_anterior.setText("Voltar a tela anterior");
        btn_tela_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tela_anteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_excluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel6))
                            .addComponent(cbx_sabor1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r_pedido_quadrado)
                                    .addComponent(r_pedido_circulo)
                                    .addComponent(r_pedido_triangulo)))
                            .addComponent(btn_tela_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbx_sabor2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(c_cliente_nome)))
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(r_pedido_cm))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r_pedido_cm_quadrados)
                                    .addComponent(btn_criarnovo))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(btn_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_sabor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_sabor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(r_pedido_quadrado)
                    .addComponent(jLabel1)
                    .addComponent(c_cliente_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_pedido_triangulo)
                    .addComponent(r_pedido_cm)
                    .addComponent(r_pedido_cm_quadrados))
                .addGap(18, 18, 18)
                .addComponent(r_pedido_circulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tela_anterior)
                    .addComponent(btn_atualizar)
                    .addComponent(btn_criarnovo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_criarnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_criarnovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_criarnovoActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_atualizarActionPerformed

    private void r_pedido_quadradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_pedido_quadradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_pedido_quadradoActionPerformed

    private void r_pedido_trianguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_pedido_trianguloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_pedido_trianguloActionPerformed

    private void r_pedido_cm_quadradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_pedido_cm_quadradosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_pedido_cm_quadradosActionPerformed

    private void r_pedido_cmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_pedido_cmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_pedido_cmActionPerformed

    private void r_pedido_circuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_pedido_circuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_pedido_circuloActionPerformed

    private void btn_tela_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tela_anteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tela_anteriorActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(NovoPedidoFormularioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoPedidoFormularioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoPedidoFormularioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoPedidoFormularioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoPedidoFormularioView().setVisible(true);
            }
        });
    }

    public JTextField getCampoNome() {
        return c_cliente_nome;
    }

//    public JTextField getCampoSobrenome() {
//        return c_cliente_sobrenome;
//    }
//
//    public JTextField getCampoTelefone() {
//        return c_cliente_telefone;
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_criarnovo;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_tela_anterior;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField c_cliente_nome;
    private javax.swing.JComboBox<String> cbx_sabor1;
    private javax.swing.JComboBox<String> cbx_sabor2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private pizzaria.view.ClienteTableModel novoPedidoTableModel1;
    private pizzaria.view.ClienteTableModel novoPedidoTableModel2;
    private pizzaria.view.ClienteTableModel novoPedidoTableModel3;
    private javax.swing.JRadioButton r_pedido_circulo;
    private javax.swing.JRadioButton r_pedido_cm;
    private javax.swing.JRadioButton r_pedido_cm_quadrados;
    private javax.swing.JRadioButton r_pedido_quadrado;
    private javax.swing.JRadioButton r_pedido_triangulo;
    // End of variables declaration//GEN-END:variables

    public void setPizza(Pizza order) {
        this.pizzaSelecionadoParaAtualizacao = order;

        String[] array = new String[arrayList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
        }

        cbx_sabor1.setSelectedIndex(order.getTipo());
        cbx_sabor1.setSelectedIndex(order.getTipo());

        c_pizza_nome.setText(order.getNome());

    }

    public Pizza getPizzaParaAtualizar() {
        if (pizzaSelecionadoParaAtualizacao == null) {
            return null;
        }
        pizzaSelecionadoParaAtualizacao.setTipo(cbx_tipo_pizza.getSelectedIndex());
        pizzaSelecionadoParaAtualizacao.setNome(c_pizza_nome.getText());
        return pizzaSelecionadoParaAtualizacao;
    }

    public void setController(PizzaController controller) {

        this.btn_novo.addActionListener(e -> controller.criarPizza());
        this.btn_atualizar.addActionListener(e -> controller.atualizarPizza());
        this.btn_excluir.addActionListener(e -> controller.excluirPizza());
//        this.btn_listar.addActionListener(e -> controller.listarCliente());
    }
}
