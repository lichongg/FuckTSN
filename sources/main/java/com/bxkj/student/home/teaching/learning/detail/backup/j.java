package com.bxkj.student.home.teaching.learning.detail.backup;

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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.ext.b0;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.learning.FaceDetectLearnActivity;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.detail.backup.j;
import com.bxkj.student.home.teaching.learning.detail.db.ReadExceptionDataDB;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import kotlin.jvm.functions.Function0;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private Context f18555a;

    /* renamed from: b, reason: collision with root package name */
    private Button f18556b;

    /* renamed from: d, reason: collision with root package name */
    private int f18558d;

    /* renamed from: e, reason: collision with root package name */
    private String f18559e;

    /* renamed from: f, reason: collision with root package name */
    private String f18560f;

    /* renamed from: g, reason: collision with root package name */
    private int f18561g;

    /* renamed from: h, reason: collision with root package name */
    private long f18562h;

    /* renamed from: i, reason: collision with root package name */
    private int f18563i;

    /* renamed from: j, reason: collision with root package name */
    private int f18564j;

    /* renamed from: l, reason: collision with root package name */
    public Timer f18566l;

    /* renamed from: m, reason: collision with root package name */
    public TimerTask f18567m;

    /* renamed from: n, reason: collision with root package name */
    private Long f18568n;

    /* renamed from: o, reason: collision with root package name */
    private BottomFragment f18569o;

    /* renamed from: p, reason: collision with root package name */
    private iOSTwoButtonDialog f18570p;

    /* renamed from: q, reason: collision with root package name */
    private ReadExceptionDataDB f18571q;

    /* renamed from: c, reason: collision with root package name */
    private int f18557c = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f18565k = 0;

    /* renamed from: r, reason: collision with root package name */
    private final int f18572r = 170;

    /* renamed from: s, reason: collision with root package name */
    public Handler f18573s = new b();

    /* renamed from: t, reason: collision with root package name */
    private boolean f18574t = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (j.this.f18574t) {
                return;
            }
            j.this.f18565k++;
            if (j.this.f18565k % 10 == 0) {
                j.this.L();
            }
            j.this.f18573s.sendEmptyMessage(170);
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
            long j6 = j.this.f18562h - j.this.f18565k;
            j.this.f18556b.setText(j.this.C(j6));
            if (j.this.f18561g != 0 && j.this.f18565k % j.this.f18561g == 0) {
                if (j.this.f18564j == 1) {
                    j.this.w();
                } else if (j.this.f18564j == 2) {
                    j.this.x();
                }
            }
            if (j6 == 0) {
                j.this.f18567m.cancel();
                j.this.f18566l.cancel();
                j jVar = j.this;
                jVar.f18573s.removeCallbacks(jVar.f18567m);
                j.this.D();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f18577a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Button f18578b;

        c(final EditText val$et_code, final Button val$btn_two) {
            this.f18577a = val$et_code;
            this.f18578b = val$btn_two;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s5) {
            Context context;
            int i6;
            boolean z5 = this.f18577a.getText().toString().length() == 4;
            this.f18578b.setEnabled(z5);
            Button button = this.f18578b;
            if (z5) {
                context = j.this.f18555a;
                i6 = R.color.ios_dialog_button_color;
            } else {
                context = j.this.f18555a;
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
    class d implements iOSTwoButtonDialog.RightButtonOnClick {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ n1 b() {
            j.this.f18569o.startActivityForResult(new Intent(j.this.f18555a, (Class<?>) FaceDetectLearnActivity.class), 170);
            ((FragmentActivity) j.this.f18555a).overridePendingTransition(2130771987, 2130771986);
            return null;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            b0.x((FragmentActivity) j.this.f18555a, "人脸识别", new Function0() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 b6;
                    b6 = j.d.this.b();
                    return b6;
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnHomeListActivity learnHomeListActivity = (LearnHomeListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(LearnHomeListActivity.class);
            if (learnHomeListActivity != null) {
                learnHomeListActivity.T0();
            }
        }
    }

    public static /* synthetic */ boolean d(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
        return i6 == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.f18574t = true;
        final iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f18555a);
        Button button = (Button) iostwobuttondialog.findViewById(2131296668);
        iostwobuttondialog.setMessage("请输入验证码继续观看");
        iostwobuttondialog.setCenterCustomView(R.layout.dialog_confirm_code);
        iostwobuttondialog.setClickAutoCancel(false);
        iostwobuttondialog.setCanceledOnTouchOutside(false);
        button.setEnabled(false);
        final EditText editText = (EditText) iostwobuttondialog.findViewById(R.id.et_code);
        button.setTextColor(ContextCompat.getColor(this.f18555a, 2131099715));
        final ImageView imageView = (ImageView) iostwobuttondialog.findViewById(R.id.iv_code);
        imageView.setImageBitmap(com.bxkj.base.util.d.e().a());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                imageView.setImageBitmap(com.bxkj.base.util.d.e().a());
            }
        });
        editText.addTextChangedListener(new c(editText, button));
        iostwobuttondialog.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.e
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                j.this.E(iostwobuttondialog, editText, imageView);
            }
        });
        iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.f
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                j.this.G();
            }
        });
        iostwobuttondialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.g
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                return j.d(dialogInterface, i6, keyEvent);
            }
        });
        iostwobuttondialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.h
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                j.this.H(editText, dialogInterface);
            }
        });
        iostwobuttondialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.f18574t = true;
        iOSTwoButtonDialog message = new iOSTwoButtonDialog(this.f18555a).setMessage("学习已暂停，请先进行人脸识别");
        this.f18570p = message;
        message.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.b
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                j.this.J();
            }
        });
        this.f18570p.setRightButtonOnClickListener(new d());
        this.f18570p.setClickAutoCancel(false);
        this.f18570p.setCancelable(false);
        this.f18570p.setCanceledOnTouchOutside(false);
        this.f18570p.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.f18562h - this.f18565k == 0 && this.f18557c == this.f18558d) {
            this.f18556b.setText(this.f18563i == 1 ? "开始答题" : "已完成");
            this.f18556b.setEnabled(this.f18563i == 1);
            Http.with(this.f18555a).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideOtherStatusMessage().setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).v(this.f18560f, "4", 1)).setDataListener(new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        ((Activity) this.f18555a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        new iOSTwoButtonDialog(this.f18555a).setMessage("确定要取消本次学习吗？").setLeftButtonText("继续").setRightButtonText("放弃").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.i
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                j.this.F();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        this.f18570p.dismiss();
        ((Activity) this.f18555a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        new iOSTwoButtonDialog(this.f18555a).setMessage("确定要取消本次学习吗？").setLeftButtonText("继续").setRightButtonText("放弃").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.c
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                j.this.I();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        this.f18571q.setCountTime(this.f18565k);
        this.f18571q.setAlertCount(this.f18557c);
        com.orhanobut.logger.j.c("update=" + cn.bluemobi.dylan.sqlitelibrary.c.h().update(this.f18571q, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), this.f18560f}));
    }

    private void y(iOSTwoButtonDialog iOSTwoButtonDialog) {
        this.f18557c++;
        if (iOSTwoButtonDialog != null) {
            iOSTwoButtonDialog.dismiss();
        }
        this.f18574t = false;
        com.orhanobut.logger.j.c("已点击弹框次数=" + this.f18557c);
        D();
    }

    public void B() {
        y(this.f18570p);
    }

    public String C(long recordingTime) {
        String valueOf;
        String valueOf2;
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

    public void M(EditText editText) {
        if (editText != null) {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        }
    }

    public void N() {
        this.f18567m = new a();
        Timer timer = new Timer();
        this.f18566l = timer;
        timer.schedule(this.f18567m, 0L, 1000L);
    }

    public j(BottomFragment bottomFragment, Context mContext, int duration, int popTime, String id, String detailId, Button bt_question, int hasQuestion, int valType) {
        this.f18558d = 0;
        this.f18561g = 30;
        this.f18569o = bottomFragment;
        this.f18555a = mContext;
        this.f18559e = id;
        this.f18562h = duration;
        this.f18556b = bt_question;
        this.f18561g = popTime;
        if (popTime == 0) {
            this.f18558d = 0;
        } else {
            this.f18558d = duration / popTime;
        }
        this.f18560f = detailId;
        this.f18563i = hasQuestion;
        this.f18564j = valType;
        com.orhanobut.logger.j.c("需要弹框次数=" + this.f18558d);
        A();
    }

    private void A() {
        List query = cn.bluemobi.dylan.sqlitelibrary.c.h().query(ReadExceptionDataDB.class, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), this.f18560f});
        if (query.size() > 0) {
            ReadExceptionDataDB readExceptionDataDB = (ReadExceptionDataDB) query.get(0);
            this.f18571q = readExceptionDataDB;
            this.f18565k = readExceptionDataDB.getCountTime();
            this.f18557c = this.f18571q.getAlertCount();
            this.f18568n = Long.valueOf(this.f18571q.getStartTime());
            return;
        }
        this.f18568n = Long.valueOf(System.currentTimeMillis());
        this.f18571q = new ReadExceptionDataDB();
        this.f18571q.setCreateTime(com.bxkj.student.run.app.utils.i.h(this.f18568n.longValue(), "yyyy-MM-dd HH:mm:ss"));
        this.f18571q.setUserId(LoginUser.getLoginUser().getUserId());
        this.f18571q.setDetailId(this.f18560f);
        this.f18571q.setStartTime(this.f18568n.longValue());
        cn.bluemobi.dylan.sqlitelibrary.c.h().insert((cn.bluemobi.dylan.sqlitelibrary.c) this.f18571q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(EditText editText, DialogInterface dialogInterface) {
        M(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.a
            @Override // java.lang.Runnable
            public final void run() {
                j.this.K();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void E(iOSTwoButtonDialog iOSTwoButtonDialog, EditText et_code, ImageView iv_code) {
        if (!et_code.getText().toString().trim().equals(com.bxkj.base.util.d.e().d())) {
            Toast.makeText(this.f18555a, "验证码错误", 0).show();
            iv_code.setImageBitmap(com.bxkj.base.util.d.e().a());
        } else {
            y(iOSTwoButtonDialog);
        }
    }
}
