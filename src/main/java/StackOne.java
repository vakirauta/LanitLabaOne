import java.util.EmptyStackException;

public class StackOne extends ItemContainerMethodsAndVariables {

    private double maxItem;

    public StackOne(String title, double maxItem) {
        super(title);
        this.maxItem = maxItem;
    }

    @Override
    public void addItem(ItemContainerMethodsAndVariables item) throws ItemStoreException, ItemAlreadyPlacedException {
        if (item.properties.contains("плоский") || item.title.contains("Коробка")) {
            if (stack.search(item) == -1 && item.checked == false) {
                if (maxItem > 0) {
                    stack.push(item);
                    item.checked = true;
                    maxItem--;
                } else {
                    throw new ItemStoreException("Нельзя положить больше 3 предметов");
                }
            } else {
                throw new ItemAlreadyPlacedException("Этот предмет уже-где то лежит");
            }
        }
    }

    public void getItem(){
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
                + "Максмальное кол-во предметов: " + maxItem;
    }
}
