package se.sh1re.Knower.service;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import se.sh1re.Knower.driver.Safari;


import java.time.LocalDate;
import java.time.Period;

@Service
@Configurable
public class PlayerService {

    private static final String safariWebDriver = "webdriver.safari.driver";
    private static final String safariWebDriverPath = "/usr/bin/safaridriver";


    private Safari safari;

    public PlayerService(){};

    public String getPersonName(String personName) {
        if(personName == null){
            return "not working";
        } else
        return personName;

    }

    public String getPersonFullName(String personFullName) {

        personFullName = personFullName.replace("[", "");
        personFullName = personFullName.replace("]", "");
        personFullName = personFullName.replaceAll("[0-9]","");
        personFullName =  personFullName.strip();

        return personFullName;
    }
    public LocalDate getPersonBirthDate(String personBirthDate) {
        personBirthDate = personBirthDate.replaceAll("\\s+","");
        personBirthDate = personBirthDate.replace("\u00a0","");

        for(int i = 0; i < personBirthDate.length(); i++){
            if(personBirthDate.charAt(i) == ')'){
                personBirthDate = personBirthDate.substring(1, i);
            }
        }

        String[] birthArray = personBirthDate.split("-");
        int[] birthArrayConverted = new int[birthArray.length];
        for (int i = 0; i < birthArray.length; i++){
            birthArrayConverted[i] = Integer.parseInt(birthArray[i]);
        }
        LocalDate playerBirth = LocalDate.of(birthArrayConverted[0],birthArrayConverted[1],birthArrayConverted[2]);
        return playerBirth;
    }

    public int getPersonAge (LocalDate playerBirth){
        return Period.between(playerBirth, LocalDate.now()).getYears();
    }



    public double getPlayerHeight(String playerHeight) {

        playerHeight = playerHeight.replace("\u00a0","");
        playerHeight = playerHeight.substring(0,5);
        playerHeight = playerHeight.strip();
        double playerHeightConvert = Double.parseDouble(playerHeight);
        return playerHeightConvert;
    }

    public String[] getPlayersPositions(String playerPositions) {
        playerPositions = playerPositions.replace("[", "");
        playerPositions = playerPositions.replace("]", "");
        playerPositions = playerPositions.replaceAll("[0-9]","");
        playerPositions = playerPositions.strip();
        String playerPositionsRemovedOfWhiteSpace = playerPositions;

        if(playerPositions.contains(",")) {

            for (int i = 0; i < playerPositions.length(); i++) {
                if (playerPositions.charAt(i) == ',') {
                    playerPositionsRemovedOfWhiteSpace = playerPositions.substring(0, i+1) + playerPositions.substring(i + 2);
                    playerPositions = playerPositions.substring(i + 1, i + 2);
                }
            }
        }
        System.out.println(playerPositionsRemovedOfWhiteSpace);
        String[] playersPositionsArray = playerPositionsRemovedOfWhiteSpace.split(",");
        return playersPositionsArray;
    }

    
    public String[] getPlayersBirthOfPlace(String playersBirthOfPlace) {

        playersBirthOfPlace = playersBirthOfPlace.replaceAll("\\s+","");
        playersBirthOfPlace = playersBirthOfPlace.replace("\u00a0","");
        playersBirthOfPlace = playersBirthOfPlace.replace("]", "");
        playersBirthOfPlace = playersBirthOfPlace.replace("[" , "");

        playersBirthOfPlace = playersBirthOfPlace.replaceAll("[0-9]","");
        playersBirthOfPlace = playersBirthOfPlace.strip();


        String [] playerBirthOfPlaceArrays = playersBirthOfPlace.split(",");
        return playerBirthOfPlaceArrays;
    }

    
    public String getPlayersCurrentClub(String playersCurrentClubExists, String playersCurrentClub ) { //Need some work on
        String expectedInformation = "Club information";
        playersCurrentClubExists = playersCurrentClubExists.strip();

        if(playersCurrentClubExists.equals(expectedInformation)) {
            playersCurrentClub = playersCurrentClub.strip();
            return playersCurrentClub;
        }
        else {
            return "No Club";
        }

    }

    public int getPlayersShirtNumber(String playersShirtNumber){

        playersShirtNumber = playersShirtNumber.strip();
        int shirtNumber = Integer.parseInt(playersShirtNumber);

        return shirtNumber;
    }




}
