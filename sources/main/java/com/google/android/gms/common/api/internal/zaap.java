package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zaap extends zaav {
    final /* synthetic */ zaaw zaa;
    private final ArrayList zac;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaap(zaaw zaawVar, ArrayList arrayList) {
        super(zaawVar, null);
        this.zaa = zaawVar;
        this.zac = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.zaav
    @WorkerThread
    public final void zaa() {
        zabi zabiVar;
        IAccountAccessor iAccountAccessor;
        zabi zabiVar2;
        zaaw zaawVar = this.zaa;
        zabiVar = zaawVar.zaa;
        zabiVar.zag.zad = zaaw.zao(zaawVar);
        ArrayList arrayList = this.zac;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            Api.Client client = (Api.Client) arrayList.get(i6);
            zaaw zaawVar2 = this.zaa;
            iAccountAccessor = zaawVar2.zao;
            zabiVar2 = zaawVar2.zaa;
            client.getRemoteService(iAccountAccessor, zabiVar2.zag.zad);
        }
    }
}
