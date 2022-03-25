package examen2p2_pamelaramirez_12141141;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Principal extends javax.swing.JFrame implements Runnable {

    Random r = new Random();
    Binarios file = new Binarios("./Cientificos.cbm");
    ArrayList<Planeta> publicos = new ArrayList();
    Planeta p1, p2;
    int d, peso, tam, x, y;
    double energia, tiempo, velocidad, energiaMax;
    Thread hilo = new Thread(this);

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Examen II");
        publicos.add(new Terrestre(5000, 13000, "Mercurio", 400, 300));
        publicos.add(new Terrestre(100000, 15000, "Venus", 640, 260));
        publicos.add(new Terrestre(140000, 17000, "Tierra", 760, 570));
        publicos.add(new Terrestre(90000, 12000, "Marte", 360, 360));
        publicos.add(new Gaseoso(400000, 40000, "Jupiter", 340, 310));
        publicos.add(new Gaseoso(300000, 30000, "Saturno", 560, 450));
        publicos.add(new Gaseoso(200000, 20000, "Urano", 670, 690));
        publicos.add(new Gaseoso(200000, 20000, "Neptuno", 840, 900));
        publicos.add(new Gaseoso(400000, 40000, "Vegetta", 340, 310));
        try {
            file.cargarArchivo();
            actualizarCbo();
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        tiempo = 0.0;
        pb1.setMaximum((int) d);
        boolean sigue = true, bonus = false;
        while (sigue) {
            try {
                pb1.setValue(pb1.getValue() + 1);
                tiempo += 5.0;
                Thread.sleep(5);
                if (pb1.getValue() == pb1.getMaximum()) {
                    sigue = false;
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (p1.seCrea()) {
            String nom = JOptionPane.showInputDialog(this, "Se ha creado un nuevo planeta!"
                    + "\nIngrese el nombre: ");
            Cientifico cientifico = (Cientifico) cboCientificos.getSelectedItem();
            if (p1 instanceof Terrestre) {
                cientifico.getPlanetas().add(new Terrestre(tam, peso, nom, x, y));
            } else {
                cientifico.getPlanetas().add(new Gaseoso(tam, peso, nom, x, y));
            }
            file.escribirArchivo();
            file.cargarArchivo();
            actualizarTree(cientifico.getPlanetas());
        }
        velocidad = d / tiempo;
        energia = (0.5) * (p1.getPeso() + p2.getPeso()) * Math.pow(velocidad, 2);
        energiaMax = (int)energia + r.nextInt((int)(energia * 2));
        System.out.println("Tiempo: " + tiempo);
        System.out.println("Distancia: " + d);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("Energia: " + energia);
        System.out.println("Energia maxima: " + energiaMax + "\n");
        pb2.setMaximum((int)(energiaMax));
        bonus = true;
        while (bonus) {
            try {
                pb2.setValue(pb2.getValue() + 1);
                Thread.sleep(5);
                if (pb2.getValue() >= energia) {
                    bonus = false;
                }
                if (pb2.getValue() <= (energiaMax * 50)/100) {
                    pb2.setForeground(Color.green);
                }
                else if (pb2.getValue() > (energiaMax * 50)/100
                        && pb2.getValue() <= (energiaMax * 75)/100) {
                    pb2.setForeground(Color.yellow);
                }
                else if (pb2.getValue() > (energiaMax * 75)/100
                        && pb2.getValue() <= (energiaMax * 90)/100) {
                    pb2.setForeground(Color.red);
                }
                else {
                    pb2.setForeground(Color.black);
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public void actualizarCbo() {
        file.cargarArchivo();
        DefaultComboBoxModel cbo = new DefaultComboBoxModel();
        if (!file.getCientificos().isEmpty()) {
            for (Cientifico cientifico : file.getCientificos()) {
                cbo.addElement(cientifico);
            }
        }
        cboCientificos.setModel(cbo);
    }

    public void actualizarTree(ArrayList<Planeta> planetas) {
        // Modelo, nodo y raiz
        file.cargarArchivo();
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Planetas");
        DefaultTreeModel modelo = new DefaultTreeModel(raiz);
        DefaultMutableTreeNode nodoPlaneta = new DefaultMutableTreeNode();
        if (!planetas.isEmpty()) {
            for (Planeta planeta : planetas) {
                nodoPlaneta = new DefaultMutableTreeNode(planeta);
                raiz.add(nodoPlaneta);
            }
        }
        tree.setModel(modelo);
        modelo.reload();
    }

    public Planeta asignarPlaneta(JTextField txt) {
        Planeta planeta = null;
        if (tree.getSelectionCount() == 1) {
            DefaultMutableTreeNode nodoPlaneta
                    = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            planeta = (Planeta) nodoPlaneta.getUserObject();
            txt.setText(planeta.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un planeta.", "", 2);
        }
        return planeta;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pop = new javax.swing.JPopupMenu();
        pop1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        pop2 = new javax.swing.JMenuItem();
        pb2 = new javax.swing.JProgressBar();
        pb1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        cbPublicos = new javax.swing.JCheckBox();
        txtPlaneta1 = new javax.swing.JTextField();
        txtPlaneta2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cboCientificos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnColision = new javax.swing.JButton();

        pop1.setText("Asignar planeta 1");
        pop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pop1ActionPerformed(evt);
            }
        });
        pop.add(pop1);
        pop.add(jSeparator1);

        pop2.setText("Asignar planeta 2");
        pop2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pop2ActionPerformed(evt);
            }
        });
        pop.add(pop2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Planetas");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        tree.setComponentPopupMenu(pop);
        jScrollPane1.setViewportView(tree);

        cbPublicos.setText("Planetas públicos");
        cbPublicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPublicosActionPerformed(evt);
            }
        });

        txtPlaneta1.setEditable(false);

        txtPlaneta2.setEditable(false);

        jLabel1.setText("Cientificos");

        cboCientificos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccionar -" }));
        cboCientificos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCientificosItemStateChanged(evt);
            }
        });

        jLabel2.setText("Nombre");

        btnAdd.setText("Agregar cientifico");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnColision.setText("Colisionar");
        btnColision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColisionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbPublicos, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPlaneta1)
                                    .addComponent(txtPlaneta2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboCientificos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNom)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnColision, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pb1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pb2, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(pb1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pb2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPlaneta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPlaneta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnColision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboCientificos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(cbPublicos)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtNom.getText().isEmpty() || txtNom.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del cientifico.", "Entrada invalida", 2);
        } else {
            file.addCientifico(new Cientifico(txtNom.getText()));
            actualizarCbo();
            txtNom.setText(null);
            JOptionPane.showMessageDialog(this, "Cientifico agregado exitosamente.", "Cientifico agregado", 1);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbPublicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPublicosActionPerformed
        actualizarTree(new ArrayList());
        if (cbPublicos.isSelected()) {
            actualizarTree(publicos);
        } else {
            if (cboCientificos.getSelectedIndex() >= 0) {
                Cientifico cientifico = (Cientifico) cboCientificos.getSelectedItem();
                if (!cientifico.getPlanetas().isEmpty()) {
                    actualizarTree(cientifico.getPlanetas());
                }
            }
        }
    }//GEN-LAST:event_cbPublicosActionPerformed

    private void pop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pop1ActionPerformed
        p1 = asignarPlaneta(txtPlaneta1);
    }//GEN-LAST:event_pop1ActionPerformed

    private void pop2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pop2ActionPerformed
        p2 = asignarPlaneta(txtPlaneta2);
    }//GEN-LAST:event_pop2ActionPerformed

    private void cboCientificosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCientificosItemStateChanged
        actualizarTree(new ArrayList());
        if (cboCientificos.getSelectedIndex() >= 0) {
            cbPublicos.setSelected(false);
            Cientifico cientifico = (Cientifico) cboCientificos.getSelectedItem();
            if (!cientifico.getPlanetas().isEmpty()) {
                actualizarTree(cientifico.getPlanetas());
            }
        }
    }//GEN-LAST:event_cboCientificosItemStateChanged

    private void btnColisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColisionActionPerformed
        int x, y;
        try {
            if (cboCientificos.getSelectedIndex() >= 0) {
                if (p1 != null && p2 != null) {
                    x = (int) Math.pow(p2.getX() - p1.getX(), 2);
                    y = (int) Math.pow(p2.getY() - p1.getY(), 2);
                    d = (int) Math.sqrt(x + y);
                    peso = (p1.getPeso() + p2.getPeso()) / 2;
                    this.x = (p1.getX() + p2.getX()) / 2;
                    this.y = (p1.getY() + p2.getY()) / 2;
                }
                if (d > 0) {
                    pb1.setValue(0);
                    pb2.setValue(0);
                    new Thread(this).start();
                    file.escribirArchivo();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un cientifico.", "", 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnColisionActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnColision;
    private javax.swing.JCheckBox cbPublicos;
    private javax.swing.JComboBox<String> cboCientificos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JProgressBar pb1;
    private javax.swing.JProgressBar pb2;
    private javax.swing.JPopupMenu pop;
    private javax.swing.JMenuItem pop1;
    private javax.swing.JMenuItem pop2;
    private javax.swing.JTree tree;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPlaneta1;
    private javax.swing.JTextField txtPlaneta2;
    // End of variables declaration//GEN-END:variables
}
