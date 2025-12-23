package com.bytedance.adsdk.lottie.cw;

import android.util.Pair;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes3.dex */
public class ae {

    /* renamed from: j, reason: collision with root package name */
    private final up f23220j;

    @WorkerThread
    Pair<cw, InputStream> j(String str) {
        try {
            File xt = xt(str);
            if (xt == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(xt);
            cw cwVar = xt.getAbsolutePath().endsWith(".zip") ? cw.ZIP : cw.JSON;
            com.bytedance.adsdk.lottie.up.up.j("Cache hit for " + str + " at " + xt.getAbsolutePath());
            return new Pair<>(cwVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    private File xt(String str) throws FileNotFoundException {
        File file = new File(j(), j(str, cw.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(j(), j(str, cw.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public ae(up upVar) {
        this.f23220j = upVar;
    }

    File j(String str, InputStream inputStream, cw cwVar) throws IOException {
        File file = new File(j(), j(str, cwVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }

    void j(String str, cw cwVar) {
        File file = new File(j(), j(str, cwVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        com.bytedance.adsdk.lottie.up.up.j("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        com.bytedance.adsdk.lottie.up.up.xt("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    private File j() {
        File j6 = this.f23220j.j();
        if (j6.isFile()) {
            j6.delete();
        }
        if (!j6.exists()) {
            j6.mkdirs();
        }
        return j6;
    }

    private static String j(String str, cw cwVar, boolean z5) {
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z5 ? cwVar.j() : cwVar.cw);
        return sb.toString();
    }
}
