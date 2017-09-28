package nz.co.manager.core;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Language;
import nz.co.manager.api.Race;
import nz.co.manager.jdbi.LanguageDAO;
import nz.co.manager.jdbi.RaceDAO;

@Service
public class RaceService extends CRUDService<Race> {

	private final LanguageDAO langDAO;

	@Inject
	public RaceService(final RaceDAO raceDAO, final LanguageDAO langDAO) {
		super(raceDAO);
		this.langDAO = langDAO;
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
		final ListIterator<String> listIterator = entity.getLanguages().listIterator();
		for (; listIterator.hasNext();) {
			final String next = listIterator.next();
			if (next == null) {
				listIterator.set("");
			}
		}
		return super.update(entity);
	}

	public List<Race> listSubRaces(final int id) {
		return getDAO().listSubRaces(id);
	}

	public Race addSubRace(final int id, final Race subRace) {
		getDAO().addSubRace(id, subRace);
		return subRace;
	}

	public Set<Language> getLanguages(final int id) {
		final Race race = getDAO().find(id);
		final Set<Language> languages = new HashSet<>();
		race.getLanguages().forEach(l -> {
			Language language = langDAO.findBy(l);
			if (language == null) {
				language = new Language();
			}
			languages.add(language);
		});
		if (race.getParent() != null) {
			race.getParent().getLanguages().forEach(l -> {
				Language language = langDAO.findBy(l);
				if (language == null) {
					language = new Language();
				}
				languages.add(language);
			});
		}
		return languages;
	}
}
