package cn.jiguang.bw;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import cn.jiguang.bb.f;
import cn.jiguang.bz.d;
import cn.jiguang.bz.w;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.kuaishou.weapon.p0.t;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static String f2623c = "SubSDKAPiManager";

    /* renamed from: d, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Object> f2624d = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private Context f2625a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f2626b;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f2634a = new b();
    }

    private b() {
        Context a6 = d.a();
        this.f2625a = a6;
        this.f2626b = ((Boolean) cn.jiguang.e.b.a(a6, cn.jiguang.e.a.A())).booleanValue();
    }

    public static b a() {
        return a.f2634a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0024, code lost:
    
        if ("init".equals(r22) != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c(java.lang.String r20, int r21, java.lang.String r22, android.os.Bundle r23, java.lang.Object... r24) {
        /*
            Method dump skipped, instructions count: 1992
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bw.b.c(java.lang.String, int, java.lang.String, android.os.Bundle, java.lang.Object[]):java.lang.String");
    }

    public void b() {
        try {
            Boolean bool = (Boolean) cn.jiguang.e.b.a(this.f2625a, cn.jiguang.e.a.N());
            f.c(f2623c, "send mHadReport=" + this.f2626b);
            f.c(f2623c, "send SubApiSwitch=" + bool);
            if (!this.f2626b && bool.booleanValue()) {
                if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                    c();
                } else {
                    cn.jiguang.be.b.a(new Runnable() { // from class: cn.jiguang.bw.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.c();
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
    }

    private String a(String str) {
        return "init".equals(str) ? "0" : "setSmartPushEnable".equals(str) ? "1" : "setLinkMergeEnable".equals(str) ? "2" : "setGeofenceEnable".equals(str) ? "3" : "setCollectControl".equals(str) ? "4" : "setNotificationCallBackEnable".equals(str) ? "5" : "resumePush".equals(str) ? "6" : "stopPush".equals(str) ? "7" : "isPushStopped".equals(str) ? "8" : "setChannel".equals(str) ? "9" : "setPushTime".equals(str) ? Constants.VIA_REPORT_TYPE_SHARE_TO_QQ : "setSilenceTime".equals(str) ? Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE : "getRegistrationID".equals(str) ? Constants.VIA_REPORT_TYPE_SET_AVATAR : "JPushActivityLifeCallBack".equals(str) ? Constants.VIA_REPORT_TYPE_JOININ_GROUP : "getUdid".equals(str) ? Constants.VIA_REPORT_TYPE_MAKE_FRIEND : "JCoreInterface.setWakeEnable".equals(str) ? Constants.VIA_REPORT_TYPE_WPA_STATE : "JCollectionAuth.setAuth".equals(str) ? Constants.VIA_REPORT_TYPE_START_WAP : "JCollectionAuth.enableAutoWakeup".equals(str) ? Constants.VIA_REPORT_TYPE_START_GROUP : "JCollectionAuth.enableAppTerminate".equals(str) ? "18" : "setLatestNotificationNumber".equals(str) ? Constants.VIA_ACT_TYPE_NINETEEN : "clearAllNotifications".equals(str) ? "20" : "clearNotificationById".equals(str) ? "21" : "setDefaultPushNotificationBuilder".equals(str) ? Constants.VIA_REPORT_TYPE_DATALINE : "setPushNotificationBuilder".equals(str) ? Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR : "setProperties".equals(str) ? Constants.VIA_REPORT_TYPE_CHAT_AIO : "deleteProperties".equals(str) ? Constants.VIA_REPORT_TYPE_CHAT_AUDIO : "cleanProperties".equals(str) ? Constants.VIA_REPORT_TYPE_CHAT_VIDEO : "setTags".equals(str) ? "27" : "addTags".equals(str) ? Constants.VIA_ACT_TYPE_TWENTY_EIGHT : "deleteTags".equals(str) ? "29" : "cleanTags".equals(str) ? "30" : "getAllTags".equals(str) ? "31" : "checkTagBindState".equals(str) ? "32" : "setAlias".equals(str) ? "33" : "deleteAlias".equals(str) ? "34" : "getAlias".equals(str) ? "35" : "setMobileNumber".equals(str) ? "36" : "reportNotificationOpened".equals(str) ? "37" : "reportMessageOpened".equals(str) ? "38" : "getConnectionState".equals(str) ? "39" : "onResume".equals(str) ? "40" : "onPause".equals(str) ? "41" : "onFragmentResume".equals(str) ? RoomMasterTable.DEFAULT_ID : "onFragmentPause".equals(str) ? "43" : "onKillProcess".equals(str) ? "44" : "initCrashHandler".equals(str) ? "45" : "stopCrashHandler".equals(str) ? "46" : "addLocalNotification".equals(str) ? "47" : "removeLocalNotification".equals(str) ? "48" : "clearLocalNotifications".equals(str) ? "49" : "setDefaultNotifactionNumber".equals(str) ? "50" : "setGeofenceInterval".equals(str) ? "51" : "setMaxGeofenceNumber".equals(str) ? "52" : "deleteGeofence".equals(str) ? "53" : "setBadgeNumber".equals(str) ? "54" : "isNotificationEnabled".equals(str) ? "55" : "setLbsEnable".equals(str) ? "56" : "goToAppNotificationSettings".equals(str) ? "57" : "reportWakedData".equals(str) ? "58" : "pullInAppMessageWithType".equals(str) ? "59" : "pullInAppMessageWithPosition".equals(str) ? "60" : "pullInAppMessageWithParams".equals(str) ? "61" : "pullInAppMessage".equals(str) ? "62" : "triggerInAppMsgByEvent".equals(str) ? "63" : "si".equals(str) ? "64" : "checkSupportVasMessage".equals(str) ? "65" : "setHbPeriodEnable".equals(str) ? "66" : "setThirdToken".equals(str) ? "67" : "setThirdPushEnable".equals(str) ? "68" : "setAliasAndTags_setAlias_setTags".equals(str) ? "69" : "normalExecutor".equals(str) ? "70" : "futureExecutor".equals(str) ? "71" : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i6, String str2, Bundle bundle, Object[] objArr) {
        try {
            String c6 = c(str, i6, str2, bundle, objArr);
            if (TextUtils.isEmpty(c6)) {
                return;
            }
            String arrays = Arrays.toString(objArr);
            JSONObject a6 = w.a(bundle);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(t.f36152m, c6);
            jSONObject.put(bi.aL, System.currentTimeMillis());
            int hashCode = (str + i6 + str2 + a6 + arrays).hashCode();
            if (f2624d.contains(Integer.valueOf(hashCode))) {
                return;
            }
            f2624d.put(Integer.valueOf(hashCode), jSONObject);
        } catch (Throwable th) {
            f.c(f2623c, "throwable=" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(f2624d);
            if (concurrentHashMap.isEmpty()) {
                return;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator it = concurrentHashMap.values().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            ArrayList<JSONArray> a6 = cn.jiguang.common.app.helper.b.a(jSONArray);
            if (a6 != null && !a6.isEmpty()) {
                int size = a6.size();
                int i6 = 0;
                while (i6 < size) {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray2 = a6.get(i6);
                    JSONObject jSONObject2 = new JSONObject();
                    new JSONObject().put("api", jSONArray2);
                    jSONObject2.put(JThirdPlatFormInterface.EXCEPTION_TYPE, "5");
                    jSONObject2.put(JThirdPlatFormInterface.KEY_EXTRA, jSONArray2);
                    JSONArray jSONArray3 = new JSONArray();
                    jSONArray3.put(System.currentTimeMillis());
                    jSONObject2.put("exception_time", jSONArray3);
                    jSONObject2.put("result", "0_1");
                    JSONArray jSONArray4 = new JSONArray();
                    jSONArray4.put(jSONObject2);
                    i6++;
                    jSONObject.put("slice_index", i6);
                    jSONObject.put("slice_count", size);
                    jSONObject.put("data", jSONArray4);
                    f.c(f2623c, "reportJson=" + jSONObject);
                    cn.jiguang.be.b.b(this.f2625a, jSONObject, "exception_stats");
                }
                this.f2626b = true;
                cn.jiguang.e.b.a(this.f2625a, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.A().a((cn.jiguang.e.a<Boolean>) Boolean.TRUE)});
                f.c(f2623c, "set had report=" + this.f2626b);
            }
        } catch (Throwable th) {
            f.c(f2623c, "set had throwable=" + th);
        }
    }

    public void a(final String str, final int i6, final String str2, final Bundle bundle, final Object[] objArr) {
        if (18 == i6) {
            return;
        }
        if (!JConstants.SDK_TYPE.equals(str) || 70 == i6 || 71 == i6) {
            try {
                if (cn.jiguang.bz.a.b(this.f2625a)) {
                    Boolean bool = (Boolean) cn.jiguang.e.b.a(this.f2625a, cn.jiguang.e.a.N());
                    f.c(f2623c, "save mHadReport=" + this.f2626b);
                    f.c(f2623c, "save SubApiSwitch=" + bool);
                    if (!this.f2626b && bool.booleanValue()) {
                        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                            b(str, i6, str2, bundle, objArr);
                        } else {
                            cn.jiguang.be.b.a(new Runnable() { // from class: cn.jiguang.bw.b.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.b(str, i6, str2, bundle, objArr);
                                }
                            });
                        }
                    }
                }
            } catch (Throwable th) {
                f.c(f2623c, "throwable=" + th);
            }
        }
    }
}
