package org.domain.delegator.session;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.log.Log;
import org.jboss.seam.international.StatusMessages;

@Stateless
@Name("Statuses")
public class StatusesBean implements Statuses
{
    @Logger private Log log;

    @In StatusMessages statusMessages;
    
    public void statuses()
    {
        // implement your business logic here
        log.info("Statuses.statuses() action called");
        statusMessages.add("statuses");
    }

    // add additional action methods
    public List getStatusesList(){
    	return Arrays.asList(StatusesEnum.values());
    }
}
