package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.amap.api.col.p0003l.e2;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.i4;
import com.amap.api.col.p0003l.n4;
import com.amap.api.col.p0003l.r6;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.h;
import com.stub.StubApp;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapLocationClient {

    /* renamed from: a, reason: collision with root package name */
    Context f8846a;

    /* renamed from: b, reason: collision with root package name */
    e2 f8847b;

    public AMapLocationClient(Context context) throws Exception {
        a(context);
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8846a = origApplicationContext;
            d.a(origApplicationContext);
            this.f8847b = new e2(context, null, null);
        } catch (Throwable th) {
            b.a(th, "AMClt", "ne1");
        }
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.f8848a = str;
        } catch (Throwable th) {
            b.a(th, "AMClt", "sKey");
        }
    }

    public void disableBackgroundLocation(boolean z5) {
        try {
            e2 e2Var = this.f8847b;
            if (e2Var != null) {
                e2Var.B(z5);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "dBackL");
        }
    }

    public void enableBackgroundLocation(int i6, Notification notification) {
        try {
            e2 e2Var = this.f8847b;
            if (e2Var != null) {
                e2Var.e(i6, notification);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "eBackL");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            e2 e2Var = this.f8847b;
            if (e2Var != null) {
                return e2Var.c0();
            }
            return null;
        } catch (Throwable th) {
            b.a(th, "AMClt", "gLastL");
            return null;
        }
    }

    public String getVersion() {
        return "6.4.3";
    }

    public boolean isStarted() {
        try {
            e2 e2Var = this.f8847b;
            if (e2Var != null) {
                return e2Var.C();
            }
            return false;
        } catch (Throwable th) {
            b.a(th, "AMClt", "isS");
            return false;
        }
    }

    public void onDestroy() {
        try {
            e2 e2Var = this.f8847b;
            if (e2Var != null) {
                e2Var.W();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "onDy");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            if (aMapLocationListener == null) {
                throw new IllegalArgumentException("listener参数不能为null");
            }
            e2 e2Var = this.f8847b;
            if (e2Var != null) {
                e2Var.x(aMapLocationListener);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "sLocL");
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (aMapLocationClientOption == null) {
                throw new IllegalArgumentException("LocationManagerOption参数不能为null");
            }
            e2 e2Var = this.f8847b;
            if (e2Var != null) {
                e2Var.w(aMapLocationClientOption);
            }
            if (aMapLocationClientOption.f8854b) {
                aMapLocationClientOption.f8854b = false;
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(aMapLocationClientOption.f8855c)) {
                    jSONObject.put("amap_loc_scenes_type", aMapLocationClientOption.f8855c);
                }
                h.a(this.f8846a, "O019", jSONObject);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "sLocnO");
        }
    }

    public void startAssistantLocation(WebView webView) {
        try {
            e2 e2Var = this.f8847b;
            if (e2Var != null) {
                e2Var.m(webView);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "sttAssL1");
        }
    }

    public void startLocation() {
        try {
            e2 e2Var = this.f8847b;
            if (e2Var != null) {
                e2Var.G();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "stl");
        }
    }

    public void stopAssistantLocation() {
        try {
            e2 e2Var = this.f8847b;
            if (e2Var != null) {
                e2Var.f0();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "stAssL");
        }
    }

    public void stopLocation() {
        try {
            e2 e2Var = this.f8847b;
            if (e2Var != null) {
                e2Var.R();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "stl");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            e2 e2Var = this.f8847b;
            if (e2Var != null) {
                e2Var.N(aMapLocationListener);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "unRL");
        }
    }

    private static void a(Context context) throws Exception {
        n4 a6 = ft.a(context, b.c());
        if (a6.f6803a == ft.c.SuccessCode) {
        } else {
            throw new Exception(a6.f6804b);
        }
    }

    public static String getDeviceId(Context context) {
        return i4.a0(context);
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            r6.f7183a = -1;
            r6.f7184b = "";
        } else {
            r6.f7183a = 1;
            r6.f7184b = str;
        }
    }

    public static void updatePrivacyAgree(Context context, boolean z5) {
        ft.i(context, z5, b.c());
    }

    public static void updatePrivacyShow(Context context, boolean z5, boolean z6) {
        ft.j(context, z5, z6, b.c());
    }

    public AMapLocationClient(Context context, Intent intent) throws Exception {
        a(context);
        try {
            if (context != null) {
                this.f8846a = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f8847b = new e2(this.f8846a, intent, null);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            b.a(th, "AMClt", "ne2");
        }
    }

    public AMapLocationClient(Looper looper, Context context) throws Exception {
        a(context);
        try {
            if (context != null) {
                this.f8846a = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f8847b = new e2(this.f8846a, null, looper);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            b.a(th, "AMClt", "ne3");
        }
    }
}
