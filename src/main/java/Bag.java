
public class Bag extends Container {

    public Bag(String title, double maxWeight, double weight) {
        super(title, maxWeight, weight);
    }

    public String toString() {
        return "Container - " + getTitle() + ", "
                + "Максмальный вес: " + getMaxWeight() + ", "
                + "Собственный вес: " + getWeight();
    }
}
