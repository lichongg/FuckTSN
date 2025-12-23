package com.bxkj.student.common.utils;

import android.content.Context;
import android.widget.Toast;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.c0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17799a;

    /* renamed from: b, reason: collision with root package name */
    private Context f17800b;

    /* renamed from: c, reason: collision with root package name */
    private SmartRefreshLayout f17801c;

    /* renamed from: d, reason: collision with root package name */
    private rx.e<c0<ResponseBody>> f17802d;

    /* renamed from: e, reason: collision with root package name */
    protected int f17803e = 10;

    /* renamed from: f, reason: collision with root package name */
    protected int f17804f = 1;

    /* renamed from: g, reason: collision with root package name */
    protected int f17805g = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements n2.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SmartRefreshLayout f17806a;

        a(final SmartRefreshLayout val$refreshLayout) {
            this.f17806a = val$refreshLayout;
        }

        @Override // n2.d
        public void a(m2.h refreshlayout) {
            g gVar = g.this;
            gVar.f17804f = 1;
            gVar.d();
        }

        @Override // n2.b
        public void f(m2.h refreshlayout) {
            g gVar = g.this;
            int i6 = gVar.f17805g;
            int i7 = gVar.f17803e;
            int i8 = i6 / i7;
            int i9 = gVar.f17804f;
            if (i6 % i7 != 0) {
                i8++;
            }
            if (i9 >= i8) {
                this.f17806a.Q();
                Toast.makeText(g.this.f17800b, "没有了", 0).show();
            } else {
                gVar.f17804f = i9 + 1;
                gVar.d();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            g.this.f17805g = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d6 = g.this.f17799a.d();
            if (g.this.f17804f != 1) {
                d6.addAll(list);
                list = d6;
            }
            g.this.f17799a.g(list);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            g.this.f17801c.Y();
            g.this.f17801c.Q();
        }
    }

    public void d() {
        Http.with(this.f17800b).hideLoadingDialog().setObservable(this.f17802d).setDataListener(new b());
    }

    public int e() {
        return this.f17804f;
    }

    public int f() {
        return this.f17803e;
    }

    public g g(final SmartRefreshLayout refreshLayout) {
        this.f17801c = refreshLayout;
        refreshLayout.D(new a(refreshLayout));
        return this;
    }

    public g h(CommonAdapter<Map<String, Object>> adapter) {
        this.f17799a = adapter;
        return this;
    }

    public g i(rx.e<c0<ResponseBody>> observe) {
        this.f17802d = observe;
        return this;
    }

    public g(Context mContext) {
        this.f17800b = mContext;
    }
}
