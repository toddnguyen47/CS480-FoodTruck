package edu.csupomona.cs480.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.net.InetAddress;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.csupomona.cs480.App;
import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.provider.UserManager;
import edu.csupomona.cs480.data.FoodTruckYelp;
import edu.csupomona.cs480.data.StringGraph;
import edu.csupomona.cs480.data.TruckInfo;
import edu.csupomona.cs480.data.provider.TruckInfoManager;
import edu.csupomona.cs480.data.GeoIP;
import edu.csupomona.cs480.data.GetYelpData;
import edu.csupomona.cs480.data.repository.TruckRepository;

/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController {

	/**
	 * When the class instance is annotated with
	 * {@link Autowired}, it will be looking for the actual
	 * instance from the defined beans.
	 * <p>
	 * In our project, all the beans are defined in
	 * the {@link App} class.
	 */
	@Autowired
	private UserManager userManager;
	@Autowired
	private TruckInfoManager truckManager;
	@Autowired
	private TruckRepository truckRepository;
	/**
	 * This is a simple example of how the HTTP API works.
	 * It returns a String "OK" in the HTTP response.
	 * To try it, run the web application locally,
	 * in your web browser, type the link:
	 * 	http://localhost:8080/cs480/ping
	 */
	@RequestMapping(value = "/cs480/ping", method = RequestMethod.GET)
	String healthCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "OK";
	}

	/**
	 * This is a simple example of how to use a data manager
	 * to retrieve the data and return it as an HTTP response.
	 * <p>
	 * Note, when it returns from the Spring, it will be
	 * automatically converted to JSON format.
	 * <p>
	 * Try it in your web browser:
	 * 	http://localhost:8080/cs480/user/user101
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.GET)
	User getUser(@PathVariable("userId") String userId) {
		User user = userManager.getUser(userId);
		return user;
	}

	/**
	 * This is an example of sending an HTTP POST request to
	 * update a user's information (or create the user if not
	 * exists before).
	 *
	 * You can test this with a HTTP client by sending
	 *  http://localhost:8080/cs480/user/user101
	 *  	name=John major=CS
	 *
	 * Note, the URL will not work directly in browser, because
	 * it is not a GET request. You need to use a tool such as
	 * curl.
	 *
	 * @param id
	 * @param name
	 * @param major
	 * @return
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.POST)
	User updateUser(
			@PathVariable("userId") String id,
			@RequestParam("name") String name,
			@RequestParam(value = "major", required = false) String major) {
		User user = new User();
		user.setId(id);
		user.setMajor(major);
		user.setName(name);
		userManager.updateUser(user);
		return user;
	}

	/**
	 * This API deletes the user. It uses HTTP DELETE method.
	 *
	 * @param userId
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.DELETE)
	void deleteUser(
			@PathVariable("userId") String userId) {
		userManager.deleteUser(userId);
	}

	/**
	 * This API lists all the users in the current database.
	 *
	 * @return
	 */
	@RequestMapping(value = "/cs480/users/list", method = RequestMethod.GET)
	List<User> listAllUsers() {
		return userManager.listAllUsers();
	}

	/*********** Web UI Test Utility **********/
	/**
	 * This method provide a simple web UI for you to test the different
	 * functionalities used in this web service.
	 */
	@RequestMapping(value = "/cs480/home", method = RequestMethod.GET)
	ModelAndView getUserHomepage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("users", listAllUsers());
		return modelAndView;
	}
	
	@RequestMapping(value = "/cs480/thonguyen/a3", method = RequestMethod.GET)
	int[] getFibonacciSequence() {
		// Will try to compute Fibonacci in O(n) time using memoization
		int maxSize = 10;
		int[] fib = new int[maxSize + 1];
		// Initialize first two numbers
		fib[0] = 0;
		fib[1] = 1;
		
		// Calculate next fibonacci numbers based on previously stored numbers
		for (int i = 2; i <= maxSize; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		return fib;
	}
	
	@RequestMapping(value = "/cs480/adriancuellar-a3", method = RequestMethod.GET)
	String dummyMethod() {
		return "Yes";
	}
	
	@RequestMapping(value = "/cs480/rachelchiang-a3", method = RequestMethod.GET)
	String getGreeting()
	{
	   return "Hello, world!";
	}
	
	@RequestMapping(value = "/cs480/asartoonian", method = RequestMethod.POST)
	public String postFoos() {
	    return "Post some Foos";
	}
	
	/*********** Web A3 truckAPI testing the framework **********/
	/*  cs480/chi-wei wang (john) -a3
	 * 
	 */
	//pass
	@RequestMapping(value = "/cs480/foodtruck/{truckId}", method = RequestMethod.GET)
	TruckInfo getTruckInfo(@PathVariable("truckId") Integer truckId) {
		TruckInfo truck = truckManager.getTruckInfo(truckId);
		return truck;
	}
	//pass
	@RequestMapping(value = "/cs480/foodtruck/{truckId}", method = RequestMethod.POST)
	TruckInfo updateTruckInfo(
			@PathVariable("truckId") String id,
			@RequestParam("name") String name,
			@RequestParam(value = "type", required = false) String type) {
		TruckInfo truck = new TruckInfo();
		truck.setId(id);
		truck.setName(name);
		truck.setType(type);
		truckManager.updateTruckInfo(truck);
		return truck;
	}
	//pass
	@RequestMapping(value = "/cs480/foodtruck/{truckId}", method = RequestMethod.DELETE)
	void deleteTruckInfo(
			@PathVariable("truckId") Integer truckId) {
		truckManager.deleteTruckInfo(truckId);	
	}
	//pass
	@RequestMapping(value = "/cs480/foodtruck/list", method = RequestMethod.GET)
	List<TruckInfo> listAllTrucks() {
		return truckManager.listAllTrucks();
	}
	
	@RequestMapping(value = "/cs480/foodtruck/home", method = RequestMethod.GET)
	ModelAndView getFoodtruckPage() {
		ModelAndView modelAndView = new ModelAndView("foodtruck");
		modelAndView.addObject("trucks", listAllTrucks());
		return modelAndView;
	}
	
	/****************** Assignment 4 *****************/
	
	@RequestMapping(value = "cs480/thonguyen/a4", method = RequestMethod.GET)
	List<ArrayList<String>> getFoodTruckYelpInfo() {
		FoodTruckYelp foodTruckYelp = new FoodTruckYelp();
		List<ArrayList<String>> foodTruckInfo = new ArrayList<ArrayList<String>>(); 
		foodTruckInfo.add(foodTruckYelp.getFoodTruckName());
		foodTruckInfo.add(foodTruckYelp.getFoodTruckAddress());
		foodTruckInfo.add(foodTruckYelp.getFoodTruckNumber());
		
		return foodTruckInfo;
	}
	
	@RequestMapping(value = "cs480/adriancuellar/a4", method = RequestMethod.GET)
	double exercise4AC() {
		NormalDistribution normalDist= new NormalDistribution(10,3);
		return normalDist.sample();
	}
	
	@RequestMapping(value = "cs480/asartoonian/a4", method = RequestMethod.GET)
	public void GsonTry() throws IOException {
		try (Writer writer = new FileWriter("Output.json")) {
	        Gson gson = new GsonBuilder().create();
	        gson.toJson("Hello", writer);
	        gson.toJson(123, writer);
		}
	}
	
	@RequestMapping(value = "/cs480/rachelchiang-a4", method = RequestMethod.GET)
	String getGraphInformation()
	{
	   StringGraph stringGraph = new StringGraph();
	   String s = stringGraph.getNodeNames();
	   s += "; " + stringGraph.getEdgeNames();
	   s += "; " + stringGraph.getSuccessorsList();
	   return s;
	}
	/* Chi-Wei Wang -- a4*/
	@RequestMapping(value = "/cs480/foodtruck/google", method = RequestMethod.GET)
	List<TruckInfo> googleSearch() throws IOException{
		return truckManager.searchGoogleResult();
	}
	@RequestMapping(value = "/cs480/foodtruck/geolocation", method = RequestMethod.GET)
	GeoIP getGEO() throws IOException{
		return truckManager.getGeoIP();
	}
	@RequestMapping(value = "/cs480/foodtruck/db/{name}", method = RequestMethod.POST)
	List<TruckInfo> dbInsertTruckInfo(
			@PathVariable("name") String name,
			@RequestParam(value = "type", required = false) String type) {
		TruckInfo truck = new TruckInfo();
		truck.setName(name);
		truck.setType(type);
		TruckInfo truck1 = new TruckInfo();
		truck1.setName("hello");
		truck1.setType("yo ");
		truckRepository.save(truck1);
		truckRepository.save(truck1);
		List<TruckInfo> list = (ArrayList<TruckInfo>) truckRepository.findAll();
		return list;
	}
	@RequestMapping(value = "/cs480/foodtruck/db/list", method = RequestMethod.GET)
	List<TruckInfo> dbGetTruckInfoList(){
		//TruckInfo truck = new TruckInfo();
		List<TruckInfo> list = (ArrayList<TruckInfo>) truckRepository.findAll();
		return list;
	}
	
	@RequestMapping(value = "/cs480/AC/TestAddress", method = RequestMethod.GET)
	public String JSTryAdd() throws IOException {
		GetYelpData.createJson("Mexican","","Pomona",0,0);
		return "File Created";
	}
	
	@RequestMapping(value = "/cs480/AC/TestCoord", method = RequestMethod.GET)
	public String JSTryCoord() throws IOException {
		GetYelpData.createJson("Mexican", null,null,34.018363,-118.492343);
		return "File Created";
	}
	
	//getting data from yelp and return a list
	@RequestMapping(value = "/cs480/foodtruck/yelp", method = RequestMethod.GET)
	List<TruckInfo> YelpListing() throws IOException {
		return truckManager.searchYelp("Mexican", null,null,34.018363,-118.492343);
	}

	
}