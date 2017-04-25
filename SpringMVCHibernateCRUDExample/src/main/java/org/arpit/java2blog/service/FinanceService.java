package org.arpit.java2blog.service;

import java.util.List;

import org.arpit.java2blog.dao.CountryDAO;
import org.arpit.java2blog.dao.FinanceDAO;
import org.arpit.java2blog.model.Country;
import org.arpit.java2blog.model.Finance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("financeService")
public class FinanceService {
	
	@Autowired
	FinanceDAO financeDao;
	
	@Transactional
	public List<Finance> getAllFinance() {
		return financeDao.getAllFinance();
	}

	@Transactional
	public Finance getFinance(int id) {
		return financeDao.getFinance(id);
	}

}
