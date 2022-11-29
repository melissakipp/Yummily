import {Link} from 'react-router-dom';
import SearchBar from '../SearchBar/SearchBar';

import './Home.css';

function Home(props) {

    return(
        <main className='home-main'>
            <h1>Welcome!</h1>
            <SearchBar placeholder="Enter a zip code" />         
        </main>
    )
}

export default Home;