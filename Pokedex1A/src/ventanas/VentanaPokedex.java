package ventanas;

import conexion.conexionSQL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class VentanaPokedex extends javax.swing.JFrame {

    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();
    BufferedImage buffer1 =null;
    Image imagen1 = null;
    int contador = 0;
    
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    
    @Override
    public void paint(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 =(Graphics2D) imagenPokemon.getGraphics();
        
        g2.drawImage(buffer1, 0,0,imagenPokemon.getWidth(),imagenPokemon.getHeight(),null);
        
    }
    
    private void cargarpokemon(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbtodos.getModel();
        modeloTabla.setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] ancho={10,50,50,50,50};
        for(int i=0; i <tbtodos.getColumnCount(); i++){
            tbtodos.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
            
        }
        try{
         
            String SQL = "select name, species, color, habitat, base_experience\n" 
                    + "from test.pokemon\n"
                    + "where color=" + "'" + txtfiltroColor.getText() + "'";
            ps =con.prepareStatement(SQL);
            
           rs = ps.executeQuery();
           rsmd = rs.getMetaData();
           columnas = rsmd.getColumnCount();
           
           while(rs.next()){
               Object[] fila = new Object[columnas];
               for(int indice =0; indice<columnas; indice++){
                   fila[indice] = rs.getObject(indice + 1);
               }
               modeloTabla.addRow(fila);
           }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
    }
      private void filtrohabitat(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbtodos.getModel();
        modeloTabla.setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] ancho={10,50,50,50,50};
        for(int i=0; i <tbtodos.getColumnCount(); i++){
            tbtodos.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
            
        }
        try{
         
            String SQL = "select name, species, color, habitat, base_experience\n" 
                    + "from test.pokemon\n"
                    + "where habitat=" + "'" + txtfiltrohabitat.getText() + "'";
            ps =con.prepareStatement(SQL);
            
           rs = ps.executeQuery();
           rsmd = rs.getMetaData();
           columnas = rsmd.getColumnCount();
           
           while(rs.next()){
               Object[] fila = new Object[columnas];
               for(int indice =0; indice<columnas; indice++){
                   fila[indice] = rs.getObject(indice + 1);
               }
               modeloTabla.addRow(fila);
           }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
    }
     private void cargarTabla(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbdatos.getModel();
        modeloTabla.setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] ancho={10,50,50};
        for(int i=0; i <tbdatos.getColumnCount(); i++){
            tbdatos.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
            
        }
        try{
         
            String SQL = "SELECT * FROM tb_favorito";
            ps =con.prepareStatement(SQL);
            
           rs = ps.executeQuery();
           rsmd = rs.getMetaData();
           columnas = rsmd.getColumnCount();
           
           while(rs.next()){
               Object[] fila = new Object[columnas];
               for(int indice =0; indice<columnas; indice++){
                   fila[indice] = rs.getObject(indice + 1);
               }
               modeloTabla.addRow(fila);
           }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
    }
      private void dtpokemon(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbpokedex.getModel();
        modeloTabla.setRowCount(0);
       int id = Integer.valueOf(idpokemon.getText());
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] ancho={10,50,50,50,50};
        for(int i=0; i <tbpokedex.getColumnCount(); i++){
            tbpokedex.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
            
        }
      
        try{
         
            String SQL = "select name, species, color, habitat, base_experience\n"
                    + "from test.pokemon\n"
                    + "where id =" + idpokemon.getText();
            
            ps =con.prepareStatement(SQL);
            
           rs = ps.executeQuery();
           rsmd = rs.getMetaData();
           columnas = rsmd.getColumnCount();
            
           while(rs.next()){
               Object[] fila = new Object[columnas];
               for(int indice =0; indice<columnas; indice++){
                   fila[indice] = rs.getObject(indice + 1);
               }
               modeloTabla.addRow(fila);
           }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
    }
       private void filtroexpe(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbtodos.getModel();
        modeloTabla.setRowCount(0);
        
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] ancho={10,50,50,50,50};
        for(int i=0; i <tbtodos.getColumnCount(); i++){
            tbtodos.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
            
        }
        try{
         
            String SQL = "select name, species, color, habitat, base_experience\n" 
                    + "from test.pokemon\n"
                    + "where base_experience=" +txtfiltroexpe.getText() ;
            ps =con.prepareStatement(SQL);
            
           rs = ps.executeQuery();
           rsmd = rs.getMetaData();
           columnas = rsmd.getColumnCount();
           
           while(rs.next()){
               Object[] fila = new Object[columnas];
               for(int indice =0; indice<columnas; indice++){
                   fila[indice] = rs.getObject(indice + 1);
               }
               modeloTabla.addRow(fila);
           }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
    }
      
    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();
        cargarTabla();
        dtpokemon();
        cargarpokemon();
        filtrohabitat();
        filtroexpe();
        try {
            //imagen1 = ImageIO.read(getClass().getResource("/imagenes/back-white.png"));
            imagen1 =ImageIO.read(new File("D:\\Zero\\Escritorio\\UMG-4toSemestre\\PROGRAMACION II\\Clase 10\\datos\\imagenes\\black-white.png"));
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        buffer1 = (BufferedImage) imagenPokemon.createImage(
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        
        Graphics2D g2 = buffer1.createGraphics();
        
        dibujaElPokemonQueEstaEnLaPosicion(30);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String JDBC_URL="jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC"; 
            
            conexion = DriverManager.getConnection(JDBC_URL,"root","fabl");
            estado = conexion.createStatement();
  
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Hay error de clase no encontrada");
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
            System.out.println("Hay error de BD");
        }

    }

    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion){
        int fila = posicion / 31;
        int columna = posicion % 31;
        
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);
        
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight()); 
        
        
        g2.drawImage(imagen1,
                0,  //posicion X inicial dentro del jpanel 
                0,  // posicion Y inicial dentro del jpanel
                imagenPokemon.getWidth(), //ancho del jpanel
                imagenPokemon.getHeight(), //alto del jpanel
                columna*96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila*96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna*96 + 96, //posicion final X
                fila*96 + 96, //posicion final Y
                null  //si no lo pones no va
                );
        
        repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        imagenPokemon = new javax.swing.JPanel();
        nombrePokemon = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        btnagregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        idpokemon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbpokedex = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbtodos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtfiltroColor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtfiltrohabitat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtfiltroexpe = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        btnCorreo = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        btnAdjuntar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        izq.setText("<== Izquierda");
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });

        der.setText("derecha ==>");
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        nombrePokemon.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        nombrePokemon.setText("nombre");

        tbdatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "id_pokemon", "usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbdatos);

        btnagregar.setText("Agregar a favoritos");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Pokemon's Favoritos");

        idpokemon.setText("0");

        jLabel2.setText("Nombre ");

        jLabel3.setText("id del pokemon");

        tbpokedex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nombre", "especie", "color", "habitat", "experiencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbpokedex);

        tbtodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nombre", "especie", "color", "habitat", "experiencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbtodos);

        jLabel4.setText("Filtrar por color");

        txtfiltroColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfiltroColorActionPerformed(evt);
            }
        });

        jLabel5.setText("Filtrar por habitat");

        txtfiltrohabitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfiltrohabitatActionPerformed(evt);
            }
        });

        jLabel6.setText("Filtrar por experiencia");

        txtfiltroexpe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfiltroexpeActionPerformed(evt);
            }
        });

        btnReporte.setText("Generar Reporte en PDF");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnCorreo.setText("Enviar Correo");
        btnCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorreoActionPerformed(evt);
            }
        });

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        btnAdjuntar.setText("Adjuntar");
        btnAdjuntar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdjuntarActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(idpokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnagregar))
                                        .addGap(37, 37, 37)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(izq)
                                .addGap(37, 37, 37)
                                .addComponent(der))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nombrePokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(26, 26, 26))))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtfiltrohabitat, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(txtfiltroColor)
                    .addComponent(txtfiltroexpe))
                .addGap(36, 36, 36)
                .addComponent(btnReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCorreo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdjuntar))
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(nombrePokemon)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(izq)
                            .addComponent(der)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idpokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnagregar))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtfiltroColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporte)
                    .addComponent(btnCorreo)
                    .addComponent(btnAdjuntar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtfiltrohabitat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtfiltroexpe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
      
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        
        try {
            resultadoConsulta = estado.
                    executeQuery("select * from pokemon where id="+(contador + 1));
            
            if (resultadoConsulta.next()){
                nombrePokemon.setText(resultadoConsulta.getString(2));
                 idpokemon.setText(resultadoConsulta.getString(1));
                 
         dtpokemon();
            } else {
                nombrePokemon.setText("Este chucho no esta e el pokedex");
                 idpokemon.setText("sin resultado");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPokedex.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        contador++;
        if (contador >= 649){
            contador = 649;
        }

    }//GEN-LAST:event_derActionPerformed

    public void agregarUsuario(){
        
        String nombre =String.valueOf(txtnombre.getText());
        int pdex =Integer.valueOf(idpokemon.getText());
        String SQL = "insert into tb_favoritos (tb_pokemon,usuario) values(?,?)";
        
        try{
            PreparedStatement pst =con.prepareStatement(SQL);
            
            pst.setInt(1,pdex);
            pst.setString(2,nombre);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de registro "+e.getMessage());
        }
    }
    
    
    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
dibujaElPokemonQueEstaEnLaPosicion(contador);
        
        try {
            resultadoConsulta = estado.
                    executeQuery("select * from pokemon where id="+(contador+1));
            
            if (resultadoConsulta.next()){
                nombrePokemon.setText(resultadoConsulta.getString(2));
                idpokemon.setText(resultadoConsulta.getString(1));
                 dtpokemon();
            } else {
                nombrePokemon.setText("Este chucho no esta e el pokedex");
                idpokemon.setText("sin resultado");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPokedex.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        contador--;
        if (contador >= 649){
            contador = 649;
        }
   
//        //evento cuando el usr de click en izquierdo
//        contador--;
//        if(contador <=0){
//            contador=1;
//        }
//        dibujaElPokemonQueEstaEnLaPosicion(contador);
//        
    }//GEN-LAST:event_izqActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
       agregarUsuario();
       cargarTabla();
    }//GEN-LAST:event_btnagregarActionPerformed

    private void txtfiltroColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfiltroColorActionPerformed
            cargarpokemon();
    }//GEN-LAST:event_txtfiltroColorActionPerformed

    private void txtfiltrohabitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfiltrohabitatActionPerformed
        filtrohabitat();
    }//GEN-LAST:event_txtfiltrohabitatActionPerformed

    private void txtfiltroexpeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfiltroexpeActionPerformed
      filtroexpe();
    }//GEN-LAST:event_txtfiltroexpeActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        
        try {
           
            JasperReport reporte = null;
            
            String path = "D:\\Zero\\Escritorio\\UMG-4toSemestre\\PROGRAMACION II\\Clase 10\\Nuevo codigo\\CODIGO\\Pokedex1A\\src\\Reportes\\Filtros.jasper";
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            //Enviamos el reporte con reporte, no enviamos parametros asi que sera null y mandamos la conexion conn
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, con);
            
            //Vista del Reporte
            JasperViewer view = new JasperViewer (jprint, false);
            
            //Agregaremos un cierre para que cuando el usuario presione la x pueda cerrar el reporte y no se qude atorado
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            //Reporte Visible
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(VentanaPokedex.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " ERROR! EL REPORTE NO SE GENERO EN PDF :(");
        }
        
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorreoActionPerformed
        
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.email.com"); // host, nombre de la propiedad a asignar
            props.setProperty("mail.smtp.startlls.enable", "true"); // Indicamos que utilizaremos tlls
            props.setProperty("mail.smtp.port", "587"); // Puerto
            props.setProperty("mail.smtp.auth", "true"); // Autentifica al servidor de Gmail
            
            Session session = Session.getDefaultInstance(props);
            
            String correoRemitente = "frnacisol@gmail.com";
            String passwordRemitente = "fabl221ale";
            String corrreoReceptor = txtCorreo.getText();
            String asunto = "Mi primer correo";
            String mensaje = "Este es el contenido";
            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));
            
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(corrreoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje);
            
            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            
            JOptionPane.showMessageDialog(null, "Correo enviado");
            
        } catch (AddressException ex) {
            Logger.getLogger(VentanaPokedex.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " ERROR!");
        } catch (MessagingException ex) {
            Logger.getLogger(VentanaPokedex.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " ERROR!");
        }
        
        
        
        
    }//GEN-LAST:event_btnCorreoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnAdjuntarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarActionPerformed

        
    }//GEN-LAST:event_btnAdjuntarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdjuntar;
    private javax.swing.JButton btnCorreo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnagregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton der;
    private javax.swing.JTextField idpokemon;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel nombrePokemon;
    private javax.swing.JTable tbdatos;
    private javax.swing.JTable tbpokedex;
    private javax.swing.JTable tbtodos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtfiltroColor;
    private javax.swing.JTextField txtfiltroexpe;
    private javax.swing.JTextField txtfiltrohabitat;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

}
