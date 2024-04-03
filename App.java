import java.util.Scanner;

class kendaraan{
    public String merk;
    public String warna;
    public String platNomor;
    public int jumlahPenumpang;
    public int maxPenumpang;

    public driver supir;

    public penumpang[] daftarPenumpang;
    public int indexPenumpang;

    public kendaraan(String pn, String m, int max){
        this.merk = m;
        this.platNomor = pn;
        this.jumlahPenumpang = 0;
        this.maxPenumpang = max;
        this.daftarPenumpang = new penumpang[max];
        this.indexPenumpang = -1;

        System.out.println("Objek dari kelas Kendaraan dengan plat nomor " + this.platNomor + " bermerk " + this.merk + " dengan kapasitas penumpang maksimum " + maxPenumpang + " orang");
        cekPenumpang();
    }

    public void cekPenumpang(){
        System.out.println("Penumpang saat ini: "+this.jumlahPenumpang);
    }

    public void penumpangNaik(int naik) {
        System.out.println("Ada penumpang yang ingin naik: " + naik);
        int current = this.jumlahPenumpang;
        if (current + naik > this.maxPenumpang) {
            System.out.println("Maaf, penumpang melebihi kapasitas");
        } else {
            for (int i = 1; i <= naik; i++) {
                this.indexPenumpang++;
                daftarPenumpang[indexPenumpang] = new penumpang("Penumpang " + (current + i));
            }
            this.jumlahPenumpang += naik;
            System.out.println("Penumpang berhasil naik");
        }
        cekPenumpang();
    }

    public void penumpangNaik(String namaPenumpang) {
        System.out.println("Ada penumpang " + namaPenumpang + " yang ingin naik");
        int current = this.jumlahPenumpang;
        if (current + 1 > this.maxPenumpang) {
            System.out.println("Maaf, penumpang melebihi kapasitas");
        } else {
            this.indexPenumpang++;
            this.daftarPenumpang[this.indexPenumpang] = new penumpang(namaPenumpang);
            this.jumlahPenumpang++;
            System.out.println("Penumpang " + namaPenumpang + " berhasil naik");
        }
        cekPenumpang();
    }

    public void penumpangTurun(int turun) {
        System.out.println("Ada penumpang yang ingin turun: " + turun);
        int current = this.jumlahPenumpang;
        if (current - turun < 0) {
            System.out.println("Maaf, penumpang ghoib yang turun");
        } else {
            for (int i = 0; i < turun; i++) {
                this.indexPenumpang--;
            }
            this.jumlahPenumpang -= turun;
            System.out.println("Penumpang berhasil turun");
        }
        cekPenumpang();
    }

    public void maju(){
        System.out.println(this.merk + " " + this.platNomor +" Maju");
    }

    public void mundur(){
        System.out.println(this.merk + " " + this.platNomor+ " Mundur");
    }

    public void belok(){
        System.out.println(this.merk + " " + this.platNomor+ " Belok");
    }

    public void berhenti(){
        System.out.println(this.merk + " " + this.platNomor+ " Berhenti");
    }

    public void ceksupir(){
        System.out.println("Supir di kendaraan ini bernama " + this.supir.nama + " dengan no sim: " + this.supir.no_sim);
    }   
}

class bus extends kendaraan{
    int isToilet;

    public bus(String pn, String m, int max, int isToilet){
        super(pn, m, max);
        this.isToilet = isToilet;
    }

    public void cekToilet() {
        if (isToilet == 1) {
            System.out.println("Bus ini memiliki toilet.");
        } else {
            System.out.println("Bus ini tidak memiliki toilet.");
        }
    }

    // public void penumpangNaik(String namaPenumpang) {
    //     super.penumpangNaik(namaPenumpang);
    // }

    public void cekDaftarPenumpang() {
        System.out.println("Daftar Nama Penumpang di Bus " + merk + " " + platNomor + ":");
        for (int i = 0; i <= indexPenumpang; i++) {
            System.out.println((i+1) + ". " + daftarPenumpang[i].nama);
        }
    }
}

class truk extends kendaraan {
    int kapasitasMuatan;

    public truk(String pn, String m, int max){
        super(pn, m, max);
    }

    public void setKapasitas(int kapasitas){
        this.kapasitasMuatan = kapasitas;
    }

    public void cekMuatan() {
        System.out.println("Kapasitas muatan truk ini adalah: " + kapasitasMuatan + " ton.");
    }

    public void cekDaftarPenumpang() {
        System.out.println("Daftar Nama Penumpang di Truk " + merk + " " + platNomor + ":");
        for (int i = 0; i <= indexPenumpang; i++) {
            System.out.println((i+1) + ". " + daftarPenumpang[i].nama);
        }
    }
}

class driver {
    public String no_sim;
    public String nama;
}

class penumpang {
    public String nama;

    public penumpang(String nama) {
        this.nama = nama;
    }
}

public class App {
    public static void main(String[] args) {
        int pilihan = 0;      

        bus b1 = new bus("AE 6365 YZ", "Mercedes", 8, 1);
        b1.cekToilet();

        driver s2 = new driver();
        s2.nama = "Suprianto";
        s2.no_sim = "621823";
        b1.supir = s2;
        b1.ceksupir();

        Scanner scan = new Scanner(System.in);
        while (pilihan != 4) {
        // Menampilkan menu
        System.out.println("Menu:");
        System.out.println("1. Naik");
        System.out.println("2. Turun");
        System.out.println("3. Cek Penumpang");
        System.out.println("4. Keluar");
        
        // Meminta input dari pengguna
        System.out.print("Pilih menu (masukkan angka): ");
        pilihan = scan.nextInt();
        scan.nextLine();
        
        // Proses pemilihan menu
        switch (pilihan) {
            case 1:
            System.out.println("Ada nama?(true/false)");
            Boolean adaNama = scan.nextBoolean();
            scan.nextLine();
            if (adaNama) {
                System.out.print("masukkan nama: ");
                String namaPenumpang = scan.nextLine();
                b1.penumpangNaik(namaPenumpang);
            } else {     
                System.out.println("Berapa jumlah penumpang naik?");
                System.out.print("masukkan angka: ");
                int naik = scan.nextInt();
                b1.penumpangNaik(naik);
            }
                break;
            case 2:
                System.out.println("Berapa jumlah penumpang turun?");
                System.out.print("masukkan angka: ");
                int turun = scan.nextInt();
                b1.penumpangTurun(turun);
                break;
            case 3:
                b1.cekPenumpang();
                b1.cekDaftarPenumpang();
                break;
            case 4:
                System.out.println("Terima kasih. Program berhenti.");
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
        }
        }
        
        scan.close();

    }
}