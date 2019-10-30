import java.io.Serializable;

/**
 * @author adrianoa 2019
 * 
 *         Forma de utilizar esta classe Deve-se instancia-la em uma classe que extende htmlprodiver
 *         passando como parametro TIPO de grafico, titulo e uma lista de valores com a seguinte
 *         estrutura para qualquer grafico exeto em linhas: 2 colunas uma com titulos dos registros
 *         e outra com os valor para graficos em linhas: 2 colunas uma com o nome de cada linha do
 *         grafico e outra com valores separados por ;
 *
 */

public class BaseGrafico implements Serializable {
  private static final long serialVersionUID = 1L;

  public String baseHTML(TipoGrafico tipoGrafico, String titulo, String subtitulo, String data) {
    StringBuffer sb = new StringBuffer("<html>\n\r<head>\n\r");

    sb.append(
        "<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n\r");
    sb.append("<script type=\"text/javascript\">\n\r");
    sb.append("google.charts.load('current', {'packages':['");

    if (tipoGrafico == TipoGrafico.BAR) {
      sb.append("bar");

    } else if (tipoGrafico == TipoGrafico.PIE || tipoGrafico == TipoGrafico.LINE) {
      sb.append("corechart");
    }

    sb.append("']});\n\rgoogle.charts.setOnLoadCallback(drawChart);");
    sb.append("function drawChart() {\n\rvar data = google.visualization.arrayToDataTable([\n\r");
    sb.append(data);
    sb.append("\n\r]);var options = {\n\r");

    if (tipoGrafico == TipoGrafico.PIE || tipoGrafico == TipoGrafico.LINE) {
      sb.append("title: '");
      sb.append(titulo);
      sb.append("',\n\r");

      if (tipoGrafico == TipoGrafico.PIE) {
        sb.append("is3D: true,\n\r");
        sb.append("};\n\rvar chart = new google.visualization.PieChart(document.getElementById('");
        sb.append(tipoGrafico.getTipoGrafico());
        sb.append("'));\n");

      } else if (tipoGrafico == TipoGrafico.LINE) {
        sb.append(
            "hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},\n\rvAxis: {minValue: 0}");
        sb.append("};\n\rvar chart = new google.visualization.AreaChart(document.getElementById('");
        sb.append(tipoGrafico.getTipoGrafico());
        sb.append("'));\n\r");
      }
      sb.append("chart.draw(data, options);\n\r");

    } else if (tipoGrafico == TipoGrafico.BAR) {
      sb.append("chart: {title: '");
      sb.append(titulo);
      sb.append("',\n\rsubtitle: '");
      sb.append(subtitulo);
      sb.append("',\n\r}\n\r};\n\r");
      sb.append(" var chart = new google.charts.Bar(document.getElementById('");
      sb.append(tipoGrafico.getTipoGrafico());
      sb.append("'));\n\r");
      sb.append("chart.draw(data, google.charts.Bar.convertOptions(options));\n\r");
    }

    sb.append("}\n\r</script>\n\r</head>\n\r<body>\n\r<div id=\"");
    sb.append(tipoGrafico.getTipoGrafico());
    sb.append("\" style=\"width: 97%; height: 99%;\"></div>\n\r</body>\n\r</html>");

    return sb.toString();
  }

}
