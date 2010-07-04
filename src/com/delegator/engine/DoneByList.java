package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("doneByList")
public class DoneByList extends EntityQuery<DoneBy> {

	private static final String EJBQL = "select doneBy from DoneBy doneBy";

	private static final String[] RESTRICTIONS = {};

	private DoneBy doneBy;

	public DoneByList() {
		doneBy = new DoneBy();
		doneBy.setId(new DoneById());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public DoneBy getDoneBy() {
		return doneBy;
	}
}
