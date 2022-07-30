import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileTesting {

    public static void main(String[] args) throws IOException {
        String text = "This is a simple test";

        try(FileOutputStream fileOutputStream = new FileOutputStream("D://fileTesting//test.txt")){
            byte[] buffer = text.getBytes();
            fileOutputStream.write(buffer,0, buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileReader fileReader = new FileReader("D://fileTesting//test.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        }
    }

}
