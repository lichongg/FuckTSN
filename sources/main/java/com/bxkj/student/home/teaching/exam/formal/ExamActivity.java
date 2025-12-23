package com.bxkj.student.home.teaching.exam.formal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
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
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.y;
import com.bxkj.base.v2.common.ext.b0;
import com.bxkj.base.view.CountDownTimeView;
import com.bxkj.student.R;
import com.bxkj.student.common.view.CustomViewPager;
import com.bxkj.student.home.teaching.exam.FaceDetectExamActivity;
import com.bxkj.student.home.teaching.exam.formal.ExamActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.jvm.functions.Function0;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ExamActivity extends BaseActivity {
    private CountDownTimer F0;
    private ConnectivityManager G0;
    private h H0;
    private PopupWindow J0;
    private iOSOneButtonDialog K0;
    private int N0;
    private int O0;
    private int P0;
    private CustomViewPager W;
    public Button X;
    public Button Y;
    private Button Z;
    private iOSOneButtonDialog Z0;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f18161a0;

    /* renamed from: b0, reason: collision with root package name */
    private RelativeLayout f18163b0;

    /* renamed from: c0, reason: collision with root package name */
    private CountDownTimeView f18164c0;

    /* renamed from: k0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f18165k0;

    /* renamed from: p0, reason: collision with root package name */
    private CountDownTimer f18166p0;
    private int I0 = 0;
    private List<Map<String, Object>> L0 = new ArrayList();
    private List<Fragment> M0 = new ArrayList();
    private List<Integer> Q0 = new ArrayList();
    private List<Integer> R0 = new ArrayList();
    private final int S0 = 170;
    private final int T0 = 187;
    private final int U0 = 255;
    private int V0 = 0;
    public int W0 = 1;
    private int X0 = 10800;
    public boolean Y0 = true;

    /* renamed from: a1, reason: collision with root package name */
    private boolean f18162a1 = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            int color;
            int color2;
            holder.J(2131298997, String.valueOf(holder.f() + 1));
            boolean equals = "1".equals(JsonParse.getString(stringObjectMap, "questionType"));
            int i6 = R.drawable.dot_cicler_blue;
            if (equals) {
                List<Map<String, Object>> list = JsonParse.getList(stringObjectMap, "answers");
                ArrayList arrayList = new ArrayList();
                for (Map<String, Object> map : list) {
                    if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                        arrayList.add(JsonParse.getString(map, "answerId"));
                    }
                }
                if (arrayList.isEmpty()) {
                    i6 = R.drawable.round_cicler_gray;
                }
                holder.l(2131298997, i6);
                if (arrayList.isEmpty()) {
                    color2 = ExamActivity.this.getResources().getColor(2131099731);
                } else {
                    color2 = ExamActivity.this.getResources().getColor(2131099737);
                }
                holder.K(2131298997, color2);
                return;
            }
            if (JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty()) {
                i6 = R.drawable.round_cicler_gray;
            }
            holder.l(2131298997, i6);
            if (JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty()) {
                color = ExamActivity.this.getResources().getColor(2131099731);
            } else {
                color = ExamActivity.this.getResources().getColor(2131099737);
            }
            holder.K(2131298997, color);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ n1 c() {
            ExamActivity.this.startActivityForResult(new Intent(((BaseActivity) ExamActivity.this).T, (Class<?>) FaceDetectExamActivity.class), 170);
            ExamActivity.this.overridePendingTransition(2130771987, 2130771986);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(View view) {
            b0.x(((BaseActivity) ExamActivity.this).U, "人脸识别", new Function0() { // from class: com.bxkj.student.home.teaching.exam.formal.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 c6;
                    c6 = ExamActivity.b.this.c();
                    return c6;
                }
            });
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamActivity.this.V0 = JsonParse.getInt(data, "isReturnExam");
            ExamActivity.this.N0 = JsonParse.getInt(data, "isExamStartFace");
            ExamActivity.this.O0 = JsonParse.getInt(data, "isExamEndFace");
            ExamActivity.this.P0 = JsonParse.getInt(data, "isExamFaceNum");
            ExamActivity examActivity = ExamActivity.this;
            examActivity.W0 = JsonParse.getInt(data, "examTimeType", examActivity.W0);
            ExamActivity examActivity2 = ExamActivity.this;
            examActivity2.X0 = JsonParse.getInt(data, "examTime", examActivity2.X0);
            ExamActivity.this.L0 = JsonParse.getList(data, "examArray");
            if (ExamActivity.this.L0 == null || ExamActivity.this.L0.size() <= 0) {
                new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).T).setMessage("没有题目").show();
                return;
            }
            ExamActivity.this.l1();
            if (ExamActivity.this.P0 > 0) {
                ExamActivity examActivity3 = ExamActivity.this;
                examActivity3.Q0 = y.a(examActivity3.L0.size(), ExamActivity.this.P0);
            }
            if (ExamActivity.this.N0 != 1) {
                ExamActivity.this.j1();
                return;
            }
            ExamActivity.this.K0 = new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).T).setMessage("考试开始前，请先进行人脸识别").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.formal.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamActivity.b.this.d(view);
                }
            });
            ExamActivity.this.K0.setClickAutoCancel(false);
            ExamActivity.this.K0.setCancelable(false);
            ExamActivity.this.K0.setCanceledOnTouchOutside(false);
            ExamActivity.this.K0.show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).T).setMessage("获取考试内容异常，请联系管理员").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends FragmentPagerAdapter {
        c(FragmentManager fm) {
            super(fm);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ExamActivity.this.M0.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) ExamActivity.this.M0.get(position);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends CountDownTimer {
        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            ExamActivity.this.f18164c0.i(ExamActivity.this.X0, ((int) millisUntilFinished) / 1000);
        }

        d(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ExamActivity.this.f18164c0.i(ExamActivity.this.X0, 0);
            if (ExamActivity.this.L0 != null) {
                ((Map) ExamActivity.this.L0.get(ExamActivity.this.W.getCurrentItem())).put("timeFinish", Boolean.TRUE);
                ExamActivity.this.u1();
                ExamActivity.this.X.setEnabled(true);
                ExamActivity.this.Y.setEnabled(true);
                ExamActivity.this.Y0 = true;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SimpleDateFormat f18171a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long millisInFuture, long countDownInterval, final SimpleDateFormat val$simpleDateFormat) {
            super(millisInFuture, countDownInterval);
            this.f18171a = val$simpleDateFormat;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ExamActivity.this.e1();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            ExamActivity.this.f18161a0.setText(this.f18171a.format(Long.valueOf(millisUntilFinished)));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f18173a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                ExamActivity.this.finish();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                ExamActivity.this.finish();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                ExamActivity.this.finish();
            }
        }

        f(final boolean val$autoCommit) {
            this.f18173a = val$autoCommit;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            String str = (this.f18173a && ExamActivity.this.O0 == 0) ? "时间已到，已经为您自动交卷成功" : "交卷成功";
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).T);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setMessage(str).setButtonOnClickListener(new a()).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if (this.f18173a) {
                new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).T).setButtonOnClickListener(new c()).setMessage("时间已到，自动交卷失败，请重新考试").show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).T).setButtonOnClickListener(new b()).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements ViewPager.OnPageChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private int f18178a;

        g() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f18178a = state;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (this.f18178a == 1 && positionOffsetPixels == 0) {
                if (position == 0) {
                    ExamActivity.this.g0("已经是第一题了");
                } else if (position == ExamActivity.this.W.getAdapter().getCount() - 1) {
                    ExamActivity.this.g0("已经是最后一题了");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            ExamActivity.this.setTitle("理论考试" + (position + 1) + "/" + ExamActivity.this.W.getAdapter().getCount());
            ExamActivity examActivity = ExamActivity.this;
            if (examActivity.W0 != 1) {
                if (examActivity.f18166p0 != null) {
                    ExamActivity.this.f18166p0.cancel();
                }
                boolean z5 = false;
                ExamActivity.this.f18164c0.i(ExamActivity.this.X0, 0);
                if (!"1".equals(JsonParse.getString((Map) ExamActivity.this.L0.get(ExamActivity.this.W.getCurrentItem()), "questionType"))) {
                    if (JsonParse.getBoolean((Map) ExamActivity.this.L0.get(ExamActivity.this.W.getCurrentItem()), "timeFinish") || !TextUtils.isEmpty(JsonParse.getString((Map) ExamActivity.this.L0.get(ExamActivity.this.W.getCurrentItem()), "checkAnswerId"))) {
                        return;
                    }
                    ExamActivity.this.y1();
                    return;
                }
                for (Map<String, Object> map : JsonParse.getList((Map) ExamActivity.this.L0.get(ExamActivity.this.W.getCurrentItem()), "answers")) {
                    if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                        z5 = true;
                    }
                }
                if (JsonParse.getBoolean((Map) ExamActivity.this.L0.get(ExamActivity.this.W.getCurrentItem()), "timeFinish") || z5) {
                    return;
                }
                ExamActivity.this.y1();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class h extends BroadcastReceiver {
        /* synthetic */ h(ExamActivity examActivity, l lVar) {
            this();
        }

        private h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!ExamActivity.this.R0()) {
                new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).T).setMessage("已脱离后台监控，请检查网络后开始考试").show();
            } else if (!ExamActivity.this.f18162a1) {
                new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).T).setMessage("网络已恢复，请继续开始考试").show();
            }
            com.orhanobut.logger.j.c("网络状态发生变化");
            ExamActivity examActivity = ExamActivity.this;
            examActivity.f18162a1 = examActivity.R0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        h1(true);
    }

    private boolean f1(int index) {
        final int i6 = index + 1;
        if (!this.Q0.contains(Integer.valueOf(i6)) || this.R0.contains(Integer.valueOf(i6))) {
            return false;
        }
        iOSOneButtonDialog buttonOnClickListener = new iOSOneButtonDialog(this.T).setMessage("考试已暂停，请先进行人脸识别").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.formal.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamActivity.this.n1(i6, view);
            }
        });
        this.Z0 = buttonOnClickListener;
        buttonOnClickListener.setClickAutoCancel(false);
        this.Z0.setCancelable(false);
        this.Z0.setCanceledOnTouchOutside(false);
        this.Z0.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        if (f1(0)) {
            return;
        }
        this.f18163b0.setVisibility(0);
        k1();
        this.f18165k0.c(this.L0);
        if (this.W0 == 1) {
            this.f18161a0.setVisibility(0);
            this.f18164c0.setVisibility(8);
            z1();
        } else {
            this.X.setEnabled(false);
            this.Y.setEnabled(false);
            this.Y0 = false;
            this.f18161a0.setVisibility(8);
            this.f18164c0.setVisibility(0);
            y1();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        h hVar = new h(this, null);
        this.H0 = hVar;
        registerReceiver(hVar, intentFilter);
    }

    private void k1() {
        Fragment fragment;
        int i6 = 0;
        while (i6 < this.L0.size()) {
            Map<String, Object> map = this.L0.get(i6);
            if ("0".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new RadioExamFragment();
            } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new CheckboxExamFragment();
            } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new RadioExamFragment();
            } else {
                this.L0.remove(i6);
                i6--;
                fragment = null;
            }
            if (fragment != null) {
                Bundle bundle = new Bundle();
                SeralizableMap seralizableMap = new SeralizableMap();
                seralizableMap.setMap(map);
                bundle.putInt("index", i6);
                bundle.putSerializable("seralizableMap", seralizableMap);
                fragment.setArguments(bundle);
                this.M0.add(fragment);
            }
            i6++;
        }
        this.W.setAdapter(new c(getSupportFragmentManager()));
        setTitle("理论考试1/" + this.W.getAdapter().getCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R0() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            this.G0 = connectivityManager;
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return activeNetworkInfo.isAvailable();
            }
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private void d1() {
        this.W.addOnPageChangeListener(new g());
    }

    public static /* synthetic */ void h0(FrameLayout frameLayout) {
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(0));
        }
    }

    private void h1(final boolean autoCommit) {
        int i6;
        String str;
        String stringExtra = getIntent().getStringExtra("stuTeacherCurriculumId");
        final List<Map<String, Object>> arrayList = new ArrayList<>();
        final List<Map<String, Object>> arrayList2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        while (i7 < this.L0.size()) {
            Map<String, Object> map = this.L0.get(i7);
            boolean z5 = JsonParse.getBoolean(map, "timeFinish");
            if ("1".equals(JsonParse.getString(this.L0.get(i7), "questionType"))) {
                List<Map> list = (List) this.L0.get(i7).get("answers");
                ArrayList arrayList3 = new ArrayList();
                for (Map map2 : list) {
                    int i8 = i7;
                    String str2 = stringExtra;
                    if (map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue()) {
                        arrayList3.add(JsonParse.getString(map2, "answerId"));
                    }
                    stringExtra = str2;
                    i7 = i8;
                }
                i6 = i7;
                str = stringExtra;
                Map<String, Object> arrayMap = new ArrayMap<>();
                arrayMap.put("question", JsonParse.getString(map, "questionId"));
                arrayMap.put("answers", arrayList3);
                arrayMap.put("scoreId", JsonParse.getString(map, "scoreId"));
                arrayList2.add(arrayMap);
                if (!z5 && arrayList3.isEmpty() && !autoCommit) {
                    sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                    sb.append(String.valueOf(i6 + 1));
                }
            } else {
                i6 = i7;
                str = stringExtra;
                String string = JsonParse.getString(map, "checkAnswerId");
                if (!z5 && string.isEmpty() && !autoCommit) {
                    sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                    sb.append(String.valueOf(i6 + 1));
                }
                Map<String, Object> arrayMap2 = new ArrayMap<>();
                arrayMap2.put("question", JsonParse.getString(map, "questionId"));
                arrayMap2.put("answers", string);
                arrayMap2.put("scoreId", JsonParse.getString(map, "scoreId"));
                arrayList.add(arrayMap2);
            }
            i7 = i6 + 1;
            stringExtra = str;
        }
        final String str3 = stringExtra;
        if (autoCommit) {
            g1(autoCommit, str3, arrayList, arrayList2);
            return;
        }
        new iOSTwoButtonDialog(this.T).setMessage(TextUtils.isEmpty(sb) ? "确定要提交试卷吗？" : "您还有第" + sb.toString() + "题未作答，是否要提交试卷？").setLeftButtonText("继续答题").setRightButtonText("直接交卷").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.exam.formal.c
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                ExamActivity.this.p1(autoCommit, str3, arrayList, arrayList2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1() {
        if (this.V0 != 1) {
            this.X.setVisibility(8);
            return;
        }
        this.X.setVisibility(0);
        a0(R.mipmap.more_white, new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.exam.formal.d
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                ExamActivity.this.q1();
            }
        });
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 m1(int i6) {
        Intent intent = new Intent(this.T, (Class<?>) FaceDetectExamActivity.class);
        intent.putExtra("faceIndex", i6);
        startActivityForResult(intent, 187);
        overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n1(final int i6, View view) {
        b0.x(this.U, "人脸识别", new Function0() { // from class: com.bxkj.student.home.teaching.exam.formal.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 m12;
                m12 = ExamActivity.this.m1(i6);
                return m12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 o1() {
        startActivityForResult(new Intent(this.T, (Class<?>) FaceDetectExamActivity.class), 255);
        overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p1(boolean z5, String str, List list, List list2) {
        if (this.O0 == 1) {
            b0.x(this.U, "人脸识别", new Function0() { // from class: com.bxkj.student.home.teaching.exam.formal.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 o12;
                    o12 = ExamActivity.this.o1();
                    return o12;
                }
            });
        } else {
            g1(z5, str, list, list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q1() {
        if (this.Y0) {
            if (this.f18162a1) {
                w1();
            } else {
                new iOSOneButtonDialog(this.T).setMessage("已脱离后台监控，请检查网络后开始考试").show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1() {
        Fragment fragment;
        List<Fragment> list = this.M0;
        if (list == null || (fragment = list.get(this.W.getCurrentItem())) == null) {
            return;
        }
        if (fragment instanceof RadioExamFragment) {
            ((RadioExamFragment) fragment).P();
        } else if (fragment instanceof CheckboxExamFragment) {
            ((CheckboxExamFragment) fragment).O();
        }
    }

    private void v1() {
        if (this.W.getCurrentItem() == this.W.getAdapter().getCount() - 1) {
            g0("已经是最后一题了");
        } else {
            if (f1(this.W.getCurrentItem() + 1)) {
                return;
            }
            u1();
            CustomViewPager customViewPager = this.W;
            customViewPager.setCurrentItem(customViewPager.getCurrentItem() + 1);
        }
    }

    private void w1() {
        this.J0 = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this.T).inflate(R.layout.pop_dialog, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.gv);
        gridView.setAdapter((ListAdapter) this.f18165k0);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.exam.formal.f
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                ExamActivity.this.t1(adapterView, view, i6, j6);
            }
        });
        this.J0.setBackgroundDrawable(new BitmapDrawable());
        this.J0.setOutsideTouchable(true);
        this.J0.setFocusable(true);
        final FrameLayout frameLayout = (FrameLayout) findViewById(2131299265);
        this.J0.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.bxkj.student.home.teaching.exam.formal.g
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ExamActivity.h0(frameLayout);
            }
        });
        this.J0.setContentView(inflate);
        this.J0.showAsDropDown(findViewById(2131298702));
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
        }
    }

    private void x1() {
        if (this.W.getCurrentItem() == 0) {
            g0("已经是第一题了");
            return;
        }
        int currentItem = this.W.getCurrentItem() - 1;
        if (f1(currentItem)) {
            return;
        }
        u1();
        this.W.setCurrentItem(currentItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1() {
        new SimpleDateFormat("HH:mm:ss").setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        this.X.setEnabled(false);
        this.Y.setEnabled(false);
        this.Y0 = false;
        d dVar = new d(this.X0 * 1000, 1000L);
        this.f18166p0 = dVar;
        dVar.start();
    }

    private void z1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        e eVar = new e(this.X0 * 1000, 1000L, simpleDateFormat);
        this.F0 = eVar;
        eVar.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        d1();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("理论考试");
        Y(new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.exam.formal.a
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                ExamActivity.this.r1();
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed, reason: merged with bridge method [inline-methods] */
    public void r1() {
        new iOSTwoButtonDialog(this.T).setMessage("正在考试，是否放弃考试？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.exam.formal.b
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                ExamActivity.this.s1();
            }
        }).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (!this.f18162a1) {
            new iOSOneButtonDialog(this.T).setMessage("已脱离后台监控，请检查网络后开始考试").show();
        }
        switch (v5.getId()) {
            case R.id.bt_next /* 2131296622 */:
                v1();
                break;
            case 2131296623:
                h1(false);
                break;
            case R.id.bt_previous /* 2131296628 */:
                x1();
                break;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        CountDownTimer countDownTimer = this.F0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.f18166p0;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        h hVar = this.H0;
        if (hVar != null) {
            unregisterReceiver(hVar);
        }
        super.onDestroy();
    }

    private void g1(final boolean autoCommit, String stuTeacherCurriculumId, List<Map<String, Object>> radioData, List<Map<String, Object>> checkData) {
        String jSONString = JSON.toJSONString(radioData);
        String jSONString2 = JSON.toJSONString(checkData);
        com.orhanobut.logger.j.h(jSONString);
        com.orhanobut.logger.j.h(jSONString2);
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).z1(stuTeacherCurriculumId, LoginUser.getLoginUser().getUserId(), jSONString, jSONString2, "", null, this.I0)).setDataListener(new f(autoCommit));
    }

    private void i1() {
        String str;
        String str2;
        String str3 = null;
        if (getIntent().hasExtra("stuTeacherCurriculumId")) {
            str = getIntent().getStringExtra("stuTeacherCurriculumId");
        } else {
            str = null;
        }
        if (getIntent().hasExtra("selectIds")) {
            str2 = getIntent().getStringExtra("selectIds");
        } else {
            str3 = str;
            str2 = null;
        }
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).z0(str3, str2, LoginUser.getLoginUser().getUserId(), this.I0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s1() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(AdapterView adapterView, View view, int i6, long j6) {
        if (f1(i6)) {
            return;
        }
        u1();
        this.W.setCurrentItem(i6);
        this.J0.dismiss();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_exam;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("onlineType")) {
            this.I0 = getIntent().getIntExtra("onlineType", 0);
        }
        this.f18165k0 = new a(this.T, R.layout.item_for_number, this.L0);
        i1();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (CustomViewPager) findViewById(R.id.vp);
        this.X = (Button) findViewById(R.id.bt_previous);
        this.Y = (Button) findViewById(R.id.bt_next);
        this.Z = (Button) findViewById(2131296623);
        this.f18161a0 = (TextView) findViewById(2131299158);
        this.f18163b0 = (RelativeLayout) findViewById(2131298068);
        this.f18164c0 = (CountDownTimeView) findViewById(R.id.cdtv);
        this.W.setPagingEnabled(false);
        this.f18163b0.setVisibility(8);
        this.f18164c0.setTextSize(cn.bluemobi.dylan.base.utils.d.d(this.T, 20.0f));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 170 && resultCode == 187) {
            iOSOneButtonDialog iosonebuttondialog = this.K0;
            if (iosonebuttondialog != null && iosonebuttondialog.isShowing()) {
                this.K0.dismiss();
            }
            j1();
            new iOSOneButtonDialog(this.T).setMessage("人脸识别成功，请开始答题").show();
            return;
        }
        if (requestCode == 187 && resultCode == 187) {
            if (data.hasExtra("faceIndex")) {
                int intExtra = data.getIntExtra("faceIndex", 0);
                com.orhanobut.logger.j.c("onActivityResult-faceIndex=" + intExtra);
                this.R0.add(Integer.valueOf(intExtra));
                int i6 = intExtra - 1;
                if (i6 == 0) {
                    j1();
                } else {
                    u1();
                    this.W.setCurrentItem(i6);
                    PopupWindow popupWindow = this.J0;
                    if (popupWindow != null && popupWindow.isShowing()) {
                        this.J0.dismiss();
                    }
                }
            }
            iOSOneButtonDialog iosonebuttondialog2 = this.Z0;
            if (iosonebuttondialog2 != null && iosonebuttondialog2.isShowing()) {
                this.Z0.dismiss();
            }
            new iOSOneButtonDialog(this.T).setMessage("人脸识别成功，请继续答题").show();
            return;
        }
        if (requestCode == 255 && resultCode == 187) {
            h1(true);
        } else if (resultCode == 170) {
            startActivityForResult(data.setClass(this.T, FaceDetectExamActivity.class), requestCode);
            overridePendingTransition(2130771987, 2130771986);
        }
    }
}
