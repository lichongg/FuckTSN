package ms.bz.bd.c.Pgl;

import android.content.res.AssetManager;
import com.bytedance.sdk.component.utils.vl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class s0 extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object b(long j6, String str, Object obj) throws Throwable {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        String str2 = str;
        AssetManager assets = pblv.a().c().getAssets();
        if (!str2.startsWith((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "31170c", new byte[]{108}))) {
            str2 = ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c9bff5", new byte[]{60})) + str2;
        }
        String str3 = str2;
        String[] list = assets.list("");
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.length; i6++) {
            if (list[i6].endsWith(str3)) {
                String str4 = list[i6];
                String absolutePath = File.createTempFile((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "91ba27", new byte[]{37, 32, 20, 13, 25}), "").getAbsolutePath();
                FileOutputStream fileOutputStream2 = null;
                try {
                    inputStream = assets.open(str4);
                } catch (IOException e6) {
                    e = e6;
                    inputStream = null;
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                }
                try {
                    try {
                        fileOutputStream = new FileOutputStream(absolutePath);
                        try {
                            byte[] bArr = new byte[256];
                            long j7 = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                j7 += read;
                            }
                            fileOutputStream.flush();
                            if (j7 > 0) {
                                arrayList.add(absolutePath);
                            }
                            pbln.a(inputStream);
                            pbln.a(fileOutputStream);
                        } catch (IOException e7) {
                            e = e7;
                            fileOutputStream2 = fileOutputStream;
                            vl.j(e);
                            pbln.a(inputStream);
                            pbln.a(fileOutputStream2);
                        } catch (Throwable th2) {
                            th = th2;
                            pbln.a(inputStream);
                            pbln.a(fileOutputStream);
                            throw th;
                        }
                    } catch (IOException e8) {
                        e = e8;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    pbln.a(inputStream);
                    pbln.a(fileOutputStream);
                    throw th;
                }
            }
        }
        return arrayList.toArray(new String[0]);
    }

    s0() {
    }
}
