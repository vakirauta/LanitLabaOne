
public class Bag extends Item {

    public Bag(String title, double maxWeight, double weight) {
        super(title,maxWeight,weight);
    }

    public String toString() {
        return "Container - " + title + ", "
                + "Максмальный вес: " + maxWeight + ", "
                + "Собственный вес: " + weight;
    }
}
