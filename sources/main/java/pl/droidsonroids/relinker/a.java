package pl.droidsonroids.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import pl.droidsonroids.relinker.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a implements c.a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f51862a = 5;

    /* renamed from: b, reason: collision with root package name */
    private static final int f51863b = 4096;

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    @Override // pl.droidsonroids.relinker.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r11, java.lang.String[] r12, java.lang.String r13, java.io.File r14, pl.droidsonroids.relinker.d r15) {
        /*
            r10 = this;
            r0 = 0
            pl.droidsonroids.relinker.a$a r1 = r10.d(r11, r12, r13, r15)     // Catch: java.lang.Throwable -> La6
            if (r1 == 0) goto L92
            r11 = 0
            r12 = 0
        L9:
            int r2 = r12 + 1
            r3 = 5
            if (r12 >= r3) goto L87
            java.lang.String r12 = "Found %s! Extracting..."
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L26
            r4[r11] = r13     // Catch: java.lang.Throwable -> L26
            r15.m(r12, r4)     // Catch: java.lang.Throwable -> L26
            boolean r12 = r14.exists()     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L2a
            if (r12 != 0) goto L2d
            boolean r12 = r14.createNewFile()     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L2a
            if (r12 != 0) goto L2d
            goto L85
        L26:
            r11 = move-exception
            r0 = r1
            goto La7
        L2a:
            goto L85
        L2d:
            java.util.zip.ZipFile r12 = r1.f51864a     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L78 java.io.FileNotFoundException -> L7b
            java.util.zip.ZipEntry r4 = r1.f51865b     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L78 java.io.FileNotFoundException -> L7b
            java.io.InputStream r12 = r12.getInputStream(r4)     // Catch: java.lang.Throwable -> L75 java.io.IOException -> L78 java.io.FileNotFoundException -> L7b
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L71 java.io.FileNotFoundException -> L73
            r4.<init>(r14)     // Catch: java.lang.Throwable -> L6e java.io.IOException -> L71 java.io.FileNotFoundException -> L73
            long r5 = r10.c(r12, r4)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L6b
            java.io.FileDescriptor r7 = r4.getFD()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L6b
            r7.sync()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L6b
            long r7 = r14.length()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L6b
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L54
        L4d:
            r10.b(r12)     // Catch: java.lang.Throwable -> L26
            r10.b(r4)     // Catch: java.lang.Throwable -> L26
            goto L85
        L54:
            r10.b(r12)     // Catch: java.lang.Throwable -> L26
            r10.b(r4)     // Catch: java.lang.Throwable -> L26
            r14.setReadable(r3, r11)     // Catch: java.lang.Throwable -> L26
            r14.setExecutable(r3, r11)     // Catch: java.lang.Throwable -> L26
            r14.setWritable(r3)     // Catch: java.lang.Throwable -> L26
            java.util.zip.ZipFile r11 = r1.f51864a     // Catch: java.io.IOException -> L91
            if (r11 == 0) goto L91
        L67:
            r11.close()     // Catch: java.io.IOException -> L91
            goto L91
        L6b:
            r11 = move-exception
        L6c:
            r0 = r12
            goto L7e
        L6e:
            r11 = move-exception
            r4 = r0
            goto L6c
        L71:
            r4 = r0
            goto L4d
        L73:
            r4 = r0
            goto L4d
        L75:
            r11 = move-exception
            r4 = r0
            goto L7e
        L78:
            r12 = r0
            r4 = r12
            goto L4d
        L7b:
            r12 = r0
            r4 = r12
            goto L4d
        L7e:
            r10.b(r0)     // Catch: java.lang.Throwable -> L26
            r10.b(r4)     // Catch: java.lang.Throwable -> L26
            throw r11     // Catch: java.lang.Throwable -> L26
        L85:
            r12 = r2
            goto L9
        L87:
            java.lang.String r11 = "FATAL! Couldn't extract the library from the APK!"
            r15.l(r11)     // Catch: java.lang.Throwable -> L26
            java.util.zip.ZipFile r11 = r1.f51864a     // Catch: java.io.IOException -> L91
            if (r11 == 0) goto L91
            goto L67
        L91:
            return
        L92:
            java.lang.String[] r11 = r10.e(r11, r13)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L97
            goto La0
        L97:
            r11 = move-exception
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L26
            java.lang.String[] r11 = new java.lang.String[]{r11}     // Catch: java.lang.Throwable -> L26
        La0:
            pl.droidsonroids.relinker.MissingLibraryException r14 = new pl.droidsonroids.relinker.MissingLibraryException     // Catch: java.lang.Throwable -> L26
            r14.<init>(r13, r12, r11)     // Catch: java.lang.Throwable -> L26
            throw r14     // Catch: java.lang.Throwable -> L26
        La6:
            r11 = move-exception
        La7:
            if (r0 == 0) goto Lb0
            java.util.zip.ZipFile r12 = r0.f51864a     // Catch: java.io.IOException -> Lb0
            if (r12 == 0) goto Lb0
            r12.close()     // Catch: java.io.IOException -> Lb0
        Lb0:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.relinker.a.a(android.content.Context, java.lang.String[], java.lang.String, java.io.File, pl.droidsonroids.relinker.d):void");
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: pl.droidsonroids.relinker.a$a, reason: collision with other inner class name */
    private static class C1000a {

        /* renamed from: a, reason: collision with root package name */
        public ZipFile f51864a;

        /* renamed from: b, reason: collision with root package name */
        public ZipEntry f51865b;

        public C1000a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f51864a = zipFile;
            this.f51865b = zipEntry;
        }
    }

    private void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private long c(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j6 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j6;
            }
            outputStream.write(bArr, 0, read);
            j6 += read;
        }
    }

    private C1000a d(Context context, String[] strArr, String str, d dVar) {
        String[] f6 = f(context);
        int length = f6.length;
        char c6 = 0;
        int i6 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i6 >= length) {
                return null;
            }
            String str2 = f6[i6];
            int i7 = 0;
            while (true) {
                int i8 = i7 + 1;
                if (i7 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i7 = i8;
                }
            }
            if (zipFile != null) {
                int i9 = 0;
                while (true) {
                    int i10 = i9 + 1;
                    if (i9 < 5) {
                        int length2 = strArr.length;
                        int i11 = 0;
                        while (i11 < length2) {
                            String str3 = strArr[i11];
                            StringBuilder sb = new StringBuilder();
                            sb.append("lib");
                            char c7 = File.separatorChar;
                            sb.append(c7);
                            sb.append(str3);
                            sb.append(c7);
                            sb.append(str);
                            String sb2 = sb.toString();
                            Object[] objArr = new Object[2];
                            objArr[c6] = sb2;
                            objArr[1] = str2;
                            dVar.m("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(sb2);
                            if (entry != null) {
                                return new C1000a(zipFile, entry);
                            }
                            i11++;
                            c6 = 0;
                        }
                        i9 = i10;
                        c6 = 0;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i6++;
            c6 = 0;
        }
    }

    private String[] e(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("lib");
        char c6 = File.separatorChar;
        sb.append(c6);
        sb.append("([^\\");
        sb.append(c6);
        sb.append("]*)");
        sb.append(c6);
        sb.append(str);
        Pattern compile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : f(context)) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(new File(str2), 1).entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private String[] f(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null && strArr.length != 0) {
            String[] strArr2 = new String[strArr.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
            return strArr2;
        }
        return new String[]{applicationInfo.sourceDir};
    }
}
