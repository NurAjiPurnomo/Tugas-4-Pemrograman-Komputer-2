import java.io.*;
import javax.swing.*;
import java.awt.FlowLayout;

public class MainFrame extends JFrame {
    private JTextField namaField, nimField;
    private JButton simpanButton, bukaButton;

    public MainFrame() {
        // Set judul frame dan ukuran
        setTitle("Aplikasi Mahasiswa");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Gunakan FlowLayout supaya elemen-elemen lebih responsif
        setLayout(new FlowLayout());

        // Buat label dan text field untuk Nama
        JLabel namaLabel = new JLabel("Nama:");
        add(namaLabel);
        
        // Teks field untuk input Nama
        namaField = new JTextField(15);  // 15 kolom
        add(namaField);

        // Buat label dan text field untuk NIM
        JLabel nimLabel = new JLabel("NIM:");
        add(nimLabel);

        // Teks field untuk input NIM
        nimField = new JTextField(15);  // 15 kolom
        add(nimField);

        // Tombol simpan
        simpanButton = new JButton("Simpan");
        add(simpanButton);

        // Tombol buka
        bukaButton = new JButton("Buka");
        add(bukaButton);

        // Aksi tombol simpan
        simpanButton.addActionListener(e -> simpanData());
        
        // Aksi tombol buka
        bukaButton.addActionListener(e -> bukaData());
    }

    // Method untuk menyimpan data ke file .dat menggunakan serialization
    private void simpanData() {
        String nama = namaField.getText();
        String nim = nimField.getText();
        Mahasiswa mhs = new Mahasiswa(nama, nim);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("mahasiswa.dat"))) {
            out.writeObject(mhs);
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // Method untuk membuka data dari file .dat dan menampilkan di form
    private void bukaData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("mahasiswa.dat"))) {
            Mahasiswa mhs = (Mahasiswa) in.readObject();
            namaField.setText(mhs.getNama());
            nimField.setText(mhs.getNim());
            JOptionPane.showMessageDialog(this, "Data berhasil dibuka!");
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // Main method untuk menjalankan aplikasi
    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
