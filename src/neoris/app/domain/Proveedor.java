package neoris.app.domain;

public class Proveedor
{
	private Integer id_proveedor;
	private String empresa;
	private String contacto;
	private String direccion;
	public Integer getId_proveedor()
	{
		return id_proveedor;
	}
	public void setId_proveedor(Integer id_proveedor)
	{
		this.id_proveedor=id_proveedor;
	}
	public String getEmpresa()
	{
		return empresa;
	}
	public void setEmpresa(String empresa)
	{
		this.empresa=empresa;
	}
	public String getContacto()
	{
		return contacto;
	}
	public void setContacto(String contacto)
	{
		this.contacto=contacto;
	}
	public String getDireccion()
	{
		return direccion;
	}
	public void setDireccion(String direccion)
	{
		this.direccion=direccion;
	}
	
}
