package pizzaria.view;

import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pizzaria.controller.ClienteController;
import pizzaria.controller.PedidoController;
import pizzaria.controller.SaborController;
import pizzaria.controller.TipoController;
import pizzaria.model.Cliente;
import pizzaria.model.Pedido;
import pizzaria.model.Sabor;
import pizzaria.model.Tipo;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        clienteFormFilter = new pizzaria.view.ClienteFormFilter();
        tabelaClienteView = new pizzaria.view.ClienteTabelaView();
        formularioCliente = new pizzaria.view.ClienteFormularioView();
        clienteFormularioPedidoView = new pizzaria.view.ClienteFormularioPedidoView();
        jPanel2 = new javax.swing.JPanel();
        saborFormularioView = new pizzaria.view.SaborFormularioView();
        saborTabelaView = new pizzaria.view.SaborTabelaView();
        jPanel3 = new javax.swing.JPanel();
        tipoFormularioView = new pizzaria.view.TipoFormularioView();
        jPanel4 = new javax.swing.JPanel();
        pedidoTabelaView = new pizzaria.view.PedidoTabelaView();
        pedidoFormularioView = new pizzaria.view.PedidoFormularioView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clienteFormFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formularioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clienteFormularioPedidoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tabelaClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clienteFormFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelaClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clienteFormularioPedidoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formularioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Clientes", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saborTabelaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saborFormularioView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(saborTabelaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(saborFormularioView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sabores", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(tipoFormularioView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(tipoFormularioView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Preços", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pedidoFormularioView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pedidoTabelaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pedidoTabelaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(pedidoFormularioView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pedidos", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pizzaria.view.ClienteFormFilter clienteFormFilter;
    private pizzaria.view.ClienteFormularioPedidoView clienteFormularioPedidoView;
    private pizzaria.view.ClienteFormularioView formularioCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private pizzaria.view.PedidoFormularioView pedidoFormularioView;
    private pizzaria.view.PedidoTabelaView pedidoTabelaView;
    private pizzaria.view.SaborFormularioView saborFormularioView;
    private pizzaria.view.SaborTabelaView saborTabelaView;
    private pizzaria.view.ClienteTabelaView tabelaClienteView;
    private pizzaria.view.TipoFormularioView tipoFormularioView;
    // End of variables declaration//GEN-END:variables

    private ClienteTableModel clienteTableModel = new ClienteTableModel();

    private int linhaClicadaParaAtualizacao = -1;

    public void initView() {
        tabelaClienteView.getTabelaCliente().setModel(clienteTableModel);
        tabelaClienteView.getTabelaCliente().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linhaClicadaParaAtualizacao = tabelaClienteView.getTabelaCliente().rowAtPoint(evt.getPoint());
                Cliente cliente = clienteTableModel.getCliente(linhaClicadaParaAtualizacao);
                formularioCliente.setCliente(cliente);
            }
        });

        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }

    public Cliente getClienteFormulario() {
        String nome = formularioCliente.getCampoNome().getText();
        String sobrenome = formularioCliente.getCampoSobrenome().getText();
        String telefone = formularioCliente.getCampoTelefone().getText();
        return new Cliente(nome, sobrenome, telefone);
    }

    public void setController(ClienteController controller) {
        tabelaClienteView.setController(controller);
        formularioCliente.setController(controller);
        clienteFormFilter.setController(controller);
    }

    public void inserirClienteView(Cliente cliente) {
        clienteTableModel.adicionaCliente(cliente);
    }

    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null, erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarListaClientes(List<Cliente> lista) {
        clienteTableModel.setListaClientes(lista);
    }

    public List<Cliente> getClientesParaExcluir() {
        int[] linhasSelecionadas = this.tabelaClienteView.getTabelaCliente().getSelectedRows();
        List<Cliente> listaExcluir = new ArrayList();
        for (int i = 0; i < linhasSelecionadas.length; i++) {
            Cliente cliente = clienteTableModel.getCliente(linhasSelecionadas[i]);
            listaExcluir.add(cliente);
        }
        return listaExcluir;
    }

    public void excluirClientesView(List<Cliente> listaParaExcluir) {
        clienteTableModel.removeClientes(listaParaExcluir);
    }

    public Cliente getClienteParaAtualizar() {
        return formularioCliente.getClienteParaAtualizar();
    }

    public void atualizarCliente(Cliente cliente) {
        clienteTableModel.fireTableRowsUpdated(linhaClicadaParaAtualizacao, linhaClicadaParaAtualizacao);
    }

    //FILTRO
    public String getQueryParaFiltrar() {
        return clienteFormFilter.getQueryParaFiltrar();
    }

    public void cleanFilterQuery() {
        clienteFormFilter.cleanQuery();
    }

    public void cleanFields() {
        formularioCliente.cleanFields();
    }

    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null, info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    //SABORES
    private int saborClicadoParaAtualizacao = -1;
    private SaborTableModel saborTableModel = new SaborTableModel();

    public void initSaboresView() {
        saborTabelaView.getTabelaSabor().setModel(saborTableModel);
        saborTabelaView.getTabelaSabor().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saborClicadoParaAtualizacao = saborTabelaView.getTabelaSabor().rowAtPoint(evt.getPoint());
                Sabor sabor = saborTableModel.getSabor(saborClicadoParaAtualizacao);
                saborFormularioView.setSabor(sabor);
            }
        });

        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }

    public void setSaborController(SaborController controller) {
        saborTabelaView.setController(controller);
        saborFormularioView.setController(controller);
    }

    public void cleanFlavorsFields() {
        saborFormularioView.cleanFields();
    }

    public Sabor getSaborFormulario() {
        String nome = saborFormularioView.getCampoNome().getText();
        Integer tipo = saborFormularioView.getCampoTipo().getSelectedIndex();
        return new Sabor(nome, tipo);
    }

    public void inserirSaborView(Sabor sabor) {
        saborTableModel.adicionaSabor(sabor);
    }

    public void mostrarListaSabores(List<Sabor> lista) {
        saborTableModel.setListaSabores(lista);
    }

    public List<Sabor> getSaboresParaExcluir() {
        int[] linhasSelecionadas = this.saborTabelaView.getTabelaSabor().getSelectedRows();
        List<Sabor> listaExcluir = new ArrayList();
        for (int i = 0; i < linhasSelecionadas.length; i++) {
            Sabor sabor = saborTableModel.getSabor(linhasSelecionadas[i]);
            listaExcluir.add(sabor);
        }
        return listaExcluir;
    }

    public void excluirSaboresView(List<Sabor> listaParaExcluir) {
        saborTableModel.removeSabores(listaParaExcluir);
    }

    public Sabor getSaborParaAtualizar() {
        return saborFormularioView.getSaborParaAtualizar();
    }

    public void atualizarSabor(Sabor sabor) {
        saborTableModel.fireTableRowsUpdated(saborClicadoParaAtualizacao, saborClicadoParaAtualizacao);
    }

    //PREÇOS / TIPO
    public void setTipoController(TipoController controller) {
        tipoFormularioView.setController(controller);
    }

    public void mostrarListaTipo(List<Tipo> lista) {
        tipoFormularioView.setListaTipo(lista);
    }

    public Double getTipoParaAtualizar(Integer type) {
        return tipoFormularioView.getTipoParaAtualizar(type);
    }

    //Pedido
    private int pedidoClicadoParaAtualizacao = -1;
    private PedidoTableModel pedidoTableModel = new PedidoTableModel();

    public void initPedidosView() {
        pedidoTabelaView.getTabelaPedido().setModel(pedidoTableModel);
        pedidoTabelaView.getTabelaPedido().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pedidoClicadoParaAtualizacao = pedidoTabelaView.getTabelaPedido().rowAtPoint(evt.getPoint());
                Pedido pedido = pedidoTableModel.getPedido(pedidoClicadoParaAtualizacao);
                try {
                    pedidoFormularioView.setPedido(pedido);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }

    public void setPedidoController(PedidoController controller) {
        pedidoTabelaView.setController(controller);
        pedidoFormularioView.setController(controller);
        clienteFormularioPedidoView.setController(controller);
    }

    public void inserirPedidoView(Pedido pedido) {
        pedidoTableModel.adicionaPedido(pedido);
    }

    public void mostrarListaPedidos(List<Pedido> lista) {
        pedidoTableModel.setListaPedidos(lista);
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

    public Pedido getPedidoParaAtualizar() {
        return pedidoFormularioView.getPedidoParaAtualizar();
    }

    public void atualizarPedido(Pedido pedido) {
        pedidoTableModel.fireTableRowsUpdated(pedidoClicadoParaAtualizacao, pedidoClicadoParaAtualizacao);
    }

}
