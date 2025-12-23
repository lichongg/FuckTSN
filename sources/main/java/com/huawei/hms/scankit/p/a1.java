package com.huawei.hms.scankit.p;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class a1 {

    /* renamed from: c, reason: collision with root package name */
    private static final String f33970c = "a1";

    /* renamed from: a, reason: collision with root package name */
    private String f33971a = "UNKNOWN";

    /* renamed from: b, reason: collision with root package name */
    private String f33972b;

    public String a() {
        return this.f33972b;
    }

    private void a(Context context, boolean z5) {
        if (context != null) {
            try {
                this.f33972b = GrsApp.getInstance().getIssueCountryCode(context);
                if (b()) {
                    Logger.i(f33970c, "getCountryCode unknown");
                }
            } catch (NullPointerException unused) {
                Logger.w(f33970c, "get CountryCode error");
            } catch (Exception unused2) {
                Logger.w(f33970c, "get CountryCode error");
            }
        }
    }

    private boolean b() {
        return !"UNKNOWN".equals(this.f33972b);
    }

    public a1(Context context, boolean z5) {
        this.f33972b = "UNKNOWN";
        a(context, z5);
        this.f33972b = this.f33972b.toUpperCase(Locale.ENGLISH);
    }
}
