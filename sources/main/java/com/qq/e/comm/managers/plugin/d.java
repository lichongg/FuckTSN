package com.qq.e.comm.managers.plugin;

import com.baidu.mobads.sdk.internal.by;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f36781a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b6 : bArr) {
            stringBuffer.append(a(b6));
        }
        return stringBuffer.toString();
    }

    private static String a(byte b6) {
        int i6 = b6;
        if (b6 < 0) {
            i6 = b6 + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = f36781a;
        sb.append(strArr[i6 / 16]);
        sb.append(strArr[i6 % 16]);
        return sb.toString();
    }

    public static String a(File file) {
        if (file != null && file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    String a6 = a(messageDigest.digest());
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused) {
                    }
                    return a6;
                } catch (Exception unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return "";
    }

    public static String a(String str) {
        try {
            String str2 = new String(str);
            try {
                return a(MessageDigest.getInstance(by.f10823a).digest(str2.getBytes("UTF-8")));
            } catch (Exception unused) {
                return str2;
            }
        } catch (Exception unused2) {
            return null;
        }
    }
}
