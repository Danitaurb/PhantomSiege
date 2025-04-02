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

        InputStream is = ImageLoader.class.getClassLoader().getResourceAsStream("assets/map_tiles.png");
        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return img;
    }

    //txt file
    public static void CreateFile() {
        File txtFile = new File("saves/testTextFile.txt"); 
    
        try {
            if (txtFile.createNewFile()) {
                System.out.println("File creato: " + txtFile.getAbsolutePath());
            } else {
                System.out.println("Il file esiste già: " + txtFile.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void CreateLevel(String name, int[] idArr) {
        File newLevel = new File("saves/" + name + ".txt");
    
        if (newLevel.exists()) {
            System.out.println("Il file esiste già: " + newLevel.getAbsolutePath());
            return;
        } else {
            try {
                if (newLevel.createNewFile()) {
                    System.out.println("File di livello creato: " + newLevel.getAbsolutePath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            WriteToFile(newLevel, idArr);
        }
    }

    private static void WriteToFile(File f, int[] idArr) {
        try (PrintWriter pw = new PrintWriter(f)) {
            for (Integer i : idArr) {
                pw.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       }

       public static void SaveLevel(String name, int[][] idArr) {
        File levelFile = new File("saves/" + name + ".txt");
    
        if (levelFile.exists()) {
            WriteToFile(levelFile, Utils.TwoDintTo1D(idArr));
        } else {
            System.out.println("Il file non esiste: " + levelFile.getAbsolutePath());
        }
    }

    public static void ReadFromFile() {
        InputStream is = ImageLoader.class.getClassLoader().getResourceAsStream("assets/text.txt");
    
        if (is == null) {
            System.out.println("File non trovato: assets/text.txt");
            return;
        }
    
        try (Scanner sc = new Scanner(is)) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
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
      
        InputStream is = ImageLoader.class.getClassLoader().getResourceAsStream("assets/" + name + ".txt");
    
        if (is != null) {
            try (Scanner sc = new Scanner(is)) {
                ArrayList<Integer> list = new ArrayList<>();
                while (sc.hasNextLine()) {
                    list.add(Integer.parseInt(sc.nextLine()));
                }
                return Utils.ArrayListTo2Dint(list, 20, 32);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        
        File lvlFile = new File("saves/" + name + ".txt");
        if (lvlFile.exists()) {
            ArrayList<Integer> list = ReadFromFile(lvlFile);
            return Utils.ArrayListTo2Dint(list, 20, 32);
        } else {
            System.out.println("File " + name + " non esiste!");
            return null;
        }
    }

}
