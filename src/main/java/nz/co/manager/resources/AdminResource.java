package nz.co.manager.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.hibernate.UnitOfWork;
import nz.co.manager.api.Ability;
import nz.co.manager.api.AbilityScore;
import nz.co.manager.api.Alignment;
import nz.co.manager.api.Condition;
import nz.co.manager.api.Duration;
import nz.co.manager.api.Gear;
import nz.co.manager.api.Language;
import nz.co.manager.api.School;
import nz.co.manager.core.AdminService;

@Path("/admin")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminResource {
	private final AdminService adminService;

	@Inject
	public AdminResource(final AdminService adminService) {
		this.adminService = adminService;
	}

	@Path("/abilityScores")
	@POST
	@UnitOfWork
	public AbilityScore createAbilityScore(final AbilityScore score) {
		return adminService.createAbilityScore(score);
	}

	@Path("/abilityScores")
	@PUT
	@UnitOfWork
	public AbilityScore updateAbilityScore(final AbilityScore score) {
		return adminService.updateAbilityScore(score);
	}

	@Path("/abilityScores/{id}")
	@GET
	@UnitOfWork
	public AbilityScore readAbilityScore(final @PathParam("id") int id) {
		final AbilityScore set = adminService.readAbilityScore(id);
		return set;
	}

	@Path("/abilityScores")
	@GET
	@UnitOfWork
	public List<AbilityScore> listAbilityScores() {
		final List<AbilityScore> listAll = adminService.listAbilityScores();
		return listAll;
	}

	@Path("/abilityScores/{id}")
	@DELETE
	@UnitOfWork
	public void deleteAbilityScore(final @PathParam("id") int id) {
		final AbilityScore score = adminService.readAbilityScore(id);
		adminService.deleteAbilityScore(score);
	}

	@Path("/abilities")
	@POST
	@UnitOfWork
	public Ability createAbility(final Ability score) {
		return adminService.createAbility(score);
	}

	@Path("/abilities")
	@PUT
	@UnitOfWork
	public Ability updateAbility(final Ability score) {
		return adminService.updateAbility(score);
	}

	@Path("/abilities/{id}")
	@GET
	@UnitOfWork
	public Ability readAbility(final @PathParam("id") int id) {
		final Ability set = adminService.readAbility(id);
		return set;
	}

	@Path("/abilities")
	@GET
	@UnitOfWork
	public List<Ability> listAbilities() {
		final List<Ability> listAll = adminService.listAbilities();
		return listAll;
	}

	@Path("/abilities/{id}")
	@DELETE
	@UnitOfWork
	public void deleteAbility(final @PathParam("id") int id) {
		final Ability score = adminService.readAbility(id);
		adminService.deleteAbility(score);
	}

	@Path("/durations")
	@POST
	@UnitOfWork
	public Duration createDuration(final Duration score) {
		return adminService.createDuration(score);
	}

	@Path("/durations")
	@PUT
	@UnitOfWork
	public Duration updateDuration(final Duration score) {
		return adminService.updateDuration(score);
	}

	@Path("/durations/{id}")
	@GET
	@UnitOfWork
	public Duration readDuration(final @PathParam("id") int id) {
		final Duration set = adminService.readDuration(id);
		return set;
	}

	@Path("/durations")
	@GET
	@UnitOfWork
	public List<Duration> listDurations() {
		final List<Duration> listAll = adminService.listDurations();
		return listAll;
	}

	@Path("/durations/{id}")
	@DELETE
	@UnitOfWork
	public void deleteDuration(final @PathParam("id") int id) {
		final Duration score = adminService.readDuration(id);
		adminService.deleteDuration(score);
	}

	@Path("/schools")
	@POST
	@UnitOfWork
	public School createSchool(final School score) {
		return adminService.createSchool(score);
	}

	@Path("/schools")
	@PUT
	@UnitOfWork
	public School updateSchool(final School score) {
		return adminService.updateSchool(score);
	}

	@Path("/schools/{id}")
	@GET
	@UnitOfWork
	public School readSchool(final @PathParam("id") int id) {
		final School set = adminService.readSchool(id);
		return set;
	}

	@Path("/schools")
	@GET
	@UnitOfWork
	public List<School> listSchools() {
		final List<School> listAll = adminService.listSchools();
		return listAll;
	}

	@Path("/schools/{id}")
	@DELETE
	@UnitOfWork
	public void deleteSchool(final @PathParam("id") int id) {
		final School score = adminService.readSchool(id);
		adminService.deleteSchool(score);
	}

	@Path("/conditions")
	@POST
	@UnitOfWork
	public Condition createCondition(final Condition score) {
		return adminService.createCondition(score);
	}

	@Path("/conditions")
	@PUT
	@UnitOfWork
	public Condition updateCondition(final Condition score) {
		return adminService.updateCondition(score);
	}

	@Path("/conditions/{id}")
	@GET
	@UnitOfWork
	public Condition readCondition(final @PathParam("id") int id) {
		final Condition set = adminService.readCondition(id);
		return set;
	}

	@Path("/conditions")
	@GET
	@UnitOfWork
	public List<Condition> listConditions() {
		final List<Condition> listAll = adminService.listConditions();
		return listAll;
	}

	@Path("/conditions/{id}")
	@DELETE
	@UnitOfWork
	public void deleteCondition(final @PathParam("id") int id) {
		final Condition score = adminService.readCondition(id);
		adminService.deleteCondition(score);
	}

	@Path("/alignments")
	@POST
	@UnitOfWork
	public Alignment createAlignment(final Alignment score) {
		return adminService.createAlignment(score);
	}

	@Path("/alignments")
	@PUT
	@UnitOfWork
	public Alignment updateAlignment(final Alignment score) {
		return adminService.updateAlignment(score);
	}

	@Path("/alignments/{id}")
	@GET
	@UnitOfWork
	public Alignment readAlignment(final @PathParam("id") int id) {
		final Alignment set = adminService.readAlignment(id);
		return set;
	}

	@Path("/alignments")
	@GET
	@UnitOfWork
	public List<Alignment> listAlignments() {
		final List<Alignment> listAll = adminService.listAlignments();
		return listAll;
	}

	@Path("/alignments/{id}")
	@DELETE
	@UnitOfWork
	public void deleteAlignment(final @PathParam("id") int id) {
		final Alignment score = adminService.readAlignment(id);
		adminService.deleteAlignment(score);
	}

	@Path("/languages")
	@POST
	@UnitOfWork
	public Language createLanguage(final Language score) {
		return adminService.createLanguage(score);
	}

	@Path("/languages")
	@PUT
	@UnitOfWork
	public Language updateLanguage(final Language score) {
		return adminService.updateLanguage(score);
	}

	@Path("/languages/{id}")
	@GET
	@UnitOfWork
	public Language readLanguage(final @PathParam("id") int id) {
		final Language set = adminService.readLanguage(id);
		return set;
	}

	@Path("/languages")
	@GET
	@UnitOfWork
	public List<Language> listLanguages() {
		final List<Language> listAll = adminService.listLanguages();
		return listAll;
	}

	@Path("/languages/{id}")
	@DELETE
	@UnitOfWork
	public void deleteLanguage(final @PathParam("id") int id) {
		final Language score = adminService.readLanguage(id);
		adminService.deleteLanguage(score);
	}

	@Path("/gear")
	@POST
	@UnitOfWork
	public Gear createGear(final Gear score) {
		return adminService.createGear(score);
	}

	@Path("/gear")
	@PUT
	@UnitOfWork
	public Gear updateGear(final Gear score) {
		return adminService.updateGear(score);
	}

	@Path("/gear/{id}")
	@GET
	@UnitOfWork
	public Gear readGear(final @PathParam("id") int id) {
		final Gear set = adminService.readGear(id);
		return set;
	}

	@Path("/gear")
	@GET
	@UnitOfWork
	public List<Gear> listGear() {
		final List<Gear> listAll = adminService.listGear();
		return listAll;
	}

	@Path("/gear/{id}")
	@DELETE
	@UnitOfWork
	public void deleteGear(final @PathParam("id") int id) {
		final Gear score = adminService.readGear(id);
		adminService.deleteGear(score);
	}
}
