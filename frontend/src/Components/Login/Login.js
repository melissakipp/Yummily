import { Component } from 'react'
import {Link} from 'react-router-dom'
import {connect} from 'react-redux'
import {withRouter} from 'react-router-dom'
import {addToken, addUser} from '../../Redux/actionCreators'
import {baseUrl} from '../../Shared/baseUrl'
import axios from 'axios'
import './Login.css';



const mapDispatchToProps = (dispatch) => ({
    addToken: () =>  dispatch(addToken()),
    addUser: () => dispatch(addUser()) 
});

class Login extends Component {
    
    constructor(props){
        super(props);
        this.state = {
            username: '',
            password: ''
        }
        this.handleInputChange = this.handleInputChange.bind(this);
    }
    

    handleLogin = async () => {
        const data = { username: this.state.username, password: this.state.password };
        

        const userWithToken = await axios.post(baseUrl + '/login', data)

        
        await this.props.dispatch(addToken(userWithToken.data.token))
        await this.props.dispatch(addUser(userWithToken.data.user));
    }

    handleInputChange = (event) => {
        event.preventDefault()
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    render(){
        return(   
            <form className='Forms forms__signin'>
                <legend>Sign In Form</legend>
                <label forHtml='username' class='sr-only'>Username</label>
                <input
                    type='text'
                    id='username'
                    name='username'
                    class='form__field form-control'
                    placeholder='Username or Email'
                    v-model='user.username'
                    onChange={this.handleInputChange}
                    required
                />
                <label forHtml='password' class='sr-only'>Password</label>
                <input
                    type='password'
                    id='password'
                    name='password'
                    class='form__field form-control'
                    placeholder='Password'
                    v-model='user.password'
                    onChange={this.handleInputChange}
                    required
                />
                <button className='btn__signin' id='SignInBttn' type='submit' onClick={this.handleLogin}>Sign in</button>
                <Link id='NeedAccnt' to='/register'>Need an account?</Link>
            </form>
        )
    }
}

export default withRouter(connect(mapDispatchToProps)(Login));