package org.fireking.app.gametv.widget.autoscrollview;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.fireking.app.gametv.R;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class KimiraSlidingView {

	private LayoutInflater inflater;
	private FrameLayout slidview;
	private ViewPager vPager;
	private LinearLayout dots;
	private LinearLayout title;

	private Activity context;

	private ImageView emptyview;
	private FrameLayout sliding;

	private SlidingAdapter slidingAdapter;

	int maxWidth = 0;
	int maxHeight = 0;

	public KimiraSlidingView(Activity context) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.context = context;
		DisplayMetrics metrics = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		maxWidth = metrics.widthPixels;
		maxHeight = (int) (maxWidth / 1.77);
		initView();
	}

	private void initView() {
		slidview = (FrameLayout) inflater.inflate(R.layout.slidingview, null);
		vPager = (ViewPager) slidview.findViewById(R.id.viewpager);
		title = (LinearLayout) slidview.findViewById(R.id.title);
		emptyview = (ImageView) slidview.findViewById(R.id.emptyview);
		initSlidViewParams();

		// 初始化viewpager
		initViewPager();
		// 初始化切换动画
		initViewpagerTranslation();
		// 初始化自动滚动
		initAutoScroll();
	}

	private void initViewpagerTranslation() {
		vPager.setPageTransformer(true, new StanTranslation());
	}

	private void initAutoScroll() {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {

				context.runOnUiThread(new Runnable() {

					@Override
					public void run() {
						vPager.setCurrentItem(vPager.getCurrentItem() + 1);
					}
				});
			}
		}, 4000, 4000);
	}

	private void initViewPager() {
		List<SlidingEntity> datas = new ArrayList<SlidingEntity>();
		for (int i = 0; i < 6; i++) {
			datas.add(new SlidingEntity(
					"http://b.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f9ce2a5205262dd42a2834a498.jpg",
					"我是美女" + i,
					"http://b.hiphotos.baidu.com/image/pic/item/eaf81a4c510fd9f9ce2a5205262dd42a2834a498.jpg"));
		}
		slidingAdapter = new SlidingAdapter(context, maxWidth, maxHeight, datas);
		ViewPagerScroller scroller = new ViewPagerScroller(context);
		scroller.setScrollerDuration(1000);
		scroller.initViewPagerScroller(vPager);
		vPager.setAdapter(slidingAdapter);
	}

	private void initSlidViewParams() {
		AbsListView.LayoutParams rp = new AbsListView.LayoutParams(maxWidth,
				maxHeight);
		slidview.setLayoutParams(rp);
	}

	public View getView() {
		return slidview;
	}

}
