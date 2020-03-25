import java.util.ArrayList;
import java.util.List;

public class Stack implements ItemContainers{

    private String title = "Стопка";
    private double maxItem = 3;
    private List<Object> cont = new ArrayList<>();


    @Override
    public void addItem(Item o) throws ItemStoreException, ItemAlreadyPlacedException {
        if(cont.contains(o)) {
            System.out.println("Этот предмет уже внутри!");
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
                throw new ItemStoreException("Нельзя положить больше 3 предметов");
            }
        }
        else {
            throw new ItemAlreadyPlacedException("Этот предмет уже-где то лежит");
        }
    }

    @Override
    public void getItem() {};

    public void getItem(Item o) {
        if(cont.indexOf(o) == cont.size()-1) {
            System.out.println("Предмет из стопки " + o);
            maxItem++;
        }
    }

    @Override
    public void findItem(Item o) {
        if(cont.indexOf(o) <= (cont.size() / 4)-1) {
            System.out.println("Предмет находится в стопке снизу");
        }else if(cont.indexOf(o) <= (cont.size() / 2 ) & cont.indexOf(o) > (cont.size() / 4)-1) {
            System.out.println("Предмет находится примерно в середине");
        }else if (cont.indexOf(o) > (cont.size() / 2) & cont.indexOf(o) < cont.size()-1) {
            System.out.println("Элемент находится ближе к верху");
        }else if(cont.indexOf(o) == cont.size()-1){
            System.out.println("Элемент можно забрать");
        }
    }

    public double getMaxItem() {
        return maxItem;
    }

    @Override
    public String toString() {
        return "Container - " + title + ", "
                + "Максмальное кол-во предметов: " + maxItem;
    }
}
