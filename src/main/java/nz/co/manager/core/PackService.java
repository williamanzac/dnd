package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Pack;
import nz.co.manager.jdbi.PackDAO;

@Service
public class PackService extends CRUDService<Pack> {

	@Inject
	public PackService(final PackDAO packDAO) {
		super(packDAO);
	}
}
