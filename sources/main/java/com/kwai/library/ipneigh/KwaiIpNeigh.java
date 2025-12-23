package com.kwai.library.ipneigh;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class KwaiIpNeigh {
    private static final String TAG = "KwaiIpNeigh";

    private static boolean aC(String str, String str2) {
        if (str == null) {
            return false;
        }
        String[] split = str.split("\\s+");
        if (split.length < 2) {
            return false;
        }
        return split[0].equals(str2);
    }

    private static native int getARPTableFromJni(int i6);

    private static native int getARPTableFromJni2(int i6);

    static {
        System.loadLibrary("ipneigh-android");
    }

    KwaiIpNeigh() {
    }

    public static String i(String str, boolean z5) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream;
        int aRPTableFromJni;
        String readLine;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
            ParcelFileDescriptor parcelFileDescriptor2 = createPipe[1];
            autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            int detachFd = parcelFileDescriptor2.detachFd();
            if (z5) {
                aRPTableFromJni = getARPTableFromJni2(detachFd);
            } else {
                aRPTableFromJni = getARPTableFromJni(detachFd);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            th.getMessage();
        }
        if (aRPTableFromJni != 0) {
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(autoCloseInputStream, StandardCharsets.UTF_8));
        do {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                return "";
            }
        } while (!aC(readLine, str));
        return readLine;
    }
}
