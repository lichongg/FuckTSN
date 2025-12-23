package com.huawei.secure.android.common.ssl.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f extends AsyncTask<Context, Integer, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35234a = "f";

    /* renamed from: b, reason: collision with root package name */
    private static final long f35235b = 432000000;

    /* renamed from: c, reason: collision with root package name */
    private static final String f35236c = "lastCheckTime";

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f35237d;

    private static boolean e() {
        if (f35237d) {
            return false;
        }
        Context a6 = c.a();
        if (a6 == null) {
            h.g(f35234a, "checkUpgradeBks, context is null");
            return false;
        }
        f35237d = true;
        long b6 = j.b(f35236c, 0L, a6);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b6 > f35235b) {
            j.h(f35236c, currentTimeMillis, a6);
            return true;
        }
        h.e(f35234a, "checkUpgradeBks, ignore");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        h.e(f35234a, "onProgressUpdate");
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        h.b(f35234a, "onPreExecute");
    }

    @SuppressLint({"NewApi"})
    public static void b() {
        if (e()) {
            h.e(f35234a, "checkUpgradeBks, execute check task");
            new f().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, c.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = a.n(contextArr[0]);
        } catch (Exception e6) {
            h.d(f35234a, "doInBackground: exception : " + e6.getMessage());
            inputStream = null;
        }
        h.b(f35234a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream != null) {
            g.g(inputStream);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            h.e(f35234a, "onPostExecute: upate done");
        } else {
            h.d(f35234a, "onPostExecute: upate failed");
        }
    }
}
