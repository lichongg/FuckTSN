package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import com.stub.StubApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class o0 implements IInputtipsSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f8284a;

    /* renamed from: b, reason: collision with root package name */
    private Inputtips.InputtipsListener f8285b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f8286c;

    /* renamed from: d, reason: collision with root package name */
    private InputtipsQuery f8287d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.obj = o0.this.f8285b;
            obtainMessage.arg1 = 5;
            try {
                try {
                    o0 o0Var = o0.this;
                    ArrayList<? extends Parcelable> c6 = o0Var.c(o0Var.f8287d);
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("result", c6);
                    obtainMessage.setData(bundle);
                    obtainMessage.what = 1000;
                } catch (AMapException e6) {
                    obtainMessage.what = e6.getErrorCode();
                }
            } finally {
                o0.this.f8286c.sendMessage(obtainMessage);
            }
        }
    }

    public o0(Context context, Inputtips.InputtipsListener inputtipsListener) throws AMapException {
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a != cf.c.SuccessCode) {
            String str = a6.f8109b;
            throw new AMapException(str, 1, str, a6.f8108a.a());
        }
        this.f8284a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f8285b = inputtipsListener;
        this.f8286c = u4.a();
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final ArrayList<Tip> requestInputtips() throws AMapException {
        return c(this.f8287d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Tip> c(InputtipsQuery inputtipsQuery) throws AMapException {
        try {
            s4.d(this.f8284a);
            if (inputtipsQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (inputtipsQuery.getKeyword() == null || inputtipsQuery.getKeyword().equals("")) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            return new q4(this.f8284a, inputtipsQuery).O();
        } catch (Throwable th) {
            j4.i(th, "Inputtips", "requestInputtips");
            if (th instanceof AMapException) {
                throw th;
            }
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final InputtipsQuery getQuery() {
        return this.f8287d;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2) throws AMapException {
        requestInputtips(str, str2, null);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener) {
        this.f8285b = inputtipsListener;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setQuery(InputtipsQuery inputtipsQuery) {
        this.f8287d = inputtipsQuery;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (str != null && !str.equals("")) {
            InputtipsQuery inputtipsQuery = new InputtipsQuery(str, str2);
            this.f8287d = inputtipsQuery;
            inputtipsQuery.setType(str3);
            requestInputtipsAsyn();
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtipsAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            j4.i(th, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    public o0(Context context, InputtipsQuery inputtipsQuery) {
        this.f8284a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f8287d = inputtipsQuery;
        this.f8286c = u4.a();
    }
}
