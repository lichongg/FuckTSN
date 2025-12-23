package com.amap.api.services.help;

import android.content.Context;
import com.amap.api.col.s.o0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class Inputtips {

    /* renamed from: a, reason: collision with root package name */
    private IInputtipsSearch f9332a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface InputtipsListener {
        void onGetInputtips(List<Tip> list, int i6);
    }

    public Inputtips(Context context, InputtipsListener inputtipsListener) throws AMapException {
        this.f9332a = null;
        try {
            this.f9332a = new o0(context, inputtipsListener);
        } catch (Exception e6) {
            e6.printStackTrace();
            if (e6 instanceof AMapException) {
                throw ((AMapException) e6);
            }
        }
    }

    public final List<Tip> requestInputtips() throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.f9332a;
        if (iInputtipsSearch != null) {
            return iInputtipsSearch.requestInputtips();
        }
        return null;
    }

    public final InputtipsQuery getQuery() {
        IInputtipsSearch iInputtipsSearch = this.f9332a;
        if (iInputtipsSearch != null) {
            return iInputtipsSearch.getQuery();
        }
        return null;
    }

    public final void requestInputtipsAsyn() {
        IInputtipsSearch iInputtipsSearch = this.f9332a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtipsAsyn();
        }
    }

    public final void setInputtipsListener(InputtipsListener inputtipsListener) {
        IInputtipsSearch iInputtipsSearch = this.f9332a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.setInputtipsListener(inputtipsListener);
        }
    }

    public final void setQuery(InputtipsQuery inputtipsQuery) {
        IInputtipsSearch iInputtipsSearch = this.f9332a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.setQuery(inputtipsQuery);
        }
    }

    public final void requestInputtips(String str, String str2) throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.f9332a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtips(str, str2);
        }
    }

    public final void requestInputtips(String str, String str2, String str3) throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.f9332a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtips(str, str2, str3);
        }
    }

    public Inputtips(Context context, InputtipsQuery inputtipsQuery) {
        this.f9332a = null;
        try {
            this.f9332a = new o0(context, inputtipsQuery);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
