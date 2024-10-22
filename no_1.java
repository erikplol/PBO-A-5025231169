class Mobil {
    String merk;
    String warna;
    boolean sedangBergerak;
 
    Mobil(String merk, String warna) {
        this.merk = merk;
        this.warna = warna;
        this.sedangBergerak = false;
    }
 
    void tampilkanDetail() {
        System.out.println("Merk: " + merk + ", Warna: " + warna);
    }
 
    void mulaiBergerak() {
        if (!sedangBergerak) {
            sedangBergerak = true;
            System.out.println(merk + " mulai bergerak.");
        } else {
            System.out.println(merk + " sudah bergerak.");
        }
    }
}
 
public class no_1 {
    public static void main(String[] args) {
        Mobil mobil1 = new Mobil("Toyota", "Merah"); 
        mobil1.tampilkanDetail();
        mobil1.mulaiBergerak();
    }
}