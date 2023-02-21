import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        String name;
        String phone;

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            Boolean haveName = false;
            Boolean havePhone = false;
            String input = new Scanner(System.in).nextLine();

            for (String keys : phoneBook.phoneBookMap.keySet()) {
                if (input.equals(keys)) {
                    havePhone = true;
                }
            }
            for (String keys : phoneBook.phoneBookMap.keySet()) {
                if (input.equals(phoneBook.phoneBookMap.get(keys))) {
                    haveName = true;
                }
            }


            if (phoneBook.isName(input)) {
                name = input;
                if (haveName) {
                    System.out.println(phoneBook.getContactByName(name));
                    continue;
                } else {
                    System.out.println("Такого имени в телефонной книге нет.\n" +
                            "Введите номер телефона для абонента " + "\"" + name + "\":");
                    String phoneInput = new Scanner(System.in).nextLine();
                    if (phoneBook.isPhone(phoneInput)) {
                        phoneBook.addContact(phoneInput, name);
                        System.out.println("Контакт сохранен!");
                        continue;
                    }
                }
            }
            if (phoneBook.isPhone(input)) {
                phone = input;
                if (havePhone) {
                    System.out.println(phoneBook.getContactByPhone(phone));
                    continue;
                } else {
                    System.out.println("Такого номера нет в телефонной книге.\n" +
                            "Введите имя абонента для номера " + "\"" + phone + "\":");
                    String nameInput = new Scanner(System.in).nextLine();
                    phoneBook.addContact(phone, nameInput);
                    System.out.println("Контакт сохранен!");
                    continue;
                }
            }
            if (input.equals("LIST")) {
                for (String contacts : phoneBook.getAllContacts()) {
                    System.out.println(contacts);
                }
                continue;
            }

            System.out.println("Неверный формат ввода");
        }
    }
}
