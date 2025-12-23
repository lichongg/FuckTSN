package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f5 {

    /* renamed from: a, reason: collision with root package name */
    public static String f6174a = "9aj&#k81";

    /* renamed from: b, reason: collision with root package name */
    public static String f6175b = "IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz";

    /* renamed from: c, reason: collision with root package name */
    private static String f6176c = "ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKATEDewAJA4QADQORABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PVNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlMQ0poWVdsa0lqb2lKWE1pSVlXbGtQUT09TWZITmxjbWxoYkQwPVFZVzVrY205cFpGOXBaQT09";

    /* renamed from: d, reason: collision with root package name */
    static byte[] f6177d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f6178e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f6179f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f6180g = new ConcurrentHashMap<>(8);

    /* renamed from: h, reason: collision with root package name */
    public static final Integer f6181h = 1;

    /* renamed from: i, reason: collision with root package name */
    public static final Integer f6182i = 2;

    /* renamed from: j, reason: collision with root package name */
    public static final Integer f6183j = 3;

    /* renamed from: k, reason: collision with root package name */
    public static final Integer f6184k = 4;

    /* renamed from: l, reason: collision with root package name */
    public static final Integer f6185l = 5;

    public static String a(String str) {
        String str2 = "";
        try {
            synchronized (f6180g) {
                try {
                    if (f6180g != null && f6180g.containsKey(str)) {
                        str2 = f6180g.get(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static byte[] c() {
        if (f6177d == null) {
            f6177d = j4.g(f6176c);
        }
        byte[] bArr = new byte[4];
        System.arraycopy(f6177d, 40, bArr, 0, 4);
        int i6 = ((bArr[0] & 255) * 256) + (bArr[1] & 255);
        int i7 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        byte[] bArr2 = new byte[i7];
        System.arraycopy(f6177d, i6, bArr2, 0, i7);
        return bArr2;
    }

    public static void b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                synchronized (f6180g) {
                    try {
                        if (f6180g == null) {
                            f6180g = new ConcurrentHashMap<>(8);
                        }
                        if (!f6180g.containsKey(str)) {
                            f6180g.put(str, str2);
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
