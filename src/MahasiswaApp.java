import java.io.Serializable;

public class MahasiswaApp implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nama;
    private String nim;

    public MahasiswaApp(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", NIM: " + nim;
    }
}
