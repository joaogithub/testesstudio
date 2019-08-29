package com.testes.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.testes.android.R;
import com.testes.fragment.FragmentTabsFragmentSupport;

public class TabHostActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragmenthost_activity);
		
		Fragment frag = new FragmentTabsFragmentSupport();
		getSupportFragmentManager().beginTransaction().add(R.id.fragment1, frag, "String").commit();
		
	}
	
}
