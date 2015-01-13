package org.fireking.app.gametv.widget.muti_item;

import org.fireking.app.gametv.R;
import org.fireking.app.kimiralibrary.base.BaseFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CommFragment extends BaseFragment {

	final int MAX_COLUMN = 2;

	LayoutInflater inflater;

	Activity mContext;

	int position;

	public CommFragment(int position) {
		this.position = position;
		Bundle b = getArguments();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public static CommFragment newInstance(int position) {
		CommFragment fragment = new CommFragment(position);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.home_item, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mContext = getActivity();
		inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		initView();
	}

	private void initView() {
		FrameLayout thumb_item = (FrameLayout) getView().findViewById(
				R.id.thumb_item);
		ImageView thumb = (ImageView) getView().findViewById(R.id.thumb);
		ImageView mask = (ImageView) getView().findViewById(R.id.mask);
		LinearLayout gridview = (LinearLayout) getView().findViewById(
				R.id.gridview);

		initGridView(gridview);
	}

	private void initGridView(LinearLayout gridview) {
		DisplayMetrics metrics = new DisplayMetrics();
		mContext.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = width / 2;
		// 这里展示6个
		LinearLayout rowLinearLayout = null;
		LinearLayout gridItem;
		for (int i = 0; i < 4; i++) {
			gridItem = (LinearLayout) inflater.inflate(R.layout.g_item, null);
			gridItem.setLayoutParams(new LinearLayout.LayoutParams(width,
					height, 1));
			if (i % MAX_COLUMN == 0) {
				rowLinearLayout = new LinearLayout(mContext);
				rowLinearLayout.addView(gridItem);
			} else {
				rowLinearLayout.addView(gridItem);
			}
		}
		gridview.addView(rowLinearLayout);
	}
}
