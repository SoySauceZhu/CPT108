package xjtlu.cpt108.complexity;

import java.io.File;
import java.io.IOException;

import com.olek.util.FileManager;

public class FileWriterTest {

	public void write(File file, String contents) throws IOException {
		System.out.println(file.getAbsolutePath());
		file.getParentFile().mkdirs();
		FileManager.write(file, contents);
	}

	public static void main(String... arguments) {
		File file = new File("./samples/sampleFile.txt");
		String fileContent = "abc\ndef\n12345\n";

		try {
			FileWriterTest tester = new FileWriterTest();
			tester.write(file, fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("-- execution completed!");
		}
	}

}
