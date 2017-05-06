package nz.co.manager.core;

import static java.lang.Integer.parseInt;
import static nz.co.manager.api.Die.getForSides;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Die;

@Service
public class DiceService {

	public static final Pattern ROLL_PATTERN = Pattern.compile("(\\d+)d(\\d+)([\\+-]\\d+)?");

	public List<Integer> roll(final String data, final int times) throws ServiceException {
		final Matcher matcher = ROLL_PATTERN.matcher(data);
		final List<Integer> values = new ArrayList<>();
		if (matcher.matches()) {
			final int numDice = parseInt(matcher.group(1));
			final int dice = parseInt(matcher.group(2));
			final int add = matcher.group(3) == null ? 0 : parseInt(matcher.group(3));
			final Die die = getForSides(dice);
			for (int t = 0; t < times; t++) {
				int value = 0;
				for (int i = 0; i < numDice; i++) {
					value += die.roll();
				}
				value += add;
				values.add(value);
			}
			return values;
		}
		throw new ServiceException("Unable to process the dice data:" + data);
	}
}
