package org.fireking.app.gametv.widget.muti_item;

import org.fireking.app.kimiralibrary.base.KimiraAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class MutiItemAdapter extends KimiraAdapter<String> {
	Context context;

	public MutiItemAdapter(Context context) {
		this.context = context;
	}

	@Override
	public View extralView(int position, View convertView, ViewGroup parent) {
		return null;
	}

}
