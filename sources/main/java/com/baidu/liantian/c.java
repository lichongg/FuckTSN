package com.baidu.liantian;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, d> f10382a = new HashMap();

    public static void a(Context context, int i6, File file, File file2) {
        try {
            if (com.baidu.liantian.b.e.a(file)) {
                if (!com.baidu.liantian.b.e.a(file2)) {
                    com.baidu.liantian.b.e.a(file, file2);
                }
                Objects.toString(file);
                Objects.toString(file2);
                b.a();
                if (f10382a.containsKey(file.getAbsolutePath())) {
                    return;
                }
                d dVar = new d(context, i6, file.getAbsolutePath(), file2.getAbsolutePath());
                dVar.startWatching();
                f10382a.put(file.getAbsolutePath(), dVar);
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public static void a(File file) {
        if (file == null) {
            return;
        }
        try {
            file.getAbsolutePath();
            b.a();
            d dVar = f10382a.get(file.getAbsolutePath());
            if (dVar != null) {
                dVar.stopWatching();
                f10382a.remove(file.getAbsolutePath());
                dVar.a();
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }
}
