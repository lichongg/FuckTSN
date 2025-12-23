package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private final File f36782a;

    /* renamed from: b, reason: collision with root package name */
    private final File f36783b;

    /* renamed from: c, reason: collision with root package name */
    private String f36784c;

    /* renamed from: d, reason: collision with root package name */
    private int f36785d;

    /* renamed from: e, reason: collision with root package name */
    private String f36786e;

    boolean a(Context context, boolean z5) {
        try {
            if (this.f36783b.exists() && this.f36782a.exists()) {
                String a6 = h.a(this.f36783b);
                this.f36786e = a6;
                if (TextUtils.isEmpty(a6)) {
                    return false;
                }
                String[] split = this.f36786e.split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    int a7 = a(split[0], 0);
                    if (c.a().a(str, this.f36782a)) {
                        this.f36784c = str;
                        this.f36785d = a7;
                        if (Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34 || !z5) {
                            return true;
                        }
                        if (!this.f36782a.canWrite() && !this.f36782a.canExecute()) {
                            return this.f36782a.canRead();
                        }
                        return this.f36782a.setReadOnly();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    String a() {
        return this.f36784c;
    }

    int b() {
        return this.f36785d;
    }

    public String c() {
        return this.f36786e;
    }

    public g(File file, File file2) {
        this.f36782a = file;
        this.f36783b = file2;
    }

    boolean a(File file, File file2, Context context) {
        if (file == null || file2 == null) {
            return false;
        }
        return (file.equals(this.f36782a) || h.a(this.f36782a, file, context, true)) && (file2.equals(this.f36783b) || h.a(this.f36783b, file2, context, false));
    }

    private int a(String str, int i6) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i6;
        }
    }
}
