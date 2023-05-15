import React from "react";
import styles from "./LandingPage.module.css";
import { SearchBar } from "./SearchBar";
import { SearchGuide } from "./SearchGuide";

const LandingPage = () => {
  return (
    <>
    
      <div className={styles.header}>
        FOOTBALL
        <span>KNOWLEDGE</span>
        </div>

      <SearchBar/>
      <SearchGuide/>
      
      <img className={styles.ball} src="./Group.svg" style={{
        zIndex: 0,
      }}/>
      </>
      
  );
};

export default LandingPage;
