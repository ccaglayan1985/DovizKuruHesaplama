package com.ccaglayan1985.dovizkuruhesaplama;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CurrencyCalculate extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private Spinner spnBuySell = null;
    private TextView txtAmountHeader = null, txtAbbrevation1 = null;
    private EditText edtAmount = null, edtCent = null;

    private TextView txtAmountHeader2 = null, txtAbbrevation2 = null;
    private EditText edtAmount2 = null, edtCent2 = null;

    private Button btnChangeCurrency = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_calculate);

        initView();
        initEvents();

    }

    private void initView() {
        spnBuySell = (Spinner) findViewById(R.id.activity_currency_spnBuySell);

        View incView1 = findViewById(R.id.activity_currency_calculate_incView1);
        txtAmountHeader = (TextView) incView1.findViewById(R.id.amount_view_layout_txtAmountHeader);
        edtAmount = (EditText) incView1.findViewById(R.id.amount_view_layout_edtAmount);
        edtCent = (EditText) incView1.findViewById(R.id.amount_view_layout_edtCent);
        txtAbbrevation1 = (TextView) incView1.findViewById(R.id.amount_view_layout_txtAbbrevation);

        View incView2 = findViewById(R.id.activity_currency_calculate_incView2);
        txtAmountHeader2 = (TextView) incView2.findViewById(R.id.amount_view_layout_txtAmountHeader);
        edtAmount2 = (EditText) incView2.findViewById(R.id.amount_view_layout_edtAmount);
        edtCent2 = (EditText) incView2.findViewById(R.id.amount_view_layout_edtCent);
        txtAbbrevation2 = (TextView) incView2.findViewById(R.id.amount_view_layout_txtAbbrevation);

        btnChangeCurrency = (Button) findViewById(R.id.activity_currency_calculate_btnChangeCurrency);
    }

    private void initEvents() {

        txtAmountHeader.setText("Döviz Tutarı");
        txtAmountHeader2.setText("TL Tutarı");

        edtAmount.setEnabled(false);
        edtCent.setEnabled(false);

        edtAmount2.addTextChangedListener(this);

        btnChangeCurrency.setOnClickListener(this);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this
                , android.R.layout.simple_spinner_dropdown_item
                , new String[]{"Alış", "Satış"});

        spnBuySell.setAdapter(spinnerArrayAdapter);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (edtAmount2.getText().toString().trim().startsWith("0")) {
            if (edtAmount2.getText().toString().trim().length() == 1) {
                edtAmount2.setText("");
            } else {
                edtAmount2.setText(edtAmount2.getText().subSequence(1, edtAmount2.getText().length()));
            }

        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

