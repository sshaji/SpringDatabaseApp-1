package com.shaji.java.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.shaji.java.main.model.Offer;
import com.shaji.java.main.model.OffersDAO;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/shaji/java/main/beans/beans.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");

		/*
		System.out.println("Create one offer :");
		int retCreate = offersDao.createOffer(new Offer("Sheeja", "sheeja@test.com", "I can cook"));
		System.out.println("Created : " + retCreate);
		*/
		
		/*
		System.out.println("Create batch : ");
		List<Offer> offers = new ArrayList<Offer>();
		offers.add(new Offer(100, "John", "john@test.com", "I can fix kitchen"));
		offers.add(new Offer(101, "Ted", "ted@test.com", "I can fix roof"));
		
		try {
			int[] retCreateBatch = offersDao.createOffers(offers);
			for(int value : retCreateBatch) {
				System.out.println("Created : " + value);
			}
		} catch (DataAccessException ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		*/
		
		System.out.println("Update batch : ");
		List<Offer> offers = new ArrayList<Offer>();
		offers.add(new Offer(100, "John", "john@test2.com", "I can fix kitchen"));
		offers.add(new Offer(101, "Ted", "ted@test2.com", "I can fix roof"));
		
		try {
			int[] retUpdateBatch = offersDao.updateOffers(offers);
			for(int value : retUpdateBatch) {
				System.out.println("Updated : " + value);
			}
		} catch (DataAccessException ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		System.out.println("All Offers :");
		for (Offer offer : offersDao.getOffers()) {
			System.out.println(offer);
		}
		
		System.out.println("By Id : 1 :");
		System.out.println(offersDao.getOfferById(1));

		((ClassPathXmlApplicationContext) context).close();
	}

}
