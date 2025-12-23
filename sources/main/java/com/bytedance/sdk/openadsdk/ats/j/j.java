package com.bytedance.sdk.openadsdk.ats.j;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.bytedance.sdk.component.r.up;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements up {
    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(5)
    public void j(String str, String str2) {
    }

    @SuppressLint({"[ByDesign12.1]UsingRuntimeExec"})
    private String up(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Process process;
        try {
            process = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            process = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (IOException e6) {
                vl.cw("SystemPropAdb", "Exception while closing InputStream", e6);
            }
            try {
                process.destroy();
            } catch (Throwable unused) {
            }
            return readLine;
        } catch (Throwable th4) {
            th = th4;
            try {
                vl.cw("SystemPropAdb", "Unable to read sysprop ".concat(String.valueOf(str)), th);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                        vl.cw("SystemPropAdb", "Exception while closing InputStream", e7);
                    }
                }
                if (process == null) {
                    return "";
                }
                try {
                    process.destroy();
                    return "";
                } catch (Throwable unused2) {
                    return "";
                }
            } finally {
            }
        }
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(1)
    public String j(String str) {
        return up(str);
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(3)
    public long cw(String str) {
        String up = up(str);
        if (!TextUtils.isEmpty(up)) {
            try {
                return Long.parseLong(up);
            } catch (Exception unused) {
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(4)
    public boolean r(String str) {
        String up = up(str);
        if (!TextUtils.isEmpty(up)) {
            try {
                return Boolean.parseBoolean(up);
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(2)
    public int xt(String str) {
        String up = up(str);
        if (!TextUtils.isEmpty(up)) {
            try {
                return Integer.parseInt(up);
            } catch (Exception unused) {
                return 0;
            }
        }
        return 0;
    }
}
