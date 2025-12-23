package com.bxkj.student.home.teaching.evaluateteacher;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class EvaluateActivity extends BaseActivity {
    private ViewPager W;
    private Button X;
    private Button Y;
    private Button Z;

    /* renamed from: a0, reason: collision with root package name */
    private RelativeLayout f18091a0;

    /* renamed from: b0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f18092b0;

    /* renamed from: c0, reason: collision with root package name */
    private List<Map<String, Object>> f18093c0 = new ArrayList();

    /* renamed from: k0, reason: collision with root package name */
    private List<Fragment> f18094k0 = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements PopupWindow.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout f18095a;

        a(final FrameLayout val$outsideView) {
            this.f18095a = val$outsideView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            FrameLayout frameLayout = this.f18095a;
            if (frameLayout != null) {
                frameLayout.setForeground(new ColorDrawable(0));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements BaseActivity.c {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            EvaluateActivity.this.y0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements BaseActivity.c {
        c() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            EvaluateActivity.this.s0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements iOSTwoButtonDialog.RightButtonOnClick {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            EvaluateActivity.this.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        e(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            int i6;
            Resources resources;
            int i7;
            holder.J(2131298997, String.valueOf(holder.f() + 1));
            if (JsonParse.getString(stringObjectMap, "checkScore").isEmpty()) {
                i6 = R.drawable.round_cicler_gray;
            } else {
                i6 = R.drawable.dot_cicler_blue;
            }
            holder.l(2131298997, i6);
            if (JsonParse.getString(stringObjectMap, "checkScore").isEmpty()) {
                resources = EvaluateActivity.this.getResources();
                i7 = 2131099731;
            } else {
                resources = EvaluateActivity.this.getResources();
                i7 = 2131099737;
            }
            holder.K(2131298997, resources.getColor(i7));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            EvaluateActivity.this.f18091a0.setVisibility(0);
            EvaluateActivity.this.f18093c0 = (List) data.get("data");
            EvaluateActivity.this.w0();
            EvaluateActivity.this.f18092b0.c(EvaluateActivity.this.f18093c0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) EvaluateActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends FragmentPagerAdapter {
        g(FragmentManager fm) {
            super(fm);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return EvaluateActivity.this.f18094k0.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) EvaluateActivity.this.f18094k0.get(position);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                EvaluateActivity.this.finish();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                EvaluateActivity.this.finish();
            }
        }

        h() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            new iOSOneButtonDialog(((BaseActivity) EvaluateActivity.this).T).setMessage("评价成功").setButtonOnClickListener(new a()).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) EvaluateActivity.this).T).setMessage(msg).setButtonOnClickListener(new b()).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i implements ViewPager.OnPageChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private int f18106a;

        i() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f18106a = state;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (this.f18106a == 1 && positionOffsetPixels == 0) {
                if (position == 0) {
                    EvaluateActivity.this.g0("已经是第一条了");
                } else if (position == EvaluateActivity.this.W.getAdapter().getCount() - 1) {
                    EvaluateActivity.this.g0("已经是最后一条了");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            EvaluateActivity.this.setTitle((position + 1) + "/" + EvaluateActivity.this.W.getAdapter().getCount());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class j implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PopupWindow f18108a;

        j(final PopupWindow val$popupWindow) {
            this.f18108a = val$popupWindow;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            EvaluateActivity.this.W.setCurrentItem(position);
            this.f18108a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        for (int i6 = 0; i6 < this.f18093c0.size(); i6++) {
            EvaluateFragment evaluateFragment = new EvaluateFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i6);
            evaluateFragment.setArguments(bundle);
            this.f18094k0.add(evaluateFragment);
        }
        this.W.setAdapter(new g(getSupportFragmentManager()));
        setTitle("1/" + this.W.getAdapter().getCount());
    }

    private void s0() {
        this.W.addOnPageChangeListener(new i());
    }

    private void u0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).X0(LoginUser.getLoginUser().getUserId())).setDataListener(new f());
    }

    private void x0() {
        if (this.W.getCurrentItem() == this.W.getAdapter().getCount() - 1) {
            g0("已经是最后一条了");
        } else {
            ViewPager viewPager = this.W;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        PopupWindow popupWindow = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this.T).inflate(R.layout.pop_dialog, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.gv);
        gridView.setAdapter((ListAdapter) this.f18092b0);
        gridView.setOnItemClickListener(new j(popupWindow));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131299265);
        popupWindow.setOnDismissListener(new a(frameLayout));
        popupWindow.setContentView(inflate);
        popupWindow.showAsDropDown(findViewById(2131298702));
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
        }
    }

    private void z0() {
        if (this.W.getCurrentItem() == 0) {
            g0("已经是第一条了");
        } else {
            this.W.setCurrentItem(r0.getCurrentItem() - 1);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        s0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.f18092b0 = new e(this.T, R.layout.item_for_number, this.f18093c0);
        u0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        a0(R.mipmap.more_white, new b());
        Y(new c());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void s0() {
        new iOSTwoButtonDialog(this.T).setMessage("正在评价，是否放弃评价？").setRightButtonOnClickListener(new d()).show();
    }

    public List<Map<String, Object>> v0() {
        return this.f18093c0;
    }

    private void t0() {
        String stringExtra = getIntent().getStringExtra("stuTeacherCurriculumId");
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.f18093c0.size(); i6++) {
            Map<String, Object> map = this.f18093c0.get(i6);
            String string = JsonParse.getString(map, "checkScore");
            if (string.isEmpty()) {
                g0("您第" + (i6 + 1) + "条还未评价");
                return;
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("contentId", JsonParse.getString(map, "id"));
            arrayMap.put("score", string);
            arrayList.add(arrayMap);
        }
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).N(stringExtra, LoginUser.getLoginUser().getUserId(), JSON.toJSONString(arrayList))).setDataListener(new h());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_evaluate_teacher;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (ViewPager) findViewById(R.id.vp);
        this.X = (Button) findViewById(R.id.bt_previous);
        this.Y = (Button) findViewById(R.id.bt_next);
        this.Z = (Button) findViewById(2131296623);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131298068);
        this.f18091a0 = relativeLayout;
        relativeLayout.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        switch (v5.getId()) {
            case R.id.bt_next /* 2131296622 */:
                x0();
                break;
            case 2131296623:
                t0();
                break;
            case R.id.bt_previous /* 2131296628 */:
                z0();
                break;
        }
    }
}
