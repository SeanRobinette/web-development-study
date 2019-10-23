import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

// Function component
function HelloFunction(props) {
    return <h1>Hello {props.name}!</h1>;
}

// Class component
class HelloClass extends React.Component {
    render() {
        return <h1>Hello {this.props.name}!</h1>;
    }
}
class UserInfo extends React.Component {
    render() {
        return(
            <div>
                <img className="avatar" src={this.props.user.avatarUrl}></img>
                <span>{this.props.user.username}</span>
            </div>
        )
    }
}
class Comment extends React.Component {
    render() {
        return (
            <div className="comment">
                <UserInfo className="user-info" user={this.props.user}/>
                <div className="message">{this.props.message}</div>
            </div>
        )
    }
}
const user = {
    avatarUrl: 'https://cdn.emojidex.com/emoji/xhdpi/unicorn_face.png',
    username: 'An Actual Unicorn'
}
const comment = <Comment user={user} message="What's up? I'm a unicorn, that's what!"/>

// Put everything together...
const body = (
    <div>
        {HelloFunction({name: 'Sean'})}
        <HelloClass name="Bob" />
        {comment}
    </div>
    )

// Render to the DOM
ReactDOM.render(body, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
