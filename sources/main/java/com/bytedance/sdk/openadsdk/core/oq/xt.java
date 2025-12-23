package com.bytedance.sdk.openadsdk.core.oq;

import com.bytedance.sdk.component.utils.vl;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends j {
    private volatile boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private int f29779j;
    private int xt;

    @Override // com.bytedance.sdk.openadsdk.core.oq.j
    protected boolean j(long j6, int i6) {
        return i6 <= this.f29779j;
    }

    private void r(List<File> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                long xt = xt(list);
                int size = list.size();
                boolean j6 = j(xt, size);
                if (j6) {
                    vl.j("splashLoadAd", "不满足删除条件，不执行删除操作(true)".concat(String.valueOf(j6)));
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !j6) {
                        vl.r("splashLoadAd", "LRUDeleteFile deleting fileTime ".concat(String.valueOf(((Long) entry.getKey()).longValue())));
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            xt -= length;
                            vl.j("splashLoadAd", "删除 一个 Cache file 当前总个数：".concat(String.valueOf(size)));
                        } else {
                            vl.r("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                        }
                        if (j(file2, xt, size)) {
                            vl.j("splashLoadAd", "停止删除 当前总个数 totalCount：" + size + " 最大值存储上限个数 maxCount " + this.f29779j + " 最小个数 " + this.xt);
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.oq.j
    protected boolean j(File file, long j6, int i6) {
        return i6 <= this.xt;
    }

    public xt(int i6, int i7) {
        this.f29779j = 15;
        this.xt = 3;
        if (i6 > 0) {
            this.f29779j = i6;
            this.xt = i7;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    private void cw(List<File> list) {
        long xt = xt(list);
        int size = list.size();
        if (!j(xt, size)) {
            for (File file : list) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    xt -= length;
                    vl.j("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    vl.j("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
                }
                if (j(file, xt, size)) {
                    return;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.oq.j
    protected void j(List<File> list) {
        if (this.cw) {
            r(list);
            this.cw = false;
        } else {
            cw(list);
        }
    }
}
