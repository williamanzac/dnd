package nz.co.manager.jdbi;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.CharacterAdvancement;

@Service
public class CharacterAdvancementDAO extends HibernateDAO<CharacterAdvancement> {

	@Inject
	public CharacterAdvancementDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
