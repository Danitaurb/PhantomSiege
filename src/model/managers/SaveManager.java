package model.managers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.saves.GameState;

public class SaveManager {

    // Directory to save the game state
    private static final String SAVE_DIRECTORY = "saves/";  


    public void saveGame( GameState gameState, String fileName) {

        ensureSaveDirectoryExists();

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(SAVE_DIRECTORY + fileName))) {
            outputStream.writeObject(gameState);
            System.out.println("Game saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }


    public void saveGame(GameState gameState) {
        ensureSaveDirectoryExists();
        String fileName = generateFileName(gameState);
        saveGame(gameState, fileName);
    }
        


    public void loadGame() {


    }
    private void ensureSaveDirectoryExists() {
        java.io.File directory = new java.io.File(SAVE_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
  
     private String generateFileName(GameState gameState) {
        int fileCount;

        File directory = new File(SAVE_DIRECTORY);
        if (!directory.exists()) {
            fileCount = 0;
        } else {
            fileCount = directory.list().length;
        }
        return "save_" + (fileCount + 1); 
    }
    


}
