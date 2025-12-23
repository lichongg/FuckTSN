package kotlin.io.path;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h0 implements kotlin.sequences.m<Path> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Path f43892a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final PathWalkOption[] f43893b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded"}, nl = {193, 199}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,180:1\n44#2,19:181\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n*L\n101#1:181,19\n*E\n"})
    static final class a extends RestrictedSuspendLambda implements Function2<kotlin.sequences.o<? super Path>, kotlin.coroutines.e<? super kotlin.n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f43894a;

        /* renamed from: b, reason: collision with root package name */
        Object f43895b;

        /* renamed from: c, reason: collision with root package name */
        Object f43896c;

        /* renamed from: d, reason: collision with root package name */
        Object f43897d;

        /* renamed from: e, reason: collision with root package name */
        Object f43898e;

        /* renamed from: f, reason: collision with root package name */
        Object f43899f;

        /* renamed from: g, reason: collision with root package name */
        Object f43900g;

        /* renamed from: h, reason: collision with root package name */
        Object f43901h;

        /* renamed from: i, reason: collision with root package name */
        int f43902i;

        /* renamed from: j, reason: collision with root package name */
        int f43903j;

        /* renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f43904k;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<kotlin.n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            a aVar = h0.this.new a(eVar);
            aVar.f43904k = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlin.sequences.o<? super Path> oVar, kotlin.coroutines.e<? super kotlin.n1> eVar) {
            return ((a) create(oVar, eVar)).invokeSuspend(kotlin.n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x0099, code lost:
        
            r2 = r8;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0121  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x009f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 389
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.h0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 210, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "node$iv", "entriesReader$iv", "path$iv", "$i$f$yieldIfNeeded"}, nl = {193, 199, 212, 218}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,180:1\n44#2,19:181\n44#2,19:200\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n*L\n70#1:181,19\n81#1:200,19\n*E\n"})
    static final class b extends RestrictedSuspendLambda implements Function2<kotlin.sequences.o<? super Path>, kotlin.coroutines.e<? super kotlin.n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f43906a;

        /* renamed from: b, reason: collision with root package name */
        Object f43907b;

        /* renamed from: c, reason: collision with root package name */
        Object f43908c;

        /* renamed from: d, reason: collision with root package name */
        Object f43909d;

        /* renamed from: e, reason: collision with root package name */
        Object f43910e;

        /* renamed from: f, reason: collision with root package name */
        Object f43911f;

        /* renamed from: g, reason: collision with root package name */
        Object f43912g;

        /* renamed from: h, reason: collision with root package name */
        Object f43913h;

        /* renamed from: i, reason: collision with root package name */
        Object f43914i;

        /* renamed from: j, reason: collision with root package name */
        Object f43915j;

        /* renamed from: k, reason: collision with root package name */
        Object f43916k;

        /* renamed from: l, reason: collision with root package name */
        int f43917l;

        /* renamed from: m, reason: collision with root package name */
        int f43918m;

        /* renamed from: n, reason: collision with root package name */
        private /* synthetic */ Object f43919n;

        b(kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<kotlin.n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            b bVar = h0.this.new b(eVar);
            bVar.f43919n = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlin.sequences.o<? super Path> oVar, kotlin.coroutines.e<? super kotlin.n1> eVar) {
            return ((b) create(oVar, eVar)).invokeSuspend(kotlin.n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x01de, code lost:
        
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x01d8, code lost:
        
            if (r1.c(r12, r17) == r2) goto L72;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x01e4  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x028e  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0175  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 784
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.h0.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public h0(@NotNull Path start, @NotNull PathWalkOption[] options) {
        kotlin.jvm.internal.g0.p(start, "start");
        kotlin.jvm.internal.g0.p(options, "options");
        this.f43892a = start;
        this.f43893b = options;
    }

    private final Iterator<Path> g() {
        return kotlin.sequences.p.a(new a(null));
    }

    private final Iterator<Path> h() {
        return kotlin.sequences.p.a(new b(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i() {
        return kotlin.collections.n.B8(this.f43893b, PathWalkOption.FOLLOW_LINKS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        return kotlin.collections.n.B8(this.f43893b, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinkOption[] k() {
        return w.f43945a.a(i());
    }

    private final boolean l() {
        return kotlin.collections.n.B8(this.f43893b, PathWalkOption.BREADTH_FIRST);
    }

    private final Object m(kotlin.sequences.o<? super Path> oVar, x xVar, i iVar, Function1<? super List<x>, kotlin.n1> function1, kotlin.coroutines.e<? super kotlin.n1> eVar) {
        boolean isDirectory;
        LinkOption linkOption;
        boolean exists;
        boolean c6;
        boolean isDirectory2;
        Path d6 = xVar.d();
        if (xVar.c() != null) {
            y1.O(d6);
        }
        LinkOption[] k6 = k();
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(k6, k6.length);
        isDirectory = Files.isDirectory(d6, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (!isDirectory) {
            linkOption = LinkOption.NOFOLLOW_LINKS;
            exists = Files.exists(d6, (LinkOption[]) Arrays.copyOf(new LinkOption[]{linkOption}, 1));
            if (exists) {
                kotlin.jvm.internal.d0.e(0);
                oVar.c(d6, eVar);
                kotlin.jvm.internal.d0.e(1);
                return kotlin.n1.f44123a;
            }
        } else {
            c6 = j0.c(xVar);
            if (!c6) {
                if (j()) {
                    kotlin.jvm.internal.d0.e(0);
                    oVar.c(d6, eVar);
                    kotlin.jvm.internal.d0.e(1);
                }
                LinkOption[] k7 = k();
                LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(k7, k7.length);
                isDirectory2 = Files.isDirectory(d6, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length));
                if (isDirectory2) {
                    function1.invoke(iVar.c(xVar));
                }
            } else {
                g0.a();
                throw f0.a(d6.toString());
            }
        }
        return kotlin.n1.f44123a;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<Path> iterator() {
        if (l()) {
            return g();
        }
        return h();
    }
}
