package com.bytedance.sdk.openadsdk.core.multipro.cw;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.multipro.up;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.wq.j.r;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements r.j {

    /* renamed from: j, reason: collision with root package name */
    private Context f29574j;

    public static boolean cw(String str) {
        if (v.getContext() == null) {
            return false;
        }
        try {
            ContentResolver up = up();
            if (up != null) {
                return "true".equals(up.getType(Uri.parse(m() + str)));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean j(String str) {
        return j(str, "checkFrequency");
    }

    public static String r() {
        return r("maxAggRit");
    }

    public static boolean xt(String str) {
        return j(str, "checkAggFrequency");
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Context getContext() {
        Context context = this.f29574j;
        return context == null ? v.getContext() : context;
    }

    public static boolean j(String str, String str2) {
        if (v.getContext() == null) {
            return false;
        }
        try {
            ContentResolver up = up();
            if (up != null) {
                return "true".equals(up.getType(Uri.parse(m() + str2 + "?rit=" + String.valueOf(str))));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static String m() {
        return up.xt + "/t_frequent/";
    }

    public static String r(String str) {
        if (v.getContext() == null) {
            return null;
        }
        try {
            ContentResolver up = up();
            if (up != null) {
                return up.getType(Uri.parse(m() + str));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean xt() {
        return cw("isAggSilent");
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getTableName() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void injectContext(Context context) {
        this.f29574j = context;
    }

    private static ContentResolver up() {
        try {
            if (v.getContext() != null) {
                return v.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public String getType(Uri uri) {
        String str = uri.getPath().split("/")[2];
        if ("checkFrequency".equals(str)) {
            if (!com.bytedance.sdk.openadsdk.core.ws.up.j().j(uri.getQueryParameter("rit"))) {
                return "false";
            }
            return "true";
        }
        if ("isSilent".equals(str)) {
            if (!com.bytedance.sdk.openadsdk.core.ws.up.j().r()) {
                return "false";
            }
            return "true";
        }
        if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.ws.up.j().up();
        }
        if ("checkAggFrequency".equals(str)) {
            if (!com.bytedance.sdk.openadsdk.core.ws.j.j().j(uri.getQueryParameter("rit"))) {
                return "false";
            }
            return "true";
        }
        if ("isAggSilent".equals(str)) {
            if (!com.bytedance.sdk.openadsdk.core.ws.j.j().r()) {
                return "false";
            }
            return "true";
        }
        if ("maxAggRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.ws.j.j().up();
        }
        return null;
    }

    public static String cw() {
        return r("maxRit");
    }

    public static boolean j() {
        return cw("isSilent");
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.r.j
    public void init() {
    }
}
