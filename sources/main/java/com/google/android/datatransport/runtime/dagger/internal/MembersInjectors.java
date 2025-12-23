package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.MembersInjector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class MembersInjectors {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum NoOpMembersInjector implements MembersInjector<Object> {
        INSTANCE;

        @Override // com.google.android.datatransport.runtime.dagger.MembersInjector
        public void injectMembers(Object obj) {
            Preconditions.checkNotNull(obj, "Cannot inject members into a null reference");
        }
    }

    public static <T> MembersInjector<T> noOp() {
        return NoOpMembersInjector.INSTANCE;
    }

    private MembersInjectors() {
    }
}
