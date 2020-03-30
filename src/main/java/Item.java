import java.util.HashSet;
import java.util.Set;

public class Item {

    private String title;
    private double weight;
    private  boolean checked = false;
    protected Set<String> properties = new HashSet<>();

    public Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public double getWeight()
    {
        return weight;
    }

    public Item(String title, double weight, String... additionalProperties) {
        this.title = title;
        this.weight = weight;
        for (int i = 0; i < additionalProperties.length; i++) {
            properties.add(additionalProperties[i]);
        }
    }

    public boolean isChecked() {
        return checked;
    }


    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getStringProperties() {
        String[] arrays = properties.toArray(new String[properties.size()]);
        return String.join(", ", arrays);
    }

    public String toString() {
        return "Item - " + title + ", " + "Вес: " + weight + " кг, " + "Свойства: " + getStringProperties();
    }
}