package fsu.cimes.contacts.jpa;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	 
	/**
	 * Entity bean with JPA annotations
	 * Hibernate provides JPA implementation
	 * @author harshulpandav
	 *
	 */
	@Entity
	@Table(name="contacts")
	public class Contact {
	 
	    @Id
	    @Column(name="id")
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	     
	    private String firstname;
	     
	    private String lastname;
	 
	    public int getId() {
	        return id;
	    }
	 	     
	    public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		@Override
	    public String toString(){
	        return "id="+id+", firstname="+firstname+", lastname="+lastname;
	    }
	}
	
