package com.sun.activation.registries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f39151d;

    /* renamed from: a, reason: collision with root package name */
    private Map f39152a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map f39153b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Map f39154c = new HashMap();

    public c(String str) throws IOException {
        FileReader fileReader;
        if (b.a()) {
            b.b("new MailcapFile: file " + str);
        }
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            g(new BufferedReader(fileReader));
            try {
                fileReader.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader2 = fileReader;
            if (fileReader2 != null) {
                try {
                    fileReader2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    static {
        try {
            f39151d = Boolean.getBoolean("javax.activation.addreverse");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
    
        h(r1 + r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(java.io.Reader r7) throws java.io.IOException {
        /*
            r6 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r0.<init>(r7)
            r7 = 0
        L6:
            r1 = r7
        L7:
            java.lang.String r2 = r0.readLine()
            if (r2 != 0) goto Le
            return
        Le:
            java.lang.String r2 = r2.trim()
            r3 = 0
            char r4 = r2.charAt(r3)     // Catch: java.lang.Throwable -> L66
            r5 = 35
            if (r4 != r5) goto L1c
            goto L7
        L1c:
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L66
            int r4 = r4 + (-1)
            char r4 = r2.charAt(r4)     // Catch: java.lang.Throwable -> L66
            r5 = 92
            if (r4 != r5) goto L4e
            if (r1 == 0) goto L43
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L66
            int r5 = r2.length()     // Catch: java.lang.Throwable -> L66
            int r5 = r5 + (-1)
            java.lang.String r2 = r2.substring(r3, r5)     // Catch: java.lang.Throwable -> L66
            r4.append(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L66
            goto L7
        L43:
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L66
            int r4 = r4 + (-1)
            java.lang.String r1 = r2.substring(r3, r4)     // Catch: java.lang.Throwable -> L66
            goto L7
        L4e:
            if (r1 == 0) goto L62
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L66
            r3.append(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L66
            r6.h(r1)     // Catch: com.sun.activation.registries.MailcapParseException -> L60 java.lang.Throwable -> L66
            goto L6
        L60:
            goto L6
        L62:
            r6.h(r2)     // Catch: java.lang.Throwable -> L66
            goto L7
        L66:
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.activation.registries.c.g(java.io.Reader):void");
    }

    protected static void j(int i6, int i7, int i8, String str) throws MailcapParseException {
        throw new MailcapParseException("Encountered a " + d.h(i8) + " token (" + str + ") while expecting a " + d.h(i6) + " or a " + d.h(i7) + " token.");
    }

    protected static void k(int i6, int i7, String str) throws MailcapParseException {
        throw new MailcapParseException("Encountered a " + d.h(i7) + " token (" + str + ") while expecting a " + d.h(i6) + " token.");
    }

    public Map b(String str) {
        Map map = (Map) this.f39153b.get(str);
        int indexOf = str.indexOf(47) + 1;
        if (!str.substring(indexOf).equals("*")) {
            Map map2 = (Map) this.f39153b.get(String.valueOf(str.substring(0, indexOf)) + "*");
            if (map2 != null) {
                return map != null ? f(map, map2) : map2;
            }
        }
        return map;
    }

    public Map c(String str) {
        Map map = (Map) this.f39152a.get(str);
        int indexOf = str.indexOf(47) + 1;
        if (!str.substring(indexOf).equals("*")) {
            Map map2 = (Map) this.f39152a.get(String.valueOf(str.substring(0, indexOf)) + "*");
            if (map2 != null) {
                return map != null ? f(map, map2) : map2;
            }
        }
        return map;
    }

    public String[] d() {
        HashSet hashSet = new HashSet(this.f39152a.keySet());
        hashSet.addAll(this.f39153b.keySet());
        hashSet.addAll(this.f39154c.keySet());
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public String[] e(String str) {
        List list = (List) this.f39154c.get(str.toLowerCase(Locale.ENGLISH));
        if (list != null) {
            return (String[]) list.toArray(new String[list.size()]);
        }
        return null;
    }

    protected void h(String str) throws MailcapParseException, IOException {
        String str2;
        int i6;
        d dVar = new d(str);
        dVar.l(false);
        if (b.a()) {
            b.b("parse: " + str);
        }
        int i7 = dVar.i();
        if (i7 != 2) {
            k(2, i7, dVar.c());
        }
        String c6 = dVar.c();
        Locale locale = Locale.ENGLISH;
        String lowerCase = c6.toLowerCase(locale);
        int i8 = dVar.i();
        if (i8 != 47 && i8 != 59) {
            j(47, 59, i8, dVar.c());
        }
        if (i8 == 47) {
            int i9 = dVar.i();
            if (i9 != 2) {
                k(2, i9, dVar.c());
            }
            str2 = dVar.c().toLowerCase(locale);
            i8 = dVar.i();
        } else {
            str2 = "*";
        }
        String str3 = String.valueOf(lowerCase) + "/" + str2;
        if (b.a()) {
            b.b("  Type: " + str3);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (i8 != 59) {
            k(59, i8, dVar.c());
        }
        dVar.l(true);
        int i10 = dVar.i();
        dVar.l(false);
        if (i10 != 2 && i10 != 59) {
            j(2, 59, i10, dVar.c());
        }
        if (i10 == 2) {
            List list = (List) this.f39154c.get(str3);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                this.f39154c.put(str3, arrayList);
            } else {
                list.add(str);
            }
        }
        if (i10 != 59) {
            i10 = dVar.i();
        }
        if (i10 != 59) {
            if (i10 != 5) {
                j(5, 59, i10, dVar.c());
                return;
            }
            return;
        }
        boolean z5 = false;
        do {
            int i11 = dVar.i();
            if (i11 != 2) {
                k(2, i11, dVar.c());
            }
            String lowerCase2 = dVar.c().toLowerCase(Locale.ENGLISH);
            i6 = dVar.i();
            if (i6 != 61 && i6 != 59 && i6 != 5) {
                i(61, 59, 5, i6, dVar.c());
            }
            if (i6 == 61) {
                dVar.l(true);
                int i12 = dVar.i();
                dVar.l(false);
                if (i12 != 2) {
                    k(2, i12, dVar.c());
                }
                String c7 = dVar.c();
                if (lowerCase2.startsWith("x-java-")) {
                    String substring = lowerCase2.substring(7);
                    if (substring.equals("fallback-entry") && c7.equalsIgnoreCase("true")) {
                        z5 = true;
                    } else {
                        if (b.a()) {
                            b.b("    Command: " + substring + ", Class: " + c7);
                        }
                        List list2 = (List) linkedHashMap.get(substring);
                        if (list2 == null) {
                            list2 = new ArrayList();
                            linkedHashMap.put(substring, list2);
                        }
                        if (f39151d) {
                            list2.add(0, c7);
                        } else {
                            list2.add(c7);
                        }
                    }
                }
                i6 = dVar.i();
            }
        } while (i6 == 59);
        Map map = z5 ? this.f39153b : this.f39152a;
        Map map2 = (Map) map.get(str3);
        if (map2 == null) {
            map.put(str3, linkedHashMap);
            return;
        }
        if (b.a()) {
            b.b("Merging commands for type " + str3);
        }
        for (String str4 : map2.keySet()) {
            List list3 = (List) map2.get(str4);
            List<String> list4 = (List) linkedHashMap.get(str4);
            if (list4 != null) {
                for (String str5 : list4) {
                    if (!list3.contains(str5)) {
                        if (f39151d) {
                            list3.add(0, str5);
                        } else {
                            list3.add(str5);
                        }
                    }
                }
            }
        }
        for (String str6 : linkedHashMap.keySet()) {
            if (!map2.containsKey(str6)) {
                map2.put(str6, (List) linkedHashMap.get(str6));
            }
        }
    }

    private Map f(Map map, Map map2) {
        HashMap hashMap = new HashMap(map);
        for (String str : map2.keySet()) {
            List list = (List) hashMap.get(str);
            if (list == null) {
                hashMap.put(str, map2.get(str));
            } else {
                List list2 = (List) map2.get(str);
                ArrayList arrayList = new ArrayList(list);
                arrayList.addAll(list2);
                hashMap.put(str, arrayList);
            }
        }
        return hashMap;
    }

    protected static void i(int i6, int i7, int i8, int i9, String str) throws MailcapParseException {
        if (b.a()) {
            b.b("PARSE ERROR: Encountered a " + d.h(i9) + " token (" + str + ") while expecting a " + d.h(i6) + ", a " + d.h(i7) + ", or a " + d.h(i8) + " token.");
        }
        throw new MailcapParseException("Encountered a " + d.h(i9) + " token (" + str + ") while expecting a " + d.h(i6) + ", a " + d.h(i7) + ", or a " + d.h(i8) + " token.");
    }

    public void a(String str) {
        if (b.a()) {
            b.b("appendToMailcap: " + str);
        }
        try {
            g(new StringReader(str));
        } catch (IOException unused) {
        }
    }

    public c(InputStream inputStream) throws IOException {
        if (b.a()) {
            b.b("new MailcapFile: InputStream");
        }
        g(new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")));
    }

    public c() {
        if (b.a()) {
            b.b("new MailcapFile: default");
        }
    }
}
