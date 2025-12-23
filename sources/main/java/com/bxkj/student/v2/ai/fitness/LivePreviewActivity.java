package com.bxkj.student.v2.ai.fitness;

import android.content.Context;
import android.content.Intent;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.bxkj.student.R;
import com.bxkj.student.v2.ai.fitness.camera.CameraSourcePreview;
import com.bxkj.student.v2.ai.fitness.camera.GraphicOverlay;
import com.bxkj.student.v2.ai.fitness.data.FitnessModel;
import com.bxkj.student.v2.ai.fitness.data.FitnessModelConfig;
import com.bxkj.student.v2.ai.fitness.posedetector.c;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.orhanobut.logger.j;
import com.stub.StubApp;
import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class LivePreviewActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static final String S = "LivePreviewActivity";
    private static final String T = "深蹲";
    private static final String U = "开合跳";
    private static final int V = 1;
    private CameraSourcePreview N;
    private GraphicOverlay O;
    private Chronometer Q;
    private com.bxkj.student.v2.ai.fitness.camera.c M = null;
    private FitnessModel P = FitnessModelConfig.SQUAT.getFitnessModel();
    private boolean R = false;

    static {
        StubApp.interface11(16950);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    private long N(String strTime) {
        long j6;
        long parseLong;
        long parseLong2;
        String[] split = strTime.split(":");
        if (split.length == 2) {
            parseLong = Long.parseLong(split[0]) * 60000;
            parseLong2 = Long.parseLong(split[1]);
        } else {
            if (split.length != 3) {
                j6 = 0;
                return SystemClock.elapsedRealtime() - j6;
            }
            parseLong = (Long.parseLong(split[0]) * 3600000) + (Long.parseLong(split[1]) * 60000);
            parseLong2 = Long.parseLong(split[0]);
        }
        j6 = parseLong + (parseLong2 * 1000);
        return SystemClock.elapsedRealtime() - j6;
    }

    private void O(final FitnessModel fitnessModel) {
        if (this.M == null) {
            this.M = new com.bxkj.student.v2.ai.fitness.camera.c(this, this.O);
        }
        try {
            try {
                this.M.t(new com.bxkj.student.v2.ai.fitness.posedetector.c((Context) this, true, fitnessModel.e(), fitnessModel.d(), fitnessModel.c()).G(new c.a() { // from class: com.bxkj.student.v2.ai.fitness.b
                    @Override // com.bxkj.student.v2.ai.fitness.posedetector.c.a
                    public final void a(List list) {
                        LivePreviewActivity.this.Q(fitnessModel, list);
                    }
                }));
            } catch (RuntimeException e6) {
                e = e6;
                fitnessModel.b();
                Toast.makeText(StubApp.getOrigApplicationContext(getApplicationContext()), "创建图像处理器失败: " + e.getMessage(), 1).show();
            }
        } catch (RuntimeException e7) {
            e = e7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(View view) {
        com.bxkj.student.v2.ai.fitness.camera.c cVar = this.M;
        if (cVar != null) {
            if (cVar.m() == 0) {
                this.M.s(1);
            } else {
                this.M.s(0);
            }
        }
        this.N.h();
        S();
    }

    private void S() {
        com.bxkj.student.v2.ai.fitness.camera.c cVar = this.M;
        if (cVar != null) {
            try {
                this.N.f(cVar, this.O);
            } catch (IOException unused) {
                this.M.p();
                this.M = null;
            }
        }
    }

    private void M() {
        ((ImageView) findViewById(R.id.iv_camera_switch)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ai.fitness.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePreviewActivity.this.P(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(FitnessModel fitnessModel, List list) {
        if (fitnessModel.e() || list.size() < 2) {
            return;
        }
        String str = (String) list.get(0);
        String str2 = (String) list.get(1);
        if (str.equals(fitnessModel.c()) && Integer.parseInt(str2) >= 100) {
            if (!this.R) {
                this.R = true;
                new ToneGenerator(5, 100).startTone(24);
                Chronometer chronometer = this.Q;
                chronometer.setBase(N(chronometer.getText().toString()));
                this.Q.start();
            }
        } else {
            this.R = false;
            this.Q.stop();
        }
        j.c("分类结果：" + str + " 置信度：" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(View view) {
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.bxkj.student.v2.ai.fitness.camera.c cVar = this.M;
        if (cVar != null) {
            cVar.p();
        }
        stopService(new Intent(this, (Class<?>) MlKitComponentDiscoveryService.class));
        j.c("MlKitComponentDiscoveryService----------stop");
        MlKitContext.initializeIfNeeded(null);
        this.Q.stop();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.N.h();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        O(this.P);
        S();
    }
}
