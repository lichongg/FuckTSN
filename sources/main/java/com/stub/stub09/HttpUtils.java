package com.stub.stub09;

import android.content.Context;
import com.stub.StubApp;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TYVMProtect
/* loaded from: D:\Downloads\app\classes10.dex */
public class HttpUtils {
    public static final int CACHE_CODE = 3;
    public static final int ERROR_CODE = 1;
    public static final int NO_UPDATE_CODE = 2;
    public static final int SUCCESS_CODE = 0;
    static ExecutorService cachedThreadPool;

    public interface DownloadListener {
        void onFail();

        void onSuccess(String str);
    }

    static {
        StubApp.interface11(56937);
        cachedThreadPool = Executors.newCachedThreadPool();
    }

    public static native void checkUpdate(Context context, DownloadListener downloadListener);

    private static native void downloadSo(String str, String str2, DownloadListener downloadListener, File file);

    public static native String getCurrentAbi(Context context);

    public static native String post_request(String str);

    public static native void request_update(Context context, DownloadListener downloadListener);

    /* renamed from: com.stub.stub09.HttpUtils$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ DownloadListener val$listener;

        AnonymousClass1(Context context, DownloadListener downloadListener) {
            this.val$context = context;
            this.val$listener = downloadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpUtils.request_update(this.val$context, this.val$listener);
        }
    }

    /* renamed from: com.stub.stub09.HttpUtils$2, reason: invalid class name */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ DownloadListener val$listener;

        AnonymousClass2(Context context, DownloadListener downloadListener) {
            this.val$context = context;
            this.val$listener = downloadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpUtils.request_update(this.val$context, this.val$listener);
        }
    }
}
