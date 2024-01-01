package tugas_besar_it.pkg45.pkg01;

public class Dosen {
    private String nama;
    private String kodedosen;
    private int nip;

    public Dosen(String nama, String kodedosen, int nip) {
        this.nama = nama;
        this.kodedosen = kodedosen;
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public String getKodedosen() {
        return kodedosen;
    }

    public int getNip() {
        return nip;
    }
    
}
