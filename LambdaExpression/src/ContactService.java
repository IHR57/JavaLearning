import java.util.ArrayList;
import java.util.List;

public class ContactService {

    public List<Contact> findContacts(List<Contact> contacts,
                                                       FilterCriteria filterCriteria) {
        List<Contact> filteredList = new ArrayList<>();

        for(Contact contact : contacts) {
            if(filterCriteria.match(contact)) {
                filteredList.add(contact);
            }
        }

        return filteredList;
    }
}
