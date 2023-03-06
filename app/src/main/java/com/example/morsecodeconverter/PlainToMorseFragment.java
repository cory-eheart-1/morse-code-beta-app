package com.example.morsecodeconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlainToMorseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlainToMorseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView mt_input;
    private TextView tv_morse_output;
    private String morse = "";

    private View root;

    private Map<String, String> plain_dict = Stream.of(new String[][] {
            {"A", "\u2022\u2014"},
            {"B", "\u2014\u2022\u2022\u2022"},
            {"C", "\u2014\u2022\u2014\u2022"},
            {"D", "\u2014\u2022\u2022"},
            {"E", "\u2022"},
            {"F", "\u2022\u2022\u2014\u2022"},
            {"G", "\u2014\u2014\u2022"},
            {"H", "\u2022\u2022\u2022\u2022"},
            {"I", "\u2022\u2022"},
            {"J", "\u2022\u2014\u2014\u2014"},
            {"K", "\u2014\u2022\u2014"},
            {"L", "\u2022\u2014\u2022\u2022"},
            {"M", "\u2014\u2014"},
            {"N", "\u2014\u2022"},
            {"O", "\u2014\u2014\u2014"},
            {"P", "\u2022\u2014\u2014\u2022"},
            {"Q", "\u2014\u2014\u2022\u2014"},
            {"R", "\u2022\u2014\u2022"},
            {"S", "\u2022\u2022\u2022"},
            {"T", "\u2014"},
            {"U", "\u2022\u2022\u2014"},
            {"V", "\u2022\u2022\u2022\u2014"},
            {"W", "\u2022\u2014\u2014"},
            {"X", "\u2014\u2022\u2022\u2014"},
            {"Y", "\u2014\u2022\u2014\u2014"},
            {"Z", "\u2014\u2014\u2022\u2022"},
            {"1", "\u2022\u2014\u2014\u2014\u2014"},
            {"2", "\u2022\u2022\u2014\u2014\u2014"},
            {"3", "\u2022\u2022\u2022\u2014\u2014"},
            {"4", "\u2022\u2022\u2022\u2022\u2014"},
            {"5", "\u2022\u2022\u2022\u2022\u2022"},
            {"6", "\u2014\u2022\u2022\u2022\u2022"},
            {"7", "\u2014\u2014\u2022\u2022\u2022"},
            {"8", "\u2014\u2014\u2014\u2022\u2022"},
            {"9", "\u2014\u2014\u2014\u2014\u2022"},
            {"0", "\u2014\u2014\u2014\u2014\u2014"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public PlainToMorseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlainToMorseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlainToMorseFragment newInstance(String param1, String param2) {
        PlainToMorseFragment fragment = new PlainToMorseFragment();
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
        root = inflater.inflate(R.layout.fragment_plain_to_morse, container, false);

        mt_input = root.findViewById(R.id.mt_input);
        tv_morse_output = root.findViewById(R.id.tv_morse_output);

        mt_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tv_morse_output.setText("");
                morse = "";
                String upper = charSequence.toString().toUpperCase();
                for (int j = 0; j < upper.length(); j++) {
                    if (upper.charAt(j) == ' ') {
                        morse += " / ";
                    } else {
                        if (plain_dict.containsKey(Character.toString(upper.charAt(j)))) {
                            morse += plain_dict.get(Character.toString(upper.charAt(j)));
                        }
                        else {
                            morse += "#";
                        }
                        morse += " ";
                    }
                }
                tv_morse_output.setText(morse);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return root;
    }
}