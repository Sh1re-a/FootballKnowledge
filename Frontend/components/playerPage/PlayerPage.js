import React, { useEffect, useState } from "react";
import styles from "./PlayerPage.module.css";
import Draggable from 'react-draggable';

export const PlayerPage = (props) => {
  const { showPlayer, setShowPlayer ,playerDetails } = props;
  const [boxHeight, setBoxHeight] = useState(1200);
  const [closePlayer, setClosePlayer] = useState(false);
  const [pageShowPlayer, setPageShowPlayer] = useState(showPlayer);

  const getFirstName = (name) => {
    if (!name) return ""
    const nameParts = name.split(" ");
    return nameParts[0];
  };

  const getLastName = (name) => {
    if (!name) return ""
    const nameParts = name.split(" ");
    const lastName = nameParts.slice(1).join(" ");
    return lastName;
  };

  const getPlaceOfBirth = (placeOfBirth) => {
    if (typeof placeOfBirth === 'object' && placeOfBirth !== null) {
      const placeOfBirthString = JSON.stringify(placeOfBirth);
      const formattedPlaceOfBirth = placeOfBirthString.replace(/"/g, '').replace(/,/g, ', ').replace("[", "").replace("]", "");
      
      return formattedPlaceOfBirth;
    }
    return placeOfBirth;
  };

  const getPositions = (positions) => {
    if (positions && Array.isArray(positions)) {
      return positions.join(", ").replace("[", "").replace("]", "");
    }
    return "";
  };
  

  useEffect(() => {
    if (closePlayer) {
      setShowPlayer(false);
      setPageShowPlayer(false);
      console.log("Home clicked");
    }
  }, [closePlayer, setShowPlayer]);

  const handleHeightChange = (e, data) => {
  const { y } = data;
  const minHeight = 900; // Minimum height
  const maxHeight = 1100; // Maximum height

  // Calculate the new height based on drag position
  let newHeight = window.innerHeight - y;
  
  if(newHeight > minHeight && newHeight < maxHeight) { 
    
    return;
  }

  
  console.log(newHeight)
  };

  useEffect(() => {
    if(showPlayer){
      setPageShowPlayer(showPlayer)

    }
}, [showPlayer])


  return (
    <div
      className={
        pageShowPlayer
          ? `${styles.container} ${styles.active}`
          : `${styles.container}`
      }
    >
      <div className={styles.header}>
      {getFirstName(playerDetails?.name)}
        <span>{getLastName(playerDetails?.name)}</span>
      </div>
      <Draggable axis="y" onDrag={handleHeightChange}  cancel={`#${styles.homeButton}`}>
      <div className={styles.playerBox}style={{ height: boxHeight }}>
        <div className={styles.playerHeader}>Personal Details</div>

        <div className={styles.lines}>
          <div className={styles.line1}></div>
          <div className={styles.line2}></div>
        </div>

        
          <div className={styles.boxes}>
            <div className={styles.box}>
            <div className={styles.text}>
            <span>Club</span>
            <span>{playerDetails && playerDetails.currentClub}</span>
            </div>
            <img
        className={styles.ball}
        src="ball3.svg"
        style={{
          zIndex: 0,
          marginLeft: '-10px'
            
        }}
      />
        </div>

        <div className={styles.box}>
        <div className={styles.text}>
            <span>Position</span>
            <span>{playerDetails && getPositions(playerDetails.positions)}</span>
            </div>
            <img
        className={styles.ball}
        src="pitch.svg"
        style={{
          zIndex: 0,
          marginLeft: '-15px',
          
        }}
      />
        </div>


        <div className={styles.box}>
        <div className={styles.text}>
            <span>Full Name</span>
            <span>{playerDetails && playerDetails.fullName}</span>
            </div>
                <img
        className={styles.ball}
        src="pass.svg"
        style={{
          zIndex: 0,
          height: '140px',
          width: '140px',
          marginLeft: '-2px',
          marginTop: '10px',
        }}
      />
        </div>

        <div className={styles.box}>
        <div className={styles.text}>
            <span>Date of birth</span>
            <span>{playerDetails && playerDetails.birth}</span>
            </div>
            <img
        className={styles.ball}
        src="calender.svg"
        style={{
          zIndex: 0,
          height: '140px',
          width: '140px',
          marginLeft: '5px',
          marginTop: '10px',
        }}
      />
        </div>

        <div className={styles.box}>
        <div className={styles.text}>
            <span>Place of birth</span>
            <span>{playerDetails && getPlaceOfBirth(playerDetails.placeOfBirth)}</span>
            </div>            <img
        className={styles.ball}
        src="earth.svg"
        style={{
          zIndex: 0,
          height: '250px',
          width: '250px',
          marginLeft: '-45px',
          marginTop: '-60px',
        }}
      />
        </div>

        <div className={styles.box}>
        <div className={styles.text}>
            <span>Height</span>
            <span>{playerDetails && playerDetails.height}m</span>
            </div>            <img
        className={styles.ball}
        src="playerheight.svg"
        style={{
          zIndex: 0,marginLeft: '-20px',
        }}

      />
      </div>

        
          </div>
          
          <div onClick={()=>setClosePlayer(true)} id={styles.homeButton}>Home</div>
      </div>

        

      </Draggable>
     
    </div>
  );
};