package com.acelabs.kambaapi.controller;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.acelabs.kambaapi.R;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    TextView mToTv, mAmountTv, mDescriptionTv, mDateTv;
    TextView mBankTv, mStatusTv;
    TextView mPaymentMethod, mAccountType;
    TextView mPhoneNumberTV, mRechargePrice, mAmountOfUttsTv, mValidityDaysTv, mMobOperatorNameTv,
             mMobOperatorTypeTv;
    ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String transaction_type = getIntent().getExtras().getString("transaction_type");

        if(transaction_type.equals("DEPOSIT")){

            // Changing the action bar title to Deposit details
            getSupportActionBar().setTitle("Deposit details");

            // Getting data from the intent
            String to = getIntent().getExtras().getString("to");
            String amount = getIntent().getExtras().getString("amount");
            String paymentMethod = getIntent().getExtras().getString("paymentMethod");
            String accountType = getIntent().getExtras().getString("accountType");
            String bank = getIntent().getExtras().getString("bank");
            String status = getIntent().getExtras().getString("status");
            String date = getIntent().getExtras().getString("date");

            // Hiding Payment screen layout
            hidePaymentLayout();
            // Hiding Recharge screen layout
            hideRechargeLayout();
            // Hiding Withdrawal screen layout
            hideWithdrawalLayout();
            // Initializing Deposit layout views
            initDepositLayout();
            // Passing data from the intent into the payment views
            setDataToDepositViews(to, amount, paymentMethod, accountType, bank, status, date);

        }else if(transaction_type.equals("PAYMENT")){

            // Changing the action bar title to Payment details
            getSupportActionBar().setTitle("Payment details");

            // Getting data from the intent
            String to = getIntent().getExtras().getString("to");
            String amount = getIntent().getExtras().getString("amount");
            String description = getIntent().getExtras().getString("description");
            String date = getIntent().getExtras().getString("date");

            // Hiding Deposit screen layout
            hideDepositLayout();
            // Hiding Recharge screen layout
            hideRechargeLayout();
            // Hiding Withdrawal screen layout
            hideWithdrawalLayout();
            // Initializing Payment layout views
            initPaymentLayout();
            // Passing data from the intent into payment views
            setDataToPaymentViews(to, amount, description, date);

        }else if(transaction_type.equals("RECHARGE")){

            // Changing the action bar title to Recharge details
            getSupportActionBar().setTitle("Recharge details");

            // Getting the data from the intent
            String phoneNumber = getIntent().getExtras().getString("phoneNumber");
            String amountPaid = getIntent().getExtras().getString("amountPaid");
            String rechargePrice = getIntent().getExtras().getString("rechargePrice");
            String amountOfUtts = getIntent().getExtras().getString("amountOfUtts");
            String validityDays = getIntent().getExtras().getString("validityDays");
            String mobOperatorName = getIntent().getExtras().getString("mobOperatorName");
            String mobOperatorType = getIntent().getExtras().getString("mobOperatorType");
            String status = getIntent().getExtras().getString("status");
            String date = getIntent().getExtras().getString("date");

            // Hiding Deposit screen layout
            hideDepositLayout();
            // Hiding Payment screen layout
            hidePaymentLayout();
            // Hiding Withdrawal screen layout
            hideWithdrawalLayout();
            // Initializing Recharge layout views
            initRechargeLayout();
            // Passing data from the intent into the Recharge views
            setDataToRechargeViews(phoneNumber, amountPaid, rechargePrice, amountOfUtts, validityDays,
                    mobOperatorName, mobOperatorType, status, date);

        }else if(transaction_type.equals("WITHDRAWAL")){

            // Changing the action bar title to Withdrawal details
            getSupportActionBar().setTitle("Withdrawal details");

            // Getting the data from the intent
            String amount = getIntent().getExtras().getString("amount");
            String bank = getIntent().getExtras().getString("bank");
            String status = getIntent().getExtras().getString("status");
            String data = getIntent().getExtras().getString("date");

            // Hiding Payment layout
            hidePaymentLayout();
            // Hiding Deposit layout
            hideDepositLayout();
            // Hiding Recharge screen layout
            hideRechargeLayout();
            // Initializing Withdrawal layout views
            initWithdrawalLayout();
            // Passing data from the intent to the Withdrawal views
            setDataToWithdrawalViews(amount, bank, status, data);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Initialize Payment screen Layout
    public void initPaymentLayout(){
        constraintLayout = (ConstraintLayout) findViewById(R.id.payment_layout);
        constraintLayout.setVisibility(View.VISIBLE);
        mToTv = (TextView) findViewById(R.id.to_txt);
        mAmountTv = (TextView) findViewById(R.id.amount_txt);
        mDescriptionTv = (TextView) findViewById(R.id.description_txt);
        mDateTv = (TextView) findViewById(R.id.date_txt);
    }

    // Set data to Payment layout views
    public void setDataToPaymentViews(String to, String amount, String description, String date){
        mToTv.setText(to);
        mAmountTv.setText(amount + " Kz");
        mDescriptionTv.setText(description);
        mDateTv.setText(date);
    }

    // Hide Payment screen Layout
    public void hidePaymentLayout(){
        constraintLayout = (ConstraintLayout) findViewById(R.id.payment_layout);
        constraintLayout.setVisibility(View.INVISIBLE);
    }

    // Initialize Recharge screen layout
    public void initRechargeLayout(){
        constraintLayout = (ConstraintLayout) findViewById(R.id.recharge_layout);
        constraintLayout.setVisibility(View.VISIBLE);
        mPhoneNumberTV = (TextView) findViewById(R.id.recharge_phone_number_txt);
        mAmountTv = (TextView) findViewById(R.id.recharge_amount_paid_txt);
        mRechargePrice = (TextView) findViewById(R.id.recharge_recharge_price_txt);
        mAmountOfUttsTv = (TextView) findViewById(R.id.recharge_amount_of_utts_txt);
        mValidityDaysTv = (TextView) findViewById(R.id.recharge_validity_days_txt);
        mMobOperatorNameTv = (TextView) findViewById(R.id.recharge_mobile_operator_name_txt);
        mMobOperatorTypeTv = (TextView) findViewById(R.id.recharge_mobile_operator_type_txt);
        mStatusTv = (TextView) findViewById(R.id.recharge_status_txt);
        mDateTv = (TextView) findViewById(R.id.recharge_date_txt);
    }

    // Set data to Recharge layout views
    public void setDataToRechargeViews(String phoneNumber, String amountPaid, String rechargePrice,
                                       String amountOfUtts, String validityDays, String mobOperatorName,
                                       String mobOperatorType, String status, String date){
        mPhoneNumberTV.setText(phoneNumber);
        mAmountTv.setText(amountPaid + " Kz");
        mRechargePrice.setText(rechargePrice + " Kz");
        mAmountOfUttsTv.setText(amountOfUtts);
        mValidityDaysTv.setText(validityDays);
        mMobOperatorNameTv.setText(mobOperatorName);
        mMobOperatorTypeTv.setText(mobOperatorType);
        mStatusTv.setText(status);
        mDateTv.setText(date);
    }

    // Hide Recharge screen layout
    public void hideRechargeLayout(){
        constraintLayout = (ConstraintLayout) findViewById(R.id.recharge_layout);
        constraintLayout.setVisibility(View.INVISIBLE);
    }

    // Initialize Withdrawal screen layout
    public void initWithdrawalLayout(){
        constraintLayout = (ConstraintLayout) findViewById(R.id.withdrawal_layout);
        constraintLayout.setVisibility(View.VISIBLE);
        mAmountTv = (TextView) findViewById(R.id.withdrawal_amount_txt);
        mBankTv = (TextView) findViewById(R.id.withdrawal_bank_txt);
        mStatusTv = (TextView) findViewById(R.id.withdrawal_status_txt);
        mDateTv = (TextView) findViewById(R.id.withdrawal_date_txt);
    }

    // Set data to Withdrawal layout views
    public void setDataToWithdrawalViews(String amount, String bank, String status, String date){
        mAmountTv.setText(amount + " Kz");
        mBankTv.setText(bank);
        mStatusTv.setText(status);
        mDateTv.setText(date);
    }

    // Hide Withdrawal screen layout
    public void hideWithdrawalLayout(){
        constraintLayout = (ConstraintLayout) findViewById(R.id.withdrawal_layout);
        constraintLayout.setVisibility(View.INVISIBLE);
    }

    // Initialize Deposit screen layout
    public void initDepositLayout(){
        constraintLayout = (ConstraintLayout) findViewById(R.id.deposit_layout);
        constraintLayout.setVisibility(View.VISIBLE);
        mToTv = (TextView) findViewById(R.id.deposit_to_txt);
        mAmountTv = (TextView) findViewById(R.id.deposit_amount_txt);
        mPaymentMethod = (TextView) findViewById(R.id.deposit_payment_method_txt);
        mAccountType = (TextView) findViewById(R.id.deposit_account_type_txt);
        mBankTv = (TextView) findViewById(R.id.deposit_bank_txt);
        mStatusTv = (TextView) findViewById(R.id.deposit_status_txt);
        mDateTv = (TextView) findViewById(R.id.deposit_date_txt);
    }

    // Set data to Deposit layout views
    public void setDataToDepositViews(String to, String amount, String paymentMethod, String accountType, String bank, String status, String date){
        mToTv.setText(to);
        mAmountTv.setText(amount + " Kz");
        mPaymentMethod.setText(paymentMethod);
        mAccountType.setText(accountType);
        mBankTv.setText(bank);
        mStatusTv.setText(status);
        mDateTv.setText(date);
    }

    // Hide Deposit screen layout
    public void hideDepositLayout(){
        constraintLayout = (ConstraintLayout) findViewById(R.id.deposit_layout);
        constraintLayout.setVisibility(View.INVISIBLE);
    }



}
