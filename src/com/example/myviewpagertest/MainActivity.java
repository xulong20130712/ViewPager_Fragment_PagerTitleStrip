package com.example.myviewpagertest;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		ViewPager viewPager= (ViewPager) findViewById(R.id.viewPager);
		PagerTitleStrip pagerTitleStrip= (PagerTitleStrip) findViewById(R.id.pagerTitleStrip);
		List<Fragment> fragments= new ArrayList<Fragment>();
		fragments.add(new Fragment1());
		fragments.add(new Fragment2());
		fragments.add(new Fragment3());
//		List<View> fragments= new ArrayList<View>();
//		LayoutInflater inflater= getLayoutInflater();
//		inflater.from(getApplicationContext());
//		fragments.add(inflater.inflate(R.layout.fragment1, null));
//		fragments.add(inflater.inflate(R.layout.fragment2, null));
//		fragments.add(inflater.inflate(R.layout.fragment3, null));
		
		List<String> titles= new ArrayList<String>();
		titles.add("1");
		titles.add("2");
		titles.add("3");
		
		FragmentManager fragmentManager= getSupportFragmentManager();
		FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
		MyFragmentPagerAdapter myFragmentPagerAdapter= new MyFragmentPagerAdapter(fragmentManager, fragments, titles);
		viewPager.setAdapter(myFragmentPagerAdapter);
	}
}
class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	
	private List<Fragment> fragments; 
	private List<String> titles;
	
	public MyFragmentPagerAdapter(FragmentManager fm, final List<Fragment> fragments, final List<String> titles) {
		
		super(fm);
		this.fragments= fragments;
		this.titles= titles;
	}

	@Override
	public android.support.v4.app.Fragment getItem(int arg0) {

		
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {

		return fragments.size();
	}
	
	@Override
    public CharSequence getPageTitle(int position) {
        return (titles.size() > position) ? titles.get(position) : "";
    }
}
