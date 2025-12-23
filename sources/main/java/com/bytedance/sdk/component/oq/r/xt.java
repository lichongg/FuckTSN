package com.bytedance.sdk.component.oq.r;

import android.os.AsyncTask;
import com.bytedance.sdk.component.oq.oq;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    /* renamed from: j, reason: collision with root package name */
    public static Executor f26666j = new r(0, 20, 3, TimeUnit.MILLISECONDS, new SynchronousQueue(), new oq("PAsyncTask"));

    public AsyncTask<Params, Progress, Result> j(Params... paramsArr) {
        return executeOnExecutor(f26666j, paramsArr);
    }
}
