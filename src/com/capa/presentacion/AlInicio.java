package com.capa.presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.capa.datos.TCabecera;
import com.capa.negocios.ComponenteCabecera;
import com.capa.negocios.ComponenteFichaA;
import com.capa.negocios.Query;
import com.capa.negocios.Reporte;
import com.capa.negocios.ServicioCabecera;
import com.capa.negocios.ServicioFichaA;
import com.capa.util.Utilitarios;

public class AlInicio extends JFrame {

	private static final long serialVersionUID = -2063817460198744409L;
	private JPanel contentPane;
	private JTextField txtBuscar;
	private TCabecera tCabecera;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlInicio frame = new AlInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AlInicio() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 459);
		setTitle("DIRECCIÓN NACIONAL DE INFRAESTRUCTURA FÍSICA");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		ServicioCabecera comProyecto = new ComponenteCabecera();

		JPanel pnlBotones = new JPanel();
		pnlBotones.setBounds(105, 71, 288, 309);
		contentPane.add(pnlBotones);
		pnlBotones.setLayout(new GridLayout(6, 0, 0, 5));

		AlInicio alInicio = this;

		JButton btnDatosGenerales = new JButton("   1.- Datos Generales UEPTM");
		btnDatosGenerales.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatosGenerales.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdatosReferenciales adatosReferenciales = new AdatosReferenciales(alInicio);
				adatosReferenciales.setVisible(true);
			}
		});
		pnlBotones.add(btnDatosGenerales);

		JButton btnAvanceGeneral = new JButton("   2.- Avance General (A)");
		btnAvanceGeneral.setHorizontalAlignment(SwingConstants.LEFT);
		btnAvanceGeneral.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ServicioFichaA servFichaA = new ComponenteFichaA();
				servFichaA.eliminar();
				FichaATemplate fichaA = new FichaATemplate();
				fichaA.generarDatos();

				HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("serial_cabecera", tCabecera.getCSerial());

				Reporte reporte = new Reporte("Reporte Evaluación", 280, 10, 850, 750);
				InputStream path = AlInicio.class.getResourceAsStream("/com/capa/templates/Evaluacion.jasper");
				reporte.cargarReporte(path, parametros, Query.getMysql().getConexion());
				reporte.setVisible(true);
			}
		});
		pnlBotones.add(btnAvanceGeneral);

		JButton btnRevisionCaract = new JButton("   3.- Revisión Características Técnicas (B)");
		btnRevisionCaract.setHorizontalAlignment(SwingConstants.LEFT);
		pnlBotones.add(btnRevisionCaract);
		btnRevisionCaract.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tCabecera == null) {
					JOptionPane.showMessageDialog(null, "ERROR: Proyecto no ingresado", "Mensaje de Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				new FichaB().setVisible(true);
				dispose();
			}
		});

		JButton btnCuantifComp = new JButton("   4.- Cuantificación Componentes (C)");
		btnCuantifComp.setHorizontalAlignment(SwingConstants.LEFT);
		btnCuantifComp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tCabecera == null) {
					JOptionPane.showMessageDialog(null, "ERROR: Proyecto no ingresado", "Mensaje de Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				Utilitarios.setNombreFicha("Menú C - Ficha - ");
				Utilitarios.setFichaC1(false);
				new Menu().setVisible(true);
				dispose();
			}
		});
		pnlBotones.add(btnCuantifComp);

		JButton btnReporteAct = new JButton("   5.- Reporte de Actividades (C.1)");
		btnReporteAct.setHorizontalAlignment(SwingConstants.LEFT);
		btnReporteAct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tCabecera == null) {
					JOptionPane.showMessageDialog(null, "ERROR: Proyecto no ingresado", "Mensaje de Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				Utilitarios.setNombreFicha("Menú C.1 - Ficha - ");
				Utilitarios.setFichaC1(true);
				new Menu().setVisible(true);
				dispose();
			}
		});
		pnlBotones.add(btnReporteAct);

		JButton btnReporteInsp = new JButton("   6.- Reporte de Inspección (D)");
		btnReporteInsp.setHorizontalAlignment(SwingConstants.LEFT);
		btnReporteInsp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tCabecera == null) {
					JOptionPane.showMessageDialog(null, "ERROR: Proyecto no ingresado", "Mensaje de Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				FichaD fichaD = new FichaD();
				fichaD.setVisible(true);
				dispose();
			}
		});
		pnlBotones.add(btnReporteInsp);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(105, 27, 199, 21);
		txtBuscar.setText("Buscar proyecto");
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.setForeground(Color.LIGHT_GRAY);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		txtBuscar.addKeyListener(new KeyAdapter() {
			public void keyPressed(final KeyEvent e) {
				int key = e.getKeyCode();
				if (txtBuscar.getText().equals("Buscar proyecto")) {
					txtBuscar.setText("");
					txtBuscar.setForeground(Color.BLACK);
				}

				if (key == KeyEvent.VK_ENTER) {
					tCabecera = comProyecto.buscarProyecto(txtBuscar.getText());
					if (!(tCabecera.getCNombreProyecto() == null)) {
						Utilitarios.settCabecera(tCabecera);
						JOptionPane.showMessageDialog(null, "Proyecto cargado", "Proyecto",
								JOptionPane.INFORMATION_MESSAGE);
						txtBuscar.setEditable(false);
					} else {
						tCabecera = null;
						JOptionPane.showMessageDialog(null, "No existe el proyecto", "ERROR",
								JOptionPane.ERROR_MESSAGE);
						txtBuscar.setEnabled(true);
					}

				}
			}
		});

		JButton btnLimpiar = new JButton("Reset");
		btnLimpiar.setBounds(322, 27, 70, 20);
		btnLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaults();
			}

		});
		contentPane.add(btnLimpiar);

		JButton btnEnviarCorreo = new JButton("ENVIAR CORREO");
		btnEnviarCorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// código para enviar correo
			}
		});
		btnEnviarCorreo.setBounds(128, 391, 144, 23);
		contentPane.add(btnEnviarCorreo);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setBounds(282, 391, 96, 23);
		contentPane.add(btnSalir);

		if (Utilitarios.gettCabecera() != null) {
			txtBuscar.setForeground(Color.BLACK);
			txtBuscar.setEditable(false);
			txtBuscar.setText(Utilitarios.gettCabecera().getCNombreProyecto());
			tCabecera = Utilitarios.gettCabecera();
		}
	}

	private void setDefaults() {
		this.tCabecera = null;
		this.txtBuscar.setText("");
		this.txtBuscar.setEditable(true);
		this.txtBuscar.requestFocus();
	}

	public TCabecera gettCabecera() {
		return tCabecera;
	}

	public void settCabecera(TCabecera tCabecera) {
		txtBuscar.setText(tCabecera.getCNombreProyecto());
		txtBuscar.setEnabled(false);
		this.tCabecera = tCabecera;
	}
}
