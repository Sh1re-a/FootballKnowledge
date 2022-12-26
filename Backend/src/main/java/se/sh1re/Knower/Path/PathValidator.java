package se.sh1re.Knower.Path;

public enum PathValidator {

    FullName {
        public String toString() {
            return "//*[text()='Full name']";
        }
    },
    DateOfBirth {
        public String toString() {
            return "//*[text()='Date of birth']";
        }
    },
    PlaceOfBirth {
        public String toString() {
            return "//*[text()='Place of birth']";
        }
    },
    Height {
        public String toString() {
            return "//*[text()='Height']";
        }
    },
    Positions {
        public String toString() {
            return "//*[text()='Position(s)']";
        }
    },
    CurrentClub {
        public String toString() {
            return "//*[text()='Current team']";
        }
    },
    ShirtNumber {
        public String toString() {
            return "//*[text()='Number']";
        }
    },
    tablePath {
        public String toString() {
            return "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody";
            
        }
    },
}
