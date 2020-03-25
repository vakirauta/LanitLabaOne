public interface ItemContainers {

    void addItem(Item o) throws ItemStoreException, ItemAlreadyPlacedException;
    void getItem();
    void findItem(Item o);

}
