package org.example.work_work;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class calc extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Загрузка FXML-файла
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/work_work/calc.fxml"));

        // Настройка сцены и окна
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Калькулятор");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Запуск JavaFX-приложения
    }
}
