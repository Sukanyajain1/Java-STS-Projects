package com.sj.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sj.bookclub.models.Book;
import com.sj.bookclub.models.LoginUser;
import com.sj.bookclub.models.User;
import com.sj.bookclub.services.BookService;
import com.sj.bookclub.services.UserService;


@Controller
public class MainController {
	 // Add once service is implemented:
//     @Autowired
     private UserService userServ;
     private BookService bookServ;
    
     public MainController(UserService userServ, BookService bookServ) {
 		this.userServ = userServ;
 		this.bookServ = bookServ;
 	}
     
// 	----------------------------------------------------------------------
// 	LOGIN PAGE
// 	----------------------------------------------------------------------
    @GetMapping("/")
    public String index(HttpSession session, Model model) {
    	session.invalidate();
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("user_id");
//    	if (userId != null) {
//    		session.invalidate();
//    	}
    	System.out.println("The register is working!!!!!!!!!!!!!!!!!");
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
    
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("user_id");
//    	if (userId != null) {
//    		session.invalidate();
//    	}
    	System.out.println("The login is working!!!!!!!!!!!!!!!!!");
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    	User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
//        User currentUser = userServ.findUserByEmail(newLogin.getEmail());
        session.setAttribute("user_id", user.getId());
        return "redirect:/dashboard";
    }
    
    
//	----------------------------------------------------------------------
//	SHOW ALL THE BOOKS EVER CREATED -- DASHBOARD
//	----------------------------------------------------------------------
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model, RedirectAttributes flash) {
    	System.out.println("The dashboard is working!!!!!!!!!!!!!!!!!");
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
//    		let the user know that they didn't log in/register to get access to the dash board.
    		flash.addFlashAttribute("logAlert", "Looks like you're not logged in! Please enter your credentials below to access the Dashboard!");
    		return "redirect:/";
    	}
    	
    	List<Book> allBooks = bookServ.allBooks();
    	User currentUser = userServ.findUser(userId);
//    	System.out.println("Before list books!!!!!!!!!!!!!!!!!");
		model.addAttribute ("currentUser", currentUser);
		model.addAttribute ("allBooks", allBooks);
		System.out.println("after the models!!!!!!!!!!!!!!!!!");
    	return "dashboard.jsp";
    }
    
    
//	----------------------------------------------------------------------
//	SHOW ONE BOOK
//	----------------------------------------------------------------------
	@GetMapping("/show/{id}")
	public String showOneBook(@PathVariable("id") Long id, Model model) {
		Book oneBook = bookServ.findBook(id);
		model.addAttribute("oneBook", oneBook);
		System.out.println("One Book is being shown!!!!!!!!!!!!!!!!!");
		return "showOneBook.jsp";
	}
    
    
    
    
//	----------------------------------------------------------------------
//	CREATE ONE BOOK
//	----------------------------------------------------------------------
	@GetMapping("/create")
	public String newBookForm(Model model, @ModelAttribute("book") Book book) {
		List<Book> books = bookServ.allBooks();
		model.addAttribute("books", books);
		return "newBook.jsp";
	}
	
	@PostMapping("/new")
	public String newBook(HttpSession session, Model model, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			List<Book> books = bookServ.allBooks();
			model.addAttribute("books", books);
			
			return "newBook.jsp";
		}
		else {
			Long userId = (Long) session.getAttribute("user_id");
	    	if (userId == null) {
	    		return "redirect:/";
	    	}
			User currentUser = userServ.findUser(userId);
			book.setUser(currentUser);
			bookServ.createBook(book);
			return "redirect:/dashboard";
		}
	}
    
    
    
    
    
//	----------------------------------------------------------------------
//	EDIT ONE BOOK
//	----------------------------------------------------------------------
	@GetMapping("/edit/{id}")
	public String updateForm(@PathVariable("id") Long id, Model model) {
		System.out.println("THE GET METHOD FOR THE UPDATE IS WORKING!!!!!!!!!!");
		Book oneBook = bookServ.findBook(id);
		model.addAttribute("oneBook", oneBook);
		Long testerId = oneBook.getId();
		System.out.println(testerId);
		return "editBook.jsp";
	}
//	System.out.println("THIS AN ERROR RESULT!!!!!!!!!!");
	
	@PutMapping("/update/processing/{id}")
    public String updateProcess(HttpSession session, @Valid @ModelAttribute("oneBook") Book book, BindingResult result) {
//		System.out.println("THE PUT METHOD FOR THE UPDATE IS STARTING!!!!!!!!!!");
		if (result.hasErrors()) {
            return "editBook.jsp";
        } else {
        	Long userId = (Long) session.getAttribute("user_id");
	    	if (userId == null) {
	    		return "redirect:/";
	    	}
			User currentUser = userServ.findUser(userId);
			book.setUser(currentUser);
        	bookServ.updateBook(book);
            return "redirect:/dashboard";
        }
	}
    

	
//	----------------------------------------------------------------------
//	DELETE BOOK
//	----------------------------------------------------------------------
	@GetMapping("/delete/{id}")
    public String logout(@PathVariable("id") Long id) {
		bookServ.deleteBookById(id);
		return "redirect:/dashboard";
	}
	
	
	
//	----------------------------------------------------------------------
//	LOGOUT METHOD -- NEED TO CLEAR THE SESSION (INVALIDATE)
//	----------------------------------------------------------------------
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    
    
    
    
}
