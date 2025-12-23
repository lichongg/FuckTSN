package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.config.FieldManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h extends a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f41959a = au.b().b(au.f40907l);

    /* renamed from: b, reason: collision with root package name */
    public static final String f41960b = "key_umeng_sp_oaid";

    /* renamed from: c, reason: collision with root package name */
    public static final String f41961c = "key_umeng_sp_oaid_required_time";

    /* renamed from: d, reason: collision with root package name */
    private static final String f41962d = "oaid";

    /* renamed from: e, reason: collision with root package name */
    private Context f41963e;

    public h(Context context) {
        super(f41962d);
        this.f41963e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.f41963e.getSharedPreferences(f41959a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(f41960b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
