package nz.co.manager.views;

import java.lang.reflect.Field;

public class ObjectToJSON {
	public static <T> String toCreateFunction(final Class<T> clazz) {
		String ret = "function " + clazz.getSimpleName() + "(data) {\n";
		ret += "\tvar self = this;\n";
		ret += "\tif (data != null) {\n";
		Class<?> c = clazz;
		while (c != null) {
			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				ret = toProperty(ret, f, true);
			}
			c = c.getSuperclass();
		}
		ret += "\t} else {\n";
		c = clazz;
		while (c != null) {
			for (final Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				ret = toProperty(ret, f, false);
			}
			c = c.getSuperclass();
		}
		ret += "\t}\n";
		ret += "}\n";
		return ret;
	}

	private static String toProperty(String ret, final Field f, final boolean bind) {
		final Class<?> type = f.getType();
		if (type.isArray() || type.getName().contains("Set") || type.getName().contains("List")
				|| type.getName().contains("Map")) {
			ret += "\t\tself." + f.getName() + " = ko.observableArray(" + (bind ? "data." + f.getName() : "[]")
					+ ");\n";
		} else if ("id".equals(f.getName()) && bind) {
			ret += "\t\tself." + f.getName() + " = data." + f.getName() + ";\n";
		} else {
			ret += "\t\tself." + f.getName() + " = ko.observable(" + (bind ? "data." + f.getName() : "") + ");\n";
		}
		return ret;
	}

	public static String toPlural(final String value) {
		String ret = value;
		if (ret.endsWith("y")) {
			ret = ret.replace("y", "ies");
		} else if (ret.endsWith("s")) {
			ret += "es";
		} else {
			ret += "s";
		}
		return ret;
	}
}
