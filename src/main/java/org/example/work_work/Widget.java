package org.example.work_work;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Widget extends Application {
    public Label widget1;
    public Label widget2;
    public Label widget3;
    public CheckBox check1;
    public CheckBox check2;
    public CheckBox check3;

    @Override
    public void start(Stage primaryStage) {
        // Создаем три виджета (в данном случае это метки)
        Label widget1 = new Label("Виджет 1");
        Label widget2 = new Label("Виджет 2");
        Label widget3 = new Label("Виджет 3");

        // Создаем чекбоксы для управления видимостью виджетов
        CheckBox check1 = new CheckBox("Показать/Скрыть Виджет 1");
        CheckBox check2 = new CheckBox("Показать/Скрыть Виджет 2");
        CheckBox check3 = new CheckBox("Показать/Скрыть Виджет 3");

        // Устанавливаем начальное состояние чекбоксов (все виджеты видимы)
        check1.setSelected(true);
        check2.setSelected(true);
        check3.setSelected(true);

        // Обработчики для управления видимостью
        check1.setOnAction(event -> widget1.setVisible(check1.isSelected()));
        check2.setOnAction(event -> widget2.setVisible(check2.isSelected()));
        check3.setOnAction(event -> widget3.setVisible(check3.isSelected()));

        // Размещение элементов в вертикальном контейнере
        VBox layout = new VBox(30, widget1, widget2, widget3, check1, check2, check3);

        // Настройка сцены и окна
        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Скрытие виджетов");
        primaryStage.show();
        primaryStage.setMinWidth(300); // Устанавливает минимальную ширину окна
        primaryStage.setMinHeight(300); // Устанавливает минимальную высоту окна
    }

    public static void main(String[] args) {
        launch(args);
    }
}
