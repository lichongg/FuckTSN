package com.bxkj.base.v2.netty4android.client.heart;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: D:\Downloads\app\classes3.dex */
public @interface AlarmActionType {

    @NotNull
    public static final a Companion = a.f17128a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f17128a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static String f17129b = "CHECK_HEART_TIMEOUT";

        @NotNull
        public final String a() {
            return f17129b;
        }

        public final void b(@NotNull String str) {
            g0.p(str, "<set-?>");
            f17129b = str;
        }

        private a() {
        }
    }
}
