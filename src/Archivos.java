import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos {

	private static final String FILE_NAME = "texto.txt";

	public void writeTexto() throws IOException {
		File f = new File(FILE_NAME);

		FileWriter fw = null;
		try {
			fw = new FileWriter(f);

			for (int i = 0; i < 10; i++) {
				fw.write("Linea " + i + "\n");
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (fw != null) {
				fw.flush();
				fw.close();
			}
		}
	}

	public void writeTextoConBuffer() throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
			for (int i = 0; i < 10; i++) {
				bw.write("Linea " + i + "\n");
			}
		}
	}
	
	public void readTexto() throws IOException {
		File f = new File(FILE_NAME);
		
		try (FileReader fr = new FileReader(f)) {

			int c;

			while ((c = fr.read()) != -1) {
				System.out.print((char) c);
			}
		}

	}
	
	public void readTextoConBuffer() throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}

	}
	
	
	public static void main(String[] args) throws IOException {
		Archivos a = new Archivos();
		
		a.writeTexto();
		
		a.readTexto();
		
		a.writeTextoConBuffer();
		
		a.readTextoConBuffer();

	}

}
