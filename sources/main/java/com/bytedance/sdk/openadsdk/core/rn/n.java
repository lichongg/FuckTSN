package com.bytedance.sdk.openadsdk.core.rn;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.openadsdk.core.tj.p;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class n {

    /* renamed from: j, reason: collision with root package name */
    private static volatile n f30118j;
    private final Set<String> cw = Collections.synchronizedSet(new HashSet());
    private String xt;

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        private final String f30123j;
        private final AtomicInteger xt = new AtomicInteger(0);
        private final AtomicInteger cw = new AtomicInteger(0);

        public String cw() {
            return this.f30123j;
        }

        void j() {
            this.xt.incrementAndGet();
        }

        public int r() {
            return this.xt.get();
        }

        public int up() {
            return this.cw.get();
        }

        void xt() {
            this.cw.incrementAndGet();
        }

        j(String str) {
            this.f30123j = str;
        }
    }

    private void xt(File file) {
        try {
            if (file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (file.setLastModified(currentTimeMillis)) {
                    return;
                }
                file.renameTo(file);
                if (file.lastModified() < currentTimeMillis) {
                    com.bytedance.sdk.component.utils.vl.xt("WebCacheResourceManager", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cw(String str) {
        File file = new File(xt(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static n j() {
        if (f30118j == null) {
            synchronized (n.class) {
                try {
                    if (f30118j == null) {
                        f30118j = new n();
                    }
                } finally {
                }
            }
        }
        return f30118j;
    }

    private String xt() {
        if (TextUtils.isEmpty(this.xt)) {
            try {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xt.xt(com.bytedance.sdk.openadsdk.core.v.getContext()), "tt_web_resource");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.xt = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.r("WebCacheResourceManager", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.xt;
    }

    public void j(List<p.cw> list, p.j jVar) {
        xt(list, jVar);
        Iterator<p.cw> it = list.iterator();
        while (it.hasNext()) {
            j(it.next(), jVar);
        }
    }

    private void j(final p.cw cwVar, final p.j jVar) {
        File[] listFiles;
        p.r cw = cwVar.cw();
        final String j6 = cwVar.cw().j();
        if (this.cw.contains(j6)) {
            return;
        }
        File file = new File(xt());
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    String substring = name.substring(0, name.indexOf("$"));
                    String substring2 = name.substring(name.indexOf("$") + 1);
                    if (!substring.equals(cwVar.j())) {
                        continue;
                    } else {
                        if (substring2.equals(com.bytedance.sdk.component.utils.up.xt(cw.xt()))) {
                            return;
                        }
                        com.bytedance.sdk.component.utils.m.cw(file2);
                        if (jVar != null) {
                            jVar.xt(xt(cwVar.j()));
                        }
                    }
                }
            }
        }
        this.cw.add(j6);
        File file3 = new File(xt(), com.bytedance.sdk.component.utils.up.xt(j6));
        com.bytedance.sdk.component.g.xt.xt r5 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().r();
        r5.j(j6);
        r5.j(file3.getParent(), file3.getName());
        r5.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.rn.n.1
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, final com.bytedance.sdk.component.g.xt xtVar) {
                n.this.cw.remove(j6);
                if (xtVar.tl() && xtVar.ae() != null && xtVar.ae().exists()) {
                    com.bytedance.sdk.component.oq.ae.j(new com.bytedance.sdk.component.oq.g("downloadZip") { // from class: com.bytedance.sdk.openadsdk.core.rn.n.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String absolutePath = xtVar.ae().getAbsolutePath();
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                com.bytedance.sdk.component.utils.h.j(absolutePath, n.this.cw(cwVar.r()));
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                p.j jVar2 = jVar;
                                if (jVar2 != null) {
                                    jVar2.j(cwVar);
                                }
                            } catch (Throwable th) {
                                StringBuilder sb = new StringBuilder("unzip web resources failed：");
                                AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                sb.append(n.this.cw(cwVar.r()));
                                com.bytedance.sdk.component.utils.vl.cw("WebCacheResourceManager", sb.toString(), th);
                            }
                            try {
                                xtVar.ae().delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }, 5);
                    return;
                }
                com.bytedance.sdk.component.utils.vl.r("WebCacheResourceManager", "download resources failed 1：" + j6);
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                n.this.cw.remove(j6);
                com.bytedance.sdk.component.utils.vl.r("WebCacheResourceManager", "download resources failed 2：" + j6);
            }
        });
    }

    public void xt(List<p.cw> list, p.j jVar) {
        File[] listFiles;
        File file = new File(xt());
        if (!file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.rn.n.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        })) == null) {
            return;
        }
        for (File file2 : listFiles) {
            String substring = file2.getName().substring(0, file2.getName().indexOf("$"));
            Iterator<p.cw> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().j().equals(substring)) {
                        break;
                    }
                } else {
                    com.bytedance.sdk.component.utils.m.cw(file2);
                    if (jVar != null) {
                        jVar.xt(xt(substring));
                    }
                }
            }
        }
    }

    public static p.cw xt(String str) {
        if (com.bytedance.sdk.openadsdk.core.tj.p.j().isEmpty()) {
            return null;
        }
        for (p.cw cwVar : com.bytedance.sdk.openadsdk.core.tj.p.j()) {
            if (cwVar.j().equals(str)) {
                return cwVar;
            }
        }
        return null;
    }

    private void j(File file) {
        xt(file);
        try {
            com.bytedance.sdk.openadsdk.core.oq.i().n().j(file);
        } catch (Throwable unused) {
        }
    }

    public List<p.cw> j(String str) {
        if (!com.bytedance.sdk.openadsdk.core.tj.p.f30389j || com.bytedance.sdk.openadsdk.core.tj.p.j().isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            String path = new URL(str).getPath();
            if (path != null && !path.isEmpty()) {
                for (p.cw cwVar : com.bytedance.sdk.openadsdk.core.tj.p.j()) {
                    if (path.contains(cwVar.xt())) {
                        arrayList.add(cwVar);
                    }
                }
                return arrayList;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public WebResourceResponse j(WebResourceResponse webResourceResponse, String str, List<p.cw> list, Map<String, j> map) {
        j jVar;
        try {
            String path = new URL(str).getPath();
            if (map != null) {
                jVar = map.get(path);
                if (jVar == null) {
                    jVar = new j(path);
                    map.put(path, jVar);
                }
            } else {
                jVar = new j(path);
            }
            String str2 = "text/html";
            for (p.cw cwVar : list) {
                File file = new File(cw(cwVar.r()), path.substring(path.indexOf(cwVar.xt())).replace(cwVar.xt(), ""));
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (webResourceResponse == null) {
                        Iterator<p.xt> it = cwVar.cw().cw().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            p.xt next = it.next();
                            if (TextUtils.equals(next.xt(), file.getName())) {
                                str2 = next.j();
                                break;
                            }
                        }
                        WebResourceResponse webResourceResponse2 = new WebResourceResponse(str2, "utf-8", fileInputStream);
                        try {
                            jVar.j();
                            webResourceResponse = webResourceResponse2;
                        } catch (Exception unused) {
                            return webResourceResponse2;
                        }
                    }
                    webResourceResponse.setData(fileInputStream);
                    j(new File(cw(cwVar.r())));
                    return webResourceResponse;
                }
            }
            jVar.xt();
            return webResourceResponse;
        } catch (Exception unused2) {
            return webResourceResponse;
        }
    }

    public void j(p.j jVar) {
        try {
            for (File file : new File(xt()).listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() >= bn.f10748d) {
                    try {
                        com.bytedance.sdk.component.utils.m.cw(file);
                        String name = file.getName();
                        String substring = name.substring(0, name.indexOf("$"));
                        if (jVar != null) {
                            jVar.xt(xt(substring));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
