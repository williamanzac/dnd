package nz.co.manager;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.hibernate.SessionFactory;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.ScanningHibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nz.co.manager.core.AdminService;
import nz.co.manager.core.DiceService;
import nz.co.manager.core.HeightWeightService;
import nz.co.manager.core.NameGenerator;
import nz.co.manager.core.PlanetologyService;
import nz.co.manager.core.WorldHookService;
import nz.co.manager.jdbi.*;

public class ManageApp extends Application<ManageAppConfiguration> {

	private final HibernateBundle<ManageAppConfiguration> hibernate = new ScanningHibernateBundle<ManageAppConfiguration>(
			"nz.co.manager.api") {
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

		environment.jersey().register(new AbstractBinder() {
			@Override
			protected void configure() {
				bind(sessionFactory).to(SessionFactory.class);

				bind(NameSetDAO.class).to(NameSetDAO.class);
				bind(AbilityScoreDAO.class).to(AbilityScoreDAO.class);
				bind(AbilityDAO.class).to(AbilityDAO.class);
				bind(DurationDAO.class).to(DurationDAO.class);
				bind(SchoolDAO.class).to(SchoolDAO.class);
				bind(ConditionDAO.class).to(ConditionDAO.class);
				bind(HeightWeightDAO.class).to(HeightWeightDAO.class);
				bind(AlignmentDAO.class).to(AlignmentDAO.class);
				bind(LanguageDAO.class).to(LanguageDAO.class);
				bind(GearDAO.class).to(GearDAO.class);
				bind(WorldHookCategoryDAO.class).to(WorldHookCategoryDAO.class);
				bind(WorldHookDAO.class).to(WorldHookDAO.class);
				bind(WorldShapeDAO.class).to(WorldShapeDAO.class);
				bind(WorldSizeDAO.class).to(WorldSizeDAO.class);
				bind(WorldHydrographyDAO.class).to(WorldHydrographyDAO.class);
				bind(DisplayTypeDAO.class).to(DisplayTypeDAO.class);
				bind(RegionTypeDAO.class).to(RegionTypeDAO.class);
				bind(LandWaterDistributionDAO.class).to(LandWaterDistributionDAO.class);
				bind(LandWaterMassDAO.class).to(LandWaterMassDAO.class);

				bind(NameGenerator.class).to(NameGenerator.class);
				bind(AdminService.class).to(AdminService.class);
				bind(DiceService.class).to(DiceService.class);
				bind(HeightWeightService.class).to(HeightWeightService.class);
				bind(WorldHookService.class).to(WorldHookService.class);
				bind(PlanetologyService.class).to(PlanetologyService.class);
			}
		});

		environment.jersey().packages("nz.co.manager.resources");
	}
}
