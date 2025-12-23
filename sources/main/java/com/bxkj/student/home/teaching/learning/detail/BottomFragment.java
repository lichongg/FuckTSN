package com.bxkj.student.home.teaching.learning.detail;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.v2.common.ext.b0;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.exam.FaceDetectExamActivity;
import com.bxkj.student.home.teaching.learning.question.list.QuestionListActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class BottomFragment extends BaseFragment {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private k G;

    /* renamed from: j, reason: collision with root package name */
    private Button f18485j;

    /* renamed from: k, reason: collision with root package name */
    private LinearLayout f18486k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f18487l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f18488m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f18489n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f18490o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f18491p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f18492q;

    /* renamed from: r, reason: collision with root package name */
    private BaseMediaObject f18493r;

    /* renamed from: s, reason: collision with root package name */
    private ShareAction f18494s;

    /* renamed from: t, reason: collision with root package name */
    private UMShareListener f18495t;

    /* renamed from: u, reason: collision with root package name */
    private String f18496u;

    /* renamed from: v, reason: collision with root package name */
    private String f18497v;

    /* renamed from: w, reason: collision with root package name */
    private int f18498w;

    /* renamed from: x, reason: collision with root package name */
    private int f18499x;

    /* renamed from: y, reason: collision with root package name */
    private int f18500y;

    /* renamed from: z, reason: collision with root package name */
    private int f18501z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements UMShareListener {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.learning.detail.BottomFragment$a$a, reason: collision with other inner class name */
        class C0224a extends HttpCallBack {
            C0224a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
            }
        }

        a() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(((BaseFragment) BottomFragment.this).f1096g, " 分享取消了", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Http.with(((BaseFragment) BottomFragment.this).f1096g).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).v(BottomFragment.this.f18497v, "3", 1)).setDataListener(new C0224a());
            Toast.makeText(((BaseFragment) BottomFragment.this).f1096g, " 分享成功啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t5) {
            t5.printStackTrace();
            Toast.makeText(((BaseFragment) BottomFragment.this).f1096g, " 分享失败啦," + t5.getMessage(), 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BottomFragment bottomFragment = BottomFragment.this;
            bottomFragment.f18498w = bottomFragment.f18498w == 0 ? 1 : 0;
            BottomFragment.this.t0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BottomFragment bottomFragment = BottomFragment.this;
            bottomFragment.f18499x = bottomFragment.f18499x == 0 ? 1 : 0;
            BottomFragment.this.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        w0(SHARE_MEDIA.WEIXIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(View view) {
        w0(SHARE_MEDIA.WEIXIN_CIRCLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        w0(SHARE_MEDIA.QQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        w0(SHARE_MEDIA.QZONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        Http.with(this.f1096g).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).v(this.f18497v, "1", this.f18498w == 0 ? 1 : 0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        Http.with(this.f1096g).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).v(this.f18497v, "2", this.f18499x == 0 ? 1 : 0)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        startActivity(new Intent(this.f1096g, (Class<?>) QuestionListActivity.class).putExtra("type", 1).putExtra("resourceId", this.f18496u));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 n0(Intent intent, int i6) {
        startActivityForResult(intent.setClass(this.f1096g, FaceDetectExamActivity.class), i6);
        this.f1097h.overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        if (this.f18499x == 1) {
            p0();
        } else {
            q0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        if (this.f18498w == 1) {
            r0();
        } else {
            s0();
        }
    }

    private void w0(SHARE_MEDIA platform) {
        this.f18494s.setPlatform(platform);
        this.f18494s.setCallback(this.f18495t);
        BaseMediaObject baseMediaObject = this.f18493r;
        if (baseMediaObject instanceof UMVideo) {
            this.f18494s.withMedia((UMVideo) baseMediaObject);
        } else if (baseMediaObject instanceof UMWeb) {
            this.f18494s.withMedia((UMWeb) baseMediaObject);
        }
        this.f18494s.share();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f18495t = new a();
        this.f18489n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.g0(view);
            }
        });
        this.f18490o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.h0(view);
            }
        });
        this.f18491p.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.i0(view);
            }
        });
        this.f18492q.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.j0(view);
            }
        });
        this.f18487l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.k0(view);
            }
        });
        this.f18488m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.l0(view);
            }
        });
        this.f18485j.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.m0(view);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        k kVar = this.G;
        if (kVar != null) {
            kVar.T();
        }
        k kVar2 = this.G;
        if (kVar2 != null) {
            kVar2.P();
        }
        super.onDestroy();
    }

    public void u0(boolean b6) {
        k kVar = this.G;
        if (kVar != null) {
            kVar.Q(b6);
        }
    }

    public void v0(BaseMediaObject baseMediaObject) {
        this.f18493r = baseMediaObject;
    }

    private void p0() {
        Drawable drawable = getResources().getDrawable(R.mipmap.goods_collection_star_red);
        drawable.setBounds(0, 0, cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1096g), cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1096g));
        this.f18488m.setCompoundDrawables(null, drawable, null, null);
        this.f18488m.setText("已收藏");
    }

    private void q0() {
        Drawable drawable = getResources().getDrawable(R.mipmap.empty_star);
        drawable.setBounds(0, 0, cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1096g), cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1096g));
        this.f18488m.setCompoundDrawables(null, drawable, null, null);
        this.f18488m.setText("收藏");
    }

    private void r0() {
        Drawable drawable = getResources().getDrawable(R.mipmap.zan_focus);
        drawable.setBounds(0, 0, cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1096g), cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1096g));
        this.f18487l.setCompoundDrawables(null, drawable, null, null);
        this.f18487l.setText("已点赞");
    }

    private void s0() {
        Drawable drawable = getResources().getDrawable(R.mipmap.zan_normal);
        drawable.setBounds(0, 0, cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1096g), cn.bluemobi.dylan.base.utils.u.a(21.0f, this.f1096g));
        this.f18487l.setCompoundDrawables(null, drawable, null, null);
        this.f18487l.setText("点赞");
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        Bundle arguments = getArguments();
        if (arguments.containsKey("id")) {
            this.f18496u = arguments.getString("id");
        }
        if (arguments.containsKey("detailId")) {
            this.f18497v = arguments.getString("detailId");
        }
        if (arguments.containsKey("isLike")) {
            this.f18498w = arguments.getInt("isLike", 0);
        }
        if (arguments.containsKey("isCollection")) {
            this.f18499x = arguments.getInt("isCollection", 0);
        }
        if (arguments.containsKey("duration")) {
            this.f18500y = arguments.getInt("duration", 0);
        }
        if (arguments.containsKey("popTime")) {
            this.f18501z = arguments.getInt("popTime", 0);
        }
        if (arguments.containsKey("hasQuestion")) {
            this.A = arguments.getInt("hasQuestion", 0);
        }
        if (arguments.containsKey("isComplete")) {
            this.B = arguments.getInt("isComplete", 0);
        }
        if (arguments.containsKey("isOk")) {
            this.C = arguments.getInt("isOk", 0);
        }
        if (arguments.containsKey("opreateFlag")) {
            this.D = arguments.getInt("opreateFlag", 0);
        }
        if (arguments.containsKey("valType")) {
            this.E = arguments.getInt("valType", 1);
        }
        if (arguments.containsKey("integral")) {
            this.F = arguments.getInt("integral", 1);
        }
        t0();
        o0();
        this.f18494s = new ShareAction(getActivity());
        int i6 = this.D;
        if (i6 == 0) {
            this.G = new k(this, this.f1096g, this.f18500y, this.f18501z, this.f18496u, this.f18497v, this.f18485j, this.A, this.E, this.F);
            if (this.f18500y == 0) {
                this.f18485j.setVisibility(8);
            } else {
                ((LearnDetailActivity) getActivity()).v0(true);
                this.G.S();
            }
            this.f18485j.setEnabled(false);
            return;
        }
        if (i6 == 1) {
            this.f18485j.setText("已完成");
            this.f18485j.setEnabled(false);
        } else if (i6 == 2) {
            this.f18485j.setText("开始答题");
            this.f18485j.setEnabled(true);
        } else if (i6 == 3) {
            this.f18485j.setText("查看答题");
            this.f18485j.setEnabled(true);
        } else {
            this.f18485j.setVisibility(8);
            this.f18485j.setEnabled(false);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f18485j = (Button) c(R.id.bt_question);
        this.f18486k = (LinearLayout) c(2131298015);
        this.f18487l = (TextView) c(R.id.tv_zan);
        this.f18488m = (TextView) c(R.id.tv_collect);
        this.f18489n = (TextView) c(R.id.tv_wechat);
        this.f18490o = (TextView) c(R.id.tv_moments);
        this.f18491p = (TextView) c(R.id.tv_qq);
        this.f18492q = (TextView) c(R.id.tv_qzone);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_bottom;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(final int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 170 && resultCode == 187) {
            k kVar = this.G;
            if (kVar != null) {
                kVar.D();
            }
            new iOSOneButtonDialog(this.f1096g).setMessage("人脸识别成功，请继续学习").show();
            return;
        }
        if (requestCode == 170 && resultCode == 170) {
            b0.x((FragmentActivity) this.f1096g, "人脸识别", new Function0() { // from class: com.bxkj.student.home.teaching.learning.detail.n
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 n02;
                    n02 = BottomFragment.this.n0(data, requestCode);
                    return n02;
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
