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
                    throw new ItemStoreException("������ �������� ������ " + getMaxWeight() + " ��");
                }
            } else {
                throw new ItemAlreadyPlacedException("���� ������� ��� ���-�� �����");
            }
        } else {
            System.err.println("������ �������: " + this.getTitle() + " � " + this.getTitle());
        }
    }

    public void getItem(Item item) {
        if (containerContents.contains(item)) {
            int indx = containerContents.indexOf(item);
            containerContents.get(indx);
            System.out.println("������� � " + getTitle() + " " + item);
        }
    }

    public void getRandomItem() {
        Random rand = new Random();
        Object randomElement = containerContents.get(rand.nextInt(containerContents.size()));
        containerContents.remove(randomElement);
        System.out.println("������� � " + getTitle() + " " + randomElement);
    }

    public void findItem(Item item) {
        if (containerContents.contains(item)) {
            int indx = containerContents.indexOf(item);
            containerContents.get(indx);
            System.out.println("������� � " + getTitle() + " " + item);
        } else if (containerContents.size() == 0) {
            System.out.println("������" + getTitle() + "������ ���");
        } else if (containerContents.indexOf(item) == -1) {
            System.out.println("���� ������� � " + getTitle() + " �����������");
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
                + "����������� ���: " + getMaxWeight() + ", "
                + "����������� ���: " + getWeight();
    }
}
