/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomcharacter;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *This class contains methods for taking the acquired user input and using it to generate a random character
 * @author Ian
 */
public class CharacterCreator {
    String professions;
    String races;
    String skills;
    int skillCap;
    
    ArrayList<String> finalList = new ArrayList<String>();
    
    // parsed strings
    ArrayList<String> parsedProfessions = new ArrayList<String>();
    ArrayList<String> parsedRaces = new ArrayList<String>();
    ArrayList<String> parsedSkills = new ArrayList<String>();
    
    // constructor
    public CharacterCreator(String professions, String races, String skills, int skillCap) {
        this.professions = professions;
        this.races = races;
        this.skills = skills;
        this.skillCap = skillCap;
    }
    
    /**
     * method to randomly combine character attributes
     * will fill out a string ArrayList with all the attributes
     * @return The ArrayList of character attributes
     */
    public void characterRandomize() {
        
  
        Random professionRNG = new Random();
        Random raceRNG = new Random();
        Random skillRNG = new Random();
       
        int professionRand;
        int raceRand;
        int skillRand;
        
        /* this arraylist holds info in the order of:
           Profession
           Race
           Skill1
           Skill1 level
           Skill2
           Skill2 level
           until end of skills
        */
         ArrayList<String> finalCharacterAttributes = new ArrayList<String>();
        
        // assign profession
        professionRand = professionRNG.nextInt(parsedProfessions.size());
        finalCharacterAttributes.add(parsedProfessions.get(professionRand)); // assign random profession to first slot
        
        // assign race
        raceRand = raceRNG.nextInt(parsedRaces.size()); 
        finalCharacterAttributes.add(parsedRaces.get(raceRand)); // assign random race to second slot
        
        // assign skills and their levels
        for (int i = 0; i < parsedSkills.size(); i++) {
            finalCharacterAttributes.add(parsedSkills.get(i)); // add each skill
            
            // add a random skill level after each skill
            skillRand = skillRNG.nextInt(skillCap) + 1; 
            finalCharacterAttributes.add(Integer.toString(skillRand)); // convert skill level to string and add after the skill
        }
        
        finalList = finalCharacterAttributes;
        
    }
    
    /**
     * method to populate the professions, races, and skills lists
     */
    public void populateLists() {
        parsedProfessions = stringParser(professions);
        parsedRaces = stringParser(races);
        parsedSkills = stringParser(skills);
    }
    
    /**
     * method to take individual words from a longer string and return an array list of words
     * @param list The string to be parsed
     * @return an ArrayList of parsed strings
     */
    private ArrayList<String> stringParser(String list) {
        
        ArrayList<String> parsedList = new ArrayList<String>();
        
       
        String[] words = list.split(" ");
        for (int i = 0; i < words.length; i++) {
            parsedList.add(words[i]);
        }
    
        return parsedList;
    }
    
    /*
     *converts the arraylist into a stylized string ready to be printed in the JFrame
    @return The completed string of character information
    */
    public String characterToString() {
        String printableCharacter;
        
        printableCharacter = "Profession: " + finalList.get(0) + "\n"
                + "Race: " + finalList.get(1) + "\n";
        
        for (int i = 2; i < finalList.size(); i += 2) {
            printableCharacter += finalList.get(i) + ": " + finalList.get(i+1) + "\n";
        }
        
        return printableCharacter;
        
    }
}

