package java8features.improvements;

/**
 * Some IO improvements known to me are:
 * 
 * Files.list(Path dir) that returns a lazily populated Stream, the elements of
 * which are the entries in the directory. Files.lines(Path path) that reads all
 * lines from a file as a Stream. Files.find() that returns a Stream that is
 * lazily populated with Path by searching for files in a file tree rooted at a
 * given starting file. BufferedReader.lines() that return a Stream, the
 * elements of which are lines read from this BufferedReader.
 * 
 * @author jeevak_gajbhiye
 *
 */
public class JavaIOImporvements {

	public JavaIOImporvements() {
		// TODO Auto-generated constructor stub
	}

}
