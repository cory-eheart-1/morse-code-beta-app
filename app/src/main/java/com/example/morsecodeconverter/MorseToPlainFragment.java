package com.example.morsecodeconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MorseToPlainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MorseToPlainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    
    private TabLayout tl_secondary;
    private ViewPager2 vp2_secondary;
    private SecondaryFragmentAdapter secondary_adapter;

    private View root;

    public MorseToPlainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MorseToPlainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MorseToPlainFragment newInstance(String param1, String param2) {
        MorseToPlainFragment fragment = new MorseToPlainFragment();
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
        root = inflater.inflate(R.layout.fragment_morse_to_plain, container, false);

        //Assign secondary TabLayout and ViewPager2
        tl_secondary = root.findViewById(R.id.tl_secondary);
        vp2_secondary = root.findViewById(R.id.vp2_secondary);

        //Add necessary tabs to tl_secondary
        tl_secondary.addTab(tl_secondary.newTab().setText("Simple"));
        tl_secondary.addTab(tl_secondary.newTab().setText("Pro"));

        //Create the fragment manager for tl_secondary, and set adapter
        FragmentManager fm = getChildFragmentManager();
        secondary_adapter = new SecondaryFragmentAdapter(fm, getLifecycle());
        vp2_secondary.setAdapter(secondary_adapter);

        vp2_secondary.setUserInputEnabled(false);

        //create tl_secondary tab selected listener
        tl_secondary.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp2_secondary.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //create vp2_secondary page change callback listener
        vp2_secondary.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tl_secondary.selectTab(tl_secondary.getTabAt(position));
            }
        });

        return root;
    }
}