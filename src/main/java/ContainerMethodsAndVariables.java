import java.util.*;

public abstract class ContainerMethodsAndVariables extends Item {

    protected double maxWeight;
    protected double totalWeight;

    private List<Item> cont = new ArrayList<>();

    public ContainerMethodsAndVariables(String title, double maxWeight, double weight) {
        super(title, weight);
        this.maxWeight = maxWeight;
    }

    public ContainerMethodsAndVariables(String title) {
        super(title);
    }

    public void addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        if (!item.checked) {
            if (item.getWeight() < (maxWeight - weight)) {
                cont.add(item);
                item.checked = true;
                totalWeight += item.getWeight();
            } else {
                throw new ItemStoreException("������ �������� ������ " + maxWeight + " ��");
            }
        } else {
            throw new ItemAlreadyPlacedException("���� ������� ��� ���-�� �����");
        }
    }

    public void getItem(Item item) {
        if (cont.contains(item)) {
            int indx = cont.indexOf(item);
            cont.get(indx);
            System.out.println("������� � " + title + " " + item);
        }
    }

    public void getRandomItem() {
        Random rand = new Random();
        Object randomElement = cont.get(rand.nextInt(cont.size()));
        cont.remove(randomElement);
        System.out.println("������� � " + title + " " + randomElement);
    }

    public void findItem(Item item) {
        if (cont.contains(item)) {
            int indx = cont.indexOf(item);
            cont.get(indx);
            System.out.println("������� � " + title + " " + item);
        } else if (cont.size() == 0) {
            System.out.println("������" + title + "������ ���");
        } else if (cont.indexOf(item) == -1) {
            System.out.println("���� ������� � " + title + " �����������");
        }
    }

    public String toString() {
        return "Container - " + title + ", "
                + "����������� ���: " + maxWeight + ", "
                + "����������� ���: " + weight;
    }

    public String getTitle() {
        return title;
    }

    public double getWeight() {
        return weight;
    }

    public double getTotalWeight() {
        return totalWeight + weight;
    }
}
