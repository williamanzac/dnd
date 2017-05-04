package nz.co.manager.core;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import nz.co.manager.api.NameSet;
import nz.co.manager.jdbi.NameSetDAO;

public class NameGeneratorTest {

	private static final String DWARF_MALE_TYPE = "dwarf_male";
	private static final List<String> DWARF_MALE = Arrays.asList("Adrik", "Alberich", "Baern", "Barendd", "Brottor",
			"Bruenor", "Dain", "Darrak", "Delg", "Eberk", "Einkil", "Fargrim", "Flint", "Gardain", "Harbek", "Kildrak",
			"Morgran", "Orsik", "Oskar", "Rangrim", "Rurik", "Taklinn", "Thoradin", "Thorin", "Tordek", "Traubon",
			"Travok", "Ulfgar", "Veit", "Vondal");
	private NameGenerator cut;
	private NameSetDAO nameSetDAO;

	@Before
	public void setup() {
		nameSetDAO = mock(NameSetDAO.class);
		final NameGenerator generator = new NameGenerator(nameSetDAO);
		cut = spy(generator);
	}

	@Test
	public void generateName() {
		final NameSet nameSet = mock(NameSet.class);
		when(nameSetDAO.getByType(DWARF_MALE_TYPE)).thenReturn(nameSet);
		when(nameSet.getNames()).thenReturn(DWARF_MALE);
		final String actual = cut.generateName(DWARF_MALE_TYPE);
		System.out.println(actual);
		verify(cut).markovChain(DWARF_MALE_TYPE);
		verify(cut).markovName(anyMap());
		verify(cut).constructChain(anyList());
	}

	@Test
	public void generateNameList() {
		final NameSet nameSet = mock(NameSet.class);
		when(nameSetDAO.getByType(DWARF_MALE_TYPE)).thenReturn(nameSet);
		when(nameSet.getNames()).thenReturn(DWARF_MALE);
		final List<String> actual = cut.nameList(DWARF_MALE_TYPE, 10);
		System.out.println(actual);
		verify(cut, times(10)).markovChain(DWARF_MALE_TYPE);
		verify(cut, times(10)).markovName(anyMap());
		verify(cut).constructChain(anyList());
	}
}
