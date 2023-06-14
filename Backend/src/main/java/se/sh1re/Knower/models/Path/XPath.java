package se.sh1re.Knower.models.Path;

public enum XPath {


     name {
         public String toString() {
             return "//*[@id=\"firstHeading\"]/span";
         }
     },
     fullName {
         public String toString(){
             return "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[3]/td";
         }
     },
    birthDate {
        public String toString(){
            return "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[4]/td";

        }
    },
    height {
        public String toString(){
            return "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[6]/td";
        }
    },
    positions {
        public String toString(){
            return "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[7]/td";
        }
    },
    birthPlace {
        public String toString(){
            return "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[5]/td";
        }
    },
    currentClubExits {
        public String toString(){
            return "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[8]/th";
        }
    },
    currentClub {
        public String toString(){
            return "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[9]/td";
        }
    },
    shirtNumber {
        public String toString(){
            return "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[10]/td";
        }
    },
    firstYouthTeam{
        public String toString(){
            return "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[11]/td";
        }
    },



}
