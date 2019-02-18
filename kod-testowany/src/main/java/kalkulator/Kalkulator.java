package kalkulator;

import adnotacje.Run;

public class Kalkulator {

  @Run
  public Integer dodaj(Integer a, Integer b) {
    return a + b;
  }

  @Run
  public Integer pomnóż(Integer a, Integer b) {
    return a + b;
  }

  public static double zwrócLiczbęPi() {
    return Math.PI;
  }
}
