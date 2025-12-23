package com.huawei.hms.framework.common;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class AssetsUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33266a = "AssetsUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33267b = "AssetsUtil_Operate";

    /* renamed from: c, reason: collision with root package name */
    private static final ExecutorService f33268c = ExecutorsUtils.newSingleThreadExecutor(f33267b);

    /* renamed from: d, reason: collision with root package name */
    private static final int f33269d = 5;

    public static String[] list(final Context context, final String str) {
        if (context == null) {
            Logger.w(f33266a, "context is null");
            return new String[0];
        }
        FutureTask futureTask = new FutureTask(new Callable<String[]>() { // from class: com.huawei.hms.framework.common.AssetsUtil.1
            @Override // java.util.concurrent.Callable
            public String[] call() throws Exception {
                return context.getAssets().list(str);
            }
        });
        f33268c.execute(futureTask);
        try {
            return (String[]) futureTask.get(5L, TimeUnit.SECONDS);
        } catch (TimeoutException unused) {
            Logger.w(f33266a, "get local config files from sp task timed out");
            return new String[0];
        } catch (Exception unused2) {
            Logger.w(f33266a, "get local config files from sp task occur unknown Exception");
            return new String[0];
        } catch (InterruptedException e6) {
            Logger.w(f33266a, "get local config files from sp task interrupted", e6);
            return new String[0];
        } catch (ExecutionException e7) {
            Logger.w(f33266a, "get local config files from sp task failed", e7);
            return new String[0];
        } finally {
            futureTask.cancel(true);
        }
    }

    public static InputStream open(Context context, String str) throws IOException {
        if (context == null) {
            Logger.w(f33266a, "context is null");
            return null;
        }
        try {
            return context.getAssets().open(str);
        } catch (RuntimeException e6) {
            Logger.e(f33266a, "AssetManager has been destroyed", e6);
            return null;
        }
    }
}
