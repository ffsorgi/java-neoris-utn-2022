package neoris.app.domain;

public class Producto
{	
	private Integer id_producto;
	private String descripcion;
	private Integer id_proveedor;
	private Integer id_categoria;
	private double precio_unitario;
	private Integer unidades_stock;
	private Integer unidades_stock_minimo;
	private Integer unidades_stock_maximo;
	private Integer flg_discontinuo;
	
	public Integer getId_producto()
	{
		return id_producto;
	}
	public void setId_producto(Integer id_producto)
	{
		this.id_producto=id_producto;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion=descripcion;
	}
	public Integer getId_proveedor()
	{
		return id_proveedor;
	}
	public void setId_proveedor(Integer id_proveedor)
	{
		this.id_proveedor=id_proveedor;
	}
	public Integer getId_categoria()
	{
		return id_categoria;
	}
	public void setId_categoria(Integer id_categoria)
	{
		this.id_categoria=id_categoria;
	}
	public double getPrecio_unitario()
	{
		return precio_unitario;
	}
	public void setPrecio_unitario(double precio_unitario)
	{
		this.precio_unitario=precio_unitario;
	}
	public Integer getUnidades_stock()
	{
		return unidades_stock;
	}
	public void setUnidades_stock(Integer unidades_stock)
	{
		this.unidades_stock=unidades_stock;
	}
	public Integer getUnidades_stock_minimo()
	{
		return unidades_stock_minimo;
	}
	public void setUnidades_stock_minimo(Integer unidades_stock_minimo)
	{
		this.unidades_stock_minimo=unidades_stock_minimo;
	}
	public Integer getUnidades_stock_maximo()
	{
		return unidades_stock_maximo;
	}
	public void setUnidades_stock_maximo(Integer unidades_stock_maximo)
	{
		this.unidades_stock_maximo=unidades_stock_maximo;
	}
	public Integer getFlg_discontinuo()
	{
		return flg_discontinuo;
	}
	public void setFlg_discontinuo(Integer flg_discontinuo)
	{
		this.flg_discontinuo=flg_discontinuo;
	}

}
