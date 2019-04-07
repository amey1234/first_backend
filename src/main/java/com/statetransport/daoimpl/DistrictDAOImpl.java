package com.statetransport.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.statetransport.dao.DistrictsDAO;
import com.statetransport.entity.Districts;
import com.statetransport.exception.DistrictException;
import com.statetransport.exception.DistrictException.DistrictsException;

@Repository
@Transactional
public class DistrictDAOImpl implements DistrictsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Districts createNewDistrict(Districts districts) throws DistrictException {
		sessionFactory.getCurrentSession().save(districts);
		return districts;
	}

	@Override
	public void checkDistrictByName(String name) throws DistrictException {
		String query = "from Districts where name='" + name + "' and status=true";
		Districts district = (Districts) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
		if (district != null) {
			throw new DistrictException(DistrictsException.DISTRICT_ALREADY_EXIST);
		}
	}

	@Override
	public List<Districts> getAllDistricts() throws DistrictException {
		String query = "from Districts where status=true";
		List<Districts> districtList = sessionFactory.getCurrentSession().createQuery(query).list();
		if (districtList.isEmpty()) {
			throw new DistrictException(DistrictsException.DISTRICTS_NOT_FOUND);
		}
		return districtList;
	}

	@Override
	public Districts getDistrictById(Integer id) throws DistrictException {
		String query = "from Districts where id=" + id + " and status=true";
		Districts district = (Districts) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
		if (district == null) {
			throw new DistrictException(DistrictsException.DISTRICTS_NOT_FOUND);
		}
		return district;
	}

}
