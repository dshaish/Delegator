package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("worksForHome")
public class WorksForHome extends EntityHome<WorksFor> {
	
	public void setWorksForId(WorksForId id) {
		setId(id);
	}

	public WorksForId getWorksForId() {
		return (WorksForId) getId();
	}

	public WorksForHome() {
		setWorksForId(new WorksForId());
	}

	@Override
	public boolean isIdDefined() {
		if (getWorksForId().getManagerId() == 0)
			return false;
		if (getWorksForId().getEid() == 0)
			return false;
		return true;
	}

	@Override
	protected WorksFor createInstance() {
		WorksFor worksFor = new WorksFor();
		worksFor.setId(new WorksForId());
		return worksFor;
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public WorksFor getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
