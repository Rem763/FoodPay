package com.quest.scene;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TitleController extends BaseSceneController {
    @FXML
    private Label titleLabel;
    @FXML
    private Button continueButton;
    @FXML
    private ImageView backgroundImage;

    @FXML
    private void initialize() {
        if (titleLabel != null) {
            titleLabel.setText("数字闯关");
        }
        if (backgroundImage != null) {
            var url = getClass().getResource("/sprites/title_bg.png");
            if (url != null) {
                backgroundImage.setImage(new Image(url.toExternalForm()));
            }
        }
    }

    @Override
    public void setSceneManager(SceneManager sceneManager) {
        super.setSceneManager(sceneManager);
        if (continueButton != null && sceneManager != null) {
            continueButton.setDisable(!sceneManager.hasSave());
        }
    }

    @FXML
    private void goToMap() {
        if (sceneManager == null) {
            return;
        }
        sceneManager.newGame();
        sceneManager.switchTo(SceneType.MAP);
    }

    @FXML
    private void continueGame() {
        if (sceneManager == null) {
            return;
        }
        if (sceneManager.loadGame()) {
            sceneManager.switchTo(SceneType.MAP);
        }
    }
}
