package com.jg.ids.c;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.jg.ids.g;
import java.util.Objects;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class a extends g {

    /* renamed from: b, reason: collision with root package name */
    private KeyguardManager f35515b;

    public a(Context context) {
        super(context);
        if (this.f35525a != null) {
            this.f35515b = (KeyguardManager) this.f35525a.getSystemService("keyguard");
            if (d()) {
                try {
                    Object invoke = this.f35515b.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f35515b, new Object[0]);
                    if (invoke != null) {
                        c(invoke.toString());
                    }
                } catch (Exception e6) {
                }
            }
        }
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        return new Intent();
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        if (this.f35525a != null && this.f35515b != null) {
            try {
                return ((Boolean) Objects.requireNonNull(this.f35515b.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f35515b, new Object[0]))).booleanValue();
            } catch (Exception e6) {
                return false;
            }
        }
        return false;
    }
}
