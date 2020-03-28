import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestItems {
    private Bag bagOne;
    private Box boxOne;
    private StackOne stackOne;

    public Item item = new Item("Кирпич", 2, "плоский", "красный", "тяжелый");
    public Item item1 = new Item("Пеноблок", 3, "белый", "термостойкий");
    public Item item0 = new Item("Камень", 1, "черный");
    public Item item2 = new Item("Шлакобетон", 5, "серый", "пористый");
    public Item item3 = new Item("Газосиликат", 6, "плоский", "белый");
    public Item item4 = new Item("Камень", 4, "плоский", "черный");
    public Item item5 = new Item("Камень", 4, "черный");
    public Item item6 = new Item("Камень", 2, "черный");
    public Item item7 = new Item("Пеноблок", 6, "плоский", "черный");

    @Test
    public void testCreateItems() {
        Item item = new Item("Кирпич", 2, "красный", "тяжелый");
        Item item1 = new Item("Пеноблок", 3, "белый", "термостойкий");
        Item item0 = new Item("Камень", 4, "черный");

        System.out.println(item.toString());
        System.out.println(item1.toString());
        System.out.println(item0.toString());
        System.out.println("----------------------------");
    }

    @Test
    public void testCreateContainerItems() {
        bagOne = new Bag("Мешок1", 10, 0.4);
        boxOne = new Box("Коробка1", 6, 0.5);
        stackOne = new StackOne("Стопка1", 3);

        System.out.println(bagOne.toString());
        System.out.println(boxOne.toString());
        System.out.println(stackOne.toString());
        System.out.println("----------------------------");
    }

    @Test
    public void TestOperationsItems() throws ItemStoreException, ItemAlreadyPlacedException {
        bagOne = new Bag("Мешок2", 8, 0.2);
        boxOne = new Box("Коробка2", 7, 0.4);
        stackOne = new StackOne("Стопка2", 3);
        Bag bagTwo = new Bag("Мешок", 10, 0.5);

        bagOne.addItem(item2);
        bagOne.addItem(item6);
        assertEquals(bagOne.getTotalWeight(), 7.2);

        boxOne.openBox();
        boxOne.addItemContainer(item1);
        boxOne.openBox();
        boxOne.addItemContainer(item);
        boxOne.openBox();
        assertEquals(boxOne.getTotalWeight(), 5.4);

        stackOne.addItem(item3);
        stackOne.addItem(item4);
        stackOne.addItem(item5);
        stackOne.addItem(bagTwo);
        stackOne.getItem();
        assertEquals(stackOne.getMaxItem(), 1.0);

        bagOne.getRandomItem();
        bagOne.findItem(item1);

        boxOne.getItem(item1);

        bagTwo.addItem(bagOne);
        bagTwo.getRandomItem();

        System.out.println("--------------------------");
    }

    @Test
    public void addBagInStack() throws ItemStoreException, ItemAlreadyPlacedException {
        stackOne = new StackOne("Стопка4", 4);
        bagOne = new Bag("Мешок", 8, 0.2);

        stackOne.addItem(bagOne);
        stackOne.getItem();
    }

    @Test(expected = ItemStoreException.class)
    public void mistakesWeightOperationItems() throws ItemStoreException, ItemAlreadyPlacedException {
        bagOne = new Bag("Мешок3", 5, 0.3);

        bagOne.addItem(item0);
        bagOne.addItem(item3);
        bagOne.addItem(item1);
        bagOne.getTotalWeight();
        System.out.println("----------------------------");
    }

    @Test(expected = ItemAlreadyPlacedException.class)
    public void mistakesStoreOperationItems() throws ItemAlreadyPlacedException, ItemStoreException {
        boxOne = new Box("Коробка3", 6, 0.6);
        stackOne = new StackOne("Стопка3", 4);

        boxOne.openBox();
        boxOne.addItemContainer(item2);
        boxOne.openBox();
        boxOne.addItemContainer(item2);
        stackOne.addItem(item2);
        System.out.println("---------------------------");
    }
}
