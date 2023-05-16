import Head from 'next/head'
import LandingPage from '../components/landingPage/LandingPage'
import { Loading } from '../components/LoadingScreen/Loading'
import { PlayerPage } from '../components/playerPage/PlayerPage'





export default function Home() {
  return (
    <>
    <Head> 
      <meta name="theme-color" content="#1B256D"></meta>
    </Head>
   
   <PlayerPage/>
    
   </>
  )
}
