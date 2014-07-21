package org.kie.workbench.backend.iolistener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.uberfire.io.FileSystemType;
import org.uberfire.io.IOService;
import org.uberfire.java.nio.IOException;
import org.uberfire.java.nio.channels.SeekableByteChannel;
import org.uberfire.java.nio.file.AtomicMoveNotSupportedException;
import org.uberfire.java.nio.file.CopyOption;
import org.uberfire.java.nio.file.DeleteOption;
import org.uberfire.java.nio.file.DirectoryNotEmptyException;
import org.uberfire.java.nio.file.DirectoryStream;
import org.uberfire.java.nio.file.DirectoryStream.Filter;
import org.uberfire.java.nio.file.FileAlreadyExistsException;
import org.uberfire.java.nio.file.FileSystem;
import org.uberfire.java.nio.file.FileSystemAlreadyExistsException;
import org.uberfire.java.nio.file.FileSystemNotFoundException;
import org.uberfire.java.nio.file.NoSuchFileException;
import org.uberfire.java.nio.file.NotDirectoryException;
import org.uberfire.java.nio.file.OpenOption;
import org.uberfire.java.nio.file.Option;
import org.uberfire.java.nio.file.Path;
import org.uberfire.java.nio.file.ProviderNotFoundException;
import org.uberfire.java.nio.file.attribute.FileAttribute;
import org.uberfire.java.nio.file.attribute.FileAttributeView;
import org.uberfire.java.nio.file.attribute.FileTime;
import org.uberfire.security.auth.AuthenticationManager;
import org.uberfire.security.authz.AuthorizationManager;

public class IOServiceListenerWrapper implements IOService {

	private final IOService wrapper;
	
	private List<IOServiceListener> listeners = new LinkedList<IOServiceListener>();

	public IOServiceListenerWrapper(IOService wrapper) {
		super();
		this.wrapper = wrapper;
	}
	
	public void addListener(IOServiceListener listener) {
		this.listeners.add(listener);
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		wrapper.setAuthenticationManager(authenticationManager);
	}

	public void setAuthorizationManager(AuthorizationManager authorizationManager) {
		wrapper.setAuthorizationManager(authorizationManager);
	}

	public void dispose() {
		wrapper.dispose();
	}

	public void startBatch(Option... options) {
		wrapper.startBatch(options);
	}

	public void endBatch(Option... options) {
		wrapper.endBatch(options);
	}

	public FileAttribute<?>[] convert(Map<String, ?> attrs) {
		return wrapper.convert(attrs);
	}

	public Path get(String first, String... more)
			throws IllegalArgumentException {
		return wrapper.get(first, more);
	}

	public Path get(URI uri) throws IllegalArgumentException,
			FileSystemNotFoundException, SecurityException {
		return wrapper.get(uri);
	}

	public Iterable<FileSystem> getFileSystems() {
		return wrapper.getFileSystems();
	}

	public Iterable<FileSystem> getFileSystems(FileSystemType type) {
		return wrapper.getFileSystems(type);
	}

	public FileSystem getFileSystem(URI uri) throws IllegalArgumentException,
			FileSystemNotFoundException, ProviderNotFoundException,
			SecurityException {
		return wrapper.getFileSystem(uri);
	}

	public FileSystem newFileSystem(URI uri, Map<String, ?> env)
			throws IllegalArgumentException, FileSystemAlreadyExistsException,
			ProviderNotFoundException, IOException, SecurityException {
		return wrapper.newFileSystem(uri, env);
	}

	public FileSystem newFileSystem(URI uri, Map<String, ?> env,
			FileSystemType type) throws IllegalArgumentException,
			FileSystemAlreadyExistsException, ProviderNotFoundException,
			IOException, SecurityException {
		return wrapper.newFileSystem(uri, env, type);
	}

	public void onNewFileSystem(NewFileSystemListener listener) {
		wrapper.onNewFileSystem(listener);
	}

