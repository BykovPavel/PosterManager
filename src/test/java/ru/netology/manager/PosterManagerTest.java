package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    PosterManager manager = new PosterManager();


    @Test
    public void shouldShow0Movies() {
        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow1Movie() {
        manager.add("Movie #1");
        String[] expected = {"Movie #1"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow11Movies() {
        manager.add("Movie #1");
        manager.add("Movie #2");
        manager.add("Movie #3");
        manager.add("Movie #4");
        manager.add("Movie #5");
        manager.add("Movie #6");
        manager.add("Movie #7");
        manager.add("Movie #8");
        manager.add("Movie #9");
        manager.add("Movie #10");
        manager.add("Movie #11");
        String[] expected = {"Movie #1", "Movie #2", "Movie #3", "Movie #4", "Movie #5", "Movie #6", "Movie #7", "Movie #8", "Movie #9", "Movie #10", "Movie #11"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow0LastMovies() {
        String[] expected = {};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow1LastMovie() {
        manager.add("Movie #1");
        String[] expected = {"Movie #1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow10LastMovies() {
        manager.add("Movie #1");
        manager.add("Movie #2");
        manager.add("Movie #3");
        manager.add("Movie #4");
        manager.add("Movie #5");
        manager.add("Movie #6");
        manager.add("Movie #7");
        manager.add("Movie #8");
        manager.add("Movie #9");
        manager.add("Movie #10");
        String[] expected = {"Movie #10", "Movie #9", "Movie #8", "Movie #7", "Movie #6", "Movie #5", "Movie #4", "Movie #3", "Movie #2", "Movie #1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow5LastMovies() {
        PosterManager manager = new PosterManager(5);
        manager.add("Movie #1");
        manager.add("Movie #2");
        manager.add("Movie #3");
        manager.add("Movie #4");
        manager.add("Movie #5");
        manager.add("Movie #6");
        manager.add("Movie #7");
        manager.add("Movie #8");
        manager.add("Movie #9");
        manager.add("Movie #10");
        String[] expected = {"Movie #10", "Movie #9", "Movie #8", "Movie #7", "Movie #6"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
