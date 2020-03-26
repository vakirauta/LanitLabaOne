import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.testng.AssertJUnit.assertEquals;

public class TestItems{
    VariablesTestItems testItems = new VariablesTestItems();
    private Bag bagOne;
    private Box boxOne;
    private Stack stackOne;


    @Before
    public void throwOffContainers() {
        Bag bagOne = new Bag();
        Box boxOne = new Box();
        Stack stackOne = new Stack();
    }

   @Test
    public void testCreateItems() {
       Item item = new Item("Кирпич", 2, "красный", "тяжелый");
       Item item1 = new Item("Пеноблок", 3, "белый", "термостойкий");
       Item item0 = new Item("Камень", 4, "черный");

       item.toString();
       item1.toString();
       item0.toString();
   }
   @Test
    public void testCreateContainerItems() {
        bagOne = new Bag();
        boxOne = new Box();
        stackOne = new Stack();

       bagOne.toString();
       boxOne.toString();
       stackOne.toString();

    }

    @Test
    public void TestOperationsItems() throws ItemStoreException, ItemAlreadyPlacedException {
        bagOne = new Bag();
        boxOne = new Box();
        stackOne = new Stack();

        bagOne.addItem(testItems.item2);
        bagOne.addItem(testItems.item0);
        assertEquals (bagOne.getWeight(),1.0);

        boxOne.openBox();
        boxOne.addItem(testItems.item1);
        boxOne.openBox();
        boxOne.addItem(testItems.item);
        boxOne.openBox();
        assertEquals (boxOne.getMaxWeight(),1.0);

        stackOne.addItem(testItems.item3);
        stackOne.addItem(testItems.item4);
        stackOne.addItem(testItems.item5);
        assertEquals (stackOne.getMaxItem(),0.0);

        bagOne.getItem();
        bagOne.findItem(testItems.item1);

        boxOne.getItem();
        boxOne.findItem(testItems.item);

        stackOne.findItem(testItems.item5);
        stackOne.getItem(testItems.item5);
    }

    @Test(expected = ItemStoreException.class)
    public void mistakesWeightOperationItems() throws ItemStoreException, ItemAlreadyPlacedException {
        bagOne = new Bag();

        bagOne.addItem(testItems.item7);
        bagOne.addItem(testItems.item3);
        bagOne.addItem(testItems.item1);
    }
    @Test(expected = ItemAlreadyPlacedException.class)
    public void mistakesStoreOperationItems() throws ItemAlreadyPlacedException, ItemStoreException {
        boxOne = new Box();
        stackOne = new Stack();
        boxOne.openBox();

        boxOne.addItem(testItems.item2);
        stackOne.addItem(testItems.item2);
    }
}
