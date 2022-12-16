import java.util.List;
import java.util.stream.Collectors;

public class MonkeyGame {
    public static void main(String[] args) {
        List<Monkey> monkeys = MonkeySquad.getMonkeySquad();
        //firstWay(monkeys);
        secondWay(monkeys);

        List<Monkey> sortedMonkeys = monkeys.stream().sorted((m1, m2) -> m2.getCounter() - m1.getCounter()).collect(Collectors.toList());
        for(Monkey monkey: sortedMonkeys) {
            System.out.println(monkey.getCounter());
        }
        System.out.println(sortedMonkeys.get(0).getCounter() * sortedMonkeys.get(1).getCounter());
    }

    private static void secondWay(List<Monkey> monkeys) {
        for(int i = 0; i< 10000; i++) {
            for (Monkey monkey : monkeys) {
                monkey.proceedMonkeyItemsWithoutDivision();
            }
        }
    }

    private static void firstWay(List<Monkey> monkeys) {
        for(int i = 0; i< 20; i++) {
            for (Monkey monkey : monkeys) {
                monkey.proceedMonkeyItems();
            }
        }
    }
}
