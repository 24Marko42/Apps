package org.example.work_work;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WordSwitcher extends Application {
    public TextField field1;
    public Button switchButton;
    public TextField field2;
    // Переменная для отслеживания направления переключения (из первого во второе или наоборот)
    private boolean isLeftToRight = true;

    @Override
    public void start(Stage primaryStage) {
        // Инициализация полей класса
        field1 = new TextField();
        field1.setPromptText("Писать сюда, там не пишется");

        field2 = new TextField();
        field2.setPromptText("Тут не писать, здесь появится");
        field2.setEditable(false); // Второе поле недоступно для ввода по умолчанию

        switchButton = new Button("туда"); // Изначально кнопка указывает направление "вправо"

        // Обработчик события нажатия кнопки
        switchButton.setOnAction(event -> {
            if (isLeftToRight) {
                // Перенос текста из первого поля во второе
                field2.setText(field1.getText());
                field1.clear(); // Очистка первого поля
                field2.setEditable(true); // Делает второе поле доступным для редактирования
                field1.setEditable(false); // Блокирует первое поле
                field1.setPromptText("Тут не писать, здесь появится");
                field2.setPromptText("Писать сюда, там не пишется");
                switchButton.setText("сюда"); // Меняет направление стрелки
            } else {
                // Перенос текста из второго поля в первое
                field1.setText(field2.getText());
                field2.clear(); // Очистка второго поля
                field1.setEditable(true); // Делает первое поле доступным для редактирования
                field2.setEditable(false); // Блокирует второе поле
                field2.setPromptText("Тут не писать, здесь появится");
                field1.setPromptText("Писать сюда, там не пишется");
                switchButton.setText("туда"); // Меняет направление стрелки
            }
            // Меняем направление переключения
            isLeftToRight = !isLeftToRight;
        });

        // Размещение компонентов в вертикальном контейнере
        VBox layout = new VBox(20, field1, switchButton, field2); // Расстояние между элементами - 20 пикселей

        // Создание сцены
        Scene scene = new Scene(layout);

        // Настройка основного окна
        primaryStage.setScene(scene); // Устанавливается сцена на основное окно.
        primaryStage.setTitle("Перекидыватель слов");
        primaryStage.setMinWidth(300); // Устанавливает минимальную ширину окна
        primaryStage.setMinHeight(300); // Устанавливает минимальную высоту окна
        primaryStage.show(); // Отображается основное окно на экране.
    }

    public static void main(String[] args) {
        launch(args); // Запуск JavaFX-приложения
    }
}
