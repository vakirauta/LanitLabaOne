import java.util.EmptyStackException;
import java.util.Stack;

public class StackOne extends ContainerMethodsAndVariables {

    private int maxItem;
    private int itemInStack;
    private Stack<Item> stack = new Stack<>();

    public StackOne(String title, int maxItem) {
        super(title);
        this.maxItem = maxItem;
    }

    public void addItemStack(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        if (item.properties.contains("�������") && !(item instanceof Bag)) {
            if (stack.search(item) == -1 && !item.checked) {
                if (maxItem > 0) {
                    stack.push(item);
                    item.checked = true;
                    itemInStack = maxItem--;
                } else {
                    throw new ItemStoreException("������ �������� ������ 3 ���������");
                }
            } else {
                throw new ItemAlreadyPlacedException("���� ������� ���-��� �� �����");
            }
        }
    }

    public void getItem() {
        try {
            System.out.println("����� �������: " + stack.peek());
        } catch (EmptyStackException ex) {
            System.err.println("�����");
        }
    }

    public double getMaxItem() {
        return maxItem;
    }

    @Override
    public String toString() {
        return "Container - " + getTitle() + ", "
                + "������������ ���-�� ��������� � ������: " + maxItem + ", "
                + "��������� � ������: " + itemInStack;
    }
}
