package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragments.FavoritesFragment;
import com.example.myapplication.fragments.RecentFragment;

class MainViewPagerAdapter extends FragmentStateAdapter{

    public MainViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return new FavoritesFragment();
        }
        return new RecentFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}