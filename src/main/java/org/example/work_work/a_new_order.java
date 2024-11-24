package org.example.work_work;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class a_new_order extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Создаем чекбоксы для выбора блюд
        CheckBox pizza = new CheckBox("Пицца - 500 руб.");
        CheckBox sushi = new CheckBox("Суши - 300 руб.");
        CheckBox burger = new CheckBox("Бургер - 200 руб.");

        // Поля для ввода количества порций
        TextField pizzaQuantity = new TextField("1");
        TextField sushiQuantity = new TextField("1");
        TextField burgerQuantity = new TextField("1");

        // Делаем поля количества активными только при выборе блюда
        pizzaQuantity.setDisable(true);
        sushiQuantity.setDisable(true);
        burgerQuantity.setDisable(true);

        pizza.setOnAction(event -> pizzaQuantity.setDisable(!pizza.isSelected()));
        sushi.setOnAction(event -> sushiQuantity.setDisable(!sushi.isSelected()));
        burger.setOnAction(event -> burgerQuantity.setDisable(!burger.isSelected()));

        // Текстовое поле для отображения чека
        TextArea receipt = new TextArea();
        receipt.setEditable(false);

        // Кнопка для расчета стоимости
        Button calculate = new Button("Посчитать");

        calculate.setOnAction(event -> {
            double total = 0;
            StringBuilder receiptText = new StringBuilder("Ваш заказ:\n");

            if (pizza.isSelected()) {
                int qty = Integer.parseInt(pizzaQuantity.getText());
                double cost = 500 * qty;
                total += cost;
                receiptText.append("Пицца: ").append(qty).append(" шт. = ").append(cost).append(" руб.\n");
            }
            if (sushi.isSelected()) {
                int qty = Integer.parseInt(sushiQuantity.getText());
                double cost = 300 * qty;
                total += cost;
                receiptText.append("Суши: ").append(qty).append(" шт. = ").append(cost).append(" руб.\n");
            }
            if (burger.isSelected()) {
                int qty = Integer.parseInt(burgerQuantity.getText());
                double cost = 200 * qty;
                total += cost;
                receiptText.append("Бургер: ").append(qty).append(" шт. = ").append(cost).append(" руб.\n");
            }

            receiptText.append("Итого: ").append(total).append(" руб.");
            receipt.setText(receiptText.toString());
        });

        // Размещение элементов в вертикальном контейнере
        VBox layout = new VBox(10, pizza, pizzaQuantity, sushi, sushiQuantity, burger, burgerQuantity, calculate, receipt);

        // Настройка сцены и окна
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Заказ в ресторане");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
