package com.bxkj.student.v2.ui.face;

import android.content.Intent;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.student.databinding.V3FaceCollectConfirmBinding;
import com.bxkj.student.v2.vm.face.FaceCollectVM;
import java.io.File;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFaceCollectConfirmActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FaceCollectConfirmActivity.kt\ncom/bxkj/student/v2/ui/face/FaceCollectConfirmActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,42:1\n1#2:43\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class FaceCollectConfirmActivity extends BaseActivity<V3FaceCollectConfirmBinding, FaceCollectVM> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 N(FaceCollectConfirmActivity faceCollectConfirmActivity) {
        ContextExtKt.s(faceCollectConfirmActivity, "人脸采集成功", 0, 2, null);
        cn.bluemobi.dylan.base.utils.a.n().i(FaceCollectActivity.class);
        faceCollectConfirmActivity.finish();
        return n1.f44123a;
    }

    public final void M() {
        Intent intent = getIntent();
        if (intent != null) {
            if (!intent.hasExtra("avatar")) {
                intent = null;
            }
            if (intent != null) {
                D().t(new File(getIntent().getStringExtra("avatar")), new Function0() { // from class: com.bxkj.student.v2.ui.face.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        n1 N;
                        N = FaceCollectConfirmActivity.N(FaceCollectConfirmActivity.this);
                        return N;
                    }
                });
            }
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        L().setActivity(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (!intent.hasExtra("avatar")) {
                intent = null;
            }
            if (intent != null) {
                com.orhanobut.logger.j.d("intent.getStringExtra(\"avatar\")=" + getIntent().getStringExtra("avatar"), new Object[0]);
                com.bumptech.glide.b.D(H()).e(new File(getIntent().getStringExtra("avatar"))).I0(true).t(com.bumptech.glide.load.engine.j.f15240b).m1(L().ivFace);
            }
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
