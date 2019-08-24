package CandyGift.Main;

import CandyGift.Interface.Box;
import CandyGift.Interface.CanDo;
import CandyGift.Sweets.*;

public class MainClass {
    public static void main(String[] args) {
        CanDo box = new Box();
       System.out.println(box.getTotalWeight());

       box.add(new Cake("Prague", 615.9, 599, "Содержит алкоголь."));
        box.remove();
        box.add(new Cake("Prague", 615.9, 599, "Содержит алкоголь."));

/*
        box.add(new Cake("Prague", 615.9, 599, "Содержит алкоголь."));
        box.add(new Cake("Tiramisu", 700.6, 699, "Основа - бисквит."));
        box.add(new Candy("Raffaello", 152.2, 215, "Вкус детства."));
        box.add(new Candy("Toffifee", 125.0, 130, "Дешево и сердито."));
        box.add(new IceCream("Movenpick vanilla", 500.00, 609, "Большая упаковка."));
        box.add(new Jellybean("Jellybean", 40.40, 40, "Что-то интересное."));
        box.add(null);

        System.out.println("Общий вес подарка: " + box.getTotalWeight() + " г");
        System.out.println("Общая стоимость подарка: " + box.getTotalPrice() + " руб");
        box.getAllInfo();
*/


        box.reducePrice(800);
       // box.reduceWeight(100.0);

        int n = 0; //сколько удаляем элементов
        for (int i = 0; i < n; i++) {

            box.remove();
        }


        box.getAllInfo();
        box.remove(-1);
        box.getAllInfo();

    }
}