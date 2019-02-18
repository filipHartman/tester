package tester;

import adnotacje.Run;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Predicate;
import kalkulator.Kalkulator;

public class Tester {

  public static void main(String[] args)
      throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
    Class klasa = Kalkulator.class;

    Method met = klasa.getDeclaredMethod("dodaj", Integer.class, Integer.class);
    Object[] parametry = {4,5};
    System.out.println(met.invoke(klasa.newInstance(), parametry));

    Method[] metody = klasa.getDeclaredMethods();
    Object obiekt = klasa.newInstance();
    Predicate<Method> czyMetodaDoTestowania = metoda -> metoda.isAnnotationPresent(Run.class);
    Arrays.stream(metody).filter(czyMetodaDoTestowania).forEach(System.out::println);
    for (Method metoda : metody) {
      Method meto = klasa.getDeclaredMethod(metoda.getName());
      meto.invoke(klasa.newInstance(), new Object[]{1,2});
    }
  }
}
