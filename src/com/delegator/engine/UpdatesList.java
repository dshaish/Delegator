package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("updatesList")
public class UpdatesList extends EntityQuery<Updates> {

	private static final String EJBQL = "select updates from Updates updates";

	private static final String[] RESTRICTIONS = { "lower(updates.updates) like concat(lower(#{updatesList.updates.updates}),'%')", };

	private Updates updates = new Updates();

	public UpdatesList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Updates getUpdates() {
		return updates;
	}
}
