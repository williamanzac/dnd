package nz.co.manager;

import org.hibernate.SessionFactory;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nz.co.manager.api.Ability;
import nz.co.manager.api.AbilityScore;
import nz.co.manager.api.Alignment;
import nz.co.manager.api.Character;
import nz.co.manager.api.CharacterClass;
import nz.co.manager.api.ClassLevel;
import nz.co.manager.api.Condition;
import nz.co.manager.api.Duration;
import nz.co.manager.api.HeightWeight;
import nz.co.manager.api.Language;
import nz.co.manager.api.NameSet;
import nz.co.manager.api.Race;
import nz.co.manager.api.School;
import nz.co.manager.api.Spell;
import nz.co.manager.core.AdminService;
import nz.co.manager.core.DiceService;
import nz.co.manager.core.HeightWeightService;
import nz.co.manager.core.NameGenerator;
import nz.co.manager.jdbi.AbilityDAO;
import nz.co.manager.jdbi.AbilityScoreDAO;
import nz.co.manager.jdbi.AlignmentDAO;
import nz.co.manager.jdbi.ConditionDAO;
import nz.co.manager.jdbi.DurationDAO;
import nz.co.manager.jdbi.HeightWeightDAO;
import nz.co.manager.jdbi.LanguageDAO;
import nz.co.manager.jdbi.NameSetDAO;
import nz.co.manager.jdbi.SchoolDAO;
import nz.co.manager.resources.AdminResource;
import nz.co.manager.resources.ToolResource;

public class ManageApp extends Application<ManageAppConfiguration> {

	private final HibernateBundle<ManageAppConfiguration> hibernate = new HibernateBundle<ManageAppConfiguration>(
			Character.class, CharacterClass.class, Race.class, AbilityScore.class, NameSet.class, ClassLevel.class,
			Ability.class, Spell.class, School.class, Duration.class, Condition.class, HeightWeight.class,
			Alignment.class, Language.class) {
		@Override
		public DataSourceFactory getDataSourceFactory(final ManageAppConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};

	public static void main(final String[] args) throws Exception {
		new ManageApp().run(args);
	}

	@Override
	public void initialize(final Bootstrap<ManageAppConfiguration> bootstrap) {
		super.initialize(bootstrap);
		bootstrap.addBundle(hibernate);
		bootstrap.addBundle(new AssetsBundle("/js", "/js", null, "js"));
		bootstrap.addBundle(new AssetsBundle("/css", "/css", null, "css"));
		bootstrap.addBundle(new AssetsBundle("/ui", "/ui", "index.html"));
	}

	@Override
	public void run(final ManageAppConfiguration configuration, final Environment environment) throws Exception {
		final SessionFactory sessionFactory = hibernate.getSessionFactory();

		final NameSetDAO nameSetDAO = new NameSetDAO(sessionFactory);
		final AbilityScoreDAO abilityScoreDAO = new AbilityScoreDAO(sessionFactory);
		final AbilityDAO abilityDAO = new AbilityDAO(sessionFactory);
		final DurationDAO durationDAO = new DurationDAO(sessionFactory);
		final SchoolDAO schoolDAO = new SchoolDAO(sessionFactory);
		final ConditionDAO conditionDAO = new ConditionDAO(sessionFactory);
		final HeightWeightDAO heightWeightDAO = new HeightWeightDAO(sessionFactory);
		final AlignmentDAO alignmentDAO = new AlignmentDAO(sessionFactory);
		final LanguageDAO languageDAO = new LanguageDAO(sessionFactory);

		final NameGenerator nameGenerator = new NameGenerator(nameSetDAO);
		final AdminService adminService = new AdminService(abilityScoreDAO, abilityDAO, durationDAO, schoolDAO,
				conditionDAO, alignmentDAO, languageDAO);
		final DiceService diceService = new DiceService();
		final HeightWeightService heightWeightService = new HeightWeightService(heightWeightDAO);

		final ToolResource toolResource = new ToolResource(nameGenerator, diceService, heightWeightService);
		final AdminResource adminResource = new AdminResource(adminService);

		environment.jersey().register(toolResource);
		environment.jersey().register(adminResource);
	}
}
