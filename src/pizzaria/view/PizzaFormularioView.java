package pizzaria.view;

import java.sql.SQLException;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import pizzaria.controller.PizzaController;
import pizzaria.model.Pizza;
import pizzaria.model.Sabor;
import pizzaria.model.dao.ConnectionFactory;
import pizzaria.model.dao.SaborDao;

public class PizzaFormularioView extends javax.swing.JPanel {

    private SaborDao modelDao;
    private List<Sabor> listaSabores;

    public PizzaFormularioView() throws SQLException {
        initComponents();
        modelDao = new SaborDao(new ConnectionFactory());
        listaSabores = modelDao.getLista();
        setListaSabores();
    }

    private Pizza pizzaSelecionadoParaAtualizacao;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        c_tamanho = new javax.swing.JTextField();
        r_pizza_cm = new javax.swing.JRadioButton();
        btn_excluir = new javax.swing.JButton();
        cbx_forma = new javax.swing.JComboBox<>();
        btn_atualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        text_valor_real = new javax.swing.JLabel();
        cbx_sabor1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbx_sabor2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btn_criarnovo = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        r_pedido_cm_quadrados = new javax.swing.JRadioButton();

        c_tamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_tamanhoActionPerformed(evt);
            }
        });

        r_pizza_cm.setText("Lado ou raio em cm");
        r_pizza_cm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_pizza_cmActionPerformed(evt);
            }
        });

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        cbx_forma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Círculo", "Quadrado", "Triângulo" }));
        cbx_forma.setToolTipText("");
        cbx_forma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_formaActionPerformed(evt);
            }
        });

        btn_atualizar.setText("Atualizar");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });

        jLabel4.setText("Preço Total do Pedido:");

        text_valor_real.setText("R$");

        cbx_sabor1.setToolTipText("");

        jLabel6.setText("Escolha o primeiro sabor:");

        cbx_sabor2.setToolTipText("");

        jLabel7.setText("Escolha o segundo sabor:");

        btn_criarnovo.setText("Criar Novo");
        btn_criarnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_criarnovoActionPerformed(evt);
            }
        });

        jLabel14.setText("Forma:");

        jLabel1.setText("Tamanho:");

        r_pedido_cm_quadrados.setText("Área em cm²");
        r_pedido_cm_quadrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_pedido_cm_quadradosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel6))
                                    .addComponent(cbx_sabor1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbx_forma, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbx_sabor2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(c_tamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(271, 271, 271)
                                        .addComponent(r_pizza_cm))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(302, 302, 302)
                                        .addComponent(btn_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_criarnovo)
                                    .addComponent(r_pedido_cm_quadrados))))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_valor_real)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_excluir)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(text_valor_real)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cbx_forma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(c_tamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r_pizza_cm)
                    .addComponent(r_pedido_cm_quadrados))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_atualizar)
                    .addComponent(btn_criarnovo))
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void r_pizza_cmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_pizza_cmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_pizza_cmActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_atualizarActionPerformed

    private void btn_criarnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_criarnovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_criarnovoActionPerformed

    private void r_pedido_cm_quadradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_pedido_cm_quadradosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_pedido_cm_quadradosActionPerformed

    private void c_tamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_tamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_tamanhoActionPerformed

    private void cbx_formaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_formaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_formaActionPerformed

    public JTextField getCampoTamanho() {
        return c_tamanho;
    }

    public JComboBox getCampoForma() {
        return cbx_forma;
    }

    public Sabor getCampoSabor1() {
        return (Sabor) cbx_sabor1.getSelectedItem();
    }

    public Sabor getCampoSabor2() {
        return (Sabor) cbx_sabor2.getSelectedItem();
    }

    public JRadioButton getPizzaCm() {
        return r_pizza_cm;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_criarnovo;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JTextField c_tamanho;
    private javax.swing.JComboBox<String> cbx_forma;
    private javax.swing.JComboBox<Sabor> cbx_sabor1;
    private javax.swing.JComboBox<Sabor> cbx_sabor2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton r_pedido_cm_quadrados;
    private javax.swing.JRadioButton r_pizza_cm;
    private javax.swing.JLabel text_valor_real;
    // End of variables declaration//GEN-END:variables

    public void setPizza(Pizza order) throws SQLException {
        this.pizzaSelecionadoParaAtualizacao = order;
        text_valor_real.setText("R$" + modelDao.getPrecoTotal(order.getPedido()));
        cbx_forma.setSelectedIndex(order.getNumberForma());
        cbx_sabor1.setSelectedItem(order.getSabor1());
        cbx_sabor2.setSelectedItem(order.getSabor2());
        r_pedido_cm_quadrados.setSelected(!order.isIsMetricaCmQuadrado());
        r_pizza_cm.setSelected(order.isIsMetricaCmQuadrado());
        c_tamanho.setText(Double.toString(order.getLadoOuRaio()));
    }

    public Pizza getPizzaParaAtualizar() {
        if (pizzaSelecionadoParaAtualizacao == null) {
            return null;
        }
        pizzaSelecionadoParaAtualizacao.setFormaFromNumber(cbx_forma.getSelectedIndex());
        pizzaSelecionadoParaAtualizacao.setSabor1(((Sabor) cbx_sabor1.getSelectedItem()).getId());
        pizzaSelecionadoParaAtualizacao.setSabor2(((Sabor) cbx_sabor2.getSelectedItem()).getId());
        pizzaSelecionadoParaAtualizacao.setLadoOuRaio(Double.parseDouble(c_tamanho.getText()));
        pizzaSelecionadoParaAtualizacao.setIsMetricaCmQuadrado(r_pizza_cm.isSelected());
        return pizzaSelecionadoParaAtualizacao;
    }

    public void setListaSabores() {
        for (Sabor p : listaSabores) {
            cbx_sabor1.addItem(p);
            cbx_sabor2.addItem(p);
        }
    }

    public void setController(PizzaController controller) {
        this.btn_criarnovo.addActionListener(e -> controller.criarPizza());
        this.btn_atualizar.addActionListener(e -> controller.atualizarPizza());
        this.btn_excluir.addActionListener(e -> controller.excluirPizza());
    }

}
