package com.google.android.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Transform {

    @NotNull
    public static final Transform INSTANCE = new Transform();

    @NotNull
    public final native String a(@NotNull Context context);

    public final native boolean d(@NotNull Context context);

    public final native int e(@NotNull Context context);

    @NotNull
    public final native String f(@NotNull Context context);

    @NotNull
    public final native String g(@NotNull Context context);

    @NotNull
    public final native String h(@NotNull Context context);

    @NotNull
    public final native String i(@NotNull Context context);

    @NotNull
    public final native String k(@NotNull Context context, @NotNull String str);

    @NotNull
    public final native String r(@NotNull Context context, @NotNull String str, @NotNull Map<String, String> map);

    @NotNull
    public final native String[] s(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    public final native String t(@NotNull Context context, @NotNull String str, @NotNull String str2);

    @NotNull
    public final native String u(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    public final native String v(@NotNull Context context, @NotNull String str, @NotNull String str2);

    @NotNull
    public final native String w(@NotNull Context context, @NotNull String str, @NotNull Map<String, String> map);

    @NotNull
    public final native String x(@NotNull Context context);

    static {
        System.loadLibrary("tsnsecret");
    }

    private Transform() {
    }
}
