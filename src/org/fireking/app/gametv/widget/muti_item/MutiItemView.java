package org.fireking.app.gametv.widget.muti_item;

import org.fireking.app.gametv.CinmaHomeActivity;
import org.fireking.app.gametv.R;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MutiItemView {
	CinmaHomeActivity context;
	LayoutInflater inflater;
	LinearLayout rootView;

	public MutiItemView(CinmaHomeActivity context) {
		this.context = context;

		initView();
	}

	private void initView() {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		rootView = (LinearLayout) inflater.inflate(R.layout.mutiitem, null);
		findViewById(rootView);

	}

	private void findViewById(View rootView) {
		RadioGroup radioGroup = (RadioGroup) rootView
				.findViewById(R.id.radipgroup);

		initRadioGroup(radioGroup);

	}

	private void initRadioGroup(RadioGroup group) {
		RadioButton btn;
		for (int i = 0; i < 3; i++) {
			btn = (RadioButton) inflater.inflate(R.layout.radio, null);
			btn.setText("Item " + i);
			group.addView(btn);
		}

		// init-选中第一个
		group.getChildAt(0).performClick();
		group.setOnCheckedChangeListener(listener);
	};

	OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {

		}
	};

	public View getView() {
		return rootView;
	};

}
