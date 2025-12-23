package com.bxkj.student.home;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bxkj.base.chat.ConversationListActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.competition.electronicentry.CompeteListActivity;
import com.bxkj.competition.signup.CompetitionListActivity;
import com.bxkj.equipment.ApplyEquipmentActivity;
import com.bxkj.equipment.history.RecordListActivity;
import com.bxkj.place.apply.SchoolDistrictActivity;
import com.bxkj.place.history.ApplyHistoryListActivity;
import com.bxkj.student.R;
import com.bxkj.student.home.physicaltest.AdmissionTicketActivity;
import com.bxkj.student.home.physicaltest.InputEyeScoreActivity;
import com.bxkj.student.home.physicaltest.calc.CalcActivity;
import com.bxkj.student.home.physicaltest.mc.ApplyMcListActivity;
import com.bxkj.student.home.physicaltest.monitor.record.MonitorRecordListActivity;
import com.bxkj.student.home.physicaltest.monitor.reservation.MonitorDescriptionActivity;
import com.bxkj.student.home.physicaltest.personal.record.MyReservationListActivity;
import com.bxkj.student.home.physicaltest.personal.reservation.DescriptionActivity;
import com.bxkj.student.home.physicaltest.rank.PhysicalTestRankActivity;
import com.bxkj.student.home.physicaltest.scanscore.TestScoreListActivity;
import com.bxkj.student.home.teaching.activity.BookingActivity;
import com.bxkj.student.home.teaching.activity.MyBookingListActivity;
import com.bxkj.student.home.teaching.evaluateteacher.EvaluateListActivity;
import com.bxkj.student.home.teaching.exam.ExamListActivity;
import com.bxkj.student.home.teaching.healthstatus.ApplyHealthStatusListActivity;
import com.bxkj.student.home.teaching.learning.ready.LearnDescriptionActivity;
import com.bxkj.student.home.teaching.leave.SelectLessenListActivity;
import com.bxkj.student.home.teaching.lesson.LessonDescriptionActivity;
import com.bxkj.student.home.teaching.lesson.ViewTermActivity;
import com.bxkj.student.home.teaching.rollcall.BleSignActivity;
import com.bxkj.student.home.teaching.separateexam.ExamLessonListActivity;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.run.app.StartRunActivity;
import com.bxkj.student.run.app.apply.ApplyAvoidRunListActivity;
import com.bxkj.student.run.app.keep.KeepAuthH5Activity;
import com.bxkj.student.run.app.keep.SyncKeepDataActivity;
import com.bxkj.student.run.extraclass.SignListActivity;
import com.bxkj.student.run.punchcard.TotalActivity;
import com.bxkj.student.v2.common.utils.i;
import com.kuaishou.weapon.p0.g;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import t.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private FragmentActivity f17879a;

    /* renamed from: b, reason: collision with root package name */
    private Context f17880b;

    /* renamed from: c, reason: collision with root package name */
    private String f17881c;

    /* renamed from: d, reason: collision with root package name */
    private String f17882d;

    /* renamed from: e, reason: collision with root package name */
    private Toast f17883e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements b.a {
        a() {
        }

        @Override // t.b.a
        public void a() {
            d.this.f17880b.startActivity(new Intent(d.this.f17880b, (Class<?>) StartRunActivity.class));
        }

        @Override // t.b.a
        public void b(@NotNull String[] strings) {
            new iOSOneButtonDialog(d.this.f17880b).setMessage(d.this.f17880b.getString(R.string.run_permission_hint)).show();
        }

        @Override // t.b.a
        public void c(@NotNull String[] strings) {
            new iOSOneButtonDialog(d.this.f17880b).setMessage(d.this.f17880b.getString(R.string.run_permission_hint)).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17885a;

        b(final String val$menu) {
            this.f17885a = val$menu;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (this.f17885a.equals("班长预约")) {
                d.this.f17880b.startActivity(new Intent(d.this.f17880b, (Class<?>) MonitorDescriptionActivity.class));
            } else {
                d.this.f17880b.startActivity(new Intent(d.this.f17880b, (Class<?>) MonitorRecordListActivity.class));
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(d.this.f17880b).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements iOSTwoButtonDialog.RightButtonOnClick {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                new iOSOneButtonDialog(d.this.f17880b).setMessage("已提交申请").show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                super.netOnOtherStatus(status, msg);
                new iOSOneButtonDialog(d.this.f17880b).setMessage(msg).show();
            }
        }

        c() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(d.this.f17880b).hideSuccessMessage().hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).D0(LoginUser.getLoginUser().getUserId())).setDataListener(new a());
        }
    }

    public void f() {
        if (!LoginUser.getLoginUser().isLogin() && !"体测计算器".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) LoginActivity.class));
            return;
        }
        if ("更多".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) HomeMenuListActivity.class));
            return;
        }
        if ("赛事中心".equals(this.f17882d)) {
            String oldToNewH5 = LoginUser.getLoginUser().getOldToNewH5();
            if (TextUtils.isEmpty(oldToNewH5)) {
                new iOSOneButtonDialog(this.f17880b).setMessage("暂未开通此权限！").show();
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("username", LoginUser.getLoginUser().getAccount());
            hashMap.put(CommonNetImpl.NAME, "赛事中心");
            hashMap.put("linkUrl", oldToNewH5);
            i.f20904a.b(this.f17880b, hashMap);
            return;
        }
        if ("竞赛报名".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) CompetitionListActivity.class));
            return;
        }
        if ("竞赛记录".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) com.bxkj.competition.score.CompetitionListActivity.class));
            return;
        }
        if ("发布通讯稿".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) com.bxkj.competition.newsletter.CompetitionListActivity.class));
            return;
        }
        if ("电子参赛证".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) CompeteListActivity.class));
            return;
        }
        if ("理论考试".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ExamListActivity.class).putExtra("title", "理论考试课程").putExtra("onlineType", 0));
            return;
        }
        if ("体育专业题库".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ExamListActivity.class).putExtra("title", this.f17882d).putExtra("onlineType", 1));
            return;
        }
        if ("体育知识竞赛".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ExamListActivity.class).putExtra("title", this.f17882d).putExtra("onlineType", 2));
            return;
        }
        if ("评价教师".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) EvaluateListActivity.class));
            return;
        }
        if ("体测成绩".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) TestScoreListActivity.class));
            return;
        }
        if ("预约体测".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) DescriptionActivity.class));
            return;
        }
        if ("体测预约记录".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) MyReservationListActivity.class));
            return;
        }
        if ("场馆预约记录".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ApplyHistoryListActivity.class).putExtra("appointType", 1));
            return;
        }
        if ("班长预约".equals(this.f17882d)) {
            d("班长预约");
            return;
        }
        if ("申请班长".equals(this.f17882d)) {
            c();
            return;
        }
        if ("班长记录".equals(this.f17882d)) {
            d("班长记录");
            return;
        }
        if ("申请免测".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ApplyMcListActivity.class));
            return;
        }
        if ("体测计算器".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) CalcActivity.class));
            return;
        }
        if ("申请状态".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ApplyHealthStatusListActivity.class));
            return;
        }
        if ("预约场馆".equals(this.f17882d)) {
            if (!LoginUser.getLoginUser().getSchoolId().equals("342")) {
                this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) SchoolDistrictActivity.class).putExtra("appointType", 1));
                return;
            }
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) H5DetailActivity.class).putExtra("title", "预约场馆").putExtra("url", "http://swufecg.tsnkj.com/#/pages/login/phone-login?u=" + LoginUser.getLoginUser().getAccount()));
            return;
        }
        if ("申请场馆".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) SchoolDistrictActivity.class).putExtra("appointType", 2));
            return;
        }
        if ("申请记录".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ApplyHistoryListActivity.class).putExtra("appointType", 2));
            return;
        }
        if ("上课请假".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) SelectLessenListActivity.class));
            return;
        }
        if (("在线选" + LoginUser.getLoginUser().getXuanAfterLabelName()).equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) LessonDescriptionActivity.class));
            return;
        }
        if (("查看" + LoginUser.getLoginUser().getViewAfterLabelName()).equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ViewTermActivity.class).putExtra(Constants.FROM, "查看" + LoginUser.getLoginUser().getViewAfterLabelName()));
            return;
        }
        if ("查看点名".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ViewTermActivity.class).putExtra(Constants.FROM, "查看点名"));
            return;
        }
        if ("上课签到".equals(this.f17882d)) {
            if (((LocationManager) this.f17879a.getSystemService(SocializeConstants.KEY_LOCATION)).isProviderEnabled(GeocodeSearch.GPS)) {
                this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) BleSignActivity.class));
                return;
            } else {
                new iOSTwoButtonDialog(this.f17880b).setTitle("GPS未开启").setMessage("为了正常上课签到，需要你开启GPS定位功能。").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.c
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        d.this.e();
                    }
                }).show();
                return;
            }
        }
        if ("绑定Keep账号".equals(this.f17882d)) {
            if (TextUtils.isEmpty(LoginUser.getLoginUser().getKeepToken())) {
                this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) KeepAuthH5Activity.class));
                return;
            } else {
                new iOSOneButtonDialog(this.f17880b).setMessage("已绑定keep账号").show();
                return;
            }
        }
        if ("同步Keep数据".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) SyncKeepDataActivity.class));
            return;
        }
        if ("App跑步".equals(this.f17882d)) {
            new t.b(this.f17879a).c(g.f36048h, g.f36047g).d(new a());
            return;
        }
        if ("申请免跑".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ApplyAvoidRunListActivity.class));
            return;
        }
        if ("锻炼考勤".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) TotalActivity.class));
            return;
        }
        if ("期末成绩".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) com.bxkj.student.home.teaching.resultfinal.ViewTermActivity.class));
            return;
        }
        if ("场馆打卡".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) SignListActivity.class));
            return;
        }
        if ("预约活动".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) BookingActivity.class));
            return;
        }
        if ("我的活动".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) MyBookingListActivity.class));
            return;
        }
        if ("借用器材".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ApplyEquipmentActivity.class));
            return;
        }
        if ("借用记录".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) RecordListActivity.class));
            return;
        }
        if ("在线学习".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) LearnDescriptionActivity.class));
            return;
        }
        if ("自助视力".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) InputEyeScoreActivity.class));
            return;
        }
        if ("预约考试".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ExamLessonListActivity.class));
            return;
        }
        if ("课后作业".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) com.bxkj.student.home.teaching.homework.ViewTermActivity.class));
            return;
        }
        if ("师生互动".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) ConversationListActivity.class));
            return;
        }
        if ("体测准考证".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) AdmissionTicketActivity.class));
        } else if ("体测排名".equals(this.f17882d)) {
            this.f17880b.startActivity(new Intent(this.f17880b, (Class<?>) PhysicalTestRankActivity.class));
        } else {
            g("暂未开放，敬请期待");
        }
    }

    private void c() {
        new iOSTwoButtonDialog(this.f17880b).setMessage("确定要申请班长吗？").setRightButtonOnClickListener(new c()).show();
    }

    private void d(final String menu) {
        Http.with(this.f17880b).hideSuccessMessage().hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).t0(LoginUser.getLoginUser().getUserId())).setDataListener(new b(menu));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        this.f17879a.startActivity(intent);
    }

    public void g(CharSequence charSequence) {
        Toast toast = this.f17883e;
        if (toast == null) {
            this.f17883e = Toast.makeText(this.f17880b, charSequence, 0);
        } else {
            toast.cancel();
            this.f17883e.setText(charSequence);
        }
        this.f17883e.show();
    }

    public d(FragmentActivity mActivity, String icon, String menu) {
        this.f17879a = mActivity;
        this.f17880b = mActivity;
        this.f17881c = icon;
        this.f17882d = menu;
    }
}
