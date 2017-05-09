package nz.co.manager.core;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import nz.co.manager.api.NameSet;
import nz.co.manager.jdbi.NameSetDAO;

@RunWith(MockitoJUnitRunner.class)
public class NameGeneratorTest {

	private static final int DWARF_MALE_TYPE = 1;
	private static final List<String> DWARF_MALE = Arrays.asList("Adrik", "Alberich", "Baern", "Barendd", "Brottor",
			"Bruenor", "Dain", "Darrak", "Delg", "Eberk", "Einkil", "Fargrim", "Flint", "Gardain", "Harbek", "Kildrak",
			"Morgran", "Orsik", "Oskar", "Rangrim", "Rurik", "Taklinn", "Thoradin", "Thorin", "Tordek", "Traubon",
			"Travok", "Ulfgar", "Veit", "Vondal");

	@Mock
	private NameSetDAO nameSetDAO;
	@Spy
	@InjectMocks
	private NameGenerator cut;

	@Test
	public void generateName() throws ServiceException {
		final NameSet nameSet = mock(NameSet.class);
		when(nameSetDAO.get(DWARF_MALE_TYPE)).thenReturn(nameSet);
		when(nameSet.getNames()).thenReturn(DWARF_MALE);
		final String actual = cut.generateName(DWARF_MALE_TYPE);
		System.out.println(actual);
		verify(cut).markovChain(DWARF_MALE_TYPE);
		verify(cut).markovName(anyMap());
		verify(cut).constructChain(anyList());
	}

	@Test
	public void generateNameList() throws ServiceException {
		final NameSet nameSet = mock(NameSet.class);
		when(nameSetDAO.get(DWARF_MALE_TYPE)).thenReturn(nameSet);
		when(nameSet.getNames()).thenReturn(DWARF_MALE);
		final List<String> actual = cut.nameList(DWARF_MALE_TYPE, 10);
		System.out.println(actual);
		verify(cut, times(10)).markovChain(DWARF_MALE_TYPE);
		verify(cut, times(10)).markovName(anyMap());
		verify(cut).constructChain(anyList());
	}
}
