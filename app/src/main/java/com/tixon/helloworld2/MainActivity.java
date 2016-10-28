package com.tixon.helloworld2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    interface SomeInterface {
        void doSomething();
        void doSomethingElse();
    }

    SomeInterface someInterfaceRealization = new SomeInterface() {
        @Override
        public void doSomething()
        {
            Log.d("tag", "I did something");
        }

        @Override
        public void doSomethingElse()
        {
            Log.e("tag", "I did something wrong OOPS");
        }
    };

    View.OnClickListener textViewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showToast("Textview clicked!");
            someInterfaceRealization.doSomething();
        }
    };

    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showToast("Button clicked!");
            someInterfaceRealization.doSomethingElse();
        }
    };

    private void showToast(String text) {
        //makeText(Context context, _____String text______, long length)
        Toast.makeText(
                this, //context
                text, //text inside toast
                Toast.LENGTH_LONG) //how long should Toast be shown on screen
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById возвращает тип View
        //View - элемент, от которого наследуются все элементы разметки

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setOnClickListener(textViewClickListener);

        TextView textViewNew = (TextView) findViewById(R.id.textView2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(buttonClickListener);
    }
}
