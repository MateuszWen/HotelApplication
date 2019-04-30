package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.text.ParseException;

public class AddWindow {

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

    public void button_OKClicked(ActionEvent actionEvent) {

        boolean bool_room, bool_beds = false;

        do {
            bool_room = AddingGuests.isParsable(textField_room.getText());
            bool_beds = AddingGuests.isParsable(textField_room.getText());

            if(bool_room != true || bool_beds != true){
                JOptionPane.showMessageDialog(null, "Wrong data provided", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }while(bool_room != true && bool_beds != true);   //   <--- infinite loops

        Controller.reservations_list.add(new ReservationV2(Integer.parseInt(textField_room.getText()), textField_name.getText(), textField_surname.getText(), textField_checkIn.getText(),
                textField_checkOut.getText(), AddingGuests.getReservationNumber(), Integer.parseInt(textField_beds.getText())));

    }

}
