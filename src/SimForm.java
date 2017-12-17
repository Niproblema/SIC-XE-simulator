
import java.awt.Color;
import java.io.File;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jan
 * Also available on https://github.com/Niproblema/SIC-XE-simulator
 */
public class SimForm extends javax.swing.JFrame {

    Machine ms;
    boolean isRunning = false;
    String mFilePath = null;

    /**
     * Creates new form SimForm
     */
    public SimForm() {
        initComponents();
        ms = new Machine();
        ms.refreshingForm = this;
//        MessageConsole mc = new MessageConsole(jTextArea_Console);
//        mc.setMessageLines(100);
//        mc.redirectErr(Color.RED, System.err);
//        mc.redirectOut(Color.MAGENTA, System.out);        
// mc.redirectOut(Color.YELLOW, System.in);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TxF_RegA = new javax.swing.JTextField();
        Lab_RegA = new javax.swing.JLabel();
        Lab_RegX = new javax.swing.JLabel();
        TxF_RegX = new javax.swing.JTextField();
        Lab_RegL = new javax.swing.JLabel();
        TxF_RegL = new javax.swing.JTextField();
        Lab_RegB = new javax.swing.JLabel();
        TxF_RegB = new javax.swing.JTextField();
        Lab_RegS = new javax.swing.JLabel();
        TxF_RegS = new javax.swing.JTextField();
        Lab_RegT = new javax.swing.JLabel();
        TxF_RegT = new javax.swing.JTextField();
        Lab_RegF = new javax.swing.JLabel();
        TxF_RegF = new javax.swing.JTextField();
        Lab_RegPC = new javax.swing.JLabel();
        TxF_RegPC = new javax.swing.JTextField();
        TxF_CLK = new javax.swing.JTextField();
        Lab_CLK = new javax.swing.JLabel();
        jButton_Start = new javax.swing.JButton();
        jButton_Stop = new javax.swing.JButton();
        jButton_Step = new javax.swing.JButton();
        jButton1_LoadObj = new javax.swing.JButton();
        jLabel_FileLoaded = new javax.swing.JLabel();
        jButton_Reset_Reg = new javax.swing.JButton();
        jButton2_Reload = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sic/XE sim");
        setResizable(false);

        TxF_RegA.setText("0");
        TxF_RegA.setAutoscrolls(false);
        TxF_RegA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxF_RegAActionPerformed(evt);
            }
        });

        Lab_RegA.setText("Reg A:");

        Lab_RegX.setText("Reg X:");

        TxF_RegX.setText("0");
        TxF_RegX.setAutoscrolls(false);
        TxF_RegX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxF_RegXActionPerformed(evt);
            }
        });

        Lab_RegL.setText("Reg L:");

        TxF_RegL.setText("0");
        TxF_RegL.setAutoscrolls(false);
        TxF_RegL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxF_RegLActionPerformed(evt);
            }
        });

        Lab_RegB.setText("Reg B:");

        TxF_RegB.setText("0");
        TxF_RegB.setAutoscrolls(false);
        TxF_RegB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxF_RegBActionPerformed(evt);
            }
        });

        Lab_RegS.setText("Reg S:");

        TxF_RegS.setText("0");
        TxF_RegS.setAutoscrolls(false);
        TxF_RegS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxF_RegSActionPerformed(evt);
            }
        });

        Lab_RegT.setText("Reg T:");

        TxF_RegT.setText("0");
        TxF_RegT.setAutoscrolls(false);
        TxF_RegT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxF_RegTActionPerformed(evt);
            }
        });

        Lab_RegF.setText("Reg F:");

        TxF_RegF.setText("0");
        TxF_RegF.setAutoscrolls(false);
        TxF_RegF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxF_RegFActionPerformed(evt);
            }
        });

        Lab_RegPC.setText("Reg PC:");

        TxF_RegPC.setText("0");
        TxF_RegPC.setAutoscrolls(false);
        TxF_RegPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxF_RegPCActionPerformed(evt);
            }
        });

        TxF_CLK.setText("100");
        TxF_CLK.setAutoscrolls(false);
        TxF_CLK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxF_CLKActionPerformed(evt);
            }
        });

        Lab_CLK.setText("CLK Speed");

        jButton_Start.setText("Start");
        jButton_Start.setPreferredSize(new java.awt.Dimension(70, 30));
        jButton_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_StartActionPerformed(evt);
            }
        });

        jButton_Stop.setText("Stop");
        jButton_Stop.setPreferredSize(new java.awt.Dimension(70, 30));
        jButton_Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_StopActionPerformed(evt);
            }
        });

        jButton_Step.setText("Step");
        jButton_Step.setPreferredSize(new java.awt.Dimension(70, 30));
        jButton_Step.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_StepActionPerformed(evt);
            }
        });

        jButton1_LoadObj.setText("Load obj");
        jButton1_LoadObj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_LoadObjActionPerformed(evt);
            }
        });

        jLabel_FileLoaded.setText("none");
        jLabel_FileLoaded.setAutoscrolls(true);

        jButton_Reset_Reg.setText("Reset");
        jButton_Reset_Reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Reset_RegActionPerformed(evt);
            }
        });

        jButton2_Reload.setText("Reload obj");
        jButton2_Reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_ReloadActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jan Aleksandrov, 63140001");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1_LoadObj, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jButton_Reset_Reg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_FileLoaded, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2_Reload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Lab_RegA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxF_RegA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lab_RegS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxF_RegS, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Lab_RegX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxF_RegX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lab_RegT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxF_RegT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Lab_RegB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxF_RegB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Lab_RegPC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxF_RegPC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Lab_RegL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxF_RegL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Lab_RegF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxF_RegF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Lab_CLK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxF_CLK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton_Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Step, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1_LoadObj)
                    .addComponent(jLabel_FileLoaded))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Reset_Reg)
                    .addComponent(jButton2_Reload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lab_RegA)
                    .addComponent(TxF_RegA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lab_RegS)
                    .addComponent(TxF_RegS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lab_RegX)
                    .addComponent(TxF_RegX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lab_RegT)
                    .addComponent(TxF_RegT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lab_RegL)
                    .addComponent(TxF_RegL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lab_RegF)
                    .addComponent(TxF_RegF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lab_RegB)
                    .addComponent(TxF_RegB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lab_RegPC)
                    .addComponent(TxF_RegPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lab_CLK)
                    .addComponent(TxF_CLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Step, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxF_RegAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxF_RegAActionPerformed
        System.out.println(Integer.toString(Integer.parseInt(TxF_RegA.getText())));
        ms.A.setValue(Integer.parseInt(TxF_RegA.getText()));
        System.out.println(Integer.toString(ms.A.getValue().intValue()));
    }//GEN-LAST:event_TxF_RegAActionPerformed

    private void TxF_RegXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxF_RegXActionPerformed
        ms.X.setValue(Integer.parseInt(TxF_RegX.getText()));
    }//GEN-LAST:event_TxF_RegXActionPerformed

    private void TxF_RegLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxF_RegLActionPerformed
        ms.L.setValue(Integer.parseInt(TxF_RegL.getText()));
    }//GEN-LAST:event_TxF_RegLActionPerformed

    private void TxF_RegBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxF_RegBActionPerformed
        ms.B.setValue(Integer.parseInt(TxF_RegB.getText()));
    }//GEN-LAST:event_TxF_RegBActionPerformed

    private void TxF_RegSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxF_RegSActionPerformed
        ms.S.setValue(Integer.parseInt(TxF_RegS.getText()));
    }//GEN-LAST:event_TxF_RegSActionPerformed

    private void TxF_RegTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxF_RegTActionPerformed
        ms.T.setValue(Integer.parseInt(TxF_RegT.getText()));
    }//GEN-LAST:event_TxF_RegTActionPerformed

    private void TxF_RegFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxF_RegFActionPerformed
        ms.F.setValue(Double.parseDouble(TxF_RegF.getText()));
    }//GEN-LAST:event_TxF_RegFActionPerformed

    private void TxF_RegPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxF_RegPCActionPerformed
        ms.PC.setValue(Integer.parseInt(TxF_RegPC.getText()));
    }//GEN-LAST:event_TxF_RegPCActionPerformed

    private void TxF_CLKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxF_CLKActionPerformed
        ms.setSpeed(Integer.parseInt(TxF_CLK.getText()));
    }//GEN-LAST:event_TxF_CLKActionPerformed

    private void jButton_Reset_RegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Reset_RegActionPerformed
        ms.resetRegisters();
        ms.resetMemory();
        this.refresh();
    }//GEN-LAST:event_jButton_Reset_RegActionPerformed

    private void jButton_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_StartActionPerformed
        if (!isRunning) {
            ms.start();
            isRunning = true;
        }
    }//GEN-LAST:event_jButton_StartActionPerformed

    private void jButton_StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_StopActionPerformed
        ms.stop();
        isRunning = false;
    }//GEN-LAST:event_jButton_StopActionPerformed

    private void jButton_StepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_StepActionPerformed
        if (!isRunning) {
            ms.start(1);
        }
    }//GEN-LAST:event_jButton_StepActionPerformed

    private void jButton2_ReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_ReloadActionPerformed
        if (mFilePath != null) {
            Loader.loadObjFile(ms, mFilePath);
        }
    }//GEN-LAST:event_jButton2_ReloadActionPerformed

    private void jButton1_LoadObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_LoadObjActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            mFilePath = fileChooser.getSelectedFile().getAbsolutePath();
            Loader.loadObjFile(ms, mFilePath);
            jLabel_FileLoaded.setText(fileChooser.getSelectedFile().getName());
        }
    }//GEN-LAST:event_jButton1_LoadObjActionPerformed

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
            java.util.logging.Logger.getLogger(SimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimForm().setVisible(true);
            }
        });
    }

    public void refresh() {
        TxF_CLK.setText(Integer.toString(ms.getSpeed()));
        TxF_RegA.setText(Integer.toString(ms.A.getValue().intValue()));
        TxF_RegB.setText(Integer.toString(ms.B.getValue().intValue()));
        TxF_RegF.setText(Double.toString(ms.F.getValue().doubleValue()));
        TxF_RegL.setText(Integer.toString(ms.L.getValue().intValue()));
        TxF_RegPC.setText(Integer.toString(ms.PC.getValue().intValue()));
        TxF_RegS.setText(Integer.toString(ms.S.getValue().intValue()));
        TxF_RegT.setText(Integer.toString(ms.T.getValue().intValue()));
        TxF_RegX.setText(Integer.toString(ms.X.getValue().intValue()));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lab_CLK;
    private javax.swing.JLabel Lab_RegA;
    private javax.swing.JLabel Lab_RegB;
    private javax.swing.JLabel Lab_RegF;
    private javax.swing.JLabel Lab_RegL;
    private javax.swing.JLabel Lab_RegPC;
    private javax.swing.JLabel Lab_RegS;
    private javax.swing.JLabel Lab_RegT;
    private javax.swing.JLabel Lab_RegX;
    private javax.swing.JTextField TxF_CLK;
    private javax.swing.JTextField TxF_RegA;
    private javax.swing.JTextField TxF_RegB;
    private javax.swing.JTextField TxF_RegF;
    private javax.swing.JTextField TxF_RegL;
    private javax.swing.JTextField TxF_RegPC;
    private javax.swing.JTextField TxF_RegS;
    private javax.swing.JTextField TxF_RegT;
    private javax.swing.JTextField TxF_RegX;
    private javax.swing.JButton jButton1_LoadObj;
    private javax.swing.JButton jButton2_Reload;
    private javax.swing.JButton jButton_Reset_Reg;
    private javax.swing.JButton jButton_Start;
    private javax.swing.JButton jButton_Step;
    private javax.swing.JButton jButton_Stop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_FileLoaded;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
