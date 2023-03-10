package fabriciodev.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private final String SERVIDOR = "localhost";
	private final String PORTA = "3306";
	private final String BANCO_DE_DADO = "crud1";
	private final String USUARIO = "root";
	private final String SENHA = "";
	private final String URL = "jdbc:mysql://" + SERVIDOR + ":" + PORTA + "/" + BANCO_DE_DADO;

	private Connection conexao;

	public Conexao() throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		conexao.setAutoCommit(true);
	}

	public Connection getConexao() {
		return conexao;
	}

}
