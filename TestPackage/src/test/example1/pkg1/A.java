package test.example1.pkg1;
public class A {
	private int priv;
	public int pub = 20;
	protected int pro;
	int def;

	
	void showData() {
		System.out.println(priv);
		System.out.println(pub);
		System.out.println(pro);
		System.out.println(def);
	}
	
	private int getPriv() {
		return priv;
	}

	public void setPriv(int priv) {
		this.priv = priv;
	}

	public int getPub() {
		return pub;
	}

	public void setPub(int pub) {
		this.pub = pub;
	}

	public int getPro() {
		return pro;
	}

	public void setPro(int pro) {
		this.pro = pro;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

}
