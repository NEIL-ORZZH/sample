package org.fireking.app.gametv.fragment;

import org.fireking.app.gametv.R;
import org.fireking.app.kimiralibrary.base.BaseFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CinmaFragment extends BaseFragment {

	public CinmaFragment() {
		super();
	}

	public static CinmaFragment newInstance() {
		return new CinmaFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_cinma, null);
	}

}
