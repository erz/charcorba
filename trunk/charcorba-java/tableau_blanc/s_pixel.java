package tableau_blanc;

/**
 *	Generated from IDL definition of struct "s_pixel"
 *	@author JacORB IDL compiler 
 */

public final class s_pixel
	implements org.omg.CORBA.portable.IDLEntity
{
	public s_pixel(){}
	public short x;
	public short y;
	public short rouge;
	public short vert;
	public short bleu;
	public boolean est_continu;
	public s_pixel(short x, short y, short rouge, short vert, short bleu, boolean est_continu)
	{
		this.x = x;
		this.y = y;
		this.rouge = rouge;
		this.vert = vert;
		this.bleu = bleu;
		this.est_continu = est_continu;
	}
}
