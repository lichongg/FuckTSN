package com.bytedance.pangle.m;

import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static boolean j(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = exec.getErrorStream();
            InputStream inputStream = exec.getInputStream();
            j(errorStream);
            j(inputStream);
            if (exec.waitFor() == 0) {
                return true;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + Arrays.toString(strArr));
            return false;
        } catch (IOException e6) {
            com.bytedance.sdk.openadsdk.api.m.j(e6);
            return false;
        } catch (InterruptedException e7) {
            com.bytedance.sdk.openadsdk.api.m.j(e7);
            return false;
        }
    }

    private static void j(final InputStream inputStream) {
        com.bytedance.pangle.up.up.xt(new Runnable() { // from class: com.bytedance.pangle.m.j.1
            @Override // java.lang.Runnable
            public void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return;
                        } else {
                            ZeusLogger.d(ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(readLine));
                        }
                    } catch (IOException e6) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e6)));
                        return;
                    } finally {
                        com.bytedance.pangle.util.ae.j(bufferedReader);
                    }
                }
            }
        });
    }
}
