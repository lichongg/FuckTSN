package com.bxkj.student.v2.ai.fitness;

import android.content.Intent;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.common.utils.UniversalItemDecoration;
import com.bxkj.student.databinding.V2AiFitnessHomeBinding;
import com.bxkj.student.databinding.V2ItemForAiFitnessListBinding;
import com.bxkj.student.v2.ai.fitness.data.FitnessModel;
import com.bxkj.student.v2.ai.fitness.data.FitnessModelConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAIFitnessHomeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIFitnessHomeActivity.kt\ncom/bxkj/student/v2/ai/fitness/AIFitnessHomeActivity\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,67:1\n11561#2:68\n11896#2,3:69\n*S KotlinDebug\n*F\n+ 1 AIFitnessHomeActivity.kt\ncom/bxkj/student/v2/ai/fitness/AIFitnessHomeActivity\n*L\n24#1:68\n24#1:69,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class AIFitnessHomeActivity extends BaseActivity<V2AiFitnessHomeBinding, BaseViewModel> {

    @NotNull
    private final List<FitnessModel> U = new ArrayList();

    private final void O() {
        final List<FitnessModel> list = this.U;
        L().recyclerView.setAdapter(new BaseAdapter<FitnessModel, V2ItemForAiFitnessListBinding>(list) { // from class: com.bxkj.student.v2.ai.fitness.AIFitnessHomeActivity$setAdapter$adapter$1
            @Override // com.bxkj.base.v2.base.BaseAdapter
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public void f(V2ItemForAiFitnessListBinding itemBinding, FitnessModel fitnessModel, int i6) {
                g0.p(itemBinding, "itemBinding");
                g0.p(fitnessModel, "fitnessModel");
                itemBinding.setFitnessModel(fitnessModel);
                itemBinding.setAiFitnessHomeActivity(AIFitnessHomeActivity.this);
                itemBinding.ivIcon.setImageResource(fitnessModel.a());
            }
        });
        L().recyclerView.addItemDecoration(new UniversalItemDecoration() { // from class: com.bxkj.student.v2.ai.fitness.AIFitnessHomeActivity$setAdapter$1
            @Override // com.bxkj.student.common.utils.UniversalItemDecoration
            public UniversalItemDecoration.b a(int i6) {
                UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
                int a6 = i6 % 2 == 0 ? u.a(10.0f, AIFitnessHomeActivity.this.H()) : 0;
                aVar.f17791d = a6;
                aVar.f17789b = a6;
                aVar.f17787f = ContextCompat.getColor(AIFitnessHomeActivity.this.H(), 2131100584);
                return aVar;
            }
        });
    }

    @NotNull
    public final List<FitnessModel> M() {
        return this.U;
    }

    public final void N(@NotNull FitnessModel fitnessModel) {
        g0.p(fitnessModel, "fitnessModel");
        startActivity(new Intent(H(), (Class<?>) LivePreviewActivity.class).putExtra("fitnessModel", fitnessModel));
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        List<FitnessModel> list = this.U;
        FitnessModelConfig[] values = FitnessModelConfig.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (FitnessModelConfig fitnessModelConfig : values) {
            arrayList.add(fitnessModelConfig.getFitnessModel());
        }
        list.addAll(arrayList);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        L().setActivity(this);
        O();
    }
}
