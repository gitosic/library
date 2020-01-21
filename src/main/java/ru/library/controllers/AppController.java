package ru.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.library.entity.Book;
import ru.library.service.BookService;

@Controller
public class AppController {

	@Autowired
	public BookService bookService;

	@RequestMapping(value = {"/books**"}, method = {RequestMethod.GET})
	public String getiAllBooks(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "booksList";
	}

	@RequestMapping(value = {"/addBook"}, method = {RequestMethod.GET})
	public String createBookPage() {
		return "createBook";//createBook
	}

	@RequestMapping(value = {"/addBook"}, method = {RequestMethod.POST})
	public String addBook(@ModelAttribute("book") Book book) throws Exception {
		bookService.save(book);
		return "redirect:/books";
	}

	@RequestMapping(value = {"/delete/{id}"}, method = {RequestMethod.GET})
	public String deleteBook(@PathVariable("id") int id) {
		bookService.delete(id);
		return "redirect:/books";
	}

	@RequestMapping(value = {"/updateBook"}, method = {RequestMethod.POST})
	public String updateBook(@ModelAttribute("book") Book book) throws Exception {
		bookService.update(book);
		return "redirect:/books";//return "redirect:book/" + book.getId();
	}

	@RequestMapping(value = {"update/{id}"}, method = {RequestMethod.GET})
	public String updateBook(@PathVariable("id") int id, Model model) {
		model.addAttribute("book", bookService.getById(id));
		return "editBook";
	}

	/*@RequestMapping(value = {"/book/{id}"}, method = {RequestMethod.GET})
		public String getById(@PathVariable("id") int id, Model model) {
			model.addAttribute("book", bookService.getById(id));
			return "showBook";
		}*/

	@RequestMapping(value = {"/", "/index**"}, method = {RequestMethod.GET})
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Tutorial");
		model.addObject("message", "Welcome Page !");
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = {"/free**"}, method = {RequestMethod.GET})
		public ModelAndView freePage() {
			ModelAndView model = new ModelAndView();
			model.addObject("title", "av1");
			model.addObject("message", "av2");
			model.setViewName("free");
			return model;
		}

	@RequestMapping(value = {"/free2**"}, method = {RequestMethod.GET})
			public ModelAndView freePage2() {
				ModelAndView model = new ModelAndView();
				model.addObject("title", "qa1222");
				model.addObject("message", "ws2333");
				model.setViewName("free2");
				return model;
			}

	@RequestMapping(value = "/protected**", method = RequestMethod.GET)
	public ModelAndView protectedPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
		model.addObject("message", "This is protected page - Only for Admin Users!");
		model.setViewName("protected");
		return model;

	}

	@RequestMapping(value = "/confidential**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
		model.addObject("message", "This is confidential page - Need Super Admin Role!");
		model.setViewName("protected");

		return model;

	}
}
