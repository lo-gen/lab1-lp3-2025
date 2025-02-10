public interface IStorageUnit<Type1> {
    double totalStorage();
    double storageLeft();
    void addObject(Type1 object);
    void removeObject(Type1 object);
    
}
