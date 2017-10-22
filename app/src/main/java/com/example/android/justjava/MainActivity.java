package com.example.android.justjava;

import android.icu.text.NumberFormat;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity = quantity + 100;
        displayQuantiy(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        if (quantity <= 0) {
            quantity = 0;
        }
        displayQuantiy(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText name = (EditText) findViewById(R.id.name_input);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChocolate = chocolateCheckBox.isChecked();
        Editable customerName = name.getText();
        //Log.v("MainActivity", "Whipped Cream Checkbox is: " + hasWhippedCream);
        //String priceMessage = "Amount Due: $" + price;
        //priceMessage = priceMessage +  "\n\nThank You!";
        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate, customerName));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantiy(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
        //Log.v("MainActivity", "This is the log message");
    }

    /**
     * This method calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    ;

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, Editable customerName) {
        String msg = "Name: " + customerName;
        msg += "\nAdd whipped cream? " + addWhippedCream;
        msg += "\nAdd chocolate? " + addChocolate;
        msg += "\nQuantity: ";
        msg += quantity;
        msg += "\nTotal: $" + price;
        msg += "\nThank You!";
        return msg;
    }
}



