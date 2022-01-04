import java.util.List;

public class ContactApp {
    public static void runContactApp() {
        List<Contact> contactList = List.of(new Contact("C++", "cpp23@gmail.com",
                50, Contact.Gender.MALE),
                new Contact("Java", "java45@gmail.com", 30, Contact.Gender.FEMALE),
                new Contact("Python", "python20@gmail.com", 20, Contact.Gender.FEMALE),
                new Contact("JavaScript", "js23@gmail.com", 23, Contact.Gender.MALE));

        ContactService contactService = new ContactService();

        // without lambda expression
        List<Contact> contactAged18To25 = contactService.findContacts(contactList,
                new FilterCriteria() {
                    @Override
                    public boolean match(Contact contact) {
                        return 18 <= contact.getAge() && contact.getAge() <= 25;
                    }
                });

        // using lambda expression
        /* we can use lambda expression instead of anonymous inner class only if the interface has
        only one method and the interface can be used by any anonymous inner class
         */
        List<Contact> contactAged18To25Female = contactService.findContacts(contactList,
                (Contact contact) -> {
                    return 18 <= contact.getAge() && contact.getAge() <= 25 &&
                            contact.getGender() == Contact.Gender.FEMALE;
                });

        for(Contact contact : contactAged18To25) {
            System.out.println(contact.toString());
        }

        for(Contact contact: contactAged18To25Female) {
            System.out.println(contact.toString());
        }
    }
}
