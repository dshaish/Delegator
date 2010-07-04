package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("divisionsList")
public class DivisionsList extends EntityQuery<Divisions> {

	private static final String EJBQL = "select divisions from Divisions divisions";

	private static final String[] RESTRICTIONS = { "lower(divisions.name) like concat(lower(#{divisionsList.divisions.name}),'%')", };

	private Divisions divisions = new Divisions();

	public DivisionsList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Divisions getDivisions() {
		return divisions;
	}
}
