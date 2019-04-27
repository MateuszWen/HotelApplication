package sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {

    private int room;
    private String guestName;
    private String guestSurname;
    private Date checkInDate;
    private Date checkOutDate;
    private int reservationNumber;

    public Reservation(int room, String guestName, String guestSurname, String checkInDateString, String checkOutDateString, int reservationNumber) {
        this.room = room;
        this.guestName = guestName;
        this.guestSurname = guestSurname;
        this.reservationNumber = reservationNumber;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); //formater is necessary to format from String to Date, bacause Java can't take Date format in constructor - in this case, only String
        try {
            Date checkInDate = formatter.parse(checkInDateString);
            Date checkOutDate = formatter.parse(checkOutDateString);
        } catch (ParseException e) {e.printStackTrace();}

        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestSurname() {
        return guestSurname;
    }

    public void setGuestSurname(String guestSurname) {
        this.guestSurname = guestSurname;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
}
