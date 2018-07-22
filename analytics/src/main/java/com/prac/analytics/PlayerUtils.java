package com.prac.analytics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerUtils {

    public static List<Player> loadPlayers() throws IOException {

        return Files.lines(Paths.get("DIM_PLAYER.csv"), Charset.defaultCharset())
                .skip(1)
                .map(playerRow -> {
                    String arr[] = playerRow.split(",");
                    return new Player(Integer.parseInt(arr[1]), arr[2], arr[3], arr[4], arr[5], arr[6]);
                })
                .collect(Collectors.toList());
    }

    public static void display(List<Player> list) {
        list.stream().forEach(System.out::println);
    }
}
