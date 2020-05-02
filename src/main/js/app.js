import {useEffect, useState} from "react";

import React from 'react';
import 'babel-polyfill';

const App = () => {

    const [data, setData] = useState({})

    useEffect(() => {
        findData().then(r => {})
    },[])

    const findData = async () => {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        const graphql = JSON.stringify({
            query: "{books{id,name,author,publishDate}}",
            variables: {}
        })
        const requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: graphql,
            redirect: 'follow'
        };

        let temp = await fetch("http://localhost:8080/DemoQL/graphql", requestOptions)
            .then(response => {
                return response.json()
            })

        setData(temp.data)
        console.log('temo----')
        console.log(temp.data)
    }

    const renderTable = () => {
        // for (let x of data.data.books) {
        //     return (
        //         <tr>
        //
        //         </tr>
        //     )
        // }
        console.log('------------- data --------------')
        console.log(data);
        console.log('---------------------------------')
        // data.data.books.map(x => {
        if(data.books) {
            for (let x of data.books) {
                return (
                    <tr>
                        <td>{x.id}</td>
                        <td>{x.name}</td>
                        <td>{x.author}</td>
                        <td>{x.publishDate}</td>
                    </tr>
                )
            }
        }
    }

    return (
        <div className="App">
            <table border="1px" color="blue">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Publish Date</th>
                </tr>
                </thead>
                <tbody>
                { renderTable() }
                </tbody>
            </table>
        </div>
    );
}

/*
class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data : { books : []}
        }
    }

    componentDidMount() {
        this.findData().then(r => {})
    }

    setData(x) {
        console.log('set state -----------')
        this.setState({data : x}, () => {
            console.log(this.state.data)
        })
    }

    async findData() {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        const graphql = JSON.stringify({
            query: "{books{name,author,publishDate}}",
            variables: {}
        })
        const requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: graphql,
            redirect: 'follow'
        };

        let temp = await fetch("http://localhost:8080/DemoQL/graphql", requestOptions)
            .then(response => {
                return response.json()
            })

        this.setData(temp.data)
        console.log('temp ----')
        console.log(temp.data)
    }

    renderTable() {
        console.log('------------- data --------------')
        console.log(this.state.data);
        console.log('---------------------------------')
        // data.data.books.map(x => {
        if(this.state.data.books) {
            for (let x of this.state.data.books) {
                return (
                    <tr>
                        <td>1</td>
                        <td>{x.name}</td>
                        <td>{x.author}</td>
                        <td>{x.publishDate}</td>
                    </tr>
                )
            }
        }
    }

    render() {
        return (
            <div className="App">
                <table border="1px">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Author</th>
                        <th>Publish Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    { this.renderTable() }
                    </tbody>
                </table>
            </div>
        );
    }
}
 */

export default App