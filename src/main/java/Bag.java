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

    public void getItem(Item item) {
        if (containerContents.contains(item)) {
            int indx = containerContents.indexOf(item);
            containerContents.get(indx);
            System.out.println("Предмет в " + getTitle() + " " + item);
        }
    }

    public void getRandomItem() {
        Random rand = new Random();
        Object randomElement = containerContents.get(rand.nextInt(containerContents.size()));
        containerContents.remove(randomElement);
        System.out.println("Предмет в " + getTitle() + " " + randomElement);
    }

    public void findItem(Item item) {
        if (containerContents.contains(item)) {
            int indx = containerContents.indexOf(item);
            containerContents.get(indx);
            System.out.println("Предмет в " + getTitle() + " " + item);
        } else if (containerContents.size() == 0) {
            System.out.println("Внутри" + getTitle() + "ничего нет");
        } else if (containerContents.indexOf(item) == -1) {
            System.out.println("Этот предмет в " + getTitle() + " отсутствует");
        }
    }

    public double getTotalWeight() {
        return totalWeight + getWeight();
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public String toString() {
        return "Container - " + getTitle() + ", "
                + "Максмальный вес: " + getMaxWeight() + ", "
                + "Собственный вес: " + getWeight();
    }
}
