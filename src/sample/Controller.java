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
    @FXML private TableColumn <Reservation, String> col_name;
    @FXML private TableColumn <Reservation, String> col_surname;
    @FXML private TableColumn <Reservation, Integer> col_room;
    @FXML private TableColumn <ReservationV2, Integer> col_beds;
    @FXML private TableColumn <Reservation, String> col_checkin;
    @FXML private TableColumn <Reservation, String> col_checkout;
    @FXML private TableColumn <ReservationV2, Integer> col_daysOfStay;
    @FXML private TableColumn <ReservationV2, Double> col_cost;
    @FXML private TableColumn <Reservation, Integer> col_reservationNumber;

    int reservationVariable = 1;

    public ObservableList<Reservation> reservations_list =  AddingGuests.functionAddingGuests();




    @Override
    public void initialize(URL location, ResourceBundle resources){
        col_name.setCellValueFactory(new PropertyValueFactory<Reservation, String>("guestName"));
        col_surname.setCellValueFactory(new PropertyValueFactory<Reservation, String>("guestSurname"));
        col_room.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("room"));
        col_beds.setCellValueFactory(new PropertyValueFactory<ReservationV2, Integer>("beds"));
        col_checkin.setCellValueFactory(new PropertyValueFactory<Reservation, String>("checkInDate"));
        col_checkout.setCellValueFactory(new PropertyValueFactory<Reservation, String>("checkOutDate"));
        col_daysOfStay.setCellValueFactory(new PropertyValueFactory<ReservationV2, Integer>("daysOfStay"));
        col_cost.setCellValueFactory(new PropertyValueFactory<ReservationV2, Double>("cost"));
        col_reservationNumber.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("reservationNumber"));
        table.setItems(reservations_list);

    }


}
