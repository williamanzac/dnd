package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Duration;
import nz.co.manager.jdbi.DurationDAO;

@Service
public class DurationService extends CRUDService<Duration> {

	@Inject
	public DurationService(DurationDAO dao) {
		super(dao);
	}
}
