package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("archivedList")
public class ArchivedList extends EntityQuery<Archived> {

	private static final String EJBQL = "select archived from Archived archived";

	private static final String[] RESTRICTIONS = {
			"lower(archived.title) like concat(lower(#{archivedList.archived.title}),'%')",
			"lower(archived.description) like concat(lower(#{archivedList.archived.description}),'%')",
			"lower(archived.attachment) like concat(lower(#{archivedList.archived.attachment}),'%')",
			"lower(archived.status) like concat(lower(#{archivedList.archived.status}),'%')", };

	private Archived archived = new Archived();

	public ArchivedList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Archived getArchived() {
		return archived;
	}
}
