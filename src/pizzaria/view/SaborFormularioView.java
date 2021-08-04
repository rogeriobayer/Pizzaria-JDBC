package pizzaria.view;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import pizzaria.controller.SaborController;
import pizzaria.model.Sabor;

public class SaborFormularioView extends javax.swing.JPanel {

    private Sabor saborSelecionadoParaAtualizacao;

    public SaborFormularioView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        c_sabor_nome = new javax.swing.JTextField();
        btn_sabor_excluir = new javax.swing.JButton();
        btn_sabor_atualizar = new javax.swing.JButton();
        btn_sabor_novo = new javax.swing.JButton();
        cbx_tipo_sabor = new javax.swing.JComboBox<>();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Sabor"));

        jLabel1.setText("Nome:");

        jLabel2.setText("Tipo:");

        btn_sabor_excluir.setText("Excluir");

        btn_sabor_atualizar.setText("Atualizar");

        btn_sabor_novo.setText("Criar Novo");

        cbx_tipo_sabor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simples", "Especial", "Premium" }));
        cbx_tipo_sabor.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbx_tipo_sabor, 0, 253, Short.MAX_VALUE)
                    .addComponent(c_sabor_nome))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 65, Short.MAX_VALUE)
                .addComponent(btn_sabor_excluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_sabor_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_sabor_novo)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_sabor_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbx_tipo_sabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sabor_excluir)
                    .addComponent(btn_sabor_atualizar)
                    .addComponent(btn_sabor_novo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JTextField getCampoNome() {
        return c_sabor_nome;
    }

    public JComboBox<String> getCampoTipo() {
        return cbx_tipo_sabor;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sabor_atualizar;
    private javax.swing.JButton btn_sabor_excluir;
    private javax.swing.JButton btn_sabor_novo;
    private javax.swing.JTextField c_sabor_nome;
    private javax.swing.JComboBox<String> cbx_tipo_sabor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void setSabor(Sabor cliente) {
        this.saborSelecionadoParaAtualizacao = cliente;
        cbx_tipo_sabor.setSelectedIndex(cliente.getTipo());
        c_sabor_nome.setText(cliente.getNome());
    }

    public Sabor getSaborParaAtualizar() {
        if (saborSelecionadoParaAtualizacao == null) {
            return null;
        }
        saborSelecionadoParaAtualizacao.setTipo(cbx_tipo_sabor.getSelectedIndex());
        saborSelecionadoParaAtualizacao.setNome(c_sabor_nome.getText());
        return saborSelecionadoParaAtualizacao;
    }

    public void cleanFields() {
        c_sabor_nome.setText(null);
        cbx_tipo_sabor.setSelectedIndex(0);
    }

    public void setController(SaborController controller) {

        this.btn_sabor_novo.addActionListener(e -> controller.criarSabor());
        this.btn_sabor_atualizar.addActionListener(e -> controller.atualizarSabor());
        this.btn_sabor_excluir.addActionListener(e -> controller.excluirSabor());
    }

}
