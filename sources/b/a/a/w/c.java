package b.a.a.w;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Type, b.a.a.f<?>> f50a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class a<T> implements b.a.a.w.h<T> {
        a() {
        }

        @Override // b.a.a.w.h
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class b<T> implements b.a.a.w.h<T> {
        b() {
        }

        @Override // b.a.a.w.h
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: b.a.a.w.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0008c<T> implements b.a.a.w.h<T> {
        C0008c() {
        }

        @Override // b.a.a.w.h
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class d<T> implements b.a.a.w.h<T> {
        d() {
        }

        @Override // b.a.a.w.h
        public T a() {
            return (T) new b.a.a.w.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class e<T> implements b.a.a.w.h<T> {

        /* renamed from: a  reason: collision with root package name */
        private final b.a.a.w.k f55a = b.a.a.w.k.b();

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f56b;
        final /* synthetic */ Type c;

        e(Class cls, Type type) {
            this.f56b = cls;
            this.c = type;
        }

        @Override // b.a.a.w.h
        public T a() {
            try {
                return (T) this.f55a.c(this.f56b);
            } catch (Exception e) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.c + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    class f<T> implements b.a.a.w.h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a.a.f f57a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f58b;

        f(b.a.a.f fVar, Type type) {
            this.f57a = fVar;
            this.f58b = type;
        }

        @Override // b.a.a.w.h
        public T a() {
            return (T) this.f57a.a(this.f58b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    class g<T> implements b.a.a.w.h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b.a.a.f f59a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f60b;

        g(b.a.a.f fVar, Type type) {
            this.f59a = fVar;
            this.f60b = type;
        }

        @Override // b.a.a.w.h
        public T a() {
            return (T) this.f59a.a(this.f60b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class h<T> implements b.a.a.w.h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Constructor f61a;

        h(Constructor constructor) {
            this.f61a = constructor;
        }

        @Override // b.a.a.w.h
        public T a() {
            try {
                return (T) this.f61a.newInstance(null);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke " + this.f61a + " with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke " + this.f61a + " with no args", e3.getTargetException());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class i<T> implements b.a.a.w.h<T> {
        i() {
        }

        @Override // b.a.a.w.h
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class j<T> implements b.a.a.w.h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f64a;

        j(Type type) {
            this.f64a = type;
        }

        @Override // b.a.a.w.h
        public T a() {
            Type type = this.f64a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return (T) EnumSet.noneOf((Class) type2);
                }
                throw new b.a.a.k("Invalid EnumSet type: " + this.f64a.toString());
            }
            throw new b.a.a.k("Invalid EnumSet type: " + this.f64a.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class k<T> implements b.a.a.w.h<T> {
        k() {
        }

        @Override // b.a.a.w.h
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class l<T> implements b.a.a.w.h<T> {
        l() {
        }

        @Override // b.a.a.w.h
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class m<T> implements b.a.a.w.h<T> {
        m() {
        }

        @Override // b.a.a.w.h
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class n<T> implements b.a.a.w.h<T> {
        n() {
        }

        @Override // b.a.a.w.h
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    public c(Map<Type, b.a.a.f<?>> map) {
        this.f50a = map;
    }

    private <T> b.a.a.w.h<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new h(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> b.a.a.w.h<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i();
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new j(type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new k();
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new l();
            }
            return new m();
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new n();
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new b();
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(b.a.a.x.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) {
                return new C0008c();
            }
            return new d();
        } else {
            return null;
        }
    }

    private <T> b.a.a.w.h<T> d(Type type, Class<? super T> cls) {
        return new e(cls, type);
    }

    public <T> b.a.a.w.h<T> a(b.a.a.x.a<T> aVar) {
        Type e2 = aVar.e();
        Class<? super T> c = aVar.c();
        b.a.a.f<?> fVar = this.f50a.get(e2);
        if (fVar != null) {
            return new f(fVar, e2);
        }
        b.a.a.f<?> fVar2 = this.f50a.get(c);
        if (fVar2 != null) {
            return new g(fVar2, e2);
        }
        b.a.a.w.h<T> b2 = b(c);
        if (b2 != null) {
            return b2;
        }
        b.a.a.w.h<T> c2 = c(e2, c);
        return c2 != null ? c2 : d(e2, c);
    }

    public String toString() {
        return this.f50a.toString();
    }
}
