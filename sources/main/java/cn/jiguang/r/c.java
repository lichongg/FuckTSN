package cn.jiguang.r;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import cn.jiguang.bz.s;
import cn.jpush.android.api.JPushInterface;
import com.amap.api.services.core.AMapException;
import com.umeng.analytics.pro.bi;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f3209a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f3210b;

    /* renamed from: cn.jiguang.r.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f3211a = new c(null);
    }

    private c() {
    }

    public static c a() {
        return a.f3211a;
    }

    /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3209a = context;
        return "JDeviceBattery";
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        if (cn.jiguang.g.a.a().g(AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS)) {
            return;
        }
        try {
            Intent a6 = s.a(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, null, false);
            if (a6 == null) {
                return;
            }
            int intExtra = a6.getIntExtra("level", -1);
            int intExtra2 = a6.getIntExtra("scale", -1);
            int intExtra3 = a6.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            if (intExtra3 == 1) {
                intExtra3 = 0;
            } else if (intExtra3 == 2) {
                intExtra3 = 2;
            } else if (intExtra3 == 3 || intExtra3 == 4) {
                intExtra3 = 1;
            } else if (intExtra3 == 5) {
                intExtra3 = 3;
            }
            int intExtra4 = a6.getIntExtra("voltage", -1);
            int intExtra5 = a6.getIntExtra("temperature", -1);
            if (this.f3210b == null) {
                this.f3210b = new JSONObject();
            }
            this.f3210b.put("level", intExtra);
            this.f3210b.put("scale", intExtra2);
            this.f3210b.put(NotificationCompat.CATEGORY_STATUS, intExtra3);
            this.f3210b.put("voltage", intExtra4);
            this.f3210b.put("temperature", intExtra5);
            cn.jiguang.bb.f.c("JDeviceBattery", "collect success:" + this.f3210b);
            super.c(context, str);
        } catch (JSONException e6) {
            cn.jiguang.bb.f.i("JDeviceBattery", "packageJson exception: " + e6.getMessage());
        }
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        if (cn.jiguang.g.a.a().g(AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS)) {
            return;
        }
        JSONObject jSONObject = this.f3210b;
        if (jSONObject == null) {
            cn.jiguang.bb.f.i("JDeviceBattery", "there are no data to report");
            return;
        }
        cn.jiguang.be.b.a(context, jSONObject, bi.Z);
        super.d(context, str);
        this.f3210b = null;
    }
}
