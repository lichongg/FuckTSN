package javax.activation;

import com.sun.activation.registries.b;
import com.sun.activation.registries.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MailcapCommandMap extends CommandMap {
    private static final int PROG = 0;
    private static c defDB;
    private c[] DB;

    public MailcapCommandMap() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(null);
        b.b("MailcapCommandMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                c loadFile = loadFile(property + File.separator + ".mailcap");
                if (loadFile != null) {
                    arrayList.add(loadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        b.b("MailcapCommandMap: load SYS");
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(System.getProperty("java.home")));
            String str = File.separator;
            sb.append(str);
            sb.append("lib");
            sb.append(str);
            sb.append("mailcap");
            c loadFile2 = loadFile(sb.toString());
            if (loadFile2 != null) {
                arrayList.add(loadFile2);
            }
        } catch (SecurityException unused2) {
        }
        b.b("MailcapCommandMap: load JAR");
        loadAllResources(arrayList, "mailcap");
        b.b("MailcapCommandMap: load DEF");
        synchronized (MailcapCommandMap.class) {
            try {
                if (defDB == null) {
                    defDB = loadResource("mailcap.default");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        c cVar = defDB;
        if (cVar != null) {
            arrayList.add(cVar);
        }
        c[] cVarArr = new c[arrayList.size()];
        this.DB = cVarArr;
        this.DB = (c[]) arrayList.toArray(cVarArr);
    }

    public synchronized void addMailcap(String str) {
        try {
            b.b("MailcapCommandMap: add to PROG");
            c[] cVarArr = this.DB;
            if (cVarArr[0] == null) {
                cVarArr[0] = new c();
            }
            this.DB[0].a(str);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x002b, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x002c, code lost:
    
        r2 = r4.DB;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x002f, code lost:
    
        if (r1 < r2.length) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0036, code lost:
    
        if (r2[r1] != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0072, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x003d, code lost:
    
        if (com.sun.activation.registries.b.a() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x003f, code lost:
    
        com.sun.activation.registries.b.b("  search fallback DB #" + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0050, code lost:
    
        r2 = r4.DB[r1].b(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0058, code lost:
    
        if (r2 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x005a, code lost:
    
        r2 = (java.util.List) r2.get("content-handler");
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0062, code lost:
    
        if (r2 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0064, code lost:
    
        r2 = getDataContentHandler((java.lang.String) r2.get(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006e, code lost:
    
        if (r2 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0071, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0032, code lost:
    
        return null;
     */
    @Override // javax.activation.CommandMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized javax.activation.DataContentHandler createDataContentHandler(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19
            java.lang.String r1 = "MailcapCommandMap: createDataContentHandler for "
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L19
            r0.append(r5)     // Catch: java.lang.Throwable -> L19
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L19
            com.sun.activation.registries.b.b(r0)     // Catch: java.lang.Throwable -> L19
            goto L1c
        L19:
            r5 = move-exception
            goto Lb7
        L1c:
            if (r5 == 0) goto L24
            java.util.Locale r0 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L19
            java.lang.String r5 = r5.toLowerCase(r0)     // Catch: java.lang.Throwable -> L19
        L24:
            r0 = 0
            r1 = 0
        L26:
            com.sun.activation.registries.c[] r2 = r4.DB     // Catch: java.lang.Throwable -> L19
            int r3 = r2.length     // Catch: java.lang.Throwable -> L19
            if (r1 < r3) goto L75
            r1 = 0
        L2c:
            com.sun.activation.registries.c[] r2 = r4.DB     // Catch: java.lang.Throwable -> L19
            int r3 = r2.length     // Catch: java.lang.Throwable -> L19
            if (r1 < r3) goto L34
            monitor-exit(r4)
            r5 = 0
            return r5
        L34:
            r2 = r2[r1]     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L39
            goto L72
        L39:
            boolean r2 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L50
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19
            java.lang.String r3 = "  search fallback DB #"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L19
            r2.append(r1)     // Catch: java.lang.Throwable -> L19
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L19
            com.sun.activation.registries.b.b(r2)     // Catch: java.lang.Throwable -> L19
        L50:
            com.sun.activation.registries.c[] r2 = r4.DB     // Catch: java.lang.Throwable -> L19
            r2 = r2[r1]     // Catch: java.lang.Throwable -> L19
            java.util.Map r2 = r2.b(r5)     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L72
            java.lang.String r3 = "content-handler"
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L19
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L72
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L19
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L19
            javax.activation.DataContentHandler r2 = r4.getDataContentHandler(r2)     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L72
            monitor-exit(r4)
            return r2
        L72:
            int r1 = r1 + 1
            goto L2c
        L75:
            r2 = r2[r1]     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L7a
            goto Lb3
        L7a:
            boolean r2 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L91
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19
            java.lang.String r3 = "  search DB #"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L19
            r2.append(r1)     // Catch: java.lang.Throwable -> L19
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L19
            com.sun.activation.registries.b.b(r2)     // Catch: java.lang.Throwable -> L19
        L91:
            com.sun.activation.registries.c[] r2 = r4.DB     // Catch: java.lang.Throwable -> L19
            r2 = r2[r1]     // Catch: java.lang.Throwable -> L19
            java.util.Map r2 = r2.c(r5)     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto Lb3
            java.lang.String r3 = "content-handler"
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L19
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto Lb3
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L19
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L19
            javax.activation.DataContentHandler r2 = r4.getDataContentHandler(r2)     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto Lb3
            monitor-exit(r4)
            return r2
        Lb3:
            int r1 = r1 + 1
            goto L26
        Lb7:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L19
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.createDataContentHandler(java.lang.String):javax.activation.DataContentHandler");
    }

    @Override // javax.activation.CommandMap
    public synchronized CommandInfo[] getAllCommands(String str) {
        ArrayList arrayList;
        Map b6;
        Map c6;
        try {
            arrayList = new ArrayList();
            if (str != null) {
                str = str.toLowerCase(Locale.ENGLISH);
            }
            int i6 = 0;
            int i7 = 0;
            while (true) {
                c[] cVarArr = this.DB;
                if (i7 >= cVarArr.length) {
                    break;
                }
                c cVar = cVarArr[i7];
                if (cVar != null && (c6 = cVar.c(str)) != null) {
                    appendCmdsToList(c6, arrayList);
                }
                i7++;
            }
            while (true) {
                c[] cVarArr2 = this.DB;
                if (i6 >= cVarArr2.length) {
                } else {
                    c cVar2 = cVarArr2[i6];
                    if (cVar2 != null && (b6 = cVar2.b(str)) != null) {
                        appendCmdsToList(b6, arrayList);
                    }
                    i6++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
    }

    @Override // javax.activation.CommandMap
    public synchronized CommandInfo getCommand(String str, String str2) {
        Map b6;
        List list;
        String str3;
        Map c6;
        List list2;
        String str4;
        if (str != null) {
            try {
                str = str.toLowerCase(Locale.ENGLISH);
            } catch (Throwable th) {
                throw th;
            }
        }
        int i6 = 0;
        while (true) {
            c[] cVarArr = this.DB;
            if (i6 >= cVarArr.length) {
                int i7 = 0;
                while (true) {
                    c[] cVarArr2 = this.DB;
                    if (i7 >= cVarArr2.length) {
                        return null;
                    }
                    c cVar = cVarArr2[i7];
                    if (cVar != null && (b6 = cVar.b(str)) != null && (list = (List) b6.get(str2)) != null && (str3 = (String) list.get(0)) != null) {
                        return new CommandInfo(str2, str3);
                    }
                    i7++;
                }
            } else {
                c cVar2 = cVarArr[i6];
                if (cVar2 != null && (c6 = cVar2.c(str)) != null && (list2 = (List) c6.get(str2)) != null && (str4 = (String) list2.get(0)) != null) {
                    return new CommandInfo(str2, str4);
                }
                i6++;
            }
        }
    }

    @Override // javax.activation.CommandMap
    public synchronized String[] getMimeTypes() {
        ArrayList arrayList;
        String[] d6;
        arrayList = new ArrayList();
        int i6 = 0;
        while (true) {
            c[] cVarArr = this.DB;
            if (i6 < cVarArr.length) {
                c cVar = cVarArr[i6];
                if (cVar != null && (d6 = cVar.d()) != null) {
                    for (int i7 = 0; i7 < d6.length; i7++) {
                        if (!arrayList.contains(d6[i7])) {
                            arrayList.add(d6[i7]);
                        }
                    }
                }
                i6++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public synchronized String[] getNativeCommands(String str) {
        ArrayList arrayList;
        String[] e6;
        try {
            arrayList = new ArrayList();
            if (str != null) {
                str = str.toLowerCase(Locale.ENGLISH);
            }
            int i6 = 0;
            while (true) {
                c[] cVarArr = this.DB;
                if (i6 < cVarArr.length) {
                    c cVar = cVarArr[i6];
                    if (cVar != null && (e6 = cVar.e(str)) != null) {
                        for (int i7 = 0; i7 < e6.length; i7++) {
                            if (!arrayList.contains(e6[i7])) {
                                arrayList.add(e6[i7]);
                            }
                        }
                    }
                    i6++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // javax.activation.CommandMap
    public synchronized CommandInfo[] getPreferredCommands(String str) {
        ArrayList arrayList;
        Map b6;
        Map c6;
        try {
            arrayList = new ArrayList();
            if (str != null) {
                str = str.toLowerCase(Locale.ENGLISH);
            }
            int i6 = 0;
            int i7 = 0;
            while (true) {
                c[] cVarArr = this.DB;
                if (i7 >= cVarArr.length) {
                    break;
                }
                c cVar = cVarArr[i7];
                if (cVar != null && (c6 = cVar.c(str)) != null) {
                    appendPrefCmdsToList(c6, arrayList);
                }
                i7++;
            }
            while (true) {
                c[] cVarArr2 = this.DB;
                if (i6 >= cVarArr2.length) {
                } else {
                    c cVar2 = cVarArr2[i6];
                    if (cVar2 != null && (b6 = cVar2.b(str)) != null) {
                        appendPrefCmdsToList(b6, arrayList);
                    }
                    i6++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
    }

    private DataContentHandler getDataContentHandler(String str) {
        Class<?> cls;
        if (b.a()) {
            b.b("    got content-handler");
        }
        if (b.a()) {
            b.b("      class " + str);
        }
        try {
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            try {
                cls = contextClassLoader.loadClass(str);
            } catch (Exception unused) {
                cls = Class.forName(str);
            }
            if (cls != null) {
                return (DataContentHandler) cls.newInstance();
            }
            return null;
        } catch (ClassNotFoundException e6) {
            if (!b.a()) {
                return null;
            }
            b.c("Can't load DCH " + str, e6);
            return null;
        } catch (IllegalAccessException e7) {
            if (!b.a()) {
                return null;
            }
            b.c("Can't load DCH " + str, e7);
            return null;
        } catch (InstantiationException e8) {
            if (!b.a()) {
                return null;
            }
            b.c("Can't load DCH " + str, e8);
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(3:21|22|(2:24|(1:26))(2:35|(1:37)))|(2:34|32)|28|29|31|32) */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loadAllResources(java.util.List r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.loadAllResources(java.util.List, java.lang.String):void");
    }

    private c loadFile(String str) {
        try {
            return new c(str);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        if (r2 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0087, code lost:
    
        if (r2 != null) goto L46;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x002b: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:44), block:B:37:0x002b */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sun.activation.registries.c loadResource(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "MailcapCommandMap: can't load "
            r1 = 0
            java.lang.Class r2 = r6.getClass()     // Catch: java.lang.Throwable -> L52 java.lang.SecurityException -> L54 java.io.IOException -> L57
            java.io.InputStream r2 = javax.activation.SecuritySupport.getResourceAsStream(r2, r7)     // Catch: java.lang.Throwable -> L52 java.lang.SecurityException -> L54 java.io.IOException -> L57
            if (r2 == 0) goto L35
            com.sun.activation.registries.c r3 = new com.sun.activation.registries.c     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            boolean r4 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            if (r4 == 0) goto L31
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            java.lang.String r5 = "MailcapCommandMap: successfully loaded mailcap file: "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            r4.append(r7)     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            com.sun.activation.registries.b.b(r4)     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            goto L31
        L2a:
            r7 = move-exception
            r1 = r2
            goto L8b
        L2d:
            r3 = move-exception
            goto L5a
        L2f:
            r3 = move-exception
            goto L72
        L31:
            r2.close()     // Catch: java.io.IOException -> L34
        L34:
            return r3
        L35:
            boolean r3 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            if (r3 == 0) goto L4c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            java.lang.String r4 = "MailcapCommandMap: not loading mailcap file: "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            r3.append(r7)     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            com.sun.activation.registries.b.b(r3)     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
        L4c:
            if (r2 == 0) goto L8a
        L4e:
            r2.close()     // Catch: java.io.IOException -> L8a
            goto L8a
        L52:
            r7 = move-exception
            goto L8b
        L54:
            r3 = move-exception
            r2 = r1
            goto L5a
        L57:
            r3 = move-exception
            r2 = r1
            goto L72
        L5a:
            boolean r4 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L6f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L2a
            r4.append(r7)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L2a
            com.sun.activation.registries.b.c(r7, r3)     // Catch: java.lang.Throwable -> L2a
        L6f:
            if (r2 == 0) goto L8a
            goto L4e
        L72:
            boolean r4 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L87
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L2a
            r4.append(r7)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L2a
            com.sun.activation.registries.b.c(r7, r3)     // Catch: java.lang.Throwable -> L2a
        L87:
            if (r2 == 0) goto L8a
            goto L4e
        L8a:
            return r1
        L8b:
            if (r1 == 0) goto L90
            r1.close()     // Catch: java.io.IOException -> L90
        L90:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.loadResource(java.lang.String):com.sun.activation.registries.c");
    }

    private void appendCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            Iterator it = ((List) map.get(str)).iterator();
            while (it.hasNext()) {
                list.add(new CommandInfo(str, (String) it.next()));
            }
        }
    }

    private void appendPrefCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            if (!checkForVerb(list, str)) {
                list.add(new CommandInfo(str, (String) ((List) map.get(str)).get(0)));
            }
        }
    }

    private boolean checkForVerb(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((CommandInfo) it.next()).getCommandName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public MailcapCommandMap(String str) throws IOException {
        this();
        if (b.a()) {
            b.b("MailcapCommandMap: load PROG from " + str);
        }
        c[] cVarArr = this.DB;
        if (cVarArr[0] == null) {
            cVarArr[0] = new c(str);
        }
    }

    public MailcapCommandMap(InputStream inputStream) {
        this();
        b.b("MailcapCommandMap: load PROG");
        c[] cVarArr = this.DB;
        if (cVarArr[0] == null) {
            try {
                cVarArr[0] = new c(inputStream);
            } catch (IOException unused) {
            }
        }
    }
}
