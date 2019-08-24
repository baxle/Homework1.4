package CandyGift.Interface;


import CandyGift.Comparator.MaxPriceComparator;
import CandyGift.Comparator.MaxWeightComparator;
import CandyGift.Sweets.Sweet;


import java.util.Arrays;
import java.util.Comparator;


/** Класс Box со свойствами <b>N</b>, <b>size</b>.
 *  @author Бакулин Андрей
 */
public class Box implements CanDo {

    private static final int N = 0;
    private static int size = 0;


    private static Sweet[] sweets = new Sweet[N];

    /**
     * Функция добавления объекта класса Sweet в массив sweets.
     */
    public void add(Sweet sweet) {
        if (sweet == null) {
            System.out.println("Вы ввели null");
        } else {
            sweets = Arrays.copyOf(sweets, sweets.length + 1);
            sweets[sweets.length-1] = sweet;
        }
    }





    /**
     * Функция удаления последнего объекта из массива sweets.
     */
   /* public void remove() {
        if (sweets.length > 0) {
            sweets = Arrays.copyOf(sweets, sweets.length - 1);
        } else {

            System.out.println("В массиве нет элементов для удаления");

        }
    }
    */
    public void remove() {
        if (sweets.length > 0) {
            sweets = Arrays.copyOf(sweets, sweets.length - 1);
        } else {

            System.out.println("В массиве нет элементов для удаления");

        }
    }


    /**
     * Функция удаления объекта из массива sweets по индексу.
     * @param index - индекс удаляемого элемента
     */
    public void remove(int index) {
        if (index > sweets.length - 1) {
            System.out.println("Индекс массива слишком большой");
        } else if (index < 0) {
            System.out.println("Индекс массива отрицателен");
        } else {
            Sweet[] anotherSweets = new Sweet[sweets.length - 1];

            for (int i = 0, k = 0; i < sweets.length; i++) {

                if (i == index) {
                    continue;
                }

                anotherSweets[k++] = sweets[i];
            }
            sweets = anotherSweets;
        }


    }

    /**
     * Функция получения значения поля totalWeight
     * @return возвращает суммарный вес всех объектов массива
     */
    public double getTotalWeight() {
        double totalWeight = 0;
        for (int i = 0; i < sweets.length; i++) {
            totalWeight = totalWeight + sweets[i].weight;
        }
        return totalWeight;
    }

    /**
     * Функция получения значения поля totalPrice
     * @return возвращает суммарную стоимость всех объектов массива
     */
    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < sweets.length; i++) {
            totalPrice = totalPrice + sweets[i].price;
        }
        return totalPrice;
    }

    /**
     * Функция выводит на экран каждый элемент массива sweets.
     */
    public void getAllInfo() {
        System.out.println("\nИнформация о всех сладостях в подарке:");
        for (Sweet sweet : sweets) {
            System.out.println(sweet.toString());
        }
        System.out.println(" ");
    }

    /**
     * Функция, удаляющая из массива sweets элементы до тех пор, пока {@link Box#getTotalWeight()} >  @param weight
     */
    public void reduceWeight(double weight) {
        sweets = Arrays.copyOf(sweets, sweets.length);
        double x = getTotalWeight();
        Comparator weightComparator = new MaxWeightComparator();
        Arrays.sort(sweets, weightComparator);
        for (Sweet sweet : sweets) {
            System.out.println(sweet.toString());
        }


        while (x > weight) {
            if (sweets.length == 0) {
                System.out.println("Коробочка пуста");
                break;
            }
            System.out.println("\n Вес коробочки " + x + " больше входного параметра " + weight);
            System.out.println("Удаляем сладость с наименьшим весом " + sweets[sweets.length - 1].weight);
            x = x - sweets[sweets.length - 1].weight;
            sweets = Arrays.copyOf(sweets, sweets.length - 1);


        }
        System.out.println("Вес коробочки " + x + " меньше входного параметра (>" + weight + ")");

    }

    /**
     * Функция, удаляющая из массива sweets элементы до тех пор, пока {@link Box#getTotalPrice()} >  @param price
     */
    public void reducePrice(double price) {
        sweets = Arrays.copyOf(sweets, sweets.length);
        double x = getTotalPrice();


        Comparator priceComparator = new MaxPriceComparator();
        Arrays.sort(sweets, priceComparator);
        for (Sweet sweet : sweets) {
            System.out.println(sweet.toString());
        }


        while (x > price) {
            if (sweets.length == 0) {
                System.out.println("Коробочка пуста");
                break;
            }
            System.out.println("\n Цена коробочки " + x + " больше входного параметра " + price);
            System.out.println("Удаляем сладость с наименьшей ценой " + sweets[sweets.length - 1].price);
            x = x - sweets[sweets.length - 1].price;
            sweets = Arrays.copyOf(sweets, sweets.length - 1);


        }
        System.out.println("Цена коробочки " + x + " меньше входного параметра (>" + price + ")");

    }
}