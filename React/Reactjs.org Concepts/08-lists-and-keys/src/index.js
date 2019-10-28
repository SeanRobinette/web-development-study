import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';

function ListItem(props) {
    const value = props.value
    return <li>{value}</li>
}

function NumberList(props) {
    const listItems = props.listItems;
    //const list = listItems.map(i => <ListItem key={i} value={i} />)
    return (
            <ul>
                {listItems.map(i => <ListItem key={i} value={i} />)}
            </ul>
        )
}

function Blog(props) {
    const sidebar = (
        <ul>
            {props.posts.map((post) =>
                <li key={post.id}>
                    {post.title}
                </li>
            )}
        </ul>
    )
    const content = props.posts.map((post) => 
        <div key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.content}</p>
        </div>
    );
    return (
        <div>
            {sidebar}
            <hr/>
            {content}
        </div>
    );
}

const numbers = [1,2,3,4,5]
const posts = [
    {id: 1, title: 'Hello World', content: 'Welcome to learning React!'},
    {id: 2, title: 'Installation', content: 'You can install React using npm.'}
]
const body = (
    <div>
        <NumberList listItems={numbers} />
        <Blog posts={posts} />
    </div>
);
ReactDOM.render(body, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
