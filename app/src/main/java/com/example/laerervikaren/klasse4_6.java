package com.example.laerervikaren;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class klasse4_6 extends Fragment {

    private Button button;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_klasse4_6, container, false);

        button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                OpenMatematik();
            }
        });
        // Inflate the layout for this fragment

        return v;
    }

    public void OpenMatematik(){
        Intent intent = new Intent(getActivity(), matematik.class);
        startActivity(intent);
    }
}
