package org.fireking.app.gametv.fragment;

import org.fireking.app.gametv.R;
import org.fireking.app.kimiralibrary.base.BaseFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ChannelFragment extends BaseFragment {
	public ChannelFragment() {
		super();
	}

	public static ChannelFragment newInstance() {
		return new ChannelFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_channel, null);
	}

}
