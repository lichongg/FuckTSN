package com.umeng.socialize.shareboard.widgets;

import android.annotation.TargetApi;
import android.view.KeyEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class KeyEventCompat {
    private static final KeyEventVersionImpl IMPL = new HoneycombKeyEventVersionImpl(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.socialize.shareboard.widgets.KeyEventCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        private static final int META_ALL_MASK = 247;
        private static final int META_MODIFIER_MASK = 247;

        private BaseKeyEventVersionImpl() {
        }

        /* synthetic */ BaseKeyEventVersionImpl(AnonymousClass1 anonymousClass1) {
            this();
        }

        private static int metaStateFilterDirectionalModifiers(int i6, int i7, int i8, int i9, int i10) {
            int i11;
            boolean z5 = (i7 & i8) != 0;
            int i12 = i9 | i10;
            boolean z6 = (i7 & i12) != 0;
            if (z5) {
                if (z6) {
                    throw new IllegalArgumentException("bad arguments");
                }
                i11 = ~i12;
            } else {
                if (!z6) {
                    return i6;
                }
                i11 = ~i8;
            }
            return i6 & i11;
        }

        private int normalizeMetaState(int i6) {
            if ((i6 & 192) != 0) {
                i6 |= 1;
            }
            if ((i6 & 48) != 0) {
                i6 |= 2;
            }
            return i6 & 247;
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasModifiers(int i6, int i7) {
            if (metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(normalizeMetaState(i6) & 247, i7, 1, 64, 128), i7, 2, 16, 32) == i7) {
                return true;
            }
            return false;
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasNoModifiers(int i6) {
            if ((normalizeMetaState(i6) & 247) == 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @TargetApi(11)
    private static class HoneycombKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        private HoneycombKeyEventVersionImpl() {
            super(null);
        }

        /* synthetic */ HoneycombKeyEventVersionImpl(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.BaseKeyEventVersionImpl, com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasModifiers(int i6, int i7) {
            return KeyEvent.metaStateHasModifiers(i6, i7);
        }

        @Override // com.umeng.socialize.shareboard.widgets.KeyEventCompat.BaseKeyEventVersionImpl, com.umeng.socialize.shareboard.widgets.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasNoModifiers(int i6) {
            return KeyEvent.metaStateHasNoModifiers(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface KeyEventVersionImpl {
        boolean metaStateHasModifiers(int i6, int i7);

        boolean metaStateHasNoModifiers(int i6);
    }

    public static boolean hasModifiers(KeyEvent keyEvent, int i6) {
        return IMPL.metaStateHasModifiers(keyEvent.getMetaState(), i6);
    }

    public static boolean hasNoModifiers(KeyEvent keyEvent) {
        return IMPL.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    KeyEventCompat() {
    }
}
