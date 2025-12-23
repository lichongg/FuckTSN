package com.baidu.liantian.rp;

import android.content.Context;
import android.os.Message;
import com.baidu.liantian.b;
import com.baidu.liantian.b.e;
import com.baidu.liantian.b.f;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Report {

    /* renamed from: a, reason: collision with root package name */
    private static Report f10467a;

    /* renamed from: b, reason: collision with root package name */
    private Context f10468b;

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            try {
                if (f10467a == null) {
                    f10467a = new Report(context);
                }
                report = f10467a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return report;
    }

    public void fr() {
        try {
            f a6 = f.a(this.f10468b);
            Message message = new Message();
            message.what = 9;
            a6.f10354a.a(message);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            e.a(this.f10468b, str, str2, str3, str4, str5);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public void n() {
        try {
            f a6 = f.a(this.f10468b);
            Message message = new Message();
            message.what = 6;
            a6.f10354a.a(message);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public void r(boolean z5) {
        try {
            f.a(this.f10468b).a();
        } catch (Throwable unused) {
            e.a();
        }
    }

    public void w(String str) {
        try {
            e.d(this.f10468b, str);
        } catch (Throwable unused) {
            e.a();
        }
    }

    private Report(Context context) {
        this.f10468b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public void s(String str) {
        try {
            b.a();
            e.c(this.f10468b, str);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public void sr(String str) {
        try {
            b.a();
            f a6 = f.a(this.f10468b);
            Message message = new Message();
            message.what = 11;
            message.obj = str;
            a6.f10354a.a(message);
        } catch (Throwable unused) {
            e.a();
        }
    }
}
