package doors;

public class Door {
    private int id;
    private boolean containPrize;

    public Door(int id, boolean containPrize) {
        this.id = id;
        this.containPrize = containPrize;
    }

    public int getId() {
        return id;
    }

    public boolean isContainPrize() {
        return containPrize;
    }
}
