package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Language;
import nz.co.manager.jdbi.LanguageDAO;

@Service
public class LanguageService extends CRUDService<Language> {

	@Inject
	public LanguageService(LanguageDAO dao) {
		super(dao);
	}
}
