package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterMovies;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    private MovieManager manager = new MovieManager();

    PosterMovies first = new PosterMovies(1, "Бладшот", "боевик");
    PosterMovies second = new PosterMovies(2, "Вперед", "мультфильм");
    PosterMovies third = new PosterMovies(3, "Отель Белград", "комедия");
    PosterMovies fourth = new PosterMovies(4, "Джентельмены", "боевик");
    PosterMovies fifth = new PosterMovies(5, "Человек-неведимка", "ужасы");
    PosterMovies sixth = new PosterMovies(6, "Тролли", "мультфильм");
    PosterMovies seventh = new PosterMovies(7, "Номер один", "комедия");
    PosterMovies eighth = new PosterMovies(8, "Матрица", "фантастика");
    PosterMovies ninth = new PosterMovies(9, "Спенсер", "драма");
    PosterMovies tenth = new PosterMovies(10, "Человек паук", "фантастика");

    public void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
    }

    @Test
    public void addMoviesToEmpty() {
        manager.addMovie(first);
        assertArrayEquals(new PosterMovies[]{first}, manager.getAllMovies());
    }

    @Test
    public void addMoviesToExisted() {
        manager.addMovie(first);
        PosterMovies[] expected = new PosterMovies[]{first};
        PosterMovies[] actual = manager.getAllMovies();
        assertArrayEquals(new PosterMovies[]{first}, manager.getAllMovies());

        manager.addMovie(second);
        PosterMovies[] expectedAdded = new PosterMovies[]{second, first};
        PosterMovies[] actualAdded = manager.getAllMovies();
        assertArrayEquals(expectedAdded, actualAdded);
    }

    @Test
    void moviesForQuantityMovies() {
        setUp();
        PosterMovies[] expected = new PosterMovies[]{tenth,ninth,eighth,seventh,sixth,fifth, fourth, third, second, first};
        PosterMovies[] actual = manager.getTenMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    void moviesMinQuantityMovies() {
        manager = new MovieManager(4);
        setUp();
        PosterMovies[] expected = new PosterMovies[]{tenth,ninth,eighth,seventh};
        PosterMovies[] actual = manager.getTenMovies();
        assertArrayEquals(expected, actual);
    }

}



