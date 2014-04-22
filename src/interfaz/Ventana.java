package interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import mundo.AnalizadorLexico;
import mundo.Configuracion;


/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * 
 * @author Jorge Leonardo Aguirre Martinez
 * @author Luis Alberto Delgado Ortiz 
 *
 */
public class Ventana extends javax.swing.JFrame implements ActionListener{

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// Declaracion de los atributos

	private JScrollPane jScrollPane2;
	private JLabel jLabelCargar;
	private JPanel jPanelCargar;
	private JComboBox listaAutomatas;
	private JButton cargar;
	private JButton cargarReservadas;
	private JButton cargarCodigoFuente;
	private JTable tablaErrores;
	private JLabel jLabel2;
	private JScrollPane jScrollPane4;
	private JLabel imagen;
	private JScrollPane jScrollPane3;
	private JTextArea texto;
	private JScrollPane jScrollPane1;
	private JButton clean;
	private JLabel jLabel6;
	private JLabel jLabel1;
	private JTable TablaDeTokens;
	private JButton Analizar;
	private AnalizadorLexico analizadorLexico;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Ventana inst = new Ventana();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	/**
	 * constructor de Ventana 
	 */
	public Ventana() {
		super();
		analizadorLexico = new AnalizadorLexico();
		initGUI();
	}

	/**
	 * inicializacion de los atributos de GUI 
	 */
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle(Configuracion.tituloVentana);
			{
				Analizar = new JButton();
				getContentPane().add(Analizar);
				Analizar.setText(Configuracion.Analizar);
				Analizar.setBounds(244, 194, 92, 26);
				Analizar.addActionListener(this);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText(Configuracion.codigo);
				jLabel1.setBounds(35, 6, 325, 24);
				jLabel1.setFont(new java.awt.Font("SansSerif",1,12));
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(29, 31, 403, 151);
				{
					texto = new JTextArea();
					jScrollPane1.setViewportView(texto);

				}
			}

			{
				jScrollPane2 = new JScrollPane();
				getContentPane().add(jScrollPane2);
				jScrollPane2.setBounds(444, 35, 413, 139);


				{

					TableModel modelo =	new DefaultTableModel(new String[][] {},	new String[] {});


					TablaDeTokens= new JTable();
					jScrollPane2.setViewportView(TablaDeTokens);
					TablaDeTokens.setModel(modelo);
				}

			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText(Configuracion.tablaTokens);
				jLabel6.setBounds(450, 10, 247, 19);
				jLabel6.setFont(new java.awt.Font("SansSerif",1,12));
			}
			{
				clean = new JButton();
				getContentPane().add(clean);
				clean.setText(Configuracion.limpiar);
				clean.setBounds(349, 193, 75, 28);
				clean.addActionListener(this);
			}
			{
				jScrollPane3 = new JScrollPane();
				getContentPane().add(jScrollPane3);
				jScrollPane3.setBounds(29, 343, 810, 313);
				{
					imagen = new JLabel();
					jScrollPane3.setViewportView(imagen);
				}
			}
			{
				jScrollPane4 = new JScrollPane();
				getContentPane().add(jScrollPane4);
				jScrollPane4.setBounds(444, 200, 413, 126);
				{
					TableModel modeloE = new DefaultTableModel(	new String[][] {},new String[] {});
					tablaErrores = new JTable();
					jScrollPane4.setViewportView(tablaErrores);
					tablaErrores.setModel(modeloE);
					tablaErrores.setForeground(new java.awt.Color(255,0,0));
				}
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText(Configuracion.tablaErrores);
				jLabel2.setBounds(450, 178, 153, 16);
				jLabel2.setFont(new java.awt.Font("SansSerif",1,12));
			}
			{
				cargar = new JButton();
				getContentPane().add(cargar);
				cargar.setText(Configuracion.cargarImagen);
				cargar.setBounds(237, 298, 186, 28);
				cargar.addActionListener(this);
			}
			{
				ComboBoxModel listaAutomatasModel = 
						new DefaultComboBoxModel(
								new String[] {Configuracion.Entero,Configuracion.Real,Configuracion.IdClase,Configuracion.IdClase,Configuracion.IdVariable,Configuracion.Break,Configuracion.Clase,"Importar",Configuracion.Paquete,Configuracion.Private,Configuracion.Public,
										Configuracion.ReservadaEntero,Configuracion.ReservadaFor,Configuracion.ReservadaReal,Configuracion.ReservadaReturn,Configuracion.ReservadaWhile,
										Configuracion.OperadorDivision,Configuracion.OperadorMultiplicacion,Configuracion.OperadorResta,Configuracion.OperadorSuma,Configuracion.OperadorRelacionalII,
										Configuracion.OperadorRelacionalMayor,Configuracion.OperadorRelacionalMayorI,Configuracion.OperadorRelacionalMenor,Configuracion.OperadorRelacionalMenorI,
										Configuracion.OperadorLogicoO,Configuracion.OperadorLogicoY,Configuracion.OperadorAsignacion,Configuracion.AperturaParentesis,Configuracion.CierreParentesis,
										Configuracion.AbrirLlaves,Configuracion.CerrarLLaves,Configuracion.FinSentencia,Configuracion.Comentario,Configuracion.Cadena});
				listaAutomatas = new JComboBox();
				getContentPane().add(listaAutomatas);
				listaAutomatas.setModel(listaAutomatasModel);
				listaAutomatas.setBounds(35, 300, 170, 26);
			}

