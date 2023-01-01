import React from 'react'
import styles from './Navbar.module.css'
import { FiMenu } from 'react-icons/fi'


export const Navbar = () => {
  return (
    <>
    <div className={styles.navbar}>
      
      <img src="./soccer.png"></img>
      
      <div className={styles.header}>
      <img src="./KnowledgeLeagueLogo.svg"></img>
      <div>Knowledge <br/><span>League</span> </div>
      </div>
      <button className={styles.loginButton}>Login</button>
      <button className={styles.signupButton}>Sign Up</button>
      <div className={styles.menu}>
        <FiMenu className={styles.menuBtn}/>
      </div>
    </div>
    </>
  )
}




