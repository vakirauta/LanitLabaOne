import java.util.HashSet;
import java.util.Set;

public class Item {

    protected String title;
    protected double weight;
    boolean checked = false;
    protected Set<String> properties = new HashSet<>();

    public Item(String title) {
        this.title = title;
    }

    public double getWeight() {
        return weight;
    }

    public Item(String title, double weight, String... additionalProperties) {
        this.title = title;
        this.weight = weight;
        for (int i = 0; i < additionalProperties.length; i++) {
            properties.add(additionalProperties[i]);
        }
    }

    public String getStringProperties() {
        String[] arrays = properties.toArray(new String[properties.size()]);
        return String.join(", ", arrays);
    }

    public String toString() {
        return "Item - " + title + ", " + "Вес: " + weight + " кг, " + "Свойства: " + getStringProperties();
    }
}