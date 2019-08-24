package CandyGift.Sweets;

/**
 * Класс Sweet со свойствами <b>name</b>, <b>weight</b>, <b>price</b>, <b>count</b>.
 *
 * @author Бакулин Андрей
 */

public abstract class Sweet {
    String name;
    public double weight;
    public double price;
    static int count = 0;


    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name - навание
     * @param weight - вес
     * @param price - цена
     */
    public Sweet(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        count++;
    }

    @Override
    public String toString() {
        return "Название: " + name + "; Вес, [г]: " + weight + "; Цена, [руб]: " + price;
    }
}