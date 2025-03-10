package thread;

import neoris.app.FacadeImplement;

public class StockThread extends Thread
{
	@Override
	public void run()
	{
		FacadeImplement facade=new FacadeImplement();

		while(true)
		{
			int delay=5000;

			try
			{
				Thread.sleep(delay);
				facade.generarReposicionProducto();

			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}

		}

	}
}
