/**
 * Represents a customer in the warehouse system.
 * Each customer has a unique ID and name used for identification and records.
 *
 * @author Ahmed Seboui
 * @version 2.0
 * @since 2025-10-20
 */

package warehouse;
import java.io.*;

public class Customer implements Serializable{
	
	private String id;
	private String name;
	
	public Customer(String name,String id) {
		this.id=id;
		this.name=name;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return String.format("%s (%s)", id,name);
	}
	
}
