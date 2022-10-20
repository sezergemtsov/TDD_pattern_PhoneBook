import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    Map<String, String> phoneBook = new HashMap<>();

    public int add(String name, String number) {
        if (phoneBook.isEmpty() | !phoneBook.containsKey(name)) {
            phoneBook.put(name, number);
        }
        int contactsNumber = 0;
        Set<String> keySet = phoneBook.keySet();
        for (int i = 0; i < keySet.size(); i++) {
            contactsNumber++;
        }
        return contactsNumber;
    }
}
