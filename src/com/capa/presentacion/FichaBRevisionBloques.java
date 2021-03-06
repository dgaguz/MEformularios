package com.capa.presentacion;

import static com.capa.util.Utilitarios.*;
import static com.capa.util.Validaciones.validarInfo;
import static com.capa.util.Constantes.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.capa.datos.TFicha;
import com.capa.datos.TGrupo;
import com.capa.datos.TInformacionObligatoria;
import com.capa.datos.TdetalleFicha;
import com.capa.negocios.ComponenteFicha;
import com.capa.negocios.ComponenteInfoObligatoria;
import com.capa.negocios.Query;
import com.capa.negocios.Reporte;
import com.capa.negocios.ServicioFicha;
import com.capa.negocios.ServicioInfoObligatoria;
import com.capa.util.Utilitarios;

public class FichaBRevisionBloques extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -464231132711014311L;
	private JPanel contentPane;
	private JTextField txtObs0;
	private JTextField txtObs3;
	private JTextField txtObs5;
	private JTextField txtObs6;
	private JTextField txtObs4;
	private JTextField txtObs1;
	private JTextField txtObs2;
	private JTextField txtObs7;
	private JTextField txtObs8;
	private JTextField txtObs9;

	private TFicha ficha;
	private String fotoInfoObl;

	private TInformacionObligatoria infor;
	private ServicioFicha servFicha;
	private JRadioButton rdBtn00;
	private JRadioButton rdBtn01;
	private JRadioButton rdBtn10;
	private JRadioButton rdBtn11;
	private JRadioButton rdBtn20;
	private JRadioButton rdBtn21;
	private JRadioButton rdBtn30;
	private JRadioButton rdBtn31;
	private JRadioButton rdBtn40;
	private JRadioButton rdBtn41;
	private JRadioButton rdBtn50;
	private JRadioButton rdBtn51;
	private JRadioButton rdBtn60;
	private JRadioButton rdBtn61;
	private JRadioButton rdBtn70;
	private JRadioButton rdBtn71;
	private JRadioButton rdBtn80;
	private JRadioButton rdBtn81;
	private JRadioButton rdBtn90;
	private JRadioButton rdBtn91;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// FichaBRevisionBloques frame = new FichaBRevisionBloques();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public FichaBRevisionBloques(TFicha tFicha) {
		this.ficha = tFicha;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1318, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		servFicha = new ComponenteFicha();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 125, 1286, 484);
		contentPane.add(tabbedPane);

		JPcabecera cabecera = new JPcabecera();
		contentPane.add(cabecera.getCabecera());
		Utilitarios.llenarCabecera(cabecera);

		JPanel pnlPestaña1 = new JPanel();
		tabbedPane.addTab("1.- Ficha Revisi\u00F3n Bloques", null, pnlPestaña1, null);
		pnlPestaña1.setLayout(null);

		JPanel pnlDimensiones = new JPanel();
		pnlDimensiones.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dimensiones",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDimensiones.setBounds(0, 11, 249, 63);
		pnlPestaña1.add(pnlDimensiones);
		pnlDimensiones.setLayout(null);

		JLabel lblDCaracteristicas = new JLabel(
				"<html><body>Largo del aula: 9,00 m<br>Ancho del aula: 6,00 m<br>Altura del aula: "
						+ "M\u00EDnima: 2,70 m, Máxima: 3,00 m</body></html>");
		lblDCaracteristicas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDCaracteristicas.setBounds(10, 13, 235, 48);
		pnlDimensiones.add(lblDCaracteristicas);

		JPanel pnlDObsRef = new JPanel();
		pnlDObsRef.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDObsRef.setBounds(249, 19, 177, 47);
		pnlPestaña1.add(pnlDObsRef);
		pnlDObsRef.setLayout(null);

		JLabel lblDObsRef = new JLabel("Observaci\u00F3n/Referencia");
		lblDObsRef.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDObsRef.setBounds(50, 0, 123, 14);
		pnlDObsRef.add(lblDObsRef);

		rdBtn00 = new JRadioButton("");
		rdBtn00.setBounds(2, 16, 21, 23);
		pnlDObsRef.add(rdBtn00);

		rdBtn01 = new JRadioButton("");
		rdBtn01.setBounds(23, 16, 21, 23);
		pnlDObsRef.add(rdBtn01);

		ButtonGroup grBtnD = new ButtonGroup();
		grBtnD.add(rdBtn00);
		grBtnD.add(rdBtn01);

		JLabel lblDSi = new JLabel("SI");
		lblDSi.setBounds(6, 0, 21, 14);
		pnlDObsRef.add(lblDSi);

		JLabel lblDNo = new JLabel("NO");
		lblDNo.setBounds(25, 0, 21, 14);
		pnlDObsRef.add(lblDNo);

		txtObs0 = new JTextField();
		txtObs0.setBounds(50, 16, 123, 20);
		pnlDObsRef.add(txtObs0);
		txtObs0.setColumns(10);

		JPanel pnlBasesPrefabricadas = new JPanel();
		pnlBasesPrefabricadas.setLayout(null);
		pnlBasesPrefabricadas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Bases Prefabricadas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlBasesPrefabricadas.setBounds(0, 77, 249, 74);
		pnlPestaña1.add(pnlBasesPrefabricadas);

		JLabel lblBPCaracteristicas = new JLabel(
				"<html><body>Material: Hormig\u00F3n premezclado con resistencia m\u00EDnima de 210 kg/cm2<br>Cantidad:   "
						+ "De acuerdo a la referencia en el Plano No. E1</body></html>");
		lblBPCaracteristicas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBPCaracteristicas.setBounds(10, 13, 235, 56);
		pnlBasesPrefabricadas.add(lblBPCaracteristicas);

		JPanel pnlBPObsRef = new JPanel();
		pnlBPObsRef.setLayout(null);
		pnlBPObsRef.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlBPObsRef.setBounds(249, 82, 177, 47);
		pnlPestaña1.add(pnlBPObsRef);

		JLabel lblBPObsRef = new JLabel("Observaci\u00F3n/Referencia");
		lblBPObsRef.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblBPObsRef.setBounds(50, 0, 123, 14);
		pnlBPObsRef.add(lblBPObsRef);

		rdBtn10 = new JRadioButton("");
		rdBtn10.setBounds(2, 16, 21, 23);
		pnlBPObsRef.add(rdBtn10);

		rdBtn11 = new JRadioButton("");
		rdBtn11.setBounds(23, 16, 21, 23);
		pnlBPObsRef.add(rdBtn11);

		ButtonGroup grBtnBP = new ButtonGroup();
		grBtnBP.add(rdBtn10);
		grBtnBP.add(rdBtn11);

		JLabel lblBPSi = new JLabel("SI");
		lblBPSi.setBounds(6, 0, 21, 14);
		pnlBPObsRef.add(lblBPSi);

		JLabel lblBPNo = new JLabel("NO");
		lblBPNo.setBounds(25, 0, 21, 14);
		pnlBPObsRef.add(lblBPNo);

		txtObs1 = new JTextField();
		txtObs1.setColumns(10);
		txtObs1.setBounds(50, 16, 123, 20);
		pnlBPObsRef.add(txtObs1);

		JPanel pnlEstrMetalica = new JPanel();
		pnlEstrMetalica.setLayout(null);
		pnlEstrMetalica.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Estructura Met\u00E1lica \"Steel Framing\"", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		pnlEstrMetalica.setBounds(0, 156, 249, 299);
		pnlPestaña1.add(pnlEstrMetalica);

		JLabel lblEMCaracteristicas = new JLabel(
				"<html><body>Material: La estructura met\u00E1lica Steel Framing es el sistema prefabricado de armado para la cubierta "
						+ "y contrapiso, conformado por perfiles metñlicos galvanizados, laminados en frño normada por "
						+ "los estándares del Instituto Americano de Hierro y Acero AISI. Composición:  Cada estructura "
						+ "metálica está conformada por perfiles tipo G con dimensiones variables de 100mm a 200mm de alto, "
						+ "40mm de ala y 17 mm de aleta (mínimo) y perfiles tipo U de 100mm a 200mm de altura, 35 mm de alma "
						+ "(mínimo) con espesores de placa entre 0,93 - 1,64 mm, laminados en frío, los cuales deberán ser "
						+ "utilizados en función del elemento a soportar y se ensamblarán entre sí utilizando su respectiva "
						+ "tuerca y perno galvanizado. Normativa: La estructura soporta acciones horizontales y verticales "
						+ "de acuerdo a lo señalado en la Norma Técnica Ecuatoriana (NEC2014). "
						+ "Plano de referencia:  No. E1</body></html>");
		lblEMCaracteristicas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEMCaracteristicas.setBounds(10, 17, 235, 274);
		pnlEstrMetalica.add(lblEMCaracteristicas);

		JPanel pnlEMObsRef = new JPanel();
		pnlEMObsRef.setLayout(null);
		pnlEMObsRef.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlEMObsRef.setBounds(249, 162, 177, 47);
		pnlPestaña1.add(pnlEMObsRef);

		JLabel lblEMObsRef = new JLabel("Observaci\u00F3n/Referencia");
		lblEMObsRef.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEMObsRef.setBounds(50, 0, 123, 14);
		pnlEMObsRef.add(lblEMObsRef);

		rdBtn20 = new JRadioButton("");
		rdBtn20.setBounds(2, 16, 21, 23);
		pnlEMObsRef.add(rdBtn20);

		rdBtn21 = new JRadioButton("");
		rdBtn21.setBounds(23, 16, 21, 23);
		pnlEMObsRef.add(rdBtn21);

		ButtonGroup grBtnEM = new ButtonGroup();
		grBtnEM.add(rdBtn20);
		grBtnEM.add(rdBtn21);

		JLabel lblEMSi = new JLabel("SI");
		lblEMSi.setBounds(6, 0, 21, 14);
		pnlEMObsRef.add(lblEMSi);

		JLabel lblEMNo = new JLabel("NO");
		lblEMNo.setBounds(25, 0, 21, 14);
		pnlEMObsRef.add(lblEMNo);

		txtObs2 = new JTextField();
		txtObs2.setColumns(10);
		txtObs2.setBounds(50, 16, 123, 20);
		pnlEMObsRef.add(txtObs2);

		JPanel pnlPPA = new JPanel();
		pnlPPA.setLayout(null);
		pnlPPA.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Paneles de Pared con alma de EPS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlPPA.setBounds(426, 11, 249, 252);
		pnlPestaña1.add(pnlPPA);

		JLabel lblPPACaracteristicas = new JLabel(
				"<html><body>Materiales:<br>" + "Acero: galvanizado pre pintado de acuerdo a diseño arquitectónico y "
						+ "disponibilidad de colores de acuerdo a producción del material, en 0,5 mm de grosor según norma ASTM.<br>"
						+ "EPS: Poliestireno expandido con retardante al fuego tipo F.<br>"
						+ "Dimensiones mínimas: 1,00 - 1,20 mts de ancho y de espesor de 100 mm, con una densidad entre 18 - 20 kg/m3.<br>"
						+ "Composición:<br>"
						+ "Las paredes están conformadas por un panel sándwich formado por un núcleo aislante térmico de espuma rígida "
						+ "de poliestireno expandido (EPS) con retardante de fuego, además de un recubrimiento en ambas caras de plancha metálica."
						+ "Las paredes son termo acústicos, auto portantes, durables, inoxidables.<br>"
						+ "Normativa: Los paneles tienen la capacidad de resisitrir acciones horizontales y verticales de acuerdo a lo señalado en el NEC2014."
						+ "Plano de referencia:  No. E1</body></html>");
		lblPPACaracteristicas.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblPPACaracteristicas.setBounds(10, 17, 235, 227);
		pnlPPA.add(lblPPACaracteristicas);

		JPanel pnlPPAObsRef = new JPanel();
		pnlPPAObsRef.setLayout(null);
		pnlPPAObsRef.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPPAObsRef.setBounds(675, 19, 177, 47);
		pnlPestaña1.add(pnlPPAObsRef);

		JLabel lblPPAObsRef = new JLabel("Observaci\u00F3n/Referencia");
		lblPPAObsRef.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPPAObsRef.setBounds(50, 0, 123, 14);
		pnlPPAObsRef.add(lblPPAObsRef);

		rdBtn30 = new JRadioButton("");
		rdBtn30.setBounds(2, 16, 21, 23);
		pnlPPAObsRef.add(rdBtn30);

		rdBtn31 = new JRadioButton("");
		rdBtn31.setBounds(23, 16, 21, 23);
		pnlPPAObsRef.add(rdBtn31);

		ButtonGroup grBtnPPA = new ButtonGroup();
		grBtnPPA.add(rdBtn30);
		grBtnPPA.add(rdBtn31);

		JLabel lblPPASi = new JLabel("SI");
		lblPPASi.setBounds(6, 0, 21, 14);
		pnlPPAObsRef.add(lblPPASi);

		JLabel lblPPANo = new JLabel("NO");
		lblPPANo.setBounds(25, 0, 21, 14);
		pnlPPAObsRef.add(lblPPANo);

		txtObs3 = new JTextField();
		txtObs3.setColumns(10);
		txtObs3.setBounds(50, 16, 123, 20);
		pnlPPAObsRef.add(txtObs3);

		JPanel pnlVentanasUPVC = new JPanel();
		pnlVentanasUPVC.setLayout(null);
		pnlVentanasUPVC.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ventanas de UPVC",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlVentanasUPVC.setBounds(426, 263, 249, 170);
		pnlPestaña1.add(pnlVentanasUPVC);

		JLabel lblV_UPVCCaracteristicas = new JLabel("<html><body>Materiales:"
				+ "UPVC (Policloruro de vinilo sin plastificar)."
				+ "Dimensiones mínimas: Las ventanas en los módulos de aulas son de 3,0 X 1,10 mts."
				+ "Composición:  La ventanearía de los módulos es corrediza compuesta de tres hojas y dos carriles, "
				+ "perfiles de UPVC, con todos los sistemas de fijación, anclaje y seguridad que se requiere."
				+ "El marco de la ventana es elaborado con canal C metálico galvanizado laminado en frío, Steel "
				+ "Framing bajo los estándares del Instituto americano de Hierro y Acero AISI."
				+ "El anclaje es realizado con tornillos autorroscantes directamente al marco de la ventana en todos sus lados. "
				+ "Normativa: Instituto americano de Hierro y Acero AISI. Plano de referencia:  No. E1</body></html>");
		lblV_UPVCCaracteristicas.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblV_UPVCCaracteristicas.setBounds(10, 17, 235, 150);
		pnlVentanasUPVC.add(lblV_UPVCCaracteristicas);

		JPanel pnlV_UPVCObsRef = new JPanel();
		pnlV_UPVCObsRef.setLayout(null);
		pnlV_UPVCObsRef.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlV_UPVCObsRef.setBounds(675, 268, 177, 47);
		pnlPestaña1.add(pnlV_UPVCObsRef);

		JLabel lblV_UPVCObsRef = new JLabel("Observaci\u00F3n/Referencia");
		lblV_UPVCObsRef.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblV_UPVCObsRef.setBounds(50, 0, 123, 14);
		pnlV_UPVCObsRef.add(lblV_UPVCObsRef);

		rdBtn40 = new JRadioButton("");
		rdBtn40.setBounds(2, 16, 21, 23);
		pnlV_UPVCObsRef.add(rdBtn40);

		rdBtn41 = new JRadioButton("");
		rdBtn41.setBounds(23, 16, 21, 23);
		pnlV_UPVCObsRef.add(rdBtn41);

		ButtonGroup grBtnV_UPVC = new ButtonGroup();
		grBtnV_UPVC.add(rdBtn40);
		grBtnV_UPVC.add(rdBtn41);

		JLabel lblV_UPVCSi = new JLabel("SI");
		lblV_UPVCSi.setBounds(6, 0, 21, 14);
		pnlV_UPVCObsRef.add(lblV_UPVCSi);

		JLabel lblV_UPVCNo = new JLabel("NO");
		lblV_UPVCNo.setBounds(25, 0, 21, 14);
		pnlV_UPVCObsRef.add(lblV_UPVCNo);

		txtObs4 = new JTextField();
		txtObs4.setColumns(10);
		txtObs4.setBounds(50, 16, 123, 20);
		pnlV_UPVCObsRef.add(txtObs4);

		JPanel pnlPTP = new JPanel();
		pnlPTP.setLayout(null);
		pnlPTP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Puerta Tipo Panel EPS",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlPTP.setBounds(852, 11, 249, 230);
		pnlPestaña1.add(pnlPTP);

		JLabel lblPTPCaracteristicas = new JLabel("<html><body>Materiales:<br>"
				+ "EPS (Poliestireno expandido con retardante al fuego), en la que se incluye el marco y tapa marcos respectivo.<br>"
				+ "Dimensiones mínimas: De acuerdo a planos constructivos.<br>Composiciñn:"
				+ "La hoja de la puerta es de panel sánduche 50 mm de espesor, con un marco y un contramarco de canal C "
				+ "metálico galvanizado laminado en frío Steel Framing bajo los estándares del Instituto Americano de Hierro y Acero.<br>"
				+ "Se usan bisagras de 3 y cerradura con llave, tipo industrial instalada en hendidura de puerta o similar con reforzamiento "
				+ "de platina metálica en el donde se instala la cerradura.<br>"
				+ "El anclaje de la puerta se realiza con tres (3) bisagras atornilladas y apernadas al contramarco con al menos 8 tornillos.<br>"
				+ "Normativa: Instituto americano de Hierro y Acero AISI. "
				+ "Plano de referencia:  No. E1</body></html>");
		lblPTPCaracteristicas.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblPTPCaracteristicas.setBounds(10, 12, 235, 212);
		pnlPTP.add(lblPTPCaracteristicas);

		JPanel pnlPTPObsRef = new JPanel();
		pnlPTPObsRef.setLayout(null);
		pnlPTPObsRef.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPTPObsRef.setBounds(1101, 19, 177, 47);
		pnlPestaña1.add(pnlPTPObsRef);

		JLabel lblPTPObsRef = new JLabel("Observaci\u00F3n/Referencia");
		lblPTPObsRef.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPTPObsRef.setBounds(50, 0, 123, 14);
		pnlPTPObsRef.add(lblPTPObsRef);

		rdBtn50 = new JRadioButton("");
		rdBtn50.setBounds(2, 16, 21, 23);
		pnlPTPObsRef.add(rdBtn50);

		rdBtn51 = new JRadioButton("");
		rdBtn51.setBounds(23, 16, 21, 23);
		pnlPTPObsRef.add(rdBtn51);

		ButtonGroup grBtnPTP = new ButtonGroup();
		grBtnPTP.add(rdBtn50);
		grBtnPTP.add(rdBtn51);

		JLabel lblPTPSi = new JLabel("SI");
		lblPTPSi.setBounds(6, 0, 21, 14);
		pnlPTPObsRef.add(lblPTPSi);

		JLabel lblPTPNo = new JLabel("NO");
		lblPTPNo.setBounds(25, 0, 21, 14);
		pnlPTPObsRef.add(lblPTPNo);

		txtObs5 = new JTextField();
		txtObs5.setColumns(10);
		txtObs5.setBounds(50, 16, 123, 20);
		pnlPTPObsRef.add(txtObs5);

		JPanel pnlPC = new JPanel();
		pnlPC.setLayout(null);
		pnlPC.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Panel de Cubierta con EPS",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlPC.setBounds(852, 245, 249, 208);
		pnlPestaña1.add(pnlPC);

		JLabel lblPCCaracteristicas = new JLabel("<html><body>Materiales:<br>El panel consta de materiales:<br>"
				+ "Acero: Acero galvanizado pre pintado de acuerdo a diseño arquitectónico y disponibilidad de "
				+ "colores de acuerdo, en  0,5 mm de grosor según norma ASTM."
				+ "EPS: Poliestireno expandido con retardante al fuego tipo F.<br>"
				+ "Dimensiones mínimas:  El panel de cubierta EPS (panel prefabricado de poliestireno con "
				+ "retardante al fuego) está compuesto por módulos de 1,00 a 1,20 mts de ancho y de espesor "
				+ "mínimo de 100 mm, con una densidad entre 18-20 kg/m3."
				+ "Composición:  Los paneles son termocústicos, auto portantes, durables, inoxidables."
				+ "	Normativa: Los paneles de cubierta tienen la capacidad de resisitrir acciones "
				+ "horizontales y verticales de acuerdo a lo señalado en el NEC2014. Plano de referencia:  No. E1"
				+ "</body></html>");
		lblPCCaracteristicas.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblPCCaracteristicas.setBounds(10, 13, 235, 188);
		pnlPC.add(lblPCCaracteristicas);

		JPanel pnlPCObsRef = new JPanel();
		pnlPCObsRef.setLayout(null);
		pnlPCObsRef.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPCObsRef.setBounds(1101, 253, 177, 47);
		pnlPestaña1.add(pnlPCObsRef);

		JLabel lblPCObsRef = new JLabel("Observaci\u00F3n/Referencia");
		lblPCObsRef.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPCObsRef.setBounds(50, 0, 123, 14);
		pnlPCObsRef.add(lblPCObsRef);

		rdBtn60 = new JRadioButton("");
		rdBtn60.setBounds(2, 16, 21, 23);
		pnlPCObsRef.add(rdBtn60);

		rdBtn61 = new JRadioButton("");
		rdBtn61.setBounds(23, 16, 21, 23);
		pnlPCObsRef.add(rdBtn61);

		ButtonGroup grBtnPC = new ButtonGroup();
		grBtnPC.add(rdBtn60);
		grBtnPC.add(rdBtn61);

		JLabel lblPCSi = new JLabel("SI");
		lblPCSi.setBounds(6, 0, 21, 14);
		pnlPCObsRef.add(lblPCSi);

		JLabel lblPCNo = new JLabel("NO");
		lblPCNo.setBounds(25, 0, 21, 14);
		pnlPCObsRef.add(lblPCNo);

		txtObs6 = new JTextField();
		txtObs6.setColumns(10);
		txtObs6.setBounds(50, 16, 123, 20);
		pnlPCObsRef.add(txtObs6);

		JPanel pnlPestaña2 = new JPanel();
		tabbedPane.addTab("2.- Ficha Revisión Bloques", null, pnlPestaña2, null);
		pnlPestaña2.setLayout(null);

		JPanel pnlIluminacion = new JPanel();
		pnlIluminacion.setLayout(null);
		pnlIluminacion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Iluminaci\u00F3n",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlIluminacion.setBounds(10, 11, 371, 156);
		pnlPestaña2.add(pnlIluminacion);

		JLabel lblICaracteristicas = new JLabel(
				"<html><body>Materiales:<br>Luminarias tipo LED.<br>Características:<br>Luminarias tipo "
						+ "LED de al menos 60 W y 5000 lúmenes.<br>Composiciñn:<br>Los conductores de iluminación "
						+ "son de calibre mínimo No. 14AWG THHN flexible, colocados en el interior de manguera "
						+ "flexible anillada metálica, con el espaciamiento de reserva y ventilación acorde a norma.<br>"
						+ "Normativa:<br>La instalación se realiza acorde a los establecido a la norma NEC 384-6 "
						+ "(Código Eléctrico Ecuatoriano).<br>Plano de referencia:  PE-08</body></html>");
		lblICaracteristicas.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblICaracteristicas.setBounds(10, 17, 351, 128);
		pnlIluminacion.add(lblICaracteristicas);

		JPanel pnlIObsRef = new JPanel();
		pnlIObsRef.setLayout(null);
		pnlIObsRef.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlIObsRef.setBounds(382, 17, 177, 47);
		pnlPestaña2.add(pnlIObsRef);

		JLabel lblIObsRef = new JLabel("Observaci\u00F3n/Referencia");
		lblIObsRef.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblIObsRef.setBounds(50, 0, 123, 14);
		pnlIObsRef.add(lblIObsRef);

		rdBtn70 = new JRadioButton("");
		rdBtn70.setBounds(2, 16, 21, 23);
		pnlIObsRef.add(rdBtn70);

		rdBtn71 = new JRadioButton("");
		rdBtn71.setBounds(23, 16, 21, 23);
		pnlIObsRef.add(rdBtn71);

		ButtonGroup grBtnI = new ButtonGroup();
		grBtnI.add(rdBtn70);
		grBtnI.add(rdBtn71);

		JLabel lblISi = new JLabel("SI");
		lblISi.setBounds(6, 0, 21, 14);
		pnlIObsRef.add(lblISi);

		JLabel lblINo = new JLabel("NO");
		lblINo.setBounds(25, 0, 21, 14);
		pnlIObsRef.add(lblINo);

		txtObs7 = new JTextField();
		txtObs7.setColumns(10);
		txtObs7.setBounds(50, 16, 123, 20);
		pnlIObsRef.add(txtObs7);

		JPanel pnlSistFuerza = new JPanel();
		pnlSistFuerza.setLayout(null);
		pnlSistFuerza.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sistema de Fuerza 110V",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlSistFuerza.setBounds(10, 167, 371, 289);
		pnlPestaña2.add(pnlSistFuerza);

		JLabel lblSFCaracteristicas = new JLabel(
				"<html><body>Materiales:<br>Tomacorrientes tipo doble polarizados, con placas decorativas "
						+ "color blanco del mismo color de la pieza del tomacorriente respectivo. Conductores rígidos "
						+ "revestido de calibres 12 y 14 AWG de tipo THHN. <br>Características:<br>Sistema de fuerza 110V."
						+ "<br>Composición:<br>El sistema de fuerza inicia su cableado en el centro de carga de cada área, "
						+ "el cableado y se lo realiza con conductor rígido revestido de calibre N.- 12 AWG THHN para la fase "
						+ "y el neutro  calibre  N.- 12 AWG THHN, y cable desnudo a tierra #14, mínimo.<br>Los conductores"
						+ " están ubicados dentro de manguera flexible anillada metálica, con el espaciamiento de reserva y "
						+ "ventilación acorde a norma (Código Eléctrico Ecuatoriano, NEC 384-6).<br>Las derivaciones para los "
						+ "demás tomacorrientes, se realizan dentro de cajas de paso dentro del cajetín rectangular profundo "
						+ "que aloja el accesorio del tomacorriente con capacidad de coducción de 15 amperios. Los "
						+ "tomacorrientes tipo doble polarizados, con placas decorativas color blanco del mismo color de la "
						+ "pieza del tomacorriente respectivo.<br>Normativa:<br>La instalación se realiza acorde a los "
						+ "establecido a la norma NEC 384-6 (Código Eléctrico Ecuatoriano).<br>Plano de referencia:PE-05</body></html>");
		lblSFCaracteristicas.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSFCaracteristicas.setBounds(10, 13, 351, 265);
		pnlSistFuerza.add(lblSFCaracteristicas);

		JPanel pnlSFObsRef = new JPanel();
		pnlSFObsRef.setLayout(null);
		pnlSFObsRef.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlSFObsRef.setBounds(382, 173, 177, 47);
		pnlPestaña2.add(pnlSFObsRef);

		JLabel lblSFObsRef = new JLabel("Observaci\u00F3n/Referencia");
		lblSFObsRef.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSFObsRef.setBounds(50, 0, 123, 14);
		pnlSFObsRef.add(lblSFObsRef);

		rdBtn80 = new JRadioButton("");
		rdBtn80.setBounds(2, 16, 21, 23);
		pnlSFObsRef.add(rdBtn80);

		rdBtn81 = new JRadioButton("");
		rdBtn81.setBounds(23, 16, 21, 23);
		pnlSFObsRef.add(rdBtn81);

		ButtonGroup grBtnSF = new ButtonGroup();
		grBtnSF.add(rdBtn80);
		grBtnSF.add(rdBtn81);

		JLabel lblSFSi = new JLabel("SI");
		lblSFSi.setBounds(6, 0, 21, 14);
		pnlSFObsRef.add(lblSFSi);

		JLabel lblSFNo = new JLabel("NO");
		lblSFNo.setBounds(25, 0, 21, 14);
		pnlSFObsRef.add(lblSFNo);

		txtObs8 = new JTextField();
		txtObs8.setColumns(10);
		txtObs8.setBounds(50, 16, 123, 20);
		pnlSFObsRef.add(txtObs8);

		JPanel pnlWPC = new JPanel();
		pnlWPC.setLayout(null);
		pnlWPC.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"<html><body>Compuesto de madera y pl\u00E1stico (WPC) para piso de m\u00F3dulos</body></html>",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlWPC.setBounds(594, 11, 249, 213);
		pnlPestaña2.add(pnlWPC);

		JLabel lblWPCCaracteristicas = new JLabel(
				"<html><body>Materiales:<br>Módulos conformados por paneles compuestos de madera y plástico (WPC)."
						+ "<br>Características:<br>Soporta las cargas vivas máximas de diseño señaldo en el NEC para su uso. "
						+ "Es impermeable, con una superficie antideslizante, resistente a deformaciones y ralladuras. "
						+ "Es resistente al ataque de insectos y hongos, y ser 100% reciclable. El ensamblado es de tipo "
						+ "machiembrado con click de ancastre.<br>Normativa:<br>Norma NEC 3.<br>"
						+ "Plano de referencia:  PE-08</body></html>");
		lblWPCCaracteristicas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblWPCCaracteristicas.setBounds(10, 34, 235, 165);
		pnlWPC.add(lblWPCCaracteristicas);

		JPanel pnlWPCObsRef = new JPanel();
		pnlWPCObsRef.setLayout(null);
		pnlWPCObsRef.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlWPCObsRef.setBounds(843, 17, 177, 47);
		pnlPestaña2.add(pnlWPCObsRef);

		JLabel lblWPCObsRef = new JLabel("Observaci\u00F3n/Referencia");
		lblWPCObsRef.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblWPCObsRef.setBounds(50, 0, 123, 14);
		pnlWPCObsRef.add(lblWPCObsRef);

		rdBtn90 = new JRadioButton("");
		rdBtn90.setBounds(2, 16, 21, 23);
		pnlWPCObsRef.add(rdBtn90);

		rdBtn91 = new JRadioButton("");
		rdBtn91.setBounds(23, 16, 21, 23);
		pnlWPCObsRef.add(rdBtn91);

		ButtonGroup grBtnWPC = new ButtonGroup();
		grBtnWPC.add(rdBtn90);
		grBtnWPC.add(rdBtn91);

		JLabel lblWPCSi = new JLabel("SI");
		lblWPCSi.setBounds(6, 0, 21, 14);
		pnlWPCObsRef.add(lblWPCSi);

		JLabel lblWPCNo = new JLabel("NO");
		lblWPCNo.setBounds(25, 0, 21, 14);
		pnlWPCObsRef.add(lblWPCNo);

		txtObs9 = new JTextField();
		txtObs9.setColumns(10);
		txtObs9.setBounds(50, 16, 123, 20);
		pnlWPCObsRef.add(txtObs9);

		JPinformacionObligatoria infoObligatoria = new JPinformacionObligatoria(845, 200);
		infoObligatoria.getBtnInsertarFoto().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fotoInfoObl = getPathImagen();
			}
		});
		pnlPestaña2.add(infoObligatoria.getPnlInformacionObl());

		cabecera.getBtnRegistrar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ServicioInfoObligatoria srvInfoOblig = new ComponenteInfoObligatoria();

				infor = cargarInfoObligatoria(infoObligatoria);
				infor.setIoFotoPath(fotoInfoObl);

				if (validarInfo(infor)) {
					srvInfoOblig.crear(infor);
					infor.setIoSerial(srvInfoOblig.serialInfoOblMax());
					servFicha.guardarFichaB(cargarFicha());
					HashMap<String, Object> parametros = new HashMap<String, Object>();
					parametros.put("serial_cabecera", Utilitarios.gettCabecera().getCSerial());
					parametros.put("serial_ficha", ficha.getFiSerial());

					Reporte reporte = new Reporte("Reporte Revisión Bloques", 280, 10, 850, 750);
					InputStream path = AlInicio.class.getResourceAsStream("/com/capa/templates/RevisionBloques.jasper");
					reporte.cargarReporte(path, parametros, Query.getMysql().getConexion());
					reporte.setVisible(true);
					new FichaB().setVisible(true);
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Ingresar datos en Información Obligatoria");
				}
			}
		});

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				new FichaB().setVisible(true);
				dispose();
			}
		});
	}

	public List<TdetalleFicha> cargarFicha() {
		List<TdetalleFicha> listaDetalles = new LinkedList<>();
		TGrupo grupoTmp = servFicha.buscarGrupo("Dimensiones");
		String observacion, desicion = "";
		Integer updateFicha = servFicha.nActualizacionFicha(gettCabecera(), ficha);
		if (updateFicha == -1) {
			updateFicha = 0;
		} else {
			updateFicha++;
		}
		observacion = txtObs0.getText();
		if (rdBtn00.isSelected()) {
			desicion = "SI";
		} else if (rdBtn01.isSelected()) {
			desicion = "NO";
		}
		listaDetalles.add(new TdetalleFicha(gettCabecera(), infor, grupoTmp, ficha, updateFicha, observacion, desicion,
				quitarEtiquetasHTML(LBL_BR_0)));

		grupoTmp = servFicha.buscarGrupo("Bases Prefabricadas");
		observacion = txtObs1.getText();
		if (rdBtn10.isSelected()) {
			desicion = "SI";
		} else if (rdBtn11.isSelected()) {
			desicion = "NO";
		}
		listaDetalles.add(new TdetalleFicha(gettCabecera(), infor, grupoTmp, ficha, updateFicha, observacion, desicion,
				quitarEtiquetasHTML(LBL_BR_1)));

		grupoTmp = servFicha.buscarGrupo("Estructura Metálica Steel Framing");
		observacion = txtObs2.getText();
		if (rdBtn20.isSelected()) {
			desicion = "SI";
		} else if (rdBtn21.isSelected()) {
			desicion = "NO";
		}
		listaDetalles.add(new TdetalleFicha(gettCabecera(), infor, grupoTmp, ficha, updateFicha, observacion, desicion,
				quitarEtiquetasHTML(LBL_BR_2)));

		grupoTmp = servFicha.buscarGrupo("Paneles de pared con alma de EPS");
		observacion = txtObs3.getText();
		if (rdBtn30.isSelected()) {
			desicion = "SI";
		} else if (rdBtn31.isSelected()) {
			desicion = "NO";
		}
		listaDetalles.add(new TdetalleFicha(gettCabecera(), infor, grupoTmp, ficha, updateFicha, observacion, desicion,
				quitarEtiquetasHTML(LBL_BR_3)));

		grupoTmp = servFicha.buscarGrupo("Ventana de UPVC");
		observacion = txtObs4.getText();
		if (rdBtn40.isSelected()) {
			desicion = "SI";
		} else if (rdBtn41.isSelected()) {
			desicion = "NO";
		}
		listaDetalles.add(new TdetalleFicha(gettCabecera(), infor, grupoTmp, ficha, updateFicha, observacion, desicion,
				quitarEtiquetasHTML(LBL_BR_4)));

		grupoTmp = servFicha.buscarGrupo("Puerta tipo panel EPS");
		observacion = txtObs5.getText();
		if (rdBtn50.isSelected()) {
			desicion = "SI";
		} else if (rdBtn51.isSelected()) {
			desicion = "NO";
		}
		listaDetalles.add(new TdetalleFicha(gettCabecera(), infor, grupoTmp, ficha, updateFicha, observacion, desicion,
				quitarEtiquetasHTML(LBL_BR_5)));

		grupoTmp = servFicha.buscarGrupo("Panel de cubierta con EPS");
		observacion = txtObs6.getText();
		if (rdBtn60.isSelected()) {
			desicion = "SI";
		} else if (rdBtn61.isSelected()) {
			desicion = "NO";
		}
		listaDetalles.add(new TdetalleFicha(gettCabecera(), infor, grupoTmp, ficha, updateFicha, observacion, desicion,
				quitarEtiquetasHTML(LBL_BR_6)));

		grupoTmp = servFicha.buscarGrupo("Iluminación");
		observacion = txtObs7.getText();
		if (rdBtn70.isSelected()) {
			desicion = "SI";
		} else if (rdBtn71.isSelected()) {
			desicion = "NO";
		}
		listaDetalles.add(new TdetalleFicha(gettCabecera(), infor, grupoTmp, ficha, updateFicha, observacion, desicion,
				quitarEtiquetasHTML(LBL_BR_7)));

		grupoTmp = servFicha.buscarGrupo("Sistema de Fuerza 110V");
		observacion = txtObs8.getText();
		if (rdBtn80.isSelected()) {
			desicion = "SI";
		} else if (rdBtn81.isSelected()) {
			desicion = "NO";
		}
		listaDetalles.add(new TdetalleFicha(gettCabecera(), infor, grupoTmp, ficha, updateFicha, observacion, desicion,
				quitarEtiquetasHTML(LBL_BR_8)));

		grupoTmp = servFicha.buscarGrupo("Compuesto de madera y plástico (WPC) para piso de módulos");
		observacion = txtObs9.getText();
		if (rdBtn90.isSelected()) {
			desicion = "SI";
		} else if (rdBtn91.isSelected()) {
			desicion = "NO";
		}
		listaDetalles.add(new TdetalleFicha(gettCabecera(), infor, grupoTmp, ficha, updateFicha, observacion, desicion,
				quitarEtiquetasHTML(LBL_BR_9)));

		return listaDetalles;
	}
}
