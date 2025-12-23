package com.bytedance.msdk.up.j;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.utils.vl;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae {
    private static final Object cw = new Object();

    /* renamed from: j, reason: collision with root package name */
    private j f25249j;
    private Context xt;

    public class j {
        private SQLiteDatabase xt = null;

        public j() {
        }

        private boolean cw() {
            SQLiteDatabase sQLiteDatabase = this.xt;
            return sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction();
        }

        private void xt() {
            try {
                synchronized (ae.cw) {
                    try {
                        SQLiteDatabase sQLiteDatabase = this.xt;
                        if (sQLiteDatabase != null) {
                            if (!sQLiteDatabase.isOpen()) {
                            }
                        }
                        SQLiteDatabase writableDatabase = new tl(ae.this.getContext(), "tt_mediation_open_sdk.db", 4).getWritableDatabase();
                        this.xt = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    } finally {
                    }
                }
            } catch (Throwable th) {
                vl.j(th);
                cw();
            }
        }

        public SQLiteDatabase j() {
            xt();
            return this.xt;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context = this.xt;
        return context == null ? com.bytedance.msdk.core.xt.getContext() : context;
    }

    public j j() {
        return this.f25249j;
    }

    ae(Context context) {
        Context origApplicationContext;
        try {
            if (context == null) {
                origApplicationContext = com.bytedance.msdk.core.xt.getContext();
            } else {
                origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            this.xt = origApplicationContext;
            if (this.f25249j == null) {
                this.f25249j = new j();
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }
}
