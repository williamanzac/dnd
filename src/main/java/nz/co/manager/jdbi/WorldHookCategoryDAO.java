package nz.co.manager.jdbi;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import io.dropwizard.hibernate.AbstractDAO;
import nz.co.manager.api.WorldHook;
import nz.co.manager.api.WorldHookCategory;

@Service
public class WorldHookCategoryDAO extends AbstractDAO<WorldHookCategory> {

	private final WorldHookDAO worldHookDAO;

	@Inject
	public WorldHookCategoryDAO(final SessionFactory sessionFactory, final WorldHookDAO worldHookDAO) {
		super(sessionFactory);
		this.worldHookDAO = worldHookDAO;
	}

	public List<WorldHookCategory> listAll() throws HibernateException {
		return super.list(criteria());
	}

	@Override
	public WorldHookCategory get(final Serializable id) {
		return super.get(id);
	}

	@Override
	public WorldHookCategory persist(final WorldHookCategory entity) throws HibernateException {
		if (entity.getWorldHooks() != null) {
			for (WorldHook hook : entity.getWorldHooks()) {
				worldHookDAO.persist(hook);
			}
		}
		return super.persist(entity);
	}

	public void delete(final WorldHookCategory set) {
		currentSession().delete(set);
	}
}
