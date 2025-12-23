package com.bxkj.student.v2.common.utils;

import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20950a = a.f20951a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f20951a = new a();

        @JvmStatic
        @NotNull
        public final String a(int i6) {
            return i6 != 1 ? i6 != 2 ? i6 != 3 ? "正常提交 " : "超时上传" : "异常上传" : "退出上传";
        }

        private a() {
        }
    }
}
