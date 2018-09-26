import React from 'react';
    
const Activity = ({activity}) =>
    
    <div className="" key={activity.id}>
        <h4>{activity.amount}</h4>
        <p>{activity.subtotal}</p>
    </div>

export default Activity;

