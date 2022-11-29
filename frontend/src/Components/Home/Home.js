import {Link} from 'react-router-dom';
import SearchBar from '../SearchBar/SearchBar';

import './Home.css';

function Home(props) {

    return(
        <main className='home-main'>
            <h1>Welcome To The Home page!</h1>
            <SearchBar placeholder="Search" />
            
        </main>
    )
}

export default Home;