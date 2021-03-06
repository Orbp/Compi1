/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201220165;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.Timer;
import javax.swing.text.Caret;

/**
 *
 * @author oscar
 */
public class Ventana extends javax.swing.JFrame{

    /**
     * Creates new form Ventana
     */
    String cont = "";
    public static ArrayList<String> errores = new ArrayList();
    int caracter = 0;
    public Ventana() {
        initComponents();
        jTextArea1.setCaretPosition(0);
        jTextArea1.addCaretListener(new CaretListener(){
            @Override
            public void caretUpdate(CaretEvent e) {
                int pos = e.getDot();
                try{
                    int fila = jTextArea1.getLineOfOffset(pos) + 1;
                    int columna = pos - jTextArea1.getLineStartOffset(fila - 1) + 1;
                    jLabel1.setText("Coordenada del Cursor: Fila: " + fila + ", Columna: " + columna);
                }catch(BadLocationException exc){
                    
                }
            }
        });
        
        jTextArea2.addCaretListener(new CaretListener(){
            @Override
            public void caretUpdate(CaretEvent e) {
                int pos = e.getDot();
                try{
                    int fila = jTextArea1.getLineOfOffset(pos) + 1;
                    int columna = pos - jTextArea1.getLineStartOffset(fila - 1) + 1;
                    jLabel2.setText("Coordenada del Cursor: Fila: " + fila + ", Columna: " + columna);
                }catch(BadLocationException exc){
                    
                }
            }
        });
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Visual Basic"));
        jPanel1.setPreferredSize(new java.awt.Dimension(590, 640));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Coordenada del Cursor: Fila: , Columna:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(378, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Java"));
        jPanel2.setPreferredSize(new java.awt.Dimension(590, 640));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel2.setText("Coordenada del Cursor: Fila: , Columna:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(378, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Errores"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Error", "Fila", "Columna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Guardar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setText("Cerrar Clase");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Analizar");

        jMenuItem4.setText("Analizar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem6.setText("Guardar salida");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu9.setText("Salir");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenu9MouseClicked

    public String direccionabierta = "";
    public String contenido = "";
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        if(direccionabierta.compareTo("") != 0){
            if(contenido.compareTo(this.jTextArea1.getText()) != 0){
                if(JOptionPane.showConfirmDialog(this, "Hay una clase abierta ¿Desea guardarla", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
                    if(GuardarArchivo()){
                        this.jTextArea1.setText("");
                        this.contenido = "";
                        this.direccionabierta = "";
                    }else{
                        JOptionPane.showMessageDialog(this, "El archivo no se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    this.jTextArea1.setText("");
                    this.contenido = "";
                    this.direccionabierta = "";
                }
            }else{
                this.jTextArea1.setText("");
                this.contenido = "";
                this.direccionabierta = "";
            }
        }else if(direccionabierta.compareTo("") == 0 && !this.jTextArea1.getText().isEmpty()){
            if(JOptionPane.showConfirmDialog(this, "Hay una clase abierta ¿Desea guardarla?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
                if(GuardarComoArchivo(new FileNameExtensionFilter("VISUAL BASIC", "vb"))){
                    this.jTextArea1.setText("");
                    this.contenido = "";
                    this.direccionabierta = "";
                }else{
                    JOptionPane.showMessageDialog(this, "El archivo no se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                this.jTextArea1.setText("");
                this.contenido = "";
                this.direccionabierta = "";
            }
        }else{
            this.jTextArea1.setText("");
            this.contenido = "";
            this.direccionabierta = "";
        }
        try{
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.vb", "Visual Basic");
            String aux = "";
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(this);
            File archivo = chooser.getSelectedFile();
            if(archivo != null){
                direccionabierta = archivo.getAbsolutePath();
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                while((aux = br.readLine()) != null){
                    this.jTextArea1.append(aux + "\n");
                    contenido += aux + "\n";
                }
                br.close();
                fr.close();
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex + " " + "\nNo existe el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if(direccionabierta.compareTo("") != 0){
            if(contenido.compareTo(this.jTextArea1.getText()) != 0){
                if(JOptionPane.showConfirmDialog(this, "Hay una clase abierta ¿Desea guardarla", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
                    if(GuardarArchivo()){
                        this.jTextArea1.setText("");
                        this.contenido = "";
                        this.direccionabierta = "";
                    }else{
                        JOptionPane.showMessageDialog(this, "El archivo no se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    this.jTextArea1.setText("");
                    this.contenido = "";
                    this.direccionabierta = "";
                }
            }
        }else if(direccionabierta.compareTo("") == 0 && !this.jTextArea1.getText().isEmpty()){
            if(JOptionPane.showConfirmDialog(this, "Hay una clase abierta ¿Desea guardarla?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
                if(GuardarComoArchivo(new FileNameExtensionFilter("VISUAL BASIC", "vb"))){
                    this.jTextArea1.setText("");
                    this.contenido = "";
                    this.direccionabierta = "";
                }else{
                    JOptionPane.showMessageDialog(this, "El archivo no se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                this.jTextArea1.setText("");
                this.contenido = "";
                this.direccionabierta = "";
            }
        }else{
            this.jTextArea1.setText("");
            this.contenido = "";
            this.direccionabierta = "";
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        if(direccionabierta.compareTo("") != 0){
            if(contenido.compareTo(this.jTextArea1.getText()) != 0){
                if(JOptionPane.showConfirmDialog(this, "Hay una clase abierta ¿Desea guardarla", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
                    if(GuardarArchivo()){
                        this.jTextArea1.setText("");
                        this.contenido = "";
                        this.direccionabierta = "";
                    }else{
                        JOptionPane.showMessageDialog(this, "El archivo no se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    this.jTextArea1.setText("");
                    this.contenido = "";
                    this.direccionabierta = "";
                }
            }
        }else if(direccionabierta.compareTo("") == 0 && !this.jTextArea1.getText().isEmpty()){
            if(JOptionPane.showConfirmDialog(this, "Hay una clase abierta ¿Desea guardarla?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
                if(GuardarComoArchivo(new FileNameExtensionFilter("VISUAL BASIC", "vb"))){
                    this.jTextArea1.setText("");
                    this.contenido = "";
                    this.direccionabierta = "";
                }else{
                    JOptionPane.showMessageDialog(this, "El archivo no se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                this.jTextArea1.setText("");
                this.contenido = "";
                this.direccionabierta = "";
            }
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        errores.clear();
        this.jTextArea2.setText("");
        int filas = jTable1.getRowCount();
        DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        for(int i = 0; i < filas; i++){
            modelo.removeRow(0);
        }
        try{
            lexico scanner = new lexico(new BufferedReader(new StringReader(this.jTextArea1.getText().toString())));
            sintactico parser = new sintactico(scanner);
            parser.parse();
            if(errores.isEmpty()){
                JOptionPane.showMessageDialog(this, "Analisis terminado con exito");
                this.jTextArea2.setText(parser.contenido);
            }else{
                JOptionPane.showMessageDialog(this, "La clase analizada contiene errores");
                
                for(int i = 0; i < errores.size(); i++){
                    String error = errores.get(i);
                    String[] dat = error.split("-");
                        modelo.addRow(dat);
                }
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        if(errores.isEmpty()){
            if(direccionabierta.compareTo("") != 0){
                String dir[] = direccionabierta.split("\\.");
                dir[dir.length-1] = "java";
                String path = "";
                for(int i = 0; i<dir.length; i++){
                    if(i == dir.length-1){
                        path += dir[i];
                    }else{
                        path += dir[i] + ".";
                    }
                }
                GuardarArchivoSalida(path);
            }else{
                GuardarComoArchivo(new FileNameExtensionFilter("JAVA", "java"));
            }
        }else{
            JOptionPane.showMessageDialog(this, "El archivo analizado tiene errores", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
            if(contenido.compareTo(this.jTextArea1.getText()) != 0){
                    if(GuardarArchivo()){
                    }else{
                        JOptionPane.showMessageDialog(this, "El archivo no se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                
            }else if(direccionabierta.compareTo("") == 0 && !this.jTextArea1.getText().isEmpty()){
                if(GuardarComoArchivo(new FileNameExtensionFilter("VISUAL BASIC", "vb"))){
            
                }else{
                    JOptionPane.showMessageDialog(this, "El archivo no se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private boolean GuardarArchivo(){
        File archivo = new File(direccionabierta);
        try {
            if(archivo.exists()){
                archivo.delete();
            }
            archivo = new File(direccionabierta);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(this.jTextArea1.getText());
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "El archivo no se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private void GuardarArchivoSalida(String path){
        File archivo = new File(path);
        try{
            if(archivo.exists()){
                archivo.delete();
            }
            archivo = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(this.jTextArea2.getText());
            bw.close();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(this, "El archivo no se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean GuardarComoArchivo(FileNameExtensionFilter filtro){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filtro);
        chooser.showSaveDialog(this);
        File archivo = chooser.getSelectedFile();
        if(archivo != null){
            try {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(this.jTextArea1.getText());
                bw.close();
                fw.close();
                JOptionPane.showMessageDialog(this, "Archivo guardado correctamente");
                return true;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "El archivo no se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
