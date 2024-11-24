package org.example.work_work;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class a_new_order extends Application {
    public TextField pivoQuantity;
    public CheckBox pivo;
    public TextField viskiQuantity;
    public CheckBox soju;
    public TextField sojuQuantity;
    public Button calculate;
    public CheckBox viski;
    public TextArea receipt;

    @Override
    public void start(Stage primaryStage) {
        // Создаем чекбоксы для выбора блюд
        CheckBox pivo = new CheckBox("Пиво - 500 руб.");
        CheckBox viski = new CheckBox("Виски - 300 руб.");
        CheckBox soju = new CheckBox("Соджа - 200 руб.");

        // Поля для ввода количества порций
        TextField pivoQuantity = new TextField("1");
        TextField viskiQuantity = new TextField("1");
        TextField sojuQuantity = new TextField("1");

        // Делаем поля количества активными только при выборе блюда
        pivoQuantity.setDisable(true);
        viskiQuantity.setDisable(true);
        sojuQuantity.setDisable(true);

        pivo.setOnAction(event -> pivoQuantity.setDisable(!pivo.isSelected()));
        viski.setOnAction(event -> viskiQuantity.setDisable(!viski.isSelected()));
        soju.setOnAction(event -> sojuQuantity.setDisable(!soju.isSelected()));

        // Текстовое поле для отображения чека
        TextArea receipt = new TextArea();
        receipt.setEditable(false);

        // Кнопка для расчета стоимости
        Button calculate = new Button("Посчитать");

        pivoQuantity.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 1, change -> {
            String newText = change.getControlNewText();
            return newText.matches("\\d*") ? change : null; //Метод matches проверяет, соответствует ли строка newText регулярному выражению \\d*
        }));
        viskiQuantity.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 1, change -> {
            String newText = change.getControlNewText();
            return newText.matches("\\d*") ? change : null; //Метод matches проверяет, соответствует ли строка newText регулярному выражению \\d*
        }));
        sojuQuantity.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 1, change -> {
            String newText = change.getControlNewText();
            return newText.matches("\\d*") ? change : null; //Метод matches проверяет, соответствует ли строка newText регулярному выражению \\d*
        }));

        calculate.setOnAction(event -> {
            double total = 0;
            StringBuilder receiptText = new StringBuilder("Ваш заказ:\n");

            if (pivo.isSelected()) {
                int skilki = Integer.parseInt(pivoQuantity.getText());
                double cost = 500 * skilki;
                total += cost;
                receiptText.append("pivo: ").append(skilki).append(" шт. = ").append(cost).append(" руб.\n");
            }
            if (viski.isSelected()) {
                int skilki = Integer.parseInt(viskiQuantity.getText());
                double cost = 300 * skilki;
                total += cost;
                receiptText.append("viski: ").append(skilki).append(" шт. = ").append(cost).append(" руб.\n");
            }
            if (soju.isSelected()) {
                int skilki = Integer.parseInt(sojuQuantity.getText());
                double cost = 200 * skilki;
                total += cost;
                receiptText.append("soju: ").append(skilki).append(" шт. = ").append(cost).append(" руб.\n");
            }

            receiptText.append("сколько ты отдашь чтоб умереть от передозировки алкоголя: ").append(total).append(" руб.");
            receipt.setText(receiptText.toString());
        });

        // Размещение элементов в вертикальном контейнере
        VBox layout = new VBox(10, pivo, pivoQuantity, soju, sojuQuantity, viski, viskiQuantity, calculate, receipt);

        // Настройка сцены и окна
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Заказ в ресторане");
        primaryStage.setMinWidth(500); // Устанавливает минимальную ширину окна
        primaryStage.setMinHeight(500); // Устанавливает минимальную высоту окна
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*идея: придумать приложение, которое будет брать твою геолокацию, определять магазины с алкоголем в радиусе
* 500 метров и предоставлять ассортимент алкогольной продукции, тип где можно дешевле купить(use API магазинов(?) ).
* Потом оно будет прокладывать маршрут, тип если нужно закупиться для компании людей, а вкусы у всех разные (пример: я люблю соджу, а она только в кб)*/