package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditWindow implements Initializable {
    @FXML
    private TextField textField_name;
    @FXML
    private TextField textField_surname;
    @FXML
    private TextField textField_room;
    @FXML
    private TextField textField_beds;
    @FXML
    private TextField textField_checkIn;
    @FXML
    private TextField textField_checkOut;

    @Override //it is useful for determining the initial parameters of TextFields
    public void initialize(URL location, ResourceBundle resources) {
        textField_name.setText(Controller.reservation.getGuestName());
        textField_surname.setText(Controller.reservation.getGuestSurname());
        textField_room.setText(Integer.toString(Controller.reservation.getRoom()));
        textField_beds.setText(Integer.toString(Controller.reservation.getBeds()));
        textField_checkIn.setText(Controller.reservation.getCheckInDate());
        textField_checkOut.setText(Controller.reservation.getCheckOutDate());

    }

    public void button_EditClicked(ActionEvent event) {
        Controller.reservation.setGuestName(textField_name.getText());
        Controller.reservation.setGuestSurname(textField_surname.getText());
        Controller.reservation.setRoom(Integer.parseInt(textField_room.getText()));
        Controller.reservation.setBeds(Integer.parseInt(textField_beds.getText()));
        Controller.reservation.setCheckInDate(textField_checkIn.getText());
        Controller.reservation.setCheckOutDate(textField_checkOut.getText());
        Controller.stageEdit.close();
    }


}
