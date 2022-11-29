import {Component} from 'react'
import {Switch, Route, Redirect, Link} from 'react-router-dom'
import Login from '../Login/Login'
import Register from '../Register/Register'
import Home from '../Home/Home'
import {addToken, deleteUser} from '../../Redux/actionCreators'
import {connect} from 'react-redux'
import {withRouter} from 'react-router-dom'
import React from 'react'

import './Main.css';

const mapStateToProps = state => {
    return {
        token: state.token,
        user: state.user
    }
}

const mapDispatchToProps = (dispatch) => ({
    addToken: () => { dispatch(addToken()) },
    deleteUser: () => { dispatch(deleteUser())}
});

class Main extends Component {
    constructor(props){
        super(props);
    }

    handleLogout = () => {
        this.props.addToken("")
        this.props.deleteUser()
    }

    render(){
        return(
            <>
            {this.props.token.token !== undefined ?
                    <header className='main-header' id='MainLinks'>
                        <Link id='HomeLinkHome' to='/home'>Home</Link> 
                        <Link id= 'LogoutLink' to='/login' onClick={this.handleLogout}>Logout</Link> 
                        <Redirect to='/home'/>
                    </header>  
                : 
                    <Link id='HomeLinkLogin'  to='/login'>Home</Link>
            }
            <Switch>
                <Route path='/login' component={() => <Login/>}/>
                <Route path='/register'component={() => <Register/>}/>
                <Route path='/home' component={this.props.token.token !== undefined ? () => <Home/> : null}/>
                <Redirect to='/login'/>
            </Switch>

            </>
        )
    }
} 

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Main));