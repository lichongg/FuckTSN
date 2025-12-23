package com.bxkj.student.life.mall.order;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import java.util.Map;
import x.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f19365a;

    /* renamed from: b, reason: collision with root package name */
    private String f19366b;

    /* renamed from: c, reason: collision with root package name */
    private String f19367c;

    /* renamed from: d, reason: collision with root package name */
    private String f19368d;

    /* renamed from: e, reason: collision with root package name */
    private String f19369e;

    /* renamed from: f, reason: collision with root package name */
    private String f19370f;

    /* renamed from: g, reason: collision with root package name */
    private String f19371g;

    /* renamed from: h, reason: collision with root package name */
    private e f19372h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.life.mall.order.a$a, reason: collision with other inner class name */
    class C0255a implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19373a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.life.mall.order.a$a$a, reason: collision with other inner class name */
        class C0256a extends HttpCallBack {
            C0256a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                Toast.makeText(a.this.f19365a, "订单取消成功", 0).show();
                if (a.this.f19372h != null) {
                    a.this.f19372h.a();
                }
            }
        }

        C0255a(final String val$orderId) {
            this.f19373a = val$orderId;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(a.this.f19365a).setObservable(((g) Http.getApiService(g.class)).x(this.f19373a)).setDataListener(new C0256a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19376a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.life.mall.order.a$b$a, reason: collision with other inner class name */
        class C0257a extends HttpCallBack {
            C0257a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                Toast.makeText(a.this.f19365a, "订单删除成功", 0).show();
                if (a.this.f19372h != null) {
                    a.this.f19372h.a();
                }
            }
        }

        b(final String val$orderId) {
            this.f19376a = val$orderId;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(a.this.f19365a).setObservable(((g) Http.getApiService(g.class)).e(this.f19376a)).setDataListener(new C0257a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19379a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.life.mall.order.a$c$a, reason: collision with other inner class name */
        class C0258a extends HttpCallBack {
            C0258a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                Toast.makeText(a.this.f19365a, "订单审核中", 0).show();
                if (a.this.f19372h != null) {
                    a.this.f19372h.a();
                }
            }
        }

        c(final String val$orderId) {
            this.f19379a = val$orderId;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(a.this.f19365a).setObservable(((g) Http.getApiService(g.class)).h(this.f19379a)).setDataListener(new C0258a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19382a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.life.mall.order.a$d$a, reason: collision with other inner class name */
        class C0259a extends HttpCallBack {
            C0259a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                Toast.makeText(a.this.f19365a, "确认收货成功", 0).show();
                if (a.this.f19372h != null) {
                    a.this.f19372h.a();
                }
            }
        }

        d(final String val$orderId) {
            this.f19382a = val$orderId;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(a.this.f19365a).setObservable(((g) Http.getApiService(g.class)).r(this.f19382a)).setDataListener(new C0259a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e {
        void a();
    }

    private void c(final String orderId) {
        new iOSTwoButtonDialog(this.f19365a).setMessage("确定要申请退款吗？").setRightButtonOnClickListener(new c(orderId)).show();
    }

    private void e(final String orderId) {
        new iOSTwoButtonDialog(this.f19365a).setMessage("确定要取消订单吗？").setRightButtonOnClickListener(new C0255a(orderId)).show();
    }

    private void f(final String orderId) {
        new iOSTwoButtonDialog(this.f19365a).setMessage("确定已收到货物吗？").setRightButtonOnClickListener(new d(orderId)).show();
    }

    private void g(final String orderId) {
        new iOSTwoButtonDialog(this.f19365a).setMessage("确定要删除订单吗？").setRightButtonOnClickListener(new b(orderId)).show();
    }

    public void d(String text, String orderId, String order_sn, double pay_amount) {
        if (text.equals("立即付款")) {
            this.f19365a.startActivity(new Intent(this.f19365a, (Class<?>) OrderPayActivity.class).putExtra("orderId", orderId).putExtra("orderNo", order_sn).putExtra("payPrice", pay_amount));
            return;
        }
        if (text.equals("取消订单")) {
            e(orderId);
            return;
        }
        if (text.equals("删除订单")) {
            g(orderId);
            return;
        }
        if (text.equals("申请退款")) {
            c(orderId);
            return;
        }
        if (text.equals("确认收货")) {
            f(orderId);
        } else if (text.equals("查看物流")) {
            this.f19365a.startActivity(new Intent(this.f19365a, (Class<?>) ViewLogisticsActivity.class).putExtra("orderId", orderId).putExtra("shipping_id", this.f19370f).putExtra("invoice_no", this.f19371g));
        } else {
            text.equals("立即评价");
        }
    }

    public String h() {
        return this.f19366b;
    }

    public String i() {
        return this.f19369e;
    }

    public String j() {
        return this.f19367c;
    }

    public String k() {
        return this.f19368d;
    }

    public String l() {
        return this.f19371g;
    }

    public String m() {
        return this.f19370f;
    }

    public a n(String goodsId) {
        this.f19366b = goodsId;
        return this;
    }

    public a o(String goodsImage) {
        this.f19369e = goodsImage;
        return this;
    }

    public a p(String goodsName) {
        this.f19367c = goodsName;
        return this;
    }

    public a q(String goodsPrice) {
        this.f19368d = goodsPrice;
        return this;
    }

    public a r(String invoice_no) {
        this.f19371g = invoice_no;
        return this;
    }

    public void s(e refreshOrderListener) {
        this.f19372h = refreshOrderListener;
    }

    public a t(String shipping_id) {
        this.f19370f = shipping_id;
        return this;
    }

    public a(Context mContext) {
        this.f19365a = mContext;
    }
}
