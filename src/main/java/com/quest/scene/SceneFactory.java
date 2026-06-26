package com.quest.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneFactory {
    private final SceneManager sceneManager;

    public SceneFactory(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public Scene create(SceneType type) {
        try {
            java.net.URL fxmlUrl = getClass().getResource(getFxmlPath(type));
            if (fxmlUrl == null) {
                throw new IllegalStateException("FXML resource not found: " + getFxmlPath(type));
            }
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();
            Object controller = loader.getController();
            if (controller instanceof SceneAware aware) {
                aware.setSceneManager(sceneManager);
            }
            Scene scene = new Scene(root, 1280, 720);
            java.net.URL cssUrl = getClass().getResource("/css/style.css");
            if (cssUrl != null) {
                scene.getStylesheets().add(cssUrl.toExternalForm());
            }
            return scene;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load scene: " + type, e);
        }
    }

    private String getFxmlPath(SceneType type) {
        return switch (type) {
            case TITLE -> "/fxml/title.fxml";
            case MAP -> "/fxml/map.fxml";
            case BATTLE -> "/fxml/battle.fxml";
            case RESULT -> "/fxml/result.fxml";
        };
    }
}
