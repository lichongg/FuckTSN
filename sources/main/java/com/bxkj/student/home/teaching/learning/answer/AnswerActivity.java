package com.bxkj.student.home.teaching.learning.answer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;
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
import com.bxkj.base.view.CountDownTimeView;
import com.bxkj.student.R;
import com.bxkj.student.common.view.CustomViewPager;
import com.bxkj.student.home.teaching.learning.answer.AnswerActivity;
import com.bxkj.student.home.teaching.learning.detail.backup.H5Activity;
import com.bxkj.student.home.teaching.learning.detail.backup.VideoPlayActivity;
import com.bxkj.student.home.teaching.learning.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AnswerActivity extends BaseActivity {
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> F0;
    private CountDownTimer G0;
    private ConnectivityManager H0;
    private l I0;
    private String J0;
    private int K0 = 60000;
    private List<Map<String, Object>> L0 = new ArrayList();
    private List<Fragment> M0 = new ArrayList();
    private boolean N0 = true;
    private TextView W;
    private TextView X;
    private CountDownTimeView Y;
    private CustomViewPager Z;

    /* renamed from: a0, reason: collision with root package name */
    public Button f18437a0;

    /* renamed from: b0, reason: collision with root package name */
    public Button f18438b0;

    /* renamed from: c0, reason: collision with root package name */
    private Button f18439c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f18440k0;

    /* renamed from: p0, reason: collision with root package name */
    private RelativeLayout f18441p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PopupWindow f18442a;

        a(final PopupWindow val$popupWindow) {
            this.f18442a = val$popupWindow;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            AnswerActivity.this.Z.setCurrentItem(position);
            this.f18442a.dismiss();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements PopupWindow.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout f18444a;

        b(final FrameLayout val$outsideView) {
            this.f18444a = val$outsideView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            FrameLayout frameLayout = this.f18444a;
            if (frameLayout != null) {
                frameLayout.setForeground(new ColorDrawable(0));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements BaseActivity.c {
        c() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            AnswerActivity.this.z2();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements iOSTwoButtonDialog.RightButtonOnClick {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            AnswerActivity.this.finish();
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
                    color2 = AnswerActivity.this.getResources().getColor(2131099731);
                } else {
                    color2 = AnswerActivity.this.getResources().getColor(2131099737);
                }
                holder.K(2131298997, color2);
                return;
            }
            if (JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty()) {
                i6 = R.drawable.round_cicler_gray;
            }
            holder.l(2131298997, i6);
            if (JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty()) {
                color = AnswerActivity.this.getResources().getColor(2131099731);
            } else {
                color = AnswerActivity.this.getResources().getColor(2131099737);
            }
            holder.K(2131298997, color);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {
        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            AnswerActivity.this.f18441p0.setVisibility(0);
            AnswerActivity.this.L0 = (List) data.get("data");
            AnswerActivity.this.J0();
            AnswerActivity.this.F0.c(AnswerActivity.this.L0);
        }

        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).T).setMessage("获取考试内容异常，请联系管理员").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).T).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            AnswerActivity.this.N0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends FragmentPagerAdapter {
        g(FragmentManager fm) {
            super(fm);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return AnswerActivity.this.M0.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) AnswerActivity.this.M0.get(position);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SimpleDateFormat f18451a;

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            AnswerActivity.this.Y.i(60, ((int) millisUntilFinished) / 1000);
            AnswerActivity.this.f18440k0.setText(this.f18451a.format(Long.valueOf(millisUntilFinished)));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long millisInFuture, long countDownInterval, final SimpleDateFormat val$simpleDateFormat) {
            super(millisInFuture, countDownInterval);
            this.f18451a = val$simpleDateFormat;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            AnswerActivity.this.Y.i(60, 0);
            ((Map) AnswerActivity.this.L0.get(AnswerActivity.this.Z.getCurrentItem())).put("timeFinish", Boolean.TRUE);
            Fragment fragment = (Fragment) AnswerActivity.this.M0.get(AnswerActivity.this.Z.getCurrentItem());
            if (fragment instanceof RadioAnswerFragment) {
                ((RadioAnswerFragment) fragment).R();
                AnswerActivity.this.f18437a0.setEnabled(true);
                AnswerActivity.this.f18438b0.setEnabled(true);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f18453a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f18454b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f18455c;

        i(final boolean val$autoCommit, final List val$radioData, final List val$checkData) {
            this.f18453a = val$autoCommit;
            this.f18454b = val$radioData;
            this.f18455c = val$checkData;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            AnswerActivity.this.F0(this.f18453a, this.f18454b, this.f18455c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class j extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f18457a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                AnswerActivity.this.finish();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                AnswerActivity.this.finish();
            }
        }

        j(final boolean val$autoCommit) {
            this.f18457a = val$autoCommit;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            String str = this.f18457a ? "时间已到，已经为您自动交卷成功" : "交卷成功";
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).T);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setMessage(str).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.answer.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnswerActivity.j.this.b(view);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            H5Activity h5Activity = (H5Activity) cn.bluemobi.dylan.base.utils.a.n().getActivity(H5Activity.class);
            VideoPlayActivity videoPlayActivity = (VideoPlayActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(VideoPlayActivity.class);
            if (h5Activity != null) {
                h5Activity.m0();
            }
            if (videoPlayActivity != null) {
                videoPlayActivity.v0();
            }
            AnswerActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if (this.f18457a) {
                new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).T).setButtonOnClickListener(new b()).setMessage("时间已到，自动交卷失败，请重新考试").show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).T).setButtonOnClickListener(new a()).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class k implements ViewPager.OnPageChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private int f18461a;

        k() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f18461a = state;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (this.f18461a == 1 && positionOffsetPixels == 0) {
                if (position == 0) {
                    AnswerActivity.this.g0("已经是第一题了");
                } else if (position == AnswerActivity.this.Z.getAdapter().getCount() - 1) {
                    AnswerActivity.this.g0("已经是最后一题了");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            AnswerActivity.this.setTitle((position + 1) + "/" + AnswerActivity.this.Z.getAdapter().getCount());
            if (AnswerActivity.this.G0 != null) {
                AnswerActivity.this.G0.cancel();
            }
            AnswerActivity.this.Y.i(60, 0);
            if (!JsonParse.getBoolean((Map) AnswerActivity.this.L0.get(AnswerActivity.this.Z.getCurrentItem()), "timeFinish") && TextUtils.isEmpty(JsonParse.getString((Map) AnswerActivity.this.L0.get(AnswerActivity.this.Z.getCurrentItem()), "checkAnswerId"))) {
                AnswerActivity.this.f18437a0.setEnabled(false);
                AnswerActivity.this.f18438b0.setEnabled(false);
                AnswerActivity.this.N0();
            }
            AnswerActivity.this.X.setText("出题人：" + JsonParse.getString((Map) AnswerActivity.this.L0.get(position), "questionsSetter"));
            AnswerActivity.this.W.setText("课程名称：" + JsonParse.getString((Map) AnswerActivity.this.L0.get(position), "curriculum"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class l extends BroadcastReceiver {
        private l() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    }

    private void D0() {
        G0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        Fragment fragment;
        int i6 = 0;
        while (i6 < this.L0.size()) {
            if ("0".equals(JsonParse.getString(this.L0.get(i6), "questionType"))) {
                fragment = new RadioAnswerFragment();
            } else if ("1".equals(JsonParse.getString(this.L0.get(i6), "questionType"))) {
                fragment = new CheckboxAnswerFragment();
            } else if ("3".equals(JsonParse.getString(this.L0.get(i6), "questionType"))) {
                fragment = new RadioAnswerFragment();
            } else {
                this.L0.remove(i6);
                i6--;
                fragment = null;
            }
            if (fragment != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("index", i6);
                fragment.setArguments(bundle);
                this.M0.add(fragment);
            }
            i6++;
        }
        this.Z.setAdapter(new g(getSupportFragmentManager()));
        setTitle("1/" + this.Z.getAdapter().getCount());
        try {
            this.X.setVisibility(8);
            this.W.setVisibility(8);
            this.f18437a0.setEnabled(false);
            this.f18438b0.setEnabled(false);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void C0() {
        this.Z.addOnPageChangeListener(new k());
    }

    private void G0(final boolean autoCommit) {
        int i6;
        List<Map<String, Object>> arrayList = new ArrayList<>();
        List<Map<String, Object>> arrayList2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        while (i7 < this.L0.size()) {
            Map<String, Object> map = this.L0.get(i7);
            if ("1".equals(JsonParse.getString(this.L0.get(i7), "questionType"))) {
                List<Map> list = (List) this.L0.get(i7).get("answers");
                ArrayList arrayList3 = new ArrayList();
                for (Map map2 : list) {
                    int i8 = i7;
                    if (map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue()) {
                        arrayList3.add(JsonParse.getString(map2, "answerId"));
                    }
                    i7 = i8;
                }
                i6 = i7;
                Map<String, Object> arrayMap = new ArrayMap<>();
                arrayMap.put("question", JsonParse.getString(map, "questionId"));
                arrayMap.put("answers", arrayList3);
                arrayMap.put("scoreId", JsonParse.getString(map, "scoreId"));
                arrayList2.add(arrayMap);
                if (arrayList3.isEmpty() && !autoCommit) {
                    sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                    sb.append(String.valueOf(i6 + 1));
                }
            } else {
                i6 = i7;
                String string = JsonParse.getString(map, "checkAnswerId");
                if (string.isEmpty() && !autoCommit) {
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
        }
        if (autoCommit) {
            F0(autoCommit, arrayList, arrayList2);
            return;
        }
        new iOSTwoButtonDialog(this.T).setMessage(TextUtils.isEmpty(sb) ? "确定要提交试卷吗？" : "您还有第" + sb.toString() + "题未作答，是否要提交试卷？").setLeftButtonText("继续答题").setRightButtonText("直接交卷").setRightButtonOnClickListener(new i(autoCommit, arrayList, arrayList2)).show();
    }

    private void H0() {
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((m) Http.getApiService(m.class)).x(LoginUser.getLoginUser().getUserId(), this.J0)).setDataListener(new f());
    }

    private void K0() {
        if (this.Z.getCurrentItem() == this.Z.getAdapter().getCount() - 1) {
            g0("已经是最后一题了");
        } else {
            CustomViewPager customViewPager = this.Z;
            customViewPager.setCurrentItem(customViewPager.getCurrentItem() + 1);
        }
    }

    private void L0() {
        PopupWindow popupWindow = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this.T).inflate(R.layout.pop_dialog, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.gv);
        gridView.setAdapter((ListAdapter) this.F0);
        gridView.setOnItemClickListener(new a(popupWindow));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131299265);
        popupWindow.setOnDismissListener(new b(frameLayout));
        popupWindow.setContentView(inflate);
        popupWindow.showAsDropDown(findViewById(2131298702));
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
        }
    }

    private void M0() {
        if (this.Z.getCurrentItem() == 0) {
            g0("已经是第一题了");
        } else {
            this.Z.setCurrentItem(r0.getCurrentItem() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        h hVar = new h(this.K0, 1000L, simpleDateFormat);
        this.G0 = hVar;
        hVar.start();
    }

    private boolean v0() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            this.H0 = connectivityManager;
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

    private void w0() {
        NetworkInfo.State state = this.H0.getNetworkInfo(0).getState();
        NetworkInfo.State state2 = this.H0.getNetworkInfo(1).getState();
        NetworkInfo.State state3 = NetworkInfo.State.CONNECTED;
        if (state == state3 || state == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, "当前为网络状态为MOBILE", 0).show();
        }
        if (state2 == state3 || state2 == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, "当前为网络状态为Wi-Fi", 0).show();
        }
    }

    public List<Map<String, Object>> I0() {
        return this.L0;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f18437a0.setOnClickListener(this);
        this.f18438b0.setOnClickListener(this);
        this.f18439c0.setOnClickListener(this);
        C0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        Y(new c());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void z2() {
        new iOSTwoButtonDialog(this.T).setMessage("正在答题，是否放弃答题？").setRightButtonOnClickListener(new d()).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        CountDownTimer countDownTimer = this.G0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        l lVar = this.I0;
        if (lVar != null) {
            unregisterReceiver(lVar);
        }
        super.onDestroy();
    }

    private String E0(long milliSecondTime) {
        String valueOf;
        String valueOf2;
        String valueOf3;
        long j6 = milliSecondTime / 3600000;
        long j7 = milliSecondTime - (3600000 * j6);
        long j8 = j7 / 60000;
        long j9 = (j7 - (60000 * j8)) / 1000;
        if (j9 >= 60) {
            j9 %= 60;
            j8 += j9 / 60;
        }
        if (j8 >= 60) {
            j8 %= 60;
            j6 += j8 / 60;
        }
        if (j6 < 10) {
            valueOf = "0" + String.valueOf(j6);
        } else {
            valueOf = String.valueOf(j6);
        }
        if (j8 < 10) {
            valueOf2 = "0" + String.valueOf(j8);
        } else {
            valueOf2 = String.valueOf(j8);
        }
        if (j9 < 10) {
            valueOf3 = "0" + String.valueOf(j9);
        } else {
            valueOf3 = String.valueOf(j9);
        }
        return valueOf + ":" + valueOf2 + ":" + valueOf3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(final boolean autoCommit, List<Map<String, Object>> radioData, List<Map<String, Object>> checkData) {
        String jSONString = JSON.toJSONString(radioData);
        String jSONString2 = JSON.toJSONString(checkData);
        com.orhanobut.logger.j.h(jSONString);
        com.orhanobut.logger.j.h(jSONString2);
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((m) Http.getApiService(m.class)).o(LoginUser.getLoginUser().getUserId(), jSONString, jSONString2)).setDataListener(new j(autoCommit));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_exam_new;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("id")) {
            this.J0 = getIntent().getStringExtra("id");
        }
        this.F0 = new e(this.T, R.layout.item_for_number, this.L0);
        H0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_question_lesson);
        this.X = (TextView) findViewById(R.id.tv_question_teacher);
        this.Z = (CustomViewPager) findViewById(R.id.vp);
        this.f18437a0 = (Button) findViewById(R.id.bt_previous);
        this.f18438b0 = (Button) findViewById(R.id.bt_next);
        this.f18439c0 = (Button) findViewById(2131296623);
        this.f18440k0 = (TextView) findViewById(2131299158);
        this.f18441p0 = (RelativeLayout) findViewById(2131298068);
        this.Y = (CountDownTimeView) findViewById(R.id.cdtv);
        this.f18441p0.setVisibility(8);
        this.Z.setPagingEnabled(false);
        this.Y.i(60, 0);
        this.Y.setTextSize(cn.bluemobi.dylan.base.utils.d.d(this.T, 20.0f));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        switch (v5.getId()) {
            case R.id.bt_next /* 2131296622 */:
                K0();
                break;
            case 2131296623:
                G0(false);
                break;
            case R.id.bt_previous /* 2131296628 */:
                M0();
                break;
        }
    }
}
