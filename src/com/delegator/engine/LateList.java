package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("lateList")
public class LateList extends EntityQuery<Late> {

	private static final String EJBQL = "select late from Late late";

	private static final String[] RESTRICTIONS = {};

	private Late late = new Late();

	public LateList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Late getLate() {
		return late;
	}
}
