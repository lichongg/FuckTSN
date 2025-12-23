package com.sun.activation.registries;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.StringTokenizer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f39171a;

    /* renamed from: b, reason: collision with root package name */
    private Hashtable f39172b;

    public f(String str) throws IOException {
        this.f39171a = null;
        this.f39172b = new Hashtable();
        this.f39171a = str;
        FileReader fileReader = new FileReader(new File(this.f39171a));
        try {
            d(new BufferedReader(fileReader));
        } finally {
            try {
                fileReader.close();
            } catch (IOException unused) {
            }
        }
    }

    private void d(BufferedReader bufferedReader) throws IOException {
        String str;
        String readLine;
        loop0: while (true) {
            str = null;
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break loop0;
                }
                if (str != null) {
                    readLine = str + readLine;
                }
                int length = readLine.length();
                if (readLine.length() > 0) {
                    int i6 = length - 1;
                    if (readLine.charAt(i6) == '\\') {
                        str = readLine.substring(0, i6);
                    }
                }
            }
            e(readLine);
        }
        if (str != null) {
            e(str);
        }
    }

    public void a(String str) {
        try {
            d(new BufferedReader(new StringReader(str)));
        } catch (IOException unused) {
        }
    }

    public e c(String str) {
        return (e) this.f39172b.get(str);
    }

    private void e(String str) {
        String str2;
        String trim = str.trim();
        if (trim.length() != 0 && trim.charAt(0) != '#') {
            if (trim.indexOf(61) > 0) {
                a aVar = new a(trim);
                String str3 = null;
                while (aVar.a()) {
                    String b6 = aVar.b();
                    if (aVar.a() && aVar.b().equals(ContainerUtils.KEY_VALUE_DELIMITER) && aVar.a()) {
                        str2 = aVar.b();
                    } else {
                        str2 = null;
                    }
                    if (str2 == null) {
                        if (b.a()) {
                            b.b("Bad .mime.types entry: " + trim);
                            return;
                        }
                        return;
                    }
                    if (b6.equals("type")) {
                        str3 = str2;
                    } else if (b6.equals("exts")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(str2, ",");
                        while (stringTokenizer.hasMoreTokens()) {
                            String nextToken = stringTokenizer.nextToken();
                            e eVar = new e(str3, nextToken);
                            this.f39172b.put(nextToken, eVar);
                            if (b.a()) {
                                b.b("Added: " + eVar.toString());
                            }
                        }
                    }
                }
                return;
            }
            StringTokenizer stringTokenizer2 = new StringTokenizer(trim);
            if (stringTokenizer2.countTokens() != 0) {
                String nextToken2 = stringTokenizer2.nextToken();
                while (stringTokenizer2.hasMoreTokens()) {
                    String nextToken3 = stringTokenizer2.nextToken();
                    e eVar2 = new e(nextToken2, nextToken3);
                    this.f39172b.put(nextToken3, eVar2);
                    if (b.a()) {
                        b.b("Added: " + eVar2.toString());
                    }
                }
            }
        }
    }

    public String b(String str) {
        e c6 = c(str);
        if (c6 != null) {
            return c6.b();
        }
        return null;
    }

    public f(InputStream inputStream) throws IOException {
        this.f39171a = null;
        this.f39172b = new Hashtable();
        d(new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")));
    }

    public f() {
        this.f39171a = null;
        this.f39172b = new Hashtable();
    }
}
