import React, { useEffect, useState } from 'react'
import styles from './Loading.module.css'

import { Animate, AnimateGroup } from 'react-simple-animate';

export const Loading = (props) => {

    const {loadingStatus} = props;
    const items = ['Sit Back', 'Relax, and Let Us Gather the Ultimate', 'Player Intel for You!'];
    const [showLoading, setShowLoading] = useState(loadingStatus);

    useEffect(() => {
        setShowLoading(loadingStatus)
    }, [loadingStatus])

    
   
  return (
    
    <div className={
        showLoading
        ? `${styles.loadingScreen} ${styles.active}`
        : `${styles.loadingScreen}`}>
    <div className={styles.loadingText}>
    'Sit Back', 'Relax, and Let Us Gather the Ultimate', 'Player Intel for You!'
    </div>
    </div>
    
  )
}




