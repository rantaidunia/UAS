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

     public void reserve(Reservasi room) {
        this.reserved.add(room);
        System.out.println(reserved);
    }
    
    public void unreserve(Reservasi room) {
        this.reserved.remove(room);
    }

    public void addHotel(Data hotel){
        System.out.println("method add hotel");
    }

    
}