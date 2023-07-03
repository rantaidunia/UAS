public abstract class Reservasi {
    private int id;
    private String room;

    public abstract void addRoom(Reservasi room);

    public void setId(int id){
        this.id = id;
    }

    public void setRoom(String room){
    this.room = room;
    }

    public int getId(){
    return id;
    }

    public String getRoom(){
    return room;
    }
    
    public void addHotel(Data hotel){
        System.out.println("method add hotel");
    }

    

}
