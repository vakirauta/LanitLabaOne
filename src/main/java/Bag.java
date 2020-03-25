import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag implements ItemContainers{
    Item o;
    private String title = "Мешок";
    private double maxWeight = 10;
    private double weight = 0.1;
    private List <Object> cont = new ArrayList<>();
    Random rand = new Random();

    @Override
    public void addItem(Item o) throws ItemStoreException, ItemAlreadyPlacedException {
        if(cont.contains(o)) {
            System.out.println("Этот предмет уже внутри!");
        }
        else if(o.checked == false){
            if (o.getWeight() < (maxWeight-weight)) {
                cont.add(o);
                o.checked = true;
                maxWeight -= o.getWeight();
//                for(Object s: cont) {
//                    System.out.println(s);
//                    }
                }else {
                throw new ItemStoreException("Нельзя положить больше 10 кг");
            }
        }else {
            throw new ItemAlreadyPlacedException("Этот предмет уже-где то лежит");
        }
    }

    @Override
    public void getItem() {
        Object randomElement = cont.get(rand.nextInt(cont.size()));
        cont.remove(randomElement);
        System.out.println("Предмет в мешке " + randomElement);
    }

    @Override
    public void findItem(Item o) {
        if (cont.contains(o)) {
            int indx = cont.indexOf(o);
            cont.get(indx);
            System.out.println("Предмет в мешке " + o);
        }else if (cont.size() == 0){
            System.out.println("Этот мешок пустой!");
        }else if (cont.indexOf(o) == -1) {
            System.out.println("Этот предмет в мешке отсутствует");
        }
    }

    public double getWeight() {
        return maxWeight;
    }

    @Override
    public String toString() {
        return "Container - " + title + ", "
                + "Максмальный вес: " + maxWeight + ", "
                + "Собственный вес: " + weight;
    }
}
