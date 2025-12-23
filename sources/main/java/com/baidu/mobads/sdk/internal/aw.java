package com.baidu.mobads.sdk.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.az;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class aw extends az.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10651a = "debug";

    @Override // com.baidu.mobads.sdk.internal.az.a
    @NonNull
    String a() {
        return "debug";
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    protected boolean a(String str, int i6) {
        return az.f10668a.equals(str);
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    protected void a(int i6, String str, String str2, Throwable th) {
        a(i6, str, str2);
    }

    private static void a(int i6, String str, String str2) {
        try {
            if (i6 == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i6, str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}
