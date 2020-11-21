package Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Repository {
	
	//1. For TxtFile, 2. For DatFile
	//int fileType = 1;
	
	public ArrayList readToList() throws IOException;
	public void saveList(List al) throws IOException;
}
