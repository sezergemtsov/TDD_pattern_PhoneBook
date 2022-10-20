import java.util.*;

public class PhoneBook {

    Map<String, String> phoneBook = new TreeMap<>();

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

    public String findByNumber(String number) {

        Iterator iterator = phoneBook.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            if (number == pair.getValue()) {
                return (String) pair.getKey();
            }
        }
        return null;
    }

    public String findByName(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        return null;
    }

    public void printAllNames() {
        phoneBook.entrySet().forEach(x -> {
                    System.out.println(x.getKey());
                });
    }

}
