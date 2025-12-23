package com.bxkj.student.home.teaching.homework.question;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.MyListView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.v2.common.utils.b0;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.homework.question.ImageActivity;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ImageActivity extends BaseActivity {
    private static final String N0 = "temp_photo.jpg";
    private MyListView F0;
    private TextView G0;
    private TextView H0;
    private LinearLayout I0;
    private String J0;
    private int K0;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> L0;
    private List<Map<String, Object>> M0;
    private MyGridView W;
    private Button X;
    private TextView Y;

    /* renamed from: a0, reason: collision with root package name */
    private Dialog f18328a0;

    /* renamed from: k0, reason: collision with root package name */
    private File f18331k0;

    /* renamed from: p0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f18332p0;
    private List<String> Z = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    private final int f18329b0 = 170;

    /* renamed from: c0, reason: collision with root package name */
    private final int f18330c0 = 187;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.homework.question.ImageActivity$a$a, reason: collision with other inner class name */
        class C0222a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
            C0222a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(ViewHolder holder, String s5) {
                holder.t(R.id.iv_img, s5, 2131231184, 2131231184);
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        private void g(String[] arr, int index) {
            Intent intent = new Intent(this.f1133a, (Class<?>) ImagePagerActivity.class);
            intent.putExtra(ImagePagerActivity.T, arr);
            intent.putExtra(ImagePagerActivity.S, index);
            ImageActivity.this.startActivity(intent);
            ImageActivity.this.overridePendingTransition(2130772094, 2130772095);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String[] strArr, AdapterView adapterView, View view, int i6, long j6) {
            g(strArr, i6);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            MyGridView myGridView = (MyGridView) holder.h(R.id.my_grid);
            final String[] split = JsonParse.getString(stringObjectMap, "answerStr").split(",");
            myGridView.setAdapter((ListAdapter) new C0222a(this.f1133a, R.layout.item_for_lost_img, Arrays.asList(split)));
            myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.e
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                    ImageActivity.a.this.f(split, adapterView, view, i6, j6);
                }
            });
            holder.J(R.id.tv_commit_time, "回答时间：" + JsonParse.getString(stringObjectMap, "answerTime"));
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
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ImageActivity.this.Q().setVisibility(0);
            ImageActivity.this.p0(data);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ImageActivity.this.finish();
        }
    }

    public static byte[] q0(String filename) {
        Throwable th;
        IOException iOException;
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            fileChannel = new RandomAccessFile(filename, com.kuaishou.weapon.p0.t.f36150k).getChannel();
        } catch (IOException e6) {
            iOException = e6;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                fileChannel2.close();
                throw th;
            } catch (IOException e7) {
                e7.printStackTrace();
                throw th;
            }
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                com.orhanobut.logger.j.c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                    return bArr;
                } catch (IOException e8) {
                    e8.printStackTrace();
                    return bArr;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel2 = fileChannel;
                fileChannel2.close();
                throw th;
            }
        } catch (IOException e9) {
            iOException = e9;
            iOException.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            return null;
        }
    }

    private void k0() {
        if (this.Z.isEmpty()) {
            new iOSOneButtonDialog(this.T).setMessage("请至少上传一张图片").show();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(MultipartBody.Part.createFormData("learnQuestionId", this.J0));
        Iterator<String> it = this.Z.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            arrayList.add(MultipartBody.Part.createFormData("files", file.getName(), RequestBody.create(file, MediaType.parse("application/octet-stream"))));
        }
        Http.with(this.T).setTimeout(3L, TimeUnit.MINUTES).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).b(arrayList)).setDataListener(new c());
    }

    private void m0() {
        Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).c(this.J0, this.K0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 n0(File file) {
        this.Z.add(file.getPath());
        this.f18332p0.c(this.Z);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(AdapterView adapterView, View view, int i6, long j6) {
        if (i6 == this.Z.size()) {
            b0.f16879a.r(this.U, new Function1() { // from class: com.bxkj.student.home.teaching.homework.question.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 n02;
                    n02 = ImageActivity.this.n0((File) obj);
                    return n02;
                }
            });
        } else {
            com.bxkj.base.util.n.c(this.T, this.Z, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Map<String, Object> data) {
        boolean z5 = JsonParse.getBoolean(data, "isFlag");
        int i6 = this.K0;
        if (i6 == 1) {
            this.X.setText("已合格");
            this.W.setVisibility(8);
            this.X.setEnabled(false);
        } else if (i6 == 2) {
            this.X.setText("待批改");
            this.W.setVisibility(8);
            this.X.setEnabled(false);
        } else if (z5) {
            this.X.setText("提交");
            this.X.setEnabled(true);
        } else {
            this.X.setText("不合格");
            this.X.setEnabled(false);
            this.W.setVisibility(8);
            this.Y.setVisibility(0);
            this.Y.setText(JsonParse.getString(data, "markAnswer"));
        }
        this.M0 = JsonParse.getList(data, "questionsRecord");
        this.f18332p0.e(JsonParse.getInt(data, "pictureCount", 3));
        if (this.M0.isEmpty()) {
            this.I0.setVisibility(8);
            this.F0.setVisibility(8);
        } else {
            this.L0.c(this.M0);
        }
        this.G0.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.H0.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.c
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                ImageActivity.this.o0(adapterView, view, i6, j6);
            }
        });
        this.X.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("课后作业开始答题-拍照");
    }

    public Map<String, RequestBody> l0(String key, List<File> files) {
        ArrayMap arrayMap = new ArrayMap();
        for (int i6 = 0; i6 < files.size(); i6++) {
            File file = files.get(i6);
            arrayMap.put(key + "\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
        }
        return arrayMap;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_learn_camera_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.J0 = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.K0 = getIntent().getIntExtra("isQualified", 0);
        }
        a aVar = new a(this.T, R.layout.item_for_learn_images_grid, this.M0);
        this.L0 = aVar;
        this.F0.setAdapter((ListAdapter) aVar);
        List<String> list = this.Z;
        Context context = this.T;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, cn.bluemobi.dylan.base.utils.u.a(10.0f, context));
        this.f18332p0 = cVar;
        cVar.e(3);
        this.W.setAdapter((ListAdapter) this.f18332p0);
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (MyGridView) findViewById(2131297030);
        this.F0 = (MyListView) findViewById(R.id.rv_answer);
        this.G0 = (TextView) findViewById(2131299093);
        this.H0 = (TextView) findViewById(R.id.tv_question);
        this.I0 = (LinearLayout) findViewById(R.id.ll_history_answer);
        this.X = (Button) findViewById(2131296599);
        this.Y = (TextView) findViewById(R.id.tv_right_answer);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        k0();
    }
}
