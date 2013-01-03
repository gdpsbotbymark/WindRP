package org.jinghouyu.wind.ftp;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * for providing a standard interface for varies of ftp client .jar file.
 * every kind of ftp client must implement it.
 *
 * @author Simsir.L
 * modified by <person></person> on <data></date>
 *
 * |  created date  | modified date  |  modified person |
 * |         |           |        |
 * @description
 *
 * @since 1.0.0
 */
public interface FtpClient extends Closeable {
	
	/**
	 * set the transfer mode of Ftp communication
	 * @param passiveMode
	 */
	void setMode(boolean passiveMode);
	
	/**
	 * upload local file to Ftp server
	 * @param localPath       the path of local file
	 * @param serverPath      the path of server where you want to put file to.
	 * @throws FtpException   if error occurs, FtpException will be thrown up.
	 */
	void upload(String localPath, String serverPath) throws FtpException;
	
	/**
	 * upload local stream to Ftp serve
	 * @param inputStream      the local input stream
	 * @param serverPath       the path of server where you want to put data to.
	 * @throws FtpException    if error occurs, FtpException will be thrown up.
	 */
	void upload(InputStream inputStream, String serverPath) throws FtpException;
	
	/**
	 * download a file of server to localPath
	 * @param serverPath          the file path of server which would be downloaded
	 * @param localPath           the local path where you want to put data to.
	 * @throws FtpException       if error occurs, FtpException will be thrown up.
	 */
	void download(String serverPath, String localPath) throws FtpException;
	
	/**
	 * download a file of server to an outputstream
	 * @param serverPath         the file path of server which would be downloaded
	 * @param out                the outputstream which you want to put data to.
	 * @throws FtpException      if error occurs, FtpException will be thrown up.
	 */
	void download(String serverPath, OutputStream out) throws FtpException;
	
	/**
	 * get the ouputstream of a server path into which we can put data.
	 * @param serverPath        the server path.
	 * @return
	 * @throws FtpException     if error occurs, FtpException will be thrown up.
	 */
	OutputStream getOutputStream(String serverPath) throws FtpException;
	
	/**
	 * make a directory.
	 * @param dir			   directory path
	 * @throws FtpException    if error occurs, FtpException will be thrown up.
	 */
	void mkdir(String dir) throws FtpException;
	
	/**
	 * make a directory with recursion mode.
	 * @param dir               directory path
	 * @throws FtpException     if error occurs, FtpException will be thrown up.
	 */
	void mkdirs(String dir) throws FtpException;
	
	/**
	 * remove a file
	 * @param filePath           file path
	 * @throws FtpException      if error occurs, FtpException will be thrown up.
	 */
	void rmFile(String filePath) throws FtpException;
	
	/**
	 * remove a directory
	 * @param dirPath          directory path
	 * @throws FtpException    if error occurs, FtpException will be thrown up.
	 */
	void rmDir(String dirPath) throws FtpException;

	/**
	 * remove a directory with recursion mode.
	 * @param dirPath
	 * @throws FtpException
	 */
	void rmDirDeeply(String dirPath) throws FtpException;
}
