package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class ImageLoader {
    public static BufferedImage getSpriteAtlas(){

        BufferedImage img = null;

        InputStream is = ImageLoader.class.getClassLoader().getResourceAsStream("assets/32x32_map_tile.png");
        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return img;
    }

    //txt file
    public static void CreateFile(){
        File txtFile = new File("src/assets/testTextFile.txt");

        try {
            txtFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void CreateLevel(String name, int [] idArr) {
        File newLevel = new File("src/assets/" + name + ".txt");

        if (newLevel.exists()) {
            System.out.println("File already exists!");
            return;
        } else {
            try {
                newLevel.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        WriteToFile(newLevel, idArr);

    }

    private static void WriteToFile(File f, int[] idArr){
        try {
            PrintWriter pw = new PrintWriter(f);
            for (Integer i : idArr) {
                pw.println(i);
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static void SaveLevel(String name, int[][] idArr) {
        File levelFile = new File("src/assets/" + name + ".txt");

        if (levelFile.exists()) {
            WriteToFile(levelFile, Utils.TwoDintTo1D(idArr));
        } else {
            System.out.println("File does not exist!");
            return;
        }
    }

    public static void ReadFromFile(){
        File txtFile = new File("src/assets/text.txt");

        try {
            Scanner sc = new Scanner(txtFile);  
            
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static ArrayList<Integer> ReadFromFile(File file) {
        ArrayList<Integer> list = new ArrayList<>();

        try {
            Scanner sc = new Scanner(file);  
            
            while (sc.hasNextLine()) {
                list.add(Integer.parseInt(sc.nextLine()));
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }

    public static int[][] GetLevelData(String name) {
        File lvlFile = new File("src/assets/" + name + ".txt");

        if (lvlFile.exists()) {
            ArrayList<Integer> list = ReadFromFile(lvlFile);
            return Utils.ArrayListTo2Dint(list, 20, 20);
            
        } else {
            System.out.println("File" + name + " does not exist!");
            return null;
        }
        
    }

}
