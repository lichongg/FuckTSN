package k0;

import com.google.common.base.Splitter;
import com.google.mlkit.vision.common.PointF3D;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class i {

    /* renamed from: d, reason: collision with root package name */
    private static final String f43540d = "PoseSample";

    /* renamed from: e, reason: collision with root package name */
    private static final int f43541e = 33;

    /* renamed from: f, reason: collision with root package name */
    private static final int f43542f = 3;

    /* renamed from: a, reason: collision with root package name */
    private final String f43543a;

    /* renamed from: b, reason: collision with root package name */
    private final String f43544b;

    /* renamed from: c, reason: collision with root package name */
    private final List<PointF3D> f43545c;

    public String a() {
        return this.f43544b;
    }

    public List<PointF3D> b() {
        return this.f43545c;
    }

    public String c() {
        return this.f43543a;
    }

    public i(String name, String className, List<PointF3D> landmarks) {
        this.f43543a = name;
        this.f43544b = className;
        this.f43545c = h.b(landmarks);
    }

    public static i d(String csvLine, String separator) {
        List<String> splitToList = Splitter.onPattern(separator).splitToList(csvLine);
        if (splitToList.size() != 101) {
            return null;
        }
        String str = splitToList.get(0);
        String str2 = splitToList.get(1);
        ArrayList arrayList = new ArrayList();
        for (int i6 = 2; i6 < splitToList.size(); i6 += 3) {
            try {
                arrayList.add(PointF3D.from(Float.parseFloat(splitToList.get(i6)), Float.parseFloat(splitToList.get(i6 + 1)), Float.parseFloat(splitToList.get(i6 + 2))));
            } catch (NullPointerException | NumberFormatException unused) {
                splitToList.get(i6);
                return null;
            }
        }
        return new i(str, str2, arrayList);
    }
}
