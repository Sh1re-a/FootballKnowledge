import React from 'react'
import styles from './Searchbar.module.css'
import { FaSearch } from 'react-icons/fa'

const Searchbar = () => {
  return (
    <form className={styles.searchbar}>
        <FaSearch className={styles.FaSearch}/>
    <input type="text"/>
    
    </form>
  )
}

export default Searchbar