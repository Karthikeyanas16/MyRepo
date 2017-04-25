package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.Finance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FinanceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List<Finance> getAllFinance() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Finance> financeList = session.createQuery("from Finance").list();
		return financeList;
	}

	public Finance getFinance(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Finance finance = (Finance) session.get(Finance.class, new Integer(id));
		return finance;
	}

}
