package app;

import java.util.Scanner;
import neoris.app.FacadeImplement;
import neoris.app.domain.*;
import thread.StockThread;

import java.util.List;

public class NeorisApp
{

	public static void main(String[] args)
	{
		StockThread t=new StockThread();
		t.start();

		Scanner read=new Scanner(System.in);
		FacadeImplement facade=new FacadeImplement();
		int opt;

		do
		{

			System.out.println("1)CLIENTES QUE ADQUIRIERON UN PRODUCTO");
			System.out.println("2)EMPLEADOS QUE ATENDIERON A UN CLIENTES");
			System.out.println("3)LISTADO DE LOS PRODUCTOS QUE TIENEN PROMOCIONES EN VIGENCIA");
			System.out.println("4)LISTADO DE LAS PROMOCIONES PARA UN PRODUCTO");
			System.out.println("5)PROVEEDORES POR CATEOGORIA");
			System.out.println("0)SALIR");
			System.out.print("Ingrese una opción(0-5):");

			opt=read.nextInt();

			switch(opt)
			{
				case 0:
				{
					System.exit(0);
					break;
				}
				case 1:
				{
					System.out.print("Ingresa el id del producto:");
					Integer id=read.nextInt();

					List<Cliente> clientes=facade.obtenerClientesQueAdquirieron(id);

					for(Cliente dto:clientes)
					{
						System.out.println(dto.getId_cliente()+" "+dto.getId_usuario()+" "+dto.getNombre()+" "+dto.getDireccion()+" "+dto.getId_tipo_cliente());
					}

					break;
				}
				case 2:
				{
					System.out.println("Ingresa el id del cliente:");
					Integer id=read.nextInt();

					List<Empleado> empleados=facade.obtenerEmpleadosQueAntendieron(id);

					for(Empleado dto:empleados)
					{
						System.out.println(dto.getId_empleado()+" "+dto.getNombre()+" "+dto.getId_empleado());
					}

					break;
				}
				case 3:
				{
					List<Producto> productos=facade.obtenerProductosConPromocionesVigentes();

					for(Producto dto:productos)
					{
						System.out.println(dto.getId_producto()+" "+dto.getDescripcion()+" "+dto.getId_proveedor()+" "+dto.getId_categoria()+" "+dto.getPrecio_unitario()+" "+dto.getUnidades_stock()
								+" "+dto.getUnidades_stock_minimo()+" "+dto.getUnidades_stock_maximo()+" "+dto.getFlg_discontinuo());
					}

					break;
				}
				case 4:
				{
					System.out.println("Ingrese el id del producto:");
					int id=read.nextInt();
					List<Promocion> promociones=facade.obtenerPromociones(id);

					for(Promocion dto:promociones)
					{
						System.out.println(dto.getId_promoción()+" "+dto.getDescripcion());
					}
					;

					break;
				}
				case 5:
				{
					List<Categoria> categorias=facade.obtenerCategorias();

					for(Categoria c:categorias)
					{
						System.out.println(c.getId_categoria()+")"+c.getDescripcion());
					}
					;

					System.out.print("Ingrese el numero para la categoria:");
					int id=read.nextInt();

					List<Proveedor> provedores=facade.obtenerProveedores(id);

					for(Proveedor p:provedores)
					{
						System.out.println(p.getId_proveedor()+" "+p.getEmpresa()+" "+p.getContacto()+" "+p.getDireccion());
					}
					;

					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: "+opt);
			}
		}
		while(opt!=0);

		read.close();
	}

}
