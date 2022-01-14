package ru.netology.manager;

import ru.netology.domain.PosterMovies;

public class MovieManager {
    public PosterMovies[] movies = new PosterMovies[0];
    private int quantityMovies = 10;

    public MovieManager(int quantityMovies) {
        this.quantityMovies = quantityMovies;
    }

    public MovieManager() {

    }

    public void addMovie(PosterMovies movie) {
        int lenght = movies.length + 1;
        PosterMovies[] tmp = new PosterMovies[lenght];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public PosterMovies[] getAllMovies() {
        PosterMovies[] result = new PosterMovies[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length -i -1;
            result[i] = movies[index];
        }
        return result;
    }

    public PosterMovies[] getTenMovies() {
        int quantity = this.quantityMovies;
        if (quantity > movies.length)
            quantity = movies.length;
        PosterMovies[] result = new PosterMovies[quantity];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length -i -1;
            result[i] = movies[index];
        }
        return result;
    }
}
