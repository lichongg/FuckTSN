package com.bumptech.glide.load.engine.executor;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f15163a = "GlideRuntimeCompat";

    /* renamed from: b, reason: collision with root package name */
    private static final String f15164b = "cpu[0-9]+";

    /* renamed from: c, reason: collision with root package name */
    private static final String f15165c = "/sys/devices/system/cpu/";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Pattern f15166a;

        a(Pattern pattern) {
            this.f15166a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f15166a.matcher(str).matches();
        }
    }

    private b() {
    }

    static int a() {
        return Runtime.getRuntime().availableProcessors();
    }

    private static int b() {
        File[] fileArr;
        int i6;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                fileArr = new File(f15165c).listFiles(new a(Pattern.compile(f15164b)));
            } catch (Throwable unused) {
                Log.isLoggable(f15163a, 6);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                fileArr = null;
            }
            if (fileArr != null) {
                i6 = fileArr.length;
            } else {
                i6 = 0;
            }
            return Math.max(1, i6);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
