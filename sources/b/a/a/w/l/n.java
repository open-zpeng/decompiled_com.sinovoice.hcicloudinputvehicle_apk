package b.a.a.w.l;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
/* compiled from: TypeAdapters.java */
/* loaded from: classes.dex */
public final class n {
    public static final b.a.a.t<String> A;
    public static final b.a.a.t<BigDecimal> B;
    public static final b.a.a.t<BigInteger> C;
    public static final b.a.a.u D;
    public static final b.a.a.t<StringBuilder> E;
    public static final b.a.a.u F;
    public static final b.a.a.t<StringBuffer> G;
    public static final b.a.a.u H;
    public static final b.a.a.t<URL> I;
    public static final b.a.a.u J;
    public static final b.a.a.t<URI> K;
    public static final b.a.a.u L;
    public static final b.a.a.t<InetAddress> M;
    public static final b.a.a.u N;
    public static final b.a.a.t<UUID> O;
    public static final b.a.a.u P;
    public static final b.a.a.t<Currency> Q;
    public static final b.a.a.u R;
    public static final b.a.a.u S;
    public static final b.a.a.t<Calendar> T;
    public static final b.a.a.u U;
    public static final b.a.a.t<Locale> V;
    public static final b.a.a.u W;
    public static final b.a.a.t<b.a.a.j> X;
    public static final b.a.a.u Y;
    public static final b.a.a.u Z;

    /* renamed from: a  reason: collision with root package name */
    public static final b.a.a.t<Class> f127a;

    /* renamed from: b  reason: collision with root package name */
    public static final b.a.a.u f128b;
    public static final b.a.a.t<BitSet> c;
    public static final b.a.a.u d;
    public static final b.a.a.t<Boolean> e;
    public static final b.a.a.t<Boolean> f;
    public static final b.a.a.u g;
    public static final b.a.a.t<Number> h;
    public static final b.a.a.u i;
    public static final b.a.a.t<Number> j;
    public static final b.a.a.u k;
    public static final b.a.a.t<Number> l;
    public static final b.a.a.u m;
    public static final b.a.a.t<AtomicInteger> n;
    public static final b.a.a.u o;
    public static final b.a.a.t<AtomicBoolean> p;
    public static final b.a.a.u q;
    public static final b.a.a.t<AtomicIntegerArray> r;
    public static final b.a.a.u s;
    public static final b.a.a.t<Number> t;
    public static final b.a.a.t<Number> u;
    public static final b.a.a.t<Number> v;
    public static final b.a.a.t<Number> w;
    public static final b.a.a.u x;
    public static final b.a.a.t<Character> y;
    public static final b.a.a.u z;

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class a extends b.a.a.t<AtomicIntegerArray> {
        a() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public AtomicIntegerArray b(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                } catch (NumberFormatException e) {
                    throw new b.a.a.r(e);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) {
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.value(atomicIntegerArray.get(i));
            }
            jsonWriter.endArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class a0 implements b.a.a.u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f129a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.a.a.t f130b;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        /* compiled from: TypeAdapters.java */
        /* loaded from: classes.dex */
        class a<T1> extends b.a.a.t<T1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Class f131a;

            a(Class cls) {
                this.f131a = cls;
            }

            @Override // b.a.a.t
            public T1 b(JsonReader jsonReader) {
                T1 t1 = (T1) a0.this.f130b.b(jsonReader);
                if (t1 == null || this.f131a.isInstance(t1)) {
                    return t1;
                }
                throw new b.a.a.r("Expected a " + this.f131a.getName() + " but was " + t1.getClass().getName());
            }

            @Override // b.a.a.t
            public void d(JsonWriter jsonWriter, T1 t1) {
                a0.this.f130b.d(jsonWriter, t1);
            }
        }

        a0(Class cls, b.a.a.t tVar) {
            this.f129a = cls;
            this.f130b = tVar;
        }

