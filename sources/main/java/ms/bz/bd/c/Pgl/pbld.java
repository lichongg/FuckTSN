package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import ms.bz.bd.c.Pgl.e1;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pbld implements e1.pgla {
    public final void b(Context context, String[] strArr, String str, File file, g1 g1Var) {
        pgla a6;
        String[] strArr2;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        pgla pglaVar = null;
        r0 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            a6 = a(context, strArr, str, g1Var);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (a6 == null) {
                try {
                    strArr2 = d(context, str);
                } catch (Exception e6) {
                    strArr2 = new String[]{e6.toString()};
                }
                throw new y0(str, strArr, strArr2);
            }
            int i6 = 0;
            while (true) {
                int i7 = i6 + 1;
                try {
                    if (i6 < 5) {
                        g1Var.getClass();
                        String.format(Locale.US, "Found %s! Extracting...", str);
                        try {
                            if (file.exists() || file.createNewFile()) {
                                try {
                                    inputStream = a6.f50322a.getInputStream(a6.f50323b);
                                } catch (FileNotFoundException | IOException unused) {
                                    inputStream = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = null;
                                }
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                } catch (FileNotFoundException | IOException unused2) {
                                    fileOutputStream = null;
                                    c(inputStream);
                                    c(fileOutputStream);
                                    i6 = i7;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                                try {
                                    try {
                                        byte[] bArr = new byte[4096];
                                        long j6 = 0;
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                            j6 += read;
                                        }
                                        fileOutputStream.flush();
                                        fileOutputStream.getFD().sync();
                                        if (j6 != file.length()) {
                                            c(inputStream);
                                            c(fileOutputStream);
                                        } else {
                                            c(inputStream);
                                            c(fileOutputStream);
                                            file.setReadable(true, false);
                                            file.setExecutable(true, false);
                                            file.setWritable(true);
                                            ZipFile zipFile = a6.f50322a;
                                            if (zipFile != null) {
                                                zipFile.close();
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        fileOutputStream2 = fileOutputStream;
                                        c(inputStream);
                                        c(fileOutputStream2);
                                        throw th;
                                    }
                                } catch (FileNotFoundException | IOException unused3) {
                                    c(inputStream);
                                    c(fileOutputStream);
                                    i6 = i7;
                                }
                            }
                        } catch (IOException unused4) {
                        }
                        i6 = i7;
                    } else {
                        g1Var.getClass();
                        ZipFile zipFile2 = a6.f50322a;
                        if (zipFile2 != null) {
                            zipFile2.close();
                        }
                    }
                } catch (IOException unused5) {
                    return;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            pglaVar = a6;
            if (pglaVar != null) {
                try {
                    ZipFile zipFile3 = pglaVar.f50322a;
                    if (zipFile3 != null) {
                        zipFile3.close();
                    }
                } catch (IOException unused6) {
                }
            }
            throw th;
        }
    }

    private static class pgla {

        /* renamed from: a, reason: collision with root package name */
        public ZipFile f50322a;

        /* renamed from: b, reason: collision with root package name */
        public ZipEntry f50323b;

        public pgla(ZipFile zipFile, ZipEntry zipEntry) {
            this.f50322a = zipFile;
            this.f50323b = zipEntry;
        }
    }

    private static pgla a(Context context, String[] strArr, String str, g1 g1Var) {
        String[] strArr2;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr3 = applicationInfo.splitSourceDirs;
        char c6 = 0;
        if (strArr3 == null || strArr3.length == 0) {
            strArr2 = new String[]{applicationInfo.sourceDir};
        } else {
            strArr2 = new String[strArr3.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr3, 0, strArr2, 1, strArr3.length);
        }
        int length = strArr2.length;
        int i6 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i6 >= length) {
                return null;
            }
            String str2 = strArr2[i6];
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
                            StringBuilder sb = new StringBuilder("lib");
                            char c7 = File.separatorChar;
                            sb.append(c7);
                            sb.append(str3);
                            sb.append(c7);
                            sb.append(str);
                            String sb2 = sb.toString();
                            Object[] objArr = new Object[2];
                            objArr[c6] = sb2;
                            objArr[1] = str2;
                            g1Var.getClass();
                            String.format(Locale.US, "Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(sb2);
                            if (entry != null) {
                                return new pgla(zipFile, entry);
                            }
                            i11++;
                            c6 = 0;
                        }
                        i9 = i10;
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

    private static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static String[] d(Context context, String str) {
        String[] strArr;
        StringBuilder sb = new StringBuilder("lib");
        char c6 = File.separatorChar;
        sb.append(c6);
        sb.append("([^\\");
        sb.append(c6);
        sb.append("]*)");
        sb.append(c6);
        sb.append(str);
        Pattern compile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr2 = applicationInfo.splitSourceDirs;
        if (strArr2 == null || strArr2.length == 0) {
            strArr = new String[]{applicationInfo.sourceDir};
        } else {
            strArr = new String[strArr2.length + 1];
            strArr[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr2, 0, strArr, 1, strArr2.length);
        }
        ZipFile zipFile = null;
        for (String str2 : strArr) {
            try {
                ZipFile zipFile2 = new ZipFile(new File(str2), 1);
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
                zipFile = zipFile2;
            } catch (IOException unused) {
            }
        }
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused2) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }
}
