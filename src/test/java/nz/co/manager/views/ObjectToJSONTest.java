package nz.co.manager.views;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import nz.co.manager.api.PlateMovement;

public class ObjectToJSONTest {

	private static final String EXPECTED = "function PlateMovement(data) {\n\tvar self = this;\n\tif (data != null) {\n\t\tself.description = ko.observable(data.description);\n\t\tself.min = ko.observable(data.min);\n\t\tself.max = ko.observable(data.max);\n\t\tself.id = data.id;\n\t} else {\n\t\tself.description = ko.observable();\n\t\tself.min = ko.observable();\n\t\tself.max = ko.observable();\n\t}\n}\n";

	@Test
	public void verifyToFunction() {
		final String actual = ObjectToJSON.toCreateFunction(PlateMovement.class);
		assertThat(actual, equalTo(EXPECTED));
	}
}
