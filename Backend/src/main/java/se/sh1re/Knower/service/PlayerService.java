package se.sh1re.Knower.service;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import se.sh1re.Knower.driver.Safari;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

@Service
@Configurable
public class PlayerService {

    private static final String safariWebDriver = "webdriver.chrome.driver";
    private static final String safariWebDriverPath = "C:\\ws\\chromedriver_win32 (2)/chromedriver";


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

        personBirthDate = personBirthDate.replace("\u00a0","");

        int firstCheck = 0;
        int secondCheck = 0;
        for(int i = 0; i < personBirthDate.length(); i++){
            if(personBirthDate.charAt(i) == '('){
                firstCheck = i;
                personBirthDate = personBirthDate.substring(0, firstCheck);
                personBirthDate = personBirthDate.replace("\u00a0","");
                break;
            }
            /*
            if(personBirthDate.charAt(i) == ')'){
                secondCheck = i;
                personBirthDate = personBirthDate.substring(firstCheck + 1, secondCheck);
                break;
            }

             */
        }
        personBirthDate = personBirthDate.trim();
        personBirthDate = personBirthDate.replace(" ", "-");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy", Locale.ENGLISH);
        LocalDate birthdate = LocalDate.parse(personBirthDate, formatter);

        /*

        String[] birthArray = personBirthDate.split("-");
        int[] birthArrayConverted = new int[birthArray.length];
        for (int i = 0; i < birthArray.length; i++){
            birthArrayConverted[i] = Integer.parseInt(birthArray[i]);
        }
        LocalDate playerBirth = LocalDate.of(birthArrayConverted[0],birthArrayConverted[1],birthArrayConverted[2]);

            */
        return birthdate;
    }

    public int getPersonAge (LocalDate playerBirth){
        return Period.between(playerBirth, LocalDate.now()).getYears();
    }



    public double getPlayerHeight(String playerHeight) {

        playerHeight = playerHeight.replace("\u00a0","");

        for(int i = 0; i < playerHeight.length(); i++){
            if(playerHeight.charAt(i) == '.'){
              playerHeight = playerHeight.substring(i-1, i+3);
              break;
            }
        }

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

        String[] playersPositionsArray = playerPositionsRemovedOfWhiteSpace.split(",");
        return playersPositionsArray;
    }

    
    public String[] getPlayersBirthOfPlace(String playersBirthOfPlace) {

        playersBirthOfPlace = playersBirthOfPlace.replace("\u00a0","");
        playersBirthOfPlace = playersBirthOfPlace.replace("]", "");
        playersBirthOfPlace = playersBirthOfPlace.replace("[" , "");

        playersBirthOfPlace = playersBirthOfPlace.replaceAll("[0-9]","");
        playersBirthOfPlace = playersBirthOfPlace.strip();



        String [] playerBirthOfPlaceArrays = playersBirthOfPlace.split(",");
        for(int i = 0; i < playerBirthOfPlaceArrays.length; i++){
            playerBirthOfPlaceArrays[i] = playerBirthOfPlaceArrays[i].strip();
        }
        return playerBirthOfPlaceArrays;
    }

    
    public String getPlayersCurrentClub(String playersCurrentClub ) { //Need some work on


        String error = "Element doesn't exist";

        if(!playersCurrentClub.equals(error)) {
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

    public String setArrayToStringForDB(String[] array){
       String stringToReturn = Arrays.toString(array);
       return stringToReturn;
    }







}
