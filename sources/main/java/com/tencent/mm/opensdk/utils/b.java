package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static Context f40442a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f40443b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f40444c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f40445d;

    /* renamed from: e, reason: collision with root package name */
    public static ThreadPoolExecutor f40446e;

    public static int a(ContentResolver contentResolver, Uri uri) {
        Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return 0;
                }
                int available = openInputStream.available();
                try {
                    openInputStream.close();
                } catch (IOException unused2) {
                }
                return available;
            } catch (Exception e6) {
                Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e6.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return 0;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public static int a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (f40442a != null && str.startsWith("content")) {
            try {
                return a(f40442a.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f40443b = availableProcessors;
        int i6 = availableProcessors + 1;
        f40444c = i6;
        int i7 = (availableProcessors * 2) + 1;
        f40445d = i7;
        f40446e = new ThreadPoolExecutor(i6, i7, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    }

    public static int a(String str, int i6) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return Integer.parseInt(str);
                }
            } catch (Exception unused) {
            }
        }
        return i6;
    }

    public static boolean a(int i6) {
        return i6 == 36 || i6 == 46;
    }
}
