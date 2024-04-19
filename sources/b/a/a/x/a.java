package b.a.a.x;

import b.a.a.w.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* compiled from: TypeToken.java */
/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final Class<? super T> f145a;

    /* renamed from: b  reason: collision with root package name */
    final Type f146b;
    final int c;

    protected a() {
        Type d = d(a.class);
        this.f146b = d;
        this.f145a = (Class<? super T>) b.k(d);
        this.c = d.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> b(Type type) {
        return new a<>(type);
    }

    static Type d(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return b.b(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> c() {
        return this.f145a;
    }

    public final Type e() {
        return this.f146b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.f(this.f146b, ((a) obj).f146b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return b.t(this.f146b);
    }

    a(Type type) {
        Type b2 = b.b((Type) b.a.a.w.a.b(type));
        this.f146b = b2;
        this.f145a = (Class<? super T>) b.k(b2);
        this.c = b2.hashCode();
    }
}
