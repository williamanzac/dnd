package nz.co.manager.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.NameSet;
import nz.co.manager.jdbi.NameSetDAO;

@Service
public class NameService extends CRUDService<NameSet> {

	@Inject
	public NameService(final NameSetDAO dao) {
		super(dao);
		// nameSet.put("dwarf_male",
		// Arrays.asList("Adrik", "Alberich", "Baern", "Barendd", "Brottor", "Bruenor", "Dain", "Darrak", "Delg",
		// "Eberk", "Einkil", "Fargrim", "Flint", "Gardain", "Harbek", "Kildrak", "Morgran", "Orsik",
		// "Oskar", "Rangrim", "Rurik", "Taklinn", "Thoradin", "Thorin", "Tordek", "Traubon", "Travok",
		// "Ulfgar", "Veit", "Vondal"));
		// nameSet.put("dwarf_female",
		// Arrays.asList("Amber", "Artin", "Audhild", "Bardryn", "Dagnal", "Diesa", "Eldeth", "Falkrunn",
		// "Finellen", "Gunnloda", "Gurdis", "Helja", "Hlin", "Kathra", "Kristryd", "Ilde", "Liftrasa",
		// "Mardred", "Riswynn", "Sannl", "Torbera", "Torgga", "Vistra"));
		// nameSet.put("dwarf_clan",
		// Arrays.asList("Balderk", "Battlehammer", "Brawnanvil", "Dankil", "Fireforge", "Frostbeard", "Gorunn",
		// "Holderhek", "Ironfist", "Loderr", "Lutgehr", "Rumnaheim", "Strakeln", "Torunn", "Ungart"));
		// elf_child => Ara, Bryn, Del, Eryn, Faen, Innil, Lael, Mella, Naill, Naeris, Phann, Rael, Rinn, Sai, Syllin,
		// Thia, Vall
		// elf_male => Adran, Aelar, Aramil, Arannis, Aust, Beiro, Berrian, Carric , Enialis, Erdan, Erevan, Galinndan,
		// Hadarai, Heian, Himo, Immeral, Ivellios, Laucian, Mindartis, Paelias, Peren, Quarion, Riardon, Rolen,
		// Soveliss, Thamior, Tharivol, Theren, Varis
		// elf_female => Adrie, Althaea, Anastrianna, Andraste, Antinua, Bethrynna, Birel, Caelynn, Drusilia, Enna,
		// Felosial, Ielenia, Jelenneth, Keyleth, Leshanna, Lia, Meriele, Mialee, Naivara, Quelenna, Quillathe, Sariel,
		// Shanairra, Shava, Silaqui, Theirastra, Thia, Vadania, Valanthe, Xanaphia
		// elf_family => Amakiir (Gemflower), Amastacia (Starflower), Galanodel (Moonwhisper), Holimion (Diamonddew),
		// Ilphelkiir (Gemblossom), Liadon (Silverfrond), Meliamne (Oakenheel), Nai'lo (Nightbreeze), Siannodel
		// (Moonbrook), Xiloscient (Goldpetal)
		// halfling_male => Alton, Ander, Cade, Corrin, Eldon, Errich, Finnan, Garret, Lindal, Lyle, Merric, Milo,
		// Osborn, Perrin, Reed, Roscoe, Wellby
		// halfling_female => Andry, Bree, Callie, Cora, Euphemia, Jillian, Kithri, Lavinia, Lidda, Merla, Nedda, Paela,
		// Portia, Seraphina, Shaena, Trym, Vani, Verna
		// halfling_family => Brushgather, Goodbarrel, Greenbottle, High-hill, Hilltopple, Leagallow, Tealeaf,
		// Thorngage, Tosscobble, Underbough
		// human_calishite_male => Aseir, Bardeid, Haseid, Khemed, Mehmen, Sudeiman, Zasheir
		// human_calishite_femle => Atala, Ceidil, Hama, Jasmal, Meilil, Seipora, Yasheira, Zasheida
		// human_calishite_surnames => Basha, Dumein, Jassan, Khalid, Mostana, Pashar, Rein
		// human_chondathan_male (tethyrian) => Darvin, Dorn, Evendur, Gorstag, Grim, Helm, Malark, Morn, Randal, Stedd
		// human_chondathan_female (tethyrian) => Arveene, Esvele, Jhessail, Kerri, Lureene, Miri, Rowan, Shandri,
		// Tessele
		// human_chondathan_surnames (tethyrian) => Amblecrown, Buckman, Dundragon, Evenwood, Greycastle, Tallstag
		// human_damaran_male => Bor, Fodel, Glar, Grigor, Igan, Ivor, Kosef, Mival, Orel, Pavel, Sergor
		// human_damaran_female => Alethra, Kara, Katernin, Mara, Natali, Olma, Tana, Zora
		// human_damaran_surnames => Bersk, Chernin, Dotsk, Kulenov, Marsk, Nemetsk, Shemov, Starag
		// human_illuskan_male => Ander, Blath, Bran, Frath, Geth, Lander, Luth, Malcer, Stor, Taman, Urth
		// human_illuskan_female => Amafrey, Betha, Cefrey, Kethra, Mara, Olga, Silifrey, Westra
		// human_illuskan_surnames => Brightwood, Helder, Hornraven, Lackman, Stormwind, Windrivver
		// human_mulan_male => Aoth, Bareris, Ehput-Ki, Kethoth, Mumed, Ramas, So-Kehur, Thazar-De, Urhur
		// human_mulan_female => Arizima, Chathi, Nephis, Nulara, Murithi, Sefris, Thola, Umara, Zolis
		// human_mulan_surnames => Ankhalab, Anskuld, Fezim, Hahpet, Nathandem, Sepret, Uuthrakt
		// human_rashemi_male => Borivik, Faurgar, Jandar, Kanithar, Madislak, Ralmevik, Shaumar, Vladislak
		// human_rashemi_female => Fyevarra, Hulmarra, Immith, Imzel, Navarra, Shevarra, Tammith, Yuldra
		// human_rashemi_surnames => Chergoba, Dyernina, Iltazyara, Murnyethara, Stayanoga, Ulmokina
		// human_shou_male => An, Chen, Chi, Fai, Jiang, Jun, Lian, Long, Meng, On, Shan, Shui, Wen
		// human_shou_female => Bai, Chao, Jia, Lei, Mei, Qiao, Shui, Tai
		// human_shou_surnames => Chien, Huang, Kao, Kung, Lao, Ling, Mei, Pin, Shin, Sum, Tan, Wan
		// human_turami_male => Anton, Diero, Marcon, Pieron, Rimardo, Romero, Salazar, Umbero
		// human_turami_female => Balama, Dona, Faila, Jalana, Luisa, Marta, Quara, Selise, Vonda
		// human_turami_surnames => Agosto, Astorio, Calabra, Domine, Falone, Marivaldi, Pisacar, Ramondo
		// dragonborn_male => Arjhan, Balasar, Bharash, Donaar, Ghesh, Heskan, Kriv, Medrash, Mehen, Nadarr, Pandjed,
		// Patrin, Rhogar, Shamash, Shedinn, Tarhun, Torinn
		// dragonborn_female => Akra, Biri, Daar, Farideh, Harann, Flavilar, Jheri, Kava, Korinn, Mishann, Nala, Perra,
		// Raiann, Sora, Surina, Thava, Uadjit
		// dragonborn_child => Climber, Earbender, Leaper, Pious, Shieldbiter, Zealous
		// dragonborn_clan => Clethtinthiallor, Daardendrian, Delmirev, Drachedandion, Fenkenkabradon, Kepeshkmolik,
		// Kerrhylon, Kimbatuul, Linxakasendalor, Myastan, Nemmonis, Norixius, Ophinshtalajiir, Prexijandilin,
		// Shestendeliath, Turnuroth, Verthisathurgiesh, Yarjerit
		// gnome_male => Alston, Alvyn, Boddynock, Brocc, Burgell, Dimble, Eldon, Erky, Fonkin, Frug, Gerbo, Gimble,
		// Glim, Jebeddo, Kellen, Namfoodle, Orryn, Roondar, Seebo, Sindri, Warryn, Wrenn, Zook
		// gnome_female => Bimpnottin, Breena, Caramip, Carlin, Donella, Duvamil, Ella, Ellyjobell, Ellywick, Lilli,
		// Loopmottin, Lorilla, Mardnab, Nissa, Nyx, Oda, Orla, Roywyn, Shamil, Tana, Waywocket, Zanna
		// gnome_clan => Beren, Daergel, Folkor, Garrick, Nackle, Murnig, Ningel, Raulnor, Scheppen, Timbers, Turen
		// gnome_nickname => Aleslosh, Ashhearth, Badger, Cloak, Doublelock, Filchbatter, Fnipper, Ku, Nim, Oneshoe,
		// Pock, Sparklegem, Stumbleduck
		// half-orc_male => Dench, Feng, Gell, Henk, Holg, Imsh, Keth, Krusk, Mhurren, Ront, Shump, Thokk
		// half-orc_female => Baggi, Emen, Engong, Kansif, Myev, Neega, Ovak, Ownka, Shautha, Sutha, Vola, Volen,
		// Yevelda
		// tiefling_male => Akmenos, Amnon, Barakas, Damakos, Ekemon, Iados, Kairon, Leucis, Melech, Mordai, Morthos,
		// Pelaios, Skamos, Therai
		// tiefling_female => Akta, Anakis, Bryseis, Criella, Damaia, Ea, Kallista, Lerissa, Makaria, Nemeia, Orianna,
		// Phelaia, Rieta
		// tiefling_virtue => Art, Carrion, Chant, Creed, Despair, Excellence, Fear, Glory, Hope, Ideal, Music, Nowhere,
		// Open, Poetry, Quest, Random, Reverence, Sorrow, Temerity, Torment, Weary
	}

