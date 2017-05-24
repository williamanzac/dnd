package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Alignment;
import nz.co.manager.jdbi.AlignmentDAO;

@Service
public class AlignmentService extends CRUDService<Alignment> {

	@Inject
	public AlignmentService(AlignmentDAO dao) {
		super(dao);
	}
}
