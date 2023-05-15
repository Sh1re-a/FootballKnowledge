import React, { useState } from 'react'
import styles from './SearchBar.module.css'
import { FaSearch } from 'react-icons/fa'

export const SearchBar = ({player}) => {
  const [playerName, setPlayerName] = useState("");
  const [inputText, setInputText] = useState("");
  

  const handleClick = () => {
  const transformed = inputText
  .split(' ')
  .map(word => word.charAt(0).toUpperCase() + word.slice(1))
  .join('_');

  setPlayerName(transformed)
  sendDataToParent();
  console.log(transformed);

    
  }

  const sendDataToParent = () => {
    player(playerName);
  }
  return (
    <div className={styles.SearchBar}>
      <div style={{ position: 'relative' }}>
        <input placeholder='Lionel Messi'
        type="text"
        value={inputText}
        onChange={e => setInputText(e.target.value)}
        className={styles.searchInput} />
        <FaSearch
          onClick={handleClick}
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
