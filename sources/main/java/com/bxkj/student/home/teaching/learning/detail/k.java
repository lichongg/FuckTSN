package com.bxkj.student.home.teaching.learning.detail;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.ext.b0;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.learning.FaceDetectLearnActivity;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.detail.db.ReadExceptionDataDB;
import com.bxkj.student.home.teaching.learning.detail.k;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.functions.Function0;
import kotlin.n1;
import org.slf4j.Marker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private Context f18604a;

    /* renamed from: b, reason: collision with root package name */
    private Button f18605b;

    /* renamed from: d, reason: collision with root package name */
    private int f18607d;

    /* renamed from: e, reason: collision with root package name */
    private String f18608e;

    /* renamed from: f, reason: collision with root package name */
    private String f18609f;

    /* renamed from: g, reason: collision with root package name */
    private int f18610g;

    /* renamed from: h, reason: collision with root package name */
    private int f18611h;

    /* renamed from: i, reason: collision with root package name */
    private int f18612i;

    /* renamed from: j, reason: collision with root package name */
    private int f18613j;

    /* renamed from: k, reason: collision with root package name */
    private int f18614k;

    /* renamed from: l, reason: collision with root package name */
    private Long f18615l;

    /* renamed from: m, reason: collision with root package name */
    public Timer f18616m;

    /* renamed from: n, reason: collision with root package name */
    public TimerTask f18617n;

    /* renamed from: o, reason: collision with root package name */
    private BottomFragment f18618o;

    /* renamed from: p, reason: collision with root package name */
    private iOSTwoButtonDialog f18619p;

    /* renamed from: q, reason: collision with root package name */
    private v f18620q;

    /* renamed from: r, reason: collision with root package name */
    private ReadExceptionDataDB f18621r;

    /* renamed from: c, reason: collision with root package name */
    private int f18606c = 0;

    /* renamed from: s, reason: collision with root package name */
    private long f18622s = 0;

    /* renamed from: t, reason: collision with root package name */
    private final int f18623t = 170;

    /* renamed from: u, reason: collision with root package name */
    public Handler f18624u = new b();

    /* renamed from: v, reason: collision with root package name */
    private boolean f18625v = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (k.this.f18625v) {
                return;
            }
            k.this.f18622s++;
            if (k.this.f18622s % 10 == 0) {
                k.this.P();
            }
            k.this.f18624u.sendEmptyMessage(170);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != 170) {
                return;
            }
            k.this.z();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f18628a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Button f18629b;

        c(final EditText val$et_code, final Button val$btn_two) {
            this.f18628a = val$et_code;
            this.f18629b = val$btn_two;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s5) {
            Context context;
            int i6;
            boolean z5 = this.f18628a.getText().toString().length() == 4;
            this.f18629b.setEnabled(z5);
            Button button = this.f18629b;
            if (z5) {
                context = k.this.f18604a;
                i6 = R.color.ios_dialog_button_color;
            } else {
                context = k.this.f18604a;
                i6 = 2131099715;
            }
            button.setTextColor(ContextCompat.getColor(context, i6));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s5, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s5, int start, int before, int count) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            k.this.C();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            k.this.C();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            k.this.f18605b.setText(k.this.f18612i == 1 ? "开始答题" : "已完成");
            k.this.f18605b.setEnabled(k.this.f18612i == 1);
            ((LearnDetailActivity) k.this.f18618o.getActivity()).v0(false);
            LearnHomeListActivity learnHomeListActivity = (LearnHomeListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(LearnHomeListActivity.class);
            if (learnHomeListActivity != null) {
                learnHomeListActivity.T0();
            }
            Toast toast = new Toast(k.this.f18604a);
            View inflate = View.inflate(k.this.f18604a, R.layout.toast_learn_get, null);
            ((LinearLayout) inflate.findViewById(2131298068)).setLayoutParams(new ViewGroup.LayoutParams(cn.bluemobi.dylan.base.utils.u.a(120.0f, k.this.f18604a), cn.bluemobi.dylan.base.utils.u.a(120.0f, k.this.f18604a)));
            ((TextView) inflate.findViewById(R.id.tv_message)).setText(Marker.ANY_NON_NULL_MARKER + k.this.f18614k + "积分");
            toast.setView(inflate);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.show();
            cn.bluemobi.dylan.sqlitelibrary.c.h().delete(ReadExceptionDataDB.class, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), k.this.f18609f});
            k.this.f18621r = null;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if (ex instanceof SocketTimeoutException) {
                new iOSTwoButtonDialog(k.this.f18604a).setMessage("获取积分超时,请重试").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.l
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        k.d.this.c();
                    }
                }).setRightButtonText("重试").show();
            } else {
                new iOSTwoButtonDialog(k.this.f18604a).setMessage("获取积分失败,请重试").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.m
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        k.d.this.d();
                    }
                }).setRightButtonText("重试").show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            k.this.f18605b.setText("");
            k.this.f18605b.setEnabled(false);
            ((LearnDetailActivity) k.this.f18618o.getActivity()).v0(false);
            new iOSOneButtonDialog(k.this.f18604a).setMessage(msg).show();
        }
    }

    public static /* synthetic */ boolean i(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
        return i6 == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        Http.with(this.f18604a).setLoadingMessage("获取积分中,请稍后...").hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setCanCancel(false).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).v(this.f18609f, "4", 1)).setDataListener(new d());
    }

    private void F() {
        if (this.f18611h - this.f18622s != 0) {
            return;
        }
        T();
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(TextView textView, View view) {
        textView.setText(this.f18620q.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(final iOSTwoButtonDialog iostwobuttondialog) {
        new iOSTwoButtonDialog(this.f18604a).setMessage("正在学习,如果离开将不积分,确定离开？").setLeftButtonText("继续学习").setRightButtonText("确定离开").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.i
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                k.this.I(iostwobuttondialog);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        this.f18619p.dismiss();
        ((Activity) this.f18604a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        new iOSTwoButtonDialog(this.f18604a).setMessage("正在学习,如果离开将不积分,确定离开？").setLeftButtonText("继续学习").setRightButtonText("确定离开").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.h
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                k.this.L();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 N() {
        this.f18618o.startActivityForResult(new Intent(this.f18604a, (Class<?>) FaceDetectLearnActivity.class), 170);
        ((FragmentActivity) this.f18604a).overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O() {
        b0.x((FragmentActivity) this.f18604a, "人脸识别", new Function0() { // from class: com.bxkj.student.home.teaching.learning.detail.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 N;
                N = k.this.N();
                return N;
            }
        });
    }

    private void w() {
        final iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f18604a);
        Button button = (Button) iostwobuttondialog.findViewById(2131296668);
        iostwobuttondialog.setTitle("请输入验证码继续观看");
        iostwobuttondialog.setCenterCustomView(R.layout.dialog_confirm_code);
        iostwobuttondialog.setClickAutoCancel(false);
        iostwobuttondialog.setCanceledOnTouchOutside(false);
        button.setEnabled(false);
        final EditText editText = (EditText) iostwobuttondialog.findViewById(R.id.et_code);
        button.setTextColor(ContextCompat.getColor(this.f18604a, 2131099715));
        final TextView textView = (TextView) iostwobuttondialog.findViewById(R.id.tv_code);
        textView.setText(this.f18620q.a());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.this.G(textView, view);
            }
        });
        editText.addTextChangedListener(new c(editText, button));
        iostwobuttondialog.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.d
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                k.this.H(iostwobuttondialog, editText, textView);
            }
        });
        iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.e
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                k.this.J(iostwobuttondialog);
            }
        });
        iostwobuttondialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.home.teaching.learning.detail.f
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                return k.i(dialogInterface, i6, keyEvent);
            }
        });
        iostwobuttondialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bxkj.student.home.teaching.learning.detail.g
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                k.this.K(editText, dialogInterface);
            }
        });
        iostwobuttondialog.show();
    }

    private void x() {
        iOSTwoButtonDialog message = new iOSTwoButtonDialog(this.f18604a).setMessage("学习已暂停，请先进行人脸识别");
        this.f18619p = message;
        message.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.a
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                k.this.M();
            }
        });
        this.f18619p.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.b
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                k.this.O();
            }
        });
        this.f18619p.setClickAutoCancel(false);
        this.f18619p.setCancelable(false);
        this.f18619p.setCanceledOnTouchOutside(false);
        this.f18619p.show();
    }

    private void y(iOSTwoButtonDialog iOSTwoButtonDialog) {
        this.f18606c++;
        if (iOSTwoButtonDialog != null) {
            iOSTwoButtonDialog.dismiss();
        }
        com.orhanobut.logger.j.c("已点击弹框次数=" + this.f18606c);
        F();
        Q(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        int i6;
        this.f18605b.setText(E(this.f18611h - this.f18622s));
        long j6 = this.f18622s;
        if (j6 <= 0 || (i6 = this.f18610g) <= 0 || j6 % i6 != 0) {
            F();
            return;
        }
        Q(true);
        if (this.f18613j == 2) {
            x();
        } else {
            w();
        }
    }

    public void D() {
        y(this.f18619p);
    }

    public String E(long recordingTime) {
        String valueOf;
        String valueOf2;
        if (recordingTime < 0) {
            T();
            recordingTime = 0;
        }
        long j6 = recordingTime / 60;
        if (j6 < 10) {
            valueOf = "0" + j6;
        } else {
            valueOf = String.valueOf(j6);
        }
        long j7 = recordingTime % 60;
        if (j7 < 10) {
            valueOf2 = "0" + j7;
        } else {
            valueOf2 = String.valueOf(j7);
        }
        return valueOf + ":" + valueOf2;
    }

    public void P() {
        ReadExceptionDataDB readExceptionDataDB = this.f18621r;
        if (readExceptionDataDB == null) {
            return;
        }
        readExceptionDataDB.setCountTime(this.f18622s);
        this.f18621r.setAlertCount(this.f18606c);
        cn.bluemobi.dylan.sqlitelibrary.c.h().update(this.f18621r, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), this.f18609f});
        com.orhanobut.logger.j.c("readExceptionDataDB=" + this.f18621r.toString());
    }

    public void Q(boolean pauseCountDown) {
        this.f18625v = pauseCountDown;
    }

    public void R(EditText editText) {
        if (editText != null) {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        }
    }

    public void S() {
        com.orhanobut.logger.j.c("time=" + this.f18622s);
        z();
        this.f18617n = new a();
        Timer timer = new Timer();
        this.f18616m = timer;
        timer.schedule(this.f18617n, 0L, 1000L);
    }

    public void T() {
        TimerTask timerTask = this.f18617n;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.f18616m;
        if (timer != null) {
            timer.cancel();
        }
        Handler handler = this.f18624u;
        if (handler != null) {
            handler.removeCallbacks(this.f18617n);
        }
    }

    public k(BottomFragment bottomFragment, Context mContext, int duration, int popTime, String id, String detailId, Button bt_question, int hasQuestion, int valType, int integral) {
        this.f18607d = 0;
        this.f18610g = 30;
        this.f18618o = bottomFragment;
        this.f18604a = mContext;
        this.f18608e = id;
        this.f18611h = duration;
        this.f18605b = bt_question;
        this.f18610g = popTime;
        if (popTime == 0) {
            this.f18607d = 0;
        } else {
            this.f18607d = duration / popTime;
        }
        this.f18609f = detailId;
        this.f18612i = hasQuestion;
        this.f18613j = valType;
        this.f18614k = integral;
        this.f18620q = new v(mContext);
        com.orhanobut.logger.j.c("需要弹框次数=" + this.f18607d);
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void H(iOSTwoButtonDialog iOSTwoButtonDialog, EditText et_code, TextView tv_code) {
        if (!et_code.getText().toString().trim().equals(this.f18620q.b().toString())) {
            Toast.makeText(this.f18604a, "验证码错误", 0).show();
            tv_code.setText(this.f18620q.a());
        } else {
            y(iOSTwoButtonDialog);
        }
    }

    private void B() {
        List query = cn.bluemobi.dylan.sqlitelibrary.c.h().query(ReadExceptionDataDB.class, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), this.f18609f});
        if (query.size() > 0) {
            ReadExceptionDataDB readExceptionDataDB = (ReadExceptionDataDB) query.get(0);
            this.f18621r = readExceptionDataDB;
            long countTime = readExceptionDataDB.getCountTime();
            this.f18622s = countTime;
            int i6 = this.f18611h;
            if (countTime > i6) {
                this.f18622s = i6;
            }
            this.f18606c = this.f18621r.getAlertCount();
            this.f18615l = Long.valueOf(this.f18621r.getStartTime());
            return;
        }
        this.f18615l = Long.valueOf(System.currentTimeMillis());
        this.f18621r = new ReadExceptionDataDB();
        this.f18621r.setCreateTime(com.bxkj.student.run.app.utils.i.h(this.f18615l.longValue(), "yyyy-MM-dd HH:mm:ss"));
        this.f18621r.setUserId(LoginUser.getLoginUser().getUserId());
        this.f18621r.setDetailId(this.f18609f);
        this.f18621r.setStartTime(this.f18615l.longValue());
        cn.bluemobi.dylan.sqlitelibrary.c.h().insert((cn.bluemobi.dylan.sqlitelibrary.c) this.f18621r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(iOSTwoButtonDialog iostwobuttondialog) {
        iostwobuttondialog.dismiss();
        ((Activity) this.f18604a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(EditText editText, DialogInterface dialogInterface) {
        R(editText);
    }
}
