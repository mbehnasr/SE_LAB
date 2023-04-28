import java.util.ArrayList;

public class EfficientList extends ArrayList<Integer> {
    private final int outerForInt;
    private final int innerForInt;

    public EfficientList(int innerForInt, int outerForInt) {
        this.innerForInt = innerForInt;
        this.outerForInt = outerForInt;
    }

    @Override
    public Integer get(int index) {
        return (index / innerForInt) + (index % innerForInt);
    }

    @Override
    public int size() {
        return innerForInt * outerForInt;
    }
}