			{
				jPanelCargar = new JPanel();
				getContentPane().add(jPanelCargar);
				jPanelCargar.setBounds(41, 216, 151, 78);
				jPanelCargar.setBorder(new LineBorder(new java.awt.Color(192,192,192), 1, false));
				jPanelCargar.setLayout(null);
				jPanelCargar.setOpaque(false);
				{
					cargarCodigoFuente = new JButton();
					jPanelCargar.add(cargarCodigoFuente);
					cargarCodigoFuente.setText(Configuracion.cargarCodigo);
					cargarCodigoFuente.setBounds(7, 7, 136, 28);
					cargarCodigoFuente.addActionListener(this);
				}
				{
					cargarReservadas = new JButton();
					jPanelCargar.add(cargarReservadas);
					cargarReservadas.setText(Configuracion.cargarReservadas);
					cargarReservadas.setBounds(7, 40, 136, 28);
					cargarReservadas.addActionListener(this);
				}
			}
			{
				jLabelCargar = new JLabel();
				getContentPane().add(jLabelCargar);
				jLabelCargar.setText(Configuracion.cargar);
				jLabelCargar.setBounds(41, 194, 44, 16);
			}

			pack();
			setSize(900, 700);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	/**
	 * metodo para capturar los eventos al precionar los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub

		// Entra al if si se preciona el boton analizar
		if(e.getSource()== Analizar)
		{


			analizadorLexico.analizar(texto.getText());


			TableModel modelo =	new DefaultTableModel(analizadorLexico.mostrarTokens(),	new String[] { Configuracion.lexema,Configuracion.tipo ,Configuracion.fila,Configuracion.columna });
			TablaDeTokens.setModel(modelo);

			TableModel modeloE =	new DefaultTableModel(analizadorLexico.mostrarTokensError(),	new String[] { Configuracion.lexema,Configuracion.tipo ,Configuracion.fila,Configuracion.columna });
			tablaErrores.setModel(modeloE);


		}

		//entra al if si se preciona el boton clean
		if(e.getSource()==clean)
		{
			texto.setText("");
		}

		//entra al if si se preciona el boton cargar, permitiendo asi cargar la imagen del automata seleccionado
		if(e.getSource()==cargar)
		{
			if(listaAutomatas.getSelectedIndex()==0)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgEntero)));
			}
			if(listaAutomatas.getSelectedIndex()==1)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgReal)));
			}
			if(listaAutomatas.getSelectedIndex()==2)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgIdClase)));
			}
			if(listaAutomatas.getSelectedIndex()==3)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgIdMetodo)));
			}
			if(listaAutomatas.getSelectedIndex()==4)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgIdVariable)));
			}
			if(listaAutomatas.getSelectedIndex()==5)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgBreak)));
			}
			if(listaAutomatas.getSelectedIndex()==6)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgClase)));
			}
			if(listaAutomatas.getSelectedIndex()==7)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgImportar)));
			}
			if(listaAutomatas.getSelectedIndex()==8)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgPaquete)));
			}
			if(listaAutomatas.getSelectedIndex()==9)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgPrivate)));
			}
			if(listaAutomatas.getSelectedIndex()==10)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgPublic)));
			}
			if(listaAutomatas.getSelectedIndex()==11)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgResEntero)));
			}
			if(listaAutomatas.getSelectedIndex()==12)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgResFor)));
			}
			if(listaAutomatas.getSelectedIndex()==13)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgResReal)));
			}
			if(listaAutomatas.getSelectedIndex()==14)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgResReturn)));
			}
			if(listaAutomatas.getSelectedIndex()==15)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgResWhile)));
			}
			if(listaAutomatas.getSelectedIndex()==16)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgDivision)));
			}
			if(listaAutomatas.getSelectedIndex()==17)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgMultiplicacion)));
			}
			if(listaAutomatas.getSelectedIndex()==18)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgResta)));
			}
			if(listaAutomatas.getSelectedIndex()==19)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgSuma)));
			}
			if(listaAutomatas.getSelectedIndex()==20)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgIgualIgual)));
			}
			if(listaAutomatas.getSelectedIndex()==21)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgMayor)));
			}
			if(listaAutomatas.getSelectedIndex()==22)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgMayorIgual)));
			}
			if(listaAutomatas.getSelectedIndex()==23)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgMenor)));
			}
			if(listaAutomatas.getSelectedIndex()==24)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgMenorIgual)));
			}
			if(listaAutomatas.getSelectedIndex()==25)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgO)));
			}
			if(listaAutomatas.getSelectedIndex()==26)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgY)));
			}
			if(listaAutomatas.getSelectedIndex()==27)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgAsignacion)));
			}
			if(listaAutomatas.getSelectedIndex()==28)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgAbrirParentesis)));
			}
			if(listaAutomatas.getSelectedIndex()==29)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgCerrarParentesis)));
			}
			if(listaAutomatas.getSelectedIndex()==30)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgAbrirLlaves)));
			}
			if(listaAutomatas.getSelectedIndex()==31)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgCerrarLlaves)));
			}
			if(listaAutomatas.getSelectedIndex()==32)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgTerminador)));
			}
			if(listaAutomatas.getSelectedIndex()==33)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgComentario)));
			}
			if(listaAutomatas.getSelectedIndex()==34)
			{
				imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Configuracion.imgCadena)));
			}
		}

		// Entra al if si se presiona el boton cargar reservadas
		if(e.getSource()==cargarReservadas)
		{
			JFileChooser chooser=new  JFileChooser();

			int res=chooser.showOpenDialog(null);
			if(res==chooser.APPROVE_OPTION)
			{
				File texto=chooser.getSelectedFile();
				String ruta=texto.getAbsolutePath();


				analizadorLexico.cargarReservadas(ruta);				

			}
		}

		// Entra al if si se preciona el boton cargar codigo
		if(e.getSource()==cargarCodigoFuente)
		{
			JFileChooser chooser=new  JFileChooser();

			int res=chooser.showOpenDialog(null);
			if(res==chooser.APPROVE_OPTION)
			{
				File texto=chooser.getSelectedFile();
				String ruta=texto.getAbsolutePath();

				try {
					String codigo=analizadorLexico.cargarCodigo(ruta);
					this.texto.setText(codigo);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

	}

}
