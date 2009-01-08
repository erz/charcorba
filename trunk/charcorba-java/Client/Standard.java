package Client;

import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.DoubleHolder;
import org.omg.CORBA.ShortHolder;
import org.omg.CORBA.StringHolder;

/**
 *	Generated from IDL interface "Standard"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public interface Standard
	extends StandardOperations, org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity
{

	Object setValues(StringHolder stringHolder, DoubleHolder doubleHolder,
			ShortHolder shortHolder, BooleanHolder booleanHolder);
}
