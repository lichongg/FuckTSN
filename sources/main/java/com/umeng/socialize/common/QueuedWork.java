package com.umeng.socialize.common;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.umeng.socialize.utils.SocializeUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QueuedWork {
    public static boolean isUseThreadPool;
    private static ExecutorService mLogicExecutor = Executors.newFixedThreadPool(5);
    private static ExecutorService mNetExecutor = Executors.newFixedThreadPool(5);
    private static Handler uiHandler;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class UMAsyncTask<Result> {
        protected Runnable thread;

        protected abstract Result doInBackground();

        public final UMAsyncTask<Result> execute() {
            this.thread = new Runnable() { // from class: com.umeng.socialize.common.QueuedWork.UMAsyncTask.1
                @Override // java.lang.Runnable
                public void run() {
                    final Object doInBackground = UMAsyncTask.this.doInBackground();
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.common.QueuedWork.UMAsyncTask.1.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            UMAsyncTask.this.onPostExecute(doInBackground);
                        }
                    });
                }
            };
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.common.QueuedWork.UMAsyncTask.2
                @Override // java.lang.Runnable
                public void run() {
                    UMAsyncTask.this.onPreExecute();
                }
            });
            QueuedWork.runInBack(this.thread, false);
            return this;
        }

        protected void onPreExecute() {
        }

        protected void onPostExecute(Result result) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class DialogThread<T> extends UMAsyncTask {
        Dialog dialog = null;

        public DialogThread(Context context) {
        }

        @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
        protected void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            SocializeUtils.safeCloseDialog(this.dialog);
        }

        @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            SocializeUtils.safeShowDialog(this.dialog);
        }
    }

    public static void runInBack(Runnable runnable, boolean z5) {
        if (!isUseThreadPool) {
            new Thread(runnable).start();
        } else if (z5) {
            mNetExecutor.execute(runnable);
        } else {
            mLogicExecutor.execute(runnable);
        }
    }

    public static void runInMain(Runnable runnable) {
        if (uiHandler == null) {
            uiHandler = new Handler(Looper.getMainLooper());
        }
        uiHandler.post(runnable);
    }
}
