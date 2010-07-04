package org.domain.delegator.session;

import java.util.List;

import javax.ejb.Local;
import javax.faces.model.SelectItem;

@Local
public interface Statuses
{
    // seam-gen method
    public void statuses();

    // add additional interface methods here
    public List getStatusesList();

}
