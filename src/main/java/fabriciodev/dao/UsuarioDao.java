package fabriciodev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import fabriciodev.model.Usuario;

public class UsuarioDao {

	EntityManagerFactory emf;
	EntityManager em;

	public UsuarioDao() {
		emf = Persistence.createEntityManagerFactory("crud-hibernate");
		em = emf.createEntityManager();
	}

	public void inserir(Usuario u) throws Exception {
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void excluir(Usuario u) {
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
        emf.close();
 }

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select usuario from Usuario usuario");
		List<Usuario> usuarios = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return usuarios;
	}

		public Usuario obterPorId(Long long1) {
			em.getTransaction().begin();
			Usuario usuario = em.find(Usuario.class, long1);
			em.getTransaction().commit();
			//emf.close();
			return usuario;

		}
		
		public Usuario obterPorCpf(long cpf) {
			em.getTransaction().begin();
			Usuario usuario = em.find(Usuario.class, cpf);
			em.getTransaction().commit();
			//emf.close();
			return usuario;
		}

	/// ALTERAR
	public void alteraUsuario() {
		em.getTransaction().begin();
		Query p = em.createQuery("From Usuario");
		List<Usuario> usuarios = p.getResultList();

		for (Usuario u : usuarios) {
			Usuario usuario = null;
			if (usuario.getId() == u.getId()) {
				// Alterar usuarios

				usuario = em.find(Usuario.class, usuario.getId());

				usuario.setNome(usuario.getNome());
				usuario.setCpf(usuario.getCpf());
				usuario.setEmail(usuario.getEmail());
				usuario.setEndereco(usuario.getEndereco());

				em.merge(usuario);
				em.getTransaction().commit();
				em.close();

				break;
			}
		}
	}

	public List<Usuario> porNomeSemelhante(String nome) {
		return em.createQuery("from Usuario where nome like :nome", Usuario.class)
				.setParameter("nome", "%" + nome + "%").getResultList();
	}

	public void buscUsuario(long cpf, String nome, String data_cadastro) {
		// TODO Auto-generated method stub
		
	}

	public void excluir(long id) {
		// TODO Auto-generated method stub
		
	}

	public void usuarioSelecionado(Long valueOf) {
		// TODO Auto-generated method stub
		
	}

}