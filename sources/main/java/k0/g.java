package k0;

import android.content.Context;
import android.media.ToneGenerator;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.google.android.material.timepicker.TimeModel;
import com.google.common.base.Preconditions;
import com.google.mlkit.vision.pose.Pose;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class g {

    /* renamed from: h, reason: collision with root package name */
    private static final String f43531h = "PoseClassifierProcessor";

    /* renamed from: a, reason: collision with root package name */
    private final String f43532a;

    /* renamed from: b, reason: collision with root package name */
    private final String[] f43533b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f43534c;

    /* renamed from: d, reason: collision with root package name */
    private c f43535d;

    /* renamed from: e, reason: collision with root package name */
    private List<j> f43536e;

    /* renamed from: f, reason: collision with root package name */
    private f f43537f;

    /* renamed from: g, reason: collision with root package name */
    private String f43538g;

    private void b(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(this.f43532a)));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                i d6 = i.d(readLine, ",");
                if (d6 != null) {
                    arrayList.add(d6);
                }
            }
        } catch (IOException e6) {
            e6.toString();
        }
        this.f43537f = new f(arrayList);
        if (this.f43534c) {
            for (String str : this.f43533b) {
                this.f43536e.add(new j(str));
            }
        }
    }

    @WorkerThread
    public g(Context context, boolean isStreamMode, String poseSamplesFile, String[] poseClasses) {
        boolean z5;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        this.f43534c = isStreamMode;
        if (isStreamMode) {
            this.f43535d = new c();
            this.f43536e = new ArrayList();
            this.f43538g = "";
        }
        this.f43532a = poseSamplesFile;
        this.f43533b = poseClasses;
        b(context);
    }

    @WorkerThread
    public List<String> a(Pose pose) {
        boolean z5;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        ArrayList arrayList = new ArrayList();
        b c6 = this.f43537f.c(pose);
        if (this.f43534c) {
            b a6 = this.f43535d.a(c6);
            if (pose.getAllPoseLandmarks().isEmpty()) {
                arrayList.add(this.f43538g);
                return arrayList;
            }
            Iterator<j> it = this.f43536e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j next = it.next();
                int c7 = next.c();
                int a7 = next.a(a6);
                if (a7 > c7) {
                    new ToneGenerator(5, 100).startTone(24);
                    this.f43538g = String.format(Locale.US, TimeModel.NUMBER_FORMAT, Integer.valueOf(a7));
                    break;
                }
            }
            arrayList.add(this.f43538g);
            return arrayList;
        }
        if (!pose.getAllPoseLandmarks().isEmpty()) {
            String d6 = c6.d();
            arrayList.add(d6);
            arrayList.add(Math.round((c6.c(d6) / this.f43537f.e()) * 100.0f) + "");
        }
        return arrayList;
    }
}
