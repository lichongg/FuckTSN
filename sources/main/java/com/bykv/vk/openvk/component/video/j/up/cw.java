package com.bykv.vk.openvk.component.video.j.up;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    public static long j(String str, String str2) {
        File cw = cw(str, str2);
        if (cw.exists()) {
            return cw.length();
        }
        File xt = xt(str, str2);
        if (xt.exists()) {
            return xt.length();
        }
        return 0L;
    }

    public static File cw(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static File xt(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }

    public static boolean j(RandomAccessFile randomAccessFile, byte[] bArr, long j6, int i6) throws IOException {
        try {
            randomAccessFile.seek(j6);
            randomAccessFile.write(bArr, 0, i6);
            return true;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.cw.j("VideoFilesUtils", "append failed", th);
            return false;
        }
    }
}
