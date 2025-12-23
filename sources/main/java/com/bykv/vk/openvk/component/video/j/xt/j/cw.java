package com.bykv.vk.openvk.component.video.j.xt.j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.j.xt.r;
import com.bykv.vk.openvk.component.video.j.xt.up;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends com.bykv.vk.openvk.component.video.j.xt.j.j {
    private volatile long ae;
    private final ReentrantReadWriteLock cw;

    /* renamed from: g, reason: collision with root package name */
    private final xt f23057g;

    /* renamed from: j, reason: collision with root package name */
    public final File f23058j;

    /* renamed from: m, reason: collision with root package name */
    private final Set<j> f23059m;
    private final Runnable oq;
    private final Handler qv;

    /* renamed from: r, reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f23060r;
    private volatile float tl;
    private final ReentrantReadWriteLock.WriteLock up;
    private final LinkedHashMap<String, File> xt = new LinkedHashMap<>(0, 0.75f, true);

    public interface j {
        void j(String str);

        void j(Set<String> set);
    }

    private static final class xt {

        /* renamed from: j, reason: collision with root package name */
        private final Map<String, Integer> f23067j;

        private xt() {
            this.f23067j = new HashMap();
        }

        synchronized boolean cw(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f23067j.containsKey(str);
        }

        synchronized void j(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.f23067j.get(str);
                if (num == null) {
                    this.f23067j.put(str, 1);
                    return;
                }
                this.f23067j.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }

        synchronized void xt(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.f23067j.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.f23067j.remove(str);
                    return;
                }
                this.f23067j.put(str, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    private void cw() {
        this.qv.removeCallbacks(this.oq);
        this.qv.postDelayed(this.oq, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
        this.up.lock();
        try {
            File[] listFiles = this.f23058j.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                final HashMap hashMap = new HashMap(listFiles.length);
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        hashMap.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.j.xt.j.cw.3
                    @Override // java.util.Comparator
                    /* renamed from: j, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long longValue = ((Long) hashMap.get(file2)).longValue() - ((Long) hashMap.get(file3)).longValue();
                        if (longValue < 0) {
                            return -1;
                        }
                        return longValue > 0 ? 1 : 0;
                    }
                });
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    this.xt.put(j(file2), file2);
                }
            }
            this.up.unlock();
            cw();
        } catch (Throwable th) {
            this.up.unlock();
            throw th;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.j.j
    public File r(String str) {
        if (!this.f23060r.tryLock()) {
            return null;
        }
        File file = this.xt.get(str);
        this.f23060r.unlock();
        return file;
    }

    public cw(File file) throws IOException {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.cw = reentrantReadWriteLock;
        this.f23060r = reentrantReadWriteLock.readLock();
        this.up = reentrantReadWriteLock.writeLock();
        this.f23059m = Collections.newSetFromMap(new ConcurrentHashMap());
        this.ae = 104857600L;
        this.tl = 0.5f;
        this.f23057g = new xt();
        this.oq = new Runnable() { // from class: com.bykv.vk.openvk.component.video.j.xt.j.cw.1
            @Override // java.lang.Runnable
            public void run() {
                ae.xt(new g("cleanupCmd", 1) { // from class: com.bykv.vk.openvk.component.video.j.xt.j.cw.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        cw cwVar = cw.this;
                        cwVar.xt(cwVar.ae);
                    }
                });
            }
        };
        this.qv = new Handler(Looper.getMainLooper());
        if (file != null && file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
            this.f23058j = file;
            ae.xt(new g("DiskLruCache", 5) { // from class: com.bykv.vk.openvk.component.video.j.xt.j.cw.2
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.xt();
                }
            });
            return;
        }
        if (file == null) {
            str = " dir null";
        } else {
            str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
        }
        throw new IOException("dir error!  ".concat(String.valueOf(str)));
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.j.j
    public File cw(String str) {
        this.f23060r.lock();
        File file = this.xt.get(str);
        this.f23060r.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.f23058j, str);
        this.up.lock();
        this.xt.put(str, file2);
        this.up.unlock();
        Iterator<j> it = this.f23059m.iterator();
        while (it.hasNext()) {
            it.next().j(str);
        }
        cw();
        return file2;
    }

    public void j(j jVar) {
        if (jVar != null) {
            this.f23059m.add(jVar);
        }
    }

    public void j(long j6) {
        this.ae = j6;
        cw();
    }

    public void j() {
        r.cw().r();
        Context context = up.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.j.xt.xt.cw.j(context).j(0);
        }
        this.qv.removeCallbacks(this.oq);
        ae.xt(new g("clear", 1) { // from class: com.bykv.vk.openvk.component.video.j.xt.j.cw.4
            @Override // java.lang.Runnable
            public void run() {
                cw.this.xt(0L);
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.j.j
    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f23057g.j(str);
    }

    private String j(File file) {
        return file.getName();
    }

    @Override // com.bykv.vk.openvk.component.video.j.xt.j.j
    public void xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f23057g.xt(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e6 A[LOOP:3: B:39:0x00e0->B:41:0x00e6, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void xt(long r13) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.j.xt.j.cw.xt(long):void");
    }
}
