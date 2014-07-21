package org.kie.workbench.backend.iolistener;

import java.util.Map;

import org.uberfire.java.nio.file.OpenOption;
import org.uberfire.java.nio.file.Path;
import org.uberfire.java.nio.file.attribute.FileAttribute;

public class IOServiceWriteEvent {

	private Path returnValue;
	private Path path;
	private byte[] bytes;
	private Map<String, ?> attrs;
	private OpenOption[] options;
	private FileAttribute<?>[] fileAttrs;
	private Exception error;
	
	public IOServiceWriteEvent(Path retval, Path path, byte[] bytes,
			Map<String, ?> attrs, OpenOption[] options,
			FileAttribute<?>[] fileAttrs, Exception error) {
		this.returnValue = retval;
		this.path = path;
		this.bytes = bytes;
		this.attrs = attrs;
		this.options = options;
		this.fileAttrs = fileAttrs;
		this.error = error;
	}
	
	public Map<String, ?> getAttrs() {
		return attrs;
	}
	
	public byte[] getBytes() {
		return bytes;
	}
	
	public FileAttribute<?>[] getFileAttrs() {
		return fileAttrs;
	}
	
	public OpenOption[] getOptions() {
		return options;
	}
	
	public Path getPath() {
		return path;
	}
	
	public Path getReturnValue() {
		return returnValue;
	}
	
	public Exception getError() {
		return error;
	}
}
