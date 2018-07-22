package com.prac.analytics;

import static com.prac.analytics.PlayerUtils.display;
import static com.prac.analytics.PlayerUtils.loadPlayers;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.function.Predicate;

@Component
public class LoadData implements CommandLineRunner {

    public static final String RIGHT_HAND_BAT = "Right-hand bat";
    public static final String LEFT_HAND_BAT = "Left-hand bat";


    @Override
    public void run(String... args) throws Exception {
        List<Player> allPlayers = loadPlayers();

        List<Player> allLeftHandBatsmen = filterPlayers(allPlayers, LEFT_HAND_BAT, "England");
        display(allLeftHandBatsmen);
    }


    public List<Player> filterPlayers(List<Player> players, String batsmenType, String country) {

        return players.stream()
                .filter(player -> player.getBatsmenType().equalsIgnoreCase(batsmenType))
                .filter(player -> filterEmptyData(country).or(filterByCountry(country,player)).test(player))
                .collect(toList());

    }

    public static Predicate<Player> filterByCountry(String country, Player player) {
        return p -> player.getCountryName().equalsIgnoreCase(country);
    }

    public static Predicate<Player> filterEmptyData(String data) {
        return p -> StringUtils.isEmpty(data) ? true : false;
    }


//    public List<String> filterPlayers(List<String> players, String filter) {
//
//        List<String> temp = new ArrayList<>();
//
//
//        players.stream().forEach(player -> {
//
//            String column = player.split(",")[4];
//            if (!StringUtils.isEmpty(column) && column.trim().equalsIgnoreCase(filter)) {
//                temp.add(player);
//            }
//        });
//
//        return temp;
//    }


//    public List<String> filterPlayers(List<String> players, String filter) {
//
//        List<String> temp = new ArrayList<>();
//        for (String player : players) {
//
//            String column = player.split(",")[4];
//            if (!StringUtils.isEmpty(column) && column.trim().equalsIgnoreCase(filter)) {
//                temp.add(player);
//            }
//        }
//        return temp;
//    }

}
