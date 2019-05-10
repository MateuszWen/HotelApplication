package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservationV2 extends Reservation{

    private static final int PRICE_DAY = 80;
    private SimpleIntegerProperty beds;
    private SimpleIntegerProperty daysOfStay;
    private SimpleDoubleProperty cost;

    public ReservationV2(SimpleIntegerProperty room, SimpleStringProperty guestName, SimpleStringProperty guestSurname, SimpleStringProperty checkInDateString, SimpleStringProperty checkOutDateString,
                         SimpleIntegerProperty reservationNumber, SimpleIntegerProperty beds, SimpleDoubleProperty cost) {
        super(room, guestName, guestSurname, checkInDateString, checkOutDateString, reservationNumber);
        this.beds = beds;
        this.cost = cost;
    }

    public ReservationV2(Integer room, String guestName, String guestSurname, String checkInDateString, String checkOutDateString, Integer reservationNumber, Integer beds) {
        super(room, guestName, guestSurname, checkInDateString, checkOutDateString, reservationNumber);
        this.beds = new SimpleIntegerProperty(beds);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); //formater is necessary to format from String to Date, bacause Java can't take Date format in constructor - in this case, only String
            try {
                Date checkInDate = formatter.parse(checkInDateString);
                Date checkOutDate = formatter.parse(checkOutDateString);
                long timeLong = checkOutDate.getTime() - checkInDate.getTime();
                long daysLong = TimeUnit.DAYS.convert(timeLong, TimeUnit.MILLISECONDS);
                Integer daysOfStay = (int) (long) daysLong;
                this.daysOfStay = new SimpleIntegerProperty(daysOfStay); // <-- daysOfStay
                this.cost = new SimpleDoubleProperty(daysOfStay * beds * PRICE_DAY);  //<-- cost
            } catch (ParseException e) {e.printStackTrace();}
    }



    public int getBeds() {
        return beds.get();
    }

    public SimpleIntegerProperty bedsProperty() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds.set(beds);
    }

    public int getDaysOfStay() {
        return daysOfStay.get();
    }

    public SimpleIntegerProperty daysOfStayProperty() {
        return daysOfStay;
    }

    public void setDaysOfStay(int daysOfStay) {
        this.daysOfStay.set(daysOfStay);
    }

    public double getCost() {
        return cost.get();
    }

    public SimpleDoubleProperty costProperty() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost.set(cost);
    }



}
