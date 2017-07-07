package nz.co.manager.jdbi;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.DisplayType;

@Service
public class DisplayTypeDAO extends HibernateDAO<DisplayType> {

	@Inject
	public DisplayTypeDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DisplayType> getBy(final String name) {
		return currentSession().createCriteria(daoType).add(Restrictions.eq("name", name)).list();
	}
}
