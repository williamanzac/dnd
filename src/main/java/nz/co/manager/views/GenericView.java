package nz.co.manager.views;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import io.dropwizard.views.View;

public class GenericView extends View {

	public static class MenuNode {
		private final String name;
		private List<MenuNode> nodes = new ArrayList<>();

		public MenuNode(final String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public List<MenuNode> getNodes() {
			return nodes;
		}

		@SuppressWarnings("unchecked")
		public static List<MenuNode> nodesFromPath(final String path) {
			final List<MenuNode> nodes = new ArrayList<>();
			try {
				final InputStream is = GenericView.class.getResourceAsStream(path);
				if (is == null) {
					return nodes;
				}
				final List<String> lines = IOUtils.readLines(is);
				lines.stream().filter(line -> !line.contains(".")).forEach(p -> {
					final MenuNode node = new MenuNode(p);
					nodes.add(node);
					final String childPath = path + "/" + p;
					final List<MenuNode> childNodes = nodesFromPath(childPath);
					node.setNodes(childNodes);
				});
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nodes;
		}

		public void setNodes(final List<MenuNode> nodes) {
			this.nodes = nodes;
		}
	}

	private final List<String> breadcrumbs = new ArrayList<>();
	private final String path;
	private final String title;
	private final List<MenuNode> menuNodes;

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
		menuNodes = MenuNode.nodesFromPath("/ui");
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

	public List<MenuNode> getMenuNodes() {
		return menuNodes;
	}
}
