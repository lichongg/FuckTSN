package com.beizi.ad.lance.a;

import com.baidu.mobads.sdk.internal.by;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f12762a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String a(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            try {
                DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance(by.f10823a));
                try {
                    while (digestInputStream.read(new byte[4096]) != -1) {
                    }
                    String a6 = a(digestInputStream.getMessageDigest().digest());
                    digestInputStream.close();
                    fileInputStream.close();
                    return a6;
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b6)));
        }
        return sb.toString();
    }
}
