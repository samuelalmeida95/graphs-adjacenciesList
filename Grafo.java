package ufpb.teste5;

import java.util.List;

public interface Grafo {

	Vertice getVertice(String nome);
	
	Vertice addVertice(String nome);

	void addAresta(Vertice v1, Vertice v2);

	List<Vertice> getVertices();

	boolean segue(Vertice v1, Vertice v2);

}