	public InputStream newInputStream(Path path, OpenOption... options)
			throws IllegalArgumentException, NoSuchFileException,
			UnsupportedOperationException, IOException, SecurityException {
		return wrapper.newInputStream(path, options);
	}

	public OutputStream newOutputStream(Path path, OpenOption... options)
			throws IllegalArgumentException, UnsupportedOperationException,
			IOException, SecurityException {
		return wrapper.newOutputStream(path, options);
	}

	public SeekableByteChannel newByteChannel(Path path, OpenOption... options)
			throws IllegalArgumentException, UnsupportedOperationException,
			FileAlreadyExistsException, IOException, SecurityException {
		return wrapper.newByteChannel(path, options);
	}

	public SeekableByteChannel newByteChannel(Path path,
			Set<? extends OpenOption> options, FileAttribute<?>... attrs)
			throws IllegalArgumentException, UnsupportedOperationException,
			FileAlreadyExistsException, IOException, SecurityException {
		return wrapper.newByteChannel(path, options, attrs);
	}

	public DirectoryStream<Path> newDirectoryStream(Path dir)
			throws IllegalArgumentException, NotDirectoryException,
			IOException, SecurityException {
		return wrapper.newDirectoryStream(dir);
	}

	public DirectoryStream<Path> newDirectoryStream(Path dir,
			Filter<Path> filter) throws IllegalArgumentException,
			NotDirectoryException, IOException, SecurityException {
		return wrapper.newDirectoryStream(dir, filter);
	}

	public Path createFile(Path path, FileAttribute<?>... attrs)
			throws IllegalArgumentException, UnsupportedOperationException,
			FileAlreadyExistsException, IOException, SecurityException {
		return wrapper.createFile(path, attrs);
	}

	public Path createDirectory(Path dir, FileAttribute<?>... attrs)
			throws IllegalArgumentException, UnsupportedOperationException,
			FileAlreadyExistsException, IOException, SecurityException {
		return wrapper.createDirectory(dir, attrs);
	}

	public Path createDirectories(Path dir, FileAttribute<?>... attrs)
			throws UnsupportedOperationException, FileAlreadyExistsException,
			IOException, SecurityException {
		return wrapper.createDirectories(dir, attrs);
	}

	public Path createDirectory(Path dir, Map<String, ?> attrs)
			throws IllegalArgumentException, UnsupportedOperationException,
			FileAlreadyExistsException, IOException, SecurityException {
		return wrapper.createDirectory(dir, attrs);
	}

	public Path createDirectories(Path dir, Map<String, ?> attrs)
			throws UnsupportedOperationException, FileAlreadyExistsException,
			IOException, SecurityException {
		return wrapper.createDirectories(dir, attrs);
	}

	public void delete(Path path, DeleteOption... options)
			throws IllegalArgumentException, NoSuchFileException,
			DirectoryNotEmptyException, IOException, SecurityException {
		wrapper.delete(path, options);
	}

	public boolean deleteIfExists(Path path, DeleteOption... options)
			throws IllegalArgumentException, DirectoryNotEmptyException,
			IOException, SecurityException {
		return wrapper.deleteIfExists(path, options);
	}

	public Path createTempFile(String prefix, String suffix,
			FileAttribute<?>... attrs) throws IllegalArgumentException,
			UnsupportedOperationException, IOException, SecurityException {
		return wrapper.createTempFile(prefix, suffix, attrs);
	}

	public Path createTempFile(Path dir, String prefix, String suffix,
			FileAttribute<?>... attrs) throws IllegalArgumentException,
			UnsupportedOperationException, IOException, SecurityException {
		return wrapper.createTempFile(dir, prefix, suffix, attrs);
	}

	public Path createTempDirectory(String prefix, FileAttribute<?>... attrs)
			throws IllegalArgumentException, UnsupportedOperationException,
			IOException, SecurityException {
		return wrapper.createTempDirectory(prefix, attrs);
	}

