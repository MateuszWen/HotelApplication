package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private TableView<Reservation> table;
    @FXML private TableColumn <Reservation, Integer> col_room;
    @FXML private TableColumn <Reservation, String> col_name;
    @FXML private TableColumn <Reservation, String> col_surname;
    @FXML private TableColumn <Reservation, String> col_checkin;
    @FXML private TableColumn <Reservation, String> col_checkout;
    @FXML private TableColumn <Reservation, String> col_reservationNumber;


    public ObservableList<Reservation> reservations_list = FXCollections.observableArrayList(
            new Reservation(123, "John", "Johnowski", "12-05-1998", "15-05-1998", 1),
            new Reservation(321, "Andrzej", "Adamowski", "11-05-1998", "12-05-1998", 2),
            new Reservation(432, "Jola", "Jolowska", "12-06-1998", "16-06-1998", 3),
            new Reservation(231, "Jan", "Janowski", "06-07-1998", "15-07-1998", 4)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources){
        col_name.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Name"));
        col_surname.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Surname"));
        col_room.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("Room"));
        col_checkin.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Check In"));
        col_checkout.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Check Out"));
        col_reservationNumber.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Reservation Number"));
        table.setItems(reservations_list);

    }


}
