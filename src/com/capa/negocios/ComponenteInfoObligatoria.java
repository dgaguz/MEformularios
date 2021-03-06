package com.capa.negocios;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.capa.datos.TInformacionObligatoria;
import com.capa.util.Utilitarios;

public class ComponenteInfoObligatoria implements ServicioInfoObligatoria {

	@Override
	public void crear(TInformacionObligatoria inforObl) {
		String query = "INSERT INTO t_informacion_obligatoria (io_obs_general_min, io_responsable_min, io_cargo_min, io_obs_gen_cont, io_responsable_cont, io_cargo_cont, "
				+ "io_fecha_io, io_foto_io) VALUES (?,?,?,?,?,?,?,?);";
		try {
			Query.insertarGenerico(query,
					new Object[] { inforObl.getIoObsGeneralMin(), inforObl.getIoResponsableMin(),
							inforObl.getIoCargoMin(), inforObl.getIoObsGenCont(), inforObl.getIoResponsableCont(),
							inforObl.getIoCargoCont(), Utilitarios.getFechaString(inforObl.getIoFechaIo()),
							inforObl.getIoFotoPath() });
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al insertar Datos " + e.getMessage(), "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public Integer serialInfoOblMax() {
		String query = "SELECT MAX(io_serial) FROM t_informacion_obligatoria;";
		Integer maxima = null;
		try {
			ResultSet rs = Query.seleccionar(query);
			while (rs.next()) {
				maxima = new Integer(rs.getInt("MAX(io_serial)"));
			}
		} catch (Exception e) {
			System.out.println("Error al BUSCAR: " + e.getMessage());
		}
		return maxima;
	}

}
