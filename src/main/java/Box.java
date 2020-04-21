import io.qameta.allure.Step;

public class Box extends Bag {

    private boolean open;

    public Box(String title, double maxWeight, double weight) {
        super(title, maxWeight, weight);
    }

    public void addItemContainer(Item item) throws ItemAlreadyPlacedException, ItemStoreException {
        if (open) {
                addItem(item);
                closeBox();
        } else {
            System.out.println("коробка закрыта!");
        }
    }

    @Step("Открытие коробки")
    public void openBox() {
        open = true;
    }

    @Step("Закрытие коробки")
    public void closeBox(){
        open = false;
    }

    public String toString() {
        return "Container - " + getTitle() + ", "
                + "Максмальный вес: " + getMaxWeight() + ", "
                + "Собственный вес: " + getWeight();
    }
}
