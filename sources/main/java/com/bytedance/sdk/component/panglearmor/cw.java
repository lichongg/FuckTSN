package com.bytedance.sdk.component.panglearmor;

import android.app.Activity;
import android.app.Application;
import android.util.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static volatile cw f26683j;
    private final ArrayList<String> xt = new ArrayList<>();
    private final AtomicBoolean cw = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private long f26686r = System.currentTimeMillis();
    private long up = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f26685m = 0;
    private String ae = "";
    private String tl = "";

    /* renamed from: g, reason: collision with root package name */
    private String f26684g = "";
    private boolean oq = false;
    private boolean qv = false;

    public static cw j(Application application) {
        if (f26683j == null) {
            synchronized (cw.class) {
                try {
                    if (f26683j == null) {
                        cw cwVar = new cw();
                        f26683j = cwVar;
                        cwVar.oq = oq.j(application);
                        f26683j.qv = oq.j(StubApp.getOrigApplicationContext(application.getApplicationContext()), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                        f26683j.j();
                    }
                } finally {
                }
            }
        }
        return f26683j;
    }

    public void xt(@ForbidWrapParam Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.xt.contains(localClassName)) {
            this.xt.remove(localClassName);
        }
        if (this.xt.size() == 0) {
            this.f26686r = System.currentTimeMillis();
            this.cw.set(true);
            this.tl = localClassName;
        }
    }

    public void j(@ForbidWrapParam Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.xt.size() == 0) {
            this.ae = localClassName;
            this.up = System.currentTimeMillis();
            this.f26685m = System.currentTimeMillis() - this.f26686r;
            this.cw.set(false);
        }
        if (!this.xt.contains(localClassName)) {
            this.xt.add(localClassName);
        }
        this.f26684g = localClassName;
    }

    private void j() {
        int size;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", null);
            boolean z5 = true;
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(invoke);
            if (arrayMap != null && (size = arrayMap.size()) > 0) {
                Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                Field declaredField2 = cls2.getDeclaredField("stopped");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                declaredField3.setAccessible(true);
                for (int i6 = 0; i6 < size; i6++) {
                    Object valueAt = arrayMap.valueAt(i6);
                    if (!((Boolean) declaredField2.get(valueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(valueAt)).getLocalClassName();
                        if (!this.xt.contains(localClassName)) {
                            this.xt.add(localClassName);
                        }
                    }
                }
                AtomicBoolean atomicBoolean = this.cw;
                if (this.xt.size() > 0) {
                    z5 = false;
                }
                atomicBoolean.set(z5);
            }
        } catch (Exception unused) {
        }
    }

    public String j(String str, long j6, int i6, boolean z5) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        long j7 = currentTimeMillis - this.up;
        long j8 = currentTimeMillis - j6;
        int i7 = j8 < 500 ? 1 : 0;
        if (this.cw.get() && this.qv) {
            i7 |= 2;
        }
        if (!this.cw.get() && this.f26685m >= 5000 && j7 < 1000) {
            i7 = this.tl.equals(this.f26684g) ? i7 | 4 : i7 | 8;
        }
        try {
            str2 = new JSONObject().put("rst", i7).put("bakdur", this.f26685m).put("popt", j7).put("uct", j8).put("isbak", this.cw).put("alert", this.qv).put("rit", i6).put(CommonNetImpl.TAG, str).put(NotificationCompat.CATEGORY_SYSTEM, this.oq).put("size", this.xt.size()).put("mutipro", z5).toString();
        } catch (JSONException unused) {
            str2 = "";
        }
        this.ae = "";
        this.f26685m = 0L;
        this.up = 0L;
        this.f26686r = System.currentTimeMillis();
        return str2;
    }
}
