import React, { Component } from 'react';
import axios from 'axios';
import Activity from './Activity';

class ListsContainer extends Component {

    constructor(props){
        super(props)
        this.state = {
            activities: []
        }
    }

    componentDidMount() {
        axios.get('http://localhost:3001/activities.json')
        .then(response => {
            console.log(response);

            this.setState({activities: response.data})
        })
        .catch(error => console.log(error))
    }

    render() {
        console.log(this.state.activities);

        return (
            <div className="">
                {this.state.activities.map( activity => {
                    return (<Activity activity={activity} key={activity.id} />)
                })}
            </div>
        )
    }
4    
}

export default ListsContainer;