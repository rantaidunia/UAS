import java.util.Scanner;

public class Main  {
static Scanner scan = new Scanner(System.in);
  static Hotel hotel = new Hotel();

  public static void main(String[] args) {
    initLibraryData();

    String isContinue = "y";

    while (isContinue.equals("y")) {
        showMenu();
        int selectedMenu = chooseMenu();

        if (selectedMenu == 1) {
          showHotels();
        } else if (selectedMenu == 2) {
          showRooms();
        } else if (selectedMenu == 3) {
          addHotel();
        } else if (selectedMenu == 4) {
          deleteHotel();
        } else if (selectedMenu == 5){
          editHotel();
        } else if (selectedMenu == 6) {
          addRoom();
        } else if (selectedMenu == 7) {
          reserved();
        } else if (selectedMenu == 8) {
          reservedroom();

        } else {
          System.out.println("invalid option");
        }
        System.out.print("continue ? ");
        isContinue = scan.next();
      }
    }

  public static void showMenu() {
     System.out.println("""
                +==========[Hotel Room Reservation Program]==========+
                | No |                                               |
                |----|----------------[Display]----------------------|
                | 1  | Show Hotels list                              |
                | 2  | Show Rooms list                               |
                |----|------------------[CRUD]-----------------------|
                | 3  | Add Hotel                                     |
                | 4  | Delete Hotel                                  |
                | 5  | Edit Hotel                                    |
                | 6  | Add Room                                      |
                |----|--------------[Reservation]--------------------|
                | 7  | Reserve Room                                  |
                | 8  | Show Reserved Rooms                           |
                |----|                                               |
                +====================================================+
                """);
  }

  public static void initLibraryData() {
    Data hotel1 = new Data();
    hotel1.id = 1;
    hotel1.nama = "Hotel pop bali";
    hotel1.tipeKamar = "Vip suite";
    hotel1.restaurant = "nasi padang";
    hotel1.service = "24 carat phone";
    hotel1.jumlahKamar = 120;
    hotel1.biayaPenginapan = 120000;

    Data hotel2 = new Data();
    hotel2.id = 2;
    hotel2.nama = "Hotel pop bali";
    hotel2.tipeKamar = "Vip suite";
    hotel2.restaurant = "nasi padang";
    hotel2.service = "24 carat phone";
    hotel2.jumlahKamar = 120;
    hotel2.biayaPenginapan = 120000;

    Data hotel3 = new Data();
    hotel3.id = 3;
    hotel3.nama = "Hotel pop bali";
    hotel3.tipeKamar = "Vip suite";
    hotel3.restaurant = "nasi padang";
    hotel3.service = "24 carat phone";
    hotel3.jumlahKamar = 120;
    hotel3.biayaPenginapan = 120000;

    Data hotel4 = new Data(4,"s", "s", "a", "b", 1, 4);
    
    Reservasi room1 = new Hotel();
    room1.setId(1);
    room1.setRoom("A01");

    Reservasi room2 = new Hotel();
    room2.setId(1); 
    room2.setRoom("A02");

    Reservasi room3 = new Hotel();
    room3.setId(1); 
    room3.setRoom("A03");

    Reservasi room12 = new Hotel();
    room12.setId(2);
    room12.setRoom("A01");

    Reservasi room22 = new Hotel();
    room22.setId(2); 
    room22.setRoom("A02");

    Reservasi room32 = new Hotel();
    room32.setId(2); 
    room32.setRoom("A03");

    Reservasi room13 = new Hotel();
    room13.setId(3);
    room13.setRoom("A01");

    Reservasi room23 = new Hotel();
    room23.setId(3); 
    room23.setRoom("A02");

    Reservasi room33 = new Hotel();
    room33.setId(3); 
    room33.setRoom("A03");



    Hotel.data.add(hotel1);
    Hotel.data.add(hotel2);
    Hotel.data.add(hotel3);
    Hotel.data.add(hotel4);

    Hotel.rooms.add(room1);
    Hotel.rooms.add(room2);
    Hotel.rooms.add(room3);

    Hotel.rooms.add(room12);
    Hotel.rooms.add(room22);
    Hotel.rooms.add(room32);

    Hotel.rooms.add(room13);
    Hotel.rooms.add(room23);
    Hotel.rooms.add(room33);
    
  }

  public static int chooseMenu() {
    System.out.print("choose menu : ");
    int pilihan = scan.nextInt();
    return pilihan;
  }

public static void showRooms() {
    System.out.print("Enter hotel ID: ");
    int hotelId = scan.nextInt();

    int index = 1; // Counter variable
  
    for (int i = 0; i < Hotel.rooms.size(); i++) {
        Reservasi room = Hotel.rooms.get(i);
        if (room.getId() == hotelId){
            System.out.println(index + " Room ID: " + room.getId() + " Room Number: " + room.getRoom());
            index++;
        }
    }
}


  public static void showHotels() {
    for (Data hotel : Hotel.data) {
      System.out.println("Hotel id: "+hotel.id);
      System.out.println("Hotel name: "+hotel.nama);
      System.out.println("Hotel room type: "+hotel.tipeKamar);
      System.out.println("Hotel restaurant: "+hotel.restaurant);
      System.out.println("Hotel Service: "+hotel.service);
      System.out.println("Hotel total room: "+hotel.jumlahKamar);
      System.out.println("Price per night: "+hotel.biayaPenginapan);
      System.out.println();
    }
  }

  public static void addRoom(){
    Reservasi room = new Hotel();

      System.out.print("id : ");
      room.setId(scan.nextInt());
  
      System.out.print("room name : ");
      room.setRoom(scan.next());

    hotel.addRoom(room);
  }

  public static void addHotel() {
    Data hotel = new Data();

    System.out.print("id : ");
    hotel.id = scan.nextInt();

    System.out.print("name : ");
    hotel.nama = scan.next();

    System.out.print("room type : ");
    hotel.tipeKamar = scan.next();

    System.out.print("restaurant : ");
    hotel.restaurant = scan.next();

    System.out.print("service : ");
    hotel.service = scan.next();

    System.out.print("total room : ");
    hotel.jumlahKamar = scan.nextInt();

    System.out.print("price per night : ");
    hotel.biayaPenginapan = scan.nextInt();

    Hotel hotelInstance = new Hotel();
    hotelInstance.addHotel(hotel);
}


  public static void reserved() {
    System.out.print("id Hotel : ");
    int HotelId = scan.nextInt();
    
    
    System.out.print("name Room : ");
    String Roomname = scan.next();
    
    hotel.reservasi(HotelId, Roomname);
  }

  public static void reservedroom(){
    hotel.showReservedRooms();
  }
  
  public static void deleteHotel(){
    System.out.print("Enter hotel ID: ");
    int hotelId = scan.nextInt();

    hotel.deleteHotel(hotelId);
  }

  public static void editHotel(){
   System.out.print("Enter hotel ID: ");
    int hotelId = scan.nextInt();

    hotel.editHotel(hotelId); 
  }
 
}

