package dbo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnection {

	public static void saveMusica(Musicas musicas) {
		if (musicas == null) {

		}
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(musicas);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public static List<Musicas> getAllMusics() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		List<Musicas> musicas = (List<Musicas>) session.createSQLQuery("SELECT * FROM musicas").addEntity(Musicas.class)
				.list();
		session.close();
		return musicas;
	}

	@SuppressWarnings("unchecked")
	public static List<Musicas> getMusicsByTitle(String titulo) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		List<Musicas> musicas = (List<Musicas>) session
				.createSQLQuery("SELECT * FROM musicas WHERE titulo='" + titulo + "'").addEntity(Musicas.class).list();
		session.close();
		return musicas;
	}

	@SuppressWarnings("unchecked")
	public static List<Musicas> getMusicsByEstilo(String estilo) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		List<Musicas> musicas = (List<Musicas>) session
				.createSQLQuery("SELECT * FROM musicas WHERE musicas.estilo ='" + estilo + "'").addEntity(Musicas.class)
				.list();
		session.close();
		return musicas;
	}

	@SuppressWarnings("unchecked")
	public static List<Musicas> getMusicsByCantor(String cantor) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		List<Musicas> musicas = (List<Musicas>) session
				.createSQLQuery("SELECT * FROM musicas WHERE cantores='" + cantor + "'").addEntity(Musicas.class)
				.list();
		session.close();
		return musicas;
	}
}
