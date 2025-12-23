package com.bxkj.student.v2.ui.sports.v3.dxyy.ar;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.student.R;
import com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar.GLView;
import com.stub.StubApp;
import kotlin.jvm.internal.v;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ARActivity extends FragmentActivity {

    @NotNull
    public static final a N;

    @NotNull
    private static final String O;

    @Nullable
    private GLView M;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(-1);
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    static {
        StubApp.interface11(17532);
        N = new a(null);
        O = "uD7vNrwt9yqkS9CKYJsyTLzEBM9yyieJas3HTYgM2R28HN8AiBHITcddyByTHswfvU6KXNMc0wLfU54CnAzICo802Ra0G55VzFOeA5Qc2QGOGs9NxyTHTZ8K0guRGvULjl2GNKBTnhmcDdUOkwvPTcckngySEtEakxbIFt8ikE2NE90bmxDOAo5dhjTfCNUBmRDLHN9TngKcHJ4y0V3RAJkK0AqOXYY03wzZAY4akiaQHtsKqQ3dDJYW0gjfU54cmBHPCtM80ACIG+4KnhDbAZQL1QCTXZBNjhrSHJhR7gqeEM4LlBHbTdFdzwqTDNlBsh3WCp4L6B2cHNcGkxieQ98M2QGOGpI8iA3aDp4a6B2cHNcGkxieQ98M2QGOGpI8jR7OHJgszA6JFt0DsB7MTdFdzwqTDNlBsBDIBpIR6B2cHNcGkxieQ98M2QGOGpIrmBHPCq4P3RuUHtAinA+eQ98M2QGOGpIsvDvoHZwc1waTGJ4y0V3ZF40WzgqpFtEKrgvdAo1dhgGIE9BD3xbPI5Ic3QPfRdoOkQzZEtEEng2IEdgDmDbYHN9F502eENFBnwfXBdMMyBqZGtIb3yKQTYsezgacEcgc30XnTZ4Q0QKIEdUbhF3hQ98P0A6JGdMdkAyeVaZd3QGZDdMGmV3hQ98S0wuIE9kc30XnTY4a0hyYUfUCnBjZO48e3wSUEdtN0V3PCpMM2UG+E9MamS3ZDJIY0gaJFtMB31OeHJgRzwrTLdkMkg3YBpMYnkPfDNkBjhqSIJ8V2QyJK84OnhTVAZpdkE2OGtIcmFHvGo8Z3QyYK84OnhTVAZpdkE2OGtIcmFHvH5wNzwquD90blB7QIpwPnkPfDNkBjhqSIpIL1QCTK84OnhTVAZpdkE2OGtIcmFH4CpMM2TyNHsgGnBPxDo1dkE2OGtIcmFH/Lrkrzg6eFNUBml3hQ98axB+UDdk7lBLZPIke0R/fRdIakROQTZQM8ACeHtBNxxndA44awUOGXd4akxvQCrQbz03HJJ4MkhKSDZIH1wXTDMgamRrSG98ikE2LHs4GnBHIHN9F502eENECiBHVG4Rd4UPfD9AOiRnTHZAMnlWmXdUAjl3hQ98S0wuIE9kc30XnTY4a0hyYUfUCnBjZO48e3wSUEdtN0V3PCpMM2UG+E9MamS3ZDJIY0gaJFtMB31OeHJgRzwrTLdkMkg3YBpMYnkPfDNkBjhqSIJ8V2QyJK84OnhTVAZpdkE2OGtIcmFHvGo8Z3QyYK84OnhTVAZpdkE2OGtIcmFHvH5wNzwquD90blB7QIpwPnkPfDNkBjhqSIpIL1QCTK84OnhTVAZpdkE2OGtIcmFH4CpMM2TyNHsgGnBPxDo1dkE2OGtIcmFH/Lrkrzg6eFNUBml3hQ98axB+UDdk7lBLZPIke0R/fRdIakROQTZQM8ACeHtBNxxndA44awTKAM5il3RnAwbuRqFoAO4smo6vu4zvvbHq9X0nqmzTysQ1Bt0i8rCUNhzqS1glH/rJ32ov7fit60pH3SCRDJwBndJAyZz9xXB7NogNmtIrmKbRyE6N67UrtqJKsIJrePiecA0c3eKwJeRiE6vUXno2p5tOD0HJsbqdee9g4eMJ4bxPwPkc2U2RVuoCkjbnvULszXDCznPSIRRy7+P1NYC1TOwlAQcuoY+EimZWWuqWhs+0SGhb2v3LgEnWYX90gkHAI/xQ59IUxnz4BvppKa7b8xcRy6d03OhzzDI8Q2ekXFMRiBtjs2+MUgf8te4PjTCrPCtBIRIBrPWfwhUWJ/X+8bw==";
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        GLView gLView = this.M;
        if (gLView != null) {
            gLView.onPause();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 f(ARActivity aRActivity) {
        ((ViewGroup) aRActivity.findViewById(R.id.preview)).addView(aRActivity.M, new ViewGroup.LayoutParams(-1, -1));
        return n1.f44123a;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        GLView gLView = this.M;
        if (gLView != null) {
            gLView.onResume();
        }
    }
}
