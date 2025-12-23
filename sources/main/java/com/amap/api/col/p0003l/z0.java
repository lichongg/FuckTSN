package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    private c f7784a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v0 f7785a;

        @Override // com.amap.api.col.3l.z0.d
        public final void a(long j6) {
            try {
                v0 v0Var = this.f7785a;
                if (v0Var != null) {
                    v0Var.a(j6);
                }
            } catch (Exception unused) {
            }
        }

        a(v0 v0Var) {
            this.f7785a = v0Var;
        }

        @Override // com.amap.api.col.3l.z0.d
        public final void a() {
            v0 v0Var = this.f7785a;
            if (v0Var != null) {
                v0Var.c();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7786a = false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private String f7787a;

        /* renamed from: b, reason: collision with root package name */
        private String f7788b;

        /* renamed from: c, reason: collision with root package name */
        private v0 f7789c;

        /* renamed from: d, reason: collision with root package name */
        private b f7790d = new b();

        /* renamed from: e, reason: collision with root package name */
        private String f7791e;

        public final String a() {
            return this.f7787a;
        }

        public final String c() {
            return this.f7788b;
        }

        public final String d() {
            return this.f7791e;
        }

        public final v0 e() {
            return this.f7789c;
        }

        public final b f() {
            return this.f7790d;
        }

        public final void g() {
            this.f7790d.f7786a = true;
        }

        public c(w0 w0Var, v0 v0Var) {
            this.f7789c = null;
            this.f7787a = w0Var.x();
            this.f7788b = w0Var.e();
            this.f7789c = v0Var;
        }

        public final void b(String str) {
            if (str.length() > 1) {
                this.f7791e = str;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void a();

        void a(long j6);
    }

    private static void f(File file, ZipInputStream zipInputStream, long j6, d dVar, b bVar) throws Exception {
        int i6 = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (bVar != null && bVar.f7786a) {
                zipInputStream.closeEntry();
                return;
            }
            String str = file.getPath() + File.separator + nextEntry.getName();
            if (!g(nextEntry.getName())) {
                if (dVar != null) {
                    dVar.a();
                    return;
                }
                return;
            } else {
                File file2 = new File(str);
                d(file2);
                if (nextEntry.isDirectory()) {
                    file2.mkdirs();
                } else {
                    i6 += a(file2, zipInputStream, i6, j6, dVar, bVar);
                }
                zipInputStream.closeEntry();
            }
        }
    }

    private static int a(File file, ZipInputStream zipInputStream, long j6, long j7, d dVar, b bVar) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i6 = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i6;
            }
            if (bVar != null && bVar.f7786a) {
                bufferedOutputStream.close();
                return i6;
            }
            bufferedOutputStream.write(bArr, 0, read);
            i6 += read;
            if (j7 > 0 && dVar != null) {
                long j8 = ((i6 + j6) * 100) / j7;
                if (bVar == null || !bVar.f7786a) {
                    dVar.a(j8);
                }
            }
        }
    }

    private static void c(c cVar) {
        if (cVar == null) {
            return;
        }
        v0 e6 = cVar.e();
        if (e6 != null) {
            e6.p();
        }
        String a6 = cVar.a();
        String c6 = cVar.c();
        if (TextUtils.isEmpty(a6) || TextUtils.isEmpty(c6)) {
            if (cVar.f().f7786a) {
                if (e6 != null) {
                    e6.r();
                    return;
                }
                return;
            } else {
                if (e6 != null) {
                    e6.c();
                    return;
                }
                return;
            }
        }
        File file = new File(a6);
        if (!file.exists()) {
            if (cVar.f().f7786a) {
                if (e6 != null) {
                    e6.r();
                    return;
                }
                return;
            } else {
                if (e6 != null) {
                    e6.c();
                    return;
                }
                return;
            }
        }
        File file2 = new File(c6);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        a aVar = new a(e6);
        try {
            if (cVar.f().f7786a && e6 != null) {
                e6.r();
            }
            e(file, file2, aVar, cVar);
            if (cVar.f().f7786a) {
                if (e6 != null) {
                    e6.r();
                }
            } else if (e6 != null) {
                e6.b(cVar.d());
            }
        } catch (Throwable unused) {
            if (cVar.f().f7786a) {
                if (e6 != null) {
                    e6.r();
                }
            } else if (e6 != null) {
                e6.c();
            }
        }
    }

    private static void e(File file, File file2, d dVar, c cVar) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        b f6 = cVar.f();
        long j6 = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
            ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (f6 != null && f6.f7786a) {
                        zipInputStream.closeEntry();
                        zipInputStream.close();
                        checkedInputStream.close();
                        fileInputStream.close();
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        if (!g(nextEntry.getName())) {
                            dVar.a();
                            break;
                        } else {
                            stringBuffer.append(nextEntry.getName());
                            stringBuffer.append(";");
                        }
                    }
                    j6 += nextEntry.getSize();
                    zipInputStream.closeEntry();
                } else {
                    break;
                }
            }
            cVar.b(stringBuffer.toString());
            zipInputStream.close();
            checkedInputStream.close();
            fileInputStream.close();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        long j7 = j6;
        FileInputStream fileInputStream2 = new FileInputStream(file);
        CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream2, new CRC32());
        ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream2);
        f(file2, zipInputStream2, j7, dVar, f6);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    private static boolean g(String str) {
        return (str.contains("..") || str.contains("/") || str.contains("\\") || str.contains("%")) ? false : true;
    }

    public final void b() {
        c cVar = this.f7784a;
        if (cVar != null) {
            cVar.g();
        }
    }

    public final void h() {
        c cVar = this.f7784a;
        if (cVar != null) {
            c(cVar);
        }
    }

    public z0(w0 w0Var, v0 v0Var) {
        this.f7784a = new c(w0Var, v0Var);
    }

    private static void d(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            d(parentFile);
            parentFile.mkdir();
        }
    }
}
