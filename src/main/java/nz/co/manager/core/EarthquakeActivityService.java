package nz.co.manager.core;

import java.util.EnumSet;
import java.util.Set;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.EarthquakeActivity;
import nz.co.manager.api.EarthquakeFrequency;
import nz.co.manager.api.EarthquakeStrength;
import nz.co.manager.jdbi.EarthquakeActivityDAO;

@Service
public class EarthquakeActivityService extends CRUDService<EarthquakeActivity> {

	@Inject
	public EarthquakeActivityService(final EarthquakeActivityDAO dao) {
		super(dao);
	}

	public Set<EarthquakeStrength> listEarthquakeStrengths() {
		return EnumSet.allOf(EarthquakeStrength.class);
	}

	public Set<EarthquakeFrequency> listEarthquakeFrequencies() {
		return EnumSet.allOf(EarthquakeFrequency.class);
	}
}
