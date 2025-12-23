package com.bxkj.student.home.teaching.learning.question;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import com.bxkj.base.v2.common.ext.b0;
import com.bxkj.student.R;
import com.bxkj.student.common.utils.video.LocalVideoPreviewActivity;
import com.bxkj.student.common.utils.video.OnLinePlayVideoActivity;
import com.bxkj.student.common.utils.video.e;
import com.bxkj.student.common.utils.video.g;
import com.bxkj.student.home.teaching.learning.question.VideoQuestionActivity;
import com.tencent.connect.share.QzonePublish;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.n1;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class VideoQuestionActivity extends BaseActivity {
    private Button F0;
    private Button G0;
    private String H0;
    private int I0;
    private String J0;
    private Bitmap K0;
    private LinearLayout L0;
    private List<Map<String, Object>> M0;
    private CommonAdapter<Map<String, Object>> N0;
    private Dialog P0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f18776a0;

    /* renamed from: b0, reason: collision with root package name */
    private RecyclerView f18777b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageView f18778c0;

    /* renamed from: k0, reason: collision with root package name */
    private ImageView f18779k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f18780p0;
    private int O0 = 60;
    private final int Q0 = 187;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Map map, View view) {
            VideoQuestionActivity.this.startActivity(new Intent(this.f1138e, (Class<?>) OnLinePlayVideoActivity.class).putExtra(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, JsonParse.getString(map, "answerStr")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_commit_time, "回答时间：" + JsonParse.getString(stringObjectMap, "answerTime"));
            holder.t(2131297182, JsonParse.getString(stringObjectMap, "learnVideoImage"), 2131231184, 2131231184);
            String string = JsonParse.getString(stringObjectMap, "reviewTime");
            holder.N(R.id.tv_check_time, TextUtils.isEmpty(string) ^ true);
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
            holder.w(R.id.fl_video_play, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoQuestionActivity.a.this.o(stringObjectMap, view);
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
            VideoQuestionActivity.this.Q().setVisibility(0);
            VideoQuestionActivity.this.T0(data);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            VideoQuestionActivity.this.G0();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            VideoQuestionActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable e6) {
            super.netOnFailure(e6);
            if (e6 instanceof SocketTimeoutException) {
                new iOSOneButtonDialog(((BaseActivity) VideoQuestionActivity.this).T).setMessage("上传超时,请检查网络后重试").setOneButtonText("重试").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VideoQuestionActivity.c.this.b(view);
                    }
                }).show();
                return;
            }
            StringWriter stringWriter = new StringWriter();
            e6.printStackTrace(new PrintWriter(stringWriter));
            stringWriter.toString();
            new iOSOneButtonDialog(((BaseActivity) VideoQuestionActivity.this).T).setMessage("上传失败,请尝试切换网络后重试或者尝试直接从APP录制上传").show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final ProgressDialog f18784a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f18785b;

        d(final String val$path) {
            this.f18785b = val$path;
            this.f18784a = new ProgressDialog(((BaseActivity) VideoQuestionActivity.this).T);
        }

        @Override // com.bxkj.student.common.utils.video.e.b
        public void a() {
            ProgressDialog progressDialog = this.f18784a;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f18784a.dismiss();
            }
            new iOSOneButtonDialog(((BaseActivity) VideoQuestionActivity.this).T).setMessage("压缩失败,请稍后再试").show();
        }

        @Override // com.bxkj.student.common.utils.video.e.b
        public void b(int percent) {
            ProgressDialog progressDialog = this.f18784a;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            this.f18784a.setProgress(percent);
        }

        @Override // com.bxkj.student.common.utils.video.e.b
        public void onStart() {
            this.f18784a.setTitle("正在压缩...");
            this.f18784a.setProgressStyle(1);
            this.f18784a.setIndeterminate(false);
            this.f18784a.setCanceledOnTouchOutside(false);
            this.f18784a.setProgress(0);
            this.f18784a.setMax(100);
            this.f18784a.show();
        }

        @Override // com.bxkj.student.common.utils.video.e.b
        public void onSuccess(String outputPath) {
            ProgressDialog progressDialog = this.f18784a;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f18784a.dismiss();
            }
            VideoQuestionActivity.this.J0 = outputPath;
            VideoQuestionActivity.this.K0 = com.bxkj.student.common.utils.video.h.a(this.f18785b);
            VideoQuestionActivity.this.f18778c0.setImageBitmap(VideoQuestionActivity.this.K0);
            VideoQuestionActivity.this.F0.setVisibility(0);
            VideoQuestionActivity.this.f18779k0.setVisibility(0);
            VideoQuestionActivity.this.f18780p0.setVisibility(0);
            VideoQuestionActivity.this.f18780p0.setText(VideoQuestionActivity.this.I0(com.bxkj.student.common.utils.video.h.b(outputPath)));
            VideoQuestionActivity.this.f18776a0.setHint("您视频地址为:" + VideoQuestionActivity.this.J0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        if (TextUtils.isEmpty(this.J0)) {
            new iOSOneButtonDialog(this.T).setMessage("请拍摄视频").show();
            return;
        }
        if (new File(this.J0).exists()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(MultipartBody.Part.createFormData("learnQuestionId", this.H0));
            arrayList.add(MultipartBody.Part.createFormData("answer", com.bxkj.base.util.c.a(this.K0)));
            File file = new File(this.J0);
            arrayList.add(MultipartBody.Part.createFormData("files", file.getName(), RequestBody.create(file, MediaType.parse("application/octet-stream"))));
            com.orhanobut.logger.j.c("文件存在");
            Http.with(this.T).setLoadingMessage("正在上传...").setTimeout(10L, TimeUnit.MINUTES).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).b(arrayList)).setDataListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String I0(long needFromatTime) {
        return new SimpleDateFormat("mm:ss").format(Long.valueOf(needFromatTime));
    }

    private void J0() {
        Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).c(this.H0, this.I0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(View view) {
        if (!TextUtils.isEmpty(this.J0)) {
            this.J0 = "";
        }
        this.f18776a0.setText("");
        this.f18778c0.setImageResource(R.drawable.ic_upload_video);
        this.F0.setVisibility(8);
        this.f18779k0.setVisibility(8);
        this.f18780p0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(View view) {
        if (TextUtils.isEmpty(this.J0)) {
            U0();
            return;
        }
        Intent intent = new Intent(this.T, (Class<?>) LocalVideoPreviewActivity.class);
        intent.putExtra("filepath", this.J0);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(View view) {
        this.P0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(View view) {
        this.P0.dismiss();
        b0.V(this.U, "录制视频", new Function0() { // from class: com.bxkj.student.home.teaching.learning.question.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 O0;
                O0 = VideoQuestionActivity.this.O0();
                return O0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(View view) {
        this.P0.dismiss();
        b0.M(this.U, "相册", new Function0() { // from class: com.bxkj.student.home.teaching.learning.question.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 Q0;
                Q0 = VideoQuestionActivity.this.Q0();
                return Q0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(Map<String, Object> data) {
        this.M0 = JsonParse.getList(data, "questionsRecord");
        this.O0 = JsonParse.getInt(data, "maxDuration", this.O0);
        if (this.M0.isEmpty()) {
            this.L0.setVisibility(8);
            this.f18777b0.setVisibility(8);
        } else {
            this.N0.g(this.M0);
        }
        this.Y.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.Z.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    private void V0(String path) {
        new com.bxkj.student.common.utils.video.e().d(this.T, path, new d(path));
    }

    private void W0() {
        new com.bxkj.student.common.utils.video.g().e(this, this.O0, new g.a() { // from class: com.bxkj.student.home.teaching.learning.question.i
            @Override // com.bxkj.student.common.utils.video.g.a
            public final void a(String str, Bitmap bitmap) {
                VideoQuestionActivity.this.S0(str, bitmap);
            }
        });
    }

    public void H0() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("video/*");
        startActivityForResult(Intent.createChooser(intent, "选择要录制的视频"), 187);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.F0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.K0(view);
            }
        });
        this.f18778c0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.L0(view);
            }
        });
        this.G0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.M0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("开始答题-视频");
    }

    public void U0() {
        View inflate = LayoutInflater.from(this.T).inflate(2131493632, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(2131298824);
        TextView textView2 = (TextView) inflate.findViewById(2131298917);
        TextView textView3 = (TextView) inflate.findViewById(2131298826);
        Dialog dialog = new Dialog(this.T, 2132018385);
        this.P0 = dialog;
        dialog.setContentView(inflate);
        this.P0.getWindow().setGravity(80);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = this.P0.getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        this.P0.getWindow().setAttributes(attributes);
        this.P0.show();
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.N0(view);
            }
        });
        textView.setText("录制");
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.P0(view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.R0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(View view) {
        G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 O0() {
        W0();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 Q0() {
        H0();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(String str, Bitmap bitmap) {
        V0(str);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_learn_video_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.H0 = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.I0 = getIntent().getIntExtra("isQualified", 0);
        }
        int i6 = this.I0;
        if (i6 == 1) {
            this.G0.setText("已合格");
            ((View) this.f18778c0.getParent()).setVisibility(8);
            this.G0.setEnabled(false);
        } else if (i6 == 2) {
            this.G0.setText("待批改");
            ((View) this.f18778c0.getParent()).setVisibility(8);
            this.G0.setEnabled(false);
        }
        this.f18777b0.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_learn_video_list, this.M0);
        this.N0 = aVar;
        this.f18777b0.setAdapter(aVar);
        J0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_index);
        this.X = (TextView) findViewById(2131299171);
        this.Y = (TextView) findViewById(2131299093);
        this.Z = (TextView) findViewById(R.id.tv_question);
        this.f18776a0 = (TextView) findViewById(2131298910);
        this.f18777b0 = (RecyclerView) findViewById(R.id.rv_answer);
        this.f18778c0 = (ImageView) findViewById(2131297159);
        this.F0 = (Button) findViewById(2131296602);
        this.f18779k0 = (ImageView) findViewById(R.id.cv_video_flag);
        this.f18780p0 = (TextView) findViewById(R.id.tv_duration);
        this.G0 = (Button) findViewById(2131296599);
        this.L0 = (LinearLayout) findViewById(R.id.ll_history_answer);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 187 && resultCode == -1 && data != null) {
            String b6 = com.bxkj.student.common.utils.e.b(this.T, data.getData());
            long b7 = com.bxkj.student.common.utils.video.h.b(b6);
            if (b7 / 1000 > this.O0) {
                new iOSOneButtonDialog(this.T).setMessage("对不起,您选取的视频时长不能大于" + this.O0 + "秒").show();
                return;
            }
            com.orhanobut.logger.j.c("duration=" + b7);
            V0(b6);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
