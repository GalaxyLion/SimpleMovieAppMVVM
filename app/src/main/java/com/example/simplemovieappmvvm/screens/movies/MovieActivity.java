package com.example.simplemovieappmvvm.screens.movies;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;


import com.example.simplemovieappmvvm.BR;
import com.example.simplemovieappmvvm.R;
import com.example.simplemovieappmvvm.base.BaseActivity;
import com.example.simplemovieappmvvm.databinding.ActivityMovieBinding;
import com.example.simplemovieappmvvm.services.navigation.Screen;
import com.example.simplemovieappmvvm.services.navigation.ScreenType;


public class MovieActivity extends BaseActivity<ActivityMovieBinding, MovieViewModel> implements  MovieNavigator {


    private MovieViewModel viewModel;
    private ActivityMovieBinding binding;
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MoviePageAdapter adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        binding = getViewDataBinding();
        viewModel.setNavigator(this);
        adapter = new MoviePageAdapter(getSupportFragmentManager());
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_movie;
    }

    @Override
    public MovieViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        return viewModel;
    }

    @Override
    public void navigateToAuth() {
        getNavigator().navigateTo(Screen.AUTH, ScreenType.ACTIVITY);
    }

    @Override
    public void navigateToProfile() {
        getNavigator().navigateTo(Screen.PROFILE, ScreenType.ACTIVITY);
    }


    private void initView(){
        drawerLayout = binding.drawer;
        tabLayout = binding.tabLayout;
        viewPager = binding.pager;
        toolbar = (Toolbar) binding.toolbar;

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        initBtnActionMenuClick();

    }

    private void initBtnActionMenuClick() {
        toolbar.setNavigationOnClickListener(v->{
            drawerLayout.openDrawer(GravityCompat.START);
        });
    }


}
