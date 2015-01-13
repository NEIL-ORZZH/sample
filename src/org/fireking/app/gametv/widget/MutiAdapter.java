package org.fireking.app.gametv.widget;

import org.fireking.app.gametv.CinmaHomeActivity;
import org.fireking.app.gametv.widget.muti_item.MutiItemView;
import org.fireking.app.kimiralibrary.base.KimiraAdapter;

import android.view.View;
import android.view.ViewGroup;

public class MutiAdapter extends KimiraAdapter<String> {
	private CinmaHomeActivity mContext;

	public MutiAdapter(CinmaHomeActivity mContext) {
		this.mContext = mContext;
	}

	@Override
	public View extralView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = new MutiItemView(mContext).getView();
		}
		return convertView;
	}

}
