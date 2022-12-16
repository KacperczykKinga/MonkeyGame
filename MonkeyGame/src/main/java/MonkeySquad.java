import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonkeySquad {
    private static Monkey monkey0 = new Monkey(new ArrayList<>(Arrays.asList(66l, 79l))
            ,  7, worry -> worry * 11);
    private static Monkey monkey1 = new Monkey(new ArrayList<>(Arrays.asList(84l, 94l, 94l, 81l, 98l, 75l))
            , 13, worry -> worry * 17);
    private static Monkey monkey2 = new Monkey(new ArrayList<>(Arrays.asList(85l, 79l, 59l, 64l, 79l, 95l, 67l))
            , 5, worry -> worry + 8);
    private static Monkey monkey3 = new Monkey(new ArrayList<>(Arrays.asList(70l))
            , 19, worry -> worry + 3);
    private static Monkey monkey4 = new Monkey(new ArrayList<>(Arrays.asList(57l, 69l, 78l, 78l))
            , 2, worry -> worry + 4);
    private static Monkey monkey5 = new Monkey(new ArrayList<>(Arrays.asList(65l, 92l, 60l, 74l, 72l))
            ,  11, worry -> worry + 7);
    private static Monkey monkey6 = new Monkey(new ArrayList<>(Arrays.asList(77l, 91l, 91l))
            ,  17, worry -> worry * worry);
    private static Monkey monkey7 = new Monkey(new ArrayList<>(Arrays.asList(76l, 58l, 57l, 55l, 67l, 77l, 54l, 99l))
            ,  3, worry -> worry + 6);

    private static void setCollaboratesMonkeys() {
        monkey0.setYesMonkey(monkey6);
        monkey0.setNoMonkey(monkey7);

        monkey1.setYesMonkey(monkey5);
        monkey1.setNoMonkey(monkey2);

        monkey2.setYesMonkey(monkey4);
        monkey2.setNoMonkey(monkey5);

        monkey3.setYesMonkey(monkey6);
        monkey3.setNoMonkey(monkey0);

        monkey4.setYesMonkey(monkey0);
        monkey4.setNoMonkey(monkey3);

        monkey5.setYesMonkey(monkey3);
        monkey5.setNoMonkey(monkey4);

        monkey6.setYesMonkey(monkey1);
        monkey6.setNoMonkey(monkey7);

        monkey7.setYesMonkey(monkey2);
        monkey7.setNoMonkey(monkey1);
    }

    private static ArrayList<Monkey> addMonkeysToSquad() {
        ArrayList<Monkey> monkeys = new ArrayList<>();
        monkeys.add(monkey0);
        monkeys.add(monkey1);
        monkeys.add(monkey2);
        monkeys.add(monkey3);
        monkeys.add(monkey4);
        monkeys.add(monkey5);
        monkeys.add(monkey6);
        monkeys.add(monkey7);
        return monkeys;
    }

    public static List<Monkey> getMonkeySquad() {
        setCollaboratesMonkeys();
        return addMonkeysToSquad();
    }
}
