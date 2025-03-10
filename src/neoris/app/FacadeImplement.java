package neoris.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.MiJdbc;
import neoris.app.domain.Categoria;
import neoris.app.domain.Cliente;
import neoris.app.domain.Empleado;
import neoris.app.domain.Producto;
import neoris.app.domain.Promocion;
import neoris.app.domain.Proveedor;
import test.neoris.util.MiFactory;

public class FacadeImplement implements Facade
{
	
	private MiJdbc getJdbcInstance()
	{
		return MiFactory.getInstance("miJdbc");
	}
	
	@Override
	public List<Producto> obtenerProductos()
	{

		MiJdbc jdbc = getJdbcInstance();
		
		List<Producto> productos=new ArrayList<>();

		try
		{
			List<Object[]> lst=jdbc
					.query("SELECT id_producto,descripcion,id_proveedor,id_categoria,precio_unitario,unidades_stock,unidades_stock_minimo,unidades_stock_maximo,flg_discontinuo FROM producto ");

			for(Object[] fila:lst)
			{
				Producto dto=new Producto();

				dto.setId_producto((Integer)fila[0]);
				dto.setDescripcion((String)fila[1]);
				dto.setId_proveedor((Integer)fila[2]);
				dto.setId_categoria((Integer)fila[3]);
				dto.setPrecio_unitario((double)fila[4]);
				dto.setUnidades_stock((Integer)fila[5]);
				dto.setUnidades_stock_minimo((Integer)fila[6]);
				dto.setUnidades_stock_maximo((Integer)fila[7]);
				dto.setFlg_discontinuo((Integer)fila[8]);

				productos.add(dto);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return productos;
	}

	@Override
	public List<Cliente> obtenerClientesQueAdquirieron(int idProducto)
	{
		MiJdbc jdbc = getJdbcInstance();

		List<Cliente> clientes=new ArrayList<>();

		try
		{
			List<Object[]> idOrden=jdbc.query("SELECT id_orden FROM detalle_orden WHERE id_producto="+idProducto);

			for(Object[] id:idOrden)
			{

				List<Object[]> idCliente=jdbc.query("SELECT id_cliente FROM orden WHERE id_orden="+id[0]);

				for(Object[] idc:idCliente)
				{
					List<Object[]> cliente=jdbc.query("SELECT id_cliente, id_usuario, nombre, direccion, id_tipo_cliente FROM cliente WHERE id_cliente="+idc[0]);

					for(Object[] c:cliente)
					{
						Cliente dto=new Cliente();
						dto.setId_cliente((Integer)c[0]);
						dto.setId_usuario((Integer)c[1]);
						dto.setNombre((String)c[2]);
						dto.setDireccion((String)c[3]);
						dto.setId_tipo_cliente((Integer)c[4]);

						clientes.add(dto);
					}
					;

				}
				;

			}
			;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return clientes;
	}

	@Override
	public List<Cliente> obtenerClientes()
	{
		MiJdbc jdbc = getJdbcInstance();

		List<Cliente> clientes=new ArrayList<>();

		try
		{
			List<Object[]> lst=jdbc.query("SELECT id_cliente, id_usuario, nombre, direccion, id_tipo_cliente FROM cliente ");

			for(Object[] c:lst)
			{
				Cliente dto=new Cliente();

				dto.setId_cliente((Integer)c[0]);
				dto.setId_usuario((Integer)c[1]);
				dto.setNombre((String)c[2]);
				dto.setDireccion((String)c[3]);
				dto.setId_tipo_cliente((Integer)c[4]);

				clientes.add(dto);
			}
			;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return clientes;
	}

	@Override
	public List<Empleado> obtenerEmpleadosQueAntendieron(int idCliente)
	{
		MiJdbc jdbc = getJdbcInstance();
		
		List<Empleado> empleados=new ArrayList<>();
		try
		{
			List<Object[]> lst=jdbc.query("SELECT id_empleado FROM orden WHERE id_cliente="+idCliente);
			for(Object[] id:lst)
			{
				List<Object[]> empleado=jdbc.query("SELECT id_empleado, nombre, id_jefe FROM empleado WHERE id_empleado="+id[0]);

				for(Object[] e:empleado)
				{
					Empleado dto=new Empleado();

					dto.setId_empleado((Integer)e[0]);
					dto.setNombre((String)e[1]);
					dto.setId_jefe((Integer)e[2]);

					empleados.add(dto);
				}
				;
			}
			;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return empleados;
	}

	@Override
	public List<Producto> obtenerProductosConPromocionesVigentes()
	{
		MiJdbc jdbc = getJdbcInstance();

		List<Producto> productos=new ArrayList<>();

		try
		{
			LocalDate date=LocalDate.now();

			Object[] params= {date, date};

			List<Object[]> idPromocion=jdbc.query("SELECT id_promocion_vigencia FROM promocion_vigencia WHERE fecha_inicio <= ? AND fecha_fin >= ?",params);

			for(Object[] idProm:idPromocion)
			{
				List<Object[]> idProducto=jdbc.query("SELECT id_producto FROM promocion_producto WHERE id_promocion_vigencia="+idProm[0]);

				for(Object[] idProd:idProducto)
				{
					List<Object[]> producto=jdbc.query(
							"SELECT id_producto,descripcion,id_proveedor,id_categoria,precio_unitario,unidades_stock,unidades_stock_minimo,unidades_stock_maximo,flg_discontinuo FROM producto WHERE id_producto="
									+idProd[0]);

					for(Object[] p:producto)
					{
						Producto dto=new Producto();

						dto.setId_producto((Integer)p[0]);
						dto.setDescripcion((String)p[1]);
						dto.setId_proveedor((Integer)p[2]);
						dto.setId_categoria((Integer)p[3]);
						dto.setPrecio_unitario((double)p[4]);
						dto.setUnidades_stock((Integer)p[5]);
						dto.setUnidades_stock_minimo((Integer)p[6]);
						dto.setUnidades_stock_maximo((Integer)p[7]);
						dto.setFlg_discontinuo((Integer)p[8]);

						productos.add(dto);
					}
					;

				}
				;

			}
			;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return productos;
	}

	@Override
	public List<Promocion> obtenerPromociones(int idProducto)
	{
		MiJdbc jdbc = getJdbcInstance();
		
		List<Promocion> promociones=new ArrayList<>();

		try
		{
			String sql="";
			sql+="SELECT DISTINCT (prom.descripcion) ";
			sql+="FROM promocion_producto pp,promocion_vigencia pv, promocion prom ";
			sql+="WHERE pp.id_promocion_vigencia=pv.id_promocion_vigencia ";
			sql+="AND pv.id_promocion=prom.id_promocion ";
			sql+="AND pp.id_producto="+idProducto+" ";

			List<Object[]> lst=jdbc.query(sql);

			for(Object[] l:lst)
			{
				Promocion dto=new Promocion();

				dto.setDescripcion((String)l[0]);

				promociones.add(dto);
			}
			;

		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return promociones;
	}

	@Override
	public List<Categoria> obtenerCategorias()
	{
		MiJdbc jdbc = getJdbcInstance();
		
		List<Categoria> categorias=new ArrayList<>();

		try
		{
			List<Object[]> lst=jdbc.query("SELECT id_categoria, descripcion FROM categoria");

			for(Object[] c:lst)
			{

				Categoria dto=new Categoria();

				dto.setId_categoria((Integer)c[0]);
				dto.setDescripcion((String)c[1]);

				categorias.add(dto);
			}
			;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return categorias;
	}

	@Override
	public List<Proveedor> obtenerProveedores(int idCategoria)
	{
		MiJdbc jdbc = getJdbcInstance();
		
		List<Proveedor> proveedores=new ArrayList<>();

		try
		{
			List<Object[]> idProveedores=jdbc.query("SELECT id_proveedor FROM proveedor_categoria WHERE id_categoria="+idCategoria);

			for(Object[] id:idProveedores)
			{
				List<Object[]> proveedor=jdbc.query("SELECT id_proveedor,empresa,contacto,direccion FROM proveedor WHERE id_proveedor="+id[0]);

				for(Object[] p:proveedor)
				{
					Proveedor dto=new Proveedor();

					dto.setId_proveedor((Integer)p[0]);
					dto.setEmpresa((String)p[1]);
					dto.setContacto((String)p[2]);
					dto.setDireccion((String)p[3]);

					proveedores.add(dto);
				}
			}
			;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return proveedores;
	}

	@Override
	public void generarReposicionProducto()
	{
		MiJdbc jdbc = getJdbcInstance();

		try
		{
			String sql="";
			sql+="INSERT INTO Reposicion (id_producto, cantidad, fecha) ";
			sql+="SELECT P.id_producto,(P.unidades_stock_maximo - P.unidades_stock) ";
			sql+="AS cantidad, CURRENT_DATE ";
			sql+="FROM Producto AS P ";
			sql+="WHERE P.unidades_stock < P.unidades_stock_minimo ";
			sql+="AND NOT EXISTS (SELECT 1 FROM reposicion WHERE id_producto=P.id_producto) ";

			jdbc.update(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