	public String generateName(final int id) throws ServiceException {
		final Map<String, Map<String, Double>> chain = markovChain(id);
		if (chain == null) {
			throw new ServiceException("Unable to generate Name.");
		}
		return markovName(chain);
	}

	public List<String> nameList(final int id, final int numOf) throws ServiceException {
		final List<String> names = new ArrayList<>();
		for (int i = 0; i < numOf; i++) {
			names.add(generateName(id));
		}
		return names;
	}

	protected Map<String, Map<String, Double>> markovChain(final int id) throws ServiceException {
		final List<String> list = read(id).getNames();
		if (list == null) {
			throw new ServiceException("No Names defined.");
		}
		final Map<String, Map<String, Double>> chain = constructChain(list);
		if (chain == null) {
			throw new ServiceException("Unable to process names.");
		}
		return chain;
	}

	protected Map<String, Map<String, Double>> constructChain(final List<String> list) {
		final Map<String, Map<String, Double>> chain = new HashMap<>();

		for (int i = 0; i < list.size(); i++) {
			final String[] names = list.get(i).split("\\s+");
			incrChain(chain, "parts", String.valueOf(names.length));

			for (final String name : names) {
				incrChain(chain, "nameLen", String.valueOf(name.length()));

				List<String> strings = splitName(name);

				String c = strings.get(0);
				incrChain(chain, "initial", c);

				strings = strings.subList(1, strings.size());
				String lastC = c;

				while (!strings.isEmpty()) {
					c = strings.get(0);
					incrChain(chain, lastC, c);

					strings = strings.subList(1, strings.size());
					lastC = c;
				}
			}
		}
		scaleChain(chain);
		return chain;
	}

