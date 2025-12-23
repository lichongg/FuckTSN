package javax.activation;

import com.sun.activation.registries.b;
import com.sun.activation.registries.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MimetypesFileTypeMap extends FileTypeMap {
    private static final int PROG = 0;
    private static f defDB = null;
    private static String defaultType = "application/octet-stream";
    private f[] DB;

    public MimetypesFileTypeMap() {
        Vector vector = new Vector(5);
        vector.addElement(null);
        b.b("MimetypesFileTypeMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                f loadFile = loadFile(property + File.separator + ".mime.types");
                if (loadFile != null) {
                    vector.addElement(loadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        b.b("MimetypesFileTypeMap: load SYS");
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(System.getProperty("java.home")));
            String str = File.separator;
            sb.append(str);
            sb.append("lib");
            sb.append(str);
            sb.append("mime.types");
            f loadFile2 = loadFile(sb.toString());
            if (loadFile2 != null) {
                vector.addElement(loadFile2);
            }
        } catch (SecurityException unused2) {
        }
        b.b("MimetypesFileTypeMap: load JAR");
        loadAllResources(vector, "mime.types");
        b.b("MimetypesFileTypeMap: load DEF");
        synchronized (MimetypesFileTypeMap.class) {
            try {
                if (defDB == null) {
                    defDB = loadResource("/mimetypes.default");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f fVar = defDB;
        if (fVar != null) {
            vector.addElement(fVar);
        }
        f[] fVarArr = new f[vector.size()];
        this.DB = fVarArr;
        vector.copyInto(fVarArr);
    }

    public synchronized void addMimeTypes(String str) {
        try {
            f[] fVarArr = this.DB;
            if (fVarArr[0] == null) {
                fVarArr[0] = new f();
            }
            this.DB[0].a(str);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // javax.activation.FileTypeMap
    public String getContentType(File file) {
        return getContentType(file.getName());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(3:21|22|(2:24|(1:26))(2:35|(1:37)))|(2:34|32)|28|29|31|32) */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loadAllResources(java.util.Vector r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MimetypesFileTypeMap.loadAllResources(java.util.Vector, java.lang.String):void");
    }

    private f loadFile(String str) {
        try {
            return new f(str);
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
    private com.sun.activation.registries.f loadResource(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "MimetypesFileTypeMap: can't load "
            r1 = 0
            java.lang.Class r2 = r6.getClass()     // Catch: java.lang.Throwable -> L52 java.lang.SecurityException -> L54 java.io.IOException -> L57
            java.io.InputStream r2 = javax.activation.SecuritySupport.getResourceAsStream(r2, r7)     // Catch: java.lang.Throwable -> L52 java.lang.SecurityException -> L54 java.io.IOException -> L57
            if (r2 == 0) goto L35
            com.sun.activation.registries.f r3 = new com.sun.activation.registries.f     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            boolean r4 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            if (r4 == 0) goto L31
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a java.lang.SecurityException -> L2d java.io.IOException -> L2f
            java.lang.String r5 = "MimetypesFileTypeMap: successfully loaded mime types file: "
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
            java.lang.String r4 = "MimetypesFileTypeMap: not loading mime types file: "
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
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MimetypesFileTypeMap.loadResource(java.lang.String):com.sun.activation.registries.f");
    }

    @Override // javax.activation.FileTypeMap
    public synchronized String getContentType(String str) {
        String b6;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return defaultType;
        }
        String substring = str.substring(lastIndexOf + 1);
        if (substring.length() == 0) {
            return defaultType;
        }
        int i6 = 0;
        while (true) {
            f[] fVarArr = this.DB;
            if (i6 >= fVarArr.length) {
                return defaultType;
            }
            f fVar = fVarArr[i6];
            if (fVar != null && (b6 = fVar.b(substring)) != null) {
                return b6;
            }
            i6++;
        }
    }

    public MimetypesFileTypeMap(String str) throws IOException {
        this();
        this.DB[0] = new f(str);
    }

    public MimetypesFileTypeMap(InputStream inputStream) {
        this();
        try {
            this.DB[0] = new f(inputStream);
        } catch (IOException unused) {
        }
    }
}
