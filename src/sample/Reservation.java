package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;

public class Reservation {

    private  SimpleIntegerProperty room;
    private  SimpleStringProperty guestName;
    private  SimpleStringProperty guestSurname;
    private  SimpleStringProperty checkInDate;
    private  SimpleStringProperty checkOutDate;
    private  SimpleIntegerProperty reservationNumber;

    public Reservation(SimpleIntegerProperty room, SimpleStringProperty guestName, SimpleStringProperty guestSurname, SimpleStringProperty checkInDate, SimpleStringProperty checkOutDate, SimpleIntegerProperty reservationNumber) {
        this.room = room;
        this.guestName = guestName;
        this.guestSurname = guestSurname;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.reservationNumber = reservationNumber;
        
    }

    public Reservation(Integer room, String guestName, String guestSurname, String checkInDate, String checkOutDate, Integer reservationNumber) {
        this.room = new SimpleIntegerProperty(room);
        this.guestName = new SimpleStringProperty(guestName);
        this.guestSurname = new SimpleStringProperty(guestSurname);
        this.checkInDate = new SimpleStringProperty(checkInDate);
        this.checkOutDate = new SimpleStringProperty(checkOutDate);
        this.reservationNumber = new SimpleIntegerProperty(reservationNumber);
    }


    public int getRoom() {
        return room.get();
    }

    public SimpleIntegerProperty roomProperty() {
        return room;
    }

    public void setRoom(int room) {
        this.room.set(room);
    }

    public String getGuestName() {
        return guestName.get();
    }

    public void setGuestName(String guestName) {
        this.guestName.set(guestName);
    }

    public SimpleStringProperty guestNameProperty() {
        return guestName;
    }

    public String getGuestSurname() {
        return guestSurname.get();
    }

    public SimpleStringProperty guestSurnameProperty() {
        return guestSurname;
    }

    public void setGuestSurname(String guestSurname) {
        this.guestSurname.set(guestSurname);
    }

    public String getCheckInDate() {
        return checkInDate.get();
    }

    public SimpleStringProperty checkInDateProperty() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate.set(checkInDate);
    }

    public String getCheckOutDate() {
        return checkOutDate.get();
    }

    public SimpleStringProperty checkOutDateProperty() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate.set(checkOutDate);
    }

    public int getReservationNumber() {
        return reservationNumber.get();
    }

    public SimpleIntegerProperty reservationNumberProperty() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber.set(reservationNumber);
    }
}
