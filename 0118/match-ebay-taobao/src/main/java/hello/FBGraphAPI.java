package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FBGraphAPI {
	/*
	 * The following are one simple example of FB Graph Search
	 */
	
	public long id; //id": "1201894",
	private String firstName; //   "first_name": "Jie",
	private String gender;//    "gender": "male",
	private String lastName;//   "last_name": "Chen",
	private String name;//   "name": "Jie Chen",
	private String userName;//   "username": "jiechen"
	private String link;//   "link": "https://www.facebook.com/jiechen",
	private String website;//"website": "http://www.huawei.com",
	private String category;//   "category": "Local business",
	private String locale;//   "locale": "en_GB",
//	private String location;//location
	private String description;//"description"
	private String about;//"about": "Welcome to the official Facebook page for Huawei: Enriching life and improving efficiency through a better connected world.",
	
	public void setAbout(String about) {
		this.about = about;
	}
	
	public String getAbout() {
		return this.about;
	}
	
	public void setDescription(String des) {
		this.description = des;
	}
	
	public String getDescription() {
		return this.description;
	}
/*	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLocation() {
		return this.location;
	}
*/	
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public String getLocale() {
		return this.locale;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
/*	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
*/	
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setLastName(String lname) {
		this.lastName = lname;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getLink() {
		return this.link;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getWebsite() {
		return this.website;
	}

}
