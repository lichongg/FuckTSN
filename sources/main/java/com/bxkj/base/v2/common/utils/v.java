package com.bxkj.base.v2.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f16952a = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final File a(@NotNull String base64Code, @NotNull String targetPath) {
            kotlin.jvm.internal.g0.p(base64Code, "base64Code");
            kotlin.jvm.internal.g0.p(targetPath, "targetPath");
            try {
                try {
                    byte[] a6 = cn.bluemobi.dylan.base.utils.b.a(base64Code);
                    FileOutputStream fileOutputStream = new FileOutputStream(targetPath);
                    fileOutputStream.write(a6);
                    fileOutputStream.close();
                    return new File(targetPath);
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return new File(targetPath);
                }
            } catch (Throwable unused) {
                return new File(targetPath);
            }
        }
    }
}
