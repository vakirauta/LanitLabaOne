public class Item extends ItemContainerMethodsAndVariables{

    public Item(String title, int weight, String ... additionalProperties) {
        super(title, weight);
        for (int i = 0; i < additionalProperties.length; i++) {
            properties.add(additionalProperties[i]);
        }
    }

    public Item(String title, double maxWeight, double weight) {
        super(title,maxWeight,weight);
    }

    public String getStringProperties() {
        String[] arrays = properties.toArray(new String[properties.size()]);
        return String.join(", ",arrays);
    }



    public String toString() {
        return "Item - " + super.title + ", " + "Вес: " + this.weight + " кг, " + "Свойства: " + getStringProperties();
    }
}