package com.ss.android.downloadlib.up;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    static class a implements InterfaceC0764b<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f38208a;

        a(Runnable runnable) {
            this.f38208a = runnable;
        }

        @Override // com.ss.android.downloadlib.up.b.InterfaceC0764b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void xt() {
            this.f38208a.run();
            return null;
        }
    }

    /* renamed from: com.ss.android.downloadlib.up.b$b, reason: collision with other inner class name */
    public interface InterfaceC0764b<T> {
        T xt();
    }

    public static <T> T a(InterfaceC0764b<T> interfaceC0764b) {
        return (T) b(true, null, interfaceC0764b);
    }

    public static void c(Runnable runnable) {
        a(new a(runnable));
    }

    public static <T> T b(boolean z5, String str, @NonNull InterfaceC0764b<T> interfaceC0764b) {
        try {
            return interfaceC0764b.xt();
        } catch (Throwable th) {
            if (!(th instanceof j)) {
                com.ss.android.downloadlib.up.a.a().e(z5, th, str);
                if (!TextUtils.isEmpty(str)) {
                    return null;
                }
                throw th;
            }
            throw th;
        }
    }
}
