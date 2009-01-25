package tableau_blanc;

import org.omg.PortableServer.POA;
/**
 *	Generated from IDL interface "AMI_TableauBlancHandler"
 *	@author JacORB IDL compiler V 2.2.3, 10-Dec-2005
 */

public class AMI_TableauBlancHandlerPOATie
	extends AMI_TableauBlancHandlerPOA
{
	private AMI_TableauBlancHandlerOperations _delegate;

	private POA _poa;
	public AMI_TableauBlancHandlerPOATie(AMI_TableauBlancHandlerOperations delegate)
	{
		_delegate = delegate;
	}
	public AMI_TableauBlancHandlerPOATie(AMI_TableauBlancHandlerOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public AMI_TableauBlancHandler _this()
	{
		return AMI_TableauBlancHandlerHelper.narrow(_this_object());
	}
	public AMI_TableauBlancHandler _this(org.omg.CORBA.ORB orb)
	{
		return AMI_TableauBlancHandlerHelper.narrow(_this_object(orb));
	}
	public AMI_TableauBlancHandlerOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(AMI_TableauBlancHandlerOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		else
		{
			return super._default_POA();
		}
	}
	public void get_pixel(s_pixel ami_return_val)
	{
_delegate.get_pixel(ami_return_val);
	}

	public void ajouter_pixel(boolean ami_return_val)
	{
_delegate.ajouter_pixel(ami_return_val);
	}

	public void ajouter_pixel_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.ajouter_pixel_excep(excep_holder);
	}

	public void get_pixel_excep(org.omg.Messaging.ExceptionHolder excep_holder)
	{
_delegate.get_pixel_excep(excep_holder);
	}

}
