
import java.util.HashSet;
import java.util.Set;

public class Item {
    private String title;
    private int weight;
    private String output;
    public boolean checked;
    Set<String> properties = new HashSet<>();

    public Item(String titleItem, int weight, String ... additionalProperties) {
        this.title = titleItem;
        this.weight = weight;
        for (int i = 0; i < additionalProperties.length; i++) {
            properties.add(additionalProperties[i]);
        }
    }

    public String getStringProperties() {
        String[] array = properties.toArray(new String[properties.size()]);
        return output = String.join(", ",array);
    }

    public void getInfo(){
        getStringProperties();
        System.out.println(this.title + ", " + "Вес: " + this.weight + " кг, " + "Свойства: " + getStringProperties());
    }

    public int getWeight() {
        return weight;
    }



    @Override
    public String toString() {
        return "Item - " + this.title + ", " + "Вес: " + this.weight + " кг, " + "Свойства: " + getStringProperties();
    }
}