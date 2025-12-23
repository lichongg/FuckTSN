package x4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Hashtable<String, b> f54759a = new Hashtable<>();

    /* renamed from: b, reason: collision with root package name */
    private String f54760b;

    /* renamed from: c, reason: collision with root package name */
    private b f54761c;

    public synchronized void d(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String[] split = readLine.split(" ");
                            if (split.length == 2) {
                                b bVar = new b();
                                bVar.f54760b = split[1];
                                g(split[0], bVar);
                            }
                        } else {
                            inputStreamReader.close();
                            bufferedReader.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    public synchronized void e(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String[] split = readLine.split(" ");
                            if (split.length == 2) {
                                int i6 = 0;
                                String str = split[0];
                                String str2 = split[1];
                                char[] charArray = str.toCharArray();
                                b bVar = this;
                                while (true) {
                                    if (i6 >= charArray.length) {
                                        break;
                                    }
                                    String upperCase = Integer.toHexString(charArray[i6]).toUpperCase();
                                    b a6 = bVar.a(upperCase);
                                    if (a6 == null) {
                                        bVar.g(upperCase, new b());
                                        a6 = bVar.a(upperCase);
                                    }
                                    b b6 = a6.b();
                                    if (charArray.length - 1 == i6) {
                                        a6.f54760b = str2;
                                        break;
                                    }
                                    if (b6 != null) {
                                        bVar = b6;
                                    } else if (charArray.length - 1 != i6) {
                                        bVar = new b();
                                        a6.h(bVar);
                                        bVar.g(Integer.toHexString(charArray[i6 + 1]).toUpperCase(), new b());
                                    }
                                    i6++;
                                }
                            }
                        } else {
                            inputStreamReader.close();
                            bufferedReader.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader == null) {
                            throw th;
                        }
                        bufferedReader.close();
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    public b a(String str) {
        return this.f54759a.get(str);
    }

    public b b() {
        return this.f54761c;
    }

    public String c() {
        return this.f54760b;
    }

    public void f() throws IOException {
        String str = a.f54758a;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                e(new FileInputStream(file));
            }
        }
    }

    public void g(String str, b bVar) {
        this.f54759a.put(str, bVar);
    }

    public void h(b bVar) {
        this.f54761c = bVar;
    }

    public void i(String str) {
        this.f54760b = str;
    }
}
