package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class EmptyView extends View implements l.j {
    private List<View> ae;
    private final AtomicBoolean av;
    private boolean az;
    private j cw;

    /* renamed from: g, reason: collision with root package name */
    private final Handler f27753g;

    /* renamed from: i, reason: collision with root package name */
    private int f27754i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f27755j;
    private String jy;

    /* renamed from: m, reason: collision with root package name */
    private List<View> f27756m;
    private final AtomicBoolean oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private View f27757r;
    private int tl;
    private List<View> up;
    private com.bytedance.sdk.openadsdk.core.tj.n vl;
    private boolean ws;
    private volatile boolean xt;

    public interface j {
        void j();

        void j(View view, Map<String, Object> map);

        void j(boolean z5);

        void xt();
    }

    public static final class xt implements j {

        /* renamed from: j, reason: collision with root package name */
        private final j f27762j;

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
        public void j(final boolean z5) {
            if (this.f27762j != null) {
                com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.xt.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.f27762j.j(z5);
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
        public void xt() {
            if (this.f27762j != null) {
                com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.xt.3
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.f27762j.xt();
                    }
                });
            }
        }

        public xt(j jVar) {
            this.f27762j = jVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
        public void j() {
            if (this.f27762j != null) {
                com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.xt.2
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.f27762j.j();
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.EmptyView.j
        public void j(final View view, final Map<String, Object> map) {
            if (this.f27762j != null) {
                com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.xt.4
                    @Override // java.lang.Runnable
                    public void run() {
                        xt.this.f27762j.j(view, map);
                    }
                });
            }
        }
    }

    public EmptyView(Context context, View view) {
        super(v.getContext());
        this.xt = true;
        this.oq = new AtomicBoolean(true);
        this.qv = 1000;
        this.ws = false;
        this.az = false;
        this.av = new AtomicBoolean(false);
        this.f27754i = 0;
        this.f27757r = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.f27753g = new com.bytedance.sdk.component.utils.l(com.bytedance.sdk.openadsdk.l.ae.xt(), this);
        this.ws = v.xt().lv();
        this.az = v.xt().ua();
    }

    static /* synthetic */ int cw(EmptyView emptyView) {
        int i6 = emptyView.f27754i;
        emptyView.f27754i = i6 + 1;
        return i6;
    }

    private void cw() {
        j jVar;
        if (this.oq.getAndSet(true) || (jVar = this.cw) == null) {
            return;
        }
        jVar.xt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.f27753g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!EmptyView.this.xt || EmptyView.this.f27755j) {
                    return;
                }
                EmptyView.this.f27755j = true;
                EmptyView.cw(EmptyView.this);
                Message obtain = Message.obtain();
                obtain.what = 1;
                EmptyView.this.f27753g.handleMessage(obtain);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        this.f27753g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.3
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.f27755j = false;
                EmptyView.this.f27753g.removeMessages(1);
            }
        });
    }

    public void setAdType(int i6) {
        this.tl = i6;
    }

    public void setCallback(j jVar) {
        this.cw = new xt(jVar);
    }

    public void setNeedCheckingShow(final boolean z5) {
        this.av.set(false);
        this.f27753g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.4
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.xt = z5;
                if (!z5 && EmptyView.this.f27755j) {
                    EmptyView.this.up();
                } else {
                    if (!z5 || EmptyView.this.f27755j) {
                        return;
                    }
                    EmptyView.this.r();
                }
            }
        });
    }

    public void setRefClickViews(List<View> list) {
        this.up = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.f27756m = list;
    }

    public void setRefDirectDownloadViews(List<View> list) {
        this.ae = list;
    }

    private void xt() {
        j jVar;
        if (!this.oq.getAndSet(false) || (jVar = this.cw) == null) {
            return;
        }
        jVar.j();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.av.set(false);
        r();
        if (this.ws) {
            j("checkWhenAddToWindow");
        }
        xt();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.av.set(false);
        up();
        cw();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        j jVar = this.cw;
        if (jVar != null) {
            jVar.j(z5);
        }
    }

    public void j() {
        j(this.up, (com.bytedance.sdk.openadsdk.core.xt.r) null);
        j(this.f27756m, (com.bytedance.sdk.openadsdk.core.xt.r) null);
        j(this.ae, (com.bytedance.sdk.openadsdk.core.xt.r) null);
    }

    public void j(List<View> list, com.bytedance.sdk.openadsdk.core.xt.r rVar) {
        if (com.bytedance.sdk.component.utils.oq.xt(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(rVar);
                    view.setOnTouchListener(rVar);
                }
            }
        }
    }

    public void j(final String str) {
        this.f27753g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EmptyView.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.equals(str, "checkWhenClicked")) {
                    if (!EmptyView.this.xt) {
                        EmptyView.this.j(8, (String) null);
                    }
                    if (!EmptyView.this.f27755j) {
                        EmptyView.this.j(EmptyView.this.av.get() ? 10 : 9, (String) null);
                    }
                }
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = str;
                EmptyView.this.f27753g.handleMessage(obtain);
            }
        });
    }

    public void j(com.bytedance.sdk.openadsdk.core.tj.n nVar, String str) {
        this.vl = nVar;
        this.jy = str;
    }

    public EmptyView(Context context, View view, int i6) {
        this(context, view);
        this.qv = i6;
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        int i6;
        boolean z5 = false;
        boolean z6 = this.ws || this.az;
        Object obj = message.obj;
        if ((obj instanceof String) && (TextUtils.equals("checkWhenAddToWindow", obj.toString()) || TextUtils.equals("checkWhenClicked", message.obj.toString()))) {
            z5 = true;
        }
        if (message.what != 1) {
            return;
        }
        if (this.f27755j || (z6 && z5)) {
            String str = null;
            if (!z6) {
                if (uf.xt(this.f27757r, 20, this.tl)) {
                    up();
                    j jVar = this.cw;
                    if (jVar != null) {
                        jVar.j(this.f27757r, null);
                        return;
                    }
                    return;
                }
                this.f27753g.sendEmptyMessageDelayed(1, this.qv);
                return;
            }
            try {
                i6 = uf.j(this.f27757r, 20, this.tl);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.j(th);
                str = th.getMessage();
                i6 = 7;
            }
            if (i6 == 0) {
                up();
                if (this.cw != null && !this.av.get()) {
                    this.av.set(true);
                    this.cw.j(this.f27757r, j(z5, message));
                }
            } else if (!z5) {
                this.f27753g.sendEmptyMessageDelayed(1, this.qv);
            }
            Object obj2 = message.obj;
            if ((obj2 instanceof String) && TextUtils.equals("checkWhenClicked", obj2.toString())) {
                j(i6, str);
            }
        }
    }

    private Map<String, Object> j(boolean z5, Message message) {
        if (!z5) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (TextUtils.equals("checkWhenAddToWindow", message.obj.toString())) {
            hashMap.put("show_send_type", 2);
            return hashMap;
        }
        if (TextUtils.equals("checkWhenClicked", message.obj.toString())) {
            hashMap.put("show_send_type", 1);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, String str) {
        HashMap hashMap = new HashMap();
        if (i6 == 0) {
            hashMap.put("is_success", Boolean.TRUE);
        } else {
            hashMap.put("is_success", Boolean.FALSE);
            if (i6 != 7) {
                str = uf.j(i6);
            }
            hashMap.put("error_code", Integer.valueOf(i6));
            hashMap.put("error_message", str);
        }
        hashMap.put("checking_cnt", Integer.valueOf(this.f27754i));
        com.bytedance.sdk.openadsdk.core.jy.cw.j(this.vl, this.jy, hashMap);
    }
}
