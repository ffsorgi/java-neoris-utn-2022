package neoris.app.domain;

public class Empleado
{
	private Integer id_empleado;
	private String nombre;
	private Integer id_jefe;
	
	public Integer getId_empleado()
	{
		return id_empleado;
	}
	public void setId_empleado(Integer id_empleado)
	{
		this.id_empleado=id_empleado;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	public Integer getId_jefe()
	{
		return id_jefe;
	}
	public void setId_jefe(Integer id_jefe)
	{
		this.id_jefe=id_jefe;
	}
	
}
