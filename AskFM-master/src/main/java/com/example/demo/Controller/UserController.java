package com.example.demo.Controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Model.Answer;
import com.example.demo.Model.User;
import com.example.demo.Repository.AnswerRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// insert, delete , update, findBYID , findBYUserName, findAll
	/*
	 * url and param for all methods in user Controller
	 * 
	 * 					URL						method				Body            
	 * add ->      		/add					post				user
	 * delete ->   		/delete					DELETE				param (id:int)
	 * update ->   		/update					PUT					user , param(id:int)
	 * userBYid->  		/getuser				GET					param (id:int)
	 * userBYUserName-> /getuser/{userName}		GET					var(userName:String)
	 * allUsers ->		/allusers				GET
	 * 
	 * */

	@Autowired
	UserService userService;
	
	@Autowired
	AnswerRepository answerRepository;

	@RequestMapping(value = "/add",
			method = RequestMethod.POST)
	public String addUser(@ModelAttribute User user) {
       System.out.println(user.toString());
       
		userService.addUser(user);

		System.out.println("user Saved !");
		return "index";

	}
	

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	// @ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteUser(@RequestParam int id) {

		userService.deleteUser(id);
		System.out.println("user deleted !");
	}

	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute User user, @RequestParam int id) {
System.out.println("id ===========  "+id);
System.out.println(user.toString());
		userService.updateUser(user, id);;
		
		System.out.println("User Updated !");
	
		
		return "setting_profile";
	}

	
	/*
	 *@param id to get user account data
	 * */
@RequestMapping(value="/getuser",method = RequestMethod.GET)	
@ResponseBody
	public User getUserById(@RequestParam int id) {
		
		return userService.getUserById(id);

	}

/*
 * @param username for view other user data
 * */
@RequestMapping(value="/getuser/{userName}",method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)	
public String getUserByUserName(@PathVariable(value= "userName") String userName ,HttpSession session,
		Model model) {
	
	System.out.println("UserName : "+userName);
	User userprofile=	userService.getUserByUserName(userName);
	
	
//	User userlogin = (User) session.getAttribute("userlogin");

	model.addAttribute("user", userprofile);

	System.out.println(userprofile.getId());
	List<Answer> anslist = answerRepository.findByUserUserName(userName);
	model.addAttribute("answers", anslist);

	return "profile";
	

}	


/*
 * this method for admin 
 * */
@RequestMapping(value="/allusers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public void getAllUsers() {
	
userService.getAllUsers();
	
}







}
