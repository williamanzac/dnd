package nz.co.manager.core;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DiceServiceTest {

	private DiceService cut;

	@Before
	public void setup() {
		cut = new DiceService(new RandomService());
	}

	@Test
	public void testDataFormatFailure() {
		try {
			cut.roll("bob", 1);
			fail("Should not get to this point");
		} catch (final ServiceException e) {
		}
	}

	@Test
	public void testDataInvalidDie() {
		try {
			cut.roll("1d16", 1);
			fail("Should not get to this point");
		} catch (final ServiceException e) {
		}
	}

	@Test
	public void testRoll() throws ServiceException {
		final List<Integer> list = cut.roll("1d8", 1);
		assertEquals(1, list.size());
		final Integer actual = list.get(0);
		assertThat(actual, is(greaterThanOrEqualTo(1)));
		assertThat(actual, is(lessThanOrEqualTo(8)));
	}

	@Test
	public void testRollAdd() throws ServiceException {
		final List<Integer> list = cut.roll("1d10+2", 1);
		assertEquals(1, list.size());
		final Integer actual = list.get(0);
		assertThat(actual, is(greaterThanOrEqualTo(3)));
		assertThat(actual, is(lessThanOrEqualTo(12)));
	}

	@Test
	public void testRollSubtract() throws ServiceException {
		final List<Integer> list = cut.roll("1d20-1", 1);
		assertEquals(1, list.size());
		final Integer actual = list.get(0);
		assertThat(actual, is(greaterThanOrEqualTo(0)));
		assertThat(actual, is(lessThanOrEqualTo(19)));
	}
}
