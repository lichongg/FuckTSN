package com.acse.ottn;

import android.content.Context;
import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e2 {

    /* renamed from: c, reason: collision with root package name */
    public static e2 f4500c;

    /* renamed from: d, reason: collision with root package name */
    public static String f4501d;

    /* renamed from: a, reason: collision with root package name */
    public a f4502a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f4503b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public Process f4504a;

        /* renamed from: b, reason: collision with root package name */
        public BufferedReader f4505b = null;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4506c = true;

        /* renamed from: d, reason: collision with root package name */
        public String f4507d;

        /* renamed from: e, reason: collision with root package name */
        public String f4508e;

        /* renamed from: f, reason: collision with root package name */
        public FileOutputStream f4509f;

        public void a() {
            this.f4506c = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            String readLine;
            try {
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            try {
                try {
                    this.f4504a = Runtime.getRuntime().exec(this.f4507d);
                    this.f4505b = new BufferedReader(new InputStreamReader(this.f4504a.getInputStream()), 1024);
                    while (this.f4506c && (readLine = this.f4505b.readLine()) != null && this.f4506c) {
                        if (readLine.length() != 0 && this.f4509f != null && readLine.contains(this.f4508e)) {
                            this.f4509f.write((readLine + com.snail.antifake.deviceid.e.f37542d).getBytes());
                        }
                    }
                    Process process = this.f4504a;
                    if (process != null) {
                        process.destroy();
                        this.f4504a = null;
                    }
                    BufferedReader bufferedReader = this.f4505b;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            this.f4505b = null;
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    fileOutputStream = this.f4509f;
                } catch (IOException e8) {
                    e8.printStackTrace();
                    Process process2 = this.f4504a;
                    if (process2 != null) {
                        process2.destroy();
                        this.f4504a = null;
                    }
                    BufferedReader bufferedReader2 = this.f4505b;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            this.f4505b = null;
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    FileOutputStream fileOutputStream2 = this.f4509f;
                    if (fileOutputStream2 == null) {
                        return;
                    } else {
                        fileOutputStream2.close();
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    this.f4509f = null;
                }
            } catch (Throwable th) {
                Process process3 = this.f4504a;
                if (process3 != null) {
                    process3.destroy();
                    this.f4504a = null;
                }
                BufferedReader bufferedReader3 = this.f4505b;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                        this.f4505b = null;
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                FileOutputStream fileOutputStream3 = this.f4509f;
                if (fileOutputStream3 == null) {
                    throw th;
                }
                try {
                    fileOutputStream3.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
                this.f4509f = null;
                throw th;
            }
        }

        public a(String str, String str2) {
            this.f4507d = null;
            this.f4509f = null;
            this.f4508e = str;
            try {
                this.f4509f = new FileOutputStream(new File(str2, "log-" + e2.this.a() + ".log"));
            } catch (FileNotFoundException e6) {
                e6.printStackTrace();
            }
            this.f4507d = "logcat | grep \"(" + this.f4508e + ")\"";
        }
    }

    public static e2 a(Context context) {
        if (f4500c == null) {
            f4500c = new e2(context);
        }
        return f4500c;
    }

    public void b(Context context) {
        f4501d = context.getExternalFilesDir("log").getAbsoluteFile().getPath() + "/log";
        File file = new File(f4501d);
        if (!file.exists()) {
            file.mkdirs();
        }
        new File(f4501d).exists();
    }

    public void c() {
        a aVar = this.f4502a;
        if (aVar != null) {
            aVar.a();
            this.f4502a = null;
        }
    }

    public e2(Context context) {
        b(context);
        this.f4503b = Process.myPid();
    }

    public String a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    public void b() {
        if (this.f4502a == null) {
            this.f4502a = new a(String.valueOf(this.f4503b), f4501d);
        }
        this.f4502a.start();
    }
}
