package nz.co.manager;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.hibernate.SessionFactory;

import nz.co.manager.core.*;
import nz.co.manager.jdbi.*;

public final class CustomBinder extends AbstractBinder {
	private final SessionFactory sessionFactory;

	public CustomBinder(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	protected void configure() {
		bind(sessionFactory).to(SessionFactory.class);

		bind(AbilityDAO.class).to(AbilityDAO.class);
		bind(AbilityScoreDAO.class).to(AbilityScoreDAO.class);
		bind(AlignmentDAO.class).to(AlignmentDAO.class);
		bind(ConditionDAO.class).to(ConditionDAO.class);
		bind(DisplayTypeDAO.class).to(DisplayTypeDAO.class);
		bind(DurationDAO.class).to(DurationDAO.class);
		bind(EarthquakeActivityDAO.class).to(EarthquakeActivityDAO.class);
		bind(GearDAO.class).to(GearDAO.class);
		bind(HeightWeightDAO.class).to(HeightWeightDAO.class);
		bind(LandWaterDistributionDAO.class).to(LandWaterDistributionDAO.class);
		bind(LandWaterMassDAO.class).to(LandWaterMassDAO.class);
		bind(LanguageDAO.class).to(LanguageDAO.class);
		bind(MountainPlacementDAO.class).to(MountainPlacementDAO.class);
		bind(MountainPropertyDAO.class).to(MountainPropertyDAO.class);
		bind(NameSetDAO.class).to(NameSetDAO.class);
		bind(PackDAO.class).to(PackDAO.class);
		bind(PlanetaryTemperatureDAO.class).to(PlanetaryTemperatureDAO.class);
		bind(PlateMovementDAO.class).to(PlateMovementDAO.class);
		bind(RegionDAO.class).to(RegionDAO.class);
		bind(RegionalHydrographyDAO.class).to(RegionalHydrographyDAO.class);
		bind(RegionTypeDAO.class).to(RegionTypeDAO.class);
		bind(SchoolDAO.class).to(SchoolDAO.class);
		bind(SeasonalVariationDAO.class).to(SeasonalVariationDAO.class);
		bind(VolcanicActivityDAO.class).to(VolcanicActivityDAO.class);
		bind(WorldHookCategoryDAO.class).to(WorldHookCategoryDAO.class);
		bind(WorldHookDAO.class).to(WorldHookDAO.class);
		bind(WorldHydrographyDAO.class).to(WorldHydrographyDAO.class);
		bind(WorldShapeDAO.class).to(WorldShapeDAO.class);
		bind(WorldSizeDAO.class).to(WorldSizeDAO.class);

		bind(AbilityService.class).to(AbilityService.class);
		bind(AbilityScoreService.class).to(AbilityScoreService.class);
		bind(AlignmentService.class).to(AlignmentService.class);
		bind(ConditionService.class).to(ConditionService.class);
		bind(DiceService.class).to(DiceService.class);
		bind(DisplayTypeService.class).to(DisplayTypeService.class);
		bind(DurationService.class).to(DurationService.class);
		bind(EarthquakeActivityService.class).to(EarthquakeActivityService.class);
		bind(GearService.class).to(GearService.class);
		bind(HeightWeightService.class).to(HeightWeightService.class);
		bind(LandWaterDistributionService.class).to(LandWaterDistributionService.class);
		bind(LandWaterMassService.class).to(LandWaterMassService.class);
		bind(LanguageService.class).to(LanguageService.class);
		bind(MountainPlacementService.class).to(MountainPlacementService.class);
		bind(MountainPropertyService.class).to(MountainPropertyService.class);
		bind(NameService.class).to(NameService.class);
		bind(PackService.class).to(PackService.class);
		bind(PlanetaryTemperatureService.class).to(PlanetaryTemperatureService.class);
		bind(PlateMovementService.class).to(PlateMovementService.class);
		bind(new RandomService()).to(RandomService.class);
		bind(RegionalHydrographyService.class).to(RegionalHydrographyService.class);
		bind(RegionTypeService.class).to(RegionTypeService.class);
		bind(SchoolService.class).to(SchoolService.class);
		bind(SeasonalVariationService.class).to(SeasonalVariationService.class);
		bind(TectonicPlateService.class).to(TectonicPlateService.class);
		bind(VolcanicActivityService.class).to(VolcanicActivityService.class);
		bind(WorldBuilderService.class).to(WorldBuilderService.class);
		bind(WorldHookCategoryService.class).to(WorldHookCategoryService.class);
		bind(WorldHookService.class).to(WorldHookService.class);
		bind(WorldHydrographyService.class).to(WorldHydrographyService.class);
		bind(WorldShapeService.class).to(WorldShapeService.class);
		bind(WorldSizeService.class).to(WorldSizeService.class);
	}
}