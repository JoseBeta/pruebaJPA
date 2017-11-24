package proyecto.clase.jpa.test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import proyecto.clase.jpa.Usuario;

public class Test {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		listar();
	}
	
	public static void listar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoClaseJPA");
		EntityManager em = emf.createEntityManager();
		try {
			Query q = em.createNamedQuery("Usuario.findAll");
			
			List lista = q.getResultList();
			Usuario user;
			for(int i=0;i<lista.size();i++) {
				user = (Usuario)lista.get(i);
				user.leer();
			}
		}catch(Exception e){
			System.out.println("error: "+e.getMessage());
		}finally {
			em.close();
			emf.close();
		}
	}
		
	
	public static void ingreso() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoClaseJPA");
		EntityManager em = emf.createEntityManager();
		try {
			Usuario user = new Usuario();
			user.setId(3);
			user.setAdmin(false);
			user.setFNacimiento(sdf.parse("26/07/1992"));
			user.setContrasena("123");
			user.setNombre("pingu");
			
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			System.out.println("OK");
		}catch(Exception e){
			em.getTransaction().rollback();
			System.out.println("error "+e.getMessage());
		}finally {
			em.close();
			emf.close();
		}
	}
	
	public static void modificar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoClaseJPA");
		EntityManager em = emf.createEntityManager();
		try {
			Usuario user = new Usuario();
			user.setId(1);
			user.setAdmin(true);
			user.setFNacimiento(sdf.parse("26/07/1992"));
			user.setContrasena("123");
			user.setNombre("jose");
			
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			System.out.println("OK");
		}catch(Exception e){
			em.getTransaction().rollback();
			System.out.println("error "+e.getMessage());
		}finally {
			em.close();
			emf.close();
		}
	}
	
	public static void eliminar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoClaseJPA");
		EntityManager em = emf.createEntityManager();
		try {
			Usuario user = new Usuario();
			user= em.find(Usuario.class, 1);
			
			if(user == null) {
				System.out.println("Usuario no encontrado");
			}else {
				user.leer();
				em.getTransaction().begin();
				em.remove(user);
				em.getTransaction().commit();
			}
			System.out.println("OK");

		}catch(Exception e){
			em.getTransaction().rollback();
			System.out.println("error "+e.getMessage());
		}finally {
			em.close();
			emf.close();
		}
	}
}
