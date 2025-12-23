package com.bytedance.j.xt.up;

import android.os.Build;
import com.bytedance.sdk.component.oq.r.cw;
import com.bytedance.sdk.component.utils.vl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class f {

    private static class a extends cw {

        /* renamed from: a, reason: collision with root package name */
        private InputStream f24252a;

        /* renamed from: b, reason: collision with root package name */
        private List<String> f24253b;

        a(InputStream inputStream, List<String> list) {
            super("LogcatDump$LogDumperThread");
            this.f24252a = inputStream;
            this.f24253b = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f24252a));
            int i6 = 32768;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (!readLine.startsWith("---------")) {
                            i6 -= readLine.getBytes("UTF-8").length;
                            if (i6 < 0) {
                                break;
                            } else {
                                this.f24253b.add(readLine);
                            }
                        }
                    } else {
                        break;
                    }
                } catch (IOException unused) {
                    return;
                } finally {
                    com.bytedance.j.xt.tl.h.a(bufferedReader);
                }
            }
        }
    }

    private static class b extends cw {

        /* renamed from: a, reason: collision with root package name */
        private Process f24254a;

        /* renamed from: b, reason: collision with root package name */
        private long f24255b;

        public b(Process process, long j6) {
            super("LogcatDump$TimerThread");
            this.f24254a = process;
            this.f24255b = j6;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(this.f24255b);
            } catch (InterruptedException e6) {
                vl.j(e6);
            }
            Process process = this.f24254a;
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static String a(int i6) {
        return (i6 < 0 || i6 >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i6];
    }

    public static List<String> b(int i6, int i7) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String[] strArr = {"logcat", "-t", String.valueOf(i6), a(i7)};
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            new a(exec.getInputStream(), copyOnWriteArrayList).start();
            new a(exec.getErrorStream(), copyOnWriteArrayList).start();
            new b(exec, 3000L).start();
            if (Build.VERSION.SDK_INT >= 26) {
                exec.waitFor(3000L, TimeUnit.MILLISECONDS);
            } else {
                exec.waitFor();
            }
            exec.destroy();
            return copyOnWriteArrayList;
        } catch (Throwable th) {
            try {
                vl.j(th);
                return copyOnWriteArrayList;
            } finally {
                if (0 != 0) {
                    process.destroy();
                }
            }
        }
    }
}
