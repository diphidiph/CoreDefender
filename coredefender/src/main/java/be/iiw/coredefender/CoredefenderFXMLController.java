package be.iiw.coredefender;

import be.iiw.coredefender.character.CharacterModel;
import be.iiw.coredefender.character.CharacterView;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import static javafx.scene.input.KeyCode.LEFT;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

public class CoredefenderFXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane character_pane;

    @FXML
    private Text coordinates;

    @FXML
    private Text item_gold;

    @FXML
    private Text item_stone;

    @FXML
    private Text item_wood;
    
    @FXML
    private HBox overlay_hbox;

    @FXML
    private Button overlay_attack;

    @FXML
    private Button overlay_build;

    @FXML
    private Button overlay_level;

    @FXML
    private Button overlay_shop;
    
    private CharacterModel model;
    private CharacterView view;

    @FXML
    void initialize() {
        overlay_attack.setOnAction(e -> character_pane.requestFocus());
    overlay_build.setOnAction(e -> character_pane.requestFocus());
    overlay_level.setOnAction(e -> character_pane.requestFocus());
    overlay_shop.setOnAction(e -> character_pane.requestFocus());
        overlay_attack.setGraphic(createIcoon("M13 .5c0-.276-.226-.506-.498-.465-1.703.257-2.94 2.012-3 8.462a.5.5 0 0 0 .498.5c.56.01 1 .13 1 1.003v5.5a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5z"));
        overlay_build.setGraphic(createIcoon("M15.528 2.973a.75.75 0 0 1 .472.696v8.662a.75.75 0 0 1-.472.696l-7.25 2.9a.75.75 0 0 1-.557 0l-7.25-2.9A.75.75 0 0 1 0 12.331V3.669a.75.75 0 0 1 .471-.696L7.443.184l.01-.003.268-.108a.75.75 0 0 1 .558 0l.269.108.01.003zM10.404 2 4.25 4.461 1.846 3.5 1 3.839v.4l6.5 2.6v7.922l.5.2.5-.2V6.84l6.5-2.6v-.4l-.846-.339L8 5.961 5.596 5l6.154-2.461z"));
        overlay_level.setGraphic(createIcoon("M7.27 1.047a1 1 0 0 1 1.46 0l6.345 6.77c.6.638.146 1.683-.73 1.683H11.5v1a1 1 0 0 1-1 1h-5a1 1 0 0 1-1-1v-1H1.654C.78 9.5.326 8.455.924 7.816zM4.5 13.5a1 1 0 0 1 1-1h5a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1h-5a1 1 0 0 1-1-1z"));
        overlay_shop.setGraphic(createIcoon("M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1m3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4z"));
        
        model = new CharacterModel();
        view = new CharacterView(model);
        character_pane.getChildren().add(view);
        character_pane.setOnKeyPressed(this::moveKeyboard);
        character_pane.setFocusTraversable(true);
        
        Timer t = new Timer(true);
        CharacterAnimator animator = new CharacterAnimator(model, this);
        t.scheduleAtFixedRate(animator, 1000, 30);
    }
    
    private SVGPath createIcoon(String data) {
        SVGPath svg = new SVGPath();
        svg.setContent(data);
        svg.setFill(Color.WHITE);
        svg.setScaleX(1.2);
        svg.setScaleY(1.2);
        return svg;
    }

    private void moveKeyboard(KeyEvent t) {
        switch (t.getCode()) {
            case A:
                model.links();
                break;
            
            case D:
                model.rechts();
                break;
                
            case W:
                model.boven();
                break;
                
            case S:
                model.onder();
                break;
        }
        view.update();
    }
    
    public void update() {
        view.update();
    }
}
