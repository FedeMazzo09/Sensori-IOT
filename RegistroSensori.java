public class RegistroSensori {

    private Sensore[] sensori;
    private int size;

    public RegistroSensori(int max) {
        sensori = new Sensore[max];
        size = 0;
    }

    public void aggiungiSensore(Sensore s) {
        if (size < sensori.length) {
            sensori[size] = s;
            size++;
        } else {
            System.out.println("Registro pieno, impossibile aggiungere sensore");
        }
    }

    public void eliminaSensore(String ip) {
        for (int i = 0; i < size; i++) {
            if (ip == sensori[i].getIP()) {
                sensori[i] = sensori[--size];
                sensori[size] = null;
                return;
            }
        }
    }

    public Sensore cercaPerIP(String ip) {
        for (int i = 0; i < size; i++) {
            if (ip == sensori[i].getIP()) {
                return sensori[i];
            }
        }
        return null;
    }

    public Sensore[] cercaPerArea(double latMin, double latMax, double lonMin, double lonMax) {
        Sensore[] trovati = new Sensore[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            Sensore s = sensori[i];
            if (s.getLatitudine() >= latMin && s.getLatitudine() <= latMax && s.getLongitudine() >= lonMin && s.getLongitudine() <= lonMax) {
                trovati[count] = s;
                count++;
            }
        }
        return trovati;
    }

    public Sensore[] cercaBatterieScadute() {
        Sensore[] trovati = new Sensore[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (sensori[i].batteriaDaSostituire()) {
                trovati[count] = sensori[i];
                count++;
            }
        }
        return trovati;
    }
}
