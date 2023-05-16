import React from "react";
import styles from "./PlayerPage.module.css"


export const PlayerPage = (props) => {

  const {showPlayer, PlayerDetails} = props;

  return (
    <div className={
      showPlayer? 
       `${styles.container} ${styles.active}`
        : `${styles.container}`}
    >
      <div className={styles.header}>
        Neymar
        <span>Junior</span>
      </div>


      
      <div className={styles.playerBox}>
        <div className={styles.playerHeader}Personal Details>Personal Details</div>

        <div className={styles.lines}>
        <div className={styles.line1}></div>
        <div className={styles.line2}></div>
        </div>


        <div className={styles.boxes}>

        <div className={styles.box}>
            <div className={styles.text}>
            <span>Club</span>
            <span>Paris</span>
            </div>
            <img
        className={styles.ball}
        src="ball3.svg"
        style={{
          zIndex: 0,
          marginLeft: '30px'
            
        }}
      />
        </div>

        <div className={styles.box}>
        <div className={styles.text}>
            <span>Club</span>
            <span>Paris</span>
            </div>
            <img
        className={styles.ball}
        src="pitch.svg"
        style={{
          zIndex: 0,
          marginLeft: '30px',
          
        }}
      />
        </div>


        <div className={styles.box}>
        <div className={styles.text}>
            <span>Club</span>
            <span>Paris</span>
            </div>
                <img
        className={styles.ball}
        src="pass.svg"
        style={{
          zIndex: 0,
          height: '140px',
          width: '140px',
          marginLeft: '50px',
          marginTop: '10px',
        }}
      />
        </div>

        <div className={styles.box}>
        <div className={styles.text}>
            <span>Club</span>
            <span>Paris</span>
            </div>
            <img
        className={styles.ball}
        src="calender.svg"
        style={{
          zIndex: 0,
          height: '140px',
          width: '140px',
          marginLeft: '30px',
          marginTop: '10px',
        }}
      />
        </div>

        <div className={styles.box}>
        <div className={styles.text}>
            <span>Club</span>
            <span>Paris</span>
            </div>            <img
        className={styles.ball}
        src="earth.svg"
        style={{
          zIndex: 0,
          height: '250px',
          width: '250px',
          marginLeft: '-20px',
          marginTop: '-60px',
        }}
      />
        </div>

        <div className={styles.box}>
        <div className={styles.text}>
            <span>Club</span>
            <span>Paris</span>
            </div>            <img
        className={styles.ball}
        src="playerheight.svg"
        style={{
          zIndex: 0,marginLeft: '30px',
        }}

      />
        </div>
        </div>





      </div>
    </div>
  );
};
