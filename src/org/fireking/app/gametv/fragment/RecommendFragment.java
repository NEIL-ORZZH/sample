package org.fireking.app.gametv.fragment;

import java.util.ArrayList;
import java.util.List;

import org.fireking.app.gametv.CinmaHomeActivity;
import org.fireking.app.gametv.R;
import org.fireking.app.gametv.widget.MutiAdapter;
import org.fireking.app.gametv.widget.autoscrollview.KimiraSlidingView;
import org.fireking.app.gametv.widget.muti_item.MutiItemView;
import org.fireking.app.kimiralibrary.base.BaseActivity;
import org.fireking.app.kimiralibrary.base.BaseFragment;
import org.fireking.app.kimiralibrary.base.MergeAdapter;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class RecommendFragment extends BaseFragment {

	private SwipeRefreshLayout swiperefreshlayout;
	private ListView data_list;

	KimiraSlidingView slidingView;

	private CinmaHomeActivity mContext;

	private MergeAdapter mergeAdapter;

	private MutiAdapter mutiAdapter;

	public static RecommendFragment newInstance() {
		return new RecommendFragment();
	}

	public RecommendFragment() {
		super();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_recommend, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (mContext == null) {
			mContext = (CinmaHomeActivity) getActivity();
		}
		slidingView = new KimiraSlidingView(mContext);
		swiperefreshlayout = (SwipeRefreshLayout) getView().findViewById(
				R.id.swiperefreshlayout);
		data_list = (ListView) getView().findViewById(R.id.data_list);

		mergeAdapter = new MergeAdapter();

		mutiAdapter = new MutiAdapter(mContext);

		List<String> m = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			m.add(i + "");
		}

		mutiAdapter.add(m);
		mergeAdapter.addView(slidingView.getView());
		mergeAdapter.addAdapter(mutiAdapter);

		data_list.setAdapter(mergeAdapter);
	}

}