	public Path createTempDirectory(Path dir, String prefix,
			FileAttribute<?>... attrs) throws IllegalArgumentException,
			UnsupportedOperationException, IOException, SecurityException {
		return wrapper.createTempDirectory(dir, prefix, attrs);
	}

	public Path copy(Path source, Path target, CopyOption... options)
			throws UnsupportedOperationException, FileAlreadyExistsException,
			DirectoryNotEmptyException, IOException, SecurityException {
		return wrapper.copy(source, target, options);
	}

	public Path move(Path source, Path target, CopyOption... options)
			throws UnsupportedOperationException, FileAlreadyExistsException,
			DirectoryNotEmptyException, AtomicMoveNotSupportedException,
			IOException, SecurityException {
		return wrapper.move(source, target, options);
	}

	public <V extends FileAttributeView> V getFileAttributeView(Path path,
			Class<V> type) throws IllegalArgumentException {
		return wrapper.getFileAttributeView(path, type);
	}

	public Map<String, Object> readAttributes(Path path)
			throws UnsupportedOperationException, NoSuchFileException,
			IllegalArgumentException, IOException, SecurityException {
		return wrapper.readAttributes(path);
	}

	public Map<String, Object> readAttributes(Path path, String attributes)
			throws UnsupportedOperationException, NoSuchFileException,
			IllegalArgumentException, IOException, SecurityException {
		return wrapper.readAttributes(path, attributes);
	}

	public Path setAttributes(Path path, FileAttribute<?>... attrs)
			throws UnsupportedOperationException, IllegalArgumentException,
			ClassCastException, IOException, SecurityException {
		return wrapper.setAttributes(path, attrs);
	}

	public Path setAttributes(Path path, Map<String, Object> attrs)
			throws UnsupportedOperationException, IllegalArgumentException,
			ClassCastException, IOException, SecurityException {
		return wrapper.setAttributes(path, attrs);
	}

	public Path setAttribute(Path path, String attribute, Object value)
			throws UnsupportedOperationException, IllegalArgumentException,
			ClassCastException, IOException, SecurityException {
		return wrapper.setAttribute(path, attribute, value);
	}

	public Object getAttribute(Path path, String attribute)
			throws UnsupportedOperationException, IllegalArgumentException,
			IOException, SecurityException {
		return wrapper.getAttribute(path, attribute);
	}

	public FileTime getLastModifiedTime(Path path)
			throws IllegalArgumentException, IOException, SecurityException {
		return wrapper.getLastModifiedTime(path);
	}

	public long size(Path path) throws IllegalArgumentException, IOException,
			SecurityException {
		return wrapper.size(path);
	}

	public boolean exists(Path path) throws IllegalArgumentException,
			SecurityException {
		return wrapper.exists(path);
	}

	public boolean notExists(Path path) throws IllegalArgumentException,
			SecurityException {
		return wrapper.notExists(path);
	}

	public boolean isSameFile(Path path, Path path2)
			throws IllegalArgumentException, IOException, SecurityException {
		return wrapper.isSameFile(path, path2);
	}

	public BufferedReader newBufferedReader(Path path, Charset cs)
			throws IllegalArgumentException, NoSuchFileException, IOException,
			SecurityException {
		return wrapper.newBufferedReader(path, cs);
	}

	public BufferedWriter newBufferedWriter(Path path, Charset cs,
			OpenOption... options) throws IllegalArgumentException,
			IOException, UnsupportedOperationException, SecurityException {
		return wrapper.newBufferedWriter(path, cs, options);
	}

	public long copy(InputStream in, Path target, CopyOption... options)
			throws IOException, FileAlreadyExistsException,
			DirectoryNotEmptyException, UnsupportedOperationException,
			SecurityException {
		return wrapper.copy(in, target, options);
	}

	public long copy(Path source, OutputStream out) throws IOException,
			SecurityException {
		return wrapper.copy(source, out);
	}

