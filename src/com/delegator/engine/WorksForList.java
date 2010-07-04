package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("worksForList")
public class WorksForList extends EntityQuery<WorksFor> {

	private static final String EJBQL = "select worksFor from WorksFor worksFor";

	private static final String[] RESTRICTIONS = {};

	private WorksFor worksFor;

	public WorksForList() {
		worksFor = new WorksFor();
		worksFor.setId(new WorksForId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public WorksFor getWorksFor() {
		return worksFor;
	}
}
