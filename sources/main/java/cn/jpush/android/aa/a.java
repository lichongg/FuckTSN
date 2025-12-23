package cn.jpush.android.aa;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ad.f;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.c;
import com.stub.StubApp;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f3338a;

    /* renamed from: b, reason: collision with root package name */
    private cn.jpush.android.aa.b f3339b;

    /* renamed from: cn.jpush.android.aa.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: cn.jpush.android.aa.a$a, reason: collision with other inner class name */
    class C0052a extends f {

        /* renamed from: b, reason: collision with root package name */
        private String f3341b;

        public C0052a(String str) {
            this.f3341b = str;
        }

        @Override // cn.jpush.android.ad.f
        public void a() {
            try {
                if (!TextUtils.isEmpty(this.f3341b)) {
                    a.this.f3339b.a(this.f3341b);
                    return;
                }
                Map<String, Integer> a6 = a.this.f3339b.a();
                if (a6 == null || a6.size() <= 0) {
                    return;
                }
                Sp.set(a.this.f3338a, Key.LastReportApiStatisticTime().set(Long.valueOf(System.currentTimeMillis())));
                if (c.a(a.this.f3338a, a6)) {
                    a.this.f3339b.b();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f3342a = new a(null);
    }

    private a() {
    }

    public static final a a() {
        return b.f3342a;
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void b() {
        long longValue = ((Long) Sp.get(this.f3338a, Key.LastReportApiStatisticTime())).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - longValue);
        if (longValue == 0 || abs >= 86400000) {
            JCoreHelper.normalExecutor(this.f3338a, null, new C0052a(""));
            return;
        }
        Logger.dd("JPushApiStatistics", "Less 24 hours since the last report so return. lastTime=" + longValue + " currentTime=" + currentTimeMillis + " diffTime=" + abs);
    }

    public void a(Context context) {
        if (this.f3338a == null || this.f3339b == null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f3338a = origApplicationContext;
            this.f3339b = new cn.jpush.android.aa.b(origApplicationContext);
        }
    }

    public void a(Context context, String str) {
        String str2;
        a(context);
        str.getClass();
        switch (str) {
            case "clear_all_notify":
                str2 = "JPushInterface#clearAllNotifications";
                break;
            case "set_mobile":
                str2 = "JPushInterface#setMobileNumber";
                break;
            case "clear_by_id":
                str2 = "JPushInterface#clearNotificationById";
                break;
            case "is_enable":
                str2 = "JPushInterface#isNotificationEnabled";
                break;
            case "clear_local_notify":
                str2 = "JPushInterface#clearLocalNotifications";
                break;
            case "geo_interval":
                str2 = "JPushInterface#setGeofenceInterval";
                break;
            case "add_local_notify":
                str2 = "JPushInterface#addLocalNotification";
                break;
            case "geo_fence_max_num":
                str2 = "JPushInterface#setMaxGeofenceNumber";
                break;
            case "delete_geo_fence":
                str2 = "JPushInterface#deleteGeofence";
                break;
            case "go_settings":
                str2 = "JPushInterface#goToAppNotificationSettings";
                break;
            case "rm_local_notify":
                str2 = "JPushInterface#removeLocalNotification";
                break;
            case "on_check":
                str2 = "JPushMessageReceiver#onNotificationSettingsCheck";
                break;
            default:
                str2 = "";
                break;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Logger.d("JPushApiStatistics", "  statistic api =" + str2);
        JCoreHelper.normalExecutor(this.f3338a, null, new C0052a(str2));
    }
}