	public byte[] readAllBytes(Path path) throws IOException, OutOfMemoryError,
			SecurityException {
		return wrapper.readAllBytes(path);
	}

	public List<String> readAllLines(Path path)
			throws IllegalArgumentException, NoSuchFileException, IOException,
			SecurityException {
		return wrapper.readAllLines(path);
	}

	public List<String> readAllLines(Path path, Charset cs)
			throws IllegalArgumentException, NoSuchFileException, IOException,
			SecurityException {
		return wrapper.readAllLines(path, cs);
	}

	public String readAllString(Path path, Charset cs)
			throws IllegalArgumentException, NoSuchFileException, IOException {
		return wrapper.readAllString(path, cs);
	}

	public String readAllString(Path path) throws IllegalArgumentException,
			NoSuchFileException, IOException {
		return wrapper.readAllString(path);
	}

	public Path write(Path path, byte[] bytes, OpenOption... options)
			throws IOException, UnsupportedOperationException,
			SecurityException {
		fireBeforeWrite(path, bytes, null, options, null);
		try {
			Path retval = wrapper.write(path, bytes, options);
			fireAfterWrite(retval, path, bytes, null, options, null);
			return retval;
		} catch (IOException e) {
			fireErrorWrite(path, bytes, null, options, null, e);
			throw e;
		} catch (UnsupportedOperationException e) {
			fireErrorWrite(path, bytes, null, options, null, e);
			throw e;
		} catch (SecurityException e) {
			fireErrorWrite(path, bytes, null, options, null, e);
			throw e;
		}
	}

	public Path write(Path path, byte[] bytes, Map<String, ?> attrs,
			OpenOption... options) throws IOException,
			UnsupportedOperationException, SecurityException {
		fireBeforeWrite(path, bytes, attrs, options, null);
		try {
			Path retval = wrapper.write(path, bytes, attrs, options);
			fireAfterWrite(retval, path, bytes, attrs, options, null);
			return retval;
		} catch (IOException e) {
			fireErrorWrite(path, bytes, attrs, options, null, e);
			throw e;
		} catch (UnsupportedOperationException e) {
			fireErrorWrite(path, bytes, attrs, options, null, e);
			throw e;
		} catch (SecurityException e) {
			fireErrorWrite(path, bytes, attrs, options, null, e);
			throw e;
		}
	}

	public Path write(Path path, byte[] bytes,
			Set<? extends OpenOption> options, FileAttribute<?>... attrs)
			throws IllegalArgumentException, IOException,
			UnsupportedOperationException {
		fireBeforeWrite(path, bytes, null, options.toArray(new OpenOption[0]), attrs);
		try {
			Path retval = wrapper.write(path, bytes, options, attrs);
			fireAfterWrite(retval, path, bytes, null, options.toArray(new OpenOption[0]), attrs);
			return retval;
		} catch (IllegalArgumentException e) {
			fireErrorWrite(path, bytes, null, options.toArray(new OpenOption[0]), attrs, e);
			throw e;
		} catch (IOException e) {
			fireErrorWrite(path, bytes, null, options.toArray(new OpenOption[0]), attrs, e);
			throw e;
		} catch (UnsupportedOperationException e) {
			fireErrorWrite(path, bytes, null, options.toArray(new OpenOption[0]), attrs, e);
			throw e;
		}
	}

