package com.nagarro.spring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.criterion.Restrictions;

import com.nagarro.spring.dao.FlightDao;
import com.nagarro.spring.model.Flight;
import com.nagarro.spring.model.SearchingDetails;

public class FlightDaoImplementation implements FlightDao{
	
    
	private  SessionFactory sessionFactory ;
	
	public void save(Flight flight) {
		Session session = this.sessionFactory.openSession();
	
		Transaction tx = session.beginTransaction();
		session.persist(flight);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Flight> search(SearchingDetails search) {
		Session session = this.sessionFactory.openSession();
		List<Flight>updatedFlightList = null;

		try {
			
             System.out.println("one");
			Criteria cr = session.createCriteria(Flight.class);
			System.out.println("one");

			cr.add(Restrictions.eq("depLoc", search.getDepLoc()));
			System.out.println("one");
			cr.add(Restrictions.eq("arrLoc", search.getArrLoc()));
			System.out.println("one");
		//	cr.add(Restrictions.gt("validTill",search.getJourneyDate()));
			System.out.println("one");
			//cr.add(Restrictions.eq("clas",search.getClass()));
			System.out.println("two");
		//    cr.addOrder(Order.asc(search.getOrderBy()));
			System.out.println("three");

			//List<Flight> fli = new ArrayList<Flight>();
			 return cr.list();
/*			
			System.out.println("four");
			for (Iterator<Flight> iterator = fli.iterator(); iterator.hasNext();) {

				Flight flight = iterator.next();
				if (search.getFlightClass().equalsIgnoreCase("B")) {
					flight.setFare((float) (flight.getFare() * 1.4));
					updatedFlightList.add(flight);

				}
			}*/
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
		session.close();
		}
	  return updatedFlightList;

		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
