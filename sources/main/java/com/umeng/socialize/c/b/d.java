package com.umeng.socialize.c.b;

import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f42314a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f42315b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f42316c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f42317d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f42318e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final int f42319f = 5;

    /* renamed from: g, reason: collision with root package name */
    public static final int f42320g = 6;

    /* renamed from: h, reason: collision with root package name */
    public static final int f42321h = 7;

    /* renamed from: i, reason: collision with root package name */
    public static final int f42322i = 8;

    /* renamed from: j, reason: collision with root package name */
    public static final int f42323j = 9;

    /* renamed from: k, reason: collision with root package name */
    public static final int f42324k = 10;

    /* renamed from: l, reason: collision with root package name */
    public static final int f42325l = 11;

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f42326m = {"jpeg", "gif", "png", "bmp", "pcx", "iff", "ras", "pbm", "pgm", "ppm", "psd", "swf"};

    public static String a(byte[] bArr) {
        String str;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                try {
                    int read = byteArrayInputStream2.read();
                    int read2 = byteArrayInputStream2.read();
                    if (read == 71 && read2 == 73) {
                        str = f42326m[1];
                    } else if (read == 137 && read2 == 80) {
                        str = f42326m[2];
                    } else if (read == 255 && read2 == 216) {
                        str = f42326m[0];
                    } else if (read == 66 && read2 == 77) {
                        str = f42326m[3];
                    } else if (read == 10 && read2 < 6) {
                        str = f42326m[4];
                    } else if (read == 70 && read2 == 79) {
                        str = f42326m[5];
                    } else if (read == 89 && read2 == 166) {
                        str = f42326m[6];
                    } else {
                        if (read == 80 && read2 >= 49 && read2 <= 54) {
                            int i6 = read2 - 48;
                            if (i6 >= 1 && i6 <= 6) {
                                str = f42326m[new int[]{7, 8, 9}[(read2 - 49) % 3]];
                            }
                            byteArrayInputStream2.close();
                            return "";
                        }
                        if (read != 56 || read2 != 66) {
                            if (read == 70 && read2 == 87) {
                                str = f42326m[11];
                            }
                            try {
                                byteArrayInputStream2.close();
                                return "";
                            } catch (IOException e6) {
                                SLog.error(UmengText.IMAGE.CLOSE, e6);
                                return "";
                            }
                        }
                        str = f42326m[10];
                    }
                    try {
                        byteArrayInputStream2.close();
                        return str;
                    } catch (IOException e7) {
                        SLog.error(UmengText.IMAGE.CLOSE, e7);
                        return str;
                    }
                } catch (Exception e8) {
                    e = e8;
                    byteArrayInputStream = byteArrayInputStream2;
                    SLog.error(UmengText.IMAGE.CHECK_FORMAT_ERROR, e);
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e9) {
                            SLog.error(UmengText.IMAGE.CLOSE, e9);
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream = byteArrayInputStream2;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e10) {
                            SLog.error(UmengText.IMAGE.CLOSE, e10);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }
}
