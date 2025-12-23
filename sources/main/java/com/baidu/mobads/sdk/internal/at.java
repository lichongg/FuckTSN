package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10639a = z.f11225o;

    /* renamed from: b, reason: collision with root package name */
    private static final String f10640b = "pauseDlByPk";

    /* renamed from: c, reason: collision with root package name */
    private static final String f10641c = "cancelDlByPk";

    /* renamed from: d, reason: collision with root package name */
    private static final String f10642d = "resumeDownload";

    /* renamed from: e, reason: collision with root package name */
    private static final String f10643e = "getDownloadStatus";

    /* renamed from: g, reason: collision with root package name */
    private static at f10644g;

    /* renamed from: f, reason: collision with root package name */
    private au f10645f;

    public static at a(Context context) {
        if (f10644g == null) {
            synchronized (at.class) {
                try {
                    if (f10644g == null) {
                        f10644g = new at(context);
                    }
                } finally {
                }
            }
        }
        return f10644g;
    }

    private at(Context context) {
        this.f10645f = au.a(context, f10639a);
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f10645f.a(null, f10641c, str);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f10645f.a(null, f10640b, str, 1);
    }

    public boolean a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context != null && jSONObject != null) {
            Object b6 = this.f10645f.b(null, f10642d, context, jSONObject, str, str2);
            if (b6 instanceof Boolean) {
                return ((Boolean) b6).booleanValue();
            }
        }
        return false;
    }

    public int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (bv.a(context, str)) {
            return 103;
        }
        Object b6 = this.f10645f.b(null, f10643e, str);
        if (b6 instanceof Integer) {
            return ((Integer) b6).intValue();
        }
        return -1;
    }
}
