package tema8_ejer5_producto;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tema8_ejer5_producto {

	private JFrame frame;
	private JTextField newcodigo;
	private JTextField newprecio;
	private JTextField newnombre;
	private JTextField newunidades;
	private JTextField newprecioactualizado;
	private JTextField newunidadesadquiridas;
	private JTextField newunidadesavender;

	Connection con;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tema8_ejer5_producto window = new Tema8_ejer5_producto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tema8_ejer5_producto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 895, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("COD");
		model.addColumn("Nombre");
		model.addColumn("Precio");
		model.addColumn("Uds");

		
		JTable table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(68, 49, 256, 157);
		
		frame.getContentPane().add(scrollPane);
		
		JLabel lbl1 = new JLabel("Nuevo producto");
		lbl1.setBounds(25, 241, 112, 15);
		frame.getContentPane().add(lbl1);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(50, 284, 70, 15);
		frame.getContentPane().add(lblCodigo);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(50, 332, 70, 15);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(226, 284, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblUnidades = new JLabel("Unidades:");
		lblUnidades.setBounds(226, 332, 86, 15);
		frame.getContentPane().add(lblUnidades);
		
		newcodigo = new JTextField();
		newcodigo.setBounds(116, 282, 79, 19);
		frame.getContentPane().add(newcodigo);
		newcodigo.setColumns(10);
		
		newprecio = new JTextField();
		newprecio.setColumns(10);
		newprecio.setBounds(116, 330, 79, 19);
		frame.getContentPane().add(newprecio);
		
		newnombre = new JTextField();
		newnombre.setColumns(10);
		newnombre.setBounds(318, 282, 79, 19);
		frame.getContentPane().add(newnombre);
		
		newunidades = new JTextField();
		newunidades.setColumns(10);
		newunidades.setBounds(318, 330, 79, 19);
		frame.getContentPane().add(newunidades);
		
		JLabel lbl2 = new JLabel("Borrar producto");
		lbl2.setBounds(25, 435, 129, 15);
		frame.getContentPane().add(lbl2);
		
		JLabel lblEligeProducto = new JLabel("Elige producto");
		lblEligeProducto.setBounds(53, 486, 117, 15);
		frame.getContentPane().add(lblEligeProducto);
		
		JComboBox comboBoxcodprod = new JComboBox();
		comboBoxcodprod.setBounds(166, 481, 87, 24);
		frame.getContentPane().add(comboBoxcodprod);
		
		JLabel lbl3 = new JLabel("Actualizar precio");
		lbl3.setBounds(488, 49, 129, 15);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("Incrementar stock");
		lbl4.setBounds(488, 216, 129, 15);
		frame.getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("Venta");
		lbl5.setBounds(488, 390, 129, 15);
		frame.getContentPane().add(lbl5);
		
		JLabel lblEligeProducto_1 = new JLabel("Elige producto");
		lblEligeProducto_1.setBounds(509, 90, 117, 15);
		frame.getContentPane().add(lblEligeProducto_1);
		
		JComboBox comboBoxcodprod_1 = new JComboBox();
		comboBoxcodprod_1.setBounds(624, 85, 87, 24);
		frame.getContentPane().add(comboBoxcodprod_1);
		
		JLabel lblNuevoPrecio = new JLabel("Nuevo precio");
		lblNuevoPrecio.setBounds(505, 129, 112, 15);
		frame.getContentPane().add(lblNuevoPrecio);
		
		newprecioactualizado = new JTextField();
		newprecioactualizado.setColumns(10);
		newprecioactualizado.setBounds(624, 127, 87, 19);
		frame.getContentPane().add(newprecioactualizado);
		
		JLabel lblEligeProducto_2 = new JLabel("Elige producto");
		lblEligeProducto_2.setBounds(509, 266, 117, 15);
		frame.getContentPane().add(lblEligeProducto_2);
		
		JComboBox comboBoxcodprod_2 = new JComboBox();
		comboBoxcodprod_2.setBounds(624, 261, 87, 24);
		frame.getContentPane().add(comboBoxcodprod_2);
		
		
		JLabel lblUnidadesAdquiridas = new JLabel("Unidades adquiridas");
		lblUnidadesAdquiridas.setBounds(509, 310, 147, 15);
		frame.getContentPane().add(lblUnidadesAdquiridas);
		
		newunidadesadquiridas = new JTextField();
		newunidadesadquiridas.setColumns(10);
		newunidadesadquiridas.setBounds(673, 308, 87, 19);
		frame.getContentPane().add(newunidadesadquiridas);
		
		JLabel lblProductoaVender = new JLabel("Producto a vender");
		lblProductoaVender.setBounds(509, 435, 147, 15);
		frame.getContentPane().add(lblProductoaVender);
		
		JComboBox comboBoxcodprod_3 = new JComboBox();
		comboBoxcodprod_3.setBounds(650, 430, 87, 24);
		frame.getContentPane().add(comboBoxcodprod_3);
		
		JLabel lblUnidadesAVender = new JLabel("Unidades a vender");
		lblUnidadesAVender.setBounds(509, 486, 147, 15);
		frame.getContentPane().add(lblUnidadesAVender);
		
		newunidadesavender = new JTextField();
		newunidadesavender.setColumns(10);
		newunidadesavender.setBounds(650, 484, 87, 19);
		frame.getContentPane().add(newunidadesavender);
		
		
		JLabel lbl6 = new JLabel("Ganancias (€):");
		lbl6.setForeground(new Color(38, 162, 105));
		lbl6.setBounds(333, 542, 104, 15);
		frame.getContentPane().add(lbl6);
		
		JLabel labelGanancias = new JLabel("0");
		labelGanancias.setForeground(new Color(38, 162, 105));
		labelGanancias.setBounds(450, 542, 70, 15);
		frame.getContentPane().add(labelGanancias);
		
		
		
		
		//boton mostrar
		JButton mostrar = new JButton("Mostrar");
		mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					con=ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM Producto");
					while (rs.next()) {
					 Object[] row = new Object[4];
					 row[0] = rs.getInt("cod");
					 row[1] = rs.getString("nombre");
					 row[2] = rs.getInt("precio");
					 row[3] = rs.getInt("unidades");
					 model.addRow(row);
					}
					
					stmt.close();
					 rs.close();
					 con.close();
					
				} catch (SQLException e) {
					
					System.err.println(e.getMessage());
					 e.getErrorCode();
					 e.printStackTrace();
				}	
				
				
			}
		});
		mostrar.setBounds(136, 12, 117, 25);
		frame.getContentPane().add(mostrar);
		
		
		
		
		//boton añadir new
		JButton añadir = new JButton("Añadir");
		añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		añadir.setBounds(136, 385, 117, 25);
		frame.getContentPane().add(añadir);

			
		
		
		//boton eliminar
		JButton eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		eliminar.setBounds(267, 481, 117, 25);
		frame.getContentPane().add(eliminar);
		
		
		
		
		//boton actualizar precio
		JButton actualizar = new JButton("Actualizar");
		actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		actualizar.setBounds(731, 85, 117, 25);
		frame.getContentPane().add(actualizar);
		
		
		
		
		
		//boton actualizar stock 
		JButton actualizar_1 = new JButton("Actualizar");
		actualizar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		actualizar_1.setBounds(731, 261, 117, 25);
		frame.getContentPane().add(actualizar_1);
		
		
		
		
		
		//boton actualizar ventas
		JButton actualizar_2 = new JButton("Actualizar");
		actualizar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		actualizar_2.setBounds(749, 452, 117, 25);
		frame.getContentPane().add(actualizar_2);
		
	}
}