        @Override // b.a.a.u
        public <T2> b.a.a.t<T2> a(b.a.a.e eVar, b.a.a.x.a<T2> aVar) {
            Class<? super T2> c = aVar.c();
            if (this.f129a.isAssignableFrom(c)) {
                return new a(c);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f129a.getName() + ",adapter=" + this.f130b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class b extends b.a.a.t<Number> {
        b() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b0 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f133a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f133a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f133a[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f133a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f133a[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f133a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f133a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f133a[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f133a[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f133a[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f133a[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class c extends b.a.a.t<Number> {
        c() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Float.valueOf((float) jsonReader.nextDouble());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class c0 extends b.a.a.t<Boolean> {
        c0() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Boolean b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            } else if (jsonReader.peek() == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
            } else {
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Boolean bool) {
            jsonWriter.value(bool);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class d extends b.a.a.t<Number> {
        d() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Double.valueOf(jsonReader.nextDouble());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class d0 extends b.a.a.t<Boolean> {
        d0() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Boolean b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Boolean.valueOf(jsonReader.nextString());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Boolean bool) {
            jsonWriter.value(bool == null ? "null" : bool.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class e extends b.a.a.t<Number> {
        e() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            int i = b0.f133a[peek.ordinal()];
            if (i == 1 || i == 3) {
                return new b.a.a.w.f(jsonReader.nextString());
            }
            if (i == 4) {
                jsonReader.nextNull();
                return null;
            }
            throw new b.a.a.r("Expecting number, got: " + peek);
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class e0 extends b.a.a.t<Number> {
        e0() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class f extends b.a.a.t<Character> {
        f() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Character b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            throw new b.a.a.r("Expecting character, got: " + nextString);
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Character ch) {
            jsonWriter.value(ch == null ? null : String.valueOf(ch));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class f0 extends b.a.a.t<Number> {
        f0() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class g extends b.a.a.t<String> {
        g() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public String b(JsonReader jsonReader) {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            } else if (peek == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.nextBoolean());
            } else {
                return jsonReader.nextString();
            }
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, String str) {
            jsonWriter.value(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class g0 extends b.a.a.t<Number> {
        g0() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Number b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Number number) {
            jsonWriter.value(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class h extends b.a.a.t<BigDecimal> {
        h() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public BigDecimal b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigDecimal(jsonReader.nextString());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, BigDecimal bigDecimal) {
            jsonWriter.value(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class h0 extends b.a.a.t<AtomicInteger> {
        h0() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public AtomicInteger b(JsonReader jsonReader) {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicInteger atomicInteger) {
            jsonWriter.value(atomicInteger.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class i extends b.a.a.t<BigInteger> {
        i() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public BigInteger b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new BigInteger(jsonReader.nextString());
            } catch (NumberFormatException e) {
                throw new b.a.a.r(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, BigInteger bigInteger) {
            jsonWriter.value(bigInteger);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class i0 extends b.a.a.t<AtomicBoolean> {
        i0() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public AtomicBoolean b(JsonReader jsonReader) {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) {
            jsonWriter.value(atomicBoolean.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class j extends b.a.a.t<StringBuilder> {
        j() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public StringBuilder b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new StringBuilder(jsonReader.nextString());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, StringBuilder sb) {
            jsonWriter.value(sb == null ? null : sb.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    private static final class j0<T extends Enum<T>> extends b.a.a.t<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, T> f134a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<T, String> f135b = new HashMap();

        public j0(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    b.a.a.v.c cVar = (b.a.a.v.c) cls.getField(name).getAnnotation(b.a.a.v.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f134a.put(str, t);
                        }
                    }
                    this.f134a.put(name, t);
                    this.f135b.put(t, name);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public T b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return this.f134a.get(jsonReader.nextString());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, T t) {
            jsonWriter.value(t == null ? null : this.f135b.get(t));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class k extends b.a.a.t<Class> {
        k() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Class b(JsonReader jsonReader) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class l extends b.a.a.t<StringBuffer> {
        l() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public StringBuffer b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new StringBuffer(jsonReader.nextString());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, StringBuffer stringBuffer) {
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class m extends b.a.a.t<URL> {
        m() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public URL b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, URL url) {
            jsonWriter.value(url == null ? null : url.toExternalForm());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: b.a.a.w.l.n$n  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0011n extends b.a.a.t<URI> {
        C0011n() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public URI b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String nextString = jsonReader.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e) {
                throw new b.a.a.k(e);
            }
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, URI uri) {
            jsonWriter.value(uri == null ? null : uri.toASCIIString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class o extends b.a.a.t<InetAddress> {
        o() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public InetAddress b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return InetAddress.getByName(jsonReader.nextString());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, InetAddress inetAddress) {
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class p extends b.a.a.t<UUID> {
        p() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public UUID b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return UUID.fromString(jsonReader.nextString());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, UUID uuid) {
            jsonWriter.value(uuid == null ? null : uuid.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class q extends b.a.a.t<Currency> {
        q() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Currency b(JsonReader jsonReader) {
            return Currency.getInstance(jsonReader.nextString());
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Currency currency) {
            jsonWriter.value(currency.getCurrencyCode());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class r implements b.a.a.u {

        /* compiled from: TypeAdapters.java */
        /* loaded from: classes.dex */
        class a extends b.a.a.t<Timestamp> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b.a.a.t f136a;

            a(b.a.a.t tVar) {
                this.f136a = tVar;
            }

            @Override // b.a.a.t
            /* renamed from: e */
            public Timestamp b(JsonReader jsonReader) {
                Date date = (Date) this.f136a.b(jsonReader);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // b.a.a.t
            /* renamed from: f */
            public void d(JsonWriter jsonWriter, Timestamp timestamp) {
                this.f136a.d(jsonWriter, timestamp);
            }
        }

        r() {
        }

        @Override // b.a.a.u
        public <T> b.a.a.t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
            if (aVar.c() != Timestamp.class) {
                return null;
            }
            return new a(eVar.l(Date.class));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class s extends b.a.a.t<Calendar> {
        s() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Calendar b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                int nextInt = jsonReader.nextInt();
                if ("year".equals(nextName)) {
                    i = nextInt;
                } else if ("month".equals(nextName)) {
                    i2 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i3 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i4 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i5 = nextInt;
                } else if ("second".equals(nextName)) {
                    i6 = nextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Calendar calendar) {
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("year");
            jsonWriter.value(calendar.get(1));
            jsonWriter.name("month");
            jsonWriter.value(calendar.get(2));
            jsonWriter.name("dayOfMonth");
            jsonWriter.value(calendar.get(5));
            jsonWriter.name("hourOfDay");
            jsonWriter.value(calendar.get(11));
            jsonWriter.name("minute");
            jsonWriter.value(calendar.get(12));
            jsonWriter.name("second");
            jsonWriter.value(calendar.get(13));
            jsonWriter.endObject();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class t extends b.a.a.t<Locale> {
        t() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public Locale b(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            if (nextToken3 == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Locale locale) {
            jsonWriter.value(locale == null ? null : locale.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class u extends b.a.a.t<b.a.a.j> {
        u() {
        }

        @Override // b.a.a.t
        /* renamed from: e */
        public b.a.a.j b(JsonReader jsonReader) {
            switch (b0.f133a[jsonReader.peek().ordinal()]) {
                case 1:
                    return new b.a.a.o(new b.a.a.w.f(jsonReader.nextString()));
                case 2:
                    return new b.a.a.o(Boolean.valueOf(jsonReader.nextBoolean()));
                case 3:
                    return new b.a.a.o(jsonReader.nextString());
                case 4:
                    jsonReader.nextNull();
                    return b.a.a.l.f37a;
                case 5:
                    b.a.a.g gVar = new b.a.a.g();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        gVar.h(b(jsonReader));
                    }
                    jsonReader.endArray();
                    return gVar;
                case 6:
                    b.a.a.m mVar = new b.a.a.m();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        mVar.h(jsonReader.nextName(), b(jsonReader));
                    }
                    jsonReader.endObject();
                    return mVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, b.a.a.j jVar) {
            if (jVar != null && !jVar.e()) {
                if (jVar.g()) {
                    b.a.a.o c = jVar.c();
                    if (c.q()) {
                        jsonWriter.value(c.m());
                        return;
                    } else if (c.o()) {
                        jsonWriter.value(c.h());
                        return;
                    } else {
                        jsonWriter.value(c.n());
                        return;
                    }
                } else if (jVar.d()) {
                    jsonWriter.beginArray();
                    Iterator<b.a.a.j> it = jVar.a().iterator();
                    while (it.hasNext()) {
                        d(jsonWriter, it.next());
                    }
                    jsonWriter.endArray();
                    return;
                } else if (jVar.f()) {
                    jsonWriter.beginObject();
                    for (Map.Entry<String, b.a.a.j> entry : jVar.b().i()) {
                        jsonWriter.name(entry.getKey());
                        d(jsonWriter, entry.getValue());
                    }
                    jsonWriter.endObject();
                    return;
                } else {
                    throw new IllegalArgumentException("Couldn't write " + jVar.getClass());
                }
            }
            jsonWriter.nullValue();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class v extends b.a.a.t<BitSet> {
        v() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
            if (r8.nextInt() != 0) goto L15;
         */
        @Override // b.a.a.t
        /* renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.BitSet b(com.google.gson.stream.JsonReader r8) {
            /*
                r7 = this;
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.beginArray()
                com.google.gson.stream.JsonToken r1 = r8.peek()
                r2 = 0
                r3 = 0
            Le:
                com.google.gson.stream.JsonToken r4 = com.google.gson.stream.JsonToken.END_ARRAY
                if (r1 == r4) goto L75
                int[] r4 = b.a.a.w.l.n.b0.f133a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L63
                r6 = 2
                if (r4 == r6) goto L5e
                r6 = 3
                if (r4 != r6) goto L47
                java.lang.String r1 = r8.nextString()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L30
                if (r1 == 0) goto L2e
                goto L69
            L2e:
                r5 = 0
                goto L69
            L30:
                b.a.a.r r8 = new b.a.a.r
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L47:
                b.a.a.r r8 = new b.a.a.r
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L5e:
                boolean r5 = r8.nextBoolean()
                goto L69
            L63:
                int r1 = r8.nextInt()
                if (r1 == 0) goto L2e
            L69:
                if (r5 == 0) goto L6e
                r0.set(r3)
            L6e:
                int r3 = r3 + 1
                com.google.gson.stream.JsonToken r1 = r8.peek()
                goto Le
            L75:
                r8.endArray()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.w.l.n.v.b(com.google.gson.stream.JsonReader):java.util.BitSet");
        }

        @Override // b.a.a.t
        /* renamed from: f */
        public void d(JsonWriter jsonWriter, BitSet bitSet) {
            jsonWriter.beginArray();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.value(bitSet.get(i) ? 1L : 0L);
            }
            jsonWriter.endArray();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    static class w implements b.a.a.u {
        w() {
        }

        @Override // b.a.a.u
        public <T> b.a.a.t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
            Class c = aVar.c();
            if (!Enum.class.isAssignableFrom(c) || c == Enum.class) {
                return null;
            }
            if (!c.isEnum()) {
                c = (Class<? super Object>) c.getSuperclass();
            }
            return new j0(c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class x implements b.a.a.u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f138a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b.a.a.t f139b;

        x(Class cls, b.a.a.t tVar) {
            this.f138a = cls;
            this.f139b = tVar;
        }

        @Override // b.a.a.u
        public <T> b.a.a.t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
            if (aVar.c() == this.f138a) {
                return this.f139b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f138a.getName() + ",adapter=" + this.f139b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class y implements b.a.a.u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f140a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f141b;
        final /* synthetic */ b.a.a.t c;

        y(Class cls, Class cls2, b.a.a.t tVar) {
            this.f140a = cls;
            this.f141b = cls2;
            this.c = tVar;
        }

        @Override // b.a.a.u
        public <T> b.a.a.t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
            Class<? super T> c = aVar.c();
            if (c == this.f140a || c == this.f141b) {
                return this.c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f141b.getName() + "+" + this.f140a.getName() + ",adapter=" + this.c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class z implements b.a.a.u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f142a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f143b;
        final /* synthetic */ b.a.a.t c;

        z(Class cls, Class cls2, b.a.a.t tVar) {
            this.f142a = cls;
            this.f143b = cls2;
            this.c = tVar;
        }

        @Override // b.a.a.u
        public <T> b.a.a.t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
            Class<? super T> c = aVar.c();
            if (c == this.f142a || c == this.f143b) {
                return this.c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f142a.getName() + "+" + this.f143b.getName() + ",adapter=" + this.c + "]";
        }
    }

    static {
        b.a.a.t<Class> a2 = new k().a();
        f127a = a2;
        f128b = a(Class.class, a2);
        b.a.a.t<BitSet> a3 = new v().a();
        c = a3;
        d = a(BitSet.class, a3);
        c0 c0Var = new c0();
        e = c0Var;
        f = new d0();
        g = b(Boolean.TYPE, Boolean.class, c0Var);
        e0 e0Var = new e0();
        h = e0Var;
        i = b(Byte.TYPE, Byte.class, e0Var);
        f0 f0Var = new f0();
        j = f0Var;
        k = b(Short.TYPE, Short.class, f0Var);
        g0 g0Var = new g0();
        l = g0Var;
        m = b(Integer.TYPE, Integer.class, g0Var);
        b.a.a.t<AtomicInteger> a4 = new h0().a();
        n = a4;
        o = a(AtomicInteger.class, a4);
        b.a.a.t<AtomicBoolean> a5 = new i0().a();
        p = a5;
        q = a(AtomicBoolean.class, a5);
        b.a.a.t<AtomicIntegerArray> a6 = new a().a();
        r = a6;
        s = a(AtomicIntegerArray.class, a6);
        t = new b();
        u = new c();
        v = new d();
        e eVar = new e();
        w = eVar;
        x = a(Number.class, eVar);
        f fVar = new f();
        y = fVar;
        z = b(Character.TYPE, Character.class, fVar);
        g gVar = new g();
        A = gVar;
        B = new h();
        C = new i();
        D = a(String.class, gVar);
        j jVar = new j();
        E = jVar;
        F = a(StringBuilder.class, jVar);
        l lVar = new l();
        G = lVar;
        H = a(StringBuffer.class, lVar);
        m mVar = new m();
        I = mVar;
        J = a(URL.class, mVar);
        C0011n c0011n = new C0011n();
        K = c0011n;
        L = a(URI.class, c0011n);
        o oVar = new o();
        M = oVar;
        N = d(InetAddress.class, oVar);
        p pVar = new p();
        O = pVar;
        P = a(UUID.class, pVar);
        b.a.a.t<Currency> a7 = new q().a();
        Q = a7;
        R = a(Currency.class, a7);
        S = new r();
        s sVar = new s();
        T = sVar;
        U = c(Calendar.class, GregorianCalendar.class, sVar);
        t tVar = new t();
        V = tVar;
        W = a(Locale.class, tVar);
        u uVar = new u();
        X = uVar;
        Y = d(b.a.a.j.class, uVar);
        Z = new w();
    }

    public static <TT> b.a.a.u a(Class<TT> cls, b.a.a.t<TT> tVar) {
        return new x(cls, tVar);
    }

    public static <TT> b.a.a.u b(Class<TT> cls, Class<TT> cls2, b.a.a.t<? super TT> tVar) {
        return new y(cls, cls2, tVar);
    }

    public static <TT> b.a.a.u c(Class<TT> cls, Class<? extends TT> cls2, b.a.a.t<? super TT> tVar) {
        return new z(cls, cls2, tVar);
    }

    public static <T1> b.a.a.u d(Class<T1> cls, b.a.a.t<T1> tVar) {
        return new a0(cls, tVar);
    }
}
