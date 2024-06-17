package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;

public class PersistenceApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			//Cliente cliente = new Cliente("Francisco", "Vargas", 44662178);
			//em.persist(cliente);
			//Domicilio domicilio = new Domicilio("Entre Ríos", 81);
			//cliente.setDomicilio(domicilio);
			//domicilio.setCliente(cliente);
			//Domicilio dom =  em.find(Domicilio.class, 1L);
			//Cliente cli =  em.find(Cliente.class, 1L);
			//System.out.println(dom.getCliente().getDni());
			//System.out.println(cli.getDomicilio().getNombre_calle());
			
			Factura factura1 = new Factura();
			factura1.setNumero(12);
			factura1.setFecha("09/12/2018");
			
			Domicilio dom = new Domicilio("Pedro del Castillo", 56);
			Cliente cliente = new Cliente("Pedro", "Gomez", 33555938);
			cliente.setDomicilio(dom);
			dom.setCliente(cliente);
			factura1.setCliente(cliente);
			
			Categoria perecederos =  new Categoria("Perecederos");
			Categoria lacteos =  new Categoria("Lácteos");
			Categoria limpieza =  new Categoria("Limpieza");
			
			Articulo art1 = new Articulo(140, "Yogurt de Vainilla", 1200);
			Articulo art2 = new Articulo(190, "Lavandina", 100);
			
			art1.getCategorias().add(perecederos);
			art1.getCategorias().add(lacteos);
			art2.getCategorias().add(limpieza);
			lacteos.getArticulos().add(art1);
			perecederos.getArticulos().add(art1);
			limpieza.getArticulos().add(art2);
			
			
			DetalleFactura detalle1 = new DetalleFactura();
			detalle1.setArticulo(art1);
			detalle1.setCantidad(2);
			detalle1.setSubtotal(40);
			
			art1.getDetalles().add(detalle1);
			factura1.getDetalles().add(detalle1);
			detalle1.setFactura(factura1);
			
			DetalleFactura detalle2 =  new DetalleFactura();
			detalle2.setArticulo(art1);
			detalle2.setCantidad(2);
			detalle2.setSubtotal(40);
			
			art2.getDetalles().add(detalle2);
			factura1.getDetalles().add(detalle2);
			detalle2.setFactura(factura1);
			
			factura1.setTotal(1400);
			
			
			
			em.persist(factura1);
			em.flush();
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}
	
}
