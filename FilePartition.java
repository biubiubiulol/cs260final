package finalproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilePartition extends Thread
{

	public void run()
	{
		
		File file = new File("/home/kai/workspace/cs260workspace/finalProject/3Gb File");
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long length1 = file.length() / 5;
		long length2 = file.length() * 2 / 5;
		long length3 = file.length() * 3 / 5;
		long length4 = file.length() * 4 / 5;
		long length5 = file.length();
		char tmp = 0;
		File partition1 = new File("old/partition1");
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter(new FileWriter(partition1, true));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int count = 0; count < length1; count++)
		{
			try
			{
				tmp = (char) reader.read();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try
			{
				writer.append(tmp);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{
			writer.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File partition2 = new File("old/partition2");
		try
		{
			writer = new BufferedWriter(new FileWriter(partition2, true));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (long count = length1; count < length2; count++)
		{
			try
			{
				tmp = (char) reader.read();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try
			{
				writer.append(tmp);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{
			writer.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File partition3 = new File("old/partition3");
		try
		{
			writer = new BufferedWriter(new FileWriter(partition3, true));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (long count = length2; count < length3; count++)
		{
			try
			{
				tmp = (char) reader.read();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try
			{
				writer.append(tmp);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{
			writer.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File partition4 = new File("old/partition4");
		try
		{
			writer = new BufferedWriter(new FileWriter(partition4, true));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (long count = length3; count < length4; count++)
		{
			try
			{
				tmp = (char) reader.read();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try
			{
				writer.append(tmp);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{
			writer.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File partition5 = new File("old/partition5");
		try
		{
			writer = new BufferedWriter(new FileWriter(partition5, true));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (long count = length4; count < length5; count++)
		{
			try
			{
				tmp = (char) reader.read();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try
			{
				writer.append(tmp);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{
			writer.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done");
		try
		{
			reader.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void partition250MB() throws IOException
	{
		File file = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/250mb.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		long length1 = file.length() / 5;
		long length2 = file.length() * 2 / 5;
		long length3 = file.length() * 3 / 5;
		long length4 = file.length() * 4 / 5;
		long length5 = file.length();
		char tmp;
		File partition1 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/250mb/partition1.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(partition1, true));
		for (int count = 0; count < length1; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition2 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/250mb/partition2.txt");
		writer = new BufferedWriter(new FileWriter(partition2, true));
		for (long count = length1; count < length2; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition3 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/250mb/partition3.txt");
		writer = new BufferedWriter(new FileWriter(partition3, true));
		for (long count = length2; count < length3; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition4 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/250mb/partition4.txt");
		writer = new BufferedWriter(new FileWriter(partition4, true));
		for (long count = length3; count < length4; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition5 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/250mb/partition5.txt");
		writer = new BufferedWriter(new FileWriter(partition5, true));
		for (long count = length4; count < length5; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		System.out.println("done");
		reader.close();
	}

	public void partition500MB() throws IOException
	{
		File file = new File("/home/kai/workspace/cs260workspace/test_file/500mb.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		long length1 = file.length() / 5;
		long length2 = file.length() * 2 / 5;
		long length3 = file.length() * 3 / 5;
		long length4 = file.length() * 4 / 5;
		long length5 = file.length();
		char tmp;
		File partition1 = new File("/home/kai/workspace/cs260workspace/test_file/500mb/partition1.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(partition1, true));
		for (int count = 0; count < length1; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition2 = new File("/home/kai/workspace/cs260workspace/test_file/500mb/partition2.txt");
		writer = new BufferedWriter(new FileWriter(partition2, true));
		for (long count = length1; count < length2; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition3 = new File("/home/kai/workspace/cs260workspace/test_file/500mb/partition3.txt");
		writer = new BufferedWriter(new FileWriter(partition3, true));
		for (long count = length2; count < length3; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition4 = new File("/home/kai/workspace/cs260workspace/test_file/500mb/partition4.txt");
		writer = new BufferedWriter(new FileWriter(partition4, true));
		for (long count = length3; count < length4; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition5 = new File("/home/kai/workspace/cs260workspace/test_file/500mb/partition5.txt");
		writer = new BufferedWriter(new FileWriter(partition5, true));
		for (long count = length4; count < length5; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		System.out.println("done");
		reader.close();
	}

	public void partition2048MB() throws IOException
	{
		File file = new File("/home/kai/workspace/cs260workspace/test_file/2048mb.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		long reminder =  file.length() % 5;
		long length1 = (file.length()-reminder) / 5;
		long length2 = (file.length()-reminder)  * 2 / 5;
		long length3 = (file.length()-reminder)  * 3 / 5;
		long length4 = (file.length()-reminder)  * 4 / 5;
		long length5 = file.length();
		char tmp;
		for (int i = 0; i < reminder; i++)
		{
			switch (i + 1)
			{
			case 1: 
				length1=length1+i;
				break;
			case 2:
				length2=length2+i;
				break;
			case 3:
				length3=length3+i;
				break;
			case 4:
				length4=length4+i;
				break;
					
			}
		}
		File partition1 = new File("/home/kai/workspace/cs260workspace/test_file/2048mb/partition1.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(partition1, true));
		for (int count = 0; count < length1; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition2 = new File("/home/kai/workspace/cs260workspace/test_file/2048mb/partition2.txt");
		writer = new BufferedWriter(new FileWriter(partition2, true));
		for (long count = length1; count < length2; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition3 = new File("/home/kai/workspace/cs260workspace/test_file/2048mb/partition3.txt");
		writer = new BufferedWriter(new FileWriter(partition3, true));
		for (long count = length2; count < length3; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition4 = new File("/home/kai/workspace/cs260workspace/test_file/2048mb/partition4.txt");
		writer = new BufferedWriter(new FileWriter(partition4, true));
		for (long count = length3; count < length4; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition5 = new File("/home/kai/workspace/cs260workspace/test_file/2048mb/partition5.txt");
		writer = new BufferedWriter(new FileWriter(partition5, true));
		for (long count = length4; count < length5; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		System.out.println("done");
		reader.close();
	}

	public void partition3072MB() throws IOException
	{
		File file = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/3072mb.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		long length1 = file.length() / 5;
		long length2 = file.length() * 2 / 5;
		long length3 = file.length() * 3 / 5;
		long length4 = file.length() * 4 / 5;
		long length5 = file.length();
		char tmp;
		File partition1 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/3072mb/partition1.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(partition1, true));
		for (int count = 0; count < length1; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition2 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/3072mb/partition2.txt");
		writer = new BufferedWriter(new FileWriter(partition2, true));
		for (long count = length1; count < length2; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition3 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/3072mb/partition3.txt");
		writer = new BufferedWriter(new FileWriter(partition3, true));
		for (long count = length2; count < length3; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition4 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/3072mb/partition4.txt");
		writer = new BufferedWriter(new FileWriter(partition4, true));
		for (long count = length3; count < length4; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition5 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/3072mb/partition5.txt");
		writer = new BufferedWriter(new FileWriter(partition5, true));
		for (long count = length4; count < length5; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		System.out.println("done");
		reader.close();
	}

	public void partition1024MB() throws IOException
	{
		File file = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/1024mb.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		long reminder =  file.length() % 5;
		long length1 = (file.length()-reminder) / 5;
		long length2 = (file.length()-reminder)  * 2 / 5;
		long length3 = (file.length()-reminder)  * 3 / 5;
		long length4 = (file.length()-reminder)  * 4 / 5;
		long length5 = file.length();
		char tmp;
		for (int i = 0; i < reminder; i++)
		{
			switch (i + 1)
			{
			case 1: 
				length1++;
				break;
			case 2:
				length2++;
				break;
			case 3:
				length3++;
				break;
			case 4:
				length4++;
				break;
					
			}
		}
		File partition1 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/1024mb/partition1.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(partition1, true));
		for (int count = 0; count < length1; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition2 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/1024mb/partition2.txt");
		writer = new BufferedWriter(new FileWriter(partition2, true));
		for (long count = length1; count < length2; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition3 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/1024mb/partition3.txt");
		writer = new BufferedWriter(new FileWriter(partition3, true));
		for (long count = length2; count < length3; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition4 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/1024mb/partition4.txt");
		writer = new BufferedWriter(new FileWriter(partition4, true));
		for (long count = length3; count < length4; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		File partition5 = new File("/media/kai/b5efec20-84a6-4513-bbd3-d9557b541fab/test/1024mb/partition5.txt");
		writer = new BufferedWriter(new FileWriter(partition5, true));
		for (long count = length4; count < length5; count++)
		{
			tmp = (char) reader.read();
			writer.append(tmp);
		}
		writer.close();
		System.out.println("done");
		reader.close();
	}


}
