import React from 'react'
import styles from './SearchBar.module.css'
import { FaSearch } from 'react-icons/fa'

export const SearchBar = () => {
  return (
    <div className={styles.SearchBar}>
      <div style={{ position: 'relative' }}>
        <input placeholder='Lionel Messi' className={styles.searchInput} />
        <FaSearch
          style={{
            position: 'absolute',
            top: '50%',
            left: '10px',
            transform: 'translateY(-50%)',
            height: '24px',
            width: '24px',
            color: 'white',
          }}
        />
      </div>
    </div>
  )
}
