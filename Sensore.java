import java.util.Calendar;

public class Sensore {

    private String ip;
    private double latitudine;
    private double longitudine;
    private Calendar dataUltimaSostituzione;

    public Sensore(String ip, double latitudine, double longitudine, Calendar dataUltimaSostituzione) {
        this.ip = ip;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.dataUltimaSostituzione = dataUltimaSostituzione;
    }

    public String getIP() {
        return ip;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public Calendar getDataUltimaSostituzione() {
        return dataUltimaSostituzione;
    }

    public boolean batteriaDaSostituire() {
        long diffMillis = Calendar.getInstance().getTimeInMillis() - dataUltimaSostituzione.getTimeInMillis();
        long diffGiorni = diffMillis / (1000 * 60 * 60 * 24);

        if (diffGiorni > 365) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Sensore[" + ip + ", lat=" + latitudine + ", lon=" + longitudine + "]";
    }
}