import java.util.ArrayList;
import java.util.List;

public class Box implements ItemContainers{
    Item o;
    private String title = "�������";
    private double maxWeight = 6;
    private double weight = 0.5;
    private boolean open = false;
    private List<Object> cont = new ArrayList<>();

    @Override
    public void addItem(Item o) throws ItemAlreadyPlacedException, ItemStoreException {
        if(open == true) {
            if (o.checked == false) {
                if (o.getWeight() < (maxWeight - weight)) {
                    cont.add(o);
                    o.checked = true;
                    maxWeight -= o.getWeight();
                    open = false;
                }
                else {
                    throw new ItemStoreException("������ �������� ������ 6 ��");
                }
            } else {
                throw new ItemAlreadyPlacedException("���� ������� ��� ���-�� �����");
            }
        }else {
            System.out.println("������� �������!");
        }
    }

    public void openBox() {
        open = true;
    }

    @Override
    public void getItem() {
        getItem(o);
    }

    private void getItem(Item o) {
        if (cont.contains(o)) {
            int indx = cont.indexOf(o);
            cont.get(indx);
            System.out.println("������� � ������� " + o);
        }
    }

    @Override
    public void findItem(Item o) {
        if (cont.contains(o)) {
            int indx = cont.indexOf(o);
            cont.get(indx);
            System.out.println("������� � ������� " + o);
        } else if (cont.size() == 0) {
            System.out.println("��a ������� ����a!");
        } else if (cont.indexOf(o) == -1) {
            System.out.println("���� ������� � ������� �����������");
        }
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    @Override
    public String toString() {
        return "Container - " + title + ", "
                + "����������� ���: " + maxWeight + ", "
                + "����������� ���: " + weight;
    }
}
