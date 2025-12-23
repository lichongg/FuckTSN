package com.kwad.sdk.core.imageloader.utils;

import com.kwad.sdk.crash.utils.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class IoUtils {
    public static final int CONTINUE_LOADING_PERCENTAGE = 75;
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final int DEFAULT_IMAGE_TOTAL_SIZE = 512000;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CopyListener {
        boolean onBytesCopied(int i6, int i7);
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream, CopyListener copyListener) {
        return copyStream(inputStream, outputStream, copyListener, 32768);
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream, CopyListener copyListener, int i6) {
        int available = inputStream.available();
        if (available <= 0) {
            available = DEFAULT_IMAGE_TOTAL_SIZE;
        }
        byte[] bArr = new byte[i6];
        if (shouldStopLoading(copyListener, 0, available)) {
            return false;
        }
        int i7 = 0;
        do {
            int read = inputStream.read(bArr, 0, i6);
            if (read == -1) {
                outputStream.flush();
                return true;
            }
            outputStream.write(bArr, 0, read);
            i7 += read;
        } while (!shouldStopLoading(copyListener, i7, available));
        return false;
    }

    public static String inputStreamToString(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        char[] cArr = new char[1024];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            while (true) {
                try {
                    int read = inputStreamReader.read(cArr, 0, 1024);
                    if (read < 0) {
                        b.closeQuietly(inputStreamReader);
                        return sb.toString();
                    }
                    sb.append(cArr, 0, read);
                } catch (Exception unused) {
                    b.closeQuietly(inputStreamReader);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader2 = inputStreamReader;
                    b.closeQuietly(inputStreamReader2);
                    throw th;
                }
            }
        } catch (Exception unused2) {
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean shouldStopLoading(CopyListener copyListener, int i6, int i7) {
        return (copyListener == null || copyListener.onBytesCopied(i6, i7) || (i6 * 100) / i7 >= 75) ? false : true;
    }

    private IoUtils() {
    }

    public static void readAndCloseStream(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
                return;
            } finally {
                b.closeQuietly(inputStream);
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
    }
}
