package com.bxkj.student.v2.common.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Target({ElementType.TYPE, ElementType.TYPE_USE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: D:\Downloads\app\classes3.dex */
public @interface MenuType {

    @NotNull
    public static final String CLASSIFY = "2";

    @NotNull
    public static final a Companion = a.f20855a;

    @NotNull
    public static final String HOME = "1";

    @NotNull
    public static final String MY = "5";

    @NotNull
    public static final String Navigation = "0";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f20855a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final String f20856b = "0";

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final String f20857c = "1";

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final String f20858d = "2";

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final String f20859e = "5";

        private a() {
        }
    }
}
