import React from 'react'
import styles from './SearchGuide.module.css'

export const SearchGuide = () => {
  return (
    <div className={styles.box}>
        <div className={styles.textBox}>In the search bar, type the name of the football player you want to get information about. Make sure to enter the player's full or partial name accurately for better search results
        <img className={styles.ball2} src="./Ball.svg" style={{
        'zIndex': '0',
        'position': 'absolute',
        'left': '160px'
      }}/>
        </div>
    </div>
  )
}
