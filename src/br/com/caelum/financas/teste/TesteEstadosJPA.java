package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteEstadosJPA {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		// ID de uma conta que exista no banco de dados. mo caso ID:1
		Conta conta = manager.find(Conta.class, 1);
		System.out.println(conta.getTitular());
		// Alterando o titular da conta
		conta.setTitular("Antônio Rogério");
		System.out.println(conta.getTitular());
		
		manager.getTransaction().commit();
		manager.close();
	}
}
