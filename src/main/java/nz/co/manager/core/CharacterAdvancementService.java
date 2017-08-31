package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.CharacterAdvancement;
import nz.co.manager.jdbi.CharacterAdvancementDAO;

@Service
public class CharacterAdvancementService extends CRUDService<CharacterAdvancement> {

	@Inject
	public CharacterAdvancementService(final CharacterAdvancementDAO dao) {
		super(dao);
	}
}
