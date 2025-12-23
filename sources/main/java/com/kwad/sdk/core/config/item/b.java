package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class b<T> {
    private T aCi;
    private T aCj;
    private String mKey;

    public b(String str, T t5) {
        this(str, t5, t5);
    }

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void b(SharedPreferences.Editor editor);

    public abstract void k(JSONObject jSONObject);

    private b(String str, T t5, T t6) {
        this.mKey = str;
        this.aCj = t5;
        this.aCi = t6;
        com.kwad.sdk.core.config.b.a(this);
    }

    public final T Gu() {
        return this.aCi;
    }

    public final String getKey() {
        return this.mKey;
    }

    @Nullable
    public T getValue() {
        return this.aCj;
    }

    public void setValue(T t5) {
        this.aCj = t5;
    }

    public static String dz(String str) {
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.core.a.c.encodeKsSdk(str);
        }
        return str;
    }

    public static String getDecodeString(String str) {
        if (!TextUtils.isEmpty(str) && com.kwad.sdk.core.a.c.isEncodeKsSdk(str)) {
            return com.kwad.sdk.core.a.c.decodeKsSdk(str);
        }
        return str;
    }
}
