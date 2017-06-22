package nz.co.manager;

import org.hibernate.SessionFactory;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.ScanningHibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

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
		// bootstrap.addBundle(new AssetsBundle("/ui", "/ui", "index.html"));
		bootstrap.addBundle(new ViewBundle<ManageAppConfiguration>());
	}

	@Override
	public void run(final ManageAppConfiguration configuration, final Environment environment) throws Exception {
		final SessionFactory sessionFactory = hibernate.getSessionFactory();

		environment.jersey().register(new CustomBinder(sessionFactory));

		environment.jersey().packages("nz.co.manager.resources");
	}
}
