package com.kwad.components.core.i;

import android.content.Context;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.i.a$a, reason: collision with other inner class name */
    static final class C0619a {
        private static final a QT = new a(0);
    }

    /* synthetic */ a(byte b6) {
        this();
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j6) {
        File[] listFiles = au(context).listFiles(new FileFilter() { // from class: com.kwad.components.core.i.a.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                String name = file.getName();
                if (name.startsWith("dynamic-") && name.endsWith(".apk")) {
                    return true;
                }
                return false;
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        long j7 = 0;
        for (File file : listFiles) {
            j7 = Math.max(j7, file.lastModified());
        }
        long min = Math.min(j6, j7);
        for (File file2 : listFiles) {
            if (file2.exists() && file2.lastModified() < min) {
                file2.delete();
            }
        }
    }

    private static File au(Context context) {
        return new File(context.getApplicationInfo().dataDir, "ksad_dynamic");
    }

    public static a qn() {
        return C0619a.QT;
    }

    public final void at(final Context context) {
        final long currentTimeMillis = System.currentTimeMillis();
        h.schedule(new Runnable() { // from class: com.kwad.components.core.i.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(context, currentTimeMillis);
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }
}
