package org.fireking.app.gametv.widget.autoscrollview;

import java.util.List;

import org.fireking.app.gametv.R;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SlidingAdapter extends PagerAdapter {

	private Context context;
	private int mWidth;
	private int mHeight;
	private List<SlidingEntity> entitys;

	public SlidingAdapter(Context context, int width, int height,
			List<SlidingEntity> entitys) {
		this.context = context;
		this.mWidth = width;
		this.mHeight = height;
		this.entitys = entitys;
	}

	static class ViewHolder {
		ImageView image;
		TextView title;
	}

	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((View) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		FrameLayout itemview = (FrameLayout) LayoutInflater.from(context)
				.inflate(R.layout.slidingitem, null);
		LayoutParams params = new LayoutParams(mWidth, mHeight);
		itemview.setLayoutParams(params);

		ImageView image = (ImageView) itemview.findViewById(R.id.image);
		TextView title = (TextView) itemview.findViewById(R.id.title);

		if (entitys != null && entitys.size() > 0) {
			SlidingEntity entity = entitys.get(position % entitys.size());
			title.setText(entity.getTitle());
			Picasso.with(context).load(entity.getImages())
					.placeholder(R.drawable.banner_background)
					.error(R.drawable.banner_background).into(image);
		}
		((ViewPager) container).addView(itemview, 0);
		return itemview;
	}
}
