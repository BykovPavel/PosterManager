package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Poster;
import ru.netology.repository.PosterManagerRepository;
import static org.mockito.Mockito.*;

public class PosterManagerTest {

    PosterManagerRepository repo = Mockito.mock(PosterManagerRepository.class);
    PosterManager manager = new PosterManager(repo);

    Poster movie1 = new Poster(1, "Movie #1");
    Poster movie2 = new Poster(2, "Movie #2");
    Poster movie3 = new Poster(3, "Movie #3");
    Poster movie4 = new Poster(4, "Movie #4");
    Poster movie5 = new Poster(5, "Movie #5");
    Poster movie6 = new Poster(6, "Movie #6");
    Poster movie7 = new Poster(7, "Movie #7");
    Poster movie8 = new Poster(8, "Movie #8");
    Poster movie9 = new Poster(9, "Movie #9");
    Poster movie10 = new Poster(10, "Movie #10");
    Poster movie11 = new Poster(11, "Movie #11");

    @BeforeEach
    public void setup() {
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);
        manager.add(movie8);
        manager.add(movie9);
        manager.add(movie10);
        manager.add(movie11);
    }


    @Test
    public void shouldShow10LastMovies() {
        Poster[] movies = { movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10 };
        doReturn(movies).when(repo).findAll();
        Poster[] expected = { movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1 };
        Poster[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow5LastMovies() {
        Poster[] movies = { movie1, movie2, movie3, movie4, movie5 };
        doReturn(movies).when(repo).findAll();
        Poster[] expected = { movie5, movie4, movie3, movie2, movie1 };
        Poster[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow11Movies() {
        Poster[] movies = { movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11 };
        doReturn(movies).when(repo).findAll();
        Poster[] expected = { movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11 };
        Poster[] actual = manager.showAll();
        Assertions.assertArrayEquals(expected, actual);
    }






}
