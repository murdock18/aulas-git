
package projetoinventario;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import javafx.scene.input.KeyCode;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BuscaItens extends javax.swing.JFrame {

    
    public BuscaItens() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        heroi = new javax.swing.JLabel();
        cubo1 = new javax.swing.JLabel();
        cubo2 = new javax.swing.JLabel();
        cubo3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventario1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caçar Item");
        setSize(new java.awt.Dimension(423, 276));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(null);

        heroi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoinventario/heroi.jpg"))); // NOI18N
        heroi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                heroiKeyPressed(evt);
            }
        });
        getContentPane().add(heroi);
        heroi.setBounds(275, 185, 32, 32);

        cubo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoinventario/item.jpg"))); // NOI18N
        cubo1.setName("Cubo1"); // NOI18N
        getContentPane().add(cubo1);
        cubo1.setBounds(270, 20, 32, 32);

        cubo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoinventario/item.jpg"))); // NOI18N
        cubo2.setName("Cubo2"); // NOI18N
        getContentPane().add(cubo2);
        cubo2.setBounds(310, 20, 32, 32);

        cubo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoinventario/item.jpg"))); // NOI18N
        cubo3.setName("Cubo3"); // NOI18N
        getContentPane().add(cubo3);
        cubo3.setBounds(350, 20, 32, 32);

        inventario1.setFocusable(false);
        jScrollPane1.setViewportView(inventario1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 10, 120, 170);

        pack();
    }

    public ArrayList<JLabel> itensMapa = new ArrayList<>(); 
    public DefaultListModel model = new DefaultListModel();
    
    public void colisao(){
//        if (itensMapa.isEmpty()){
//            itensMapa.add(cubo1);
//            itensMapa.add(cubo2);
//            itensMapa.add(cubo3);
//        }
        
        for (JLabel itensM : itensMapa) {
            if (itensM.isVisible()==true)
                if (itensM.getBounds().intersects(heroi.getBounds())){
                    itensM.setVisible(false);
                    model.addElement("Item: "+itensM.getName());                    
                }
        }        
        inventario1.setModel(model);
    }
    
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {            
            heroi.setLocation(heroi.getX(), heroi.getY()-10);
            colisao();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            heroi.setLocation(heroi.getX(), heroi.getY()+10);
            colisao();
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            heroi.setLocation(heroi.getX()-10, heroi.getY());
            colisao();
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            heroi.setLocation(heroi.getX()+10, heroi.getY());
            colisao();
        }
    }//GEN-LAST:event_formKeyPressed

    private void heroiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_heroiKeyPressed
    
    }//GEN-LAST:event_heroiKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
         
    }//GEN-LAST:event_formKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            ArrayList<JLabel> itensIniciais = new ArrayList<JLabel>();
            
            public void criarItens(BuscaItens form, String name){
                JLabel cubo = new JLabel();
                cubo.setIcon(new ImageIcon(
                      getClass().getResource(
                              "/projetoinventario/item.jpg")));
                int posX = new Random().nextInt(300);
                int posY = new Random().nextInt(300);
                int w = 32;
                int h = 32;
                cubo.setBounds(posX, posY, w, h);
                cubo.setName(name);
                cubo.setText("");
                form.itensMapa.add(cubo);
                form.getContentPane().add(cubo);
                cubo.getBounds();
            }
            
            public void run() {
                BuscaItens formBuscarItens= new BuscaItens();
                formBuscarItens.setSize(450, 450);
                
                for (int x=0; x<2; x++){
                    criarItens(formBuscarItens, "Item_"+x);
                }
                formBuscarItens.setVisible(true);                
            }
        });
    }

    
    private javax.swing.JLabel cubo1;
    private javax.swing.JLabel cubo2;
    private javax.swing.JLabel cubo3;
    private javax.swing.JLabel heroi;
    private javax.swing.JList<String> inventario1;
    private javax.swing.JScrollPane jScrollPane1;
    
}