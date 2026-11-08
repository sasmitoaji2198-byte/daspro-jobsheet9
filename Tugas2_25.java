import java.util.Scanner;

public class Tugas2_25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] menu = {"Nasi Goreng", "Mie Goreng", "Roti Bakar", "Kentang Goreng", "Teh Tarik", "Cappucino", "Chocolate Ice"};
        int[] harga = {15000, 13000, 10000, 12000, 8000, 18000, 20000};

        // Fitur Pencarian Menu
        System.out.println("--- PENCARIAN MENU KAFE ---");
        System.out.print("Masukkan nama makanan/minuman yang ingin dicari: ");
        String cariMenu = input.nextLine();
        boolean ditemukan = false;
        int indeksMenu = -1;

        for (int i = 0; i < menu.length; i++) {
            if (menu[i].equalsIgnoreCase(cariMenu)) {
                ditemukan = true;
                indeksMenu = i;
                break;
            }
        }

        if (ditemukan) {
            System.out.println("Menu \"" + menu[indeksMenu] + "\" tersedia dengan harga Rp " + harga[indeksMenu]);
        } else {
            System.out.println("Mohon maaf, menu \"" + cariMenu + "\" tidak tersedia di kafe.");
        }

        // Fitur Pemesanan
        System.out.println("\n--- PEMESANAN KAFE KAMPUS ---");
        System.out.print("Masukkan jumlah jenis item yang ingin dipesan: ");
        int jumlahPesanan = input.nextInt();
        input.nextLine(); // membersihkan buffer

        String[] pesananNama = new String[jumlahPesanan];
        int[] pesananJumlah = new int[jumlahPesanan];
        int[] pesananSubtotal = new int[jumlahPesanan];
        int totalBiaya = 0;

        for (int i = 0; i < jumlahPesanan; i++) {
            boolean menuValid = false;
            while (!menuValid) {
                System.out.print("Masukkan nama menu ke-" + (i + 1) + ": ");
                String namaPilihan = input.nextLine();

                int idx = -1;
                for (int j = 0; j < menu.length; j++) {
                    if (menu[j].equalsIgnoreCase(namaPilihan)) {
                        idx = j;
                        break;
                    }
                }

                if (idx != -1) {
                    pesananNama[i] = menu[idx];
                    System.out.print("Masukkan jumlah porsi/item untuk " + menu[idx] + ": ");
                    int jmlItem = input.nextInt();
                    input.nextLine(); // membersihkan buffer

                    pesananJumlah[i] = jmlItem;
                    pesananSubtotal[i] = harga[idx] * jmlItem;
                    totalBiaya += pesananSubtotal[i];
                    menuValid = true;
                } else {
                    System.out.println("Menu tidak valid atau tidak ada dalam daftar! Silakan masukkan ulang.");
                }
            }
        }

        // Menampilkan Struk / Daftar Pesanan
        System.out.println("\n========================================");
        System.out.println("         STRUK PEMESANAN KAFE KAMPUS    ");
        System.out.println("========================================");
        for (int i = 0; i < jumlahPesanan; i++) {
            System.out.println("- " + pesananNama[i] + " (" + pesananJumlah[i] + "x) : Rp " + pesananSubtotal[i]);
        }
        System.out.println("----------------------------------------");
        System.out.println("TOTAL BIAYA KESELURUHAN : Rp " + totalBiaya);
        System.out.println("========================================");

        input.close();
    }
}