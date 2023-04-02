package ru.netology.manager;

import ru.netology.domain.Poster;
import ru.netology.repository.PosterManagerRepository;

public class PosterManager {
    private PosterManagerRepository repo;
    private int limit;

    public PosterManager(PosterManagerRepository repo) {
        this.repo = repo;
        this.limit = 10;
    }

    public void PosterManager(PosterManagerRepository repo, int limit) {
        this.repo = repo;
        this.limit = limit;
    }

    public void add(Poster movie) {
        repo.save(movie);
    }

    public Poster[] findLast() {
        Poster[] movies = repo.findAll();
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }
        Poster[] result = new Poster[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }

    public Poster[] showAll() {
        return repo.findAll();
    }
}
