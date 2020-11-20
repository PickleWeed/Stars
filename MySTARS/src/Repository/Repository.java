package Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Repository {
	public ArrayList readToList() throws IOException;
	public void saveList(List al) throws IOException;
	public void write(String fileName, List data) throws IOException;
	public List read(String fileName) throws IOException;
}
