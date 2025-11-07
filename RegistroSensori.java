public class RegistroSensori {

    private Sensore[] sensori;
    private int size;

    public RegistroSensori(int max) {
        sensori = new Sensore[max];
        size = 0;
    }

    public int aggiungiSensore(Sensore s) {
        if (size < sensori.length) {
            sensori[size] = s;
            size++;
        }
        return -1;
    }

    public int eliminaSensore(String ip) {
        for (int i = 0; i < size; i++) {
            if (ip.equals(sensori[i].getIP())) {
                size--;
                sensori[i] = sensori[size];
                sensori[size] = null;
                return 1;
            }

        }
        return -1;
    }

    public Sensore cercaPerIP(String ip) {
        for (int i = 0; i < size; i++) {
            if (ip.equals(sensori[i].getIP())) {
                return sensori[i];
            }
        }
        return null;
    }

    public void cercaPerArea(double latMin, double latMax, double lonMin, double lonMax) {
        Sensore[] trovati = new Sensore[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            Sensore s = sensori[i];
            if (s.getLatitudine() >= latMin && s.getLatitudine() <= latMax && s.getLongitudine() >= lonMin && s.getLongitudine() <= lonMax) {
                trovati[count] = s;
                System.out.println(trovati[count]);
                count++;
            }
        }
    }

    public void cercaBatterieScadute() {
        Sensore[] trovati = new Sensore[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (sensori[i].batteriaDaSostituire()) {
                trovati[count] = sensori[i];
                System.out.println(trovati[count]);
                count++;
            }
        }
    }
}
