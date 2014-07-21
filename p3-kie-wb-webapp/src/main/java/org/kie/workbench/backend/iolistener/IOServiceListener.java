package org.kie.workbench.backend.iolistener;

public interface IOServiceListener {

	public void beforeWrite(IOServiceWriteEvent event);
	
	public void afterWrite(IOServiceWriteEvent event);

	public void errorWrite(IOServiceWriteEvent event);
}
