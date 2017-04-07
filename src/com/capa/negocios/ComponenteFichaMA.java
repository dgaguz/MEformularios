package com.capa.negocios;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.capa.datos.TAula;
import com.capa.datos.TGrupo;

public class ComponenteFichaMA implements ServicioFichaMA {

	@Override
	public TAula buscarAula(String nombre) {
		TAula aula = new TAula();

		String sql = "SELECT * FROM t_aula WHERE au_nombre LIKE '" + nombre + "')";
		ResultSet rs = Query.seleccionar(sql);
		try {
			while (rs.next()) {
				aula.setAuSerial(rs.getInt("au_serial"));
				aula.setAuNombre(rs.getString("au_nombre"));
				// aula.setAuFoto(rs.getBlob("au_foto"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aula;
	}

	@Override
	public TGrupo buscarGrupo(String grupo) {
		TGrupo oGrupo = new TGrupo();
		String sql = "SELECT * FROM t_grupo WHERE g_nombre LIKE '" + grupo + "')";
		ResultSet rs = Query.seleccionar(sql);
		try {
			while (rs.next()) {
				oGrupo.setGSerial(rs.getInt("g_serial"));
				oGrupo.setGNombre(rs.getString("g_nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oGrupo;
	}

	@Override
	public Integer buscarUpdateFicha() {
		// TODO Auto-generated method stub
		return null;
	}

}