	private List<String> splitName(final String name) {
		final List<String> strings = new ArrayList<>();
		boolean prevVowel = false;
		StringBuilder vowelGroup = new StringBuilder();
		for (final char c : name.toCharArray()) {
			if (isVowel(c)) {
				if (!prevVowel) {
					// start vowel group
					vowelGroup = new StringBuilder();
				}
				// add to vowel group
				vowelGroup.append(c);
				prevVowel = true;
			} else {
				// not a vowel so just add single character to list
				if (prevVowel) {
					// add vowel group
					strings.add(vowelGroup.toString());
				}
				prevVowel = false;
				strings.add(String.valueOf(c));
			}
		}
		if (prevVowel) {
			// add vowel group
			strings.add(vowelGroup.toString());
		}
		return strings;
	}

	private boolean isVowel(final char c) {
		return StringUtils.contains("aeiouAEIOU", c);
	}

	private void incrChain(final Map<String, Map<String, Double>> chain, final String key, final String token) {
		if (chain.containsKey(key)) {
			final Map<String, Double> map = chain.get(key);
			if (map.containsKey(token)) {
				map.put(token, chain.get(key).get(token) + 1);
			} else {
				map.put(token, 1.0);
			}
		} else {
			chain.put(key, new HashMap<>());
			chain.get(key).put(token, 1.0);
		}
	}

	private void scaleChain(final Map<String, Map<String, Double>> chain) {
		final Map<String, Double> tableLen = new HashMap<>();

		for (final String key : chain.keySet()) {
			tableLen.put(key, 0.0);
			final Map<String, Double> map = chain.get(key);
			for (final String token : map.keySet()) {
				final double count = map.get(token);
				final double weighted = Math.floor(Math.pow(count, 1.3));

				map.put(token, weighted);
				tableLen.put(key, tableLen.get(key) + weighted);
			}
		}
		chain.put("tableLen", tableLen);
	}

	protected String markovName(final Map<String, Map<String, Double>> chain) {
		final int parts = Integer.valueOf(selectLink(chain, "parts"));
		final List<String> names = new ArrayList<>();

		for (int i = 0; i < parts; i++) {
			int nameLen = Integer.valueOf(selectLink(chain, "nameLen"));
			String c = selectLink(chain, "initial");
			final List<String> name = new ArrayList<>();
			name.add(c);

			while (String.join("", name).length() < nameLen) {
				c = selectLink(chain, name.get(name.size() - 1));
				if (c == null) {
					nameLen = name.size();
					continue;
				}
				name.add(c);
			}
			names.add(String.join("", name));
		}
		return String.join(" ", names);
	}

	private String selectLink(final Map<String, Map<String, Double>> chain, final String key) {
		final Map<String, Double> tableLen = chain.get("tableLen");
		if (!tableLen.containsKey(key)) {
			return null;
		}
		final double len = tableLen.get(key);
		final double idx = Math.floor(Math.random() * len);

		if (!chain.containsKey(key)) {
			return null;
		}
		int t = 0;
		final Map<String, Double> map = chain.get(key);
		for (final String token : map.keySet()) {
			t += map.get(token);
			if (idx < t) {
				return token;
			}
		}
		return null;
	}
}
