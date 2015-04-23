package com.loresky.zoom.test.asynctask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loresky.zoom.util.DebugLog;

/**
 * Created by Administrator on 2015/3/3.
 * AsyncTask是Handler的一个轻量级实现，模型类似于IntentService于Service。
 * 都是为了更加方便操作。（因为一般的异步，我们都是开启一个子线程或是匿名线程，缺点就是样的实现对于线程的操作，控制是十分困难）
 * <p/>
 * <h1>AsyncTask定义了三种泛型类型 Params，Progress和Result。</h1>
 * •Params 启动任务执行的输入参数，比如HTTP请求的URL。
 * •Progress 后台任务执行的百分比。
 * •Result 后台执行任务最终返回的结果，比如String。
 * <p/>
 * <h1>AsyncTask的执行分为四个步骤，每一步都对应一个回调方法，开发者需要实现一个或几个方法。在任务的执行过程中，这些方法被自动调用。</h1>
 * onPreExecute(), 该方法将在执行实际的后台操作前被UI thread调用。可以在该方法中做一些准备工作，如在界面上显示一个进度条。
 * doInBackground(Params...), 将在onPreExecute 方法执行后马上执行，该方法运行在后台线程中。这里将主要负责执行那些很耗时的后台计算工作。可以调用 publishProgress方法来更新实时的任务进度。该方法是抽象方法，子类必须实现。
 * onProgressUpdate(Progress...),在publishProgress方法被调用后，UI thread将调用这个方法从而在界面上展示任务的进展情况，例如通过一个进度条进行展示。
 * onPostExecute(Result), 在doInBackground 执行完成后，onPostExecute 方法将被UI thread调用，后台的计算结果将通过该方法传递到UI thread.
 * <p/>
 * <h1>使用AsyncTask类，以下是几条必须遵守的准则：</h1>
 * 1) Task的实例必须在UI thread中创建
 * 2) execute方法必须在UI thread中调用
 * 3) 不要手动的调用onPreExecute(), onPostExecute(Result)，doInBackground(Params...), onProgressUpdate(Progress...)这几个方法
 * <p/>
 * 4) 该task只能被执行一次，否则多次调用时将会出现异常
 */
public class DownAsyncTask extends AsyncTask<Integer, Integer, String> {
    private TextView mTextView;
    private ProgressBar mProgressBar;

    public DownAsyncTask(TextView mTextView, ProgressBar mProgressBar) {
        this.mTextView = mTextView;
        this.mProgressBar = mProgressBar;
    }

    /**
     * 这里的String参数对应AsyncTask中的第一个参数
     * 这里的String返回值对应AsyncTask的第三个参数
     * 该方法并不运行在UI线程当中，主要用于异步操作，所有在该方法中不能对UI当中的空间进行设置和修改
     * 但是可以调用publishProgress方法触发onProgressUpdate对UI进行操作
     */
    @Override
    protected String doInBackground(Integer... params) {
        //操作
        int i = 0;
        for (i = 0; i < params[0]; i++) {
            operate();
            //执行publishProgress()调用onProgressUpdate()方法
            publishProgress(i);
        }
        return "end";
    }

    /**
     * 运行在UI线程中，在调用doInBackground()之前执行
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mTextView.setText("加载中....");
        DebugLog.i("onPreExecute()");
    }

    /**
     * 这里的String参数对应AsyncTask中的第三个参数（也就是接收doInBackground的返回值）
     * 在doInBackground方法执行结束之后在运行，并且运行在UI线程当中 可以对UI空间进行设置
     */
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        DebugLog.i("onPostExecute()");
        //返回的结果
        mTextView.setText(s);
    }

    /**
     * 这里的Intege参数对应AsyncTask中的第二个参数
     * 在doInBackground方法当中，，每次调用publishProgress方法都会触发onProgressUpdate执行
     * onProgressUpdate是在UI线程中执行，所有可以对UI空间进行操作
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        //设置进度条的进度
        DebugLog.i("" + values[0]);
        mProgressBar.setProgress(values[0] + 1);
        mTextView.setText((values[0] + 1) + "%");
    }

    /**
     * 休眠100m
     */
    public void operate() {
        Thread th = new Thread();
        try {
            th.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
