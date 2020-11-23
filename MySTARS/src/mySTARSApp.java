import java.io.IOException;

import Interface.AdminApp;
import Interface.LoginInterface;
import Interface.StudentInterface;
import Interface.AdminApp;
/**
 * mySTARSApp is a boundary class which starts the program by creating 
 * and running a {@link Interface.LoginInterface}
 * @author ?
 *
 */
public class mySTARSApp {
	public static void main(String[] args) throws Exception {
		LoginInterface loginInterface = new LoginInterface();
		loginInterface.loginAs();
	}		
}
