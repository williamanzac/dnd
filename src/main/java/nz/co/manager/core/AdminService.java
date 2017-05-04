package nz.co.manager.core;

import java.util.List;

import nz.co.manager.api.Ability;
import nz.co.manager.api.AbilityScore;
import nz.co.manager.api.Alignment;
import nz.co.manager.api.Condition;
import nz.co.manager.api.Duration;
import nz.co.manager.api.Language;
import nz.co.manager.api.School;
import nz.co.manager.jdbi.AbilityDAO;
import nz.co.manager.jdbi.AbilityScoreDAO;
import nz.co.manager.jdbi.AlignmentDAO;
import nz.co.manager.jdbi.ConditionDAO;
import nz.co.manager.jdbi.DurationDAO;
import nz.co.manager.jdbi.LanguageDAO;
import nz.co.manager.jdbi.SchoolDAO;

public class AdminService {
	private final AbilityScoreDAO abilityScoreDAO;
	private final AbilityDAO abilityDAO;
	private final DurationDAO durationDAO;
	private final SchoolDAO schoolDAO;
	private final ConditionDAO conditionDAO;
	private final AlignmentDAO alignmentDAO;
	private final LanguageDAO languageDAO;

	public AdminService(final AbilityScoreDAO abilityScoreDAO, final AbilityDAO abilityDAO,
			final DurationDAO durationDAO, final SchoolDAO schoolDAO, final ConditionDAO conditionDAO,
			final AlignmentDAO alignmentDAO, final LanguageDAO languageDAO) {
		this.abilityScoreDAO = abilityScoreDAO;
		this.abilityDAO = abilityDAO;
		this.durationDAO = durationDAO;
		this.schoolDAO = schoolDAO;
		this.conditionDAO = conditionDAO;
		this.alignmentDAO = alignmentDAO;
		this.languageDAO = languageDAO;
	}

	public AbilityScore createAbilityScore(final AbilityScore score) {
		return abilityScoreDAO.persist(score);
	}

	public AbilityScore updateAbilityScore(final AbilityScore score) {
		return abilityScoreDAO.persist(score);
	}

	public AbilityScore readAbilityScore(final int id) {
		final AbilityScore set = abilityScoreDAO.get(id);
		return set;
	}

	public List<AbilityScore> listAbilityScores() {
		final List<AbilityScore> listAll = abilityScoreDAO.listAll();
		return listAll;
	}

	public void deleteAbilityScore(final AbilityScore score) {
		abilityScoreDAO.delete(score);
	}

	public Ability createAbility(final Ability score) {
		return abilityDAO.persist(score);
	}

	public Ability updateAbility(final Ability score) {
		return abilityDAO.persist(score);
	}

	public Ability readAbility(final int id) {
		return abilityDAO.get(id);
	}

	public List<Ability> listAbilities() {
		return abilityDAO.listAll();
	}

	public void deleteAbility(final Ability score) {
		abilityDAO.delete(score);
	}

	public Duration createDuration(final Duration score) {
		return durationDAO.persist(score);
	}

	public Duration updateDuration(final Duration score) {
		return durationDAO.persist(score);
	}

	public Duration readDuration(final int id) {
		return durationDAO.get(id);
	}

	public List<Duration> listDurations() {
		return durationDAO.listAll();
	}

	public void deleteDuration(final Duration score) {
		durationDAO.delete(score);
	}

	public School createSchool(final School score) {
		return schoolDAO.persist(score);
	}

	public School updateSchool(final School score) {
		return schoolDAO.persist(score);
	}

	public School readSchool(final int id) {
		return schoolDAO.get(id);
	}

	public List<School> listSchools() {
		return schoolDAO.listAll();
	}

	public void deleteSchool(final School score) {
		schoolDAO.delete(score);
	}

	public Condition createCondition(final Condition score) {
		return conditionDAO.persist(score);
	}

	public Condition updateCondition(final Condition score) {
		return conditionDAO.persist(score);
	}

	public Condition readCondition(final int id) {
		return conditionDAO.get(id);
	}

	public List<Condition> listConditions() {
		return conditionDAO.listAll();
	}

	public void deleteCondition(final Condition score) {
		conditionDAO.delete(score);
	}

	public Language createLanguage(final Language score) {
		return languageDAO.persist(score);
	}

	public Language updateLanguage(final Language score) {
		return languageDAO.persist(score);
	}

	public Language readLanguage(final int id) {
		return languageDAO.get(id);
	}

	public List<Language> listLanguages() {
		return languageDAO.listAll();
	}

	public void deleteLanguage(final Language score) {
		languageDAO.delete(score);
	}

	public Alignment createAlignment(final Alignment score) {
		return alignmentDAO.persist(score);
	}

	public Alignment updateAlignment(final Alignment score) {
		return alignmentDAO.persist(score);
	}

	public Alignment readAlignment(final int id) {
		return alignmentDAO.get(id);
	}

	public List<Alignment> listAlignments() {
		return alignmentDAO.listAll();
	}

	public void deleteAlignment(final Alignment score) {
		alignmentDAO.delete(score);
	}
}
