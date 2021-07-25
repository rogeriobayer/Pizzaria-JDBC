package pizzaria.view;

import java.awt.event.MouseAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pizzaria.controller.ClienteController;
import pizzaria.model.Cliente;
import pizzaria.model.Pedido;
import pizzaria.model.SaborPizza;
import pizzaria.utils.EstadosEnum;
import pizzaria.utils.TiposPizza;

public class TelaInicial extends javax.swing.JFrame {

    ArrayList<Cliente> listaClientes;
    ArrayList<SaborPizza> listaSabores;

    String modo;

    public TelaInicial() {
        initComponents();
        setLocationRelativeTo(null);
        listaClientes = new ArrayList();
        listaSabores = new ArrayList();

        modo = "Navegar";
        manipulaInterface();
        btn_sabor_excluir.setEnabled(false);

        tabs.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (tabs.getSelectedIndex() == 3) {
                    loadTablePedidos();
                }
            }
        });
    }

    public void loadTableClientes() {
        Object colunas[] = {"Nome", "Sobrenome", "Telefone"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (int i = 0; i < listaClientes.size(); i++) {
            Object dados[] = new Object[]{
                listaClientes.get(i).getNome(),
                listaClientes.get(i).getSobrenome(),
                listaClientes.get(i).getTelefone()
            };
            modelo.addRow(dados);
        }

        tb_clientes.setModel(modelo);
        tb_clientes.setDefaultEditor(Object.class, null);

        tb_clientes.getColumnModel().getColumn(0).setPreferredWidth(100);
        tb_clientes.getColumnModel().getColumn(1).setPreferredWidth(150);
        tb_clientes.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    public void loadTablePedidos() {
        Object colunas[] = {"Id", "Telefone", "Preco", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        btn_pedidos_salvar.setEnabled(false);

        for (int i = 0; i < listaClientes.size(); i++) {

            Pedido pedido = listaClientes.get(i).getPedido();
            if (pedido != null) {
                String estadoPedido;
                switch (pedido.getEstado()) {
                    case 0:
                        estadoPedido = "Aberto";
                        break;
                    case 1:
                        estadoPedido = "A caminho";
                        break;
                    case 2:
                        estadoPedido = "Entregue";
                        break;
                    default:
                        estadoPedido = "Aberto";
                }

                Object dados[] = new Object[]{
                    pedido.getId(),
                    pedido.getCliente().getTelefone(),
                    pedido.getPreco(),
                    estadoPedido,};

                modelo.addRow(dados);
            }
        }
        tb_pedidos.setModel(modelo);
        tb_pedidos.setDefaultEditor(Object.class, null);

        tb_pedidos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tb_pedidos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tb_pedidos.getColumnModel().getColumn(2).setPreferredWidth(50);
        tb_pedidos.getColumnModel().getColumn(3).setPreferredWidth(100);

        if (listaClientes.size() == 0) {
            c_pedidos_id.setText("");
            c_pedidos_telefone.setText("");
            c_pedidos_preco.setText("");
            cbx_pedidos_estado.getModel().setSelectedItem("Aberto");
        }
    }

    public void loadTableSabores() {
        Object colunas[] = {"Sabor", "Tipo", "ID"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (int i = 0; i < listaSabores.size(); i++) {
            Object dados[] = new Object[]{
                listaSabores.get(i).getNome(),
                listaSabores.get(i).getTipo().getNome(),
                listaSabores.get(i).getId(),};
            modelo.addRow(dados);
        }
        tb_sabores.setModel(modelo);
        tb_sabores.setDefaultEditor(Object.class, null);

        tb_sabores.getColumnModel().getColumn(0).setPreferredWidth(150);
        tb_sabores.getColumnModel().getColumn(1).setPreferredWidth(100);
        tb_sabores.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    public void manipulaInterface() {
        switch (modo) {
            case "Navegar":
                c_cliente_nome.setText("");
                c_cliente_sobrenome.setText("");
                c_cliente_telefone.setText("");
                btn_cliente_salvar.setEnabled(false);
                btn_cliente_cancelar.setEnabled(false);
                c_cliente_nome.setEnabled(false);
                c_cliente_sobrenome.setEnabled(false);
                c_cliente_telefone.setEnabled(false);
                btn_cliente_novo.setEnabled(true);
                btn_cliente_editar.setEnabled(false);
                btn_cliente_excluir.setEnabled(false);
                btn_cliente_pedido.setEnabled(false);
                break;

            case "Novo":
                c_cliente_nome.setText("");
                c_cliente_sobrenome.setText("");
                c_cliente_telefone.setText("");

                btn_cliente_salvar.setEnabled(true);
                btn_cliente_cancelar.setEnabled(true);
                c_cliente_nome.setEnabled(true);
                c_cliente_sobrenome.setEnabled(true);
                c_cliente_telefone.setEnabled(true);
                btn_cliente_novo.setEnabled(false);
                btn_cliente_editar.setEnabled(false);
                btn_cliente_excluir.setEnabled(false);
                btn_cliente_pedido.setEnabled(false);
                break;

            case "Editar":
                btn_cliente_salvar.setEnabled(true);
                btn_cliente_cancelar.setEnabled(true);
                c_cliente_nome.setEnabled(true);
                c_cliente_sobrenome.setEnabled(true);
                c_cliente_telefone.setEnabled(true);
                btn_cliente_novo.setEnabled(false);
                btn_cliente_editar.setEnabled(false);
                btn_cliente_excluir.setEnabled(false);
                btn_cliente_pedido.setEnabled(false);
                break;

            case "Selecao":
                btn_cliente_salvar.setEnabled(false);
                btn_cliente_cancelar.setEnabled(false);
                c_cliente_nome.setEnabled(false);
                c_cliente_sobrenome.setEnabled(false);
                c_cliente_telefone.setEnabled(false);
                btn_cliente_novo.setEnabled(true);
                btn_cliente_editar.setEnabled(true);
                btn_cliente_excluir.setEnabled(true);
                btn_cliente_pedido.setEnabled(true);
                break;
        }
    }

    public boolean validaTelefone(String telefone) {
        if (telefone.matches("[0-9]+") && telefone.length() > 9 && telefone.length() < 12) {
            return true;
        } else {
            showMessageDialog(null, "Telefone inválido. Digite seu telefone com DDD.");
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_clientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        c_cliente_nome = new javax.swing.JTextField();
        c_cliente_sobrenome = new javax.swing.JTextField();
        c_cliente_telefone = new javax.swing.JTextField();
        btn_cliente_salvar = new javax.swing.JButton();
        btn_cliente_cancelar = new javax.swing.JButton();
        btn_cliente_novo = new javax.swing.JButton();
        btn_cliente_editar = new javax.swing.JButton();
        btn_cliente_excluir = new javax.swing.JButton();
        btn_cliente_pedido = new javax.swing.JButton();
        c_filtrar_cliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_sabores = new javax.swing.JTable();
        btn_sabor_excluir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        c_sabor_nome = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_sabor_salvar = new javax.swing.JButton();
        cbx_tipo_sabor = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btn_preco_simples_salvar = new javax.swing.JButton();
        c_preco_simples = new javax.swing.JTextField();
        titulo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_preco_especial_salvar = new javax.swing.JButton();
        btn_preco_premium_salvar = new javax.swing.JButton();
        c_preco_especial = new javax.swing.JTextField();
        c_preco_premium = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_pedidos = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        c_pedidos_id = new javax.swing.JTextField();
        c_pedidos_telefone = new javax.swing.JTextField();
        c_pedidos_preco = new javax.swing.JTextField();
        btn_pedidos_salvar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cbx_pedidos_estado = new javax.swing.JComboBox<>();
        tabelaClienteView = new pizzaria.view.ClienteTabelaView();
        formularioCliente = new pizzaria.view.ClienteFormularioView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabsMouseClicked(evt);
            }
        });

        tb_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Sobrenome", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_clientes);
        if (tb_clientes.getColumnModel().getColumnCount() > 0) {
            tb_clientes.getColumnModel().getColumn(0).setResizable(false);
            tb_clientes.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_clientes.getColumnModel().getColumn(1).setResizable(false);
            tb_clientes.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_clientes.getColumnModel().getColumn(2).setResizable(false);
            tb_clientes.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cliente"));

        jLabel1.setText("Nome:");

        jLabel2.setText("Sobrenome:");

        jLabel3.setText("Telefone:");

        c_cliente_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_cliente_nomeActionPerformed(evt);
            }
        });

        btn_cliente_salvar.setText("Salvar");
        btn_cliente_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_salvarActionPerformed(evt);
            }
        });

        btn_cliente_cancelar.setText("Cancelar");
        btn_cliente_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_cancelarActionPerformed(evt);
            }
        });

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_cliente_salvar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cliente_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(c_cliente_nome)
                    .addComponent(c_cliente_sobrenome)
                    .addComponent(c_cliente_telefone))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_cliente_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_cliente_sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c_cliente_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cliente_salvar)
                    .addComponent(btn_cliente_cancelar))
                .addContainerGap())
        );

        btn_cliente_novo.setText("Novo");
        btn_cliente_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_novoActionPerformed(evt);
            }
        });

        btn_cliente_editar.setText("Editar");
        btn_cliente_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_editarActionPerformed(evt);
            }
        });

        btn_cliente_excluir.setText("Excluir");
        btn_cliente_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_excluirActionPerformed(evt);
            }
        });

        btn_cliente_pedido.setText("Pedido");
        btn_cliente_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_pedidoActionPerformed(evt);
            }
        });

        c_filtrar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_filtrar_clienteActionPerformed(evt);
            }
        });
        c_filtrar_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                c_filtrar_clienteKeyReleased(evt);
            }
        });

        jLabel4.setText("Filtrar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cliente_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cliente_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_cliente_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cliente_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_filtrar_cliente)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_filtrar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cliente_novo)
                    .addComponent(btn_cliente_pedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cliente_editar)
                    .addComponent(btn_cliente_excluir))
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabs.addTab("Clientes", jPanel1);

        tb_sabores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sabor", "Tipo", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_sabores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_saboresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_sabores);

        btn_sabor_excluir.setText("Excluir");
        btn_sabor_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sabor_excluirActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Sabor"));

        c_sabor_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_sabor_nomeActionPerformed(evt);
            }
        });

        jLabel14.setText("Tipo:");

        jLabel5.setText("Nome:");

        btn_sabor_salvar.setText("Salvar");
        btn_sabor_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sabor_salvarActionPerformed(evt);
            }
        });

        cbx_tipo_sabor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simples", "Especial", "Premium" }));
        cbx_tipo_sabor.setToolTipText("");
        cbx_tipo_sabor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_tipo_saborActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_sabor_nome)
                            .addComponent(cbx_tipo_sabor, 0, 224, Short.MAX_VALUE))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_sabor_salvar)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(c_sabor_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbx_tipo_sabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btn_sabor_salvar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btn_sabor_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_sabor_excluir)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabs.addTab("Sabores", jPanel3);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Simples:");

        btn_preco_simples_salvar.setText("Salvar");
        btn_preco_simples_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preco_simples_salvarActionPerformed(evt);
            }
        });

        c_preco_simples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_preco_simplesActionPerformed(evt);
            }
        });

        titulo.setText("Valores dos Tipos de Pizza");

        jLabel7.setText("R$ por cm2");

        jLabel8.setText("Especial:");

        jLabel9.setText("R$ por cm2");

        jLabel10.setText("Premium:");

        jLabel11.setText("R$ por cm2");

        btn_preco_especial_salvar.setText("Salvar");
        btn_preco_especial_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preco_especial_salvarActionPerformed(evt);
            }
        });

        btn_preco_premium_salvar.setText("Salvar");
        btn_preco_premium_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preco_premium_salvarActionPerformed(evt);
            }
        });

        c_preco_especial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_preco_especialActionPerformed(evt);
            }
        });

        c_preco_premium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_preco_premiumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(titulo))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_preco_especial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_preco_premium, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_preco_simples, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(btn_preco_premium_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(btn_preco_simples_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(btn_preco_especial_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_preco_simples, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(btn_preco_simples_salvar))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(btn_preco_especial_salvar)
                    .addComponent(c_preco_especial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(btn_preco_premium_salvar)
                    .addComponent(c_preco_premium, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(367, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Preços", jPanel5);

        tb_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Telefone", "Preco", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_pedidos.setMaximumSize(new java.awt.Dimension(60, 0));
        tb_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_pedidosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_pedidos);
        if (tb_pedidos.getColumnModel().getColumnCount() > 0) {
            tb_pedidos.getColumnModel().getColumn(0).setResizable(false);
            tb_pedidos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tb_pedidos.getColumnModel().getColumn(1).setResizable(false);
            tb_pedidos.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_pedidos.getColumnModel().getColumn(2).setResizable(false);
            tb_pedidos.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Pedidos"));
        jPanel8.setMaximumSize(new java.awt.Dimension(60, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Id:");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 34, -1, -1));

        jLabel15.setText("Telefone:");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 63, -1, -1));

        jLabel16.setText("Preco:");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 92, -1, -1));

        c_pedidos_id.setEditable(false);
        c_pedidos_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c_pedidos_id.setMaximumSize(new java.awt.Dimension(6, 22));
        c_pedidos_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_pedidos_idActionPerformed(evt);
            }
        });
        jPanel8.add(c_pedidos_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 31, 186, -1));

        c_pedidos_telefone.setEditable(false);
        c_pedidos_telefone.setMaximumSize(new java.awt.Dimension(6, 22));
        c_pedidos_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_pedidos_telefoneActionPerformed(evt);
            }
        });
        jPanel8.add(c_pedidos_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 60, 186, -1));

        c_pedidos_preco.setEditable(false);
        c_pedidos_preco.setMaximumSize(new java.awt.Dimension(6, 22));
        jPanel8.add(c_pedidos_preco, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 89, 186, -1));

        btn_pedidos_salvar.setText("Salvar");
        btn_pedidos_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedidos_salvarActionPerformed(evt);
            }
        });
        jPanel8.add(btn_pedidos_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        jLabel17.setText("Estado:");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 121, -1, -1));

        cbx_pedidos_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aberto", "A caminho", "Entregue" }));
        cbx_pedidos_estado.setMaximumSize(new java.awt.Dimension(87, 22));
        jPanel8.add(cbx_pedidos_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 118, 186, -1));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        tabs.addTab("Pedidos", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(tabelaClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(formularioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabs)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tabelaClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(formularioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c_cliente_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_cliente_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_cliente_nomeActionPerformed

    private void btn_cliente_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_editarActionPerformed
        modo = "Editar";
        manipulaInterface();
    }//GEN-LAST:event_btn_cliente_editarActionPerformed

    private void btn_cliente_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_novoActionPerformed
        modo = "Novo";
        manipulaInterface();
    }//GEN-LAST:event_btn_cliente_novoActionPerformed

    private void btn_cliente_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_cancelarActionPerformed
        modo = "Navegar";
        manipulaInterface();
    }//GEN-LAST:event_btn_cliente_cancelarActionPerformed

    private void btn_cliente_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_excluirActionPerformed
        int index = tb_clientes.getSelectedRow();
        if (index >= 0 && index < listaClientes.size()) {
            listaClientes.remove(index);
        }
        loadTableClientes();
        modo = "Navegar";
        manipulaInterface();
    }//GEN-LAST:event_btn_cliente_excluirActionPerformed

    ///////// ONDA LARANJA
    private ClienteTableModel clienteTableModel = new ClienteTableModel();

    private int linhaClicadaParaAtualizacao = -1;

    public void initView() {
        /* Create and display the form */
        tabelaClienteView.getTabelaCliente().setModel(clienteTableModel);
        tabelaClienteView.getTabelaCliente().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //Pega a linha clicada
                linhaClicadaParaAtualizacao = tabelaClienteView.getTabelaCliente().rowAtPoint(evt.getPoint());
                //Pega o contato da linha clicada
                Cliente cliente = clienteTableModel.getCliente(linhaClicadaParaAtualizacao);
                //Seta os dados nos componentes
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

    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null, info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btn_cliente_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_salvarActionPerformed
        String nome = c_cliente_nome.getText();
        String sobrenome = c_cliente_sobrenome.getText();
        String telefone = c_cliente_telefone.getText();

        if (!nome.isEmpty() && !sobrenome.isEmpty() && !telefone.isEmpty()) {
            if (validaTelefone(telefone)) {
                if (modo.equals("Novo")) {
                    Cliente novoCliente = new Cliente(nome, sobrenome, telefone);

                    listaClientes.add(novoCliente);
                } else if (modo.equals("Editar")) {
                    int index = tb_clientes.getSelectedRow();
                    listaClientes.get(index).setNome(nome);
                    listaClientes.get(index).setSobrenome(sobrenome);
                    listaClientes.get(index).setTelefone(telefone);
                }
                loadTableClientes();
                modo = "Navegar";
                manipulaInterface();
            }
        } else {
            showMessageDialog(null, "Todos os campos devem ser preenchidos!");
        }
    }//GEN-LAST:event_btn_cliente_salvarActionPerformed

    private void tb_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_clientesMouseClicked
        int index = tb_clientes.getSelectedRow();
        if (index >= 0 && index < listaClientes.size()) {
            modo = "Selecao";
            manipulaInterface();
            Cliente c = listaClientes.get(index);
            c_cliente_nome.setText(c.getNome());
            c_cliente_sobrenome.setText(c.getSobrenome());
            c_cliente_telefone.setText(c.getTelefone());
        }
    }//GEN-LAST:event_tb_clientesMouseClicked

    private void btn_cliente_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_pedidoActionPerformed
        int index = tb_clientes.getSelectedRow();
        if (index >= 0 && index < listaClientes.size()) {
            Cliente clienteSelecionado = listaClientes.get(index);
            TelaNovoPedido telaPedidos = new TelaNovoPedido(clienteSelecionado);
            telaPedidos.setVisible(true);
            SwingUtilities.updateComponentTreeUI(telaPedidos);
        }
    }//GEN-LAST:event_btn_cliente_pedidoActionPerformed

    private void c_filtrar_clienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_filtrar_clienteKeyReleased
        DefaultTableModel tabela = (DefaultTableModel) tb_clientes.getModel();
        String pesquisa = c_filtrar_cliente.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tabela);
        tb_clientes.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + pesquisa));
    }//GEN-LAST:event_c_filtrar_clienteKeyReleased

    private void c_sabor_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_sabor_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_sabor_nomeActionPerformed

    private void cbx_tipo_saborActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_tipo_saborActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_tipo_saborActionPerformed

    private void btn_sabor_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sabor_salvarActionPerformed
        String nomeSabor = c_sabor_nome.getText();
        SaborPizza saborPizza;

        if (nomeSabor.isEmpty()) {
            showMessageDialog(null, "O nome do sabor precisa ser preenchido!");
        } else if (nomeSabor.matches("[0-9]+")) {
            showMessageDialog(null, "O nome do sabor não pode conter números!");
        } else {
            switch (cbx_tipo_sabor.getSelectedItem().toString()) {
                case "Simples":
                    saborPizza = new SaborPizza(nomeSabor, TiposPizza.pizzaSimples);
                    TiposPizza.pizzaSimples.adicionarSabor(saborPizza);
                    listaSabores.add(saborPizza);
                    break;
                case "Especial":
                    saborPizza = new SaborPizza(nomeSabor, TiposPizza.pizzaEspecial);
                    TiposPizza.pizzaEspecial.adicionarSabor(saborPizza);
                    listaSabores.add(saborPizza);
                    break;
                case "Premium":
                    saborPizza = new SaborPizza(nomeSabor, TiposPizza.pizzaPremium);
                    TiposPizza.pizzaPremium.adicionarSabor(saborPizza);
                    listaSabores.add(saborPizza);
                    break;
            }
            loadTableSabores();
            c_sabor_nome.setText("");
        }
    }//GEN-LAST:event_btn_sabor_salvarActionPerformed

    private void btn_sabor_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sabor_excluirActionPerformed
        int index = tb_sabores.getSelectedRow();
        String tipoSabor = tb_sabores.getValueAt(index, 1).toString();
        String idSabor = tb_sabores.getValueAt(index, 2).toString();
        if (index >= 0 && index < listaSabores.size()) {
            listaSabores.remove(index);
            switch (tipoSabor) {
                case "Simples":
                    TiposPizza.pizzaSimples.removerSabor(idSabor);
                    break;
                case "Especial":
                    TiposPizza.pizzaEspecial.removerSabor(idSabor);
                    break;
                case "Premium":
                    TiposPizza.pizzaPremium.removerSabor(idSabor);
                    break;
            }
        }
        loadTableSabores();
        btn_sabor_excluir.setEnabled(false);
        c_sabor_nome.setText("");
    }//GEN-LAST:event_btn_sabor_excluirActionPerformed

    private void tb_saboresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_saboresMouseClicked
        int index = tb_sabores.getSelectedRow();
        if (index >= 0 && index < listaSabores.size()) {
            btn_sabor_excluir.setEnabled(true);
        }
    }//GEN-LAST:event_tb_saboresMouseClicked

    private void btn_preco_simples_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preco_simples_salvarActionPerformed
        double precoSimples;

        try {
            precoSimples = Double.parseDouble(c_preco_simples.getText());
        } catch (Exception e) {
            showMessageDialog(null, "Valor inválido!");
            return;
        }

        TiposPizza.pizzaSimples.setPrecoCmQuadrado(precoSimples);
        showMessageDialog(null, "Sucesso!");
    }//GEN-LAST:event_btn_preco_simples_salvarActionPerformed

    private void c_preco_simplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_preco_simplesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_preco_simplesActionPerformed

    private void btn_preco_especial_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preco_especial_salvarActionPerformed
        double precoEspecial;

        try {
            precoEspecial = Double.parseDouble(c_preco_especial.getText());
        } catch (Exception e) {
            showMessageDialog(null, "Valor inválido!");
            return;
        }

        TiposPizza.pizzaEspecial.setPrecoCmQuadrado(precoEspecial);
        showMessageDialog(null, "Sucesso!");
    }//GEN-LAST:event_btn_preco_especial_salvarActionPerformed

    private void btn_preco_premium_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preco_premium_salvarActionPerformed
        double precoPremium;

        try {
            precoPremium = Double.parseDouble(c_preco_premium.getText());
        } catch (Exception e) {
            showMessageDialog(null, "Valor inválido!");
            return;
        }

        TiposPizza.pizzaPremium.setPrecoCmQuadrado(precoPremium);
        showMessageDialog(null, "Sucesso!");
    }//GEN-LAST:event_btn_preco_premium_salvarActionPerformed

    private void c_preco_especialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_preco_especialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_preco_especialActionPerformed

    private void c_preco_premiumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_preco_premiumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_preco_premiumActionPerformed

    private void tb_pedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_pedidosMouseClicked
        int index = tb_pedidos.getSelectedRow();
        String id = tb_pedidos.getValueAt(index, 0).toString();
        String telefone = tb_pedidos.getValueAt(index, 1).toString();
        String preco = tb_pedidos.getValueAt(index, 2).toString();
        String estado = tb_pedidos.getValueAt(index, 3).toString();

        if (index >= 0) {
            c_pedidos_id.setText(id);
            c_pedidos_telefone.setText(telefone);
            c_pedidos_preco.setText(preco);
            cbx_pedidos_estado.getModel().setSelectedItem(estado);
            btn_pedidos_salvar.setEnabled(true);
        }
    }//GEN-LAST:event_tb_pedidosMouseClicked

    private void c_filtrar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_filtrar_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_filtrar_clienteActionPerformed

    private void tabsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabsMouseClicked

    private void btn_pedidos_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedidos_salvarActionPerformed

        int index = tb_pedidos.getSelectedRow();
        String idPedido = tb_pedidos.getModel().getValueAt(index, 0).toString();

        if (index >= 0) {
            int estadoNum;

            switch (cbx_pedidos_estado.getSelectedItem().toString()) {
                case "Aberto":
                    estadoNum = EstadosEnum.ABERTO;
                    break;
                case "A caminho":
                    estadoNum = EstadosEnum.A_CAMINHO;
                    break;
                case "Entregue":
                    estadoNum = EstadosEnum.ENTREGUE;
                    break;
                default:
                    estadoNum = EstadosEnum.ABERTO;
                    break;
            }

            for (int i = 0; i < listaClientes.size(); i++) {
                Pedido pedido = listaClientes.get(i).getPedido();
                if (pedido.getId() == idPedido) {
                    pedido.setEstado(estadoNum);
                    loadTablePedidos();
                }
            }
        }
    }//GEN-LAST:event_btn_pedidos_salvarActionPerformed

    private void c_pedidos_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_pedidos_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_pedidos_telefoneActionPerformed

    private void c_pedidos_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_pedidos_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_pedidos_idActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cliente_cancelar;
    private javax.swing.JButton btn_cliente_editar;
    private javax.swing.JButton btn_cliente_excluir;
    private javax.swing.JButton btn_cliente_novo;
    private javax.swing.JButton btn_cliente_pedido;
    private javax.swing.JButton btn_cliente_salvar;
    private javax.swing.JButton btn_pedidos_salvar;
    private javax.swing.JButton btn_preco_especial_salvar;
    private javax.swing.JButton btn_preco_premium_salvar;
    private javax.swing.JButton btn_preco_simples_salvar;
    private javax.swing.JButton btn_sabor_excluir;
    private javax.swing.JButton btn_sabor_salvar;
    private javax.swing.JTextField c_cliente_nome;
    private javax.swing.JTextField c_cliente_sobrenome;
    private javax.swing.JTextField c_cliente_telefone;
    private javax.swing.JTextField c_filtrar_cliente;
    private javax.swing.JTextField c_pedidos_id;
    private javax.swing.JTextField c_pedidos_preco;
    private javax.swing.JTextField c_pedidos_telefone;
    private javax.swing.JTextField c_preco_especial;
    private javax.swing.JTextField c_preco_premium;
    private javax.swing.JTextField c_preco_simples;
    private javax.swing.JTextField c_sabor_nome;
    private javax.swing.JComboBox<String> cbx_pedidos_estado;
    private javax.swing.JComboBox<String> cbx_tipo_sabor;
    private pizzaria.view.ClienteFormularioView formularioCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private pizzaria.view.ClienteTabelaView tabelaClienteView;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tb_clientes;
    private javax.swing.JTable tb_pedidos;
    private javax.swing.JTable tb_sabores;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
