import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class BioskopTiket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int HARGA_TIKET = 50000;
        int totalTiket = 0;
        double totalPenjualan = 0;
        String input;

        // Format Rupiah
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols simbol = new DecimalFormatSymbols();
        simbol.setCurrencySymbol("Rp ");
        simbol.setMonetaryDecimalSeparator(',');
        simbol.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(simbol);

        System.out.println("==============================================");
        System.out.println("         PROGRAM PEMESANAN TIKET BIOSKOP      ");
        System.out.println("==============================================");

        while (true) {
            System.out.print("\nMasukkan nama pelanggan (atau ketik 'selesai' untuk keluar): ");
            String namaPelanggan = sc.nextLine();

            if (namaPelanggan.equalsIgnoreCase("selesai")) {
                break;
            }

            System.out.print("Masukkan nama film yang ditonton: ");
            String namaFilm = sc.nextLine();

            System.out.print("Masukkan jam tayang film (contoh: 19.30): ");
            String jamTayang = sc.nextLine();

            System.out.print("Masukkan jumlah tiket yang dibeli: ");
            input = sc.nextLine();

            int jumlah;
            try {
                jumlah = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka.");
                continue;
            }

            if (jumlah <= 0) {
                System.out.println("Jumlah tiket tidak boleh nol atau negatif!");
                continue;
            }

            // Input posisi kursi
            String[] posisiKursi = new String[jumlah];
            for (int i = 0; i < jumlah; i++) {
                System.out.print("Masukkan posisi kursi ke-" + (i + 1) + " (contoh: A1, B3, C5): ");
                posisiKursi[i] = sc.nextLine();
            }

            // Hitung total harga + diskon
            double totalHarga = jumlah * HARGA_TIKET;
            double diskon = 0;

            if (jumlah > 10) {
                diskon = 0.15;
                System.out.println("Diskon 15% untuk pembelian lebih dari 10 tiket!");
            } else if (jumlah > 4) {
                diskon = 0.10;
                System.out.println("Diskon 10% untuk pembelian lebih dari 4 tiket!");
            }

            totalHarga -= totalHarga * diskon;
            totalTiket += jumlah;
            totalPenjualan += totalHarga;

            // Tampilkan struk pembelian
            System.out.println("\n==============================================");
            System.out.println("               STRUK PEMBELIAN TIKET          ");
            System.out.println("==============================================");
            System.out.println("Nama Pelanggan  : " + namaPelanggan);
            System.out.println("Film Ditonton   : " + namaFilm);
            System.out.println("Jam Tayang      : " + jamTayang);
            System.out.print("Posisi Kursi    : ");
            for (String kursi : posisiKursi) {
                System.out.print(kursi + " ");
            }
            System.out.println("\nJumlah Tiket    : " + jumlah + " tiket");
            System.out.println("Total Pembayaran: " + kursIndonesia.format(totalHarga));
            System.out.println("==============================================");
            System.out.println("Terima kasih telah memesan tiket di Bioskop Kami!");
            System.out.println("==============================================\n");
        }

        System.out.println("\n==============================================");
        System.out.println("           RINGKASAN PENJUALAN HARI INI        ");
        System.out.println("==============================================");
        System.out.println("Total tiket terjual : " + totalTiket + " tiket");
        System.out.println("Total penjualan     : " + kursIndonesia.format(totalPenjualan));
        System.out.println("==============================================");
        System.out.println("Program selesai. Terima kasih!");
    }
}
