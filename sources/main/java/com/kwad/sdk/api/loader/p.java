package com.kwad.sdk.api.loader;

import android.content.Context;
import com.umeng.socialize.bean.StatusCode;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p {
    public static int a(String str, InputStream inputStream, String str2) {
        try {
            boolean a6 = a(str, o.decrypt(str2.getBytes("UTF-8"), a(inputStream)));
            boolean a7 = a(inputStream, str, true);
            if (a6 && a7) {
                return 1;
            }
            if (a6) {
                return -104;
            }
            return StatusCode.ST_CODE_SDK_NORESPONSE;
        } catch (UnsupportedEncodingException unused) {
            return -102;
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String bb(Context context) {
        q Dp = r.Dp();
        if (Dp != null) {
            return Dp.getAESKey(context);
        }
        return null;
    }

    private static int f(byte[] bArr) {
        int i6 = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt();
        PrintStream printStream = System.out;
        Integer.toHexString(i6);
        printStream.getClass();
        return i6;
    }

    private static byte[] a(InputStream inputStream) {
        try {
            byte[] bArr = new byte[4];
            inputStream.read(bArr, 0, 4);
            int f6 = f(bArr);
            byte[] bArr2 = new byte[f6];
            if (inputStream.read(bArr2, 0, f6) > 0) {
                System.out.getClass();
                return bArr2;
            }
            System.out.getClass();
            return null;
        } catch (IOException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private static boolean a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                file.setWritable(true);
                file.setReadable(true);
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                    System.out.getClass();
                    closeQuietly(fileOutputStream2);
                    return true;
                } catch (IOException e6) {
                    e = e6;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    closeQuietly(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean a(InputStream inputStream, String str, boolean z5) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str, true);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            System.out.getClass();
                            closeQuietly(fileOutputStream2);
                            return true;
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    closeQuietly(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e7) {
            e = e7;
        }
    }
}
