package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteGerenciamentoJPA {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		//ID de conta que exista no banco de dados, no caso ID:1
		Conta conta = manager.find(Conta.class, 1);
		//commit antes da altera��o
		manager.getTransaction().commit();
		//Altera��o do titular
		conta.setTitular("Caelum ensino e inova��o");
		manager.getTransaction().begin();
		manager.merge(conta);
		manager.getTransaction().commit();
		
		manager.close();
		
	}
}
