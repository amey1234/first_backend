package com.statetransport.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.statetransport.dao.DepotDao;
import com.statetransport.entity.Depot;
import com.statetransport.exception.DepotException;
import com.statetransport.exception.DepotException.DepoException;

@Repository
@Transactional
public class DepotDaoImpl implements DepotDao {

	@Autowired
	private SessionFactory hibernateSession;

	@Override
	public void checkDepotNameIfPresent(Depot depot) throws DepotException {
		Criteria depotCriteria = hibernateSession.getCurrentSession().createCriteria(Depot.class);
		SimpleExpression depotNameRestriction = Restrictions.eq("depotName", depot.getDepotName());
		SimpleExpression address = Restrictions.eq("address", depot.getAddress());
		depotCriteria.add(Restrictions.and(depotNameRestriction, address));

		if (!depotCriteria.list().isEmpty()) {
			throw new DepotException(DepoException.DEPOT_ALREADY_EXIST);
		}
	}

	@Override
	public Depot createNewDepot(Depot depot) throws DepotException {
		hibernateSession.getCurrentSession().save(depot);
		return depot;
	}

	@Override
	public List<Depot> getall() throws DepotException {
		Criteria criteria = hibernateSession.getCurrentSession().createCriteria(Depot.class);
		criteria.add(Restrictions.eq("status", true));
		List<Depot> depotList = criteria.list();

		if (depotList.isEmpty()) {
			throw new DepotException(DepoException.DEPOT_NOT_FOUND);
		}
		return depotList;
	}

	@Override
	public Depot updateDepot(Depot depot) throws DepotException {
		hibernateSession.getCurrentSession().update(depot);
		return depot;
	}

	@Override
	public Depot getDepotById(int depotId) throws DepotException {

		Criteria criteria = hibernateSession.getCurrentSession().createCriteria(Depot.class);
		SimpleExpression idSearch = Restrictions.eq("id", depotId);
		SimpleExpression statusSearch = Restrictions.eq("status", true);
		criteria.add(Restrictions.and(idSearch, statusSearch));

		if (criteria.uniqueResult() == null) {
			throw new DepotException(DepoException.DEPOT_NOT_FOUND);

		}

		return (Depot) criteria.uniqueResult();
	}

	@Override
	public void deleteDepot(int depotId) throws DepotException {
		Criteria criteria = hibernateSession.getCurrentSession().createCriteria(Depot.class);
		SimpleExpression idSearch = Restrictions.eq("id", depotId);
		SimpleExpression statusSearch = Restrictions.eq("status", true);
		criteria.add(Restrictions.and(idSearch, statusSearch));

		if (criteria.uniqueResult() == null) {
			throw new DepotException(DepoException.DEPOT_NOT_FOUND);

		}
		
		Depot depot=(Depot) criteria.uniqueResult();
		
		depot.setStatus(false);
		hibernateSession.getCurrentSession().update(depot);
	}

}
