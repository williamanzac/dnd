package nz.co.manager.core;

import static java.lang.Integer.parseInt;
import static nz.co.manager.api.Die.getForSides;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Die;

@Service
public class DiceService {

	public static final Pattern ROLL_PATTERN = Pattern.compile("(\\d+)d(\\d+)([\\+-]\\d+)?");

	private final RandomService randomService;

	@Inject
	public DiceService(RandomService randomService) {
		this.randomService = randomService;
	}

	/**
	 * Parse the number of dice and generate some random numbers May not be unique values.
	 * 
	 * @param data
	 *            the number and type of dice to roll (\\d+)d(\\d+)([\\+-]\\d+)?
	 * @param times
	 *            how many time to roll the dice
	 * @return the generated random numbers
	 * @throws ServiceException
	 */
	public List<Integer> roll(final String data, final int times) throws ServiceException {
		final Matcher matcher = ROLL_PATTERN.matcher(data);
		final List<Integer> values = new ArrayList<>();
		if (matcher.matches()) {
			final int numDice = parseInt(matcher.group(1));
			final int dice = parseInt(matcher.group(2));
			final int add = matcher.group(3) == null ? 0 : parseInt(matcher.group(3));
			final Die die = getForSides(dice);
			if (die == null) {
				throw new ServiceException("Invalid number of sides: " + dice);
			}
			for (int t = 0; t < times; t++) {
				int value = 0;
				for (int i = 0; i < numDice; i++) {
					value += randomService.nextInt(die.getNumSides()) + 1;
				}
				value += add;
				values.add(value);
			}
			return values;
		}
		throw new ServiceException("Unable to process the dice data:" + data);
	}

	/**
	 * Generate random numbers from 1 to the value specified. Numbers should be unique.
	 * 
	 * @param data
	 *            the maximum value for the random number
	 * @param times
	 *            how many numbers to generate.
	 * @return a list of the random numbers
	 * @throws ServiceException
	 */
	public List<Integer> roll(final int data, final int times) throws ServiceException {
		final List<Integer> values = new ArrayList<>();
		for (int t = 0; t < times; t++) {
			int value = randomService.nextInt(data) + 1;
			while (values.contains(value)) { // this could cause an infinite loop
				value = randomService.nextInt(data) + 1;
			}
			values.add(value);
		}
		return values;
	}
}
