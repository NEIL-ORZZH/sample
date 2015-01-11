package org.fireking.app.gametv.fragment;

import org.fireking.app.gametv.R;
import org.fireking.app.gametv.widget.autoscrollview.KimiraSlidingView;
import org.fireking.app.kimiralibrary.base.BaseFragment;
import org.fireking.app.kimiralibrary.base.MergeAdapter;

import android.app.Activity;
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

	private Activity mContext;

	private MergeAdapter mergeAdapter;

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
			mContext = getActivity();
		}
		slidingView = new KimiraSlidingView(mContext);
		swiperefreshlayout = (SwipeRefreshLayout) getView().findViewById(
				R.id.swiperefreshlayout);
		data_list = (ListView) getView().findViewById(R.id.data_list);

		mergeAdapter = new MergeAdapter();
		mergeAdapter.addView(slidingView.getView());
		data_list.setAdapter(mergeAdapter);
	}

}
