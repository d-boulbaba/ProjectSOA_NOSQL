/*package com.pj;

import com.pj.model.Book;
import com.pj.service.BookService;
import com.pj.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BookStoreApplication.class)
@AutoConfigureMockMvc
public class BookStoreH2DatabaseIntegrationTest
{
	@Autowired
	MockMvc mockMvc;


	@Autowired
	BookService bookService;

	@Test
	public void createPersons_And_GetPersonsTest() throws Exception
	{
		Book book = createBook("Spring Boot Essentials", 200, 12.23, "Craig");
		mockMvc.perform(get("/books").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$[0].title", is(book.getTitle())));
	}

	private Book createBook(String title, Integer numberOfPages, Integer NumberCopies,Integer NumberCopiesAvailable, String author)
	{
		Book book = new Book(title, numberOfPages, cost, author);
		bookService.insertBook(book);
		return book;
	}

	@Test
	public void whenValidInput_createPerson() throws Exception
	{
		Book book = createBook("Java Edition 9", 200, 12.23, "Craig");
		mockMvc.perform(post("/books/save_book").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(book)));
		List<Book> retrievedBooks = bookService.findAll();
		for (Book retrievedBook : retrievedBooks)
		{
			if (retrievedBook.getTitle().equals("Java Edition 9"))
				System.out.println("Success");
		}
		//assertThat(retrivedBooks).extracting(Book::getTitle).isEqualTo("Spring Essentials");
	}

	@Test
	public void getBook()
	{
		System.out.println("Book with id: 5b68baab7ab51f15c19908c6 ==>" + bookService.findById("5b68baab7ab51f15c19908c6"));
		System.out.println("Book with id: 0 ==> " + bookService.findById("0"));
	}


	@Test
	public void getAllBooks()
	{
		List<Book> books = bookService.findAll();
		for (Book book : books)
		{

			System.out.println("Book: " + book);
		}

	}

	@Test
	public void deleteBookById()
	{
		bookService.deleteById("0");
	}

	@Test
	public void deleteAllBooks()
	{
		bookService.deleteAll();
	}

	@Test
	public void updateBook()
	{
		if (bookService.findById("5b69d82cbdae811dade29e31").isPresent())
		{
			Book book = bookService.findById("5b69d82cbdae811dade29e31").get();
			System.out.println("Before Updating Book ==> " + book.toString());
			book.setCost(100.99);
			book.setNumberOfPages(1000);
			book.setAuthor("PJ");
			bookService.updateBook(book);
		}

	}

	@Test
	public void insertBillionRecords()
	{
		List<Book> bookList = new ArrayList<>(100000000);
		Book book;
		LocalDateTime startArrayListDateTime = LocalDateTime.now();
		for (int i = 0; i < 100000000; i++)
		{
			book = new Book("Spring Boot Essentials", 200, 12.23, "Craig");
			bookList.add(book);
		}

		Iterable<Book> booksIterable = new Iterable<Book>()
		{
			@Override
			public Iterator<Book> iterator()
			{
				return bookList.iterator();
			}
		};

		LocalDateTime endArrayListDateTime = LocalDateTime.now();
		calculateDifferenceInDates(startArrayListDateTime, endArrayListDateTime, "Time took to create Array List of billion records==> ");

		LocalDateTime startDateTime = LocalDateTime.now();
		bookService.insertAllBooks(booksIterable);
		LocalDateTime endDateTime = LocalDateTime.now();
		calculateDifferenceInDates(startDateTime, endDateTime, "Time took to insert billion records into DB ==> ");
	}

	private void calculateDifferenceInDates(LocalDateTime startDateTime, LocalDateTime endDateTime, String messsage)
	{
		long hours = startDateTime.until(endDateTime, ChronoUnit.HOURS);
		long minutes = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
		long seconds = startDateTime.until(endDateTime, ChronoUnit.SECONDS);
		long milliSeconds = startDateTime.until(endDateTime, ChronoUnit.MILLIS);
		long microSeconds = startDateTime.until(endDateTime, ChronoUnit.MICROS);
		long nanoSeconds = startDateTime.until(endDateTime, ChronoUnit.NANOS);
		System.out.println(messsage + hours + " hours " + minutes + " minutes " + seconds + " seconds " + milliSeconds + " milliSeconds " + microSeconds + " microSeconds " + nanoSeconds + " nanoSeconds");

	}
}
*/