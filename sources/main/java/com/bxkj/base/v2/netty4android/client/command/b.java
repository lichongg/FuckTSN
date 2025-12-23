package com.bxkj.base.v2.netty4android.client.command;

import com.bxkj.base.util.b0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f17084a = a.f17097a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte f17085b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final byte f17086c = 4;

    /* renamed from: d, reason: collision with root package name */
    public static final byte f17087d = 6;

    /* renamed from: e, reason: collision with root package name */
    public static final byte f17088e = 7;

    /* renamed from: f, reason: collision with root package name */
    public static final byte f17089f = 8;

    /* renamed from: g, reason: collision with root package name */
    public static final byte f17090g = 16;

    /* renamed from: h, reason: collision with root package name */
    public static final byte f17091h = 18;

    /* renamed from: i, reason: collision with root package name */
    public static final byte f17092i = 20;

    /* renamed from: j, reason: collision with root package name */
    public static final byte f17093j = 21;

    /* renamed from: k, reason: collision with root package name */
    public static final byte f17094k = 22;

    /* renamed from: l, reason: collision with root package name */
    public static final byte f17095l = 24;

    /* renamed from: m, reason: collision with root package name */
    public static final byte f17096m = 25;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f17097a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static boolean f17098b = false;

        /* renamed from: c, reason: collision with root package name */
        private static final byte f17099c = 1;

        /* renamed from: d, reason: collision with root package name */
        public static final byte f17100d = 2;

        /* renamed from: e, reason: collision with root package name */
        private static final byte f17101e = 33;

        /* renamed from: f, reason: collision with root package name */
        public static final byte f17102f = 4;

        /* renamed from: g, reason: collision with root package name */
        public static final byte f17103g = 6;

        /* renamed from: h, reason: collision with root package name */
        public static final byte f17104h = 7;

        /* renamed from: i, reason: collision with root package name */
        public static final byte f17105i = 8;

        /* renamed from: j, reason: collision with root package name */
        private static final byte f17106j = 9;

        /* renamed from: k, reason: collision with root package name */
        public static final byte f17107k = 16;

        /* renamed from: l, reason: collision with root package name */
        private static final byte f17108l = 17;

        /* renamed from: m, reason: collision with root package name */
        public static final byte f17109m = 18;

        /* renamed from: n, reason: collision with root package name */
        private static final byte f17110n = 19;

        /* renamed from: o, reason: collision with root package name */
        public static final byte f17111o = 20;

        /* renamed from: p, reason: collision with root package name */
        public static final byte f17112p = 21;

        /* renamed from: q, reason: collision with root package name */
        public static final byte f17113q = 22;

        /* renamed from: r, reason: collision with root package name */
        private static final byte f17114r = 23;

        /* renamed from: s, reason: collision with root package name */
        public static final byte f17115s = 24;

        /* renamed from: t, reason: collision with root package name */
        public static final byte f17116t = 25;

        @NotNull
        public final com.bxkj.base.v2.netty4android.client.command.a a(@NotNull String userName, @NotNull String basUserId, @NotNull String secret, @NotNull String appVersion, @NotNull String schoolCode) {
            g0.p(userName, "userName");
            g0.p(basUserId, "basUserId");
            g0.p(secret, "secret");
            g0.p(appVersion, "appVersion");
            g0.p(schoolCode, "schoolCode");
            String jSONObject = new JSONObject().put("userName", userName).put("basUserId", basUserId).put("secret", secret).put("type", b0.f()).put("appVersion", appVersion).put("schoolCode", schoolCode).toString();
            g0.o(jSONObject, "toString(...)");
            return new com.bxkj.base.v2.netty4android.client.command.a((byte) 1, jSONObject.length(), jSONObject);
        }

        @NotNull
        public final com.bxkj.base.v2.netty4android.client.command.a b() {
            return new com.bxkj.base.v2.netty4android.client.command.a((byte) 33, 0, "");
        }

        public final boolean c() {
            return f17098b;
        }

        public final void d(boolean z5) {
            f17098b = z5;
        }

        private a() {
        }
    }
}
