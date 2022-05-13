package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Answer;
import com.example.demo.Model.Question;
import com.example.demo.Model.User;
import com.example.demo.Repository.AnswerRepository;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Services.QuestionService;

@Controller
public class ForwardController {

	@Autowired
	QuestionRepository questionRepo;	
	
	@Autowired
	AnswerRepository answerRepository;
	
	@RequestMapping(value="/setting", method=RequestMethod.GET)
	public String settingForward(Model model,HttpSession session) {
	User user=	(User) session.getAttribute("userlogin");
		model.addAttribute("user", user);
		
		return "setting_profile";
	}
	
	

	@RequestMapping(value="/question", method=RequestMethod.GET)
	public void questionForward(Model model,HttpSession session,HttpServletResponse response) {
	User user=	(User) session.getAttribute("userlogin");
		model.addAttribute("user", user);
		try {
			
			response.sendRedirect("/question/getquestions?id="+user.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return "";
	}
	
	
	@RequestMapping("/answerQuestion/{questionId}")
	public String answerQuestionForward(@PathVariable int questionId, Model model) {
		System.out.println(questionId);
		
	Question question= questionRepo.findById(questionId).get();
	
	model.addAttribute("questiondata", question);
	Answer ans = new Answer();
	ans.setQuestion(question);
	ans.setUser(question.getRecUser());
	model.addAttribute("answer",ans );
		return "answerpeople";
	}
	
	
	@RequestMapping("/profile")
	public String profileForward(HttpSession session, Model model) {
		
		User userlogin = (User) session.getAttribute("userlogin");

		model.addAttribute("user", userlogin);

		System.out.println(userlogin.getId());
		List<Answer> anslist = answerRepository.findByUserId(userlogin.getId());
		model.addAttribute("answers", anslist);

		return "profile";
		
	}
	
	
	
}
