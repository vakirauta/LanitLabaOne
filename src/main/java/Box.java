import java.util.ArrayList;
import java.util.List;

public class Box implements ItemContainers{
    Item o;
    private String title = "Коробка";
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
                    throw new ItemStoreException("Нельзя положить больше 6 кг");
                }
            } else {
                throw new ItemAlreadyPlacedException("Этот предмет уже где-то лежит");
            }
        }else {
            System.out.println("коробка закрыта!");
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
            System.out.println("Предмет в коробке " + o);
        }
    }

    @Override
    public void findItem(Item o) {
        if (cont.contains(o)) {
            int indx = cont.indexOf(o);
            cont.get(indx);
            System.out.println("Предмет в коробке " + o);
        } else if (cont.size() == 0) {
            System.out.println("Этa коробка пустa!");
        } else if (cont.indexOf(o) == -1) {
            System.out.println("Этот предмет в коробке отсутствует");
        }
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    @Override
    public String toString() {
        return "Container - " + title + ", "
                + "Максмальный вес: " + maxWeight + ", "
                + "Собственный вес: " + weight;
    }
}
