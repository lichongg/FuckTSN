package com.bytedance.sdk.openadsdk.core.ugeno.component.xt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.cw.g;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.adsdk.ugeno.xt.j;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.ugeno.component.xt.up;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends com.bytedance.adsdk.ugeno.xt.j<RecyclerView> {

    /* renamed from: d, reason: collision with root package name */
    private up.cw f30662d;
    private RecyclerView.g ll;
    private Map<Integer, g.j> oy;
    private up px;
    private xt qe;
    private r xw;
    private List<cw> yl;

    public interface xt {
        void j();

        void j(int i6, int i7);

        void j(int i6, View view, cw cwVar);

        void j(RecyclerView recyclerView, int i6);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(ViewGroup.LayoutParams layoutParams) {
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j
    public j.C0328j tl() {
        return null;
    }

    private static class j extends RecyclerView.tl implements up.j {

        /* renamed from: j, reason: collision with root package name */
        private int f30664j;

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.up.j
        public View cw() {
            return null;
        }

        public j(int i6) {
            this.f30664j = i6;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.tl
        public void j(Rect rect, View view, RecyclerView recyclerView, RecyclerView.kt ktVar) {
            super.j(rect, view, recyclerView, ktVar);
            int i6 = this.f30664j;
            rect.left = i6;
            rect.right = i6;
            rect.bottom = i6;
            if (recyclerView.m(view) == 0) {
                rect.top = this.f30664j;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.up.j
        public void J_() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.up.j
        public void K_() {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j, com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        up upVar = new up(this.xt);
        this.px = upVar;
        upVar.j(this.ki);
        this.px.j(this.f23874t);
        this.px.j(this.uq);
        this.px.j(this.xw);
        this.px.j(this.f30662d);
        this.px.j(this.oy);
        this.px.j(this.yl);
        ((RecyclerView) this.up).setLayoutManager(this.ll);
        ((RecyclerView) this.up).setAdapter(this.px);
        ((RecyclerView) this.up).j((RecyclerView.tl) new j((int) tl.j(this.xt, 10.0f)));
        ((RecyclerView) this.up).j((RecyclerView.ws) new com.bytedance.sdk.openadsdk.core.ugeno.component.xt.xt(new com.bytedance.sdk.openadsdk.core.ugeno.component.xt.j()) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.xt
            public void j(int i6, int i7) {
                if (m.this.qe != null) {
                    m.this.qe.j(i6, i7);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.xt
            public void xt(RecyclerView recyclerView, int i6) {
                if (m.this.qe != null) {
                    m.this.qe.j(recyclerView, i6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.xt
            public void j(int i6, View view) {
                if (m.this.qe == null || i6 < 0 || m.this.yl == null || i6 >= m.this.yl.size()) {
                    return;
                }
                m.this.qe.j(i6, view, (cw) m.this.yl.get(i6));
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.xt
            public void j() {
                if (m.this.qe != null) {
                    m.this.qe.j();
                }
            }
        });
    }

    public m(Context context) {
        super(context);
        this.oy = new HashMap();
    }

    public void j(r rVar) {
        this.xw = rVar;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public View j() {
        return new RecyclerView(this.xt);
    }

    public void j(xt xtVar) {
        this.qe = xtVar;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(JSONObject jSONObject) {
        super.j(jSONObject);
    }

    public void j(List<cw> list) {
        this.yl = list;
    }

    public void j(int i6, Object obj) {
        up upVar = this.px;
        if (upVar != null) {
            upVar.j(obj);
            this.px.j(i6, obj);
        }
    }

    public void j(up.r rVar) {
        this.px.j(rVar);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        if (cwVar == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.xt.j) this).f23887j.add(cwVar);
        if (cwVar.la() != null) {
            this.oy.put(Integer.valueOf(cwVar.la().hashCode()), cwVar.l());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        str.getClass();
        if (str.equals("layoutType") && !TextUtils.equals("grid", str2)) {
            this.ll = new com.bytedance.sdk.component.widget.recycler.up(this.xt);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void xt(List<cw> list) {
        if (this.px == null || list == null || list.isEmpty()) {
            return;
        }
        if (this.yl == null) {
            this.yl = new ArrayList();
        }
        int size = this.yl.size();
        this.yl.addAll(list);
        this.px.j(list);
        this.px.j(size, this.yl.size());
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, ViewGroup.LayoutParams layoutParams) {
        ((com.bytedance.adsdk.ugeno.xt.j) this).f23887j.add(cwVar);
        this.oy.put(Integer.valueOf(cwVar.la().hashCode()), cwVar.l());
    }
}
