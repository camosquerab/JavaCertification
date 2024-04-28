import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        variables(2);

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }





        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(2));

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isGreaterThan5 = x -> x > 5;
        System.out.println(isEven.and(isGreaterThan5).test(8)); // Imprime true
        System.out.println(isEven.and(isGreaterThan5).test(8));
        System.out.println(isGreaterThan5.and(isEven).test(4 ));

        Predicate<Integer> isNegative = x -> x < 0;
        System.out.println(isEven.or(isNegative).test(-3)); // Imprime true

        System.out.println("Negate: ");
        System.out.println(isEven.negate().test(-4));

        System.out.println("Is Equal: ");
        Predicate<Object> isNull = Predicate.isEqual(null);
        System.out.println(isNull.test(null));

        System.out.println("Is one: ");
        Predicate<Integer> isOne = Predicate.isEqual(1);
        System.out.println(isOne.negate().test(1));

        Consumer<String> printer = System.out::println;
        printer.accept("Hello, world!");

        Function<Integer,String> converterIntToString = Object::toString;
        System.out.println(converterIntToString.apply(234));
        String numero = converterIntToString.apply(234);


        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("fish",false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        //print(animals, new CheckIfHopper());
        print(animals, a-> a.canSwim());

    }
    public static void variables(int a){
        int b = 1;
        Predicate<Integer> p = x -> {
            int bLocal = 0;
            int c = 0;
            return bLocal == c;
        };
        System.out.print(p);
    }

    private static void print(List<Animal> animals, CheckTrait checker){
        for(Animal animal : animals){
            if(checker.test(animal)){
                System.out.print(animal);
            }
        }
        System.out.println();
    }
}