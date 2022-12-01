import React from 'react';
import useFetch from '../../Hooks/useFetch';
import CardsList from '../Cards/CardsList';

import './SearchBar.css';

function SearchBar({ placeholder, zipCode }) {

    // const Connection ='http://localhost:8081/restaurants/' + zipCode;
    // async function testConnection(e){
    //     e.preventDefault();
    //     const response = await fetch(Connection);
    //     const jsonBody = await response.json();
    //     console.log(jsonBody);
    // }

    // const reqByZipCode  ='http://localhost:8081/restaurants/64142';
    // async function data(e){
    //     e.preventDefault();
    //     const response = await fetch(reqByZipCode);
    //     const jsonBody = await response.json();
    //     console.log(jsonBody);
    // }

    // const reqByZipCode = 'http://localhost:8081/restaurants/';
    // const data = fetch(reqByZipCode)
    //   .then(res => {
    //     if (res.ok) {
    //       console.log('Success')
    //     } else {
    //       console.log('Not Successfull')
    //     }
    //   })
    //   .then(data => console.log(data))
    //   .catch(error => console.log('ERROR'));

    const { data, loading, error } = useFetch('http://localhost:8081/restaurants/64142');

    if (loading) return <h2>Loading...</h2>;

    if (error) return <h2>There was an error, please try again.</h2>;

  return (
    <>
    <section className='search'>
      <form className='Forms' action="">
        <label htmlFor="search-bar" className='sr-only'>Search for a restaurant by zip code</label>
        <input type="text" name="search-bar" id="searchBar" className='search-field' placeholder={placeholder} />
        <button className='btn__search' onClick={console.log(data)}>Test</button>
      </form>
    </section>

    <section>
      <CardsList />
    </section>
    </>
  )
}

export default SearchBar;