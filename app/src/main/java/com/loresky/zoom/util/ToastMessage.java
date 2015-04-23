package com.loresky.zoom.util;

import android.app.Activity;
import android.widget.Toast;

/**
 * @Company: guangpai
 * @Title: ToastMessage.java
 * @Description: 描述
 * @author: chenyong
 * @date: 2015年2月27日
 * @version: 1.0
 */

public class ToastMessage
{
	private static Toast MToast = null;

	/**
	 * 弹出Toast消息
	 * 
	 * @param activity
	 *            当前activity
	 * @param resId
	 *            提示信息
	 * */
	public static final void toastShow(final Activity activity, final int resId)
	{
		activity.runOnUiThread(new Runnable() {
			public void run()
			{
				show(activity, resId, Toast.LENGTH_LONG);
			}
		});
	}

	/**
	 * 弹出Toast消息
	 * 
	 * @param activity
	 *            当前activity
	 * @param resId
	 *            提示信息
	 * @param time
	 *            提示显示的时间
	 * */
	public static final void toastshow(final Activity activity, final int resId, final int time)
	{
		activity.runOnUiThread(new Runnable() {
			public void run()
			{
				show(activity, resId, time);
			}
		});
	}

	/**
	 * Toast显示
	 * 
	 * @param activity
	 *            当前activity
	 * @param resId
	 *            提示信息
	 * @param time
	 *            提示显示的时间
	 * */
	private static void show(Activity activity, int resId, int time)
	{
		// 当前有Toast的提示就关闭
		closd();
		MToast = Toast.makeText(activity, activity.getString(resId), time);
		MToast.show();
	}

	/** Toast关闭提示 */
	public static final void closd()
	{
		if (MToast != null)
		{
			MToast.cancel();
			MToast = null;
		}
	}
}
