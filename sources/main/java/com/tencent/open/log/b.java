package com.tencent.open.log;

import android.text.TextUtils;
import com.tencent.open.log.d;
import com.tencent.open.utils.m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f40595a = d.C0816d.a("yy.MM.dd.HH");

    /* renamed from: g, reason: collision with root package name */
    private File f40601g;

    /* renamed from: b, reason: collision with root package name */
    private String f40596b = "Tracer.File";

    /* renamed from: c, reason: collision with root package name */
    private int f40597c = Integer.MAX_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private int f40598d = Integer.MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f40599e = 4096;

    /* renamed from: f, reason: collision with root package name */
    private long f40600f = 10000;

    /* renamed from: h, reason: collision with root package name */
    private int f40602h = 10;

    /* renamed from: i, reason: collision with root package name */
    private String f40603i = ".log";

    /* renamed from: j, reason: collision with root package name */
    private long f40604j = Long.MAX_VALUE;

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    private File d(long j6) {
        String c6 = c(a(j6));
        String b6 = m.b();
        if (TextUtils.isEmpty(b6) && b6 == null) {
            return null;
        }
        try {
            File file = new File(b6, c.f40619o);
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, c6);
        } catch (Exception e6) {
            SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e6);
            return null;
        }
    }

    public File a() {
        return d(System.currentTimeMillis());
    }

    public String b() {
        return this.f40596b;
    }

    public static String a(long j6) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j6);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public void b(int i6) {
        this.f40598d = i6;
    }

    public int c() {
        return this.f40599e;
    }

    public b(File file, int i6, int i7, int i8, String str, long j6, int i9, String str2, long j7) {
        a(file);
        b(i6);
        a(i7);
        c(i8);
        a(str);
        b(j6);
        d(i9);
        b(str2);
        c(j7);
    }

    public void b(long j6) {
        this.f40600f = j6;
    }

    public void c(int i6) {
        this.f40599e = i6;
    }

    public void b(String str) {
        this.f40603i = str;
    }

    public void c(long j6) {
        this.f40604j = j6;
    }

    public void a(String str) {
        this.f40596b = str;
    }

    public void a(int i6) {
        this.f40597c = i6;
    }

    public void a(File file) {
        this.f40601g = file;
    }

    public int d() {
        return this.f40602h;
    }

    public void d(int i6) {
        this.f40602h = i6;
    }
}
