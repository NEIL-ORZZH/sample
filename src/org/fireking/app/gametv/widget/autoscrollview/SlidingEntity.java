package org.fireking.app.gametv.widget.autoscrollview;

import java.io.Serializable;

public class SlidingEntity implements Serializable {

	/**
	 * @Description long serialVersionUID�� TODO
	 **/
	private static final long serialVersionUID = 1L;

	// ��תԴ
	private String uri;

	// ��������
	private String title;

	// ͼƬ��ַ
	private String images;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public SlidingEntity(String uri, String title, String images) {
		super();
		this.uri = uri;
		this.title = title;
		this.images = images;
	}

}
