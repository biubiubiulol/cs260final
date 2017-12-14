package finalproject;
//
import java.io.*;
import java.io.ObjectOutputStream.PutField;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServerFile extends Thread
{
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private DataInputStream inStream = null;
	private DataOutputStream outStream = null;
	private String fileName;
	private int port;
	public TCPServerFile(String fileName,int port)
	{
		this.fileName = fileName;
		this.port = port;
	}

	public void run()
	{
		
				try
				{
					// create Server and start listening
					serverSocket = new ServerSocket(port);
					// accept the connection
					socket = serverSocket.accept();
					// fetch the streams
					inStream = new DataInputStream(socket.getInputStream());
					outStream = new DataOutputStream(socket.getOutputStream());
					System.out.println("Connected");
					sendFile(fileName);
				} catch (IOException io)
				{
					io.printStackTrace();
				}
			
	
	}

	public void sendFile(String fileName)
	{
		final int MAX_BUFFER = 1000;
		byte[] data = null;
		int bufferSize = 0;
		try
		{
			// write the filename below in the File constructor
			File file = new File(fileName);
			FileInputStream fileInput = new FileInputStream(file);
			// get the file length
			long fileSize = file.length();

			System.out.println("File size at server is: " + fileSize + " bytes");
			// first send the size of the file to the client
			outStream.writeLong(fileSize);
			outStream.flush();

			// Now send the file contents
			if (fileSize > MAX_BUFFER)
				bufferSize = MAX_BUFFER;
			else
				bufferSize = (int) fileSize;

			data = new byte[bufferSize];

			long totalBytesRead = 0;
			while (true)
			{
				// read upto MAX_BUFFER number of bytes from file
				int readBytes = fileInput.read(data);
				// send readBytes number of bytes to the client
				outStream.write(data);
				outStream.flush();

				// stop if EOF
				if (readBytes == -1)// EOF
					break;

				totalBytesRead = totalBytesRead + readBytes;

				// stop if fileLength number of bytes are read
				if (totalBytesRead == fileSize)
					break;

				//// update fileSize for the last remaining block of data
				if ((fileSize - totalBytesRead) < MAX_BUFFER)
					bufferSize = (int) (fileSize - totalBytesRead);

				// reinitialize the data buffer
				data = new byte[bufferSize];
			}

			fileInput.close();
			serverSocket.close();
			socket.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException
	{
		FilePartition f = new FilePartition();
		f.run();
		f.join();
		
		TCPServerFile[] chatServers = new TCPServerFile[5]; 
		int port = 3334;
		String[] fileNames = { "old/partition1",
				"old/partition2",
				"old/partition3",
				"old/partition4",
				"old/partition5" };
		for (int i = 0; i < 5; i++)
		{
			chatServers[i]=new TCPServerFile(fileNames[i], port);
			port++;
			chatServers[i].start();
		}

	}
}
