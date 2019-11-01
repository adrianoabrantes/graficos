package br.com.empresa.graficos;

public enum TipoGrafico {
  BAR("bar"), LINE("line"), PIE("pie");

  private String tipoGrafico = "";

  TipoGrafico(String tipoGrafico) {
      this.tipoGrafico = tipoGrafico;
  }

  public String getTipoGrafico() {
    return tipoGrafico;
  }

  @Override
  public String toString() {
    return getTipoGrafico();
  }
}
