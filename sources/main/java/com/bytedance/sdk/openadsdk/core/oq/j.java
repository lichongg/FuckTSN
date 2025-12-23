package com.bytedance.sdk.openadsdk.core.oq;

import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.oq.tl;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.vl;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {

    /* renamed from: com.bytedance.sdk.openadsdk.core.oq.j$j, reason: collision with other inner class name */
    private class CallableC0468j implements Callable<Void> {
        private final File xt;

        private CallableC0468j(File file) {
            this.xt = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            j.this.xt(this.xt);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(File file) throws IOException {
        try {
            m.xt(file);
        } catch (Throwable unused) {
        }
        List<File> j6 = m.j(file.getParentFile());
        vl.r("splashLoadAd", "LruDiskFile touchInBackground files.size() " + j6.size());
        j(j6);
    }

    protected abstract void j(List<File> list);

    protected abstract boolean j(long j6, int i6);

    protected abstract boolean j(File file, long j6, int i6);

    public void j(File file) throws IOException {
        final tl tlVar = new tl(new CallableC0468j(file), 1, 2);
        ae.xt(new g("touch", tlVar.j()) { // from class: com.bytedance.sdk.openadsdk.core.oq.j.1
            @Override // java.lang.Runnable
            public void run() {
                tlVar.run();
            }
        });
    }

    long xt(List<File> list) {
        Iterator<File> it = list.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 += it.next().length();
        }
        return j6;
    }
}
