package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("onTimeList")
public class OnTimeList extends EntityQuery<OnTime> {

	private static final String EJBQL = "select onTime from OnTime onTime";

	private static final String[] RESTRICTIONS = {};

	private OnTime onTime = new OnTime();

	public OnTimeList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public OnTime getOnTime() {
		return onTime;
	}
}
