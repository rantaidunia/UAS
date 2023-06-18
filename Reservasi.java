public abstract class Reservasi {
    private int id;
    private String room;
    
    public Reservasi(){

    }

    public Reservasi(int id, String room){
        this.id = id;
        this.room = room;
    }

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

    

}
