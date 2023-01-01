import Head from 'next/head'
import Image from 'next/image'
import {Navbar} from '../components/navbar/Navbar'
import SearchEnginePopup from '../components/popup/SearchEnginePopup'
import Searchbar from '../components/searchbar/Searchbar'





export default function Home() {
  return (
    <>
    <Head> 
      <meta name="theme-color" content="#1B256D"></meta>
    </Head>
    <Navbar/>
    <SearchEnginePopup/>
    <Searchbar/>
    
   </>
  )
}
