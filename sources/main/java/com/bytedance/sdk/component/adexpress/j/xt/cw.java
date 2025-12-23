package com.bytedance.sdk.component.adexpress.j.xt;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.adexpress.j.cw.j;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.vl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class cw {
    public void cw(List<j.C0397j> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<j.C0397j> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(j(), com.bytedance.sdk.component.utils.up.xt(it.next().j()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public abstract File j();

    protected boolean j(Map<String, com.bytedance.sdk.component.adexpress.j.cw.j> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.adexpress.j.cw.j jVar = map.get(it.next());
            if (jVar != null && !j(jVar.getResources())) {
                return false;
            }
        }
        return true;
    }

    public List<j.C0397j> xt(com.bytedance.sdk.component.adexpress.j.cw.j jVar, com.bytedance.sdk.component.adexpress.j.cw.j jVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (jVar2 == null || jVar2.getResources().isEmpty()) {
            arrayList2.addAll(jVar.getResources());
        } else if (jVar.getResources().isEmpty()) {
            arrayList.addAll(jVar2.getResources());
        } else {
            for (j.C0397j c0397j : jVar.getResources()) {
                if (!jVar2.getResources().contains(c0397j) && c0397j != null && c0397j.j() != null && c0397j.xt() != null) {
                    arrayList2.add(c0397j);
                }
            }
            for (j.C0397j c0397j2 : jVar2.getResources()) {
                if (!jVar.getResources().contains(c0397j2)) {
                    arrayList.add(c0397j2);
                }
            }
        }
        if (j(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    protected boolean j(List<j.C0397j> list) {
        if (list == null || list.size() <= 0 || j() == null) {
            return false;
        }
        for (j.C0397j c0397j : list) {
            String xt = com.bytedance.sdk.component.utils.up.xt(c0397j.j());
            if (TextUtils.isEmpty(xt)) {
                return false;
            }
            File file = new File(j(), xt);
            String j6 = com.bytedance.sdk.component.utils.up.j(file);
            if (!file.exists() || !file.isFile() || c0397j.xt() == null || !c0397j.xt().equals(j6)) {
                return false;
            }
        }
        return true;
    }

    public static boolean cw(com.bytedance.sdk.component.adexpress.j.cw.j jVar, com.bytedance.sdk.component.adexpress.j.cw.j jVar2) {
        if (jVar != null) {
            try {
                if (!TextUtils.isEmpty(jVar.cw())) {
                    if (jVar2 == null) {
                        return false;
                    }
                    if (j(jVar.cw(), jVar2.cw())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.j.cw.j> j6 = jVar.j();
                    Map<String, com.bytedance.sdk.component.adexpress.j.cw.j> j7 = jVar2.j();
                    if (j6.isEmpty()) {
                        return !j7.isEmpty();
                    }
                    if (j7.isEmpty()) {
                        return false;
                    }
                    return j(j6, j7);
                }
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }
        return true;
    }

    protected boolean j(j.xt xtVar) {
        if (xtVar == null || j() == null) {
            return false;
        }
        List<Pair<String, String>> xt = xtVar.xt();
        if (xt == null || xt.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = xt.iterator();
        while (it.hasNext()) {
            File file = new File(j(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public void xt(List<j.C0397j> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<j.C0397j> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(j(), com.bytedance.sdk.component.utils.up.xt(it.next().j()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public List<j.C0397j> j(com.bytedance.sdk.component.adexpress.j.cw.j jVar, com.bytedance.sdk.component.adexpress.j.cw.j jVar2) {
        Map<String, com.bytedance.sdk.component.adexpress.j.cw.j> j6 = jVar.j();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (j6.size() == 0) {
            if (jVar2 != null && jVar2.j().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.j.cw.j> j7 = jVar2.j();
                Iterator<String> it = j7.keySet().iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.j.cw.j jVar3 = j7.get(it.next());
                    if (jVar3 != null) {
                        arrayList.addAll(jVar3.getResources());
                    }
                }
            }
        } else if (jVar2 != null && jVar2.j().size() != 0) {
            Map<String, com.bytedance.sdk.component.adexpress.j.cw.j> j8 = jVar2.j();
            for (String str : j6.keySet()) {
                com.bytedance.sdk.component.adexpress.j.cw.j jVar4 = j6.get(str);
                com.bytedance.sdk.component.adexpress.j.cw.j jVar5 = j8.get(str);
                if (jVar5 == null && jVar4 != null) {
                    arrayList2.addAll(jVar4.getResources());
                } else if (jVar4 == null && jVar5 != null) {
                    arrayList.addAll(jVar5.getResources());
                } else if (jVar4 != null) {
                    for (j.C0397j c0397j : jVar4.getResources()) {
                        if (c0397j != null && !jVar5.getResources().contains(c0397j) && c0397j.xt() != null && c0397j.j() != null) {
                            arrayList2.add(c0397j);
                        }
                    }
                    for (j.C0397j c0397j2 : jVar5.getResources()) {
                        if (c0397j2 != null && !jVar4.getResources().contains(c0397j2)) {
                            arrayList.add(c0397j2);
                        }
                    }
                }
            }
        } else if (j6.size() != 0) {
            Iterator<String> it2 = j6.keySet().iterator();
            while (it2.hasNext()) {
                com.bytedance.sdk.component.adexpress.j.cw.j jVar6 = j6.get(it2.next());
                if (jVar6 != null) {
                    arrayList2.addAll(jVar6.getResources());
                }
            }
        }
        if (j(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public static void xt(File file, com.bytedance.sdk.component.adexpress.j.cw.j jVar, String str) {
        if (jVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (jVar.getResources() != null) {
            Iterator<j.C0397j> it = jVar.getResources().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.up.xt(it.next().j())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    private boolean j(List<j.C0397j> list, List<j.C0397j> list2) {
        for (j.C0397j c0397j : list) {
            String j6 = c0397j.j();
            String xt = com.bytedance.sdk.component.utils.up.xt(j6);
            File file = new File(j(), xt);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            com.bytedance.sdk.component.g.xt.xt r5 = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().r();
            r5.j(j6);
            r5.j(j().getAbsolutePath(), xt);
            com.bytedance.sdk.component.g.xt j7 = r5.j();
            list2.add(c0397j);
            if (j7 == null || !j7.tl() || j7.ae() == null || !j7.ae().exists()) {
                cw(list2);
                return false;
            }
        }
        return true;
    }

    public boolean j(String str) {
        String xt = com.bytedance.sdk.component.utils.up.xt(str);
        File file = new File(j().getAbsoluteFile(), xt + ".zip");
        com.bytedance.sdk.component.g.xt.xt r5 = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().r();
        r5.j(str);
        r5.j(file.getParent(), file.getName());
        com.bytedance.sdk.component.g.xt j6 = r5.j();
        if (j6.tl() && j6.ae() != null && j6.ae().exists()) {
            File ae = j6.ae();
            try {
                h.j(ae.getAbsolutePath(), file.getParent());
                if (!ae.exists()) {
                    return true;
                }
                ae.delete();
                return true;
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        return false;
    }

    public void j(int i6) {
        if (com.bytedance.sdk.component.adexpress.j.j.j.j().r() != null) {
            com.bytedance.sdk.component.adexpress.j.j.j.j().r().j(i6);
        }
    }

    public static void j(File file, com.bytedance.sdk.component.adexpress.j.cw.j jVar, String str) {
        if (jVar == null) {
            return;
        }
        String tl = jVar.tl();
        if (TextUtils.isEmpty(tl)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                try {
                    fileOutputStream2.write(tl.getBytes("utf-8"));
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file3.renameTo(file2);
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        vl.cw("PlayComponentEngineCacheManager", "version save error3", th);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException unused2) {
        }
    }

    private static boolean j(Map<String, com.bytedance.sdk.component.adexpress.j.cw.j> map, Map<String, com.bytedance.sdk.component.adexpress.j.cw.j> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.j.cw.j jVar = map.get(str);
            if (jVar == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.j.cw.j jVar2 = map2.get(str);
            if (jVar2 == null) {
                return false;
            }
            if (j(jVar.cw(), jVar2.cw())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean j(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "\\."
            java.lang.String[] r7 = r7.split(r0)
            java.lang.String[] r6 = r6.split(r0)
            int r0 = r7.length
            int r1 = r6.length
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 0
            r2 = 0
        L12:
            if (r2 >= r0) goto L42
            r3 = r7[r2]
            int r3 = r3.length()
            r4 = r6[r2]
            int r4 = r4.length()
            int r3 = r3 - r4
            r4 = 1
            if (r3 != 0) goto L3f
            r3 = r7[r2]
            r5 = r6[r2]
            int r3 = r3.compareTo(r5)
            if (r3 <= 0) goto L2f
            return r4
        L2f:
            if (r3 >= 0) goto L32
            return r1
        L32:
            int r3 = r0 + (-1)
            if (r2 != r3) goto L3c
            int r7 = r7.length
            int r6 = r6.length
            if (r7 <= r6) goto L3b
            return r4
        L3b:
            return r1
        L3c:
            int r2 = r2 + 1
            goto L12
        L3f:
            if (r3 <= 0) goto L42
            return r4
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.j.xt.cw.j(java.lang.String, java.lang.String):boolean");
    }

    @Deprecated
    public static boolean j(com.bytedance.sdk.component.adexpress.j.cw.j jVar, String str) {
        if (jVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(jVar.cw())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return j(jVar.cw(), str);
        } catch (Throwable unused) {
            return false;
        }
    }
}
