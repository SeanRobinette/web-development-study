import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
function UserGreeting(props) {
    return <h1>Welcome back.</h1>
}
function GuestGreeting(props) {
    return <h1>Please sign up.</h1>
}
function Greeting(props) {
    const isLoggedIn = props.isLoggedIn;
    if(isLoggedIn)
        return <UserGreeting />
    return <GuestGreeting />
}
function LogInButton(props) {
    return (
        <button onClick={props.onClick}>Log In</button>
    )
}
function LogOutButton(props) {
    return (
        <button onClick={props.onClick}>Log Out</button>
    )
}
class LoginControl extends React.Component {
    constructor(props) {
        super(props);
        this.handleLoginClick = this.handleLoginClick.bind(this);
        this.handleLogoutClick = this.handleLogoutClick.bind(this);
        this.state = {isLoggedIn: false};
    }

    handleLoginClick() {
        console.log('Logging in!')
        this.setState({isLoggedIn: true});
    }

    handleLogoutClick() {
        console.log('Logging out!')
        this.setState({isLoggedIn: false});
    }
    render() {
        const isLoggedIn = this.state.isLoggedIn;

        return (
            <div>
                <Greeting isLoggedIn={isLoggedIn} />
                {isLoggedIn ?
                <LogOutButton onClick={this.handleLogoutClick} /> :
                <LogInButton onClick={this.handleLoginClick} />}
            </div>
        )            

    }
}
function Mailbox(props) {
    const unreadMessages = props.unreadMessages;
    return (
        <div>
            <h2>Hello!</h2>
            {
                unreadMessages.length > 0 && 
                <h3>
                    You have {unreadMessages.length} unread messages.
                </h3>
            }
        </div>
    )
}

function Warning(props) {
    if(!props.warn)
        return null;
    return (
        <div className="warning">Warning!</div>
    )
}
class Page extends React.Component {
    constructor(props) {
        super(props)
        this.state = {showWarning: true};
        this.toggle = this.toggle.bind(this);
    }
    render() {
        return (
        <div>
            <Warning warn={this.state.showWarning}/>
            <button onClick={this.toggle}>
                {this.state.showWarning ? 'Hide' : 'Show'}
            </button>            
        </div>
        )
    }
    toggle() {
        this.setState({showWarning: !this.state.showWarning});
    }
}

const messages = ['React', 'Re: React', 'Re:Re: React']
const body = (
<div>
    <LoginControl />
    <Mailbox unreadMessages={messages}/>
    <Page />
</div>)
ReactDOM.render(body, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
