import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaFilters {

    AddressCollection addresses = new AddressCollection();

    List<Address> addressByCity = filterAddresses(addresses.addressList,
            a -> a.getCity().equalsIgnoreCase("Philidelphia"));

    Predicate<Address> byCity = a -> a.getCity().equalsIgnoreCase("Philidelphia");

    List<Address> filterAddresses(List<Address> source, Predicate<Address> criteria) {
        List<Address> result = new ArrayList<>();
        for (Address a : source) {
            if (criteria.test(a)) {
                result.add(a);
                Stream<Address> test1 = result.stream().sorted();
                System.out.println(test1);
            }
        }
        return result;
    }

}
