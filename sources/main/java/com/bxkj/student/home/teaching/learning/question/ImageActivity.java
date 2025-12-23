package com.bxkj.student.home.teaching.learning.question;

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
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.MyListView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.v2.common.utils.b0;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.learning.question.ImageActivity;
import com.kuaishou.weapon.p0.t;
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
    private int F0;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> G0;
    private List<Map<String, Object>> H0;
    private MyGridView W;
    private Button X;
    private List<String> Y = new ArrayList();
    private cn.bluemobi.dylan.base.adapter.c Z;

    /* renamed from: a0, reason: collision with root package name */
    private MyListView f18749a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f18750b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f18751c0;

    /* renamed from: k0, reason: collision with root package name */
    private LinearLayout f18752k0;

    /* renamed from: p0, reason: collision with root package name */
    private String f18753p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.learning.question.ImageActivity$a$a, reason: collision with other inner class name */
        class C0227a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
            C0227a(Context context, int layoutId, List datas) {
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
            myGridView.setAdapter((ListAdapter) new C0227a(this.f1133a, R.layout.item_for_lost_img, Arrays.asList(split)));
            myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.e
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
            fileChannel = new RandomAccessFile(filename, t.f36150k).getChannel();
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
        if (this.Y.isEmpty()) {
            new iOSOneButtonDialog(this.T).setMessage("请至少上传一张图片").show();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(MultipartBody.Part.createFormData("learnQuestionId", this.f18753p0));
        Iterator<String> it = this.Y.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            arrayList.add(MultipartBody.Part.createFormData("files", file.getName(), RequestBody.create(file, MediaType.parse("application/octet-stream"))));
        }
        Http.with(this.T).setTimeout(3L, TimeUnit.MINUTES).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).b(arrayList)).setDataListener(new c());
    }

    private void m0() {
        Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).c(this.f18753p0, this.F0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 n0(File file) {
        this.Y.add(file.getPath());
        this.Z.c(this.Y);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(AdapterView adapterView, View view, int i6, long j6) {
        if (i6 == this.Y.size()) {
            b0.f16879a.r(this.U, new Function1() { // from class: com.bxkj.student.home.teaching.learning.question.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 n02;
                    n02 = ImageActivity.this.n0((File) obj);
                    return n02;
                }
            });
        } else {
            com.bxkj.base.util.n.c(this.T, this.Y, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Map<String, Object> data) {
        this.H0 = JsonParse.getList(data, "questionsRecord");
        this.Z.e(JsonParse.getInt(data, "pictureCount", 3));
        if (this.H0.isEmpty()) {
            this.f18752k0.setVisibility(8);
            this.f18749a0.setVisibility(8);
        } else {
            this.G0.c(this.H0);
        }
        this.f18750b0.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.f18751c0.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.d
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                ImageActivity.this.o0(adapterView, view, i6, j6);
            }
        });
        this.X.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("开始答题-拍照");
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
            this.f18753p0 = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.F0 = getIntent().getIntExtra("isQualified", 0);
        }
        int i6 = this.F0;
        if (i6 == 1) {
            this.X.setText("已合格");
            this.W.setVisibility(8);
            this.X.setEnabled(false);
        } else if (i6 == 2) {
            this.X.setText("待批改");
            this.W.setVisibility(8);
            this.X.setEnabled(false);
        }
        a aVar = new a(this.T, R.layout.item_for_learn_images_grid, this.H0);
        this.G0 = aVar;
        this.f18749a0.setAdapter((ListAdapter) aVar);
        List<String> list = this.Y;
        Context context = this.T;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.Z = cVar;
        cVar.e(3);
        this.W.setAdapter((ListAdapter) this.Z);
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (MyGridView) findViewById(2131297030);
        this.f18749a0 = (MyListView) findViewById(R.id.rv_answer);
        this.f18750b0 = (TextView) findViewById(2131299093);
        this.f18751c0 = (TextView) findViewById(R.id.tv_question);
        this.f18752k0 = (LinearLayout) findViewById(R.id.ll_history_answer);
        this.X = (Button) findViewById(2131296599);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        k0();
    }
}
