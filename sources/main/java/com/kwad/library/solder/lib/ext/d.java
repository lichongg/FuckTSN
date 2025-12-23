package com.kwad.library.solder.lib.ext;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"LongLogTag"})
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, "pathList").get(classLoader);
            Field c6 = com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) c6.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            c6.set(obj, arrayList.toArray(new File[0]));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, "pathList").get(classLoader);
            Field c6 = com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories");
            Collection collection = (List) c6.get(obj);
            if (collection == null) {
                collection = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(collection);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList.add(file);
            c6.set(obj, arrayList);
            if (c6.get(obj) != arrayList) {
                com.kwad.library.solder.lib.ext.e.d(obj, "nativeLibraryDirectories").set(obj, arrayList);
            }
            List list = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Object obj2 = (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
            Field c7 = com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryPathElements");
            c7.set(obj, obj2);
            if (c7.get(obj) != obj2) {
                com.kwad.library.solder.lib.ext.e.d(obj, "nativeLibraryPathElements").set(obj, obj2);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, "pathList").get(classLoader);
            List list = (List) com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.library.solder.lib.ext.d$d, reason: collision with other inner class name */
    static final class C0667d {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, "pathList").get(classLoader);
            List list = (List) com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, "makePathElements", List.class).invoke(obj, arrayList));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            String str;
            String path = file.getPath();
            Field c6 = com.kwad.library.solder.lib.ext.e.c(classLoader, "libPath");
            String valueOf = String.valueOf(c6.get(classLoader));
            if (!TextUtils.isEmpty(valueOf)) {
                str = valueOf + ":" + path;
            } else {
                str = path;
            }
            c6.set(classLoader, str);
            Field c7 = com.kwad.library.solder.lib.ext.e.c(classLoader, "libraryPathElements");
            List list = (List) c7.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    return;
                }
            }
            list.add(path);
            c7.set(classLoader, list);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001a, code lost:
    
        if (r6 == 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void c(java.lang.ClassLoader r9, java.io.File r10) {
        /*
            java.lang.Class<com.kwad.library.solder.lib.ext.d> r0 = com.kwad.library.solder.lib.ext.d.class
            monitor-enter(r0)
            r1 = 1
            r2 = 0
            if (r10 == 0) goto La2
            boolean r3 = r10.exists()     // Catch: java.lang.Throwable -> L1d
            if (r3 != 0) goto Lf
            goto La2
        Lf:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1d
            r4 = 2
            r5 = 25
            if (r3 != r5) goto L20
            int r6 = com.bytedance.pangle.transform.c.a()     // Catch: java.lang.Throwable -> L1d
            if (r6 != 0) goto L22
            goto L20
        L1d:
            r9 = move-exception
            goto Lb3
        L20:
            if (r3 <= r5) goto L48
        L22:
            com.kwad.library.solder.lib.ext.d.C0667d.h(r9, r10)     // Catch: java.lang.Throwable -> L27
            monitor-exit(r0)
            return
        L27:
            r3 = move-exception
            java.lang.String r5 = "Sodler.ShareLibraryLoader"
            java.lang.String r6 = "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23"
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L1d
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L1d
            r4[r2] = r7     // Catch: java.lang.Throwable -> L1d
            r4[r1] = r3     // Catch: java.lang.Throwable -> L1d
            java.lang.String r1 = java.lang.String.format(r6, r4)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.a.e(r5, r1)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.ext.d.b.f(r9, r10)     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r0)
            return
        L48:
            r5 = 24
            if (r3 != r5) goto L72
            com.kwad.library.solder.lib.ext.d.c.g(r9, r10)     // Catch: java.lang.Throwable -> L51
            monitor-exit(r0)
            return
        L51:
            r3 = move-exception
            java.lang.String r5 = "Sodler.ShareLibraryLoader"
            java.lang.String r6 = "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14"
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r8 = r3.getMessage()     // Catch: java.lang.Throwable -> L1d
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L1d
            r4[r2] = r7     // Catch: java.lang.Throwable -> L1d
            r4[r1] = r8     // Catch: java.lang.Throwable -> L1d
            java.lang.String r1 = java.lang.String.format(r6, r4)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.a.e(r5, r1)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.ext.d.a.e(r9, r10)     // Catch: java.lang.Throwable -> L71
            goto L9a
        L71:
            throw r3     // Catch: java.lang.Throwable -> L1d
        L72:
            r5 = 23
            if (r3 < r5) goto L9d
            com.kwad.library.solder.lib.ext.d.b.f(r9, r10)     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r0)
            return
        L7b:
            r3 = move-exception
            java.lang.String r5 = "Sodler.ShareLibraryLoader"
            java.lang.String r6 = "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14"
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r8 = r3.getMessage()     // Catch: java.lang.Throwable -> L1d
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L1d
            r4[r2] = r7     // Catch: java.lang.Throwable -> L1d
            r4[r1] = r8     // Catch: java.lang.Throwable -> L1d
            java.lang.String r1 = java.lang.String.format(r6, r4)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.a.e(r5, r1)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.ext.d.a.e(r9, r10)     // Catch: java.lang.Throwable -> L9c
        L9a:
            monitor-exit(r0)
            return
        L9c:
            throw r3     // Catch: java.lang.Throwable -> L1d
        L9d:
            com.kwad.library.solder.lib.ext.d.a.e(r9, r10)     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r0)
            return
        La2:
            java.lang.String r9 = "Sodler.ShareLibraryLoader"
            java.lang.String r3 = "installNativeLibraryPath, folder %s is illegal"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L1d
            r1[r2] = r10     // Catch: java.lang.Throwable -> L1d
            java.lang.String r10 = java.lang.String.format(r3, r1)     // Catch: java.lang.Throwable -> L1d
            com.kwad.library.solder.lib.a.e(r9, r10)     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r0)
            return
        Lb3:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.library.solder.lib.ext.d.c(java.lang.ClassLoader, java.io.File):void");
    }
}
