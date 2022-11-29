import {Link} from 'react-router-dom';
import SearchBar from '../SearchBar/SearchBar';

import './Home.css';

function Home(props) {
    return(
        <div id='HomeTitle'>
            Welcome To The Home page!
            <SearchBar />
        </div>
    )
}

export default Home;