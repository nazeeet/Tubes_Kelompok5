package tugas_besar_it.pkg45.pkg01;

public class Kuis {
    private String kodekuis;
    private String kodematkul;
    private String namakuis;
    private String nilaikuis;

    public Kuis(String kodekuis, String kodematkul, String namakuis, String nilaikulis) {
        this.kodekuis = kodekuis;
        this.kodematkul = kodematkul;
        this.namakuis = namakuis;
        this.nilaikuis = nilaikuis;
    }

    public String getKodekuis() {
        return kodekuis;
    }

    public String getKodematkul() {
        return kodematkul;
    }
    
    public String getNamakuis() {
        return namakuis;
    }

    public String getNilaikuis() {
        return nilaikuis;
    }
}
