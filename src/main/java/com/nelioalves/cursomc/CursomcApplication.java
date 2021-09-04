package com.nelioalves.cursomc;

import com.nelioalves.cursomc.domain.*;
import com.nelioalves.cursomc.domain.enums.ClientType;
import com.nelioalves.cursomc.domain.enums.StatePayment;
import com.nelioalves.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private DemandRepository demandRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderedItemRepository orderedItemRepository;

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

		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PESSOAFISICA);
		cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));

		Address ad1 = new Address("Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Address ad2 = new Address("Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

		cli1.getAddresses().addAll(Arrays.asList(ad1, ad2));

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Demand ped1 = new Demand(null, sdf.parse("30/09/2017 10:32"), cli1, ad1);
		Demand ped2 = new Demand(null, sdf.parse("10/10/2017 19:35"), cli1, ad2);

		Payment pagto1 = new PaymentCard(null, StatePayment.QUITADO, ped1, 6);
		ped1.setPayment(pagto1);

		Payment pagto2 = new PaymentSlip(null, StatePayment.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPayment(pagto2);

		cli1.getDemands().addAll(Arrays.asList(ped1, ped2));

		demandRepository.saveAll(Arrays.asList(ped1, ped2));
		paymentRepository.saveAll(Arrays.asList(pagto1, pagto2));

		OrderedItem ip1 = new OrderedItem(ped1, p1, 0.00, 1, 2000.00);
		OrderedItem ip2 = new OrderedItem(ped1, p3, 0.00, 2, 80.00);
		OrderedItem ip3 = new OrderedItem(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		orderedItemRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
