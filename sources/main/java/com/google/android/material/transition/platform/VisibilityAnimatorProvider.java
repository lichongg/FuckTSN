package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes5.dex */
public interface VisibilityAnimatorProvider {
    @Nullable
    Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view);

    @Nullable
    Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view);
}
