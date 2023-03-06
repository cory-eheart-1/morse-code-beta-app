package com.example.morsecodeconverter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PrimaryFragmentAdapter extends FragmentStateAdapter {

    public PrimaryFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new MorseToPlainFragment();
        }
        return new PlainToMorseFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
