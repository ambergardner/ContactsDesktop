package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    ListView list;

    @FXML
    TextField name;

    @FXML
    TextField phone;

    @FXML
    TextField email;


    public void initialize() {
        ObservableList items;
        list.setItems(contacts);
    }

    public void addItem() {
        Contact item = new Contact(name.getText(), phone.getText(), email.getText());
        if (!item.name.isEmpty()) {  /* Don't add a new contact if any of the three fields are blank. */
            contacts.add(item);
            name.setText("");
            phone.setText("");
            email.setText("");
        }
    }

    public void removeItem() {
        ContactsDesktop item = (ContactsDesktop) list.getSelectionModel().getSelectedItem();
        contacts.remove(item);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}