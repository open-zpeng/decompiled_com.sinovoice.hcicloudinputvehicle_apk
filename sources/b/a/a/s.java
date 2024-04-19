package b.a.a;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LongSerializationPolicy.java */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    public static final s f41a;

    /* renamed from: b  reason: collision with root package name */
    public static final s f42b;
    private static final /* synthetic */ s[] c;

    /* compiled from: LongSerializationPolicy.java */
    /* loaded from: classes.dex */
    enum a extends s {
        a(String str, int i) {
            super(str, i, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        f41a = aVar;
        s sVar = new s("STRING", 1) { // from class: b.a.a.s.b
        };
        f42b = sVar;
        c = new s[]{aVar, sVar};
    }

    private s(String str, int i) {
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) c.clone();
    }

    /* synthetic */ s(String str, int i, a aVar) {
        this(str, i);
    }
}
