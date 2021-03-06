package hackathon.sdlc.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FileActions {

	public static boolean upload(FTPClient client, String deposit, File file) {
		// Set our file type for upload.
		try {
			client.setFileType(FTP.BINARY_FILE_TYPE);
		} catch (IOException e) {
			System.out.println("FileActions::upload -> IOException");
			return false;
		}
		
		// Validate our connection before attempting an upload.
        if (!client.isConnected())
        {
        	return false;
        }
		
        // Generate an input stream to read.
		InputStream is;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("FileActions::upload -> FileNotFoundException");
			return false;
		}
		
		// Upload our file to the file server.
		try {
			client.storeFile(deposit, is);
			is.close();
		} catch (IOException e) {
			System.out.println("FileActions::upload -> IOException");
			return false;
		}
		
		return true;
	}
	
	public static boolean download(FTPClient client, String remote, String local) {
		// Set our file type for download.
		try {
			client.setFileType(FTP.BINARY_FILE_TYPE);
		} catch (IOException e) {
			System.out.println("FileActions::upload -> IOException");
			return false;
		}
		
		// Validate our connection before attempting an upload.
        if (!client.isConnected())
        {
        	return false;
        }		
        
        // Perform a download operation.
        try (FileOutputStream fos = new FileOutputStream(local)) {
            client.retrieveFile(remote, fos);
        } catch (IOException e) {
			System.out.println("FileActions::upload -> IOException");
			return false;
        }

        return true;
	}	
	
}