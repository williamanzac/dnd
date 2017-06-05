package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

@Service
public class LandformService {
	private final DiceService diceService;

	@Inject
	public LandformService(final DiceService diceService) {
		this.diceService = diceService;
	}

	public void generate() {

	}
}
