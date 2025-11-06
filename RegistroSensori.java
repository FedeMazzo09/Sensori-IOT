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
}