package nz.co.manager.core;

import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Ability;
import nz.co.manager.api.AbilityScore;
import nz.co.manager.api.Alignment;
import nz.co.manager.api.Condition;
import nz.co.manager.api.Duration;
import nz.co.manager.api.Gear;
import nz.co.manager.api.Language;
import nz.co.manager.api.School;
import nz.co.manager.jdbi.AbilityDAO;
import nz.co.manager.jdbi.AbilityScoreDAO;
import nz.co.manager.jdbi.AlignmentDAO;
import nz.co.manager.jdbi.ConditionDAO;
import nz.co.manager.jdbi.DurationDAO;
import nz.co.manager.jdbi.GearDAO;
import nz.co.manager.jdbi.LanguageDAO;
import nz.co.manager.jdbi.SchoolDAO;

@Service
public class AdminService {
	private final AbilityScoreDAO abilityScoreDAO;
	private final AbilityDAO abilityDAO;
	private final DurationDAO durationDAO;
	private final SchoolDAO schoolDAO;
	private final ConditionDAO conditionDAO;
	private final AlignmentDAO alignmentDAO;
	private final LanguageDAO languageDAO;
	private final GearDAO gearDAO;

	@Inject
	public AdminService(final AbilityScoreDAO abilityScoreDAO, final AbilityDAO abilityDAO,
			final DurationDAO durationDAO, final SchoolDAO schoolDAO, final ConditionDAO conditionDAO,
			final AlignmentDAO alignmentDAO, final LanguageDAO languageDAO, final GearDAO gearDAO) {
		this.abilityScoreDAO = abilityScoreDAO;
		this.abilityDAO = abilityDAO;
		this.durationDAO = durationDAO;
		this.schoolDAO = schoolDAO;
		this.conditionDAO = conditionDAO;
		this.alignmentDAO = alignmentDAO;
		this.languageDAO = languageDAO;
		this.gearDAO = gearDAO;
	}

	public AbilityScore createAbilityScore(final AbilityScore entity) {
		abilityScoreDAO.add(entity);
		return entity;
	}

	public AbilityScore updateAbilityScore(final AbilityScore entity) {
		abilityScoreDAO.update(entity);
		return entity;
	}

	public AbilityScore readAbilityScore(final int id) {
		return abilityScoreDAO.find(id);
	}

	public List<AbilityScore> listAbilityScores() {
		return abilityScoreDAO.list();
	}

	public void deleteAbilityScore(final AbilityScore entity) {
		abilityScoreDAO.remove(entity);
	}

	public Ability createAbility(final Ability entity) {
		abilityDAO.add(entity);
		return entity;
	}

	public Ability updateAbility(final Ability entity) {
		abilityDAO.update(entity);
		return entity;
	}

	public Ability readAbility(final int id) {
		return abilityDAO.find(id);
	}

	public List<Ability> listAbilities() {
		return abilityDAO.list();
	}

	public void deleteAbility(final Ability entity) {
		abilityDAO.remove(entity);
	}

	public Duration createDuration(final Duration entity) {
		durationDAO.add(entity);
		return entity;
	}

	public Duration updateDuration(final Duration entity) {
		durationDAO.update(entity);
		return entity;
	}

	public Duration readDuration(final int id) {
		return durationDAO.find(id);
	}

	public List<Duration> listDurations() {
		return durationDAO.list();
	}

	public void deleteDuration(final Duration entity) {
		durationDAO.remove(entity);
	}

	public School createSchool(final School entity) {
		schoolDAO.add(entity);
		return entity;
	}

	public School updateSchool(final School entity) {
		schoolDAO.update(entity);
		return entity;
	}

	public School readSchool(final int id) {
		return schoolDAO.find(id);
	}

	public List<School> listSchools() {
		return schoolDAO.list();
	}

	public void deleteSchool(final School entity) {
		schoolDAO.remove(entity);
	}

	public Condition createCondition(final Condition entity) {
		conditionDAO.add(entity);
		return entity;
	}

	public Condition updateCondition(final Condition entity) {
		conditionDAO.update(entity);
		return entity;
	}

	public Condition readCondition(final int id) {
		return conditionDAO.find(id);
	}

	public List<Condition> listConditions() {
		return conditionDAO.list();
	}

	public void deleteCondition(final Condition entity) {
		conditionDAO.remove(entity);
	}

	public Language createLanguage(final Language entity) {
		languageDAO.add(entity);
		return entity;
	}

	public Language updateLanguage(final Language entity) {
		languageDAO.update(entity);
		return entity;
	}

	public Language readLanguage(final int id) {
		return languageDAO.find(id);
	}

	public List<Language> listLanguages() {
		return languageDAO.list();
	}

	public void deleteLanguage(final Language entity) {
		languageDAO.remove(entity);
	}

	public Alignment createAlignment(final Alignment entity) {
		alignmentDAO.add(entity);
		return entity;
	}

	public Alignment updateAlignment(final Alignment entity) {
		alignmentDAO.update(entity);
		return entity;
	}

	public Alignment readAlignment(final int id) {
		return alignmentDAO.find(id);
	}

	public List<Alignment> listAlignments() {
		return alignmentDAO.list();
	}

	public void deleteAlignment(final Alignment entity) {
		alignmentDAO.remove(entity);
	}

	public Gear createGear(final Gear entity) {
		gearDAO.add(entity);
		return entity;
	}

	public Gear updateGear(final Gear entity) {
		gearDAO.update(entity);
		return entity;
	}

	public Gear readGear(final int id) {
		return gearDAO.find(id);
	}

	public List<Gear> listGear() {
		return gearDAO.list();
	}

	public void deleteGear(final Gear entity) {
		gearDAO.remove(entity);
	}
}
