package com.ttasjwi.PCRoom.bulkinsert;

import java.util.Random;
import java.util.stream.Collectors;

public class MyRandomNickName {

    private enum FirstWord {

        도토리, Hemdi, 베니, 도리, 도트, Nick, Jwu, S, dony, Oliver,
        Jamie, 아울, Muffin, Maeve, J, 도비, ver, 호이, 포키, 파크,
        bangtae, otter, 콜라, jinnie, 난정, Millie, 지미뉴트론, sonya, 럼카, JinJeon,
        JS, 이누, Janet, BB, Khan, 옐로우, Alan, 건, 이든,
        BC, 땃쥐, 산토리, BE_Jay, Hwi, Heyho, 부카, 케이, donggi, Lucid,
        Jerry, Tany, Phil, Miller, 쿠킴, 데이먼, BE_sally, Shine, Yan, 노리,
        Ader, 후, Nathan, 테리, Dave, MEenzino, 반스, 검봉, 선을로, zzangmin,
        벅픽, Sammy, Jun, 루이, Ikjo, Riako, 로니, Lee, 피오, Hanse, Forky,
        bibi, Ebony, MAse, 피그백, IOS_sally, 주방, Jed, dale, Kai, Sol, Beck,
        Eddy, Alex, Shingha, 푸코, Jason, 다마고치, Matthew, Rosa, Chez, OS, Jee,
        Josh, 앤드류, 스타크, Han, JungPar, 히데, Linus, stitch, Funny, AND_Jay, wooki;

        public static final FirstWord[] values = values();

        public static FirstWord of(int ordinal) {
            return values[ordinal];
        }
    }

    private static String makeFirstWord() {
        int randomIndex = (int)(Math.random()* FirstWord.values().length);
        return FirstWord.of(randomIndex).name();
    }

    private static String makeMiddleWord() {
        return new Random().ints('a','z')
                .limit(3)
                .mapToObj(i -> String.valueOf((char)i))
                .collect(Collectors.joining());
    }

    private static String makeLastNumber() {
        return new Random().ints('0','9')
                .limit(4)
                .mapToObj(i -> String.valueOf((char)i))
                .collect(Collectors.joining());
    }

    public static String generate() {
        return String.join("", makeFirstWord(), makeMiddleWord(), makeLastNumber());
    }

}
