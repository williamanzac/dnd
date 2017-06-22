package nz.co.manager.views;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.dropwizard.views.View;

public class GenericView extends View {
	private final List<String> breadcrumbs = new ArrayList<>();
	private final String path;
	private final String title;

	public GenericView(final String templatePath) {
		super("/" + templatePath + "/index.ftl");
		final String[] parts = templatePath.split("/");
		final StringBuilder p = new StringBuilder();
		for (int i = 0; i < parts.length; i++) {
			if (i > 0) {
				breadcrumbs.add(StringUtils.capitalize(parts[i]));
			}
			if (i != 1) {
				p.append("/").append(parts[i]);
			}
		}
		path = p.toString();
		title = breadcrumbs.get(breadcrumbs.size() - 1);
	}

	public List<String> getBreadcrumbs() {
		return breadcrumbs;
	}

	public String getPath() {
		return path;
	}

	public String getTitle() {
		return title;
	}
}
