package br.com.empresa.sql;

import java.util.List;

import br.com.empresa.service.ConnectionUtil;

public class DataProvider {
	List<String> lista = null;
	String data = "";

	public DataProvider(List<String> campos, String nomeTabela) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		String sql = "select * from " + nomeTabela.toLowerCase();
		lista = connectionUtil.connectionUtil(sql, campos);

		String titulos = "";
		int cont = 1;

		for (String campo : campos) {
			if (cont == 1) {
				titulos += "[\'";
				titulos += nomeTabela;
			} else {
				titulos += campo;
			}

			if (cont < campos.size()) {
				titulos += "\',\'";
			} else if (cont == campos.size()) {
				titulos += "\']";
			}
			cont++;
		}

		data += String.format("%s,", titulos);

		int i2 = 0;
		for (String item : lista) {
			for (int i = 0; i < item.split(",").length; i++) {
				if (i == 0) {
					data += String.format("[\'%s\'", item.split(",")[i]);
				} else if (i < campos.size()) {
					data += String.format("%s", item.split(",")[i]);
				}

				if (i != campos.size() - 1) {
					data += ",";
				} else {
					data += String.format("]");
				}
			}

			if (i2 != lista.size() - 1) {
				data += ",";
			}
			i2++;
		}

	}

	public String data() {
		return this.data;
	}
}
