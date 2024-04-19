package b.a.a.w;

import b.a.a.t;
import b.a.a.u;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* compiled from: Excluder.java */
/* loaded from: classes.dex */
public final class d implements u, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final d f70a = new d();
    private boolean e;

    /* renamed from: b  reason: collision with root package name */
    private double f71b = -1.0d;
    private int c = 136;
    private boolean d = true;
    private List<b.a.a.a> f = Collections.emptyList();
    private List<b.a.a.a> g = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Excluder.java */
    /* loaded from: classes.dex */
    class a<T> extends t<T> {

        /* renamed from: a  reason: collision with root package name */
        private t<T> f72a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f73b;
        final /* synthetic */ boolean c;
        final /* synthetic */ b.a.a.e d;
        final /* synthetic */ b.a.a.x.a e;

        a(boolean z, boolean z2, b.a.a.e eVar, b.a.a.x.a aVar) {
            this.f73b = z;
            this.c = z2;
            this.d = eVar;
            this.e = aVar;
        }

        private t<T> e() {
            t<T> tVar = this.f72a;
            if (tVar != null) {
                return tVar;
            }
            t<T> m = this.d.m(d.this, this.e);
            this.f72a = m;
            return m;
        }

        @Override // b.a.a.t
        public T b(JsonReader jsonReader) {
            if (this.f73b) {
                jsonReader.skipValue();
                return null;
            }
            return e().b(jsonReader);
        }

        @Override // b.a.a.t
        public void d(JsonWriter jsonWriter, T t) {
            if (this.c) {
                jsonWriter.nullValue();
            } else {
                e().d(jsonWriter, t);
            }
        }
    }

    private boolean e(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean f(Class<?> cls) {
        return cls.isMemberClass() && !g(cls);
    }

    private boolean g(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean h(b.a.a.v.d dVar) {
        return dVar == null || dVar.value() <= this.f71b;
    }

    private boolean i(b.a.a.v.e eVar) {
        return eVar == null || eVar.value() > this.f71b;
    }

    private boolean j(b.a.a.v.d dVar, b.a.a.v.e eVar) {
        return h(dVar) && i(eVar);
    }

    @Override // b.a.a.u
    public <T> t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
        Class<? super T> c = aVar.c();
        boolean c2 = c(c, true);
        boolean c3 = c(c, false);
        if (c2 || c3) {
            return new a(c3, c2, eVar, aVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean c(Class<?> cls, boolean z) {
        if (this.f71b == -1.0d || j((b.a.a.v.d) cls.getAnnotation(b.a.a.v.d.class), (b.a.a.v.e) cls.getAnnotation(b.a.a.v.e.class))) {
            if ((this.d || !f(cls)) && !e(cls)) {
                for (b.a.a.a aVar : z ? this.f : this.g) {
                    if (aVar.a(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean d(Field field, boolean z) {
        b.a.a.v.a aVar;
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f71b == -1.0d || j((b.a.a.v.d) field.getAnnotation(b.a.a.v.d.class), (b.a.a.v.e) field.getAnnotation(b.a.a.v.e.class))) && !field.isSynthetic()) {
            if (!this.e || ((aVar = (b.a.a.v.a) field.getAnnotation(b.a.a.v.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.d || !f(field.getType())) && !e(field.getType())) {
                    List<b.a.a.a> list = z ? this.f : this.g;
                    if (list.isEmpty()) {
                        return false;
                    }
                    b.a.a.b bVar = new b.a.a.b(field);
                    for (b.a.a.a aVar2 : list) {
                        if (aVar2.b(bVar)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }
}
