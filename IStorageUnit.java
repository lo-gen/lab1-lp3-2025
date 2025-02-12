public interface IStorageUnit<Type1> {
    double getSpaceUsed();
    double getSpaceLeft();
    void addItem(Type1 item);
    void removeItem();
}