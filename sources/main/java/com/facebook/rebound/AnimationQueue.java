package com.facebook.rebound;

import com.facebook.rebound.ChoreographerCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class AnimationQueue {

    /* renamed from: g, reason: collision with root package name */
    private boolean f32444g;

    /* renamed from: b, reason: collision with root package name */
    private final Queue<Double> f32439b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private final Queue<Double> f32440c = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    private final List<Callback> f32441d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<Double> f32442e = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    private final ChoreographerCompat f32438a = ChoreographerCompat.e();

    /* renamed from: f, reason: collision with root package name */
    private final ChoreographerCompat.FrameCallback f32443f = new ChoreographerCompat.FrameCallback() { // from class: com.facebook.rebound.AnimationQueue.1
        @Override // com.facebook.rebound.ChoreographerCompat.FrameCallback
        public void a(long j6) {
            AnimationQueue.this.g(j6);
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Callback {
        void a(Double d6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j6) {
        int max;
        Double poll = this.f32439b.poll();
        if (poll != null) {
            this.f32440c.offer(poll);
            max = 0;
        } else {
            max = Math.max(this.f32441d.size() - this.f32440c.size(), 0);
        }
        this.f32442e.addAll(this.f32440c);
        int size = this.f32442e.size();
        while (true) {
            size--;
            if (size <= -1) {
                break;
            }
            Double d6 = this.f32442e.get(size);
            int size2 = ((this.f32442e.size() - 1) - size) + max;
            if (this.f32441d.size() > size2) {
                this.f32441d.get(size2).a(d6);
            }
        }
        this.f32442e.clear();
        while (this.f32440c.size() + max >= this.f32441d.size()) {
            this.f32440c.poll();
        }
        if (this.f32440c.isEmpty() && this.f32439b.isEmpty()) {
            this.f32444g = false;
        } else {
            this.f32438a.f(this.f32443f);
        }
    }

    private void i() {
        if (this.f32444g) {
            return;
        }
        this.f32444g = true;
        this.f32438a.f(this.f32443f);
    }

    public void b(Collection<Double> collection) {
        this.f32439b.addAll(collection);
        i();
    }

    public void c(Callback callback) {
        this.f32441d.add(callback);
    }

    public void d(Double d6) {
        this.f32439b.add(d6);
        i();
    }

    public void e() {
        this.f32441d.clear();
    }

    public void f() {
        this.f32439b.clear();
    }

    public void h(Callback callback) {
        this.f32441d.remove(callback);
    }
}
