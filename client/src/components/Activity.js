import React from 'react';
    
const Activity = ({activity}) =>
    
    <div className="col-xs-12 col-md-3" key={activity.id}>
        <div className="card">
            <div className="card-body">
                <h4 className="card-title">{activity.transaction_type}</h4>
                <p className="text-left card-text">Amount: {activity.amount}</p>
                <p className="text-left card-text">Subtotal: {activity.subtotal}</p>
                <p className="text-left card-text">Fee: {activity.fee}</p>
            </div>
        </div>
    </div>

export default Activity;

