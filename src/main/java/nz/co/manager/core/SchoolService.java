package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.School;
import nz.co.manager.jdbi.SchoolDAO;

@Service
public class SchoolService extends CRUDService<School> {

	@Inject
	public SchoolService(final SchoolDAO dao) {
		super(dao);
	}
}
