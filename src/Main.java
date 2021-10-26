import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void nonFunctional() {
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        for(int i = 0; i < cities.size(); i++) {
            cities.set(i, cities.get(i).toUpperCase());
        }

        for(String city : cities) {
            System.out.println(city);
        }

        // Method reference operator
        cities.replaceAll(String::toUpperCase);

        System.out.println(cities);
        //cities skall innehålla samma städer, men med stora bokstäver
        //skriv sedan ut hela listan
    }

    public static void functional() {
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        Consumer<List<String>> upperCaseConsumer = list -> {
            list.replaceAll(String::toUpperCase);
        };

        Consumer<List<String>> printConsumer = list -> list.forEach(System.out::println);

        upperCaseConsumer.andThen(printConsumer).accept(cities);
    }

    public static void main(String[] args) {
        functional();
    }
}