	public Path write(Path path, Iterable<? extends CharSequence> lines,
			Charset cs, OpenOption... options) throws IllegalArgumentException,
			IOException, UnsupportedOperationException, SecurityException {
		fireBeforeWrite(path, toString(lines).getBytes(cs), null, options, null);
		try {
			Path retval = wrapper.write(path, lines, cs, options);
			fireAfterWrite(retval, path, toString(lines).getBytes(cs), null, options, null);
			return retval;
		} catch (IllegalArgumentException e) {
			fireErrorWrite(path, toString(lines).getBytes(cs), null, options, null, e);
			throw e;
		} catch (IOException e) {
			fireErrorWrite(path, toString(lines).getBytes(cs), null, options, null, e);
			throw e;
		} catch (UnsupportedOperationException e) {
			fireErrorWrite(path, toString(lines).getBytes(cs), null, options, null, e);
			throw e;
		} catch (SecurityException e) {
			fireErrorWrite(path, toString(lines).getBytes(cs), null, options, null, e);
			throw e;
		}
	}

	public Path write(Path path, String content, OpenOption... options)
			throws IllegalArgumentException, IOException,
			UnsupportedOperationException {
		fireBeforeWrite(path, content.getBytes(Charset.defaultCharset()), null, options, null);
		try {
			Path retval = wrapper.write(path, content, options);
			fireAfterWrite(retval, path, content.getBytes(Charset.defaultCharset()), null, options, null);
			return retval;
		} catch (IllegalArgumentException e) {
			fireErrorWrite(path, content.getBytes(Charset.defaultCharset()), null, options, null, e);
			throw e;
		} catch (IOException e) {
			fireErrorWrite(path, content.getBytes(Charset.defaultCharset()), null, options, null, e);
			throw e;
		} catch (UnsupportedOperationException e) {
			fireErrorWrite(path, content.getBytes(Charset.defaultCharset()), null, options, null, e);
			throw e;
		}
	}

	public Path write(Path path, String content, Charset cs,
			OpenOption... options) throws IllegalArgumentException,
			IOException, UnsupportedOperationException {
		fireBeforeWrite(path, content.getBytes(cs), null, options, null);
		try {
			Path retval = wrapper.write(path, content, cs, options);
			fireAfterWrite(retval, path, content.getBytes(cs), null, options, null);
			return retval;
		} catch (IllegalArgumentException e) {
			fireErrorWrite(path, content.getBytes(cs), null, options, null, e);
			throw e;
		} catch (IOException e) {
			fireErrorWrite(path, content.getBytes(cs), null, options, null, e);
			throw e;
		} catch (UnsupportedOperationException e) {
			fireErrorWrite(path, content.getBytes(cs), null, options, null, e);
			throw e;
		}
	}

	public Path write(Path path, String content,
			Set<? extends OpenOption> options, FileAttribute<?>... attrs)
			throws IllegalArgumentException, IOException,
			UnsupportedOperationException {
		fireBeforeWrite(path, content.getBytes(Charset.defaultCharset()), null, options.toArray(new OpenOption[0]), attrs);
		try {
			Path retval = wrapper.write(path, content, options, attrs);
			fireAfterWrite(retval, path, content.getBytes(Charset.defaultCharset()), null, options.toArray(new OpenOption[0]), attrs);
			return retval;
		} catch (IllegalArgumentException e) {
			fireErrorWrite(path, content.getBytes(Charset.defaultCharset()), null, options.toArray(new OpenOption[0]), attrs, e);
			throw e;
		} catch (IOException e) {
			fireErrorWrite(path, content.getBytes(Charset.defaultCharset()), null, options.toArray(new OpenOption[0]), attrs, e);
			throw e;
		} catch (UnsupportedOperationException e) {
			fireErrorWrite(path, content.getBytes(Charset.defaultCharset()), null, options.toArray(new OpenOption[0]), attrs, e);
			throw e;
		}
	}

