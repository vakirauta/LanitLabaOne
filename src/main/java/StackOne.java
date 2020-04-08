import java.util.EmptyStackException;
import java.util.Stack;

public class StackOne extends Item {

    private int maxItem;
    private int itemInStack;
    private Stack<Item> stack = new Stack<>();

    public StackOne(String title, int maxItem) {
        super(title);
        this.maxItem = maxItem;
    }

    public void addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        if (item.getProperties().contains("плоский") && !(item instanceof Bag)) {
            if (stack.search(item) == -1 && !item.isChecked()) {
                if (maxItem > 0) {
                    stack.push(item);
                    item.setChecked(true);
                    itemInStack = maxItem--;
                } else {
                    throw new ItemStoreException("Нельзя положить больше 3 предметов");
                }
            } else {
                throw new ItemAlreadyPlacedException("Этот предмет уже-где то лежит");
            }
        }
    }

    public void getItem() {
        try {
            System.out.println("Сняли предмет: " + stack.peek());
        } catch (EmptyStackException ex) {
            System.err.println("Пусто");
        }
    }

    public double getMaxItem() {
        return maxItem;
    }

    @Override
    public String toString() {
        return "Container - " + getTitle() + ", "
                + "Максимальное кол-во предметов в стопке: " + maxItem + ", "
                + "Предметов в стопке: " + itemInStack;
    }
}
