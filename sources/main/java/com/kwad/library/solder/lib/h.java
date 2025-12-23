package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class h extends g {
    private void c(Set<File> set) {
        com.kwad.library.solder.lib.c.b bVar = this.aqQ;
        if (bVar == null || bVar.arD.size() <= 0 || set == null) {
            return;
        }
        for (Map.Entry<String, String> entry : this.aqQ.arD.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(value)) {
                for (File file : set) {
                    String fileMD5Digest = al.getFileMD5Digest(file);
                    if (file.getName().equals(key)) {
                        if (!TextUtils.equals(fileMD5Digest, value)) {
                            d(set);
                            throw new PluginError.LoadError(new Exception(file.getName() + " Md5 check error,find " + fileMD5Digest + ",except " + value), 4008);
                        }
                    }
                }
                throw new PluginError.LoadError(new Exception(key + " not found"), 4001);
            }
        }
    }

    private File f(File file) {
        File file2 = new File(file.getParentFile(), this.aqp.Aq());
        w.Y(file2);
        return file2;
    }

    public h(String str) {
        super(str);
    }

    private Set<File> a(Context context, File file, File file2) {
        String[] list;
        Objects.toString(file2);
        HashSet hashSet = new HashSet();
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            for (String str : list) {
                hashSet.add(new File(file2.getAbsolutePath() + File.separator + str));
            }
            return hashSet;
        }
        File file3 = new File(file2.getParentFile(), this.aqp.Ar());
        w.Y(file3);
        Iterator<String> it = com.kwad.library.solder.lib.d.c.b(file, file3).iterator();
        while (it.hasNext()) {
            File a6 = com.kwad.library.solder.lib.d.c.a(file3, it.next(), file2);
            if (a6 != null) {
                hashSet.add(a6);
            }
        }
        w.T(file3);
        return hashSet;
    }

    private static void d(Set<File> set) {
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            w.T(it.next());
        }
    }

    @Override // com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public void i(Context context, String str) {
        ClassLoader classLoader;
        super.i(context, str);
        getId();
        File file = new File(str);
        try {
            File f6 = f(file);
            this.aqK = f6;
            try {
                try {
                    c(a(context, file, f6));
                    com.kwad.library.solder.lib.c.b bVar = this.aqQ;
                    if (bVar == null || (classLoader = bVar.arG) == null) {
                        classLoader = getClass().getClassLoader();
                    }
                    synchronized (Runtime.getRuntime()) {
                        try {
                            try {
                                com.kwad.library.solder.lib.ext.d.c(classLoader, this.aqK);
                            } finally {
                                PluginError.LoadError loadError = new PluginError.LoadError(th, 4004);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (PluginError.LoadError e6) {
                    w.T(file);
                    throw e6;
                }
            } catch (IOException th2) {
                throw new PluginError.LoadError(th2, r1);
            }
        } catch (IOException e7) {
            throw new PluginError.LoadError(e7, 4003);
        }
    }
}
