package c0;

import android.content.Context;
import com.google.android.datatransport.Transform;
import java.util.Map;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f1042a = new b();

    @NotNull
    public final String a(@NotNull Context context, @NotNull String encryptedData, @NotNull String key) {
        g0.p(context, "context");
        g0.p(encryptedData, "encryptedData");
        g0.p(key, "key");
        return Transform.INSTANCE.t(context, encryptedData, key);
    }

    @NotNull
    public final String[] b(@NotNull Context context, @NotNull String token, @NotNull String timestamp, @NotNull String data) {
        g0.p(context, "context");
        g0.p(token, "token");
        g0.p(timestamp, "timestamp");
        g0.p(data, "data");
        return Transform.INSTANCE.s(context, token, timestamp, data);
    }

    public final boolean c(@NotNull Context context) {
        g0.p(context, "context");
        return Transform.INSTANCE.d(context);
    }

    @NotNull
    public final String d(@NotNull Context context, @NotNull String appId, @NotNull String token, @NotNull String timestamp) {
        g0.p(context, "context");
        g0.p(appId, "appId");
        g0.p(token, "token");
        g0.p(timestamp, "timestamp");
        return Transform.INSTANCE.u(context, appId, token, timestamp);
    }

    @NotNull
    public final String e(@NotNull Context context, @NotNull String token, @NotNull String timestamp) {
        g0.p(context, "context");
        g0.p(token, "token");
        g0.p(timestamp, "timestamp");
        return Transform.INSTANCE.v(context, token, timestamp);
    }

    @NotNull
    public final String f(@NotNull Context context) {
        g0.p(context, "context");
        return Transform.INSTANCE.a(context);
    }

    @NotNull
    public final String g(@NotNull Context context) {
        g0.p(context, "context");
        return Transform.INSTANCE.x(context);
    }

    @NotNull
    public final String h(@NotNull Context context, @NotNull String token, @NotNull Map<String, String> map) {
        g0.p(context, "context");
        g0.p(token, "token");
        g0.p(map, "map");
        return Transform.INSTANCE.r(context, token, map);
    }

    @NotNull
    public final String i(@NotNull Context context, @NotNull String token, @NotNull Map<String, String> map) {
        g0.p(context, "context");
        g0.p(token, "token");
        g0.p(map, "map");
        return Transform.INSTANCE.w(context, token, map);
    }

    @NotNull
    public final String j(@NotNull Context context) {
        g0.p(context, "context");
        return Transform.INSTANCE.i(context);
    }

    @NotNull
    public final String k(@NotNull Context context) {
        g0.p(context, "context");
        return Transform.INSTANCE.g(context);
    }

    @NotNull
    public final String l(@NotNull Context context, @NotNull String url) {
        g0.p(context, "context");
        g0.p(url, "url");
        return Transform.INSTANCE.k(context, url);
    }

    public final int m(@NotNull Context context) {
        g0.p(context, "context");
        return Transform.INSTANCE.e(context);
    }

    @NotNull
    public final String n(@NotNull Context context) {
        g0.p(context, "context");
        return Transform.INSTANCE.f(context);
    }

    @NotNull
    public final String o(@NotNull Context context) {
        g0.p(context, "context");
        return Transform.INSTANCE.h(context);
    }

    private b() {
    }
}
