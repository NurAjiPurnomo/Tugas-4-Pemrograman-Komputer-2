import java.io.*;
import javax.swing.*;
import java.awt.FlowLayout;

public class MainFrame extends JFrame {
    private JTextField namaField, nimField;
    private JButton simpanButton, bukaButton;

    public MainFrame() {
        setTitle("Aplikasi Mahasiswa");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel namaLabel = new JLabel("Nama:");
        add(namaLabel);
        namaField = new JTextField(15);
        add(namaField);

        JLabel nimLabel = new JLabel("NIM:");
        add(nimLabel);
        nimField = new JTextField(15);
        add(nimField);

        simpanButton = new JButton("Simpan");
        add(simpanButton);

        bukaButton = new JButton("Buka");
        add(bukaButton);

        simpanButton.addActionListener(e -> simpanData());
        bukaButton.addActionListener(e -> bukaData());
    }

    private void simpanData() {
        String nama = namaField.getText();
        String nim = nimField.getText();
        MahasiswaApp mhs = new MahasiswaApp(nama, nim); // pakai MahasiswaApp

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("mahasiswa.dat"))) {
            out.writeObject(mhs);
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void bukaData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("mahasiswa.dat"))) {
            MahasiswaApp mhs = (MahasiswaApp) in.readObject();
            namaField.setText(mhs.getNama());
            nimField.setText(mhs.getNim());
            JOptionPane.showMessageDialog(this, "Data berhasil dibuka!");
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
