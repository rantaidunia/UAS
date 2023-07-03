import java.util.ArrayList;

class Data{
    
    public int id;
    public String nama;
    public String tipeKamar;
    public String restaurant;
    public String service;
    public int jumlahKamar;
    public int biayaPenginapan;

     public ArrayList<Reservasi> reserved = new ArrayList<>();

     public Data(){

     }

     public Data(int id, String nama, String tipeKamar, String restaurant, String service, int jumlahKamar, int biayaPenginapan){
        this.id = id;
        this.nama = nama;
        this.tipeKamar = tipeKamar;
        this.restaurant = restaurant;
        this.service = service;
        this.jumlahKamar = jumlahKamar;
        this.biayaPenginapan = biayaPenginapan;
     }

     public void reserve(Reservasi room) {
        this.reserved.add(room);
        System.out.println(reserved);
    }
    
    public void unreserve(Reservasi room) {
        this.reserved.remove(room);
    }

    

    
}