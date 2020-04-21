import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

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
        public Item item7 = new Item("Камень", 3, "красный");
        public Item item8 = new Item("Газосиликат", 6, "плоский", "белый");

    @Epic(value = "Создание")
    @Feature(value = "Создание Элементов")
    @Story(value = "Создание предметов")
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

    @Epic(value = "Создание")
    @Feature(value = "Создание Элементов")
    @Story(value = "Создание контейнеров")
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

    @Epic(value = "Добавление")
    @Feature(value = "Добавление элементов")
    @Story(value = "Добавление предметов в мешок")
    @Test
    public void TestAddItemsToTheBag() throws ItemStoreException, ItemAlreadyPlacedException {
        bagOne = new Bag("Мешок2", 8, 0.2);

        bagOne.addItem(item2);
        bagOne.addItem(item6);
        bagOne.getRandomItem();
        assertEquals(bagOne.getTotalWeight(), 7.2);
    }

    @Epic(value = "Добавление")
    @Feature(value = "Добавление элементов")
    @Story(value = "Добавление предметов в коробку")
    @Test
     public void  TestAddItemsToTheBox() throws ItemStoreException, ItemAlreadyPlacedException {
        boxOne = new Box("Коробка2", 7, 0.4);

        boxOne.openBox();
        boxOne.addItemContainer(item1);
        boxOne.openBox();
        boxOne.addItemContainer(item);
        boxOne.openBox();
        boxOne.getItem(item);
        assertEquals(boxOne.getTotalWeight(), 3.4);
    }

     @Epic(value = "Добавление")
     @Feature(value = "Добавление элементов")
     @Story(value = "Добавление предметов в стопку")
     @Test
      public void TestAddItemsToTheStack() throws ItemStoreException, ItemAlreadyPlacedException {
         stackOne = new StackOne("Стопка2", 3);

         stackOne.addItem(item3);
         stackOne.addItem(item4);
         stackOne.addItem(item5);
         stackOne.getItem();

         System.out.println(stackOne.toString());
         assertEquals(stackOne.getMaxItem(), 1.0);
     }

     @Epic(value = "Добавление")
     @Feature(value = "Добавление элементов")
     @Story(value = "Добавление мешка в коробку")
     @Test
      public void TestAddThisBagToTheBox() throws ItemStoreException, ItemAlreadyPlacedException {
        boxOne = new Box("Коробка6", 7, 0.4);
        bagOne = new Bag("Мешок2", 8, 0.2);

        boxOne.openBox();
        boxOne.addItemContainer(bagOne);
        boxOne.findItem(bagOne);

        System.out.println("--------------------------");
    }

    @Epic(value = "Добавление")
    @Feature(value = "Добавление элементов")
    @Story(value = "Добавление мешка в стопку")
    @Test
    public void TestAddBagInStack() throws ItemStoreException, ItemAlreadyPlacedException {
        stackOne = new StackOne("Стопка4", 4);
        bagOne = new Bag("Мешок", 8, 0.2);

        stackOne.addItem(bagOne);
        stackOne.getItem();
    }

    @Epic(value = "Исключениe")
    @Feature(value = "Проверка исключения")
    @Story(value = "Проверка работы исключения на перегруз")
    @Test(expectedExceptions = {ItemStoreException.class})
    public void mistakesWeightOperationItems() throws ItemStoreException, ItemAlreadyPlacedException {
        bagOne = new Bag("Мешок3", 5, 0.3);

        bagOne.addItem(item0);
        bagOne.addItem(item7);
        bagOne.addItem(item8);
        System.out.println("----------------------------");
    }

    @Epic(value = "Исключениe")
    @Feature(value = "Проверка исключения")
    @Story(value = "Проверка работы исключения на добавление ранее добавленного предмета")
    @Test(expectedExceptions = {ItemAlreadyPlacedException.class})
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
    @Epic(value = "Добавление")
    @Feature(value = "Добавление элементов")
    @Story(value = "Проверка на добавление коробки в коробку")
    @Test
    public void addContainerToContainer() throws ItemStoreException, ItemAlreadyPlacedException {
        boxOne = new Box("Коробка5",8,0.3);

        boxOne.openBox();
        boxOne.addItemContainer(boxOne);
        boxOne.getItem(boxOne);

    }
}
