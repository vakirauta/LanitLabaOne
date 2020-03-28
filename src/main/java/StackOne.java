import java.util.EmptyStackException;

public class StackOne extends ItemContainerMethodsAndVariables {

    private double maxItem;

    public StackOne(String title, double maxItem) {
        super(title);
        this.maxItem = maxItem;
    }

    @Override
    public void addItem(ItemContainerMethodsAndVariables item) throws ItemStoreException, ItemAlreadyPlacedException {
        if (item.properties.contains("�������") || item.title.contains("�������")) {
            if (stack.search(item) == -1 && item.checked == false) {
                if (maxItem > 0) {
                    stack.push(item);
                    item.checked = true;
                    maxItem--;
                } else {
                    throw new ItemStoreException("������ �������� ������ 3 ���������");
                }
            } else {
                throw new ItemAlreadyPlacedException("���� ������� ���-��� �� �����");
            }
        }
    }

    public void getItem(){
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
                + "����������� ���-�� ���������: " + maxItem;
    }
}
