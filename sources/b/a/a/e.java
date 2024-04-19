package b.a.a;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* compiled from: Gson.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final b.a.a.x.a<?> f29a = b.a.a.x.a.a(Object.class);

    /* renamed from: b  reason: collision with root package name */
    private final ThreadLocal<Map<b.a.a.x.a<?>, f<?>>> f30b;
    private final Map<b.a.a.x.a<?>, t<?>> c;
    private final List<u> d;
    private final b.a.a.w.c e;
    private final b.a.a.w.d f;
    private final b.a.a.d g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final b.a.a.w.l.d m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public class a extends t<Number> {
        a() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Double b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Double.valueOf(jsonReader.nextDouble());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            e.d(number.doubleValue());
            jsonWriter.value(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public class b extends t<Number> {
        b() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Float b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Float.valueOf((float) jsonReader.nextDouble());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            e.d(number.floatValue());
            jsonWriter.value(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public static class c extends t<Number> {
        c() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Long.valueOf(jsonReader.nextLong());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public static class d extends t<AtomicLong> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f33a;

        d(t tVar) {
            this.f33a = tVar;
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public AtomicLong b(JsonReader jsonReader) {
            return new AtomicLong(((Number) this.f33a.b(jsonReader)).longValue());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicLong atomicLong) {
            this.f33a.d(jsonWriter, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* renamed from: b.a.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0006e extends t<AtomicLongArray> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f34a;

        C0006e(t tVar) {
            this.f34a = tVar;
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public AtomicLongArray b(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(Long.valueOf(((Number) this.f34a.b(jsonReader)).longValue()));
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i = 0; i < size; i++) {
                atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
            }
            return atomicLongArray;
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) {
            jsonWriter.beginArray();
            int length = atomicLongArray.length();
            for (int i = 0; i < length; i++) {
                this.f34a.d(jsonWriter, Long.valueOf(atomicLongArray.get(i)));
            }
            jsonWriter.endArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public static class f<T> extends t<T> {

        /* renamed from: a  reason: collision with root package name */
        private t<T> f35a;

        f() {
        }

        @Override // b.a.a.t
        public T b(JsonReader jsonReader) {
            t<T> tVar = this.f35a;
            if (tVar != null) {
                return tVar.b(jsonReader);
            }
            throw new IllegalStateException();
        }

        @Override // b.a.a.t
        public void d(JsonWriter jsonWriter, T t) {
            t<T> tVar = this.f35a;
            if (tVar != null) {
                tVar.d(jsonWriter, t);
                return;
            }
            throw new IllegalStateException();
        }

        public void e(t<T> tVar) {
            if (this.f35a == null) {
                this.f35a = tVar;
                return;
            }
            throw new AssertionError();
        }
    }

    public e() {
        this(b.a.a.w.d.f70a, b.a.a.c.f27a, Collections.emptyMap(), false, false, false, true, false, false, false, s.f41a, Collections.emptyList());
    }

    private static void a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() == JsonToken.END_DOCUMENT) {
                    return;
                }
                throw new k("JSON document was not fully consumed.");
            } catch (MalformedJsonException e) {
                throw new r(e);
            } catch (IOException e2) {
                throw new k(e2);
            }
        }
    }

    private static t<AtomicLong> b(t<Number> tVar) {
        return new d(tVar).a();
    }

    private static t<AtomicLongArray> c(t<Number> tVar) {
        return new C0006e(tVar).a();
    }

    static void d(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private t<Number> e(boolean z) {
        if (z) {
            return b.a.a.w.l.n.v;
        }
        return new a();
    }

    private t<Number> f(boolean z) {
        if (z) {
            return b.a.a.w.l.n.u;
        }
        return new b();
    }

    private static t<Number> n(s sVar) {
        if (sVar == s.f41a) {
            return b.a.a.w.l.n.t;
        }
        return new c();
    }

    public <T> T g(JsonReader jsonReader, Type type) {
        boolean isLenient = jsonReader.isLenient();
        boolean z = true;
        jsonReader.setLenient(true);
        try {
            try {
                try {
                    jsonReader.peek();
                    z = false;
                    T b2 = k(b.a.a.x.a.b(type)).b(jsonReader);
                    jsonReader.setLenient(isLenient);
                    return b2;
                } catch (IOException e) {
                    throw new r(e);
                }
            } catch (EOFException e2) {
                if (z) {
                    jsonReader.setLenient(isLenient);
                    return null;
                }
                throw new r(e2);
            } catch (IllegalStateException e3) {
                throw new r(e3);
            }
        } catch (Throwable th) {
            jsonReader.setLenient(isLenient);
            throw th;
        }
    }

    public <T> T h(Reader reader, Type type) {
        JsonReader o = o(reader);
        T t = (T) g(o, type);
        a(t, o);
        return t;
    }

    public <T> T i(String str, Class<T> cls) {
        return (T) b.a.a.w.i.c(cls).cast(j(str, cls));
    }

    public <T> T j(String str, Type type) {
        if (str == null) {
            return null;
        }
        return (T) h(new StringReader(str), type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> t<T> k(b.a.a.x.a<T> aVar) {
        t<T> tVar = (t<T>) this.c.get(aVar == null ? f29a : aVar);
        if (tVar != null) {
            return tVar;
        }
        Map<b.a.a.x.a<?>, f<?>> map = this.f30b.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.f30b.set(map);
            z = true;
        }
        f<?> fVar = map.get(aVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            f<?> fVar2 = new f<>();
            map.put(aVar, fVar2);
            for (u uVar : this.d) {
                t tVar2 = (t<T>) uVar.a(this, aVar);
                if (tVar2 != null) {
                    fVar2.e(tVar2);
                    this.c.put(aVar, tVar2);
                    return tVar2;
                }
            }
            throw new IllegalArgumentException("GSON cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.f30b.remove();
            }
        }
    }

    public <T> t<T> l(Class<T> cls) {
        return k(b.a.a.x.a.a(cls));
    }

    public <T> t<T> m(u uVar, b.a.a.x.a<T> aVar) {
        if (!this.d.contains(uVar)) {
            uVar = this.m;
        }
        boolean z = false;
        for (u uVar2 : this.d) {
            if (z) {
                t<T> a2 = uVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (uVar2 == uVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public JsonReader o(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.l);
        return jsonReader;
    }

    public JsonWriter p(Writer writer) {
        if (this.j) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.k) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.h);
        return jsonWriter;
    }

    public String q(j jVar) {
        StringWriter stringWriter = new StringWriter();
        u(jVar, stringWriter);
        return stringWriter.toString();
    }

    public String r(Object obj) {
        if (obj == null) {
            return q(l.f37a);
        }
        return s(obj, obj.getClass());
    }

    public String s(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        w(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void t(j jVar, JsonWriter jsonWriter) {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.i);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.h);
        try {
            try {
                b.a.a.w.j.b(jVar, jsonWriter);
            } catch (IOException e) {
                throw new k(e);
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.h + ",factories:" + this.d + ",instanceCreators:" + this.e + "}";
    }

    public void u(j jVar, Appendable appendable) {
        try {
            t(jVar, p(b.a.a.w.j.c(appendable)));
        } catch (IOException e) {
            throw new k(e);
        }
    }

    public void v(Object obj, Type type, JsonWriter jsonWriter) {
        t k = k(b.a.a.x.a.b(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.i);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.h);
        try {
            try {
                k.d(jsonWriter, obj);
            } catch (IOException e) {
                throw new k(e);
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public void w(Object obj, Type type, Appendable appendable) {
        try {
            v(obj, type, p(b.a.a.w.j.c(appendable)));
        } catch (IOException e) {
            throw new k(e);
        }
    }

    e(b.a.a.w.d dVar, b.a.a.d dVar2, Map<Type, b.a.a.f<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, s sVar, List<u> list) {
        this.f30b = new ThreadLocal<>();
        this.c = new ConcurrentHashMap();
        b.a.a.w.c cVar = new b.a.a.w.c(map);
        this.e = cVar;
        this.f = dVar;
        this.g = dVar2;
        this.h = z;
        this.j = z3;
        this.i = z4;
        this.k = z5;
        this.l = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(b.a.a.w.l.n.Y);
        arrayList.add(b.a.a.w.l.h.f109a);
        arrayList.add(dVar);
        arrayList.addAll(list);
        arrayList.add(b.a.a.w.l.n.D);
        arrayList.add(b.a.a.w.l.n.m);
        arrayList.add(b.a.a.w.l.n.g);
        arrayList.add(b.a.a.w.l.n.i);
        arrayList.add(b.a.a.w.l.n.k);
        t<Number> n = n(sVar);
        arrayList.add(b.a.a.w.l.n.b(Long.TYPE, Long.class, n));
        arrayList.add(b.a.a.w.l.n.b(Double.TYPE, Double.class, e(z7)));
        arrayList.add(b.a.a.w.l.n.b(Float.TYPE, Float.class, f(z7)));
        arrayList.add(b.a.a.w.l.n.x);
        arrayList.add(b.a.a.w.l.n.o);
        arrayList.add(b.a.a.w.l.n.q);
        arrayList.add(b.a.a.w.l.n.a(AtomicLong.class, b(n)));
        arrayList.add(b.a.a.w.l.n.a(AtomicLongArray.class, c(n)));
        arrayList.add(b.a.a.w.l.n.s);
        arrayList.add(b.a.a.w.l.n.z);
        arrayList.add(b.a.a.w.l.n.F);
        arrayList.add(b.a.a.w.l.n.H);
        arrayList.add(b.a.a.w.l.n.a(BigDecimal.class, b.a.a.w.l.n.B));
        arrayList.add(b.a.a.w.l.n.a(BigInteger.class, b.a.a.w.l.n.C));
        arrayList.add(b.a.a.w.l.n.J);
        arrayList.add(b.a.a.w.l.n.L);
        arrayList.add(b.a.a.w.l.n.P);
        arrayList.add(b.a.a.w.l.n.R);
        arrayList.add(b.a.a.w.l.n.W);
        arrayList.add(b.a.a.w.l.n.N);
        arrayList.add(b.a.a.w.l.n.d);
        arrayList.add(b.a.a.w.l.c.f98a);
        arrayList.add(b.a.a.w.l.n.U);
        arrayList.add(b.a.a.w.l.k.f120a);
        arrayList.add(b.a.a.w.l.j.f118a);
        arrayList.add(b.a.a.w.l.n.S);
        arrayList.add(b.a.a.w.l.a.f93a);
        arrayList.add(b.a.a.w.l.n.f128b);
        arrayList.add(new b.a.a.w.l.b(cVar));
        arrayList.add(new b.a.a.w.l.g(cVar, z2));
        b.a.a.w.l.d dVar3 = new b.a.a.w.l.d(cVar);
        this.m = dVar3;
        arrayList.add(dVar3);
        arrayList.add(b.a.a.w.l.n.Z);
        arrayList.add(new b.a.a.w.l.i(cVar, dVar2, dVar, dVar3));
        this.d = Collections.unmodifiableList(arrayList);
    }
}
