package ufpb.teste5;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ParcasTest {

	@Test
	public void test() {
		Grafo grafo = new GrafoComListaDeAdjacencias("Faustão", "Neymar", 
				"Thiaguinho", "Gabriel Medina", 
				"Tirulipa",
				"Whindersson");

		Vertice faustao = grafo.getVertice("Faustão");
		Vertice neymar = grafo.getVertice("Neymar");
		Vertice thiaguinho = grafo.getVertice("Thiaguinho");
		Vertice gabriel = grafo.getVertice("Gabriel Medina");
		Vertice tirulipa = grafo.getVertice("Tirulipa");
		Vertice whindersson = grafo.getVertice("Whindersson");

		grafo.addAresta(faustao, neymar);
		grafo.addAresta(thiaguinho, neymar);
		grafo.addAresta(neymar, thiaguinho);
		grafo.addAresta(neymar, gabriel);
		grafo.addAresta(tirulipa, faustao);
		grafo.addAresta(tirulipa, neymar);
		grafo.addAresta(tirulipa, whindersson);
		grafo.addAresta(whindersson, gabriel);
		grafo.addAresta(gabriel, whindersson);

		List<Vertice> vertices = grafo.getVertices();

		assertTrue(vertices.contains(faustao));
		assertTrue(vertices.contains(neymar));
		assertTrue(vertices.contains(thiaguinho));
		assertTrue(vertices.contains(gabriel));
		assertTrue(vertices.contains(tirulipa));
		assertTrue(vertices.contains(whindersson));
		assertEquals(6, vertices.size());

		// Faustão
		assertTrue(grafo.segue(faustao, neymar));
		assertFalse(grafo.segue(faustao, thiaguinho));
		assertFalse(grafo.segue(faustao, gabriel));
		assertFalse(grafo.segue(faustao, tirulipa));
		assertFalse(grafo.segue(faustao, whindersson));

		// Neymar
		assertFalse(grafo.segue(neymar, faustao));
		assertTrue(grafo.segue(neymar, thiaguinho));
		assertTrue(grafo.segue(neymar, gabriel));
		assertFalse(grafo.segue(neymar, tirulipa));
		assertFalse(grafo.segue(neymar, whindersson));

		// Thiaguinho
		assertFalse(grafo.segue(thiaguinho, faustao));
		assertTrue(grafo.segue(thiaguinho, neymar));
		assertFalse(grafo.segue(thiaguinho, gabriel));
		assertFalse(grafo.segue(thiaguinho, tirulipa));
		assertFalse(grafo.segue(thiaguinho, whindersson));

		// Gabriel
		assertFalse(grafo.segue(gabriel, faustao));
		assertFalse(grafo.segue(gabriel, neymar));
		assertFalse(grafo.segue(gabriel, thiaguinho));
		assertFalse(grafo.segue(gabriel, tirulipa));
		assertTrue(grafo.segue(gabriel, whindersson));

		// Tirulipa
		assertTrue(grafo.segue(tirulipa, faustao));
		assertTrue(grafo.segue(tirulipa, neymar));
		assertFalse(grafo.segue(tirulipa, thiaguinho));
		assertFalse(grafo.segue(tirulipa, gabriel));
		assertTrue(grafo.segue(tirulipa, whindersson));

		// Whindersson
		assertFalse(grafo.segue(whindersson, faustao));
		assertFalse(grafo.segue(whindersson, neymar));
		assertFalse(grafo.segue(whindersson, thiaguinho));
		assertTrue(grafo.segue(whindersson, gabriel));
		assertFalse(grafo.segue(whindersson, tirulipa));

	}

}