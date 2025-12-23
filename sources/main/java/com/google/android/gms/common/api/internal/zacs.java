package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@WorkerThread
/* loaded from: D:\Downloads\app\classes5.dex */
public interface zacs {
    void zae(ConnectionResult connectionResult);

    void zaf(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set set);

    void zag(int i6);
}
