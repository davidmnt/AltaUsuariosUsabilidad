import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class formulario {

    private JButton enviarButton;
    private JLabel Pass;
    private JPanel panelPrin;
    private JTextField textNombre;
    private JTextField id;
    private JTextField textMail;
    private JLabel user;
    private JLabel mail;
    private JLabel comprobacion;
    private JPasswordField textPass;
    private JLabel dni;
    private JPanel panelTabla;
    private JTextField textDni;
    private JTable tablaUsuarios;
    private JButton botonEnviar;
    private JButton BotonEliminar;
    private JButton botonVerUser;
    private JButton modificarButton;
    private JTextField textApellido;
    private JScrollPane JS;
    private JLabel titulo;
    static int idDatos = 0;

    public formulario() throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("nombre");
        modelo.addColumn("apellidos");
        modelo.addColumn("dni");
        modelo.addColumn("email");
        modelo.addColumn("contraseña");

        tablaUsuarios.setModel(modelo);


        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textNombre.getText();
                String apell = textApellido.getText();
                String nif = textDni.getText();
                String mail = textMail.getText();
                String pass = String.valueOf(textPass.getPassword());

                if(!name.isEmpty() && !apell.isEmpty() && !mail.isEmpty() && nif.isEmpty() && !pass.isEmpty()){

                    String[] obj = {String.valueOf(idDatos),name, apell,"",mail,"True"};
                    modelo.addRow(obj);
                    idDatos++;
                    textNombre.setText("");
                    textApellido.setText("");
                    textDni.setText("");
                    textMail.setText("");
                    textPass.setText("");

                } else if(!name.isEmpty() && !apell.isEmpty() && !mail.isEmpty() && !nif.isEmpty() && pass.isEmpty()){
                    String[] obj = {String.valueOf(idDatos),name, apell,nif,mail,"False"};
                    modelo.addRow(obj);
                    idDatos++;
                    textNombre.setText("");
                    textApellido.setText("");
                    textDni.setText("");
                    textMail.setText("");
                    textPass.setText("");

                }else if(!name.isEmpty() && !apell.isEmpty() && !mail.isEmpty() && !nif.isEmpty() && !pass.isEmpty()){
                    String[] obj = {String.valueOf(idDatos),name, apell,nif,mail,"True"};
                    modelo.addRow(obj);
                    idDatos++;
                    textNombre.setText("");
                    textApellido.setText("");
                    textDni.setText("");
                    textMail.setText("");
                    textPass.setText("");

                }else if(!name.isEmpty() && !apell.isEmpty() && !mail.isEmpty() && nif.isEmpty() && pass.isEmpty()) {
                    String[] obj = {String.valueOf(idDatos), name, apell, " ", mail, "False"};
                    modelo.addRow(obj);
                    idDatos++;
                    textNombre.setText("");
                    textApellido.setText("");
                    textDni.setText("");
                    textMail.setText("");
                    textPass.setText("");
                }else {
                    JOptionPane.showMessageDialog( null,"Error al introducir variables en la tabla, por favor introduce datos");
                }



            }
        });

        botonVerUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = tablaUsuarios.getSelectedRow();

                String nombre = tablaUsuarios.getValueAt(id,1).toString();
                String apellido = tablaUsuarios.getValueAt(id,2).toString();
                String dni = tablaUsuarios.getValueAt(id,3).toString();
                String mail = tablaUsuarios.getValueAt(id,4).toString();

                System.out.println(nombre);

