import org.domain.delegator.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("archivedHome")
public class ArchivedHome extends EntityHome<Archived> {

	@In(create = true)
	ArchivedHome archivedHome;
	@In(create = true)
	EmployeeHome employeeHome;

	public void setArchivedTid(Integer id) {
		setId(id);
	}

	public Integer getArchivedTid() {
		return (Integer) getId();
	}

	@Override
	protected Archived createInstance() {
		Archived archived = new Archived();
		return archived;
	}

	public void wire() {
		getInstance();
		Employee employee = employeeHome.getDefinedInstance();
		if (employee != null) {
			getInstance().setEmployee(employee);
		}
	}

	public boolean isWired() {
		if (getInstance().getArchivedByParentTaskId() == null)
			return false;
		if (getInstance().getArchivedByRootTaskId() == null)
			return false;
		if (getInstance().getEmployee() == null)
			return false;
		return true;
	}

	public Archived getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Archived> getArchivedsForRootTaskId() {
		return getInstance() == null ? null : new ArrayList<Archived>(
				getInstance().getArchivedsForRootTaskId());
	}

	public List<Archived> getArchivedsForParentTaskId() {
		return getInstance() == null ? null : new ArrayList<Archived>(
				getInstance().getArchivedsForParentTaskId());
	}

}
