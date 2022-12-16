import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class Monkey {
    private ArrayList<Long> items;
    private Predicate<Long> test;
    private Function<Long, Long> operation;

    private Function<Long, Long> unridiculousness;
    private Monkey yesMonkey;
    private Monkey noMonkey;
    private Integer counter = 0;
    private static Long multiplication = 1l;

    public Monkey(ArrayList<Long> startItems, Integer divisionNumber, Function<Long, Long> operation) {
        items = startItems;
        this.test = worry -> worry % divisionNumber == 0;
        this.unridiculousness = worry -> worry%multiplication;
        this.operation = operation;
        multiplication *= divisionNumber;
    }

    public void proceedMonkeyItems() {
        counter += items.size();
        items.stream().map(operation.andThen(worry -> worry/3)).filter(test).forEach(worry -> throwToMonkey(yesMonkey, worry));
        items.stream().map(operation.andThen(worry -> worry/3)).filter(test.negate()).forEach(worry -> throwToMonkey(noMonkey, worry));
        items.clear();
    }

    public void proceedMonkeyItemsWithoutDivision() {
        counter += items.size();
        items.stream().map(operation).filter(test).map(unridiculousness).forEach(worry -> throwToMonkey(yesMonkey, worry));
        items.stream().map(operation).filter(test.negate()).map(unridiculousness).forEach(worry -> throwToMonkey(noMonkey, worry));
        items.clear();
    }

    public void throwToMonkey(Monkey monkey, Long worry) {
        monkey.items.add(worry);
    }

    public void setYesMonkey(Monkey yesMonkey) {
        this.yesMonkey = yesMonkey;
    }

    public void setNoMonkey(Monkey noMonkey) {
        this.noMonkey = noMonkey;
    }

    public Integer getCounter() {
        return counter;
    }
}
