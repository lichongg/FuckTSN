package com.bxkj.student.run.app.exam;

import android.os.Bundle;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.databinding.AcRunQuestionBinding;
import com.orhanobut.logger.j;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nQuestionActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QuestionActivity.kt\ncom/bxkj/student/run/app/exam/QuestionActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,94:1\n1869#2,2:95\n*S KotlinDebug\n*F\n+ 1 QuestionActivity.kt\ncom/bxkj/student/run/app/exam/QuestionActivity\n*L\n49#1:95,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class QuestionActivity extends AppCompatActivity {
    private AcRunQuestionBinding M;
    private QuestionVieModel N;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            List<Map<String, Object>> list = JsonParse.getList(map, "data");
            if (list == null || list.size() <= 0) {
                return;
            }
            QuestionVieModel questionVieModel = QuestionActivity.this.N;
            QuestionVieModel questionVieModel2 = null;
            if (questionVieModel == null) {
                g0.S("mViewModel");
                questionVieModel = null;
            }
            questionVieModel.g().putAll(list.get(0));
            QuestionVieModel questionVieModel3 = QuestionActivity.this.N;
            if (questionVieModel3 == null) {
                g0.S("mViewModel");
                questionVieModel3 = null;
            }
            questionVieModel3.e().addAll(JsonParse.getList(list.get(0), "answers"));
            AcRunQuestionBinding acRunQuestionBinding = QuestionActivity.this.M;
            if (acRunQuestionBinding == null) {
                g0.S("mDataBinding");
                acRunQuestionBinding = null;
            }
            QuestionVieModel questionVieModel4 = QuestionActivity.this.N;
            if (questionVieModel4 == null) {
                g0.S("mViewModel");
                questionVieModel4 = null;
            }
            acRunQuestionBinding.setData(questionVieModel4.g());
            AcRunQuestionBinding acRunQuestionBinding2 = QuestionActivity.this.M;
            if (acRunQuestionBinding2 == null) {
                g0.S("mDataBinding");
                acRunQuestionBinding2 = null;
            }
            QuestionVieModel questionVieModel5 = QuestionActivity.this.N;
            if (questionVieModel5 == null) {
                g0.S("mViewModel");
            } else {
                questionVieModel2 = questionVieModel5;
            }
            acRunQuestionBinding2.setAnswer(questionVieModel2.e());
        }
    }

    static {
        StubApp.interface11(16595);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    private final String O() {
        QuestionVieModel questionVieModel = this.N;
        if (questionVieModel == null) {
            g0.S("mViewModel");
            questionVieModel = null;
        }
        String str = "";
        for (Map<String, Object> map : questionVieModel.e()) {
            if (JsonParse.getInt(map, "isRight") == 0) {
                str = "正确答案：" + JsonParse.getString(map, "mark");
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(QuestionActivity questionActivity, RadioGroup radioGroup, int i6) {
        QuestionVieModel questionVieModel = questionActivity.N;
        AcRunQuestionBinding acRunQuestionBinding = null;
        if (questionVieModel == null) {
            g0.S("mViewModel");
            questionVieModel = null;
        }
        questionVieModel.i(Integer.valueOf(i6));
        AcRunQuestionBinding acRunQuestionBinding2 = questionActivity.M;
        if (acRunQuestionBinding2 == null) {
            g0.S("mDataBinding");
            acRunQuestionBinding2 = null;
        }
        RadioGroup radioGroup2 = acRunQuestionBinding2.rgAnswer;
        AcRunQuestionBinding acRunQuestionBinding3 = questionActivity.M;
        if (acRunQuestionBinding3 == null) {
            g0.S("mDataBinding");
            acRunQuestionBinding3 = null;
        }
        RadioGroup radioGroup3 = acRunQuestionBinding3.rgAnswer;
        QuestionVieModel questionVieModel2 = questionActivity.N;
        if (questionVieModel2 == null) {
            g0.S("mViewModel");
            questionVieModel2 = null;
        }
        Integer f6 = questionVieModel2.f();
        g0.m(f6);
        int indexOfChild = radioGroup2.indexOfChild(radioGroup3.findViewById(f6.intValue()));
        QuestionVieModel questionVieModel3 = questionActivity.N;
        if (questionVieModel3 == null) {
            g0.S("mViewModel");
            questionVieModel3 = null;
        }
        if (Integer.parseInt(String.valueOf(questionVieModel3.e().get(indexOfChild).get("isRight"))) != 1) {
            AcRunQuestionBinding acRunQuestionBinding4 = questionActivity.M;
            if (acRunQuestionBinding4 == null) {
                g0.S("mDataBinding");
            } else {
                acRunQuestionBinding = acRunQuestionBinding4;
            }
            acRunQuestionBinding.tvRightAnswer.setVisibility(8);
            return;
        }
        AcRunQuestionBinding acRunQuestionBinding5 = questionActivity.M;
        if (acRunQuestionBinding5 == null) {
            g0.S("mDataBinding");
            acRunQuestionBinding5 = null;
        }
        acRunQuestionBinding5.tvRightAnswer.setText(questionActivity.O());
        AcRunQuestionBinding acRunQuestionBinding6 = questionActivity.M;
        if (acRunQuestionBinding6 == null) {
            g0.S("mDataBinding");
        } else {
            acRunQuestionBinding = acRunQuestionBinding6;
        }
        acRunQuestionBinding.tvRightAnswer.setVisibility(0);
    }

    public final void M() {
        QuestionVieModel questionVieModel = this.N;
        QuestionVieModel questionVieModel2 = null;
        if (questionVieModel == null) {
            g0.S("mViewModel");
            questionVieModel = null;
        }
        if (questionVieModel.f() == null) {
            new iOSOneButtonDialog(this).setMessage("请选择答案").show();
            return;
        }
        AcRunQuestionBinding acRunQuestionBinding = this.M;
        if (acRunQuestionBinding == null) {
            g0.S("mDataBinding");
            acRunQuestionBinding = null;
        }
        RadioGroup radioGroup = acRunQuestionBinding.rgAnswer;
        AcRunQuestionBinding acRunQuestionBinding2 = this.M;
        if (acRunQuestionBinding2 == null) {
            g0.S("mDataBinding");
            acRunQuestionBinding2 = null;
        }
        RadioGroup radioGroup2 = acRunQuestionBinding2.rgAnswer;
        QuestionVieModel questionVieModel3 = this.N;
        if (questionVieModel3 == null) {
            g0.S("mViewModel");
            questionVieModel3 = null;
        }
        Integer f6 = questionVieModel3.f();
        g0.m(f6);
        int indexOfChild = radioGroup.indexOfChild(radioGroup2.findViewById(f6.intValue()));
        j.d("indexOfChild=" + indexOfChild, new Object[0]);
        QuestionVieModel questionVieModel4 = this.N;
        if (questionVieModel4 == null) {
            g0.S("mViewModel");
        } else {
            questionVieModel2 = questionVieModel4;
        }
        ObservableArrayList<Map<String, Object>> e6 = questionVieModel2.e();
        if (e6 != null) {
            if (Integer.parseInt(String.valueOf(e6.get(indexOfChild).get("isRight"))) == 1) {
                new iOSOneButtonDialog(this).setMessage("答案错误").show();
            } else {
                setResult(-1);
                finish();
            }
        }
    }

    private final void N() {
        Http.with(this).setObservable(((e0.a) Http.getApiService(e0.a.class)).f0()).setDataListener(new a());
    }
}
