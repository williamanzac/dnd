package nz.co.manager.jdbi;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Race;

@Service
public class RaceDAO extends HibernateDAO<Race> {

	@Inject
	public RaceDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Race> list() {
		return currentSession().createCriteria(daoType).add(Restrictions.isNull("parent")).list();
	}

	@Override
	public void update(final Race entity) {
		final Race race = find(entity.getId());
		race.setAbilityScoreAdjustments(entity.getAbilityScoreAdjustments());
		race.setName(entity.getName());
		race.setLanguages(entity.getLanguages());
		race.setSpeed(entity.getSpeed());
		super.update(race);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Race> listSubRaces(final int id) {
		final List<Race> list = currentSession().createCriteria(daoType).add(Restrictions.eq("parent.id", id)).list();
		return list;
	}

	public void addSubRace(final int id, final Race subRace) {
		final Race parent = find(id);
		subRace.setParent(parent);
		add(subRace);
	}
}
