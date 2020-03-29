
public class Box extends Bag {

    private boolean open;

    public Box(String title, double maxWeight, double weight) {
        super(title, maxWeight, weight);
    }

    public void addItemContainer(Item item) throws ItemAlreadyPlacedException, ItemStoreException {
        if (open) {
            addItem(item);
            open = false;
        } else {
            System.out.println("коробка закрыта!");
        }
    }

    public void openBox() {
        open = true;
    }

    public String toString() {
        return "Container - " + title + ", "
                + "Максмальный вес: " + maxWeight + ", "
                + "Собственный вес: " + weight;
    }
}
