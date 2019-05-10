package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private TableView<ReservationV2> table;
    @FXML private TableColumn <ReservationV2, String> col_name;
    @FXML private TableColumn <ReservationV2, String> col_surname;
    @FXML private TableColumn <ReservationV2, Integer> col_room;
    @FXML private TableColumn <ReservationV2, Integer> col_beds;
    @FXML private TableColumn <ReservationV2, String> col_checkin;
    @FXML private TableColumn <ReservationV2, String> col_checkout;
    @FXML private TableColumn <ReservationV2, Integer> col_daysOfStay;
    @FXML private TableColumn <ReservationV2, Double> col_cost;
    @FXML private TableColumn <ReservationV2, Integer> col_reservationNumber;

    public static ObservableList<ReservationV2> reservations_list =  AddingGuests.functionAddingGuests();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        col_name.setCellValueFactory(new PropertyValueFactory<ReservationV2, String>("guestName"));
        col_surname.setCellValueFactory(new PropertyValueFactory<ReservationV2, String>("guestSurname"));
        col_room.setCellValueFactory(new PropertyValueFactory<ReservationV2, Integer>("room"));
        col_beds.setCellValueFactory(new PropertyValueFactory<ReservationV2, Integer>("beds"));
        col_checkin.setCellValueFactory(new PropertyValueFactory<ReservationV2, String>("checkInDate"));
        col_checkout.setCellValueFactory(new PropertyValueFactory<ReservationV2, String>("checkOutDate"));
        col_daysOfStay.setCellValueFactory(new PropertyValueFactory<ReservationV2, Integer>("daysOfStay"));
        col_cost.setCellValueFactory(new PropertyValueFactory<ReservationV2, Double>("cost"));
        col_reservationNumber.setCellValueFactory(new PropertyValueFactory<ReservationV2, Integer>("reservationNumber"));
        table.setItems(reservations_list);

    }


    public void button_addClicked(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AddWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Add Reservation");
        stage.setScene(new Scene(root, 1000, 200));
        stage.show();

        }

    public void buttonRemove(ActionEvent event){
        Reservation reservation = table.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Attention!");
        alert.setHeaderText("You just want to delete the reservation.");
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            table.getItems().remove(reservation);
        } else {
            //do nothink
        }
    }

    public static ReservationV2 reservation;
    public static Stage stageEdit = new Stage(); // static declaration to make stageEdit.close() possible <-- in EditWindow
    public void buttonEdit(ActionEvent event) throws IOException {
        reservation = table.getSelectionModel().getSelectedItem();

        //EditWindow editedWindow = new EditWindow();

        Parent root = FXMLLoader.load(getClass().getResource("EditWindow.fxml"));
        stageEdit.setTitle("Edit Reservation");
        stageEdit.setScene(new Scene(root, 1100, 200));
        stageEdit.show();

    }






}
