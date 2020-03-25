import org.junit.Assert;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertEquals;

public class TestItems {
    Item item, item0, item1, item2, item3, item4, item5, item6, item7;

    Bag bagOne;
    Box boxOne;
    Stack stackOne;

   @Test(priority = 0)
    public void createItems() {
       item = new Item("Кирпич", 2, "красный", "тяжелый");
       item1 = new Item("Пеноблок", 3, "белый", "термостойкий");
       item0 = new Item("Камень", 4, "черный");
       item2 = new Item("Шлакобетон", 5, "серый", "пористый");
       item3 = new Item("Газосиликат", 6, "белый");
       item4 = new Item("Камень", 4, "черный");
       item5 = new Item("Камень", 4, "черный");
       item6 = new Item("Камень", 4, "черный");
       item7 = new Item("Камень", 4, "черный");
   }
   @Test(priority = 1)
    public void createContainerItems() {
        bagOne = new Bag();
        boxOne = new Box();
        stackOne = new Stack();
    }

    @Test(priority = 2)
    public void operationsItems() throws ItemStoreException, ItemAlreadyPlacedException {
        bagOne.addItem(item2);
        bagOne.addItem(item0);
        assertEquals (bagOne.getWeight(),1.0);

        boxOne.openBox();
        boxOne.addItem(item1);
        boxOne.openBox();
        boxOne.addItem(item);
        boxOne.openBox();
        assertEquals (boxOne.getMaxWeight(),1.0);

        stackOne.addItem(item3);
        stackOne.addItem(item4);
        stackOne.addItem(item5);
        assertEquals (stackOne.getMaxItem(),0.0);

        bagOne.getItem();
        bagOne.findItem(item1);

        boxOne.getItem();
        boxOne.findItem(item);

        stackOne.findItem(item5);
        stackOne.getItem(item5);
    }
    @Test(priority = 3)
    public void mistakesStoreOperationItems() throws ItemStoreException, ItemAlreadyPlacedException {
        boxOne.addItem(item7);
        boxOne.addItem(item6);
    }
    @Test(priority = 4)
    public void mistakexWeightOperationItems() throws ItemStoreException, ItemAlreadyPlacedException {
       bagOne.addItem(item2);
       boxOne.addItem(item2);
    }
}
