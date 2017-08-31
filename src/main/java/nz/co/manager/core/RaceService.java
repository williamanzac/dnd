package nz.co.manager.core;

import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Race;
import nz.co.manager.jdbi.RaceDAO;

@Service
public class RaceService extends CRUDService<Race> {

	@Inject
	public RaceService(final RaceDAO raceDAO) {
		super(raceDAO);
	}

	private RaceDAO getDAO() {
		return (RaceDAO) dao;
	}

	@Override
	public Race update(final Race entity) {
		entity.getAbilityScoreAdjustments().forEach(a -> {
			if (a.getAbility() != null && a.getAbility().getId() == 0) {
				a.setAbility(null);
			}
		});
		return super.update(entity);
	}

	public List<Race> listSubRaces(final int id) {
		return getDAO().listSubRaces(id);
	}

	public Race addSubRace(final int id, final Race subRace) {
		getDAO().addSubRace(id, subRace);
		return subRace;
	}
}
