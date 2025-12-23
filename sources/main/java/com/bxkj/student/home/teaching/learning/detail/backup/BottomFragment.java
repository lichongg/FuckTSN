package com.bxkj.student.home.teaching.learning.detail.backup;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
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
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class BottomFragment extends BaseFragment {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private j F;

    /* renamed from: j, reason: collision with root package name */
    private Button f18514j;

    /* renamed from: k, reason: collision with root package name */
    private LinearLayout f18515k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f18516l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f18517m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f18518n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f18519o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f18520p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f18521q;

    /* renamed from: r, reason: collision with root package name */
    private BaseMediaObject f18522r;

    /* renamed from: s, reason: collision with root package name */
    private ShareAction f18523s;

    /* renamed from: t, reason: collision with root package name */
    private UMShareListener f18524t;

    /* renamed from: u, reason: collision with root package name */
    private String f18525u;

    /* renamed from: v, reason: collision with root package name */
    private String f18526v;

    /* renamed from: w, reason: collision with root package name */
    private int f18527w;

    /* renamed from: x, reason: collision with root package name */
    private int f18528x;

    /* renamed from: y, reason: collision with root package name */
    private int f18529y;

    /* renamed from: z, reason: collision with root package name */
    private int f18530z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements UMShareListener {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.BottomFragment$a$a, reason: collision with other inner class name */
        class C0225a extends HttpCallBack {
            C0225a() {
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
            Http.with(((BaseFragment) BottomFragment.this).f1096g).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).v(BottomFragment.this.f18526v, "3", 1)).setDataListener(new C0225a());
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
            bottomFragment.f18527w = bottomFragment.f18527w == 0 ? 1 : 0;
            BottomFragment.this.r0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BottomFragment bottomFragment = BottomFragment.this;
            bottomFragment.f18528x = bottomFragment.f18528x == 0 ? 1 : 0;
            BottomFragment.this.m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(View view) {
        t0(SHARE_MEDIA.WEIXIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        t0(SHARE_MEDIA.WEIXIN_CIRCLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(View view) {
        t0(SHARE_MEDIA.QQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        t0(SHARE_MEDIA.QZONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        Http.with(this.f1096g).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).v(this.f18526v, "1", this.f18527w == 0 ? 1 : 0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        Http.with(this.f1096g).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).v(this.f18526v, "2", this.f18528x == 0 ? 1 : 0)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        startActivity(new Intent(this.f1096g, (Class<?>) QuestionListActivity.class).putExtra("type", 1).putExtra("resourceId", this.f18525u));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        if (this.f18528x == 1) {
            n0();
        } else {
            o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        if (this.f18527w == 1) {
            p0();
        } else {
            q0();
        }
    }

    private void t0(SHARE_MEDIA platform) {
        this.f18523s.setPlatform(platform);
        this.f18523s.setCallback(this.f18524t);
        BaseMediaObject baseMediaObject = this.f18522r;
        if (baseMediaObject instanceof UMVideo) {
            this.f18523s.withMedia((UMVideo) baseMediaObject);
        } else if (baseMediaObject instanceof UMWeb) {
            this.f18523s.withMedia((UMWeb) baseMediaObject);
        }
        this.f18523s.share();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f18524t = new a();
        this.f18518n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.f0(view);
            }
        });
        this.f18519o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.g0(view);
            }
        });
        this.f18520p.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.h0(view);
            }
        });
        this.f18521q.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.i0(view);
            }
        });
        this.f18516l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.j0(view);
            }
        });
        this.f18517m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.k0(view);
            }
        });
        this.f18514j.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomFragment.this.l0(view);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        j jVar = this.F;
        if (jVar != null) {
            TimerTask timerTask = jVar.f18567m;
            if (timerTask != null) {
                timerTask.cancel();
            }
            Timer timer = this.F.f18566l;
            if (timer != null) {
                timer.cancel();
            }
            j jVar2 = this.F;
            Handler handler = jVar2.f18573s;
            if (handler != null) {
                handler.removeCallbacks(jVar2.f18567m);
            }
        }
        super.onDestroy();
    }

    public void s0(BaseMediaObject baseMediaObject) {
        this.f18522r = baseMediaObject;
    }

    private void n0() {
        Drawable drawable = getResources().getDrawable(R.mipmap.goods_collection_star_red);
        drawable.setBounds(0, 0, u.a(21.0f, this.f1096g), u.a(21.0f, this.f1096g));
        this.f18517m.setCompoundDrawables(null, drawable, null, null);
        this.f18517m.setText("已收藏");
    }

    private void o0() {
        Drawable drawable = getResources().getDrawable(R.mipmap.empty_star);
        drawable.setBounds(0, 0, u.a(21.0f, this.f1096g), u.a(21.0f, this.f1096g));
        this.f18517m.setCompoundDrawables(null, drawable, null, null);
        this.f18517m.setText("收藏");
    }

    private void p0() {
        Drawable drawable = getResources().getDrawable(R.mipmap.zan_focus);
        drawable.setBounds(0, 0, u.a(21.0f, this.f1096g), u.a(21.0f, this.f1096g));
        this.f18516l.setCompoundDrawables(null, drawable, null, null);
        this.f18516l.setText("已点赞");
    }

    private void q0() {
        Drawable drawable = getResources().getDrawable(R.mipmap.zan_normal);
        drawable.setBounds(0, 0, u.a(21.0f, this.f1096g), u.a(21.0f, this.f1096g));
        this.f18516l.setCompoundDrawables(null, drawable, null, null);
        this.f18516l.setText("点赞");
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        Bundle arguments = getArguments();
        if (arguments.containsKey("id")) {
            this.f18525u = arguments.getString("id");
        }
        if (arguments.containsKey("detailId")) {
            this.f18526v = arguments.getString("detailId");
        }
        if (arguments.containsKey("isLike")) {
            this.f18527w = arguments.getInt("isLike", 0);
        }
        if (arguments.containsKey("isCollection")) {
            this.f18528x = arguments.getInt("isCollection", 0);
        }
        if (arguments.containsKey("duration")) {
            this.f18529y = arguments.getInt("duration", 0);
        }
        if (arguments.containsKey("popTime")) {
            this.f18530z = arguments.getInt("popTime", 0);
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
        r0();
        m0();
        this.f18523s = new ShareAction(getActivity());
        int i6 = this.D;
        if (i6 == 0) {
            j jVar = new j(this, this.f1096g, this.f18529y, this.f18530z, this.f18525u, this.f18526v, this.f18514j, this.A, this.E);
            this.F = jVar;
            if (this.f18529y == 0) {
                this.f18514j.setVisibility(8);
            } else {
                jVar.N();
            }
            this.f18514j.setEnabled(false);
            return;
        }
        if (i6 == 1) {
            this.f18514j.setText("已完成");
            this.f18514j.setEnabled(false);
        } else if (i6 == 2) {
            this.f18514j.setText("开始答题");
            this.f18514j.setEnabled(true);
        } else if (i6 == 3) {
            this.f18514j.setText("查看答题");
            this.f18514j.setEnabled(true);
        } else {
            this.f18514j.setVisibility(8);
            this.f18514j.setEnabled(false);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f18514j = (Button) c(R.id.bt_question);
        this.f18515k = (LinearLayout) c(2131298015);
        this.f18516l = (TextView) c(R.id.tv_zan);
        this.f18517m = (TextView) c(R.id.tv_collect);
        this.f18518n = (TextView) c(R.id.tv_wechat);
        this.f18519o = (TextView) c(R.id.tv_moments);
        this.f18520p = (TextView) c(R.id.tv_qq);
        this.f18521q = (TextView) c(R.id.tv_qzone);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_bottom;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 170 && resultCode == 187) {
            j jVar = this.F;
            if (jVar != null) {
                jVar.B();
            }
            new iOSOneButtonDialog(this.f1096g).setMessage("人脸识别成功，请继续学习").show();
            return;
        }
        if (requestCode == 170 && resultCode == 170) {
            startActivityForResult(data.setClass(this.f1096g, FaceDetectExamActivity.class), requestCode);
            this.f1097h.overridePendingTransition(2130771987, 2130771986);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
