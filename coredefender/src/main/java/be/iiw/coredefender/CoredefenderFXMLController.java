package be.iiw.coredefender;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class CoredefenderFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text coordinates;

    @FXML
    private Text item_gold;

    @FXML
    private Text item_stone;

    @FXML
    private Text item_wood;

    @FXML
    private Button overlay_attack;

    @FXML
    private Button overlay_build;

    @FXML
    private Button overlay_level;

    @FXML
    private Button overlay_shop;

    @FXML
    void initialize() {
        
    }

}
