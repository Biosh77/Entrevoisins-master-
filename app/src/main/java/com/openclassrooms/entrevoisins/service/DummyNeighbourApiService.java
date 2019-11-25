package com.openclassrooms.entrevoisins.service;



import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;


/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }


    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> FavNeighbour = new ArrayList<>();
        for ( int i = 0; i< neighbours.size(); i++)
            if (neighbours.get(i).getIsFavorite()){
                FavNeighbour.add(neighbours.get(i));
            }
        return FavNeighbour;
    }


    @Override
    public void changeFavoriteNeighbour ( int neighbourFavorite){

        for (int i = 0; i< neighbours.size(); i++){

            if (neighbourFavorite == neighbours.get(i).getId()){

                neighbours.get(i).setFavorite(!neighbours.get(i).getIsFavorite());

                return;
            }

        }
    }
}


