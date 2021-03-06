package finalproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileMerger extends Thread
{
	private File[] files;
	private File mergedFile;
	/*
	 * @param File array with all the file particles, merged file.
	 * 
	 * The purpose of this method is to merge file particles into a big file using
	 * threads running one after another.
	 */
	public FileMerger(File[] files, File mergedFile)
	{
		this.files = files;
		this.mergedFile = mergedFile;
	}
	
	public void mergeFiles() throws IOException, InterruptedException {

		OutputStream out = new FileOutputStream(mergedFile);

		for (File file : files) {

			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					long progress = 0;

					try {
						int length;
						byte[] buffer = new byte[1024];
						InputStream in = new FileInputStream(file);
						while((length = in.read(buffer)) != -1)
						{
							out.write(buffer, 0, length);
							progress += length;
							System.out.println("Progress: " + 100.0* progress / (double) file.length());
						}

						in.close();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			});

			thread.start();
			thread.join();
		}

		out.close();
	}
	public void run(){
		try
		{
			this.mergeFiles();
		} catch (IOException | InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}