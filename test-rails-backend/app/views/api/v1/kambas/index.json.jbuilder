json.status 200
json.message "All Transactions"
json.activities do 
    json.payments @payments
    json.deposits @deposits
    json.withdrawals @withdrawals
    json.tvrecharges @tvrecharges
end