package hackathon.sdlc.unittests;

import java.io.File;

import org.apache.commons.net.ftp.FTPClient;

import hackathon.sdlc.ftp.FTPServer;
import hackathon.sdlc.ftp.FTPUser;
import hackathon.sdlc.ftp.FileActions;

public class FTPTest {

	public FTPTest() {
		System.out.println("Beginning FTP unit test.");
		
		FTPServer server = new FTPServer("sdlc.drewerth.ehst.co", 21);
		FTPClient client = server.connect();
		
		FTPUser user = new FTPUser("sdlc_user", "Bxz4#8y7");
		user.login(client);
		
		FileActions.upload(client, "memes.pdf", new File("test-data/01.pdf"));
		FileActions.download(client, "memes.pdf", "testobj.pdf");
		
		System.out.println("Finishing FTP unit test.");
	}
	
}