;

                JFrame frameUser = new JFrame();
                frameUser.setBounds(0,0,350,400);
                frameUser.setVisible(true);
                frameUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel panelPerfil = new JPanel();
                panelPerfil.setLayout(new GridBagLayout());

                ImageIcon icono1 = new ImageIcon("src/imagenes/img1.jpg");
                Image img = icono1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                icono1 = new ImageIcon(img);
                JLabel labelImg = new JLabel(icono1);


                panelPerfil.add(labelImg,
                        new GridBagConstraints(
                                0,
                                0,
                                1,
                                1,
                                2.0,
                                1.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.HORIZONTAL,
                                new Insets(0, 60, 0, 0),
                                0,
                                0
                        ));




                JLabel LabelNombre = new JLabel("Nombre");
                panelPerfil.add(LabelNombre,
                        new GridBagConstraints(
                        0,
                        1,
                        1,
                        1,
                        2.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(0, 40, 0, 0),
                        0,
                        0
                ));

                JLabel NombreTabla = new JLabel();
                panelPerfil.add(NombreTabla,
                        new GridBagConstraints(
                                1,
                                1,
                                1,
                                1,
                                2.0,
                                1.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.HORIZONTAL,
                                new Insets(0, 0, 0, 0),
                                0,
                                0
                        ));

                NombreTabla.setText(nombre);

                JLabel LabelApellido = new JLabel("Apellido");
                panelPerfil.add(LabelApellido,
                        new GridBagConstraints(
                                0,
                                2,
                                1,
                                1,
                                2.0,
                                1.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.HORIZONTAL,
                                new Insets(0, 40, 0, 0),
                                0,
                                0
                        ));

                JLabel ApellidoTabla = new JLabel();
                panelPerfil.add(ApellidoTabla,
                        new GridBagConstraints(
                                1,
                                2,
                                1,
                                1,
                                2.0,
                                1.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.HORIZONTAL,
                                new Insets(0, 0, 0, 0),
                                0,
                                0
                        ));

                ApellidoTabla.setText(apellido);



                JLabel LabelDni = new JLabel("DNI");
                panelPerfil.add(LabelDni,
                        new GridBagConstraints(
                                0,
                                3,
                                1,
                                1,
                                2.0,
                                1.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.HORIZONTAL,
                                new Insets(0, 40, 0, 0),
                                0,
                                0
                        ));

                JLabel DNITabla = new JLabel();
                panelPerfil.add(DNITabla,
                        new GridBagConstraints(
                                1,
                                3,
                                1,
                                1,
                                2.0,
                                1.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.HORIZONTAL,
                                new Insets(0, 0, 0, 0),
                                0,
                                0
                        ));

                DNITabla.setText(dni);

                JLabel LabelMail = new JLabel("MAIL");
                panelPerfil.add(LabelMail,
                        new GridBagConstraints(
                                0,
                                4,
                                1,
                                1,
                                2.0,
                                1.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.HORIZONTAL,
                                new Insets(0, 40, 0, 0),
                                0,
                                0
                        ));

                JLabel mailTabla = new JLabel();
                panelPerfil.add(mailTabla,
                        new GridBagConstraints(
                                1,
                                4,
                                1,
                                1,
                                2.0,
                                1.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.HORIZONTAL,
                                new Insets(0, 0, 0, 0),
                                0,
                                0
                        ));

                mailTabla.setText(mail);

                frameUser.add(panelPerfil);



            }
        });

        BotonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idBorrar = tablaUsuarios.getSelectedRow();

                try {
                    modelo.removeRow(idBorrar);
                }catch (ArrayIndexOutOfBoundsException exce) {
                    JOptionPane.showMessageDialog( null,"Seleciona una persona para eliminar");
                }


            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int idMod = tablaUsuarios.getSelectedRow();
                try {

                    String nombreCambiar = textNombre.getText();
                    String apellidoCambiar = textApellido.getText();
                    String dniCambiar = textDni.getText();
                    String mailCambiar = textMail.getText();
                    String passCambiar = textPass.toString();


                    String nombreIntroducido = (String) tablaUsuarios.getValueAt(idMod,1);
                    String apellidoIntroducido = (String) tablaUsuarios.getValueAt(idMod,2);
                    String dniIntroducido = (String) tablaUsuarios.getValueAt(idMod,3);
                    String mailIntroducido = (String) tablaUsuarios.getValueAt(idMod,4);
                    String passIntroducido = (String) tablaUsuarios.getValueAt(idMod,5);


                    for(int i=0;i<tablaUsuarios.getRowCount();i++) {
                        if(!nombreCambiar.isEmpty()) {
                            if (!nombreCambiar.equals(nombreIntroducido)) {
                                tablaUsuarios.setValueAt(nombreCambiar, idMod, 1);
                            }
                        }
                        if(!apellidoCambiar.isEmpty()) {
                            if (!apellidoCambiar.equals(apellidoIntroducido)) {
                                tablaUsuarios.setValueAt(apellidoCambiar, idMod, 2);
                            }
                        }
                        if(!dniCambiar.isEmpty()) {

                            if (!dniCambiar.equals(dniIntroducido)) {
                                tablaUsuarios.setValueAt(dniCambiar, idMod, 3);
                            }
                        }if(!mailCambiar.isEmpty()) {


                            if (!mailCambiar.equals(mailIntroducido)) {
                                tablaUsuarios.setValueAt(mailCambiar, idMod, 4);
                            }
                        }
                        if(!passCambiar.isEmpty()) {

                            if (!passIntroducido.equals("False")) {
                                tablaUsuarios.setValueAt("True", idMod, 5);
                            }
                        }

                    }

                }catch (ArrayIndexOutOfBoundsException exce) {
                    JOptionPane.showMessageDialog( null,"Seleciona una persona para eliminar");
                }

            }
        });

    }

    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("formulario");
        frame.setContentPane(new formulario().panelPrin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,550,550);
        frame.setVisible(true);



    }




}

