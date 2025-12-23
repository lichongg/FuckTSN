package com.google.android.material.textfield;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class CustomEndIconDelegate extends EndIconDelegate {
    @Override // com.google.android.material.textfield.EndIconDelegate
    void setUp() {
        this.endLayout.setEndIconOnLongClickListener(null);
    }

    CustomEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
    }
}
