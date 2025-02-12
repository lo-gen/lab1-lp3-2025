import java.util.ArrayList;

public class StorageUnit<storageType>{
    private ArrayList<storageType> storage;
    private int totalSpace;

    public StorageUnit(int totalSpace){
        storage = new ArrayList<storageType>();
        this.totalSpace = totalSpace;
    }

    protected int getSpaceUsed(){
        return storage.size();
    }

    protected int getSpaceLeft(){
        return totalSpace - getSpaceUsed();
    }

    protected void addItem(storageType item){
        if (getSpaceLeft() > 0)
            storage.add(item);
    }

    protected void removeFirstItem(){
        storage.removeFirst();
    }

    protected void removeLastItem(){
        storage.removeLast();
    }

    protected void removeSpecificItem(storageType item){
        storage.remove(item);
    }
}
