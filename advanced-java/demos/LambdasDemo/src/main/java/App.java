import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        LambdaFilters lambdaFilters = new LambdaFilters();

        List<Address> addresses = lambdaFilters.addresses.addressList;

        List<Address> list1 = lambdaFilters.filterAddresses(addresses, lambdaFilters.byCity);

        List<String> stringList = new ArrayList<>();
        stringList.add("ok1");
        stringList.add("ok2");
        stringList.add("ok3");
        stringList.add("ok4");
        stringList.add("ok5");
        stringList.add("ok6");

        stringList = stringList.stream()
                .sorted((a, b) -> b.compareToIgnoreCase(a))
                .map(a -> a + " ok")
                .collect(Collectors.toList());

        stringList.forEach(System.out::println);

    }

}
