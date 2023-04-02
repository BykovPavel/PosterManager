package ru.netology.repository;

import ru.netology.domain.Poster;

public class PosterManagerRepository {
    private Poster[] movies = new Poster[0];

    public Poster[] findAll() {
        return movies;
    }

    public void save(Poster movie) {
        Poster[] tmp = new Poster[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public Poster findById(int id) {
        for (Poster movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Poster[] tmp = new Poster[movies.length - 1];
        int copyToIndex = 0;
        for (Poster movie : movies) {
            if (movie.getId() != id) {
                tmp[copyToIndex] = movie;
                copyToIndex++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        movies = new Poster[0];
    }
}
