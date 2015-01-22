package hello;

import java.util.List;

 
/**
 * Defines DAO operations for the contact model.
 * @author Scott
 *
 */

public interface ContactDAO {
	public void saveOrUpdate(Contact contact);
	public void delete(int id);
	public Contact get(int id);
	public List<Contact> list();
}