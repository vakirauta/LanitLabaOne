import java.util.*;

public abstract class ItemContainerMethodsAndVariables{

    protected String title;
    protected double maxWeight;
    protected double weight;
    private double totalWeight;
    protected boolean checked = false;

    protected Stack<ItemContainerMethodsAndVariables> stack = new Stack<>();
    private List<Item> cont = new ArrayList<>();
    protected Set<String> properties = new HashSet<>();
    private Random rand = new Random();

    public ItemContainerMethodsAndVariables(String title, double maxWeight, double weight) {
        this.title = title;
        this.maxWeight = maxWeight;
        this.weight = weight;
    }

    public ItemContainerMethodsAndVariables(String title) {
        this.title = title;
    }

    public ItemContainerMethodsAndVariables(String title, double weight) {
        this.title = title;
        this.weight = weight;
    }

    public void addItem(ItemContainerMethodsAndVariables item) throws ItemStoreException, ItemAlreadyPlacedException{
        if (!item.checked) {
            if (item.getWeight() < (maxWeight - weight)) {
                cont.add((Item) item);
                item.checked = true;
                totalWeight += item.getWeight();
            } else {
                throw new ItemStoreException("Нельзя положить больше " + maxWeight + " кг");
            }
        }else {
            throw new ItemAlreadyPlacedException("Этот предмет уже где-то лежит");
        }
    };

    public void getItem(ItemContainerMethodsAndVariables item) {
        if (cont.contains(item)) {
            int indx = cont.indexOf(item);
            cont.get(indx);
            System.out.println("Предмет в " + title + " " + item);
        }
    };

    public void getRandomItem(){
        Object randomElement = cont.get(rand.nextInt(cont.size()));
        cont.remove(randomElement);
        System.out.println("Предмет в " + title + " " + randomElement);
    };

    void findItem(ItemContainerMethodsAndVariables item){
        if (cont.contains(item)) {
            int indx = cont.indexOf(item);
            cont.get(indx);
            System.out.println("Предмет в " + title + " " + item);
        }else if (cont.size() == 0){
            System.out.println("Внутри" + title + "ничего нет");
        }else if (cont.indexOf(item) == -1) {
            System.out.println("Этот предмет в " + title + " отсутствует");
        }
    };

    public String toString() {
        return "Container - " + title + ", "
                + "Максмальный вес: " + maxWeight + ", "
                + "Собственный вес: " + weight;
    }

    public String getTitle() {
        return title;
    }

    public double getWeight() {
        return weight;
    }

    public double getTotalWeight() {
        return totalWeight + weight;
    }
}
