package com.huawei.hms.hatool;

import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class n1 {

    /* renamed from: a, reason: collision with root package name */
    private String f33619a = y0.q().getFilesDir().getPath();

    private static boolean h(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    j1.h("hmsSdk", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                h(file2);
            }
        }
        return file.delete();
    }

    private String b(String str) {
        return this.f33619a + "/hms/component/".replace("component", str);
    }

    private void c(String str, String str2) {
        File file = new File(b(str));
        File file2 = new File(b(str), "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            j1.h("hmsSdk", "file directory is mkdirs");
        }
        if (d(file2)) {
            i0.d(file2, str2);
        } else {
            j1.m("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    private String f(String str) {
        File file = new File(b(str), "hianalytics_" + str);
        if (d(file)) {
            return i0.a(file);
        }
        String e6 = d2.b.e(128);
        i0.d(file, e6);
        return e6;
    }

    public static boolean i() {
        return h(new File(y0.q().getFilesDir().getPath() + "/hms"));
    }

    private String j() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }

    n1() {
    }

    private boolean d(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            j1.m("hmsSdk", "create new file error!");
            return false;
        }
    }

    private char[] e(String str, String str2, String str3, String str4) {
        byte[] c6 = d2.c.c(str);
        byte[] c7 = d2.c.c(str2);
        byte[] c8 = d2.c.c(str3);
        byte[] c9 = d2.c.c(str4);
        int length = c6.length;
        if (length > c7.length) {
            length = c7.length;
        }
        if (length > c8.length) {
            length = c8.length;
        }
        if (length > c9.length) {
            length = c9.length;
        }
        char[] cArr = new char[length];
        for (int i6 = 0; i6 < length; i6++) {
            cArr[i6] = (char) (((c6[i6] ^ c7[i6]) ^ c8[i6]) ^ c9[i6]);
        }
        return cArr;
    }

    private boolean g() {
        long a6 = l.a(y0.q(), "Privacy_MY", "assemblyFlash", -1L);
        if (-1 == a6) {
            j1.h("hmsSdk", "First init components");
            return true;
        }
        if (System.currentTimeMillis() - a6 > 31536000000L) {
            return true;
        }
        return false;
    }

    public String a() {
        String f6;
        String f7;
        String f8;
        String f9;
        String j6 = j();
        if (g()) {
            j1.h("hmsSdk", "refresh components");
            f6 = d2.b.e(128);
            c("aprpap", f6);
            f7 = d2.b.e(128);
            c("febdoc", f7);
            f8 = d2.b.e(128);
            c("marfil", f8);
            f9 = d2.b.e(128);
            c("maywnj", f9);
            l.f(y0.q(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            f6 = f("aprpap");
            f7 = f("febdoc");
            f8 = f("marfil");
            f9 = f("maywnj");
        }
        return d2.c.b(z1.c.c(e(f6, f7, f8, j6), d2.c.c(f9), 10000, 16));
    }
}
