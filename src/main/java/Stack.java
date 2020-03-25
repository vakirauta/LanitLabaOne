import java.util.ArrayList;
import java.util.List;

public class Stack implements ItemContainers{

    private String title = "������";
    private double maxItem = 3;
    private List<Object> cont = new ArrayList<>();


    @Override
    public void addItem(Item o) throws ItemStoreException, ItemAlreadyPlacedException {
        if(cont.contains(o)) {
            System.out.println("���� ������� ��� ������!");
        }
        else if(o.checked == false){
            if (maxItem > 0) {
                cont.add(o);
                o.checked = true;
                maxItem--;
//                for(Object s: cont) {
//                    System.out.println(s);
//                    }
            }
            else {
                throw new ItemStoreException("������ �������� ������ 3 ���������");
            }
        }
        else {
            throw new ItemAlreadyPlacedException("���� ������� ���-��� �� �����");
        }
    }

    @Override
    public void getItem() {};

    public void getItem(Item o) {
        if(cont.indexOf(o) == cont.size()-1) {
            System.out.println("������� �� ������ " + o);
            maxItem++;
        }
    }

    @Override
    public void findItem(Item o) {
        if(cont.indexOf(o) <= (cont.size() / 4)-1) {
            System.out.println("������� ��������� � ������ �����");
        }else if(cont.indexOf(o) <= (cont.size() / 2 ) & cont.indexOf(o) > (cont.size() / 4)-1) {
            System.out.println("������� ��������� �������� � ��������");
        }else if (cont.indexOf(o) > (cont.size() / 2) & cont.indexOf(o) < cont.size()-1) {
            System.out.println("������� ��������� ����� � �����");
        }else if(cont.indexOf(o) == cont.size()-1){
            System.out.println("������� ����� �������");
        }
    }

    public double getMaxItem() {
        return maxItem;
    }

    @Override
    public String toString() {
        return "Container - " + title + ", "
                + "����������� ���-�� ���������: " + maxItem;
    }
}
