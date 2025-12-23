package com.bxkj.student.home.teaching.exam.mock;

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
import android.widget.Toast;
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
import com.bxkj.base.view.CountDownTimeView;
import com.bxkj.student.R;
import com.bxkj.student.common.view.CustomViewPager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class NewExamActivity extends BaseActivity {
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> F0;
    private CountDownTimer G0;
    private CountDownTimer H0;
    private ConnectivityManager I0;
    private m J0;
    private long M0;
    private TextView W;
    private TextView X;
    private CountDownTimeView Y;
    private CustomViewPager Z;

    /* renamed from: a0, reason: collision with root package name */
    public Button f18218a0;

    /* renamed from: b0, reason: collision with root package name */
    public Button f18219b0;

    /* renamed from: c0, reason: collision with root package name */
    private Button f18220c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f18221k0;

    /* renamed from: p0, reason: collision with root package name */
    private RelativeLayout f18222p0;
    private int K0 = 30;
    private int L0 = 0;
    private String N0 = "体育专业题库";
    public int O0 = 1;
    private List<Map<String, Object>> P0 = new ArrayList();
    private List<Fragment> Q0 = new ArrayList();
    private boolean R0 = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ViewPager.OnPageChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private int f18223a;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f18223a = state;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (this.f18223a == 1 && positionOffsetPixels == 0) {
                if (position == 0) {
                    NewExamActivity.this.g0("已经是第一题了");
                } else if (position == NewExamActivity.this.Z.getAdapter().getCount() - 1) {
                    NewExamActivity.this.g0("已经是最后一题了");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            NewExamActivity.this.setTitle(NewExamActivity.this.N0 + (position + 1) + "/" + NewExamActivity.this.Z.getAdapter().getCount());
            if (NewExamActivity.this.G0 != null) {
                NewExamActivity.this.G0.cancel();
            }
            NewExamActivity.this.Y.i(NewExamActivity.this.K0, 0);
            if ("1".equals(JsonParse.getString((Map) NewExamActivity.this.P0.get(NewExamActivity.this.Z.getCurrentItem()), "questionType"))) {
                boolean z5 = false;
                for (Map<String, Object> map : JsonParse.getList((Map) NewExamActivity.this.P0.get(NewExamActivity.this.Z.getCurrentItem()), "answers")) {
                    if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                        z5 = true;
                    }
                }
                if (!JsonParse.getBoolean((Map) NewExamActivity.this.P0.get(NewExamActivity.this.Z.getCurrentItem()), "timeFinish") && !z5) {
                    NewExamActivity.this.f18218a0.setEnabled(false);
                    NewExamActivity.this.f18219b0.setEnabled(false);
                    NewExamActivity newExamActivity = NewExamActivity.this;
                    if (newExamActivity.O0 == 0) {
                        newExamActivity.d1();
                    }
                }
            } else if (!JsonParse.getBoolean((Map) NewExamActivity.this.P0.get(NewExamActivity.this.Z.getCurrentItem()), "timeFinish") && TextUtils.isEmpty(JsonParse.getString((Map) NewExamActivity.this.P0.get(NewExamActivity.this.Z.getCurrentItem()), "checkAnswerId"))) {
                NewExamActivity.this.f18218a0.setEnabled(false);
                NewExamActivity.this.f18219b0.setEnabled(false);
                NewExamActivity newExamActivity2 = NewExamActivity.this;
                if (newExamActivity2.O0 == 0) {
                    newExamActivity2.d1();
                }
            }
            NewExamActivity.this.X.setText("出题人：" + JsonParse.getString((Map) NewExamActivity.this.P0.get(position), "questionsSetter"));
            NewExamActivity.this.W.setText("课程名称：" + JsonParse.getString((Map) NewExamActivity.this.P0.get(position), "curriculum"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PopupWindow f18225a;

        b(final PopupWindow val$popupWindow) {
            this.f18225a = val$popupWindow;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            NewExamActivity.this.Z.setCurrentItem(position);
            this.f18225a.dismiss();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements PopupWindow.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout f18227a;

        c(final FrameLayout val$outsideView) {
            this.f18227a = val$outsideView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            FrameLayout frameLayout = this.f18227a;
            if (frameLayout != null) {
                frameLayout.setForeground(new ColorDrawable(0));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements BaseActivity.c {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            NewExamActivity.this.z2();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements iOSTwoButtonDialog.RightButtonOnClick {
        e() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            NewExamActivity.this.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        f(Context context, int layoutId, List datas) {
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
                    color2 = NewExamActivity.this.getResources().getColor(2131099731);
                } else {
                    color2 = NewExamActivity.this.getResources().getColor(2131099737);
                }
                holder.K(2131298997, color2);
                return;
            }
            if (JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty()) {
                i6 = R.drawable.round_cicler_gray;
            }
            holder.l(2131298997, i6);
            if (JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty()) {
                color = NewExamActivity.this.getResources().getColor(2131099731);
            } else {
                color = NewExamActivity.this.getResources().getColor(2131099737);
            }
            holder.K(2131298997, color);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends HttpCallBack {
        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            NewExamActivity.this.M0 = System.currentTimeMillis();
            NewExamActivity newExamActivity = NewExamActivity.this;
            newExamActivity.O0 = JsonParse.getInt(data, "examTimeType", newExamActivity.O0);
            NewExamActivity newExamActivity2 = NewExamActivity.this;
            newExamActivity2.K0 = JsonParse.getInt(data, "examTime", newExamActivity2.K0);
            NewExamActivity.this.P0 = (List) data.get("examArray");
            if (NewExamActivity.this.P0 == null || NewExamActivity.this.P0.size() <= 0) {
                new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).T).setMessage("没有题目").show();
                return;
            }
            NewExamActivity.this.f18222p0.setVisibility(0);
            NewExamActivity.this.Y0();
            NewExamActivity.this.F0.c(NewExamActivity.this.P0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            NewExamActivity.this.J0 = new m(NewExamActivity.this, null);
            NewExamActivity newExamActivity3 = NewExamActivity.this;
            newExamActivity3.registerReceiver(newExamActivity3.J0, intentFilter);
            NewExamActivity.this.Y.i(NewExamActivity.this.K0, 0);
            NewExamActivity.this.Y.setTextSize(cn.bluemobi.dylan.base.utils.d.d(((BaseActivity) NewExamActivity.this).T, 20.0f));
            NewExamActivity newExamActivity4 = NewExamActivity.this;
            if (newExamActivity4.O0 == 1) {
                ((View) newExamActivity4.f18221k0.getParent()).setVisibility(0);
                NewExamActivity.this.Y.setVisibility(8);
                NewExamActivity.this.c1();
            } else {
                ((View) newExamActivity4.f18221k0.getParent()).setVisibility(8);
                NewExamActivity.this.Y.setVisibility(0);
                NewExamActivity.this.d1();
            }
        }

        g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).T).setMessage("获取考试内容异常，请联系管理员").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).T).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h extends FragmentPagerAdapter {
        h(FragmentManager fm) {
            super(fm);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return NewExamActivity.this.Q0.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) NewExamActivity.this.Q0.get(position);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SimpleDateFormat f18234a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(long millisInFuture, long countDownInterval, final SimpleDateFormat val$simpleDateFormat) {
            super(millisInFuture, countDownInterval);
            this.f18234a = val$simpleDateFormat;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Iterator it = NewExamActivity.this.P0.iterator();
            while (it.hasNext()) {
                ((Map) it.next()).put("timeFinish", Boolean.TRUE);
            }
            for (Fragment fragment : NewExamActivity.this.Q0) {
                if (fragment instanceof NewRadioExamFragment) {
                    ((NewRadioExamFragment) fragment).R();
                } else if (fragment instanceof NewCheckboxExamFragment) {
                    ((NewCheckboxExamFragment) fragment).P();
                }
            }
            NewExamActivity.this.T0();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            NewExamActivity.this.f18221k0.setText(this.f18234a.format(Long.valueOf(millisUntilFinished)));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class j extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SimpleDateFormat f18236a;

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            NewExamActivity.this.Y.i(NewExamActivity.this.K0, ((int) millisUntilFinished) / 1000);
            NewExamActivity.this.f18221k0.setText(this.f18236a.format(Long.valueOf(millisUntilFinished)));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(long millisInFuture, long countDownInterval, final SimpleDateFormat val$simpleDateFormat) {
            super(millisInFuture, countDownInterval);
            this.f18236a = val$simpleDateFormat;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            NewExamActivity.this.Y.i(NewExamActivity.this.K0, 0);
            if (NewExamActivity.this.P0 != null) {
                ((Map) NewExamActivity.this.P0.get(NewExamActivity.this.Z.getCurrentItem())).put("timeFinish", Boolean.TRUE);
                Fragment fragment = (Fragment) NewExamActivity.this.Q0.get(NewExamActivity.this.Z.getCurrentItem());
                if (fragment instanceof NewRadioExamFragment) {
                    ((NewRadioExamFragment) fragment).R();
                    NewExamActivity.this.f18218a0.setEnabled(true);
                    NewExamActivity.this.f18219b0.setEnabled(true);
                } else if (fragment instanceof NewCheckboxExamFragment) {
                    ((NewCheckboxExamFragment) fragment).P();
                    NewExamActivity.this.f18218a0.setEnabled(true);
                    NewExamActivity.this.f18219b0.setEnabled(true);
                }
                NewExamActivity.this.Z0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class k implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f18238a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f18239b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f18240c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f18241d;

        k(final boolean val$autoCommit, final String val$stuTeacherCurriculumId, final List val$radioData, final List val$checkData) {
            this.f18238a = val$autoCommit;
            this.f18239b = val$stuTeacherCurriculumId;
            this.f18240c = val$radioData;
            this.f18241d = val$checkData;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            NewExamActivity.this.V0(this.f18238a, this.f18239b, this.f18240c, this.f18241d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class l extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f18243a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                NewExamActivity.this.finish();
            }
        }

        l(final boolean val$autoCommit) {
            this.f18243a = val$autoCommit;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            String str = this.f18243a ? "时间已到，已经为您自动交卷成功" : "交卷成功";
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).T);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setMessage(str).setButtonOnClickListener(new a()).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if (this.f18243a) {
                new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).T).setMessage("时间已到，自动交卷失败，请手动交卷").show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class m extends BroadcastReceiver {
        /* synthetic */ m(NewExamActivity newExamActivity, com.bxkj.student.home.teaching.exam.mock.a aVar) {
            this();
        }

        private m() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!NewExamActivity.this.H0()) {
                new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).T).setMessage("已脱离后台监控，请检查网络后开始考试").show();
            } else if (!NewExamActivity.this.R0) {
                new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).T).setMessage("网络已恢复，请继续开始考试").show();
            }
            com.orhanobut.logger.j.c("网络状态发生变化");
            NewExamActivity newExamActivity = NewExamActivity.this;
            newExamActivity.R0 = newExamActivity.H0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        W0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        Fragment fragment;
        int i6 = 0;
        while (i6 < this.P0.size()) {
            Map<String, Object> map = this.P0.get(i6);
            if ("0".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new NewRadioExamFragment();
            } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new NewCheckboxExamFragment();
            } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new NewRadioExamFragment();
            } else {
                this.P0.remove(i6);
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
                this.Q0.add(fragment);
            }
            i6++;
        }
        this.Z.setAdapter(new h(getSupportFragmentManager()));
        setTitle(this.N0 + "1/" + this.Z.getAdapter().getCount());
        try {
            String string = JsonParse.getString(this.P0.get(0), "questionsSetter");
            if (TextUtils.isEmpty(string)) {
                this.X.setVisibility(8);
            } else {
                this.X.setVisibility(0);
                this.X.setText("出题人：" + string);
            }
            String string2 = JsonParse.getString(this.P0.get(0), "curriculum");
            if (TextUtils.isEmpty(string2)) {
                this.W.setVisibility(8);
            } else {
                this.W.setVisibility(0);
                this.W.setText("课程名称：" + string2);
            }
            this.f18218a0.setEnabled(false);
            this.f18219b0.setEnabled(false);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H0() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            this.I0 = connectivityManager;
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

    private void I0() {
        NetworkInfo.State state = this.I0.getNetworkInfo(0).getState();
        NetworkInfo.State state2 = this.I0.getNetworkInfo(1).getState();
        NetworkInfo.State state3 = NetworkInfo.State.CONNECTED;
        if (state == state3 || state == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, "当前为网络状态为MOBILE", 0).show();
        }
        if (state2 == state3 || state2 == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, "当前为网络状态为Wi-Fi", 0).show();
        }
    }

    private void S0() {
        this.Z.addOnPageChangeListener(new a());
    }

    private void W0(final boolean autoCommit) {
        int i6;
        String stringExtra = getIntent().getStringExtra("stuTeacherCurriculumId");
        List<Map<String, Object>> arrayList = new ArrayList<>();
        List<Map<String, Object>> arrayList2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        while (i7 < this.P0.size()) {
            Map<String, Object> map = this.P0.get(i7);
            if ("1".equals(JsonParse.getString(this.P0.get(i7), "questionType"))) {
                List<Map> list = (List) this.P0.get(i7).get("answers");
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
            V0(autoCommit, stringExtra, arrayList, arrayList2);
        } else {
            new iOSTwoButtonDialog(this.T).setMessage("确定要提交试卷吗？").setLeftButtonText("继续答题").setRightButtonText("直接交卷").setRightButtonOnClickListener(new k(autoCommit, stringExtra, arrayList, arrayList2)).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        if (this.Z.getCurrentItem() == this.Z.getAdapter().getCount() - 1) {
            g0("已经是最后一题了");
            return;
        }
        List<Fragment> list = this.Q0;
        if (list != null) {
            Fragment fragment = list.get(this.Z.getCurrentItem());
            if (fragment instanceof NewCheckboxExamFragment) {
                ((NewCheckboxExamFragment) fragment).P();
            }
        }
        CustomViewPager customViewPager = this.Z;
        customViewPager.setCurrentItem(customViewPager.getCurrentItem() + 1);
    }

    private void a1() {
        PopupWindow popupWindow = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this.T).inflate(R.layout.pop_dialog, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.gv);
        gridView.setAdapter((ListAdapter) this.F0);
        gridView.setOnItemClickListener(new b(popupWindow));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131299265);
        popupWindow.setOnDismissListener(new c(frameLayout));
        popupWindow.setContentView(inflate);
        popupWindow.showAsDropDown(findViewById(2131298702));
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
        }
    }

    private void b1() {
        if (this.Z.getCurrentItem() == 0) {
            g0("已经是第一题了");
        } else {
            this.Z.setCurrentItem(r0.getCurrentItem() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        i iVar = new i(this.K0 * 1000, 1000L, simpleDateFormat);
        this.H0 = iVar;
        iVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        j jVar = new j(this.K0 * 1000, 1000L, simpleDateFormat);
        this.G0 = jVar;
        jVar.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f18218a0.setOnClickListener(this);
        this.f18219b0.setOnClickListener(this);
        this.f18220c0.setOnClickListener(this);
        S0();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void z2() {
        new iOSTwoButtonDialog(this.T).setMessage("正在考试，是否放弃考试？").setRightButtonOnClickListener(new e()).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (!this.R0) {
            new iOSOneButtonDialog(this.T).setMessage("已脱离后台监控，请检查网络后开始考试").show();
        }
        switch (v5.getId()) {
            case R.id.bt_next /* 2131296622 */:
                Z0();
                break;
            case 2131296623:
                W0(false);
                break;
            case R.id.bt_previous /* 2131296628 */:
                b1();
                break;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        CountDownTimer countDownTimer = this.H0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.G0;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        m mVar = this.J0;
        if (mVar != null) {
            unregisterReceiver(mVar);
        }
        super.onDestroy();
    }

    private String U0(long milliSecondTime) {
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
    public void V0(final boolean autoCommit, String stuTeacherCurriculumId, List<Map<String, Object>> radioData, List<Map<String, Object>> checkData) {
        String jSONString = JSON.toJSONString(radioData);
        String jSONString2 = JSON.toJSONString(checkData);
        com.orhanobut.logger.j.h(jSONString);
        com.orhanobut.logger.j.h(jSONString2);
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).z1(stuTeacherCurriculumId, LoginUser.getLoginUser().getUserId(), jSONString, jSONString2, "", String.valueOf(this.M0), this.L0)).setDataListener(new l(autoCommit));
    }

    private void X0() {
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
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).z0(str3, str2, LoginUser.getLoginUser().getUserId(), this.L0)).setDataListener(new g());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_exam_new;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("onlineType")) {
            this.L0 = getIntent().getIntExtra("onlineType", 0);
        }
        this.F0 = new f(this.T, R.layout.item_for_number, this.P0);
        X0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        String stringExtra = getIntent().getStringExtra("title");
        this.N0 = stringExtra;
        setTitle(stringExtra);
        Y(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_question_lesson);
        this.X = (TextView) findViewById(R.id.tv_question_teacher);
        this.Z = (CustomViewPager) findViewById(R.id.vp);
        this.f18218a0 = (Button) findViewById(R.id.bt_previous);
        this.f18219b0 = (Button) findViewById(R.id.bt_next);
        this.f18220c0 = (Button) findViewById(2131296623);
        this.f18221k0 = (TextView) findViewById(2131299158);
        this.f18222p0 = (RelativeLayout) findViewById(2131298068);
        this.Y = (CountDownTimeView) findViewById(R.id.cdtv);
        this.f18222p0.setVisibility(8);
        this.Z.setPagingEnabled(false);
    }
}
