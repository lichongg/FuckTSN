package com.bxkj.student.home.teaching.learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.exam.formal.ExamActivity;
import com.bxkj.student.home.teaching.learning.FaceDetectLearnActivity;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.stub.StubApp;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class FaceDetectLearnActivity extends FaceDetectExpActivity {
    private int R = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            FaceDetectLearnActivity.this.N();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(View view) {
            FaceDetectLearnActivity.this.N();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Intent intent = new Intent(((FaceDetectExpActivity) FaceDetectLearnActivity.this).M, (Class<?>) ExamActivity.class);
            intent.putExtra("faceIndex", FaceDetectLearnActivity.this.R);
            com.orhanobut.logger.j.c("setResult-faceIndex=" + FaceDetectLearnActivity.this.R);
            FaceDetectLearnActivity.this.setResult(187, intent);
            FaceDetectLearnActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((FaceDetectExpActivity) FaceDetectLearnActivity.this).M).setMessage("人脸识别失败，请重新再试").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectLearnActivity.a.this.c(view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((FaceDetectExpActivity) FaceDetectLearnActivity.this).M).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FaceDetectLearnActivity.a.this.d(view);
                }
            }).show();
        }
    }

    static {
        StubApp.interface11(15819);
    }

    @Override // com.bxkj.student.run.app.face.FaceDetectExpActivity, com.baidu.idl.face.platform.ui.FaceDetectActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle savedInstanceState);

    @Override // com.bxkj.student.run.app.face.FaceDetectExpActivity
    protected void N() {
        Intent intent = new Intent();
        intent.putExtra("faceIndex", this.R);
        setResult(170, intent);
        finish();
    }

    @Override // com.bxkj.student.run.app.face.FaceDetectExpActivity
    protected void e(String base64ImageMap) {
        Http.with(this.M).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).F0(base64ImageMap, LoginUser.getLoginUser().getAccount())).setDataListener(new a());
    }
}
