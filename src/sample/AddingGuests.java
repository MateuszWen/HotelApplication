package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AddingGuests {

    public static ObservableList<Reservation> functionAddingGuests(){


        ObservableList<Reservation> list = FXCollections.observableArrayList();
            for(int i = 0; i<=250; i++) {
                list.add(new ReservationV2(getRoomNumber(), getNameAdding(), getSurnameAdding(), getCheckInDate(), getCheckOutDate(), getReservationNumber(), getNumberOfBeds()));
            }


        return list;

    }


    public static String getNameAdding() {
        Random rand = new Random();
        int number = rand.nextInt(2) + 1;
        int draw = rand.nextInt(50) + 1;

        File file = null;
        String name = null;
            if(number%2 == 0)
            {
                 file = new File("first-f.txt");
            }
            else
            {
                 file = new File("first-m.txt");
            }

//        BufferedReader reader = null;
//        try (){
//            reader = new BufferedReader(new FileReader(file));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        try (Scanner sc = new Scanner(file)) {
            for (int i = 0; i < draw; i++) {
                name = sc.next();
            }
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return name;
    }

    public static String getSurnameAdding() {
        Random rand = new Random();
        int draw = rand.nextInt(50) + 1;
        String surname = null;

        File file = new File("last.txt");
            try (Scanner sc = new Scanner(file)) {
                for(int i=0; i<=draw; i++){
                    surname = sc.nextLine();
                }
                sc.close();
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
        return surname;
    }

    public static int getRoomNumber(){
        Random rand = new Random();
        return rand.nextInt(998) + 1;
    }


//    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
//    public static Date dateHelp;
//    {
//        try {
//            dateHelp = sdf.parse("01-01-2017");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

    public static String getCheckInDate(){
        Random rand = new Random();

        int month = rand.nextInt(12) + 1;

        int day;
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = rand.nextInt(31) + 1;
        } else if(month == 2){
            day = rand.nextInt(29) + 1;
        } else{
            day = rand.nextInt(30) + 1;
        }

        int year = rand.nextInt(10) + 2015;

        String checkInDateString = day + "-" + month + "-" + year;
        dateHelp = checkInDateString;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date data = sdf.parse(checkInDateString);
            checkInDateString = sdf.format(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return checkInDateString;

    }

    public static String dateHelp ;

    public static String getCheckOutDate(){
        Random rand = new Random();
        int days = rand.nextInt(10) + 1;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(dateHelp));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, days);
        String newDate = sdf.format(cal.getTime());

        return newDate;
    }

    public static int getNumberOfBeds(){
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

    public static int getReservationNumber(){
      Random rand = new Random();
      int reservationNumber = rand.nextInt(5000) + 1000;
      return reservationNumber;
    };



}
