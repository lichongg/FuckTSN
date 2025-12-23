package com.amap.api.col.p0003l;

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
public final class i5 {

    /* renamed from: e, reason: collision with root package name */
    public static final String f6499e = q4.u("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");

    /* renamed from: f, reason: collision with root package name */
    private static i5 f6500f;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f6501a;

    /* renamed from: b, reason: collision with root package name */
    private String f6502b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f6503c;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f6504d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6505a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6506b;

        a(String str, int i6) {
            this.f6505a = str;
            this.f6506b = i6;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            boolean canWrite;
            String h6 = o5.h(this.f6505a);
            if (TextUtils.isEmpty(h6)) {
                return;
            }
            if ((this.f6506b & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        canWrite = Settings.System.canWrite(i5.this.f6503c);
                        if (canWrite) {
                            Settings.System.putString(i5.this.f6503c.getContentResolver(), i5.this.f6502b, h6);
                        }
                    } else {
                        Settings.System.putString(i5.this.f6503c.getContentResolver(), i5.this.f6502b, h6);
                    }
                } catch (Exception unused) {
                }
            }
            if ((this.f6506b & 16) > 0) {
                k5.b(i5.this.f6503c, i5.this.f6502b, h6);
            }
            if ((this.f6506b & 256) > 0) {
                SharedPreferences.Editor edit = i5.this.f6503c.getSharedPreferences(i5.f6499e, 0).edit();
                edit.putString(i5.this.f6502b, h6);
                edit.apply();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<i5> f6508a;

        b(i5 i5Var) {
            this.f6508a = new WeakReference<>(i5Var);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            i5 i5Var = this.f6508a.get();
            if (i5Var == null || message == null || (obj = message.obj) == null) {
                return;
            }
            i5Var.e((String) obj, message.what);
        }

        b(Looper looper, i5 i5Var) {
            super(looper);
            this.f6508a = new WeakReference<>(i5Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(String str, int i6) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new a(str, i6).start();
            return;
        }
        String h6 = o5.h(str);
        if (!TextUtils.isEmpty(h6)) {
            if ((i6 & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        Settings.System.putString(this.f6503c.getContentResolver(), this.f6502b, h6);
                    } else {
                        Settings.System.putString(this.f6503c.getContentResolver(), this.f6502b, h6);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i6 & 16) > 0) {
                k5.b(this.f6503c, this.f6502b, h6);
            }
            if ((i6 & 256) > 0) {
                SharedPreferences.Editor edit = this.f6503c.getSharedPreferences(f6499e, 0).edit();
                edit.putString(this.f6502b, h6);
                edit.apply();
            }
        }
    }

    public static i5 b(Context context) {
        if (f6500f == null) {
            synchronized (i5.class) {
                try {
                    if (f6500f == null) {
                        f6500f = new i5(context);
                    }
                } finally {
                }
            }
        }
        return f6500f;
    }

    public final void d(String str) {
        this.f6502b = str;
    }

    public final void g(String str) {
        List<String> list = this.f6501a;
        if (list != null) {
            list.clear();
            this.f6501a.add(str);
        }
        e(str, 273);
    }

    private i5(Context context) {
        this.f6503c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (Looper.myLooper() == null) {
            this.f6504d = new b(Looper.getMainLooper(), this);
        } else {
            this.f6504d = new b(this);
        }
    }
}
