package com.bykv.vk.openvk.component.video.j.xt.m;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bykv.vk.openvk.component.video.api.m.cw;
import com.bykv.vk.openvk.component.video.j.xt.m;
import com.bykv.vk.openvk.component.video.j.xt.up;
import com.bytedance.sdk.component.utils.vl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public static final boolean f23077j = cw.xt();
    private C0311j cw;
    private HashMap<String, Boolean> xt;

    /* renamed from: com.bykv.vk.openvk.component.video.j.xt.m.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: com.bykv.vk.openvk.component.video.j.xt.m.j$j, reason: collision with other inner class name */
    class C0311j extends com.bytedance.sdk.component.oq.r.cw {
        private boolean cw;

        /* renamed from: r, reason: collision with root package name */
        private final Queue<C0312j> f23080r;
        private Queue<C0312j> up;
        private Queue<C0312j> xt;

        /* renamed from: com.bykv.vk.openvk.component.video.j.xt.m.j$j$j, reason: collision with other inner class name */
        private class C0312j {
            public String[] cw;

            /* renamed from: j, reason: collision with root package name */
            public int f23081j;

            /* renamed from: m, reason: collision with root package name */
            public r f23082m;

            /* renamed from: r, reason: collision with root package name */
            public int f23083r;
            public String up;
            public String xt;

            public C0312j() {
            }
        }

        private C0312j j(int i6, r rVar) {
            this.f23080r.size();
            C0312j poll = this.f23080r.poll();
            if (poll == null) {
                poll = new C0312j();
            }
            poll.f23081j = i6;
            poll.f23082m = rVar;
            return poll;
        }

        private synchronized void xt(C0312j c0312j) {
            this.up.add(c0312j);
            notify();
        }

        public C0311j() {
            super("VideoCachePreloader$PreLoadThread");
            this.f23080r = new ArrayBlockingQueue(10);
            this.xt = new LinkedBlockingQueue();
            this.cw = true;
            this.up = new LinkedBlockingQueue();
        }

        private void cw(C0312j c0312j) {
            if (c0312j == null) {
                return;
            }
            this.xt.offer(c0312j);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.cw) {
                synchronized (this) {
                    try {
                        if (!this.up.isEmpty()) {
                            j();
                        }
                        while (!this.xt.isEmpty()) {
                            C0312j poll = this.xt.poll();
                            if (poll != null) {
                                int i6 = poll.f23081j;
                                if (i6 == 0) {
                                    String[] strArr = poll.cw;
                                    if (strArr != null && strArr.length > 0) {
                                        ArrayList arrayList = new ArrayList();
                                        for (String str : poll.cw) {
                                            if (com.bykv.vk.openvk.component.video.j.cw.j.j(str)) {
                                                arrayList.add(str);
                                            }
                                        }
                                        com.bykv.vk.openvk.component.video.j.xt.r.cw().j(false, !TextUtils.isEmpty(poll.up), poll.f23083r, poll.xt, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                    }
                                } else if (i6 == 1) {
                                    com.bykv.vk.openvk.component.video.j.xt.r.cw().j(poll.xt);
                                } else if (i6 == 2) {
                                    com.bykv.vk.openvk.component.video.j.xt.r.cw().r();
                                } else if (i6 == 3) {
                                    com.bykv.vk.openvk.component.video.j.xt.r.cw().r();
                                    if (up.xt() != null) {
                                        up.xt().j();
                                    }
                                    if (up.j() != null) {
                                        up.j().j();
                                    }
                                } else if (i6 == 4) {
                                    com.bykv.vk.openvk.component.video.j.xt.r.cw().r();
                                    this.cw = false;
                                }
                                j(poll);
                            }
                        }
                        try {
                            wait();
                        } catch (InterruptedException e6) {
                            vl.j(e6);
                        }
                    } finally {
                    }
                }
            }
        }

        private void j(C0312j c0312j) {
            c0312j.cw = null;
            c0312j.xt = null;
            c0312j.f23081j = -1;
            c0312j.f23082m = null;
            this.f23080r.offer(c0312j);
        }

        private void j() {
            while (true) {
                C0312j poll = this.up.poll();
                if (poll == null) {
                    return;
                }
                poll.xt = poll.f23082m.av();
                poll.cw = new String[]{poll.f23082m.av()};
                int xt = poll.f23082m.xt();
                if (xt <= 0) {
                    xt = poll.f23082m.m();
                }
                poll.f23083r = xt;
                poll.up = poll.f23082m.i();
                if (!TextUtils.isEmpty(poll.f23082m.i())) {
                    poll.xt = poll.f23082m.i();
                }
                poll.f23082m = null;
                cw(poll);
            }
        }

        public void j(r rVar) {
            xt(j(0, rVar));
        }
    }

    private static class xt {

        /* renamed from: j, reason: collision with root package name */
        private static final j f23084j = new j(null);
    }

    /* synthetic */ j(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static j j() {
        return xt.f23084j;
    }

    public boolean xt() {
        if (this.cw != null) {
            return true;
        }
        com.bykv.vk.openvk.component.video.j.xt.j.cw cw = cw();
        if (cw == null) {
            return false;
        }
        up.j(true);
        up.xt(true);
        up.j(1);
        m.j().r();
        try {
            C0311j c0311j = new C0311j();
            this.cw = c0311j;
            c0311j.setName("csj_video_cache_preloader");
            this.cw.start();
            up.j(cw, com.bykv.vk.openvk.component.video.api.cw.getContext());
            com.bykv.vk.openvk.component.video.j.xt.r.cw();
            com.bykv.vk.openvk.component.video.j.xt.r.cw().j(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private j() {
        this.xt = new HashMap<>();
        xt();
    }

    private static com.bykv.vk.openvk.component.video.j.xt.j.cw cw() {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xt.xt(com.bykv.vk.openvk.component.video.api.cw.getContext()), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        com.bykv.vk.openvk.component.video.j.xt.j.cw cwVar = null;
        try {
            com.bykv.vk.openvk.component.video.j.xt.j.cw cwVar2 = new com.bykv.vk.openvk.component.video.j.xt.j.cw(file);
            try {
                cwVar2.j(104857600L);
                return cwVar2;
            } catch (IOException e6) {
                e = e6;
                cwVar = cwVar2;
                vl.j(e);
                return cwVar;
            }
        } catch (IOException e7) {
            e = e7;
        }
    }

    public boolean j(r rVar) {
        if (!xt()) {
            return false;
        }
        this.cw.j(rVar);
        return true;
    }

    public String xt(r rVar) {
        if (rVar == null) {
            return null;
        }
        boolean isEmpty = TextUtils.isEmpty(rVar.i());
        return m.j().j(false, !isEmpty, !isEmpty ? rVar.i() : rVar.av(), rVar.av());
    }
}
