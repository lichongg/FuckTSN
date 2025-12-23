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
public @interface FaceType {

    @NotNull
    public static final a Companion = a.f20851a;

    @NotNull
    public static final String End = "3";

    @NotNull
    public static final String Middle = "2";

    @NotNull
    public static final String Start = "1";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f20851a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final String f20852b = "1";

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final String f20853c = "2";

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final String f20854d = "3";

        private a() {
        }
    }
}
