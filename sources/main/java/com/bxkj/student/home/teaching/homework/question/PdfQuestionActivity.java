package com.bxkj.student.home.teaching.homework.question;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.homework.question.PdfQuestionActivity;
import java.io.File;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class PdfQuestionActivity extends BaseActivity {
    private Button F0;
    private Button G0;
    private TextView H0;
    private String I0;
    private int J0;
    private String K0;
    private LinearLayout L0;
    private List<Map<String, Object>> M0;
    private CommonAdapter<Map<String, Object>> N0;
    private int O0 = 60;
    private final int P0 = 23;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f18337a0;

    /* renamed from: b0, reason: collision with root package name */
    private RecyclerView f18338b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageView f18339c0;

    /* renamed from: k0, reason: collision with root package name */
    private ImageView f18340k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f18341p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Map map, View view) {
            PdfQuestionActivity.this.startActivity(new Intent(this.f1138e, (Class<?>) PdfViewActivity.class).putExtra("url", JsonParse.getString(map, "answerStr")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_commit_time, "回答时间：" + JsonParse.getString(stringObjectMap, "answerTime"));
            holder.r(2131297182, 2131231197);
            holder.N(R.id.cv_video_flag, false);
            String string = JsonParse.getString(stringObjectMap, "reviewTime");
            holder.N(R.id.tv_check_time, !TextUtils.isEmpty(string));
            holder.J(R.id.tv_check_time, "批改时间：" + string);
            int i6 = JsonParse.getInt(stringObjectMap, "isRight");
            if (i6 == 0) {
                holder.J(R.id.tv_isOK, "是否合格：不合格");
            } else if (i6 == 1) {
                holder.J(R.id.tv_isOK, "是否合格：合格");
            } else if (i6 == 2) {
                holder.J(R.id.tv_isOK, "是否合格：待批改");
            }
            String string2 = JsonParse.getString(stringObjectMap, "note");
            holder.N(R.id.tv_reviewer, !TextUtils.isEmpty(string2));
            holder.J(R.id.tv_reviewer, "备注：" + string2);
            holder.w(R.id.fl_video_play, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PdfQuestionActivity.a.this.o(stringObjectMap, view);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PdfQuestionActivity.this.Q().setVisibility(0);
            PdfQuestionActivity.this.v0(data);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            PdfQuestionActivity.this.p0();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PdfQuestionActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable e6) {
            super.netOnFailure(e6);
            if (e6 instanceof SocketTimeoutException) {
                new iOSOneButtonDialog(((BaseActivity) PdfQuestionActivity.this).T).setMessage("上传超时,请检查网络后重试").setOneButtonText("重试").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PdfQuestionActivity.c.this.b(view);
                    }
                }).show();
            }
        }
    }

    private void o0() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("application/pdf");
        intent.addCategory("android.intent.category.OPENABLE");
        new u.b(this).startActivityForResult(intent).c(new b.a() { // from class: com.bxkj.student.home.teaching.homework.question.i
            @Override // u.b.a
            public final void a(int i6, Intent intent2) {
                PdfQuestionActivity.this.u0(i6, intent2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        if (TextUtils.isEmpty(this.K0)) {
            new iOSOneButtonDialog(this.T).setMessage("请选择文件").show();
            return;
        }
        if (!new File(this.K0).exists()) {
            new iOSOneButtonDialog(this.T).setMessage("文件不存在！").show();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(MultipartBody.Part.createFormData("learnQuestionId", this.I0));
        File file = new File(this.K0);
        arrayList.add(MultipartBody.Part.createFormData("files", file.getName(), RequestBody.create(file, MediaType.parse("application/octet-stream"))));
        com.orhanobut.logger.j.c("文件存在");
        Http.with(this.T).setLoadingMessage("正在上传...").setTimeout(3L, TimeUnit.MINUTES).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).b(arrayList)).setDataListener(new c());
    }

    private void q0() {
        Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).c(this.I0, this.J0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(View view) {
        if (!TextUtils.isEmpty(this.K0)) {
            this.K0 = "";
        }
        this.f18337a0.setText("");
        this.f18339c0.setImageResource(R.drawable.ic_upload_pdf);
        this.f18340k0.setVisibility(8);
        this.f18341p0.setVisibility(8);
        this.F0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(View view) {
        if (TextUtils.isEmpty(this.K0)) {
            o0();
            return;
        }
        Intent intent = new Intent(this.T, (Class<?>) PdfViewActivity.class);
        intent.putExtra("filePath", this.K0);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(int i6, Intent intent) {
        if (intent != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.K0 = com.bxkj.student.common.utils.e.b(this.T, intent.getData());
            } else {
                this.K0 = com.bxkj.student.common.utils.e.c(this.T, intent.getData());
            }
            if (!"pdf".equalsIgnoreCase(com.bxkj.base.util.file.b.i(this.K0))) {
                this.K0 = null;
                new iOSOneButtonDialog(this.T).setMessage("只能上传PDF文件").show();
                return;
            }
            this.f18339c0.setImageResource(R.mipmap.pdf);
            this.F0.setVisibility(0);
            com.orhanobut.logger.j.c("filePath=" + this.K0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(Map<String, Object> data) {
        this.X.setText(JsonParse.getString(data, "questionTypeName"));
        boolean z5 = JsonParse.getBoolean(data, "isFlag");
        int i6 = this.J0;
        if (i6 == 1) {
            this.G0.setText("已合格");
            ((View) this.f18339c0.getParent()).setVisibility(8);
            this.G0.setEnabled(false);
        } else if (i6 == 2) {
            this.G0.setText("待批改");
            ((View) this.f18339c0.getParent()).setVisibility(8);
            this.G0.setEnabled(false);
        } else if (z5) {
            this.G0.setText("提交");
            this.G0.setEnabled(true);
        } else {
            this.G0.setText("不合格");
            this.G0.setEnabled(false);
            ((View) this.f18339c0.getParent()).setVisibility(8);
            this.H0.setVisibility(0);
            this.H0.setText(JsonParse.getString(data, "markAnswer"));
        }
        this.M0 = JsonParse.getList(data, "questionsRecord");
        this.O0 = JsonParse.getInt(data, "maxDuration", this.O0);
        if (this.M0.isEmpty()) {
            this.L0.setVisibility(8);
            this.f18338b0.setVisibility(8);
        } else {
            this.N0.g(this.M0);
        }
        this.Y.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.Z.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.F0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PdfQuestionActivity.this.r0(view);
            }
        });
        this.f18339c0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PdfQuestionActivity.this.s0(view);
            }
        });
        this.G0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PdfQuestionActivity.this.t0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("课后作业开始答题-PDF文件");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View view) {
        p0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_learn_video_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.I0 = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.J0 = getIntent().getIntExtra("isQualified", 0);
        }
        this.f18338b0.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_learn_video_list, this.M0);
        this.N0 = aVar;
        this.f18338b0.setAdapter(aVar);
        q0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_index);
        this.X = (TextView) findViewById(2131299171);
        this.Y = (TextView) findViewById(2131299093);
        this.Z = (TextView) findViewById(R.id.tv_question);
        this.f18337a0 = (TextView) findViewById(2131298910);
        this.f18338b0 = (RecyclerView) findViewById(R.id.rv_answer);
        this.f18339c0 = (ImageView) findViewById(2131297159);
        this.f18340k0 = (ImageView) findViewById(R.id.cv_video_flag);
        this.f18341p0 = (TextView) findViewById(R.id.tv_duration);
        this.F0 = (Button) findViewById(2131296602);
        this.G0 = (Button) findViewById(2131296599);
        this.H0 = (TextView) findViewById(R.id.tv_right_answer);
        this.L0 = (LinearLayout) findViewById(R.id.ll_history_answer);
        this.f18339c0.setImageResource(R.drawable.ic_upload_pdf);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
