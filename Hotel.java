import java.util.ArrayList;
import java.util.Scanner;

public class Hotel extends Reservasi {
    
    public static ArrayList<Data> data = new ArrayList<>();
    public static ArrayList<Reservasi> rooms = new ArrayList<>();

    public void addHotel(Data hotel){
        if (!isHotelIdExist(hotel.id)) {
            Hotel.data.add(hotel);
            System.out.println("Hotel has been added");
        } else {
            System.out.println("Hotel with ID " + hotel.id + " already exists");
        }
    }

    public void deleteHotel(int hotelId) {
    Data hotel = getHotelById(hotelId);
    if (hotel != null) {
        Hotel.data.remove(hotel);
        System.out.println("Hotel with ID " + hotelId + " has been deleted");

        // Remove rooms associated with the deleted hotel
        ArrayList<Reservasi> roomsToRemove = new ArrayList<>();
        for (Reservasi room : Hotel.rooms) {
            if (room.getId() == hotelId) {
                roomsToRemove.add(room);
            }
        }
        Hotel.rooms.removeAll(roomsToRemove);

        System.out.println("Rooms associated with Hotel ID " + hotelId + " have been removed");
    } else {
        System.out.println("Hotel with ID " + hotelId + " does not exist");
    }
}


    public Boolean isHotelIdExist(int id) {
        Boolean isExist = false;
        for (Data hotel : Hotel.data) {
          if (hotel.id == id) {
            isExist = true;
          }
        }
        return isExist;
    }

    public void addRoom(Reservasi room) {
    if (!isRoomnameExist(room.getRoom(), room.getId())) {
        Hotel.rooms.add(room);
        System.out.println("Room added successfully.");
    } else {
        System.out.println("Room with name " + room.getRoom() + " already exists for hotel ID " + room.getId() + ".");
    }
}

    public Boolean isRoomnameExist(String roomname, int hotelId) {
    Boolean isExist = false;
    for (Reservasi room : Hotel.rooms) {
        if (room.getId() == hotelId && room.getRoom().equals(roomname)) {
            isExist = true;
            break;
        }
    }
    return isExist;
}

      public void reservasi(int hotelId, String roomname) {
    Reservasi room = this.getRoomByname(roomname, hotelId);
    if (room != null) {
        Hotel.rooms.remove(room);
        Data hotel = this.getHotelById(hotelId);
        if (hotel != null) {
            hotel.reserve(room);
            System.out.println("Room reserved successfully.");
        } else {
            System.out.println("Hotel with ID " + hotelId + " does not exist.");
        }
    } else {
        System.out.println("Room with name " + roomname + " does not exist.");
    }
}

    public void editHotel(int hotelId) {
        Data hotel = getHotelById(hotelId);
        if (hotel != null) {
            Scanner scan = new Scanner(System.in);

            System.out.println("Editing Hotel with ID " + hotelId);

            System.out.print("New name: ");
            hotel.nama = scan.nextLine();

            System.out.print("New room type: ");
            hotel.tipeKamar = scan.nextLine();

            System.out.print("New restaurant: ");
            hotel.restaurant = scan.nextLine();

            System.out.print("New service: ");
            hotel.service = scan.nextLine();

            System.out.print("New total room: ");
            hotel.jumlahKamar = scan.nextInt();

            System.out.print("New price per night: ");
            hotel.biayaPenginapan = scan.nextInt();

            System.out.println("Hotel with ID " + hotelId + " has been edited");
        } else {
            System.out.println("Hotel with ID " + hotelId + " does not exist");
        }
    }
    
    private Data getHotelById(int id) {
      for (Data hotel : Hotel.data) {
        if (hotel.id == id) {
          return hotel;
        }
      }
      return null;
    }

    private Reservasi getRoomByname(String roomname, int hotelId) {
    for (Reservasi room : Hotel.rooms) {
        if (room.getId() == hotelId && room.getRoom().equals(roomname)) {
            return room;
        }
    }
    return null;
}

public void showReservedRooms() {
    System.out.println("Reserved Rooms:");
    for (Data hotel : data) {
        System.out.println("Hotel ID: " + hotel.id);
        for (Reservasi room : hotel.reserved) {
            System.out.println("Room: " + room.getRoom());
            System.out.println("--------------------------");
        }
        System.out.println();
    }
}

    
}
