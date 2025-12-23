package com.jg.ids.meizu;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class c extends com.jg.ids.a implements b {
    public c(Context context) {
        super(context, "meizu_thread");
        a.a().a(this);
    }

    @Override // com.jg.ids.a
    protected final void a(Message message) {
        if (message != null) {
            try {
                int i6 = message.getData().getInt("type", -1);
                String str = "";
                switch (i6) {
                    case 0:
                        str = a.a().c(this.f35525a);
                        break;
                    case 1:
                        str = a.a().d(this.f35525a);
                        break;
                    case 2:
                        str = a.a().b(this.f35525a);
                        break;
                }
                a(i6, str);
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.jg.ids.a
    protected final void b() {
        b(2);
        b(0);
        b(1);
    }

    private void b(int i6) {
        try {
            Message a6 = a();
            a6.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i6);
            a6.setData(bundle);
            b(a6);
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        return a.a().a(this.f35525a);
    }

    @Override // com.jg.ids.meizu.b
    public final void a(int i6) {
        switch (i6) {
            case 0:
                b(0);
                break;
            case 1:
                b(1);
                break;
            case 2:
                b(2);
                break;
        }
    }
}
