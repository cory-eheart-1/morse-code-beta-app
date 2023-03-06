package com.example.morsecodeconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SimpleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView tv_input;
    private TextView tv_output;

    private Button btn_dot;
    private Button btn_dash;
    private Button btn_letter;
    private Button btn_word;
    private Button btn_clear;

    private Map<String, String> morse_dict = Stream.of(new String[][] {
            {"\u2022\u2014", "A"},
            {"\u2014\u2022\u2022\u2022", "B"},
            {"\u2014\u2022\u2014\u2022", "C"},
            {"\u2014\u2022\u2022", "D"},
            {"\u2022", "E"},
            {"\u2022\u2022\u2014\u2022", "F"},
            {"\u2014\u2014\u2022", "G"},
            {"\u2022\u2022\u2022\u2022", "H"},
            {"\u2022\u2022", "I"},
            {"\u2022\u2014\u2014\u2014", "J"},
            {"\u2014\u2022\u2014", "K"},
            {"\u2022\u2014\u2022\u2022", "L"},
            {"\u2014\u2014", "M"},
            {"\u2014\u2022", "N"},
            {"\u2014\u2014\u2014", "O"},
            {"\u2022\u2014\u2014\u2022", "P"},
            {"\u2014\u2014\u2022\u2014", "Q"},
            {"\u2022\u2014\u2022", "R"},
            {"\u2022\u2022\u2022", "S"},
            {"\u2014", "T"},
            {"\u2022\u2022\u2014", "U"},
            {"\u2022\u2022\u2022\u2014", "V"},
            {"\u2022\u2014\u2014", "W"},
            {"\u2014\u2022\u2022\u2014", "X"},
            {"\u2014\u2022\u2014\u2014", "Y"},
            {"\u2014\u2014\u2022\u2022", "Z"},
            {"\u2022\u2014\u2014\u2014\u2014", "1"},
            {"\u2022\u2022\u2014\u2014\u2014", "2"},
            {"\u2022\u2022\u2022\u2014\u2014", "3"},
            {"\u2022\u2022\u2022\u2022\u2014", "4"},
            {"\u2022\u2022\u2022\u2022\u2022", "5"},
            {"\u2014\u2022\u2022\u2022\u2022", "6"},
            {"\u2014\u2014\u2022\u2022\u2022", "7"},
            {"\u2014\u2014\u2014\u2022\u2022", "8"},
            {"\u2014\u2014\u2014\u2014\u2022", "9"},
            {"\u2014\u2014\u2014\u2014\u2014", "0"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    private String convertedFromMorse = "";
    private String inputtedMorse = "";
    private String morseToDecode = "";

    private View root;

    public SimpleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SimpleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SimpleFragment newInstance(String param1, String param2) {
        SimpleFragment fragment = new SimpleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_simple, container, false);

        tv_input = root.findViewById(R.id.tv_input);
        tv_output = root.findViewById(R.id.tv_output);
        btn_dot = root.findViewById(R.id.btn_dot);
        btn_dash = root.findViewById(R.id.btn_dash);
        btn_letter = root.findViewById(R.id.btn_letter);
        btn_word = root.findViewById(R.id.btn_word);
        btn_clear = root.findViewById(R.id.btn_clear);

        btn_dot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Button v = (Button)view;
                inputtedMorse += v.getText().toString();
                morseToDecode += v.getText().toString();
                tv_input.setText(inputtedMorse);
            }
        });

        btn_dash.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Button v = (Button)view;
                inputtedMorse += v.getText().toString();
                morseToDecode += v.getText().toString();
                tv_input.setText(inputtedMorse);
            }
        });

        btn_letter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                inputtedMorse += " ";
                if (morse_dict.containsKey(morseToDecode)) {
                    convertedFromMorse += morse_dict.get(morseToDecode);
                } else {
                    convertedFromMorse += "#";
                }
                morseToDecode = "";
                tv_input.setText(inputtedMorse);
                tv_output.setText(convertedFromMorse);
            }
        });

        btn_word.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                inputtedMorse += " / ";
                if (morse_dict.containsKey(morseToDecode)) {
                    convertedFromMorse += morse_dict.get(morseToDecode);
                } else {
                    convertedFromMorse += "#";
                }
                convertedFromMorse += " ";
                morseToDecode = "";
                tv_input.setText(inputtedMorse);
                tv_output.setText(convertedFromMorse);
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                tv_input.setText("");
                tv_output.setText("");
                inputtedMorse = "";
                convertedFromMorse = "";
                morseToDecode = "";
            }
        });

        return root;
    }
}