package com.jmolsmobile.landscapevideocapture;

import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static final String f35601c = "/";

    /* renamed from: d, reason: collision with root package name */
    private static final String f35602d = "yyyyMMdd_HHmmss";

    /* renamed from: e, reason: collision with root package name */
    private static final String f35603e = "video_";

    /* renamed from: f, reason: collision with root package name */
    private static final String f35604f = ".mp4";

    /* renamed from: a, reason: collision with root package name */
    private final String f35605a;

    /* renamed from: b, reason: collision with root package name */
    private Date f35606b;

    public c(String str) {
        this.f35605a = str;
    }

    private Date b() {
        if (this.f35606b == null) {
            this.f35606b = new Date();
        }
        return this.f35606b;
    }

    private boolean e() {
        String str = this.f35605a;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public c(String str, Date date) {
        this(str);
        this.f35606b = date;
    }

    private String a() {
        if (e()) {
            return this.f35605a;
        }
        return f35603e + new SimpleDateFormat(f35602d, Locale.getDefault()).format(b()) + f35604f;
    }

    public File c() {
        String a6 = a();
        if (a6.contains(f35601c)) {
            return new File(a6);
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        externalStoragePublicDirectory.mkdirs();
        return new File(externalStoragePublicDirectory, a());
    }

    public String d() {
        return c().getAbsolutePath();
    }
}
