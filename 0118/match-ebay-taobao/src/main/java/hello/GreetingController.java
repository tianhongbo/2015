package hello;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

	@Autowired
    private ContactDAO contactDAO;
	
	public GreetingController() throws SQLException {
//		this.jdbcTemplate = myConnection.getMySQLConnection();
		System.out.println("the myConnection bean is: " + contactDAO);
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String listContact(Model model) {
	    List<Contact> listContact = contactDAO.list();
	    model.addAttribute("listContact", listContact);
	 
	    return "home";
	}
	
	@RequestMapping(value="/api", method=RequestMethod.GET)
	public String setOneFBItemQuery(Model model) {
	    Contact contact = new Contact();
	    model.addAttribute("query", contact);
	    return "fbquery";
	}
	
	@RequestMapping(value="/api", method=RequestMethod.POST)
	public String getOneFBItem(@ModelAttribute Contact contact, Model model) {

	    /*
        RestTemplate restTemplate = new RestTemplate();
        Page page = restTemplate.getForObject("http://graph.facebook.com/pivotalsoftware", Page.class);
        */
	    
		String fbUrl = "http://graph.facebook.com/";
		String url = fbUrl + contact.getName();
		
		System.out.println(url);
		
        RestTemplate restTemplate = new RestTemplate();
        
        try {
        	FBGraphAPI oneFBItem = restTemplate.getForObject(url, FBGraphAPI.class);
            System.out.println(oneFBItem.getAbout());
            System.out.println(oneFBItem.getName());

    	    model.addAttribute("onefbitem", oneFBItem);

        } catch(HttpStatusCodeException e){
        		String errorpayload = e.getResponseBodyAsString();
        		System.out.println(errorpayload);
        		//to whatever you want
        	
        	} catch(RestClientException e){
        		//no response payload, tell the user sth else
        		System.out.println(e.getCause());
        	}
        
        
	    return "fbitem";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String greetingForm(Model model) {
		model.addAttribute("student", new Contact());
		return "greeting";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute Contact contact, Model model) {
		// Insert this form into database
		System.out.println("The JDBC is: " + contactDAO);
		System.out.println("Insert to database");
	    contactDAO.saveOrUpdate(contact);
				
		model.addAttribute("student", contact);
		System.out.println("id = " + contact.getId() + "name = " + contact.getName());
		
		return "result";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteContact(HttpServletRequest request) {
	    int id = Integer.parseInt(request.getParameter("id"));
	    contactDAO.delete(id);
	    return "home";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editContact(HttpServletRequest request, Model model) {
	    int id = Integer.parseInt(request.getParameter("id"));
	    Contact contact = contactDAO.get(id);
	    model.addAttribute("contact", contact);
	 
	    return "greeting";
	} 
}

