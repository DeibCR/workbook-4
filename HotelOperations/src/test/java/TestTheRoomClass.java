import com.pluralsight.hotelOperations.Room;

public class TestTheRoomClass {
    public static void main(String[] args) {
        Room r= new Room(1,99.99);

        ///System.out.println(r);
        if (r.isAvailable())
            System.out.println("The Room is  available");
    }
}
