import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag extends Item {

    private double maxWeight;
    private double totalWeight;
    private List<Item> containerContents = new ArrayList<>();

    public Bag(String title, double maxWeight, double weight) {
        super(title, weight);
        this.maxWeight = maxWeight;
    }
    @Step("Добавление предметa")
    public void addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        if(!this.equals(item)) {
            if (!item.isChecked()) {
                if (item.getWeight() < (maxWeight - getWeight())) {
                    containerContents.add(item);
                    item.setChecked(true);
                    totalWeight += item.getWeight();
                } else {
                    throw new ItemStoreException("Нельзя положить больше " + getMaxWeight() + " кг");
                }
            } else {
                throw new ItemAlreadyPlacedException("Этот предмет уже где-то лежит");
            }
        } else {
            System.err.println("Нельзя вложить: " + this.getTitle() + " в " + this.getTitle());
        }
    }
    @Step("Получение предмета")
    public void getItem(Item item) {
        if (containerContents.contains(item)) {
            removeItem(item);
            int indx = containerContents.indexOf(item);
            System.out.println("Предмет в " + getTitle() + " " + item);
        }
    }
    @Step("Удаление предмета")
    public void removeItem(Item item){
        containerContents.remove(item);
        totalWeight-=item.getWeight();
        item.setChecked(false);
    }

    @Step("Получение рандомного предмета")
    public void getRandomItem() {
        Random rand = new Random();
        Object randomElement = containerContents.get(rand.nextInt(containerContents.size()));
        containerContents.remove(randomElement);
        System.out.println("Предмет в " + getTitle() + " " + randomElement);
    }

    @Step("Поиск предмета")
    public void findItem(Item item) {
        if (containerContents.contains(item)) {
            int indx = containerContents.indexOf(item);
            containerContents.get(indx);
            System.out.println("Предмет в " + getTitle() + " " + item);
        } else if (containerContents.size() == 0) {
            System.out.println("Внутри" + getTitle() + "ничего нет");
        } else if (!containerContents.contains(item)) {
            System.out.println("Этот предмет в " + getTitle() + " отсутствует");
        }
    }
    @Step("Получить общий вес")
    public double getTotalWeight() {
        return totalWeight + getWeight();
    }
    @Step("Получить максимальный вес")
    public double getMaxWeight() {
        return maxWeight;
    }

    public String toString() {
        return "Container - " + getTitle() + ", "
                + "Максмальный вес: " + getMaxWeight() + ", "
                + "Собственный вес: " + getWeight();
    }
}
