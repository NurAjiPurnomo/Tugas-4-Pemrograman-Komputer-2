import java.io.Serializable;

public class Mahasiswa implements Serializable {
    private static final long serialVersionUID = 1L; // Versi serialisasi untuk kompatibilitas
    private String nama;
    private String nim;

    // Konstruktor untuk inisialisasi data mahasiswa
    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Getter untuk NIM
    public String getNim() {
        return nim;
    }

    // Setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Setter untuk NIM
    public void setNim(String nim) {
        this.nim = nim;
    }

    // Method toString untuk menampilkan informasi mahasiswa
    @Override
    public String toString() {
        return "Nama: " + nama + ", NIM: " + nim;
    }
}
