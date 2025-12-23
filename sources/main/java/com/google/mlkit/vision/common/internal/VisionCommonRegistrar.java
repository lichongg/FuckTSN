package com.google.mlkit.vision.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class VisionCommonRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    public final List getComponents() {
        return zzp.zzi(Component.builder(MultiFlavorDetectorCreator.class).add(Dependency.setOf(MultiFlavorDetectorCreator.Registration.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.vision.common.internal.zzf
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new MultiFlavorDetectorCreator(componentContainer.setOf(MultiFlavorDetectorCreator.Registration.class));
            }
        }).build());
    }
}
