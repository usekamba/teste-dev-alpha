import React from 'react';
import Currency from 'react-currency-formatter';


const Activity = ({activity}) =>
    
    
    <div className="col-xs-12 col-md-3" key={activity.id}>
        <div className="card">
            <div className="card-body">

                <h4 className="card-title">{activity.transaction_type}</h4>
                <p className="text-left card-text">Amount: <Currency quantity={activity.amount ? activity.amount : 0} currency="AOA" pattern="##,### !" decimal="," group="."/></p>
                <p className="text-left card-text">Subtotal: <Currency quantity={activity.subtotal ? activity.subtotal : 0} currency="AOA" pattern="##,### !" decimal="," group="."/></p>
                <p className="text-left card-text">Fee: {activity.fee}</p>
            </div>
        </div>
    </div>

export default Activity;

