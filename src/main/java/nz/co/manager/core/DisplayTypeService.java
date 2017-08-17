package nz.co.manager.core;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.DisplayType;
import nz.co.manager.api.Region;
import nz.co.manager.jdbi.DisplayTypeDAO;
import nz.co.manager.jdbi.RegionDAO;

@Service
public class DisplayTypeService extends CRUDService<DisplayType> {
	public static final double length = 100;
	public static final double rowheight = Math.sqrt(Math.pow(length, 2) - Math.pow(50, 2));
	public static final double r = length / 2.0 / Math.sin(Math.PI * 60 / 180);

	private final RegionDAO regionDAO;

	@Inject
	public DisplayTypeService(final DisplayTypeDAO dao, final RegionDAO regionDAO) {
		super(dao);
		this.regionDAO = regionDAO;
	}

	@Override
	public DisplayType create(final DisplayType entity) {
		if (entity.getRegions() != null) {
			for (final Region region : entity.getRegions()) {
				regionDAO.update(region);
			}
		}
		super.create(entity);
		return entity;
	}

	@Override
	public DisplayType update(final DisplayType entity) {
		if (entity.getRegions() != null) {
			for (final Region region : entity.getRegions()) {
				regionDAO.update(region);
			}
		}
		super.update(entity);
		return entity;
	}

	public List<DisplayType> getBy(final String name) {
		return ((DisplayTypeDAO) dao).getBy(name);
	}

	public List<Point2D> getRegionPoints(final DisplayType type, final int number) {
		final List<Point2D> list = new ArrayList<>();
		if ("Polyhedral".equals(type.getName())) {
			switch (number) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				list.addAll(getPoints(number * 100, r, -90));
				break;
			case 6:
			case 8:
			case 10:
			case 12:
			case 14:
				list.addAll(getPoints(50 + (100 * ((number - 6) / 2)), rowheight + r, -90));
				break;
			case 7:
			case 9:
			case 11:
			case 13:
			case 15:
				list.addAll(getPoints(100 * ((number - 5) / 2), rowheight * 2 - r, 90));
				break;
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
				// 16 050,rowheight*3
				list.addAll(getPoints(50 + (100 * (number - 16)), rowheight * 3 - r, 90));
				break;
			}
		}
		return list;
	}

	private List<Point2D> getPoints(final double x, final double y, final double a) {
		final List<Point2D> list = new ArrayList<>();
		final double angle = Math.toRadians(a);
		final double r = length / 2.0 / Math.sin(Math.PI * 60. / 180.);

		for (int i = 0; i < 3; i++) {
			final double x2 = x + r * Math.cos(angle + i * 2. * Math.PI / 3.);
			final double y2 = y + r * Math.sin(angle + i * 2. * Math.PI / 3.);
			list.add(new Point2D.Double(x2, y2));
		}
		return list;
	}

}
