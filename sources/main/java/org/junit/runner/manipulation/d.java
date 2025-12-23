package org.junit.runner.manipulation;

import java.util.Comparator;
import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d implements Comparator<Description> {

    /* renamed from: b, reason: collision with root package name */
    public static final d f51511b = new d(new a());

    /* renamed from: a, reason: collision with root package name */
    private final Comparator<Description> f51512a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Comparator<Description> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Description description, Description description2) {
            return 0;
        }

        a() {
        }
    }

    public void a(Object obj) {
        if (obj instanceof c) {
            ((c) obj).d(this);
        }
    }

    @Override // java.util.Comparator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compare(Description description, Description description2) {
        return this.f51512a.compare(description, description2);
    }

    public d(Comparator<Description> comparator) {
        this.f51512a = comparator;
    }
}
