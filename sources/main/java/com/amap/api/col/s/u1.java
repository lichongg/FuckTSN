package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class u1 {

    /* renamed from: e, reason: collision with root package name */
    public static final String f8497e = j1.t("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");

    /* renamed from: f, reason: collision with root package name */
    private static u1 f8498f;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f8499a;

    /* renamed from: b, reason: collision with root package name */
    private String f8500b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f8501c;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f8502d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8503a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8504b;

        a(String str, int i6) {
            this.f8503a = str;
            this.f8504b = i6;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            boolean canWrite;
            String h6 = a2.h(this.f8503a);
            if (TextUtils.isEmpty(h6)) {
                return;
            }
            if ((this.f8504b & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        canWrite = Settings.System.canWrite(u1.this.f8501c);
                        if (canWrite) {
                            Settings.System.putString(u1.this.f8501c.getContentResolver(), u1.this.f8500b, h6);
                        }
                    } else {
                        Settings.System.putString(u1.this.f8501c.getContentResolver(), u1.this.f8500b, h6);
                    }
                } catch (Exception unused) {
                }
            }
            if ((this.f8504b & 16) > 0) {
                w1.b(u1.this.f8501c, u1.this.f8500b, h6);
            }
            if ((this.f8504b & 256) > 0) {
                SharedPreferences.Editor edit = u1.this.f8501c.getSharedPreferences(u1.f8497e, 0).edit();
                edit.putString(u1.this.f8500b, h6);
                edit.apply();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<u1> f8506a;

        b(u1 u1Var) {
            this.f8506a = new WeakReference<>(u1Var);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            u1 u1Var = this.f8506a.get();
            if (u1Var == null || message == null || (obj = message.obj) == null) {
                return;
            }
            u1Var.e((String) obj, message.what);
        }

        b(Looper looper, u1 u1Var) {
            super(looper);
            this.f8506a = new WeakReference<>(u1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(String str, int i6) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new a(str, i6).start();
            return;
        }
        String h6 = a2.h(str);
        if (!TextUtils.isEmpty(h6)) {
            if ((i6 & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        Settings.System.putString(this.f8501c.getContentResolver(), this.f8500b, h6);
                    } else {
                        Settings.System.putString(this.f8501c.getContentResolver(), this.f8500b, h6);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i6 & 16) > 0) {
                w1.b(this.f8501c, this.f8500b, h6);
            }
            if ((i6 & 256) > 0) {
                SharedPreferences.Editor edit = this.f8501c.getSharedPreferences(f8497e, 0).edit();
                edit.putString(this.f8500b, h6);
                edit.apply();
            }
        }
    }

    public static u1 b(Context context) {
        if (f8498f == null) {
            synchronized (u1.class) {
                try {
                    if (f8498f == null) {
                        f8498f = new u1(context);
                    }
                } finally {
                }
            }
        }
        return f8498f;
    }

    public final void d(String str) {
        this.f8500b = str;
    }

    public final void g(String str) {
        List<String> list = this.f8499a;
        if (list != null) {
            list.clear();
            this.f8499a.add(str);
        }
        e(str, 273);
    }

    private u1(Context context) {
        this.f8501c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (Looper.myLooper() == null) {
            this.f8502d = new b(Looper.getMainLooper(), this);
        } else {
            this.f8502d = new b(this);
        }
    }
}
