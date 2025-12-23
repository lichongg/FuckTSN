package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class t implements ICommonModuleObj {

    /* renamed from: a, reason: collision with root package name */
    private static volatile t f11098a;

    /* renamed from: b, reason: collision with root package name */
    private CustomNotification f11099b = new CustomNotification();

    /* renamed from: c, reason: collision with root package name */
    private com.baidu.mobads.sdk.internal.b.a f11100c = new com.baidu.mobads.sdk.internal.b.a();

    public static t a() {
        if (f11098a == null) {
            synchronized (t.class) {
                try {
                    if (f11098a == null) {
                        f11098a = new t();
                    }
                } finally {
                }
            }
        }
        return f11098a;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        if (!ICommonModuleObj.KEY_NOTIFICATION.equals(str)) {
            if (ICommonModuleObj.KEY_RESOURCES.equals(str)) {
                return this.f11100c;
            }
            return null;
        }
        if (jSONObject == null) {
            return null;
        }
        Context context = (Context) jSONObject.opt(com.umeng.analytics.pro.d.X);
        int optInt = jSONObject.optInt("version", 0);
        String optString = jSONObject.optString(URLPackage.KEY_CHANNEL_ID);
        String optString2 = jSONObject.optString("ticker");
        Bitmap bitmap = (Bitmap) jSONObject.opt("icon");
        String optString3 = jSONObject.optString("title");
        String optString4 = jSONObject.optString("content");
        String optString5 = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
        boolean optBoolean = jSONObject.optBoolean("autoCancel");
        int optInt2 = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
        boolean optBoolean2 = jSONObject.optBoolean("indeterminate", false);
        int optInt3 = jSONObject.optInt("smallIcon");
        String optString6 = jSONObject.optString(com.umeng.ccg.a.f41544t);
        PendingIntent pendingIntent = (PendingIntent) jSONObject.opt(BaseGmsClient.KEY_PENDING_INTENT);
        return optInt == 1 ? this.f11099b.getNewNotification(context, optString2, optBoolean, bitmap, optString3, optString4, optInt2, optBoolean2, optString6, pendingIntent, jSONObject.optString("action2"), (PendingIntent) jSONObject.opt("pendingIntent2")) : this.f11099b.getCustomNotification(context, optString, optString2, bitmap, optString3, optString4, optString5, optBoolean, optInt2, optInt3, optString6, pendingIntent);
    }

    private t() {
    }
}
