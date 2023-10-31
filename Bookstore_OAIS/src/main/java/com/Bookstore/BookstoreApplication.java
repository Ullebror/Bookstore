package com.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.Bookstore.model.Book;
import com.Bookstore.model.BookRepository;
import com.Bookstore.model.Category;
import com.Bookstore.model.CategoryRepository;

import com.Bookstore.model.AppUser;
import com.Bookstore.model.AppUserRepository;

@SpringBootApplication
public class BookstoreApplication extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BookstoreApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, AppUserRepository urepository) {
		return (args) -> {
			/*log.info("save categories");
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Dystopian"));
			crepository.save(new Category("Sci-fi"));
			log.info("save a couple of books");
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 20.00,
					crepository.findByName("Horror").get(0)));
			repository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 25.00,
					crepository.findByName("Dystopian").get(0)));

			// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"ADMIN");
			urepository.save(user1);
			urepository.save(user2);*/

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());

				log.info("fetch all categories");
				for (Category category : crepository.findAll()) {
					log.info(category.toString());
				}
			}

		};

	}

}
