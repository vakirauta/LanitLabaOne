
public class Bag extends ContainerMethodsAndVariables {

    public Bag(String title, double maxWeight, double weight) {
        super(title, maxWeight, weight);
    }

    public String toString() {
        return "Container - " + title + ", "
                + "����������� ���: " + maxWeight + ", "
                + "����������� ���: " + weight;
    }
}
