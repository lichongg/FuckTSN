package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class y {

    /* renamed from: c, reason: collision with root package name */
    private static volatile y f41469c;

    /* renamed from: a, reason: collision with root package name */
    private w f41470a = new x();

    /* renamed from: b, reason: collision with root package name */
    private String f41471b;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f41472d;

    /* renamed from: e, reason: collision with root package name */
    private String f41473e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(String str, long j6, long j7, long j8);

        void a(String str, String str2, long j6, long j7, long j8);
    }

    public static y a() {
        if (f41469c == null) {
            synchronized (y.class) {
                try {
                    if (f41469c == null) {
                        f41469c = new y();
                    }
                } finally {
                }
            }
        }
        return f41469c;
    }

    public long b() {
        return this.f41470a.a();
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.f41471b) && i.a(context).a(this.f41471b) > 0;
    }

    private long h(Context context) {
        return a(context, u.f41453f);
    }

    private long i(Context context) {
        return a(context, u.f41448a);
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f41471b = d(appContext);
        if (e(appContext)) {
            try {
                this.f41471b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f41471b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f41471b)) {
            try {
                this.f41471b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f41471b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f41471b)) {
            this.f41471b = d(context);
        }
        return TextUtils.isEmpty(this.f41471b) || j(context) || g(context);
    }

    private y() {
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(u.f41451d, d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long h6 = h(context);
        long i6 = i(context);
        String str = this.f41471b;
        long a6 = u.a(context);
        long j6 = a6 * 5000;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + a6);
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
            if (UMWorkDispatch.eventHasExist()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
                UMWorkDispatch.removeEvent();
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
            }
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        }
        a(i6, h6, j6, str, false);
        this.f41471b = this.f41470a.a(context);
        a(i6, h6, j6, str, true);
        this.f41470a.a(context, this.f41471b);
        return this.f41471b;
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j6 = sharedPreferences.getLong(u.f41452e, 0L);
            long j7 = sharedPreferences.getLong(u.f41453f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && j6 > 0 && j7 == 0) {
                long a6 = u.a(appContext);
                if (a6 > 0) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j7 = j6 + (a6 * 5000);
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j7 - j6));
            return this.f41470a.a(j6, j7);
        } catch (Exception unused) {
            return false;
        }
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f41471b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f41471b;
    }

    public void a(long j6) {
        this.f41470a.a(j6);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (y.class) {
                str = PreferenceWrapper.getDefault(appContext).getString(u.f41451d, "");
            }
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f41472d) == null || list.size() == 0) {
            return;
        }
        this.f41472d.remove(aVar);
    }

    public String a(Context context, long j6) {
        if (TextUtils.isEmpty(this.f41473e)) {
            String str = "SUB" + j6;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.f41473e = sb.toString();
        }
        return this.f41473e;
    }

    private long a(Context context, String str) {
        long j6;
        try {
            j6 = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j6 = 0;
        }
        return j6 <= 0 ? System.currentTimeMillis() : j6;
    }

    private void a(long j6, long j7, long j8, String str, boolean z5) {
        List<a> list = this.f41472d;
        if (list != null) {
            for (a aVar : list) {
                if (z5) {
                    try {
                        aVar.a(str, this.f41471b, j6, j7, j8);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.f41471b, j6, j7, j8);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f41472d == null) {
            this.f41472d = new ArrayList();
        }
        if (this.f41472d.contains(aVar)) {
            return;
        }
        this.f41472d.add(aVar);
    }
}
