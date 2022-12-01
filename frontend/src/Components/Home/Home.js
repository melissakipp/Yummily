import SearchBar from '../SearchBar/SearchBar';
import Logo from '../assets/logo--color.svg'

import './Home.css';

function Home(props) {

    return(
        <main className='home-main'>
            <img className='logo' src={Logo} alt="Logo" />
            <SearchBar placeholder="Enter a zip code" />         
        </main>
    );
}

export default Home;