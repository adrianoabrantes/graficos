package br.com.empresa.graficos.relatorios;

import java.util.ArrayList;
import java.util.List;

import br.com.empresa.graficos.BaseGrafico;
import br.com.empresa.graficos.TipoGrafico;
import br.com.empresa.sql.DataProvider;

public class UsuariosGraficoBar {
	public UsuariosGraficoBar() {
		BaseGrafico bg = new BaseGrafico();
		List<String> campos = new ArrayList<String>();

		String nomeGrafico = "Usuario";
		campos.add("usuario");
		campos.add("senha");
		
		DataProvider dp = new DataProvider(campos, nomeGrafico.toLowerCase());
		String data=dp.data();

		System.out.println(bg.baseHTML(TipoGrafico.BAR, nomeGrafico, "Statistica de Usuarios", data));
	}
}
