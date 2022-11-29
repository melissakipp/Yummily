import {Link} from 'react-router-dom';
import SearchBar from '../SearchBar/SearchBar';
import Logo from '../assets/logo--color.svg'

import './Home.css';

function Home(props) {

    return(
        <main className='home-main'>
            <h1>Welcome!</h1>
            <img className='logo' src={Logo} alt="Logo" />
            <SearchBar placeholder="Enter a zip code" />         
        </main>
    )
}

export default Home;