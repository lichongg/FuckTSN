package com.kwai.library.ipneigh;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwai.library.ipneigh.a$a, reason: collision with other inner class name */
    static class C0715a extends Thread {
        private final InputStream bfk;

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            BufferedReader bufferedReader;
            Throwable th;
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(this.bfk));
                do {
                    try {
                    } catch (IOException unused) {
                        bufferedReader2 = bufferedReader;
                        a.closeQuietly(bufferedReader2);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        a.closeQuietly(bufferedReader);
                        throw th;
                    }
                } while (bufferedReader.readLine() != null);
                a.closeQuietly(bufferedReader);
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        }

        public C0715a(InputStream inputStream) {
            super("NoopStreamConsumer");
            this.bfk = inputStream;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface b<T> {
        T b(BufferedReader bufferedReader);
    }

    private static <T> T a(String str, b<T> bVar) {
        BufferedReader bufferedReader;
        Process exec;
        C0715a c0715a;
        Process process = null;
        try {
            exec = Runtime.getRuntime().exec(str);
            try {
                c0715a = new C0715a(exec.getErrorStream());
                c0715a.start();
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            T b6 = bVar.b(bufferedReader);
            c0715a.join();
            exec.waitFor();
            exec.destroy();
            closeQuietly(bufferedReader);
            return b6;
        } catch (Throwable th3) {
            th = th3;
            process = exec;
            if (process != null) {
                process.destroy();
            }
            closeQuietly(bufferedReader);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String hR(String str) {
        try {
            return (String) a(str, new b<String>() { // from class: com.kwai.library.ipneigh.a.1
                private static String a(BufferedReader bufferedReader) {
                    String readLine = bufferedReader.readLine();
                    while (bufferedReader.readLine() != null) {
                    }
                    return readLine;
                }

                @Override // com.kwai.library.ipneigh.a.b
                public final /* synthetic */ String b(BufferedReader bufferedReader) {
                    return a(bufferedReader);
                }
            });
        } catch (IOException | InterruptedException unused) {
            return null;
        }
    }
}
