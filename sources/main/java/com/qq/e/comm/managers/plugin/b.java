package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class b {
    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    static void a(Context context, File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        String str;
        boolean z5;
        AssetManager assets = context.getAssets();
        InputStream inputStream2 = null;
        try {
            String[] list = assets.list(h.a());
            if (Arrays.binarySearch(list, h.b()) < 0) {
                if (list != null && list.length > 0) {
                    str = TextUtils.join(",", list);
                    String str2 = "Asset Error " + str;
                    GDTLogger.e(str2);
                    throw new Exception(str2);
                }
                str = "no asset";
                String str22 = "Asset Error " + str;
                GDTLogger.e(str22);
                throw new Exception(str22);
            }
            String str3 = h.a() + File.separator + h.b();
            String str4 = Sig.ASSET_PLUGIN_SIG;
            if (str4 == null) {
                str4 = "";
            }
            h.a(context);
            h.a(SDKStatus.getBuildInPluginVersion() + "#####" + str4, file2);
            if (TextUtils.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                z5 = h.a(assets.open(str3), file);
                fileOutputStream = null;
            } else {
                inputStream = assets.open(str3);
                try {
                    if (!file.canWrite()) {
                        file.setWritable(true);
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                    inputStream2 = inputStream;
                    inputStream = inputStream2;
                    try {
                        GDTLogger.e("插件加载失败", th);
                        throw th;
                    } finally {
                        a(inputStream);
                        a(fileOutputStream);
                    }
                }
                try {
                    byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
                    byte[] bArr = new byte[1024];
                    int length = bytes.length;
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        int i8 = 0;
                        while (i8 < read) {
                            int i9 = i7 + 1;
                            if (i7 >= 64) {
                                bArr[i8] = (byte) (bytes[i6 % length] ^ bArr[i8]);
                                i6++;
                            }
                            i8++;
                            i7 = i9;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    inputStream2 = inputStream;
                    z5 = true;
                } catch (Throwable th2) {
                    th = th2;
                    GDTLogger.e("插件加载失败", th);
                    throw th;
                }
            }
            if (z5) {
                try {
                    z5 = h.a(file, context);
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                    GDTLogger.e("插件加载失败", th);
                    throw th;
                }
            }
            if (!z5) {
                throw new Exception("Plugin prepare failed");
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }
}
