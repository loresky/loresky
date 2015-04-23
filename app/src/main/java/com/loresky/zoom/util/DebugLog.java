/***
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

For more information, please refer to <http://unlicense.org/>
 */

package com.loresky.zoom.util;

import com.loresky.zoom.BuildConfig;

import android.util.Log;

/**
 * @date 21.06.2012
 * @author Mustafa Ferhan Akman
 * 
 *         Create a simple and more understandable Android logs.
 * */

public class DebugLog
{

	private static final String TAG = "random";

	static String className;
	static String methodName;
	static int lineNumber;

	private DebugLog()
	{
		/* Protect from instantiations */
	}

	public static boolean isDebuggable()
	{
		return BuildConfig.DEBUG;
	}

	private static String createLog(String log)
	{

		StringBuffer buffer = new StringBuffer();

		buffer.append("【" + className + "->");
		buffer.append(methodName);
		buffer.append("()->");
		buffer.append(lineNumber + "】");
		buffer.append(log);
		return buffer.toString();
	}

	/** 获取类、方法、方法行数 */
	private static void getMethodNames(StackTraceElement[] sElements)
	{
		className = sElements[1].getFileName();
		methodName = sElements[1].getMethodName();
		lineNumber = sElements[1].getLineNumber();
	}

	/** Log.e为红色，可以想到error错误，这里仅显示红色的错误信息，这些错误就需要我们认真的分析，查看栈的信息了 */
	public static void e(String message)
	{
		if (!isDebuggable())
			return;

		// Throwable instance must be created before any methods
		getMethodNames(new Throwable().getStackTrace());
		Log.e(TAG, createLog(message));
	}

	/** Log.i的输出为绿色，一般提示性的消息information，它不会输出Log.v和Log.d的信息，但会显示i、w和e的信息 */
	public static void i(String message)
	{
		if (!isDebuggable())
			return;

		getMethodNames(new Throwable().getStackTrace());
		Log.i(TAG, createLog(message));
	}

	/** Log.d的输出颜色是蓝色的，仅输出debug调试的意思，但他会输出上层的信息，过滤起来可以通过DDMS的Logcat标签来选择 */
	public static void d(String message)
	{
		if (!isDebuggable())
			return;

		getMethodNames(new Throwable().getStackTrace());
		Log.d(TAG, createLog(message));
	}

	/** Log.v 的调试颜色为黑色的，任何消息都会输出，这里的v代表verbose啰嗦的意思 */
	public static void v(String message)
	{
		if (!isDebuggable())
			return;

		getMethodNames(new Throwable().getStackTrace());
		Log.v(TAG, createLog(message));
	}

	/** Log.w的意思为橙色，可以看作为warning警告，一般需要我们注意优化Android代码，同时选择它后还会输出Log.e的信息 */
	public static void w(String message)
	{
		if (!isDebuggable())
			return;

		getMethodNames(new Throwable().getStackTrace());
		Log.w(TAG, createLog(message));
	}

	/**
	 * Log.wtf()记录的则是非常致命的FAULT信息（What a Terrible
	 * Failure），报这个错误，不光是在Log里记录，还要在界面上有提示，并可能杀死当前的进程
	 */
	public static void wtf(String message)
	{
		if (!isDebuggable())
			return;

		getMethodNames(new Throwable().getStackTrace());
		Log.wtf(TAG, createLog(message));
	}

}
