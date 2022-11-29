import React from 'react';

import './SearchBar.css';

function SearchBar({ placeholder, zipCode }) {

    const Connection ='http://localhost:8081/restaurants/{zipCode}';
    async function testConnection(e){
        e.preventDefault();
        const response = await fetch(Connection);
        const jsonBody = await response.json();
        console.log(jsonBody);
    }

  return (
    <section className='search'>
      <form className='Forms' action="">
        <label htmlFor="search-bar" className='sr-only'>Search for a restaurant by zip code</label>
        <input type="text" name="search-bar" id="searchBar" className='search-field' placeholder={placeholder} />
        <button onClick={testConnection}>Test</button>
      </form>
      
    </section>
  )
}

export default SearchBar;