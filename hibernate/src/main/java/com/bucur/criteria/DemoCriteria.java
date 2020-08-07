package com.bucur.criteria;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

import static com.bucur.criteria.Gender.FEMALE;
import static com.bucur.criteria.Gender.MALE;

public class DemoCriteria {

    public static void main(String[] args) {
        createTravelers();

        TravelerDao travelerDao = new TravelerDao();

        System.out.println("\r\nAll travelers:");
        travelerDao.findAll().forEach(traveler -> System.out.println(traveler));

        System.out.println("\r\nTravelers from Switzerland:");
        travelerDao.findByCountryCode("SW").forEach(traveler -> System.out.println(traveler));

        System.out.println("\r\nFemale travelers from Switzerland:");
        travelerDao.findByGenderAndCountry(FEMALE, "SW").forEach(traveler -> System.out.println(traveler));
    }

    private static void createTravelers() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Country romania = new Country("Romania", "RO");
        Country switzerland = new Country("Switzerland", "SW");

        session.save(romania);
        session.save(switzerland);

        Traveler t1 = new Traveler();
        t1.setEmail("ana@gmail.com");
        t1.setPassword("secret");
        t1.setCountry(romania);
        t1.setGender(FEMALE);

        Traveler t2 = new Traveler();
        t2.setEmail("anto@gmail.com");
        t2.setPassword("secret");
        t2.setCountry(switzerland);
        t2.setGender(FEMALE);

        Traveler t3 = new Traveler();
        t3.setEmail("jon@gmail.com");
        t3.setPassword("secret");
        t3.setCountry(switzerland);
        t3.setGender(MALE);

        Traveler t4 = new Traveler();
        t4.setEmail("iuliu@gmail.com");
        t4.setPassword("secret");
        t4.setCountry(romania);
        t4.setGender(MALE);

        List<Traveler> travelers = Arrays.asList(t1, t3, t3, t4);
        travelers.forEach(traveler -> session.save(traveler));

        transaction.commit();
        session.close();
    }
}
