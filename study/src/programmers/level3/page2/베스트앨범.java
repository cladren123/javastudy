package programmers.level3.page2;

import java.util.*;

public class 베스트앨범 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(solution(genres, plays));
    }


    public static ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, ArrayList<music>> map2 = new HashMap<>();


        int n = genres.length;


        for(int i = 0; i < n; i++)
        {
            // 장르 별 총 음악재생 횟수 저장
            map1.put(genres[i], map1.getOrDefault(genres[i], 0) + plays[i]);

            // 장르 별 노래번호와 재생횟수 저장
            if(map2.containsKey(genres[i]))
                map2.get(genres[i]).add(new music(i, plays[i]));
                // 처음 저장하는 경우
            else
            {
                ArrayList<music> one = new ArrayList<>();
                one.add(new music(i, plays[i]));
                map2.put(genres[i], one);
            }

        }

        // 총 재생횟수를 기준으로 장르들을 내림차순 정렬
        ArrayList<String> genre = new ArrayList<>(map1.keySet());

        // o1, o2는 각각 어레이리스트의 타입인 String이다.
        Collections.sort(genre, (o1, o2) -> map1.get(o2) - map1.get(o1));

        // System.out.println(map1);
        // System.out.println(genre);


        for(int i = 0; i < genre.size(); i++)
        {
            ArrayList<music> one = map2.get(genre.get(i));

            // 장르당 재생수로 내림차순 정렬
            // o1, o2는 어리이리스트의 타입인 music이다.
            Collections.sort(one, new Comparator<music>(){

                @Override
                public int compare(music o1, music o2)
                {
                    int result = o2.play - o1.play;

                    if(result == 0)
                    {
                        return o1.index - o2.index;
                    }

                    return result;
                }

            });

            answer.add(one.get(0).index);
            if(one.size() != 1)
                answer.add(one.get(1).index);
        }

        return answer;
    }

    static class music
    {
        int index;
        int play;

        public music(int index, int play)
        {
            this.index = index;
            this.play = play;
        }
    }


}
