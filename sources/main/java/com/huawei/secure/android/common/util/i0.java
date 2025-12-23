package com.huawei.secure.android.common.util;

import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35279a = "FileUtil";

    @RequiresApi(api = 26)
    public static boolean a(File file) throws IOException {
        Path path;
        if (file == null) {
            return false;
        }
        try {
            path = Paths.get(file.getCanonicalPath(), new String[0]);
            if (path == null) {
                return false;
            }
            return f(path, null);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean b(String str) throws UnsupportedEncodingException {
        if (str == null || str.equals("")) {
            return true;
        }
        if (str.contains("%")) {
            str = str.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        }
        String decode = URLDecoder.decode(str, "utf-8");
        return (decode.contains("..") || decode.contains("./") || decode.contains(".\\.\\") || decode.contains("%00")) ? false : true;
    }

    public static boolean c(String str, String str2) throws IOException {
        if (str != null && !str.equals("") && str2 != null && !str2.equals("")) {
            String decode = URLDecoder.decode(str2, "utf-8");
            String decode2 = URLDecoder.decode(str, "utf-8");
            if (!decode2.contains("..") && !decode2.contains("./") && !decode2.contains(".\\.\\") && !decode2.contains("%00") && !decode.contains("..") && !decode.contains("./") && !decode.contains(".\\.\\") && !decode.contains("%00")) {
                return new File(decode2, decode).getCanonicalPath().startsWith(new File(decode2).getCanonicalPath());
            }
        }
        return false;
    }

    public static boolean d(String str, String[] strArr) {
        if (str != null && !str.isEmpty() && strArr != null) {
            String h6 = h(str);
            for (String str2 : strArr) {
                if (h6.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 26)
    public static boolean e(Path path) throws IOException {
        return f(path, null);
    }

    @RequiresApi(api = 26)
    public static boolean f(Path path, UserPrincipal userPrincipal) throws IOException {
        return g(path, userPrincipal, 5);
    }

    @RequiresApi(api = 26)
    public static boolean i(Path path) {
        LinkOption linkOption;
        BasicFileAttributes readAttributes;
        boolean isRegularFile;
        try {
            Class a6 = cn.jiguang.i.g.a();
            linkOption = LinkOption.NOFOLLOW_LINKS;
            readAttributes = Files.readAttributes(path, (Class<BasicFileAttributes>) a6, linkOption);
            if (readAttributes == null) {
                return false;
            }
            isRegularFile = readAttributes.isRegularFile();
            return isRegularFile;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:22:0x0048 */
    @androidx.annotation.RequiresApi(api = 26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean g(java.nio.file.Path r7, java.nio.file.attribute.UserPrincipal r8, int r9) throws java.io.IOException {
        /*
            boolean r0 = com.huawei.secure.android.common.util.p.a(r7)
            if (r0 != 0) goto La
            java.nio.file.Path r7 = com.huawei.secure.android.common.util.f0.a(r7)
        La:
            r0 = 0
            if (r9 > 0) goto Le
            return r0
        Le:
            r1 = 0
            java.nio.file.Path r2 = com.huawei.secure.android.common.util.a0.a(r7)     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lba
            java.lang.String r2 = com.huawei.secure.android.common.util.b0.a(r2)     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lba
            java.lang.String[] r3 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lba
            java.nio.file.Path r2 = cn.jiguang.i.f.a(r2, r3)     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lba
            java.nio.file.FileSystem r1 = com.huawei.secure.android.common.util.u.a(r2)     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lba
            java.nio.file.attribute.UserPrincipalLookupService r2 = com.huawei.secure.android.common.util.v.a(r1)     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lba
            if (r1 == 0) goto L2a
            com.huawei.secure.android.common.util.t.a(r1)
        L2a:
            java.lang.String r1 = "root"
            java.nio.file.attribute.UserPrincipal r1 = com.huawei.secure.android.common.util.w.a(r2, r1)     // Catch: java.io.IOException -> Lb7
            if (r8 != 0) goto L3c
            java.lang.String r8 = "user.name"
            java.lang.String r8 = java.lang.System.getProperty(r8)     // Catch: java.io.IOException -> Lb7
            java.nio.file.attribute.UserPrincipal r8 = com.huawei.secure.android.common.util.w.a(r2, r8)     // Catch: java.io.IOException -> Lb7
        L3c:
            if (r1 == 0) goto Lb7
            if (r8 != 0) goto L42
            goto Lb7
        L42:
            r2 = 1
            r3 = 1
        L44:
            int r4 = com.huawei.secure.android.common.util.z.a(r7)
            if (r3 > r4) goto Lb6
            java.nio.file.Path r4 = com.huawei.secure.android.common.util.a0.a(r7)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r4 = com.huawei.secure.android.common.util.b0.a(r4)     // Catch: java.lang.Throwable -> Lb5
            java.nio.file.Path r5 = com.huawei.secure.android.common.util.c0.a(r7, r0, r3)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r5 = com.huawei.secure.android.common.util.b0.a(r5)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch: java.lang.Throwable -> Lb5
            java.nio.file.Path r4 = cn.jiguang.i.f.a(r4, r5)     // Catch: java.lang.Throwable -> Lb5
            boolean r5 = cn.jiguang.bz.h1.a(r4)
            if (r5 == 0) goto L78
            com.huawei.secure.android.common.util.b0.a(r4)
            java.nio.file.Path r4 = com.huawei.secure.android.common.util.d0.a(r4)
            int r5 = r9 + (-1)
            boolean r4 = g(r4, r8, r5)
            if (r4 != 0) goto Lb2
            return r0
        L78:
            java.nio.file.LinkOption[] r5 = new java.nio.file.LinkOption[r0]
            java.nio.file.attribute.UserPrincipal r5 = com.huawei.secure.android.common.util.e0.a(r4, r5)
            boolean r6 = r8.equals(r5)
            if (r6 != 0) goto L8b
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L8b
            return r0
        L8b:
            java.lang.Class r5 = com.huawei.secure.android.common.util.g0.a()
            java.nio.file.LinkOption[] r6 = new java.nio.file.LinkOption[r0]
            java.nio.file.attribute.BasicFileAttributes r4 = cn.jiguang.i.h.a(r4, r5, r6)
            java.nio.file.attribute.PosixFileAttributes r4 = com.huawei.secure.android.common.util.h0.a(r4)
            java.util.Set r4 = com.huawei.secure.android.common.util.q.a(r4)
            java.nio.file.attribute.PosixFilePermission r5 = com.huawei.secure.android.common.util.r.a()
            boolean r5 = r4.contains(r5)
            if (r5 != 0) goto Lb5
            java.nio.file.attribute.PosixFilePermission r5 = com.huawei.secure.android.common.util.s.a()
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto Lb2
            goto Lb5
        Lb2:
            int r3 = r3 + 1
            goto L44
        Lb5:
            return r0
        Lb6:
            return r2
        Lb7:
            return r0
        Lb8:
            r7 = move-exception
            goto Lbc
        Lba:
            goto Lc2
        Lbc:
            if (r1 == 0) goto Lc1
            com.huawei.secure.android.common.util.t.a(r1)
        Lc1:
            throw r7
        Lc2:
            if (r1 == 0) goto Lc7
            com.huawei.secure.android.common.util.t.a(r1)
        Lc7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.i0.g(java.nio.file.Path, java.nio.file.attribute.UserPrincipal, int):boolean");
    }

    private static String h(String str) {
        int lastIndexOf;
        int i6;
        if (!str.isEmpty() && (lastIndexOf = str.lastIndexOf(".")) != -1 && (i6 = lastIndexOf + 1) != str.length()) {
            return str.substring(i6).toLowerCase(Locale.ENGLISH);
        }
        return "";
    }
}
