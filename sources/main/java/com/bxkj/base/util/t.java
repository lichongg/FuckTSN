package com.bxkj.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class t {

    /* renamed from: b, reason: collision with root package name */
    public static t f16639b;

    /* renamed from: a, reason: collision with root package name */
    private a f16640a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();

        void b();
    }

    public static t a() {
        if (f16639b == null) {
            synchronized (t.class) {
                try {
                    if (f16639b == null) {
                        f16639b = new t();
                    }
                } finally {
                }
            }
        }
        return f16639b;
    }

    public void b(Activity activity, int i6) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, activity.getPackageName(), null));
        activity.startActivityForResult(intent, i6);
    }

    public void e(a aVar) {
        this.f16640a = this.f16640a;
    }

    @RequiresApi(api = 19)
    public boolean c(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    @RequiresApi(api = 19)
    public void d(Context context, a aVar) {
        if (!c(context)) {
            if (aVar != null) {
                aVar.b();
            }
        } else if (aVar != null) {
            aVar.a();
        }
    }
}
