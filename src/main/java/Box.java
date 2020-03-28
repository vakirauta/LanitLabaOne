
public class Box extends Item {

    private boolean open;

    public Box(String title, double maxWeight, double weight) {
        super(title, maxWeight, weight);
    }

    public void addItemContainer(ItemContainerMethodsAndVariables item) throws ItemAlreadyPlacedException, ItemStoreException {
        if (open == true) {
                addItem(item);
                open = false;
            }else {
            System.out.println("������� �������!");
        }
    }

    public void openBox() {
        open = true;
    }

    public String toString() {
        return "Container - " + title + ", "
                + "����������� ���: " + maxWeight + ", "
                + "����������� ���: " + weight;
    }
}