	public Path write(Path path, String content, Charset cs,
			Set<? extends OpenOption> options, FileAttribute<?>... attrs)
			throws IllegalArgumentException, IOException,
			UnsupportedOperationException {
		fireBeforeWrite(path, content.getBytes(cs), null, options.toArray(new OpenOption[0]), attrs);
		try {
			Path retval = wrapper.write(path, content, cs, options, attrs);
			fireAfterWrite(retval, path, content.getBytes(cs), null, options.toArray(new OpenOption[0]), attrs);
			return retval;
		} catch (IllegalArgumentException e) { 
			fireErrorWrite(path, content.getBytes(cs), null, options.toArray(new OpenOption[0]), attrs, e);
			throw e;
		} catch (IOException e) {
			fireErrorWrite(path, content.getBytes(cs), null, options.toArray(new OpenOption[0]), attrs, e);
			throw e;
		} catch (UnsupportedOperationException e) {
			fireErrorWrite(path, content.getBytes(cs), null, options.toArray(new OpenOption[0]), attrs, e);
			throw e;
		}
	}

	public Path write(Path path, String content, Map<String, ?> attrs,
			OpenOption... options) throws IllegalArgumentException,
			IOException, UnsupportedOperationException {
		fireBeforeWrite(path, content.getBytes(Charset.defaultCharset()), attrs, options, null);
		try {
			Path retval = wrapper.write(path, content, attrs, options);
			fireAfterWrite(retval, path, content.getBytes(Charset.defaultCharset()), attrs, options, null);
			return retval;
		} catch (IllegalArgumentException e) { 
			fireErrorWrite(path, content.getBytes(Charset.defaultCharset()), attrs, options, null, e);
			throw e;
		} catch (IOException e) {
			fireErrorWrite(path, content.getBytes(Charset.defaultCharset()), attrs, options, null, e);
			throw e;
		} catch (UnsupportedOperationException e) {
			fireErrorWrite(path, content.getBytes(Charset.defaultCharset()), attrs, options, null, e);
			throw e;
		}
	}

	public Path write(Path path, String content, Charset cs,
			Map<String, ?> attrs, OpenOption... options)
			throws IllegalArgumentException, IOException,
			UnsupportedOperationException {
		fireBeforeWrite(path, content.getBytes(cs), attrs, options, null);
		try {
			Path retval = wrapper.write(path, content, cs, attrs, options);
			fireAfterWrite(retval, path, content.getBytes(cs), attrs, options, null);
			return retval;
		} catch (IllegalArgumentException e) { 
			fireErrorWrite(path, content.getBytes(cs), attrs, options, null, e);
			throw e;
		} catch (IOException e) {
			fireErrorWrite(path, content.getBytes(cs), attrs, options, null, e);
			throw e;
		} catch (UnsupportedOperationException e) {
			fireErrorWrite(path, content.getBytes(cs), attrs, options, null, e);
			throw e;
		}
	}
	
	protected void fireBeforeWrite(Path path, byte[] bytes, Map<String, ?> attrs, OpenOption[] options, FileAttribute<?>[] fileAttrs) {
		IOServiceWriteEvent event = new IOServiceWriteEvent(null, path, bytes, attrs, options, fileAttrs, null);
		for (IOServiceListener listener : listeners) {
			listener.beforeWrite(event);
		}
	}

	protected void fireErrorWrite(Path path, byte[] bytes, Map<String, ?> attrs, OpenOption[] options, FileAttribute<?>[] fileAttrs, Exception e) {
		IOServiceWriteEvent event = new IOServiceWriteEvent(null, path, bytes, attrs, options, fileAttrs, e);
		for (IOServiceListener listener : listeners) {
			listener.errorWrite(event);
		}
	}

	protected void fireAfterWrite(Path retval, Path path, byte[] bytes, Map<String, ?> attrs, OpenOption[] options, FileAttribute<?>[] fileAttrs) {
		IOServiceWriteEvent event = new IOServiceWriteEvent(retval, path, bytes, attrs, options, fileAttrs, null);
		for (IOServiceListener listener : listeners) {
			listener.afterWrite(event);
		}
	}
	
	protected String toString(Iterable<? extends CharSequence> lines) {
		if (lines == null) return null;
		StringBuilder sb = new StringBuilder();
		for (CharSequence line : lines) {
			sb.append(line).append('\n');
		}
		return sb.toString();
	}
}
