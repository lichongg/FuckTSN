package com.bxkj.base.v2.netty4android.client.handler;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final C0193a f17117a = C0193a.f17118a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.base.v2.netty4android.client.handler.a$a, reason: collision with other inner class name */
    public static final class C0193a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0193a f17118a = new C0193a();

        public final int a(@NotNull byte[] bytes) {
            g0.p(bytes, "bytes");
            int i6 = 0;
            for (byte b6 : bytes) {
                i6 += b6;
            }
            if (i6 > 255) {
                i6 = (~i6) + 1;
            }
            return 255 & i6;
        }

        private C0193a() {
        }
    }
}
