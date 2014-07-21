package org.kie.workbench.backend.iolistener;

public class IOServiceListenerImpl implements IOServiceListener {

	@Override
	public void beforeWrite(IOServiceWriteEvent event) {
		System.out.println("BEFORE WRITE: " + event);
	}

	@Override
	public void afterWrite(IOServiceWriteEvent event) {
		System.out.println("AFTER WRITE: " + event);
	}

	@Override
	public void errorWrite(IOServiceWriteEvent event) {
		System.out.println("ERROR WRITE: " + event);
	}

}
