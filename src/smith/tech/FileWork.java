/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smith.tech;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Samuel
 */
public class FileWork {
    private String path;
    public static String unFile = "C:/ProgramData/Guillotine/username.txt";
    public static String nameFile = "C:/ProgramData/Guillotine/name.txt";
    public static String workDir = "C:/ProgramData/Guillotine";
    
    public static void createDir() {
        File theDir = new File(workDir);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("Creating program files");
            boolean result = false;

            try{
                theDir.mkdir();
                result = true;
            } 
            catch(SecurityException se){
                //handle it
            }        
            if(result) {    
                System.out.println("DIR created");  
            }
        }
        Path file = Paths.get(unFile);
        Path nFile = Paths.get(nameFile);
        
    try {
         // Create the empty file with default permissions, etc.
        Files.createDirectories(file.getParent());
        Files.createFile(file);
        System.out.println("username.txt created");
    } catch (FileAlreadyExistsException x) {
        System.err.format("file named %s" +
            " already exists%n", file);
    } catch (IOException x) {
        // Some other sort of failure, such as permissions.
        System.err.format("createFile error: %s%n", x);
    }
    
    try {
         // Create the empty file with default permissions, etc.
        Files.createDirectories(file.getParent());
        Files.createFile(nFile);
        System.out.println("name.txt created");
    } catch (FileAlreadyExistsException x) {
        System.err.format("file named %s" +
            " already exists%n", file);
    } catch (IOException x) {
        // Some other sort of failure, such as permissions.
        System.err.format("createFile error: %s%n", x);
    }
    }
    
    public FileWork(String file_path) {
        path = file_path;
    }
    
    public String[] OpenFile() throws IOException /*throws IOException*/ {
        
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        
        int numberOfLines = readLines();
        String[] textData = new String[numberOfLines];
        
        int i;
        
        for (i=0; i < numberOfLines; i++) {
            textData[i] = textReader.readLine();
        }
        
        textReader.close();
        return textData;
    }
    
    int readLines() throws FileNotFoundException, IOException /*throws IOException*/ {
        
        FileReader file_to_read = new FileReader(path);
        BufferedReader bf = new BufferedReader (file_to_read);
        
        String aLine;
        int numberOfLines = 0;
        
        while ((aLine = bf.readLine()) != null) {
            numberOfLines++;
        }
        
        bf.close();
        
        return numberOfLines;
    }
}
