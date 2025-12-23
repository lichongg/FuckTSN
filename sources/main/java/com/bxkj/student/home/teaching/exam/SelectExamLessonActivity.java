package com.bxkj.student.home.teaching.exam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.exam.formal.ExamActivity;
import com.bxkj.student.home.teaching.exam.mock.NewExamActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SelectExamLessonActivity extends BaseActivity {
    private List<Map<String, Object>> W;
    private RecyclerView X;
    private Button Y;
    private CommonAdapter<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f18136a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f18137b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f18138c0 = 8;

    /* renamed from: k0, reason: collision with root package name */
    private int f18139k0 = 2;

    /* renamed from: p0, reason: collision with root package name */
    private HashSet<String> f18140p0 = new HashSet<>();
    private HashSet<String> F0 = new HashSet<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "teachingCurriculumName"));
            String string = JsonParse.getString(stringObjectMap, "teachingCurriculumId");
            holder.m(2131296715, SelectExamLessonActivity.this.f18140p0.contains(string) || SelectExamLessonActivity.this.F0.contains(string));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectExamLessonActivity.this.W = (List) data.get("teachingCurriculumArray");
            SelectExamLessonActivity.this.Z.g(SelectExamLessonActivity.this.W);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            SelectExamLessonActivity.this.r0();
        }
    }

    private void p0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).Y()).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(ViewGroup viewGroup, View view, Object obj, int i6) {
        String string = JsonParse.getString(this.Z.getItem(i6), "teachingCurriculumId");
        int i7 = JsonParse.getInt(this.Z.getItem(i6), "type");
        if (i7 == 1) {
            if (this.f18140p0.contains(string)) {
                this.f18140p0.remove(string);
            } else if (this.f18140p0.size() < this.f18138c0) {
                this.f18140p0.add(string);
            } else {
                new iOSOneButtonDialog(this.T).setMessage("最多只能选择" + this.f18138c0 + "门A题型课程").show();
            }
        } else if (i7 == 2) {
            if (this.F0.contains(string)) {
                this.F0.remove(string);
            } else if (this.F0.size() < this.f18139k0) {
                this.F0.add(string);
            } else {
                new iOSOneButtonDialog(this.T).setMessage("最多只能选择" + this.f18139k0 + "门B题型课程").show();
            }
        }
        this.Z.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        if (this.f18140p0.size() != this.f18138c0) {
            new iOSOneButtonDialog(this.T).setMessage("请选择" + this.f18138c0 + "门A题型课程").show();
            return;
        }
        if (this.F0.size() != this.f18139k0) {
            new iOSOneButtonDialog(this.T).setMessage("请选择" + this.f18139k0 + "门B题型课程").show();
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f18140p0);
        hashSet.addAll(this.F0);
        Iterator it = hashSet.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(TextUtils.isEmpty(sb) ? "" : ",");
            sb.append((String) it.next());
        }
        Intent intent = getIntent();
        intent.putExtra("onlineType", this.f18137b0);
        intent.putExtra("selectIds", sb.toString());
        if (this.f18137b0 == 0) {
            intent.setClass(this.T, ExamActivity.class);
        } else {
            intent.setClass(this.T, NewExamActivity.class);
        }
        startActivity(intent);
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.exam.f
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                SelectExamLessonActivity.this.q0(viewGroup, view, obj, i6);
            }
        });
        this.Y.setOnClickListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W = new ArrayList();
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        this.X.addItemDecoration(new DividerItemDecoration(this.T, 1));
        a aVar = new a(this.T, R.layout.item_for_select_exam_lesson_list, this.W);
        this.Z = aVar;
        this.X.setAdapter(aVar);
        p0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("选择考试课程");
        if (getIntent().hasExtra("courseNum")) {
            this.f18136a0 = getIntent().getIntExtra("courseNum", 1);
            setTitle("请选择" + this.f18136a0 + "门考试课程");
        }
        if (getIntent().hasExtra("onlineType")) {
            this.f18137b0 = getIntent().getIntExtra("onlineType", 0);
        }
        setTitle("请选择8门A题型和2门B题型考试课程");
    }

    private void o0() {
        this.X = (RecyclerView) findViewById(2131298421);
        this.Y = (Button) findViewById(2131296623);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_exam_select_lesson;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        o0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
