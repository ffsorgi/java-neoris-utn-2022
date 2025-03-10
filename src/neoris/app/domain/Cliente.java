package neoris.app.domain;

public class Cliente
{
	private Integer id_cliente;
	private Integer id_usuario;
	private String nombre;
	private String direccion;
	private Integer id_tipo_cliente;
	
	public Integer getId_cliente()
	{
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente)
	{
		this.id_cliente=id_cliente;
	}
	public Integer getId_usuario()
	{
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario)
	{
		this.id_usuario=id_usuario;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	public String getDireccion()
	{
		return direccion;
	}
	public void setDireccion(String direccion)
	{
		this.direccion=direccion;
	}
	public Integer getId_tipo_cliente()
	{
		return id_tipo_cliente;
	}
	public void setId_tipo_cliente(Integer id_tipo_cliente)
	{
		this.id_tipo_cliente=id_tipo_cliente;
	}
	
}
