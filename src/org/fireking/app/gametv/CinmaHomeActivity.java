package org.fireking.app.gametv;

import org.fireking.app.gametv.fragment.ChannelFragment;
import org.fireking.app.gametv.fragment.CinmaFragment;
import org.fireking.app.gametv.fragment.RecommendFragment;
import org.fireking.app.kimiralibrary.base.BaseActivity;
import org.fireking.app.kimiralibrary.utils.Utils;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.google.inject.Inject;

public class CinmaHomeActivity extends BaseActivity {
	ViewPager vPager;
	RadioGroup radiogroup;
	View indicator_line;

	@Inject
	Utils utils;

	private int cell_width = 0;
	private int width;

	String[] datas = new String[] { "热门推荐", "影视爆点", "频道分类" };

	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cinmahome);
		context = this;
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		width = metrics.widthPixels;
		cell_width = width / datas.length;
		initFreamwork();
	}

	private void initFreamwork() {
		vPager = (ViewPager) this.findViewById(R.id.vpager);
		radiogroup = (RadioGroup) this.findViewById(R.id.radiogroup);
		indicator_line = this.findViewById(R.id.indicator_line);
		indicator_line.setLayoutParams(new FrameLayout.LayoutParams(cell_width,
				utils.dip2px(context, 2)));
		LayoutInflater inflater = LayoutInflater.from(context);
		for (int i = 0; i < datas.length; i++) {
			RadioButton button = (RadioButton) inflater.inflate(
					R.layout.tab_radio, null);
			button.setId(i);
			button.setText(datas[i]);
			LayoutParams lp = new LayoutParams(cell_width,
					LayoutParams.MATCH_PARENT, 1);
			button.setTag(i);
			radiogroup.addView(button, lp);
		}

		radiogroup.setOnCheckedChangeListener(onCheckedChangeListener);
		// 点击第一个默认
		radiogroup.getChildAt(0).performClick();
		// radiogroup.check(radiogroup.getChildAt(0).getId());
		initContent();
	}

	private void initContent() {
		CinmaAdapter adapter = new CinmaAdapter(getSupportFragmentManager(),
				context);
		vPager.setAdapter(adapter);

		vPager.setOnPageChangeListener(pageChangeListener);
	}

	OnPageChangeListener pageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
			radiogroup.getChildAt(arg0).performClick();
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};

	class CinmaAdapter extends FragmentStatePagerAdapter {
		Context context;

		public CinmaAdapter(FragmentManager fm, Context context) {
			super(fm);
			this.context = context;
		}

		@Override
		public Fragment getItem(int arg0) {
			Fragment f = null;
			if (arg0 == 0) {
				f = RecommendFragment.newInstance();
			} else if (arg0 == 1) {
				f = CinmaFragment.newInstance();
			} else if (arg0 == 2) {
				f = ChannelFragment.newInstance();
			}
			return f;
		}

		@Override
		public int getCount() {
			return 3;
		}

	}

	int before = 0;
	int from = 0;
	int to = 0;
	OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			RadioButton button = (RadioButton) group.getChildAt(checkedId);
			LayoutParams lp = (LayoutParams) button.getLayoutParams();
			int tWidth = lp.width;
			int tag = (Integer) button.getTag();
			vPager.setCurrentItem(tag);
			if (before - tag > 0) {
				from = before * tWidth;
				to = tag * tWidth;
			} else {
				from = 0;
				to = tag * tWidth;
			}
			before = tag;
			TranslateAnimation animation = new TranslateAnimation(from, to, 0,
					0);
			animation.setFillAfter(true);
			animation.setDuration(200);
			indicator_line.startAnimation(animation);
		}
	};

}
