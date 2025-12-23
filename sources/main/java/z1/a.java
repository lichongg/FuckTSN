package z1;

import android.app.backup.BackupDataInputStream;
import android.text.TextUtils;
import d2.f;
import d2.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f56788a = 8192;

    /* renamed from: c, reason: collision with root package name */
    private static final String f56790c = "FileSHA256";

    /* renamed from: d, reason: collision with root package name */
    private static final String f56791d = "";

    /* renamed from: b, reason: collision with root package name */
    private static final String f56789b = "SHA-256";

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f56792e = {f56789b, "SHA-384", "SHA-512"};

    private static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    private static boolean b(String str) {
        for (String str2 : f56792e) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String c(File file) {
        return d(file, f56789b);
    }

    public static String e(InputStream inputStream) {
        return inputStream == null ? "" : f(inputStream, f56789b);
    }

    public static String f(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[8192];
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read < 0) {
                        String b6 = d2.c.b(messageDigest.digest());
                        f.g(inputStream);
                        return b6;
                    }
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    }
                }
            } catch (IOException | NoSuchAlgorithmException unused) {
                g.d(f56790c, "inputstraem exception");
                f.g(inputStream);
                return "";
            }
        } catch (Throwable th) {
            f.g(inputStream);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String d(File file, String str) {
        FileInputStream fileInputStream;
        if (!TextUtils.isEmpty(str) && b(str)) {
            if (!a(file)) {
                g.d(f56790c, "file is not valid");
                return "";
            }
            BackupDataInputStream backupDataInputStream = 0;
            String str2 = null;
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(str);
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[8192];
                        boolean z5 = false;
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                            z5 = true;
                        }
                        if (z5) {
                            str2 = d2.c.b(messageDigest.digest());
                        }
                        f.g(fileInputStream);
                        return str2;
                    } catch (IOException e6) {
                        e = e6;
                        g.d(f56790c, "IOException" + e.getMessage());
                        f.g(fileInputStream);
                        return null;
                    } catch (NoSuchAlgorithmException e7) {
                        e = e7;
                        g.d(f56790c, "NoSuchAlgorithmException" + e.getMessage());
                        f.g(fileInputStream);
                        return null;
                    }
                } catch (IOException e8) {
                    e = e8;
                    fileInputStream = null;
                } catch (NoSuchAlgorithmException e9) {
                    e = e9;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    f.g(backupDataInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                backupDataInputStream = "";
                f.g(backupDataInputStream);
                throw th;
            }
        } else {
            g.d(f56790c, "algorithm is empty or not safe");
            return "";
        }
    }

    public static boolean g(File file, String str, String str2) {
        if (!TextUtils.isEmpty(str) && b(str2)) {
            return str.equals(d(file, str2));
        }
        g.d(f56790c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean h(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(c(file));
    }

    public static boolean i(InputStream inputStream, String str, String str2) {
        if (!TextUtils.isEmpty(str) && b(str2)) {
            return str.equals(f(inputStream, str2));
        }
        g.d(f56790c, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean j(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(e(inputStream));
    }
}
