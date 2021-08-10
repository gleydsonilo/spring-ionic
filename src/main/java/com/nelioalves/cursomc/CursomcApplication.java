package com.nelioalves.cursomc;

import com.nelioalves.cursomc.domain.Category;
import com.nelioalves.cursomc.domain.City;
import com.nelioalves.cursomc.domain.Product;
import com.nelioalves.cursomc.domain.State;
import com.nelioalves.cursomc.repositories.CategoryRepository;
import com.nelioalves.cursomc.repositories.CityRepository;
import com.nelioalves.cursomc.repositories.ProductRepository;
import com.nelioalves.cursomc.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category("Informática");
		Category cat2 = new Category("Escritório");

		Product p1 = new Product("Computador", 2000.00);
		Product p2 = new Product("Impressora", 800.00);
		Product p3 = new Product("Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));



		State st1 = new State("Minas Gerais");
		State st2 = new State("São Paulo");

		City c1 = new City("Uberlandia", st1);
		City c2 = new City("São Paulo", st2);
		City c3 = new City("Campinas", st2);

		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

	}
}
