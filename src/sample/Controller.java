package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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

    public static ObservableList<Reservation> reservations_list =  AddingGuests.functionAddingGuests();

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


    public void button_addClicked(ActionEvent actionEvent) throws IOException {
//        Parent root = null;
//        try {                                                                               //    <-- this lines open a new addWindow
        Parent root = FXMLLoader.load(getClass().getResource("AddWindow.fxml"));        //
//        } catch (IOException e) {                                                           //
//            e.printStackTrace();                                                            //
//        }                                                                                   //
        Stage stage = new Stage();                                                       //
        stage.setTitle("Add Reservation");                                             //
        stage.setScene(new Scene(root, 1000, 200));                        //
        stage.show();                                                                    //

        }

}
