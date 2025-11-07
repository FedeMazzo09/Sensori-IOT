import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {

    public static void main(String[] args) {

        RegistroSensori registro = new RegistroSensori(10);

        Sensore s1 = new Sensore("192.168.1.10", 45.6, 9.2, new GregorianCalendar(2023, Calendar.JANUARY, 10));
        Sensore s2 = new Sensore("192.168.1.11", 45.7, 9.3, new GregorianCalendar(2022, Calendar.DECEMBER, 1));
        Sensore s3 = new Sensore("192.168.1.12", 46.0, 9.4, new GregorianCalendar(2024, Calendar.JANUARY, 5));
        Sensore s4 = new Sensore("192.168.1.13", 48.0, 10.98, new GregorianCalendar(2025, Calendar.SEPTEMBER, 12));

        registro.aggiungiSensore(s1);
        registro.aggiungiSensore(s2);
        registro.aggiungiSensore(s3);
        registro.aggiungiSensore(s4);

        System.out.println("Ricerca per IP:");
        System.out.println(registro.cercaPerIP("192.168.1.11"));
        System.out.println();

        System.out.println("Sensori in area (45.5 - 45.8 , 9.0 - 9.5):");
        registro.cercaPerArea(45.5, 45.8, 9.0, 9.5);
        System.out.println();

        System.out.println("Sensori con batteria scaduta:");
        registro.cercaBatterieScadute();
        System.out.println();

        System.out.println("Eliminazione sensore:");
        registro.eliminaSensore("192.168.1.11");
        System.out.println();

        System.out.println(registro.cercaPerIP("192.168.1.11"));
    }
}
