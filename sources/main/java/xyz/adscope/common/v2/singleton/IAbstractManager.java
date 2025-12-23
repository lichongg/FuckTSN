package xyz.adscope.common.v2.singleton;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class IAbstractManager<T> implements IBaseManagerSingleton<T> {
    private volatile T impl;

    protected abstract T createNewImpl(Context context);

    @Override // xyz.adscope.common.v2.singleton.IBaseManagerSingleton
    public T getOrCreateImplement(Context context) {
        if (this.impl == null) {
            synchronized (this) {
                try {
                    if (this.impl == null) {
                        this.impl = createNewImpl(context);
                    }
                } finally {
                }
            }
        }
        return this.impl;
    }
}
