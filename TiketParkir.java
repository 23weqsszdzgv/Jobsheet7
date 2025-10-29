import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class TiketParkir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nama, nopol;
        int jenis, durasi;
        int totalPembayaran = 0;

        // Format Rupiah
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols simbol = new DecimalFormatSymbols();
        simbol.setCurrencySymbol("Rp ");
        simbol.setMonetaryDecimalSeparator(',');
        simbol.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(simbol);

        System.out.println("==============================================");
        System.out.println("         SISTEM PEMBAYARAN PARKIR OTOMATIS     ");
        System.out.println("==============================================");

        do {
            System.out.print("\nMasukkan nama pelanggan (atau ketik 'selesai' untuk keluar): ");
            nama = sc.nextLine();

            if (nama.equalsIgnoreCase("selesai")) {
                break;
            }

            System.out.print("Masukkan nomor polisi kendaraan: ");
            nopol = sc.nextLine();

            System.out.print("Masukkan jenis kendaraan (1=Mobil, 2=Motor): ");
            jenis = sc.nextInt();

            if (jenis != 1 && jenis != 2) {
                System.out.println("Jenis kendaraan tidak valid! Silakan input ulang.");
                sc.nextLine(); // bersihkan buffer
                continue;
            }

            System.out.print("Masukkan durasi parkir (jam): ");
            durasi = sc.nextInt();
            sc.nextLine(); // membersihkan buffer newline

            if (durasi <= 0) {
                System.out.println("Durasi tidak valid! Harus lebih dari 0 jam.");
                continue;
            }

            int tarif;
            if (durasi > 5) {
                tarif = 12500;
            } else if (jenis == 1) {
                tarif = 3000 * durasi;
            } else {
                tarif = 2000 * durasi;
            }

            totalPembayaran += tarif;

            // Cetak struk pembayaran parkir
            System.out.println("\n==============================================");
            System.out.println("               STRUK PARKIR RESMI              ");
            System.out.println("==============================================");
            System.out.println("Nama Pelanggan  : " + nama);
            System.out.println("No. Polisi      : " + nopol);
            System.out.println("Jenis Kendaraan : " + (jenis == 1 ? "Mobil" : "Motor"));
            System.out.println("Durasi Parkir   : " + durasi + " jam");
            System.out.println("Tarif Dikenakan : " + kursIndonesia.format(tarif));
            System.out.println("==============================================");
            System.out.println("Terima kasih telah menggunakan layanan kami!");
            System.out.println("==============================================");
        } while (true);

        System.out.println("\n==============================================");
        System.out.println("       REKAP PEMBAYARAN PARKIR HARI INI        ");
        System.out.println("==============================================");
        System.out.println("Total pendapatan hari ini : " + kursIndonesia.format(totalPembayaran));
        System.out.println("==============================================");
        System.out.println("Program selesai. Semoga harimu menyenangkan!");
    }
}
