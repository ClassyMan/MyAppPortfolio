package com.example.aidan.myappportfolio;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("My App Portfolio"); // Set the title for the application
        setContentView(R.layout.activity_main); // Set the main view
        if (savedInstanceState == null) {
            getFragmentManager() // Add in our fragment
                    .beginTransaction() // Begin a new fragment transaction
                    .add(R.id.container, new PlaceholderFragment()) // Add our fragment to the application container
                    .commit(); // Commit the transaction
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends android.app.Fragment {
        int tag = 0;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            List<String> applicationNames = Arrays.asList("POPULAR MOVIES",
                                                          "STOCK HAWK",
                                                          "BUILD IT BIGGER",
                                                          "MAKE YOUR APP MATERIAL",
                                                          "GO UBIQUITOUS",
                                                          "CAPSTONE");

            LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.fragment);

            for (String name : applicationNames) {
                layout.addView(createButton(name));
            }
            return rootView;
        }


        /**
         * Create a button object
         * @param text The text which the button object is to display
         * @return The button object
         */
        private Button createButton(final String text) {
            View.OnClickListener btnClicked = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "This button will launch my " + text.toLowerCase() + " app", Toast.LENGTH_SHORT).show();
                }
            };
            Button button = new Button(getActivity());
            button.setText(text);
            button.setTag(tag++);
            button.setOnClickListener(btnClicked);
            return button;
        }
    }
}