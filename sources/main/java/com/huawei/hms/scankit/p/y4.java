package com.huawei.hms.scankit.p;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class y4 {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f35045a;

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f35046b;

    /* renamed from: c, reason: collision with root package name */
    private static byte[] f35047c;

    public static byte[] a() {
        return f35046b;
    }

    public static byte[] b() {
        return f35047c;
    }

    public static void c(Context context, String str) {
        o4.d("MsModel", "load model...." + str);
        if (f35045a != null) {
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = context.getAssets().open(str);
                    o4.d("MsModel", "inputStream" + inputStream);
                    byte[] bArr = new byte[inputStream.available()];
                    inputStream.read(bArr);
                    inputStream.close();
                    f35045a = bArr;
                    inputStream.close();
                } catch (IOException unused) {
                    o4.b("MsModel", "loadModel IOException");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception unused2) {
                    o4.b("MsModel", "loadModel Exception");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException unused3) {
                o4.b("MsModel", "loadModel inputStream.close() IOException");
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                    o4.b("MsModel", "loadModel inputStream.close() IOException");
                }
            }
            throw th;
        }
    }

    public static void a(Context context, String str) {
        o4.d("MsModel", "load angle model...." + str);
        if (f35046b != null) {
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = context.getAssets().open(str);
                    o4.d("MsModel", "3inputStream" + inputStream);
                    byte[] bArr = new byte[inputStream.available()];
                    inputStream.read(bArr);
                    inputStream.close();
                    f35046b = bArr;
                    inputStream.close();
                } catch (IOException unused) {
                    o4.b("MsModel", "loadAngleModel IOException");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception unused2) {
                    o4.b("MsModel", "loadAngleModel Exception");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException unused3) {
                o4.b("MsModel", "loadAngleModel inputStream.close() IOException");
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                    o4.b("MsModel", "loadAngleModel inputStream.close() IOException");
                }
            }
            throw th;
        }
    }

    public static void b(Context context, String str) {
        o4.d("MsModel", "load corner model...." + str);
        if (f35047c != null) {
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = context.getAssets().open(str);
                    o4.d("MsModel", "4inputStream" + inputStream);
                    byte[] bArr = new byte[inputStream.available()];
                    inputStream.read(bArr);
                    inputStream.close();
                    f35047c = bArr;
                    inputStream.close();
                } catch (IOException unused) {
                    o4.b("MsModel", "loadConerModel IOException");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception unused2) {
                    o4.b("MsModel", "loadConerModel Exception");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException unused3) {
                o4.b("MsModel", "loadConerModel inputStream.close() IOException");
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                    o4.b("MsModel", "loadConerModel inputStream.close() IOException");
                }
            }
            throw th;
        }
    }

    public static byte[] c() {
        return f35045a;
    }
}
